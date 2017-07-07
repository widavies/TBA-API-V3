package models.other;

/**
 * Created by Will Davies on 7/7/2017.
 */

import lombok.Data;

/**
 * List of year-specific values provided in the `sort_orders` array for each team.
 */
@Data
public class SortInfo {
    private String name;
    private long precision;
}
