package tech.harmless.minecraft.htlib.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import org.atteo.classindex.IndexSubclasses;
import org.jetbrains.annotations.NotNull;
import tech.harmless.minecraft.htlib.HTLib;

@IndexSubclasses
//TODO Add more functionality.
//TODO Add a manuel way to trigger the registering. For the times where you just want a simple item.
public class HTItem extends Item {

    public final String id;

    public HTItem(@NotNull String id) {
        this(id, HTLib.ITEM_GROUP);
    }

    public HTItem(@NotNull String id, @NotNull ItemGroup itemGroup) {
        this(id, new FabricItemSettings().group(itemGroup));
    }

    public HTItem(@NotNull String id, @NotNull ItemGroup itemGroup, @NotNull Settings settings) {
        this(id, settings.group(itemGroup));
    }

    public HTItem(@NotNull String id, @NotNull Settings settings) {
        super(settings);

        this.id = id;
    }
}
