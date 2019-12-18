/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/**
 * Contributors:
 * Evan Garrison
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 * The Drivetrain subsystem, used for driving the robot and referencing the gyroscope
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Motor Controller Declarations
  WPI_TalonSRX 
  leftMotor1,
  leftMotor2,
  rightMotor1,
  rightMotor2;

  //Gryo Declaration
  ADXRS450_Gyro gyro;

  //Drivetrain Class Constructor
  public Drivetrain() {
    //Motor Controller Definitions
    leftMotor1 = new WPI_TalonSRX(RobotMap.motorLeft1);
    leftMotor2 = new WPI_TalonSRX(RobotMap.motorLeft2);
    rightMotor1 = new WPI_TalonSRX(RobotMap.motorRight1);
    rightMotor2 = new WPI_TalonSRX(RobotMap.motorRight2);

    //Gyro Definition
    gyro = new ADXRS450_Gyro();

    stop();
    resetGyro();
  }

  //Method for controlling drive motors
  public void drive(double leftPower, double rightPower) {
    leftPower = -leftPower;
    leftMotor1.set(leftPower);
    leftMotor2.set(leftPower);
    rightMotor1.set(rightPower);
    rightMotor2.set(rightPower);
  }

  //Method for stopping drive motors
  public void stop() {
    drive(0, 0);
  }

  //Method for reseting gyro
  public void resetGyro() {
    gyro.reset();
  }

  //Method for getting gyro angle
  public double getAngle() {
    return gyro.getAngle();
  }

  //Method for getting rate of rotation of gyro
  public double getRate() {
    return gyro.getRate();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new TeleopDrive());
  }
}
