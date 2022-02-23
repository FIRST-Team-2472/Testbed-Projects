// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.simulation.RelaySim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;





public class Robot extends TimedRobot {

  ShuffleboardTab main;
  NetworkTableEntry bruh, getTeamColor;
  NetworkTableInstance inst;
  Relay arduinoRed,arduinoGreen, arduinoYellow;


  
  @Override
  public void robotInit() 
  {
    arduinoRed = new Relay(0, Direction.kForward);
    arduinoGreen = new Relay(1, Direction.kForward);
    arduinoYellow = new Relay(2, Direction.kForward);

  }

  @Override
  public void robotPeriodic() {


  }

  @Override
  public void autonomousInit() {



    //create/find shuffleboard tab
    main = Shuffleboard.getTab("01");
    //declare a default instance of to access FMSInfo
    inst = NetworkTableInstance.getDefault();

    //string tells which entry to look at; boolean is just a DEFULT vaule
    bruh = main.add("3", false).getEntry();
    //how to access FMSInfo don't ask me how it works it just does
    getTeamColor = inst.getTable("FMSInfo").getEntry("IsRedAlliance");
    
    //need to provide a defult vaule if can't find find value
    //System.out.println(bruh.getBoolean(false));
    System.out.println(getTeamColor.getBoolean(false));

    if (getTeamColor.getBoolean(false)) arduinoRed.set(Value.kOff);
    else arduinoRed.set(Value.kOn);
    arduinoGreen.set(Value.kOn);
    arduinoYellow.set(Value.kOn);
  }

  @Override
  public void autonomousPeriodic() {
    if (getTeamColor.getBoolean(false)) arduinoRed.set(Value.kOff);
    else arduinoRed.set(Value.kOn);
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
