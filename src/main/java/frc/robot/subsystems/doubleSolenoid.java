// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class doubleSolenoid extends SubsystemBase {
  private final DoubleSolenoid intake1;
  private final DoubleSolenoid intake2;
  private TalonSRX intakeMotor;
  Boolean bool;

  /** Creates a new doubleSolenoid. */
  public doubleSolenoid() {
    intake1 = new DoubleSolenoid(1, PneumaticsModuleType.CTREPCM, 1, 3); 
    intake2 = new DoubleSolenoid(1, PneumaticsModuleType.CTREPCM, 0, 2); 
    
    intakeMotor = new TalonSRX(IntakeMotor.kMotorPort);

  
  }
  
  public void start(){
      intakeMotor.set(ControlMode.PercentOutput, IntakeMotor.kSpeed);
  }

  public void stop(){
      intakeMotor.set(ControlMode.PercentOutput, 0);
  }

  public void extend(){
    intake1.set(DoubleSolenoid.Value.kForward);
    intake2.set(DoubleSolenoid.Value.kForward);
  }

  public void retract(){
    intake1.set(DoubleSolenoid.Value.kReverse);
    intake2.set(DoubleSolenoid.Value.kReverse);
  }

  public void closeP(){
        intake1.set(DoubleSolenoid.Value.kOff);
        intake2.set(DoubleSolenoid.Value.kOff);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if(intake1.get() == Value.kForward) {bool = true;} 
    else if (intake1.get() == Value.kReverse) {bool = false;}
    SmartDashboard.putBoolean("Forward or Backward", bool);
  }
}
