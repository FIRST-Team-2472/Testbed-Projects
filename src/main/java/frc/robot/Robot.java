// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Robot extends TimedRobot {
  
  private  CANSparkMax intake;
  private XboxController xboxController = new XboxController(2);
  @Override
  public void robotInit()  
  {
    intake = new CANSparkMax(40, MotorType.kBrushless);
  }

  @Override
  public void robotPeriodic() {
    
    if(xboxController.getAButton())
      intake.set(1);
    else if(xboxController.getBButton())
      intake.set(-1);
    else intake.set(0);
  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
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
