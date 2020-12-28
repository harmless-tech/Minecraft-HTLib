package tech.harmless.minecraft.htlib.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import org.atteo.classindex.IndexSubclasses;
import org.jetbrains.annotations.NotNull;
import tech.harmless.minecraft.htlib.HTLib;

@IndexSubclasses
//TODO Add more functionality.
public class HTItem extends Item {

    public String itemId;

    public HTItem(@NotNull String itemId) {
        super(new FabricItemSettings().group(HTLib.ITEM_GROUP));

        this.itemId = itemId;
    }

    public HTItem(@NotNull String itemId, @NotNull ItemGroup itemGroup) {
        super(new FabricItemSettings().group(itemGroup));

        this.itemId = itemId;
    }

    public HTItem(@NotNull String itemId, @NotNull Settings settings) {
        super(settings);

        this.itemId = itemId;
    }

    public HTItem(@NotNull String itemId, @NotNull ItemGroup itemGroup, @NotNull Settings settings) {
        super(settings.group(itemGroup));

        this.itemId = itemId;
    }
}
