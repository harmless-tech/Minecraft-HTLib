package tech.harmless.minecraft.htlib.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import org.atteo.classindex.IndexSubclasses;
import org.jetbrains.annotations.NotNull;
import tech.harmless.minecraft.htlib.HTRegistry;

@IndexSubclasses
//TODO Add more functionality.
//TODO Put BlockEntityProvider here?
public class HTBlock extends Block {

    public final String id;
    public final Item.Settings itemSettings;

    public HTBlock(@NotNull String id) {
        this(id, Material.SOIL);
    }

    public HTBlock(@NotNull String id, @NotNull Material material) {
        this(id, FabricBlockSettings.of(material));
    }

    public HTBlock(@NotNull String id, @NotNull Settings settings) {
        this(id, settings, defaultItemSettings());
    }

    public HTBlock(@NotNull String id, @NotNull ItemGroup itemGroup) {
        this(id, itemGroup, Material.SOIL);
    }

    public HTBlock(@NotNull String id, @NotNull ItemGroup itemGroup, @NotNull Material material) {
        this(id, itemGroup, FabricBlockSettings.of(material));
    }

    public HTBlock(@NotNull String id, @NotNull ItemGroup itemGroup, @NotNull Settings settings) {
        this(id, itemGroup, settings, defaultItemSettings());
    }

    public HTBlock(@NotNull String id, @NotNull Item.Settings itemSettings) {
        this(id, Material.SOIL, itemSettings);
    }

    public HTBlock(@NotNull String id, @NotNull Material material, @NotNull Item.Settings itemSettings) {
        this(id, FabricBlockSettings.of(material), itemSettings);
    }

    public HTBlock(@NotNull String id, @NotNull ItemGroup itemGroup, @NotNull Item.Settings itemSettings) {
        this(id, itemGroup, FabricBlockSettings.of(Material.SOIL), itemSettings);
    }

    public HTBlock(@NotNull String id, @NotNull ItemGroup itemGroup, @NotNull Material material,
                   @NotNull Item.Settings itemSettings) {
        this(id, itemGroup, FabricBlockSettings.of(material), itemSettings);
    }

    public HTBlock(@NotNull String id, @NotNull Settings settings, @NotNull Item.Settings itemSettings) {
        super(settings);

        this.id = id;
        this.itemSettings = itemSettings;
    }

    public HTBlock(@NotNull String id, @NotNull ItemGroup itemGroup, @NotNull Settings settings,
                   @NotNull Item.Settings itemSettings) {
        this(id, settings, itemSettings.group(itemGroup));
    }

    private static Item.Settings defaultItemSettings() {
        return new FabricItemSettings().group(HTRegistry.ITEM_GROUP);
    }
}
