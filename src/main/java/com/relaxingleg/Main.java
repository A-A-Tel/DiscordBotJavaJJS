package com.relaxingleg;

import com.relaxingleg.commands.GetSum;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {

    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault(Token.token).enableIntents(GatewayIntent.MESSAGE_CONTENT).build(); // Token in ignored file, add your token here or do the same as me!
        jda.addEventListener(new Listeners());
        jda.addEventListener(new GetSum());
    }
}
