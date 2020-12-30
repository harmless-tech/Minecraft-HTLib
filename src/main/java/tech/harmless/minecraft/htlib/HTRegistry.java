package tech.harmless.minecraft.htlib;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;
import tech.harmless.minecraft.htlib.block.HTBlock;
import tech.harmless.minecraft.htlib.item.HTItem;

import java.util.HashMap;
import java.util.HashSet;

//TODO Make protected?
//TODO Nothing in this class should be static!
public final class HTRegistry {

    // protected constructor

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(HTLib.ID, "overflow"),
            () -> new ItemStack(Blocks.SPRUCE_SAPLING)); //TODO Better picture?

    protected static final HashSet<String> MODS = new HashSet<>();
    protected static final HashMap<String, HTItem> ITEMS = new HashMap<>(); //TODO Way to make items inside final?
    protected static final HashMap<String, HTBlock> BLOCKS = new HashMap<>(); //TODO Way to make items inside final?
    protected static final HashSet<String> COMMANDS = new HashSet<>(); //TODO Way to make items inside final?
    //TODO Block Entities.

    /**
     * The {@code addItem()} method will register a {@code HTItem}. This method will only work when called during the
     * {@code onInitialize()} method.
     *
     * @param modId The mod id of the mod that is registering the item.
     * @param item  The {@code HTItem} that you want to register.
     */
    public static void addItem(@NotNull String modId, @NotNull HTItem item) { //TODO Less duplication?
        String registerName = modId + ":" + item.id;

        if(!ITEMS.containsKey(registerName)) {
            ITEMS.put(registerName, item);
            Registry.register(Registry.ITEM, new Identifier(modId, item.id), item);
        }
        else
            HTLib.LOG.error(registerName + " is a duplicate item, and it will be ignored by HTLib.");
    }

    /**
     * The {@code addBlock()} method will register a {@code HTBlock}. This method will only work when called during the
     * {@code onInitialize()} method.
     *
     * @param modId The mod id of the mod that is registering the item.
     * @param block The {@code HTBlock} that you want to register.
     */
    public static void addBlock(@NotNull String modId, @NotNull HTBlock block) { //TODO Less duplication?
        String registerName = modId + ":" + block.id;

        if(!BLOCKS.containsKey(registerName)) {
            BLOCKS.put(registerName, block);
            Identifier identifier = new Identifier(modId, block.id);

            Registry.register(Registry.BLOCK, identifier, block);
            Registry.register(Registry.ITEM, identifier, new BlockItem(block, block.itemSettings));
        }
        else
            HTLib.LOG.error(registerName + " is a duplicate block, and it will be ignored by HTLib.");
    }

    //TODO Commands and BlockEntities.
}
