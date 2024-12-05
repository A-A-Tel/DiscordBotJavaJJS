package com.relaxingleg.leveling;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class LevelingMain extends ListenerAdapter {

    public static ArrayList<LeveledUser> leveledUsers;

    public String fileName = "levels.json";

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        File leveledMembers = new File(fileName);

        if (leveledMembers.exists()) {
            Gson gson = new Gson();

            Type type = new TypeToken<ArrayList<LeveledUser>>() {}.getType();

            try (FileReader reader = new FileReader(fileName)) {
                leveledUsers = gson.fromJson(reader, type);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            leveledUsers = new ArrayList<>();
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        FileSaver saver = new FileSaver();


        long[] bots = {1313781740413779980L, 1307829293451182211L};

        for (long userId : bots) {
            if (event.getAuthor().getIdLong() == userId) {
                return;
            }
        }


        for (LeveledUser user : leveledUsers) {
            if (user.getMemberId() == event.getMember().getIdLong()) {
                user.setMessagesUntilLevelUp(user.getMessagesUntilLevelUp() - 1);

                if (user.getMessagesUntilLevelUp() <= 0) {
                    user.setLevel(user.getLevel() + 1);
                    user.setMessagesUntilLevelUp(100 + 100 * user.getLevel());
                    event.getChannel().sendMessage(event.getMember().getEffectiveName() + ", you just leveled up! You are now level " + user.getLevel()).queue();
                }
                saver.saveLevels();
                return;
            }
        }
        LeveledUser user = new LeveledUser(event.getMember().getIdLong(), 0, 99);
        leveledUsers.add(user);
        saver.saveLevels();
    }
}
