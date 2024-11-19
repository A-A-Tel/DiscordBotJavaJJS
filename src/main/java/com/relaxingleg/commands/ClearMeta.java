package com.relaxingleg.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class ClearMeta extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        MessageChannel channel = event.getChannel();
        List<Message> messages = channel.getIterableHistory().complete();
        int count = 0;

        for (Message message : messages) {
            if (!(message.getContentRaw().isEmpty())) {
                if (message.getContentRaw().charAt(0) == '(' && message.getContentRaw().charAt(message.getContentRaw().length() - 1) == ')') {
                    message.delete().queue();
                    count++;
                }
            }
        }
        event.getChannel().sendMessage("Deleted amount: " + count).queue();
    }
}
