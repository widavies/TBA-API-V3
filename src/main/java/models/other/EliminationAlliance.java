package models.other;

import lombok.Data;

import java.io.Serializable;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class EliminationAlliance implements Serializable {
    private String name;
    private Backup[] backups;
    private String[] declines;
    private String[] picks;
    private Status status;

    @Data
    private class Backup {
        private String out;
        private String in;
    }

    @Data
    private class Status {
        private WLTRecord currentLevelRecord;
        private String level;
        private double playoffAverage;
        private WLTRecord record;
        private String status;
    }


}
