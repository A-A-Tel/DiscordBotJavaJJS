package com.relaxingleg.leveling;

public class LeveledUser {
    private long memberId;
    private int level;
    private int messagesUntilLevelUp;

    public LeveledUser(long memberId, int level, int messagesUntilLevelUp) {
        this.memberId = memberId;
        this.level = level;
        this.messagesUntilLevelUp = messagesUntilLevelUp;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMessagesUntilLevelUp() {
        return messagesUntilLevelUp;
    }

    public void setMessagesUntilLevelUp(int messagesUntilLevelUp) {
        this.messagesUntilLevelUp = messagesUntilLevelUp;
    }
}

