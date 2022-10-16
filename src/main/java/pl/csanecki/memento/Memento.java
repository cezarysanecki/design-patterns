package pl.csanecki.memento;

import java.time.Instant;

public interface Memento {

    String getName();

    Instant getSnapshotDate();

}
