package requests;

import models.other.APIStatus;
import utils.IO;
import utils.Parser;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@SuppressWarnings("unused")
public class OtherRequest extends Parser {

    /**
     * Returns API status, and TBA status information.
     * @return APIStatus representing the state of the TBA API interface
     */
    public APIStatus getStatus() {
        return parseStatus(IO.doRequest("status"));
    }

    /**
     * Makes a custom call to the URL
     * @param URL the URL suffix to make a call to, this API automatically fills in Constants.URL for you, so an example parameter here might be 'teams/{page_num}'
     * @return an Object (json formatted), representing the data received from the server
     */
    public Object customCall(String URL) {
        return IO.doRequest(URL);
    }

}