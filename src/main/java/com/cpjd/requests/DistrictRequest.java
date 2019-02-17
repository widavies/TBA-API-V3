package com.cpjd.requests;

import com.cpjd.main.TBA;
import com.cpjd.models.districts.District;
import com.cpjd.models.events.SEvent;
import com.cpjd.models.teams.STeam;
import com.cpjd.models.events.Event;
import com.cpjd.models.teams.Team;
import org.json.simple.JSONArray;
import com.cpjd.utils.IO;
import com.cpjd.utils.Parser;
import com.cpjd.utils.Utils;
import com.cpjd.utils.exceptions.DataNotFoundException;

/**
 * In an attempt to keep this API organized, if you look at the blue alliance v3 documentation, all calls that start with /district/ or /districts/
 * will be accessed from this class.
 *
 * API calls not implemented yet:
 * /district/{district_key}/rankings
 *
 * @since 1.0.0
 * @author Will Davies
 */
public class DistrictRequest extends Parser {

    /**
     * Mirror of: /district/{district_key}/teams
     *
     * @param districtKey TBA District Key, eg 2016fim
     * @return Team[] including a Team object for every team in the specified district
     */
    public Team[] getDistrictTeams(String districtKey) {
        JSONArray teams = (JSONArray) IO.doRequest("district/"+districtKey+"/teams");
        if(teams == null) throw new DataNotFoundException("Couldn't find any teams in district with key: "+districtKey);
        Team[] toGet = new Team[teams.size()];
        for(int i = 0; i < teams.size(); i++) toGet[i] = parseTeam(teams.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /district/{district_key}/teams/simple
     *
     * @param districtKey TBA District Key, eg 2016fim
     * @return STeam[] including a STeam object for every team in the specified district (simple model)
     */
    public STeam[] getDistrictSTeams(String districtKey) {
        JSONArray teams = (JSONArray) IO.doRequest("district/"+districtKey+"/teams/simple");
        if(teams == null) throw new DataNotFoundException("Couldn't find any simple teams in district with key: "+districtKey);
        STeam[] toGet = new STeam[teams.size()];
        for(int i = 0; i < teams.size(); i++) toGet[i] = parseSTeam(teams.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /district/{district_key}/teams/keys
     *
     * Gets a list of Team objects that competed in events in the given district.
     * @param districtKey TBA District Key, eg 2016fim
     * @return String[] containing all the team keys in this district
     */
    public String[] getDistrictTeamKeys(String districtKey) {
        JSONArray keys = (JSONArray) IO.doRequest("district/"+districtKey+"/teams/keys");
        if(keys == null) throw new DataNotFoundException("Couldn't find any team keys in district with key: "+districtKey);
        return Utils.jsonArrayToStringArray(keys);
    }

    /**
     * Mirror of: /district/{district_key}/events
     *
     * @param districtKey TBA District Key, eg 2016fim
     * @return Event[] including an Event object for every event in the specified district
     */
    public Event[] getDistrictEvents(String districtKey) {
        JSONArray teams = (JSONArray) IO.doRequest("district/"+districtKey+"/events");
        if(teams == null) throw new DataNotFoundException("Couldn't find any events in district with key: "+districtKey);
        Event[] toGet = new Event[teams.size()];
        for(int i = 0; i < teams.size(); i++) toGet[i] = parseEvent(teams.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /district/{district_key}/events/simple
     *
     * @param districtKey TBA District Key, eg 2016fim
     * @return SEvent[] including an SEvent object for every event in the specified district (simple model)
     */
    public SEvent[] getDistrictSEvents(String districtKey) {
        JSONArray teams = (JSONArray) IO.doRequest("district/"+districtKey+"/events/simple");
        if(teams == null) throw new DataNotFoundException("Couldn't find any simple events in district with key: "+districtKey);
        SEvent[] toGet = new SEvent[teams.size()];
        for(int i = 0; i < teams.size(); i++) toGet[i] = parseSEvent(teams.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /district/{district_key}/events/keys
     *
     * Gets a list of Team objects that competed in events in the given district.
     * @param districtKey TBA District Key, eg 2016fim
     * @return String[] containing all the team keys in this district
     */
    public String[] getDistrictEventKeys(String districtKey) {
        JSONArray keys = (JSONArray) IO.doRequest("district/"+districtKey+"/events/keys");
        if(keys == null) throw new DataNotFoundException("Couldn't find any event keys in district with key: "+districtKey);
        return Utils.jsonArrayToStringArray(keys);
    }

    /**
     * Mirror of: /districts/{year}
     *
     * Gets a list of districts and their corresponding district key, for the given year.
     * @param year Competition Year (or Season). Must be 4 digits.
     * @return District[] containing a District for each active district in the specified year
     */
    public District[] getDistricts(int year) {
        JSONArray districts = (JSONArray) IO.doRequest("districts/"+year);
        if(districts == null) throw new DataNotFoundException("Couldn't find any districts in year: "+year);
        District[] toReturn = new District[districts.size()];
        for(int i = 0; i < districts.size(); i++) toReturn[i] = parseDistrict(districts.get(i));
        TBA.sort(toReturn);
        return toReturn;
    }

}
