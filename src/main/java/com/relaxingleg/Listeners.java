package com.relaxingleg;

import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listeners extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {
//        Guild guild = Main.jda.getGuildById(1308043773405827155L);
//
//        assert guild != null;
//
//        guild.loadMembers();
//
//        guild.getTextChannelById(1309135463533121638L).sendMessage("Online").queue();

        for (Emoji emoji : EmojiManager.getAll()) {
            System.out.println(emoji.getAliases());
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        AutoRun run = new AutoRun();

        Guild guild = Main.jda.getGuildById(1308043773405827155L);
        MessageChannel channel = event.getChannel();
        Message message = event.getMessage();
        String messageRaw = message.getContentRaw();

        assert guild == null;


        // Clear the bot's messages after 10 secs
        if (message.getAuthor() == Main.jda.getUserById(1307829293451182211L)) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Run when a message is sent.
//        run.updateStats();
        run.bannedWordsCheck(message);
    }
}
