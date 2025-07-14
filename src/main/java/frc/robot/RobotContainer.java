// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsytems.Collecter;
import frc.robot.subsytems.Indexer;
import frc.robot.subsytems.Pivot;
import frc.robot.subsytems.Shooter;

public class RobotContainer {
    private static final Collecter collecter = new Collecter();
    private static final Shooter shooter = new Shooter();
    private static final Indexer indexer = new Indexer();
    private static final Pivot pivot = new Pivot();

    private static final NoteTrain notetrain = new NoteTrain(collecter, shooter, indexer, pivot);


    private static final CommandXboxController driverctl = new CommandXboxController(0);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        collecter.setDefaultCommand(collecter.resistNote());

        driverctl.a().whileTrue(collecter.stop());
    }

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }
}
