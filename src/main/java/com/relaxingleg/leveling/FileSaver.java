package com.relaxingleg.leveling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileSaver {
    public void saveLevels() {
        LevelingMain main = new LevelingMain();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Type type = new TypeToken<ArrayList<LeveledUser>>() {}.getType();

        try (FileWriter writer = new FileWriter(main.fileName)) {
            gson.toJson(LevelingMain.leveledUsers, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}