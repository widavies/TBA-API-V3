package com.cpjd.utils;

import com.cpjd.models.ScoreBreakdown;
import com.cpjd.models.other.*;
import com.cpjd.models.other.events.EventOPR;
import com.cpjd.models.other.events.Webcast;
import com.cpjd.models.other.matches.MatchAlliance;
import com.cpjd.models.other.teams.Robot;
import com.cpjd.models.simple.SEvent;
import com.cpjd.models.simple.SMatch;
import com.cpjd.models.simple.STeam;
import com.cpjd.models.standard.Event;
import com.cpjd.models.standard.Match;
import com.cpjd.models.standard.Team;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;

/**
 * Converts the data received from the server into the models found in models/
 *
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

    protected Media parseMedia(Object object) {
        Media media = new Media();
        HashMap hash = (HashMap)object;
        media.setKey((String)hash.get("key"));
        media.setType((String)hash.get("type"));
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
        try {
            JSONObject obj = (JSONObject)hash.get("score_breakdown");
            ScoreBreakdown red = new ScoreBreakdown();
            red.setRed(true);
            red.setValues(new HashMap<String, Object>((JSONObject)obj.get("red")));
            m.setRedScoreBreakdown(red);
            ScoreBreakdown blue = new ScoreBreakdown();
            blue.setRed(false);
            blue.setValues(new HashMap<String, Object>((JSONObject)obj.get("blue")));
            m.setBlueScoreBreakdown(blue);
        } catch(Exception e) {}

       // m.setScoreBreakdown((String)hash.get("score_breakdown"));
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

    protected EventRanking parseEventRanking(Object object) {
        EventRanking ranking = new EventRanking();
        HashMap hash = (HashMap) object;
        ranking.setMatchesPlayed(Utils.cleanLong(hash.get("matches_played")));
        ranking.setQualAverage(Utils.cleanLong(hash.get("qual_average")));
        ranking.setRank(Utils.cleanLong(hash.get("rank")));
        ranking.setDq(Utils.cleanLong(hash.get("dq")));
        ranking.setTeamKey((String)hash.get("team_key"));
        ranking.setSortOrders(Utils.jsonArrayToDoubleArray((JSONArray)hash.get("sort_orders")));
        ranking.setExtraStats(Utils.jsonArrayToLongArray((JSONArray)hash.get("extra_stats")));
        ranking.setWins(Utils.cleanLong(((JSONObject) hash.get("record")).get("wins")));
        ranking.setTies(Utils.cleanLong(((JSONObject) hash.get("record")).get("ties")));
        ranking.setLosses(Utils.cleanLong(((JSONObject) hash.get("record")).get("losses")));
        return ranking;
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
