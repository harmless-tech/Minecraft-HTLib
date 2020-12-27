package tech.harmless.minecraft.htlib.lib;

import org.jetbrains.annotations.NotNull;

//TODO ItemGroup
// Replaced by just using HTItem and HTBlock.
@Deprecated
public class HTLibRegistry {

    private HTLibHandle handle;

    public HTLibRegistry(@NotNull HTLibHandle handle) {
        this.handle = handle;
    }

    public void registerItems(@NotNull String namespace) {
        //TODO
    }

    public void registerBlocks(@NotNull String namespace) {
        //TODO
    }
}
