package main;

import models.other.APIStatus;
import models.standard.Team;
import utils.Constants;
import utils.IO;
import utils.Parser;

/**
 * Created by Will Davies on 7/7/2017.
 */
public class Test {

    public static void main(String[] args) {
        Team team = new Parser().parseTeam(IO.doRequest("team/frc5", Constants.AUTH_TOKEN));
        System.out.println(team.toString()+"\n\n");
        printTeam(team);
    }

    private static void printTeam(Team team) {
        System.out.println("Key: "+team.getName());
        System.out.println("Number: "+team.getTeamNumber());
        System.out.println("Nickname: "+team.getNickname());
        System.out.println("Name: "+team.getName());
        System.out.println("City: "+team.getCity());
        System.out.println("State/Province: "+team.getStateProv());
        System.out.println("Country: "+team.getCountry());
        System.out.println("Address: "+team.getAddress());
        System.out.println("Postal code: "+team.getPostalCode());
        System.out.println("Gmaps place id : "+team.getGMAPSPlaceID());
        System.out.println("gmaps url: "+team.getGMAPURL());
        System.out.println("lat: "+team.getLatitude());
        System.out.println("lng: "+team.getLongitude());
        System.out.println("location name: "+team.getLocationName());
        System.out.println("website "+team.getWebsite());
        System.out.println("rookie year: "+team.getRookieYear());
        System.out.println("motto: "+team.getMotto());



    }

    private static void printStatus(APIStatus status) {
        System.out.println("Current season: "+status.getCurrentSeason());
        System.out.println("Max season: "+status.getMaxSeason());
        for(String s : status.getDownEvents()) {
            System.out.println("Down event: "+s);
        }
        System.out.println("IOS min app version: "+status.getIosMinAppVersion());
        System.out.println("IOS latest app version: "+status.getIosMinAppVersion());
        System.out.println("Android min app version: "+status.getAndroidMinAppVersion());
        System.out.println("Android latest app version: "+status.getAndroidLatestAppVersion());

    }

}
