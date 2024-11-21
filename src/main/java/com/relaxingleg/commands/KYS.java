package com.relaxingleg.commands;

import com.relaxingleg.ICommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

public class KYS implements ICommand {
    @Override
    public String getName() {
        return "kys";
    }

    @Override
    public String getDescription() {
        return "kills the bot and restarts it (if the python script doesn't fail)";
    }

    @Override
    public List<OptionData> getOptions() {
        return List.of();
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("Main I'm dead").queue();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }
}
