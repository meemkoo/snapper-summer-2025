package frc.robot.subsytems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.sim.SparkMaxSim;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Collecter extends SubsystemBase {
    public static final int motorID = 99;
    public static final DCMotor motorPhy = DCMotor.getNEO(1);
    public static final double speed = 1;
    public static final boolean inverted = true;

    public SparkBaseConfig motorConfig = new SparkMaxConfig()
        .inverted(true)
        .idleMode(IdleMode.kBrake);
    public SparkMax motor = new SparkMax(motorID, MotorType.kBrushless);
    public SparkMaxSim motorSim = new SparkMaxSim(motor, motorPhy);

    public Collecter() {
        motor.configure(motorConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    public Command resistNote() {
        return run(()->{
            motor.set(-1);
        });
    }

    public Command stop() {
        return run(()->motor.set(0));
    }
}
