package tech.harmless.minecraft.htlib.lib;

import org.jetbrains.annotations.NotNull;
import tech.harmless.minecraft.htlib.lib.block.HTBlock;
import tech.harmless.minecraft.htlib.lib.item.HTItem;

//TODO ItemGroup
public class HTLibRegistry {

    private HTLibHandle handle;

    public HTLibRegistry(@NotNull HTLibHandle handle) {
        this.handle = handle;
    }

    public void registerItem(@NotNull HTItem item) {

    }

    public void registerBlock(@NotNull HTBlock block) {

    }
}
