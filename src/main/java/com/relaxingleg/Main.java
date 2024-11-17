package com.relaxingleg;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Main {

    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault(Token.token).build();
    }
}
