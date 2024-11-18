package com.relaxingleg;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class Listeners extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        Guild guild = event.getJDA().getGuildById("1275236533359874079");
        guild.upsertCommand("sum-of", "Returns the sum of 2 integers.").addOptions(
                new OptionData(OptionType.INTEGER, "num1", "int0", true),
                new OptionData(OptionType.INTEGER, "num2", "int1", true)).queue();
    }
}
