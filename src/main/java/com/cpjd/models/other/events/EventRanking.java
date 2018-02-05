package com.cpjd.models.other.events;

import lombok.Data;
import com.cpjd.models.other.Ranking;
import com.cpjd.models.other.SortInfo;
import com.cpjd.models.other.WLTRecord;

import java.io.Serializable;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class EventRanking implements Serializable {

    /**
     * List of rankings at the event.
     */
    private Ranking[] rankings;
    private SortInfo[] sortOrderInfo;


}
