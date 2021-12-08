// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.TimedRobot;


public class Robot extends TimedRobot {

  private static final int TalonSRX_ID = 30;
  private static final int Can_Spark_ID = 40;
  private static final int FalconID = 50;
  private TalonFX TheOtherOne;
  private CANSparkMax Spike_Motor;
  private TalonSRX grey_motor;
  
  @Override
  public void robotInit() {
    Spike_Motor = new CANSparkMax(Can_Spark_ID, MotorType.kBrushless);
    TheOtherOne = new TalonFX(FalconID);
    grey_motor = new TalonSRX(TalonSRX_ID);
     // Set talon parameters to default values
      TheOtherOne.configFactoryDefault();


    TheOtherOne.setSensorPhase(true);  // correct encoder to motor direction
     
    // Tell the talon that he has a quad encoder
   // TheOtherOne.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 30);
   
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
    Spike_Motor.set(.1);
    TheOtherOne.set(ControlMode.PercentOutput, .5);
    grey_motor.set(ControlMode.PercentOutput, .1);
  }

  @Override
  public void autonomousPeriodic() {
    SmartDashboard.putNumber("Faclcon Motor Value", TheOtherOne.getSelectedSensorPosition());
  }

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
