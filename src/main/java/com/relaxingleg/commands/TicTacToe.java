package com.relaxingleg.commands;

import com.relaxingleg.ICommand;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import okhttp3.internal.ws.RealWebSocket;

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
        MessageChannel channel = event.getChannel();
        channel.sendMessage("""
                
                1️⃣2️⃣3️⃣
                4️⃣5️⃣6️⃣
                7️⃣8️⃣9️⃣""").queue();
        long messageId = channel.getLatestMessageIdLong();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        channel.editMessageById(messageId, "Ballala").queue();
    }
}
