package com.cpjd.tests;

import com.cpjd.main.TBA;
import com.cpjd.models.other.Ranking;
import com.cpjd.models.other.events.EventOPR;
import com.cpjd.models.other.events.EventRanking;
import com.cpjd.models.standard.Event;
import com.cpjd.models.standard.Match;
import com.cpjd.models.standard.Team;

public class Test {
    public static void main(String[] args) {
        TBA.setAuthToken("xgqQi9cACRSUt4xanOto70jLPxhz4lR2Mf83e2iikyR2vhOmr1Kvg1rDBlAQcOJg");

        // Case 1
        Match[] matches = new TBA().getMatches("2018txpa");
        System.out.println(matches.length);

        // Case 2
        Team[] teams = new TBA().getEventTeams("2018txpa");
        System.out.println(teams.length);

        // Case 3
        EventOPR[] oprs = new TBA().getOprs("2018txpa");
    }

}
