// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




public class Robot extends TimedRobot {

  NetworkTable hi;

  
  @Override
  public void robotInit() 
  {
    
  }

  @Override
  public void robotPeriodic() {


  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
    boolean teamColor = SmartDashboard.getEntry("IsRedAlliance");
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
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}


}
