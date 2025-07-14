package frc.robot;

import java.lang.Thread.State;

import frc.robot.subsytems.Collecter;
import frc.robot.subsytems.Indexer;
import frc.robot.subsytems.Pivot;
import frc.robot.subsytems.Shooter;

public class NoteTrain {
    public enum States {
        resting,
        resistingNotes,
        collecting,
        loaded,
        shootingAmp,
        shootingSpeaker;
    }

    private final Collecter collecter;
    private final Shooter shooter;
    private final Indexer indexer;
    private final Pivot pivot;

    public State state;

    public NoteTrain(Collecter collecter, Shooter shooter, Indexer indexer, Pivot pivot) {
        this.collecter = collecter;
        this.shooter = shooter;
        this.indexer = indexer;
        this.pivot = pivot;
    }
}
