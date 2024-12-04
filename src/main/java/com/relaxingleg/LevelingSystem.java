package com.relaxingleg;

import com.google.gson.GsonBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;

public class LevelingSystem {
    public ArrayList<User> leveledUsers;

    GsonBuilder builder = new GsonBuilder();

}

class LeveledPerson {
    private Member member;
    private int level;
    private long remainingMessages;
    public LeveledPerson(){}

    public Member getMember() {
        return member;
    }

    public int getLevel() {
        return level;
    }

    public long getRemainingMessages() {
        return remainingMessages;
    }

    public String toString() {
        return "LeveledPerson\r\n{\r\nMember: " + member.getEffectiveName() + "\r\nLevel: " + level + "\r\n}";
    }
}
