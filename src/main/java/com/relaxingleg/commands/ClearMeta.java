package com.relaxingleg.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ClearMeta extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("clear-meta")) return;
        event.reply("Proceeding...").queue();

        Guild guild = event.getGuild();
        ArrayList<MessageChannel> channels = new ArrayList<>(guild.getCategoryById("1287854251376381982").getTextChannels());


        event.getChannel().sendMessage("Clearing messages... This might take a while!").queue();
        for (MessageChannel channel : channels) {
            MessageHistory history = MessageHistory.getHistoryFromBeginning(channel).complete();
            List<Message> messages = history.getRetrievedHistory();
            ArrayList<String> metaMessagesIds = new ArrayList<>();
            for (Message message : messages) {
                String messageRaw = message.getContentRaw();
                try {
                    if (messageRaw.charAt(0) == '(' && messageRaw.charAt(messageRaw.length() - 1) == ')') {
                        metaMessagesIds.add(message.getId());
                    }
                } catch (StringIndexOutOfBoundsException _) {}
            }
            for (String id : metaMessagesIds) {
                ch/
            }
        }
        event.getChannel().sendMessage("Finished!").queue();
    }
}
