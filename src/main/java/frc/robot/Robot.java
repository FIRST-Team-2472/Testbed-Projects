// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




public class Robot extends TimedRobot {

  private static final int FalconID = 50;
  private TalonFX TheOtherOne;
  int target = 10000;

  
  @Override
  public void robotInit() 
  {
    TheOtherOne = new TalonFX(FalconID);

    // Set talon parameters to default values
    TheOtherOne.configFactoryDefault();

    TheOtherOne.config_kF(0, 0.19, 30);
    TheOtherOne.config_kP(0, 0, 30);
    TheOtherOne.config_kI(0, 0, 30);
    TheOtherOne.config_kD(0, 0, 30);

    
    TheOtherOne.setSensorPhase(true);  // correct encoder to motor direction
          
    // Set minimum output (closed loop)  to 0 for now
    TheOtherOne.configNominalOutputForward(0, 30);
    TheOtherOne.configNominalOutputReverse(0, 30);
        
    // Set maximum forward and backward to full speed
    TheOtherOne.configPeakOutputForward(1, 30);
    TheOtherOne.configPeakOutputReverse(-1, 30);
    
    // Motion magic cruise (max speed) is 100 counts per 100 ms
    TheOtherOne.configMotionCruiseVelocity(500, 30);
    
    // Motion magic acceleration is 50 counts
    TheOtherOne.configMotionAcceleration(100, 30);
    
    // Zero the sensor once on robot boot up 
    TheOtherOne.setSelectedSensorPosition(0, 0, 30);
  }

  @Override
  public void robotPeriodic() {


  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    TheOtherOne.setSelectedSensorPosition(0);
  }

  @Override
  public void teleopPeriodic() {
    SmartDashboard.putNumber("Motor Target", target);
    SmartDashboard.putNumber("Motor Position", TheOtherOne.getSelectedSensorPosition());
    TheOtherOne.set(ControlMode.MotionMagic, target);
  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}


}
