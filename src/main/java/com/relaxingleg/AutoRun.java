package com.relaxingleg;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;

public class AutoRun {
    // These two should have the same length!
    public static long[] statChannelList = {1309143428939911258L, 1309143461391237262L, 1309211315629199481L};
    public static long[] statRolesList = {1309134466769485824L, 1309134643517460562L, 1309137530657964033L};

    public static void updateStats() {
        Guild guild = Main.jda.getGuildById(1308043773405827155L);
        assert guild != null;

        for (int i = 0; i < statChannelList.length; i++) {
            guild.getVoiceChannelById(statChannelList[i]).getManager()
                    .setName(guild.getRoleById(statRolesList[i]).getName() + ": " +
                            guild.getMembersWithRoles(guild.getRoleById(statRolesList[i])).size()).queue();
        }
    }

    //Banned words get deleted
    public static String[] bannedWords = {"nigger", "nigga", "negro", "kk", "kkr", "kank", "rape", "canc", "verkr"};


    public static boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }


    public static void bannedWordsCheck(Message message) {
        StringBuilder messageRaw = new StringBuilder();
        for (int i = 0; i < message.getContentRaw().length(); i++) {
            if (Character.isAlphabetic(message.getContentRaw().charAt(i))) {
                messageRaw.append(message.getContentRaw().charAt(i));
            } else if (Character.isDigit(message.getContentRaw().charAt(i))) {
                switch (message.getContentRaw().charAt(i)) {
                    case '1':
                        messageRaw.append('i');
                        break;
                    case '2':
                        messageRaw.append('z');
                        break;
                    case '3':
                        messageRaw.append('e');
                        break;
                    case '4':
                        messageRaw.append('a');
                        break;
                    case '5':
                        messageRaw.append('s');
                        break;
                    case '7':
                        messageRaw.append('l');
                        break;
                    case '8':
                        messageRaw.append('b');
                        break;
                    case '6', '9':
                        messageRaw.append('g');
                        break;
                    case '0':
                        messageRaw.append('o');
                        break;
                }
            }
        }
        for (int i = 0; i < messageRaw.length() - 1; i++) {
            if (!(isVowel(messageRaw.charAt(i)))) {

            }
        }

        for (String banned : bannedWords) {
            if (messageRaw.toString().toLowerCase().contains(banned)) {
                message.delete().queue();
                return;
            }
        }
    }
}
