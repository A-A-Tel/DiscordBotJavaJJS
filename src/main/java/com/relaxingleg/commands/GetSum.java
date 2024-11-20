package com.relaxingleg.commands;

import com.relaxingleg.ICommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class GetSum implements ICommand {

    @Override
    public String getName() {
        return "sum-of";
    }

    @Override
    public String getDescription() {
        return "Calculate integers";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> data = new ArrayList<>();
        data.add(new OptionData(OptionType.INTEGER, "number-1", "First Number", true));
        data.add(new OptionData(OptionType.INTEGER, "number-2", "Second Number", true));
        return data;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        int num1 = event.getOption("number-1").getAsInt();
        int num2 = event.getOption("number-2").getAsInt();

        event.reply("The sum is: " + (num1 + num2)).queue();
    }
}
