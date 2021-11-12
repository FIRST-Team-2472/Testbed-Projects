// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;


public class Robot extends TimedRobot {

  private static final int Can_Spark_ID = 40;
  private static final int FalconID = 50;
  private TalonFX TheOtherOne;
  private CANSparkMax The_One_Motor_To_Rule_Them_All;
  
  @Override
  public void robotInit() {
    The_One_Motor_To_Rule_Them_All = new CANSparkMax(Can_Spark_ID, MotorType.kBrushless);
    TheOtherOne = new TalonFX(FalconID);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    The_One_Motor_To_Rule_Them_All.set(.1);
    TheOtherOne.set(ControlMode.PercentOutput, .1);
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
