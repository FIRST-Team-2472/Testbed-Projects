// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;





public class Robot extends TimedRobot {

  ShuffleboardTab main;
  NetworkTableEntry teamColor, FMSInfo;
  NetworkTableInstance inst;

  
  @Override
  public void robotInit() 
  {
    
  }

  @Override
  public void robotPeriodic() {


  }

  @Override
  public void autonomousInit() {
    main = Shuffleboard.getTab("01");
    inst = NetworkTableInstance.getDefault();

    //string tells which entry to look at; boolean is just a DEFULT vaule
    teamColor = main.add("3", false).getEntry();
    FMSInfo = inst.getTable("FMSInfo").getEntry("IsRedAlliance");
    //test = main.add("Test", true).getEntry();
    
  }

  @Override
  public void autonomousPeriodic() {
    //need to provide a defult vaule if can't find find value
    //System.out.println(teamColor.getBoolean(false));
    System.out.println(FMSInfo.getBoolean(false));
    //System.out.println(SmartDashboard.getBoolean("FMSInfo/IsRedAlliance", false));
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
