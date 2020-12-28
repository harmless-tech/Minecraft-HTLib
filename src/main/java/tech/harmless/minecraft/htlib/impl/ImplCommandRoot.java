package tech.harmless.minecraft.htlib.impl;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;
import org.jetbrains.annotations.NotNull;
import tech.harmless.minecraft.htlib.command.HTCommand;

public class ImplCommandRoot implements HTCommand {
    @Override
    public String cmdName() {
        return "htlib";
    }

    @Override
    public void cmd(@NotNull CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal(cmdName())
                .executes(ctx -> {
                    ctx.getSource().sendError(new TranslatableText("command.htlib.htlib"));
                    return Command.SINGLE_SUCCESS;
                })
        );
    }
}
