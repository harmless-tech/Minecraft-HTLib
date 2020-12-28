package tech.harmless.minecraft.htlib;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.atteo.classindex.ClassFilter;
import org.atteo.classindex.ClassIndex;
import tech.harmless.minecraft.htlib.annotations.HTMod;
import tech.harmless.minecraft.htlib.annotations.NoRegister;
import tech.harmless.minecraft.htlib.block.HTBlock;
import tech.harmless.minecraft.htlib.item.HTItem;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


/**
 * HTLib is a library mod for fabric that seeks to automate and improve the process of making fabric mods.
 */
//TODO Javadocs.
public class HTLib implements ModInitializer {

    public static final String NAME = "HTLib";
    public static final String ID = "htlib";
    public static final String VERSION = "0.0.1";

    public static final Logger LOG = LogManager.getLogger();

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(ID, "overflow"),
            () -> new ItemStack(Blocks.SPRUCE_SAPLING)); //TODO Better picture?

    private static final HashSet<String> htMods = new HashSet<>();
    private static final HashMap<String, HTItem> htItems = new HashMap<>(); //TODO Way to make items inside final?
    private static final HashMap<String, HTBlock> htBlocks = new HashMap<>(); //TODO Way to make items inside final?
    //TODO Block Entities.

    @Override
    public void onInitialize() {
        LOG.info("Initializing " + NAME + " " + VERSION + "...");

        Iterable<Class<?>> modClasses = ClassIndex.getAnnotated(HTMod.class);
        Iterator<Class<?>> mods = modClasses.iterator();

        int numMods = 0;
        while(mods.hasNext()) {
            numMods++;
            mods.next();
        }

        if(numMods == 0)
            LOG.error("Found no HTMods! This could mean that the mods are not being detected by fabric! " +
                    "(or you did not install any mods that use this library.)");
        else
            LOG.info("Found " + numMods + " HTMods.");

        for(Class<?> c : modClasses) {
            HTMod mod = c.getAnnotation(HTMod.class);

            if(!htMods.contains(mod.id())) {
                htMods.add(mod.id());
                LOG.info("Registered HTLib mod " + mod.name() + " with id " + mod.id() + ", version "
                        + mod.version() + ".");

                String modPackage = mod.rootPackage();
                if(mod.rootPackage().isEmpty()) {
                    modPackage = c.getPackage().getName();
                }
                LOG.warn(mod.name() + " uses package " + modPackage + "."); //TODO Remove!

                final String finalModPackage = modPackage;
                final Logger modLog = LogManager.getLogger(mod.name());
                final ClassFilter.FilterBuilder filter =
                        ClassFilter.any((klass) -> klass.getPackage().getName().startsWith(finalModPackage));

                // Items
                //TODO Get ItemGroups
                registerItems(modLog, filter, mod.id());

                // Blocks
                //TODO Get Blocks
            }
            else
                LOG.error(mod.id() + " is a duplicate HTMod! It will be ignored by HTLib.");
        }

        LOG.info("Done initializing " + NAME + ".");
    }

    private void registerItemGroups() {

    }

    private void registerItems(Logger log, ClassFilter.FilterBuilder filter, String modId) {
        Iterable<Class<? extends HTItem>> itemClasses = filter.from(ClassIndex.getSubclasses(HTItem.class));

        for(Class<? extends HTItem> itemClass : itemClasses) {
            if(!itemClass.isAnnotationPresent(NoRegister.class) && !itemClass.isInterface() && !itemClass.isEnum()) {
                try {
                    HTItem item = itemClass.getDeclaredConstructor().newInstance();

                    String registerName = modId + ":" + item.id;
                    log.info("Registering item: " + registerName);

                    if(!htItems.containsKey(registerName)) {
                        htItems.put(registerName, item);
                        Registry.register(Registry.ITEM, new Identifier(modId, item.id), item);
                    }
                    else
                        log.error(registerName + " is a duplicate item, and it will be ignored by HTLib.");
                }
                catch(InstantiationException | IllegalAccessException | InvocationTargetException |
                        NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void registerBlocks(Logger log, ClassFilter.FilterBuilder filter, String modId) {
        Iterable<Class<? extends HTBlock>> blockClasses = filter.from(ClassIndex.getSubclasses(HTBlock.class));

        for(Class<? extends HTBlock> blockClass : blockClasses) {
            if(!blockClass.isAnnotationPresent(NoRegister.class) && !blockClass.isInterface() && !blockClass.isEnum()) {
                try {
                    HTBlock block = blockClass.getDeclaredConstructor().newInstance();

                    String registerName = modId + ":" + block.id;
                    log.info("Registering block: " + registerName);

                    if(!htBlocks.containsKey(registerName)) {
                        htBlocks.put(registerName, block);
                        Identifier identifier = new Identifier(modId, block.id);

                        Registry.register(Registry.BLOCK, identifier, block);
                        Registry.register(Registry.ITEM, identifier, new BlockItem(block, block.itemSettings));
                    }
                    else
                        log.error(registerName + " is a duplicate block, and it will be ignored by HTLib.");
                }
                catch(InstantiationException | IllegalAccessException | InvocationTargetException |
                        NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
