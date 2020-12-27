package tech.harmless.minecraft.htlib.lib.item;

import net.minecraft.item.Item;
import org.atteo.classindex.IndexSubclasses;
import org.jetbrains.annotations.NotNull;

@IndexSubclasses
//TODO Add more functionality.
public class HTItem extends Item {

    protected String itemName;

    public HTItem(@NotNull String itemName, Settings settings) {
        super(settings);

        this.itemName = itemName;
    }
}
