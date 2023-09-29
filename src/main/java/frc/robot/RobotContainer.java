// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.*;

import javax.sound.sampled.Port;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Drive;
import frc.robot.commands.Autos;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.ExampleCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
    private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
    private CommandXboxController driverController = new CommandXboxController(0);
    Drive robotDrive;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
      // Configure the trigger bindings
      robotDrive = new Drive(1);
      robotDrive.setDefaultCommand(new DefaultDrive(
        () -> driverController.getLeftY(),
        () -> driverController.getRightX(),
        robotDrive));
      configureBindings();
    }
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));
      
    driverController.povUp().whileTrue(new InstantCommand(() -> robotDrive.goUp()))
                            .whileFalse(new InstantCommand(() -> robotDrive.turnOff()));

    driverController.povDown().whileTrue(new InstantCommand(() -> robotDrive.goDown()))
                              .whileFalse(new InstantCommand(() -> robotDrive.turnOff()));

    driverController.povRight().whileTrue(
      new InstantCommand(
        () -> robotDrive.turnRight()
        )
      );

    driverController.povLeft().whileTrue(
      new InstantCommand(
        () -> robotDrive.turnLeft()
        )
      );
    driverController.rightTrigger().whileTrue(
      new InstantCommand(
        () -> robotDrive.incrementSpeed()
      )
    );
    driverController.leftTrigger().whileTrue(
      new InstantCommand(
        () -> robotDrive.decrementSpeed()
      )
    );


      
  }
  public Command getAutonomousCommand() {
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
