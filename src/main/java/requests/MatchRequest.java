package requests;

import models.simple.SMatch;
import models.standard.Match;
import utils.IO;
import utils.Parser;
import utils.exceptions.DataNotFoundException;

/**
 * In an attempt to keep this API organized, if you look at the blue alliance v3 documentation, all calls that start with /match/
 * will be accessed from this class.
 *
 * @since 1.0.0
 * @author Will Davies
 */
public class MatchRequest extends Parser {

    /**
     * Mirror of: /match/{match_key}
     *
     * Gets a Match object for the given match key.
     * @param matchKey TBA Match Key, eg 2016nytr_qm1
     * @return Match object represented by the match key
     */
    public Match getMatch(String matchKey) {
        Match m = parseMatch(IO.doRequest("match/"+matchKey));
        if(m == null) throw new DataNotFoundException("No match found with key: "+matchKey);
        return m;
    }

    /**
     * Mirror of: /match/{match_key}/simple
     *
     * Gets a Match object for the given match key.
     * @param matchKey TBA Match Key, eg 2016nytr_qm1
     * @return SMatch object represented by the match key (simple model)
     */
    public SMatch getSMatch(String matchKey) {
        SMatch m = parseSMatch(IO.doRequest("match/"+matchKey+"/simple"));
        if(m == null) throw new DataNotFoundException("No match found with key: "+matchKey);
        return m;
    }



}
