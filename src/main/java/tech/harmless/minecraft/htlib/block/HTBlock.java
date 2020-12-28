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
public class HTBlock extends Block {

    public final String blockId;
    public final Item.Settings itemSettings;

    public HTBlock(@NotNull String blockId) {
        super(FabricBlockSettings.of(Material.SOIL));

        this.blockId = blockId;
        this.itemSettings = defaultItemSettings();
    }

    public HTBlock(@NotNull String blockId, @NotNull Material material) {
        super(FabricBlockSettings.of(material));

        this.blockId = blockId;
        this.itemSettings = defaultItemSettings();
    }

    public HTBlock(@NotNull String blockId, @NotNull ItemGroup itemGroup) {
        super(FabricBlockSettings.of(Material.SOIL));

        this.blockId = blockId;
        this.itemSettings = defaultItemSettings();
    }

    public HTBlock(@NotNull String blockId, @NotNull ItemGroup itemGroup, @NotNull Material material) {
        super(FabricBlockSettings.of(material));

        this.blockId = blockId;
        this.itemSettings = defaultItemSettings();
    }

    public HTBlock(@NotNull String blockId, @NotNull Settings settings) {
        super(settings);

        this.blockId = blockId;
        this.itemSettings = defaultItemSettings();
    }

    public HTBlock(@NotNull String blockId, @NotNull ItemGroup itemGroup, @NotNull Settings settings) {
        super(settings);

        this.blockId = blockId;
        this.itemSettings = defaultItemSettings();
    }

    private Item.Settings defaultItemSettings() {
        return new FabricItemSettings().group(HTLib.ITEM_GROUP);
    }

    public HTBlock(@NotNull String blockId, @NotNull Item.Settings itemSettings) {
        super(FabricBlockSettings.of(Material.SOIL));

        this.blockId = blockId;
        this.itemSettings = itemSettings;
    }

    public HTBlock(@NotNull String blockId, @NotNull Material material, @NotNull Item.Settings itemSettings) {
        super(FabricBlockSettings.of(material));

        this.blockId = blockId;
        this.itemSettings = itemSettings;
    }

    public HTBlock(@NotNull String blockId, @NotNull ItemGroup itemGroup, @NotNull Item.Settings itemSettings) {
        super(FabricBlockSettings.of(Material.SOIL));

        this.blockId = blockId;
        this.itemSettings = itemSettings;
    }

    public HTBlock(@NotNull String blockId, @NotNull ItemGroup itemGroup, @NotNull Material material,
                   @NotNull Item.Settings itemSettings) {
        super(FabricBlockSettings.of(material));

        this.blockId = blockId;
        this.itemSettings = itemSettings;
    }

    public HTBlock(@NotNull String blockId, @NotNull Settings settings, @NotNull Item.Settings itemSettings) {
        super(settings);

        this.blockId = blockId;
        this.itemSettings = itemSettings;
    }

    public HTBlock(@NotNull String blockId, @NotNull ItemGroup itemGroup, @NotNull Settings settings,
                   @NotNull Item.Settings itemSettings) {
        super(settings);

        this.blockId = blockId;
        this.itemSettings = itemSettings;
    }
}
