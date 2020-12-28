package tech.harmless.minecraft.htlib.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import org.atteo.classindex.IndexSubclasses;
import org.jetbrains.annotations.NotNull;
import tech.harmless.minecraft.htlib.HTLib;

@IndexSubclasses
//TODO Add more functionality.
public class HTBlock extends Block {

    public final String blockId;
    public final Item.Settings itemSettings;

    public HTBlock(@NotNull String blockId) {
        this(blockId, Material.SOIL);
    }

    public HTBlock(@NotNull String blockId, @NotNull Material material) {
        this(blockId, FabricBlockSettings.of(material));
    }

    public HTBlock(@NotNull String blockId, @NotNull Settings settings) {
        this(blockId, settings, defaultItemSettings());
    }

    public HTBlock(@NotNull String blockId, @NotNull ItemGroup itemGroup) {
        this(blockId, itemGroup, Material.SOIL);
    }

    public HTBlock(@NotNull String blockId, @NotNull ItemGroup itemGroup, @NotNull Material material) {
        this(blockId, itemGroup, FabricBlockSettings.of(material));
    }

    public HTBlock(@NotNull String blockId, @NotNull ItemGroup itemGroup, @NotNull Settings settings) {
        this(blockId, itemGroup, settings, defaultItemSettings());
    }

    public HTBlock(@NotNull String blockId, @NotNull Item.Settings itemSettings) {
        this(blockId, Material.SOIL, itemSettings);
    }

    public HTBlock(@NotNull String blockId, @NotNull Material material, @NotNull Item.Settings itemSettings) {
        this(blockId, FabricBlockSettings.of(material), itemSettings);
    }

    public HTBlock(@NotNull String blockId, @NotNull ItemGroup itemGroup, @NotNull Item.Settings itemSettings) {
        this(blockId, itemGroup, FabricBlockSettings.of(Material.SOIL), itemSettings);
    }

    public HTBlock(@NotNull String blockId, @NotNull ItemGroup itemGroup, @NotNull Material material,
                   @NotNull Item.Settings itemSettings) {
        this(blockId, itemGroup, FabricBlockSettings.of(material), itemSettings);
    }
    
    public HTBlock(@NotNull String blockId, @NotNull Settings settings, @NotNull Item.Settings itemSettings) {
        super(settings);

        this.blockId = blockId;
        this.itemSettings = itemSettings;
    }

    public HTBlock(@NotNull String blockId, @NotNull ItemGroup itemGroup, @NotNull Settings settings,
                   @NotNull Item.Settings itemSettings) {
        this(blockId, settings, itemSettings.group(itemGroup));
    }

    private static Item.Settings defaultItemSettings() {
        return new FabricItemSettings().group(HTLib.ITEM_GROUP);
    }
}
