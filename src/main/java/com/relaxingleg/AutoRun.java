package com.relaxingleg;

import net.dv8tion.jda.api.entities.Guild;

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
}
