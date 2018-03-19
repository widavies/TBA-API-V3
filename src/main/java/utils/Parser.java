package utils;

import models.other.*;
import models.other.events.EventOPR;
import models.other.events.Webcast;
import models.other.matches.MatchAlliance;
import models.other.teams.Robot;
import models.other.teams.status.*;
import models.simple.SEvent;
import models.simple.SMatch;
import models.simple.STeam;
import models.standard.Event;
import models.standard.Match;
import models.standard.Team;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;

/**
 * Converts the data received from the server into the models found in models/
 *
 * @since 1.0.0
 * @author Will Davies
 */
public class Parser {

    protected APIStatus parseStatus(Object object) {
        APIStatus status = new APIStatus();
        HashMap hash = (HashMap) object;
        status.setCurrentSeason((long)hash.get("current_season"));
        status.setMaxSeason((long)hash.get("max_season"));
        status.setDatafeedDown((boolean)hash.get("is_datafeed_down"));
        JSONArray downEvents = (JSONArray)hash.get("down_events");
        status.setDownEvents(Utils.jsonArrayToStringArray(downEvents));
        status.setAndroidMinAppVersion((long) ((JSONObject) hash.get("android")).get("min_app_version"));
        status.setAndroidLatestAppVersion((long) ((JSONObject) hash.get("android")).get("latest_app_version"));
        status.setIosMinAppVersion((long) ((JSONObject) hash.get("ios")).get("min_app_version"));
        status.setIosLatestAppVersion((long) ((JSONObject) hash.get("ios")).get("latest_app_version"));
        return status;
    }

    protected Team parseTeam(Object object) {
        Team team = new Team();
        HashMap hash = (HashMap) object;
        team.setKey((String)hash.get("key"));
        team.setTeamNumber((long)hash.get("team_number"));
        team.setNickname((String)hash.get("nickname"));
        team.setName((String)hash.get("name"));
        team.setCity((String)hash.get("city"));
        team.setStateProv((String)hash.get("state_prov"));
        team.setCountry((String)hash.get("country"));
        team.setAddress((String)hash.get("address"));
        team.setPostalCode((String)hash.get("postal_code"));
        team.setGMAPSPlaceID((String)hash.get("gmaps_place_id"));
        team.setGMAPURL((String)hash.get("gmaps_url"));
        team.setLatitude(Utils.cleanDouble(hash.get("lat")));
        team.setLongitude(Utils.cleanDouble(hash.get("lng")));
        team.setLocationName((String)hash.get("location_name"));
        team.setWebsite((String)hash.get("website"));
        team.setRookieYear(Utils.cleanLong(hash.get("rookie_year")));
        team.setMotto((String)hash.get("motto"));
        return team;
    }

    protected STeam parseSTeam(Object object) {
        STeam team = new STeam();
        HashMap hash = (HashMap) object;
        team.setKey((String)hash.get("key"));
        team.setTeamNumber((long)hash.get("team_number"));
        team.setNickname((String)hash.get("nickname"));
        team.setName((String)hash.get("name"));
        team.setCity((String)hash.get("city"));
        team.setStateProv((String)hash.get("state_prov"));
        team.setCountry((String)hash.get("country"));
        return team;
    }

    protected District parseDistrict(Object object) {
        HashMap hash = (HashMap) object;
        District d = new District();
        if(hash == null) return null;
        d.setAbbreviation((String)hash.get("abbreviation"));
        d.setDisplayName((String)hash.get("display_name"));
        d.setKey((String)hash.get("key"));
        d.setYear(Utils.cleanLong(hash.get("year")));
        return d;
    }

    protected Robot[] parseRobots(Object object) {
        JSONArray robotsList = (JSONArray) object;
        Robot[] robots = new Robot[robotsList.size()];
        for(int i = 0; i < robotsList.size(); i++) {
            Robot r = new Robot();
            JSONObject o = (JSONObject) robotsList.get(i);
            r.setYear(Utils.cleanLong(o.get("year")));
            r.setRobotName((String)o.get("robot_name"));
            r.setKey((String)o.get("key"));
            r.setTeamKey((String)o.get("team_key"));
            robots[i] = r;
        }
        return robots;
    }

    protected Event parseEvent(Object object) {
        Event e = new Event();
        HashMap hash = (HashMap) object;
        e.setKey((String)hash.get("key"));
        e.setName((String)hash.get("name"));
        e.setEventCode((String)hash.get("event_code"));
        e.setEventType(Utils.cleanLong(hash.get("event_type")));
        e.setCity((String)hash.get("city"));
        e.setStateProv((String)hash.get("state_prov"));
        e.setCountry((String)hash.get("country"));
        e.setStartDate((String)hash.get("start_date"));
        e.setEndDate((String)hash.get("end_Date"));
        e.setYear(Utils.cleanLong(hash.get("year")));
        e.setShortName((String)hash.get("short_name"));
        e.setEventTypeString((String)hash.get("event_type_string"));
        e.setWeek(Utils.cleanLong(hash.get("week")));
        e.setAddress((String)hash.get("address"));
        e.setPostalCode((String)hash.get("postal_code"));
        e.setGMAPSPlaceID((String)hash.get("gmaps_place_id"));
        e.setGMAPSURL((String)hash.get("gmaps_url"));
        e.setLongitude(Utils.cleanDouble(hash.get("lng")));
        e.setLatitude(Utils.cleanDouble(hash.get("lat")));
        e.setLocationName((String)hash.get("location_name"));
        e.setTimezone((String)hash.get("timezone"));
        e.setWebsite((String)hash.get("website"));
        e.setFirstEventID((String)hash.get("first_event_id"));
        e.setParentEventkey((String)hash.get("parent_event_key"));
        e.setPlayoffType(Utils.cleanLong(hash.get("playoff_type")));
        e.setPlayoffTypeString((String)hash.get("playoff_type_string"));
        e.setDistrict(parseDistrict(hash.get("district")));
        JSONArray keys = (JSONArray) hash.get("division_keys");
        e.setDivisonKeys(Utils.jsonArrayToStringArray(keys));
        JSONArray webcasts = (JSONArray) hash.get("webcasts");
        Webcast[] casts = new Webcast[webcasts.size()];
        for(int i = 0; i < webcasts.size(); i++) {
            Webcast w = new Webcast();
            JSONObject o = (JSONObject) webcasts.get(i);
            w.setChannel((String)o.get("channel"));
            w.setType((String)o.get("type"));
            w.setFile((String)o.get("file"));
            casts[i] = w;
        }
        e.setWebcasts(casts);
        return e;
    }

    protected SEvent parseSEvent(Object object) {
        SEvent e = new SEvent();
        HashMap hash = (HashMap) object;
        e.setKey((String)hash.get("key"));
        e.setName((String)hash.get("name"));
        e.setEventCode((String)hash.get("event_code"));
        e.setEventType(Utils.cleanLong(hash.get("event_type")));
        e.setStateProv((String)hash.get("state_prov"));
        e.setCountry((String)hash.get("country"));
        e.setStartDate((String)hash.get("start_date"));
        e.setEndDate((String)hash.get("end_Date"));
        e.setYear(Utils.cleanLong(hash.get("year")));
        e.setDistrict(parseDistrict(hash.get("district")));
        return e;
    }

    protected TeamEventStatus parseTeamEventStatus(Object object){
        TeamEventStatus t = new TeamEventStatus();
        HashMap hash = (HashMap) object;
        t.setQual(parseTeamEventStatusRank(hash.get("qual")));
        t.setAlliance(new TeamEventStatusAlliance());
        if(hash.get("alliance") != null){
            t.setAlliance(parseTeamEventStatusAlliance(hash.get("alliance")));
        }

        t.setPlayoff(parseTeamEventStatusPlayoff(hash.get("playoff")));
        t.setAllianceStatus((String)hash.get("alliance_status_str"));
        t.setPlayoffStatus((String)hash.get("playoff_status_str"));
        t.setOverallStatus((String)hash.get("overall_status_str"));
        return t;
    }

    protected TeamEventStatusRank parseTeamEventStatusRank(Object object){
        TeamEventStatusRank t = new TeamEventStatusRank();
        HashMap hash = (HashMap) object;
        t.setNumTeams(Utils.cleanLong(hash.get("num_teams")));
        t.setRanking(parseRanking(hash.get("ranking")));
        JSONArray sortOrderList = (JSONArray)hash.get("sort_order_info");
        SortInfo[] si = new SortInfo[sortOrderList.size()];
        for(int i = 0; i < sortOrderList.size(); i++) {
            si[i] = parseSortInfo(sortOrderList.get(i));
        }
        t.setSortOrderInfo(si);
        return t;
    }

    protected Ranking parseRanking(Object object){
        Ranking r = new Ranking();
        HashMap hash = (HashMap) object;
        r.setDq(Utils.cleanLong(hash.get("dq")));
        r.setMatchesPlayed(Utils.cleanLong(hash.get("matches_played")));
        r.setQualAverage(Utils.cleanDouble(hash.get("qual_average")));
        r.setRank(Utils.cleanLong(hash.get("rank")));
        r.setQualificationsRecord(parseWLTRecord(hash.get("record")));
        r.setOverallRecord(null);
        JSONArray sortOrders = (JSONArray)hash.get("sort_orders");
        r.setSortOrders(Utils.jsonArrayToDoublesArray(sortOrders));
        r.setTeamKey((String)hash.get("team_key"));
        return r;
    }

    protected WLTRecord parseWLTRecord(Object object){
        WLTRecord w = new WLTRecord();
        HashMap hash = (HashMap) object;
        w.setLosses(Utils.cleanLong(hash.get("losses")));
        w.setWins(Utils.cleanLong(hash.get("wins")));
        w.setTies(Utils.cleanLong(hash.get("ties")));
        return w;
    }

    protected SortInfo parseSortInfo(Object object){
        SortInfo s = new SortInfo();
        HashMap hash = (HashMap) object;
        s.setName((String)hash.get("name"));
        s.setPrecision(Utils.cleanLong(hash.get("precision")));
        return s;
    }

    protected TeamEventStatusAlliance parseTeamEventStatusAlliance(Object object){
        TeamEventStatusAlliance t = new TeamEventStatusAlliance();
        HashMap hash = (HashMap) object;
        t.setName((String)hash.get("name"));
        t.setNumber(Utils.cleanLong(hash.get("number")));
        t.setBackup(parseTeamEventStatusAllianceBackup(hash.get("backup")));
        t.setPick(Utils.cleanLong(hash.get("pick")));
        return t;
    }

    protected TeamEventStatusAllianceBackup parseTeamEventStatusAllianceBackup(Object object){
        TeamEventStatusAllianceBackup t = new TeamEventStatusAllianceBackup();
        HashMap hash = (HashMap) object;
        if(hash == null)return null;
        t.setOut((String)hash.get("out"));
        t.setIn((String)hash.get("in"));
        return t;
    }

    protected TeamEventStatusPlayoff parseTeamEventStatusPlayoff(Object object){
        TeamEventStatusPlayoff t = new TeamEventStatusPlayoff();
        HashMap hash = (HashMap) object;
        if(hash == null) return null;
        t.setLevel((String)hash.get("level"));
        t.setCurrentLevelRecord(parseWLTRecord(hash.get("current_level_record")));
        t.setRecord(parseWLTRecord(hash.get("record")));
        t.setStatus((String)hash.get("status"));
        t.setPlayoffAverage(Utils.cleanLong(hash.get("playoff_average")));
        return t;
    }

    protected Media parseMedia(Object object) {
        Media media = new Media();
        HashMap hash = (HashMap)object;
        media.setKey((String)hash.get("key"));
        media.setType(Utils.jsonArrayToStringArray((JSONArray)hash.get("type")));
        media.setForeignKey((String)hash.get("foreign_key"));
        media.setDetails((String)hash.get("details"));
        media.setPreferred(Utils.cleanBoolean(hash.get("preferred")));
        return media;
    }

    protected Match parseMatch(Object object) {
        Match m = new Match();
        HashMap hash = (HashMap) object;
        m.setKey((String)hash.get("key"));
        m.setCompLevel((String)hash.get("comp_level"));
        m.setSetNumber(Utils.cleanLong(hash.get("set_number")));
        m.setMatchNumber(Utils.cleanLong(hash.get("match_number")));
        m.setWinningAlliance((String)hash.get("winning_alliance"));
        m.setEventKey((String)hash.get("event_key"));
        m.setTime(Utils.cleanLong(hash.get("time")));
        m.setActualTime(Utils.cleanLong(hash.get("actual_time")));
        m.setPredictedTime(Utils.cleanLong(hash.get("predicted_time")));
        m.setPostResultTime(Utils.cleanLong(hash.get("post_result_time")));
        JSONObject allies = (JSONObject) hash.get("alliances");
        if(allies != null) {
            JSONObject blue = (JSONObject) allies.get("blue");
            JSONObject red = (JSONObject) allies.get("red");
            MatchAlliance redAlly = new MatchAlliance();
            MatchAlliance blueAlly = new MatchAlliance();
            redAlly.setScore(Utils.cleanLong(red.get("score")));
            blueAlly.setScore(Utils.cleanLong(blue.get("score")));
            JSONArray redTeamKeys = (JSONArray) red.get("team_keys");
            JSONArray blueTeamKeys = (JSONArray) blue.get("team_keys");
            redAlly.setTeamKeys(Utils.jsonArrayToStringArray(redTeamKeys));
            blueAlly.setTeamKeys(Utils.jsonArrayToStringArray(blueTeamKeys));
            JSONArray redSurrogateKeys = (JSONArray) red.get("surrogate_team_keys");
            JSONArray blueSurrogateKeys = (JSONArray) blue.get("surrogate_team_keys");
            redAlly.setSurrogateTeamKeys(Utils.jsonArrayToStringArray(redSurrogateKeys));
            blueAlly.setSurrogateTeamKeys(Utils.jsonArrayToStringArray(blueSurrogateKeys));
            m.setRed(redAlly);
            m.setBlue(blueAlly);
        }
        JSONArray videos = (JSONArray) hash.get("videos");
        Media[] medias = new Media[videos.size()];
        for(int i = 0; i < videos.size(); i++) medias[i] = parseMedia(videos.get(i));
        m.setVideos(medias);
        return m;
    }

    protected SMatch parseSMatch(Object object) {
        SMatch m = new SMatch();
        HashMap hash = (HashMap) object;
        m.setKey((String)hash.get("key"));
        m.setCompLevel((String)hash.get("comp_level"));
        m.setSetNumber(Utils.cleanLong(hash.get("set_number")));
        m.setMatchNumber(Utils.cleanLong(hash.get("match_number")));
        m.setWinningAlliance((String)hash.get("winning_alliance"));
        m.setEventKey((String)hash.get("event_key"));
        m.setTime(Utils.cleanLong(hash.get("time")));
        m.setActualTime(Utils.cleanLong(hash.get("actual_time")));
        m.setPredictedTime(Utils.cleanLong(hash.get("predicted_time")));
        JSONObject allies = (JSONObject) hash.get("alliances");
        if(allies != null) {
            JSONObject blue = (JSONObject) allies.get("blue");
            JSONObject red = (JSONObject) allies.get("red");
            MatchAlliance redAlly = new MatchAlliance();
            MatchAlliance blueAlly = new MatchAlliance();
            redAlly.setScore(Utils.cleanLong(red.get("score")));
            blueAlly.setScore(Utils.cleanLong(blue.get("score")));
            JSONArray redTeamKeys = (JSONArray) red.get("team_keys");
            JSONArray blueTeamKeys = (JSONArray) blue.get("team_keys");
            redAlly.setTeamKeys(Utils.jsonArrayToStringArray(redTeamKeys));
            blueAlly.setTeamKeys(Utils.jsonArrayToStringArray(blueTeamKeys));
            JSONArray redSurrogateKeys = (JSONArray) red.get("surrogate_team_keys");
            JSONArray blueSurrogateKeys = (JSONArray) blue.get("surrogate_team_keys");
            redAlly.setSurrogateTeamKeys(Utils.jsonArrayToStringArray(redSurrogateKeys));
            blueAlly.setSurrogateTeamKeys(Utils.jsonArrayToStringArray(blueSurrogateKeys));
            m.setRed(redAlly);
            m.setBlue(blueAlly);
        }
        return m;
    }

    protected Award parseAward(Object object) {
        Award a = new Award();
        HashMap hash = (HashMap)object;
        a.setName((String)hash.get("name"));
        a.setAwardType(Utils.cleanLong(hash.get("award_type")));
        a.setEventKey((String)hash.get("event_key"));
        a.setYear(Utils.cleanLong(hash.get("year")));
        JSONArray array = (JSONArray) hash.get("recipient_list");
        AwardRecipient[] recipientsList = new AwardRecipient[array.size()];
        for(int i = 0; i < array.size(); i++) {
            AwardRecipient ar = new AwardRecipient();
            JSONObject obj = (JSONObject) array.get(i);
            ar.setAwardee((String)obj.get("awardee"));
            ar.setTeamKey((String)obj.get("team_key"));
            recipientsList[i] = ar;
        }
        a.setRecipients(recipientsList);
        return a;
    }

    protected EventOPR[] parseOPRs(Object object) {
        HashMap hash = (HashMap) object;
        JSONObject oprs = (JSONObject) hash.get("oprs");
        JSONObject dprs = (JSONObject) hash.get("dprs");
        JSONObject ccwms = (JSONObject) hash.get("ccwms");
        EventOPR[] toReturn = new EventOPR[oprs.size()];
        for(int i = 0; i < oprs.keySet().size(); i++) {
            EventOPR opr = new EventOPR();
            opr.setOpr(Utils.cleanDouble(oprs.get(oprs.keySet().toArray()[i])));
            opr.setDpr(Utils.cleanDouble(dprs.get(dprs.keySet().toArray()[i])));
            opr.setCcwm(Utils.cleanDouble(ccwms.get(ccwms.keySet().toArray()[i])));
            opr.setTeamKey((String)oprs.keySet().toArray()[i]);
            toReturn[i] = opr;
        }

        return toReturn;
    }
}
