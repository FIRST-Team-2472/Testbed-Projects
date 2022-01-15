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
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.simulation.JoystickSim;


public class Robot extends TimedRobot {

  private static final int TalonSRX_ID = 30;
  private static final int Can_Spark_ID = 40;
  private static final int FalconID = 50;
  private static final int leverOne_ID = 4;
  private Joystick leverOne;
  private TalonFX TheOtherOne;
  private CANSparkMax Spike_Motor;
  private TalonSRX grey_motor;
  private UsbCamera camera1;
  private UsbCamera camera2;
  private UsbCamera camera3;
  private NetworkTableEntry cameraSelection;
  private VideoSink server;
  
  
  @Override
  public void robotInit() {
    Spike_Motor = new CANSparkMax(Can_Spark_ID, MotorType.kBrushless);
    TheOtherOne = new TalonFX(FalconID);
    grey_motor = new TalonSRX(TalonSRX_ID);
    leverOne = new Joystick(leverOne_ID);
    camera1 = CameraServer.getInstance().startAutomaticCapture(0);
    camera2 = CameraServer.getInstance().startAutomaticCapture(1);
    camera3 = CameraServer.getInstance().startAutomaticCapture(2);

    cameraSelection = NetworkTableInstance.getDefault().getTable("").getEntry("CameraSelection");
    
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
  public void teleopInit() {
    

  }

  @Override
  public void teleopPeriodic() {
    if (leverOne.getRawButtonPressed(2)) {
      System.out.println("Setting camera 3");
      Shuffleboard.selectTab("LimeLight");
  }else if (leverOne.getRawButtonPressed(1) && !(leverOne.getRawButton(2)))  {
      System.out.println("Setting camera 1");
      Shuffleboard.selectTab("Back");
  }else if (leverOne.getRawButtonReleased(1) && !(leverOne.getRawButton(2))) {
    System.out.println("Setting camera 2");
    Shuffleboard.selectTab("Front");
  }
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
