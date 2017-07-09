package utils;

import main.TBA;
import models.other.APIStatus;
import models.other.events.EventOPR;
import models.simple.SMatch;
import models.simple.STeam;
import models.standard.Event;
import models.standard.Match;
import models.standard.Team;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utils.IO;

/**
 * Use for testing the API calls
 */
@SuppressWarnings("unused")
public class Test {

    public static void main(String[] args) {
        TBA.setAuthToken("FhVZJYGHSWut9lO6ArPP8GpAX7pljZ7PCvyDpg3pqVIkiEoXH9pN8YOvTHrPbk2c");
        TBA t = new TBA();
        String[] s = t.getMatchKeys("2016casd");
        System.out.println(s[0]);
    }

    public static void printTeam(Team team) {
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

    public static void printSTeam(STeam team) {
        System.out.println("Key: "+team.getName());
        System.out.println("Number: "+team.getTeamNumber());
        System.out.println("Nickname: "+team.getNickname());
        System.out.println("Name: "+team.getName());
        System.out.println("City: "+team.getCity());
        System.out.println("State/Province: "+team.getStateProv());
        System.out.println("Country: "+team.getCountry());
    }

    public static void printStatus(APIStatus status) {
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
