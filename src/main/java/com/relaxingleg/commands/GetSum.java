package com.relaxingleg.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GetSum extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!(event.getName().equals("sum-of"))) return;
        int num1 = event.getOption("num1").getAsInt();
        int num2 = event.getOption("num2").getAsInt();
        event.reply("The sum is: " + (num1 + num2)).queue();
    }
}
