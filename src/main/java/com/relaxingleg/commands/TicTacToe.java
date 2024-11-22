package com.relaxingleg.commands;

import com.relaxingleg.ICommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

public class TicTacToe implements ICommand {
    @Override
    public String getName() {
        return "tic-tac-toe";
    }

    @Override
    public String getDescription() {
        return "Play Tic Tac Toe!";
    }

    @Override
    public List<OptionData> getOptions() {
        return List.of();
    }

    @Override
    public DefaultMemberPermissions permission() {
        return DefaultMemberPermissions.ENABLED;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("Test").queue();
    }
}
