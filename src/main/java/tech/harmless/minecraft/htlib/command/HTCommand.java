package tech.harmless.minecraft.htlib.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import org.atteo.classindex.IndexSubclasses;

@IndexSubclasses
public interface HTCommand {
    String cmdName();

    void cmd(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated);
}
