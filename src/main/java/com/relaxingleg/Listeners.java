package com.relaxingleg;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;

public class Listeners extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        Guild guild = event.getJDA().getGuildById("1275236533359874079");

        // Calculates the sum of 2 integers (command)
        guild.upsertCommand("sum-of", "Returns the sum of 2 integers.").addOptions(
                new OptionData(OptionType.INTEGER, "num1", "int0", true),
                new OptionData(OptionType.INTEGER, "num2", "int1", true)).queue();

        // Clears all meta messages in roleplay (command)
        guild.upsertCommand("clear-meta", "Clears all meta messages in the roleplay category").queue();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Guild guild = event.getJDA().getGuildById("1275236533359874079");
        MessageChannel channel = event.getChannel();
        Message message = event.getMessage();
        String messageRaw = message.getContentRaw();


        // Clear meta messages after 30 secs
        ArrayList<GuildChannel> roleplayChannels = new ArrayList<>(guild.getCategoryById("1287854251376381982").getChannels());

        if (roleplayChannels.contains(channel.getId()) && messageRaw.charAt(0) == '(' && messageRaw.charAt(messageRaw.length() - 1) == ')') {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            message.delete().queue();
        }
    }
}
