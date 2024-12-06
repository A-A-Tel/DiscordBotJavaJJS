package com.relaxingleg.commands;

import com.relaxingleg.ICommand;
import com.relaxingleg.leveling.LeveledUser;
import com.relaxingleg.leveling.LevelingMain;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

public class CheckLevel implements ICommand {
    @Override
    public String getName() {
        return "level";
    }

    @Override
    public String getDescription() {
        return "Returns the user's level";
    }

    @Override
    public List<OptionData> getOptions() {
        return List.of(new OptionData(OptionType.USER, "user", "Specify a user", false));
    }

    @Override
    public DefaultMemberPermissions permission() {
        return DefaultMemberPermissions.ENABLED;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {

        if (event.getOption("user") == null) {
            for (LeveledUser user : LevelingMain.leveledUsers) {
                if (user.getMemberId() == event.getUser().getIdLong()) {
                    event.getChannel().sendMessage("Your level is: " + user.getLevel()).queue();
                    return;
                }
            }
        } else {
            for (LeveledUser user : LevelingMain.leveledUsers) {
                if (user.getMemberId() == event.getOption("user").getAsUser().getIdLong()) {
                    event.getChannel().sendMessage(event.getOption("user") + "'s level is: " + user.getLevel()).queue();
                    return;
                }
            }
        }
    }
}
