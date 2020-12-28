package tech.harmless.minecraft.htlib;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
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
import tech.harmless.minecraft.htlib.item.HTItem;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

//TODO Javadocs.
public class HTLib implements ModInitializer {

    public static final String NAME = "HTLib";
    public static final String ID = "htlib";
    public static final String VERSION = "0.0.1";

    public static final Logger LOG = LogManager.getLogger();

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(ID, "overflow"),
            () -> new ItemStack(Blocks.SPRUCE_SAPLING)); //TODO Items. ?

    private static final HashSet<String> htMods = new HashSet<>();
    private static final HashMap<String, HTItem> htItems = new HashMap<>(); //TODO Way to make items inside final?
    //TODO Blocks.

    //TODO Use annotation HTMod.
    /*@NotNull
    public static HTLibHandle init(@NotNull String id, @NotNull String version) {
        if(htMods.contains(id))
            throw new RuntimeException("HTLib already registered this mod id: " + id + ".");

        htMods.add(id);
        return new HTLibHandle(modCounter++, id, version);
    }*/

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

                String modPackage = mod.topPackage();
                if(mod.topPackage().isEmpty()) {
                    modPackage = c.getPackage().getName();
                }
                LOG.warn(mod.name() + " uses package " + modPackage + "."); //TODO Remove!

                final String finalModPackage = modPackage;
                ClassFilter.FilterBuilder filter =
                        ClassFilter.any((klass) -> klass.getPackage().getName().startsWith(finalModPackage));

                // Items
                //TODO Get ItemGroups
                registerItems(filter, mod.id());

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

    private void registerItems(ClassFilter.FilterBuilder filter, String modId) {
        Iterable<Class<? extends HTItem>> itemClasses = filter.from(ClassIndex.getSubclasses(HTItem.class));

        for(Class<? extends HTItem> itemClass : itemClasses) {
            if(!itemClass.isAnnotationPresent(NoRegister.class) && !itemClass.isInterface() && !itemClass.isEnum()) {
                try {
                    HTItem item = itemClass.getDeclaredConstructor().newInstance();

                    String registerName = modId + ":" + item.itemId;
                    LOG.info("Registering item: " + registerName);

                    if(!htItems.containsKey(registerName)) {
                        htItems.put(registerName, item);
                        Registry.register(Registry.ITEM, new Identifier(modId, item.itemId), item);
                    }
                    else
                        LOG.error(registerName + " is a duplicate item, and it will be ignored by HTLib.");
                }
                catch(InstantiationException | IllegalAccessException | InvocationTargetException |
                        NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void registerBlocks() {

    }
}
