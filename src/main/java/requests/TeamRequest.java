package requests;

import models.other.teams.District;
import models.other.teams.Robot;
import models.simple.STeam;
import models.standard.Team;
import org.json.simple.JSONArray;
import utils.IO;
import utils.Parser;

import java.util.Arrays;

/**
 * TeamRequest manages all the API calls, in order, as listed on https://www.thebluealliance.com/apidocs/v3 under
 * the "teams" section.
 *
 * @since 1.0.0
 * @author Will Davies
 */
@SuppressWarnings("unused")
public class TeamRequest extends Parser {

    /**
     * Gets a list of Team objects, paginated in groups of 500.
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of Team objects (full team models)
     */
    public Team[] getTeams(int pageNum) {
        JSONArray teams = (JSONArray) IO.doRequest("teams/"+pageNum);
        Team[] toGet = new Team[teams.size()];
        for(int i = 0; i < toGet.length; i++) toGet[i] = parseTeam(teams.get(i));
        return toGet;
    }

    /**
     * Gets a list of STeam objects, paginated in groups of 500.
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of STeam objects (simple team models)
     */
    public STeam[] getSTeams(int pageNum) {
        JSONArray teams = (JSONArray) IO.doRequest("teams/"+pageNum+"/simple");
        STeam[] toGet = new STeam[teams.size()];
        for(int i = 0; i < toGet.length; i++) toGet[i] = parseSTeam(teams.get(i));
        return toGet;
    }

    /**
     * Gets a list of Team keys, paginated in groups of 500. (Note, each page will not have 500 teams, but will include the teams within that range of 500.)
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return String[] of team keys in the format 'frc254'
     */
    public String[] getTeamKeys(int pageNum) {
        JSONArray keys = (JSONArray) IO.doRequest("teams/"+pageNum+"/keys");
        return Arrays.asList(keys.toArray()).toArray(new String[keys.size()]);
    }

    /**
     * Gets a list of Team objects that competed in the given year, paginated in groups of 500.
     * @param year the year to get teams from
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of Team objects (full models)
     */
    public Team[] getTeams(int year, int pageNum) {
        JSONArray teams = (JSONArray) IO.doRequest("teams/"+year+"/"+pageNum);
        Team[] toGet = new Team[teams.size()];
        for(int i = 0; i < toGet.length; i++) toGet[i] = parseTeam(teams.get(i));
        return toGet;
    }

    /**
     * Gets a list of Team objects that competed in the given year, paginated in groups of 500.
     * @param year the year to get teams from
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of Team objects (simple models)
     */
    public STeam[] getSTeams(int year, int pageNum) {
        JSONArray teams = (JSONArray) IO.doRequest("teams/"+year+"/"+pageNum+"/simple");
        STeam[] toGet = new STeam[teams.size()];
        for(int i = 0; i < toGet.length; i++) toGet[i] = parseSTeam(teams.get(i));
        return toGet;
    }

    /**
     * Gets a list Team Keys that competed in the given year, paginated in groups of 500.
     * @param year the year to get teams from
     * @return String[] of team keys in format 'frc254'
     */
    public String[] getTeamKeys(int year, int pageNum) {
        JSONArray keys = (JSONArray) IO.doRequest("teams/"+year+"/"+pageNum+"/keys");
        return Arrays.asList(keys.toArray()).toArray(new String[keys.size()]);
    }

    /**
     * Gets the specified team (full team model)
     * @param number the team's frc number
     * @return Team object (full model)
     */
    public Team getTeam(int number) {
        return parseTeam(IO.doRequest("teams/frc"+number));
    }

    /**
     * Gets the specified team (simple team model)
     * @param number the team's frc number
     * @return STeam object (simple model)
     */
    public STeam getSTeam(int number) {
        return parseSTeam(IO.doRequest("teams/frc"+number+"/simple"));
    }

    /**
     * Returns an array containing the years that a particular team participated in FRC events
     * @param number the team's frc number
     * @return long[] containing years participated
     */
    public long[] getYearsParticipated(int number) {
        JSONArray keys = (JSONArray) IO.doRequest("teams/frc"+number+"/years_participated");
        String[] data = Arrays.asList(keys.toArray()).toArray(new String[keys.size()]);
        long[] years = new long[data.length];
        for(int i = 0; i < years.length; i++) {
            years[i] = Long.parseLong(data[i]);
        }
        return years;
    }

    /**
     * Gets the districts this team was in, empty array if none
     * @param number the team's frc number
     * @return District[] containing a District object for each district this team was in
     */
    public District[] getDistricts(int number) {
        return parseDistrictList(IO.doRequest("teams/frc"+number+"/districts"));
    }

    /**
     * Gets the robots that this team has had
     * @param number the team's frc number
     * @return Robot[] containing a Robot object for each robot this team has built
     */
    public Robot[] getRobots(int number) {
        return parseRobots(IO.doRequest("teams/frc"+number+"/robots"));
    }

}
