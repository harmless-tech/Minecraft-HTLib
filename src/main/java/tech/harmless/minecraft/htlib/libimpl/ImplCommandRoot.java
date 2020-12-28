package tech.harmless.minecraft.htlib.libimpl;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;
import tech.harmless.minecraft.htlib.command.HTCommand;

public class ImplCommandRoot implements HTCommand {
    @Override
    public String cmdName() {
        return "htlib";
    }

    @Override
    public void cmd(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal(cmdName())
                .executes(ctx -> {
                    ctx.getSource().sendError(new TranslatableText("command.htlib.htlib"));
                    return Command.SINGLE_SUCCESS;
                })
        );
    }
}
