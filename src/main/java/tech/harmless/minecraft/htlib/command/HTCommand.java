package tech.harmless.minecraft.htlib.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import org.atteo.classindex.IndexSubclasses;
import org.jetbrains.annotations.NotNull;

@IndexSubclasses
public interface HTCommand {
    String cmdName();

    void cmd(@NotNull CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated);
}
