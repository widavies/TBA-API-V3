package com.cpjd.requests;

import com.cpjd.models.APIStatus;
import com.cpjd.utils.IO;
import com.cpjd.utils.Parser;
import com.cpjd.utils.exceptions.DataNotFoundException;

/**
 * @since 1.0.0
 * @author Will Davies
 */
public class OtherRequest extends Parser {

    /**
     * Returns API status, and TBA status information.
     * @return APIStatus representing the state of the TBA API interface
     */
    public APIStatus getStatus() {
        APIStatus status = parseStatus(IO.doRequest("status"));
        if (status == null) throw new DataNotFoundException("Unable to fetch API status.");
        return status;
    }

    /**
     * Makes a custom call to the URL
     * @param URL the URL suffix to make a call to, this API automatically fills in Constants.URL for you, so an example parameter here might be 'teams/{page_num}'
     * @return an Object (json formatted), representing the data received from the server
     */
    public Object customCall(String URL) {
        Object o = IO.doRequest(URL);
        if(o == null) throw new DataNotFoundException("No response for your custom URL call");
        return o;
    }

}