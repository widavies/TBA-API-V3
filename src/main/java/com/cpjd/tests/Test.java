package com.cpjd.tests;

import com.cpjd.main.TBA;
import com.cpjd.models.other.EventRanking;
import com.cpjd.requests.EventRequest;
import com.cpjd.utils.IO;
import com.cpjd.utils.exceptions.DataNotFoundException;
import org.json.simple.JSONObject;

public class Test {
    public static void main(String[] args) {
        TBA.setAuthToken("xgqQi9cACRSUt4xanOto70jLPxhz4lR2Mf83e2iikyR2vhOmr1Kvg1rDBlAQcOJg");

        // Case 1
//        Match[] matches = new TBA().getMatches("2018txpa");
//        System.out.println(matches.length);
//
//        // Case 2
//        Team[] teams = new TBA().getEventTeams("2018txpa");
//        System.out.println(teams.length);
//
//        // Case 3
//        EventOPR[] oprs = new TBA().getOprs("2018txpa");
////
//        Event e = new TBA().getEvent("2018code");
//
//        Match[] colorado = new TBA().getMatches("2018code");
//        Match m = colorado[0]; // choose a match you're interested in
//        System.out.println("Match number: "+m.getMatchNumber());
//        System.out.println("Red team #1: "+m.getRed().getTeamKeys()[0]);
//        System.out.println("Blue team #3: "+m.getBlue().getTeamKeys()[2]);
        // You can take a look at:
        // https://github.com/wdavies973/TBA-API-V3/blob/master/src/main/java/com/cpjd/models/simple/SMatch.java
        // For a list of variables you can get.

        EventRanking[] rankings = new EventRequest().getEventRankings("2018code");
        System.out.println(rankings[0].getWins());
        System.out.println(rankings[0].getRank());
    }

}
