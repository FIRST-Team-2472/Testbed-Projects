// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.can.TalonFX;



import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.simulation.JoystickSim;

public class Robot extends TimedRobot {

  private static final int FalconID = 50;
  private static final int leverOne_ID = 4;
  private Joystick leverOne;
  private TalonFX TheOtherOne;

  @Override
  public void robotInit() {
    TheOtherOne = new TalonFX(FalconID);
    leverOne = new Joystick(leverOne_ID);
  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void autonomousInit() {
    TheOtherOne.set(ControlMode.PercentOutput, .5);
  }

  @Override
  public void autonomousPeriodic() {
    SmartDashboard.putNumber("Faclcon Motor Value", TheOtherOne.getSelectedSensorPosition());
  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }
}
