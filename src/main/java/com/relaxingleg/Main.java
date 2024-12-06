package com.relaxingleg;

import com.relaxingleg.commands.CheckLevel;
import com.relaxingleg.commands.GetSum;
import com.relaxingleg.commands.KYS;
import com.relaxingleg.commands.TicTacToe;
import com.relaxingleg.leveling.LevelingMain;
import com.sedmelluq.discord.lavaplayer.jdaudp.NativeAudioSendFactory;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class Main {

    public static JDA jda = JDABuilder.createDefault(Token.TOKEN) // Token in hidden/ignored file, add your token here or do the same as me!
            .setMemberCachePolicy(MemberCachePolicy.ALL)
            .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS).setAudioSendFactory(new NativeAudioSendFactory()).build();

    public static void main(String[] args) {
        Main.jda.addEventListener(new Listeners());
        Main.jda.addEventListener(new LevelingMain());
        CommandManager manager = new CommandManager();
        manager.add(new GetSum());
        manager.add(new TicTacToe());
        manager.add(new KYS());
        manager.add(new CheckLevel());
        jda.addEventListener(manager);
    }
}
