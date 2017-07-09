package models.other.events;

import lombok.Data;
import models.other.Ranking;
import models.other.SortInfo;
import models.other.WLTRecord;

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
