package com.relaxingleg;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;

public class AutoRun {
    // These two should have the same length!
    public long[] statChannelList = {1309143428939911258L, 1309143461391237262L, 1309211315629199481L};
    public long[] statRolesList = {1309134466769485824L, 1309134643517460562L, 1309137530657964033L};

    public void updateStats() {
        Guild guild = Main.jda.getGuildById(1308043773405827155L);
        assert guild != null;

        for (int i = 0; i < statChannelList.length; i++) {
            guild.getVoiceChannelById(statChannelList[i]).getManager()
                    .setName(guild.getRoleById(statRolesList[i]).getName() + ": " +
                            guild.getMembersWithRoles(guild.getRoleById(statRolesList[i])).size()).queue();
        }
    }

    //Banned words get deleted
    public static String[] bannedWords = {"nigger", "nigga", "niggs", "nigs", "negro", "kkr", "kank", "rape", "canc", "verkr", "negaw", "\uD835\uDDC7\uD835\uDDC2\uD835\uDDC0\uD835\uDDC0\uD835\uDDBE\uD835\uDDCB"};


    public static boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }


    public void bannedWordsCheck(Message message) {
        String rawContent = message.getContentRaw();

        if (message.getAuthor().getIdLong() == 441582230666739722L) {
            return;
        }

        boolean hasNonStandardFont = rawContent.chars().anyMatch(ch -> ch < 32 || ch > 126);
        if (hasNonStandardFont) {
            message.delete().queue();
            return;
        }

        StringBuilder normalizedMessage = new StringBuilder();
        for (char ch : rawContent.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                normalizedMessage.append(ch);
            } else if (Character.isDigit(ch)) {
                switch (ch) {
                    case '1' -> normalizedMessage.append('i');
                    case '2' -> normalizedMessage.append('z');
                    case '3' -> normalizedMessage.append('e');
                    case '4' -> normalizedMessage.append('a');
                    case '5' -> normalizedMessage.append('s');
                    case '7' -> normalizedMessage.append('l');
                    case '8' -> normalizedMessage.append('b');
                    case '6', '9' -> normalizedMessage.append('g');
                    case '0' -> normalizedMessage.append('o');
                }
            }
        }

        for (String banned : bannedWords) {
            if (normalizedMessage.toString().toLowerCase().contains(banned)) {
                message.delete().queue();
                return;
            }
        }
    }
}

