package tech.harmless.minecraft.htlib;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import tech.harmless.minecraft.htlib.lib.HTLibHandle;

import java.util.Collection;
import java.util.HashSet;

public class HTLib implements ModInitializer {

    public static final String NAME = "HTLib";
    public static final String ID = "htlib";
    public static final String VERSION = "0.0.1";

    public static final Logger LOG = LogManager.getLogger();

    private static int modCounter = 0;
    private static final HashSet<String> htMods = new HashSet<>();

    @NotNull
    public static HTLibHandle init(@NotNull String id, @NotNull String version) {
        if(htMods.contains(id))
            throw new RuntimeException("HTLib already registered this mod id. (" + id + ")");

        htMods.add(id);
        return new HTLibHandle(modCounter++, id, version);
    }

    @Override
    public void onInitialize() {
        LOG.info("Initializing HTLib...");
        //TODO

        Collection<ModContainer> mods = FabricLoader.getInstance().getAllMods();
        for(ModContainer mod : mods)
            LOG.info(mod.getMetadata());

        LOG.info("Done initializing HTLib.");
    }
}
