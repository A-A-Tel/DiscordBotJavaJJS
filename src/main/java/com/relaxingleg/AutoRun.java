package com.relaxingleg;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;

import java.util.*;

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
    public String[] bannedWords = {"nigger", "nigga", "niggs", "nigs", "negro", "kkr", "kank", "rape", "canc", "verkr", "negaw"};


    public boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }

    public List<Long> allowedPeople = Arrays.asList(441582230666739722L, 955175684093911071L, 510899779354492950L, 1313781740413779980L, 1307829293451182211L);

    public void bannedWordsCheck(Message message) {
        String rawContent = message.getContentRaw();

        // Skip check for allowed people
        if (allowedPeople.contains(message.getAuthor().getIdLong())) {
            return;
        }

        // Normalize message content, allowing emojis
        StringBuilder normalizedMessage = new StringBuilder();
        Map<Character, Character> leetSpeakMap = Map.of(
                '1', 'i', '2', 'z', '3', 'e', '4', 'a',
                '5', 's', '7', 'l', '8', 'b', '6', 'g',
                '9', 'g', '0', 'o'
        );

        // Unicode emoji ranges
        Set<Integer> emojiRanges = Set.of(
                0x1F600, 0x1F64F,  // Emoticons
                0x1F300, 0x1F5FF,  // Miscellaneous Symbols and Pictographs
                0x1F680, 0x1F6FF,  // Transport and Map Symbols
                0x1F900, 0x1F9FF,  // Supplemental Symbols and Pictographs
                0x2600, 0x26FF,    // Miscellaneous Symbols
                0x2700, 0x27BF     // Dingbats
        );

        for (char ch : rawContent.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                normalizedMessage.append(ch);
            } else if (Character.isDigit(ch)) {
                normalizedMessage.append(leetSpeakMap.getOrDefault(ch, ch));
            } else if (emojiRanges.contains(Character.codePointAt(new char[]{ch}, 0))) {
                normalizedMessage.append(ch);
            }
        }

        // Check for banned words
        for (String banned : bannedWords) {
            if (normalizedMessage.toString().toLowerCase().contains(banned)) {
                message.delete().queue();
                return;
            }
        }
    }
}

