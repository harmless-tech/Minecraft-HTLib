package tech.harmless.minecraft.htlib.lib.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import org.atteo.classindex.IndexSubclasses;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@IndexSubclasses
//TODO Add more functionality.
public class HTItem extends Item {

    protected String itemName;
    protected ItemGroup itemGroup;

    public HTItem(@NotNull String itemName, @Nullable ItemGroup itemGroup, Settings settings) {
        super(settings);

        this.itemName = itemName;
        this.itemGroup = itemGroup;
    }
}
