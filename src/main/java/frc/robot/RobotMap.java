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

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  
  //Motor Ports
  public static int 
  motorLeft1 = 0,
  motorLeft2 = 1,
  motorRight1 = 2,
  motorRight2 = 3,
  motorIntake = 4;
  
  //Servos
  public static int
  servo1 = 0,
  servo2 = 1;

  //Controller(s)
  public static int
  controller1 = 0;

  //Motor Powers
  public static double
  kCurrent = 0.7, //Current Motor set speed, starts at 0.7
  kFast = 0.7, //Faster motor setting
  kSlow = 0.5, //Slower motor setting
  kCreep = 0.25, //Creep forward motor setting
  kIntake = 0.85; //Intake motor setting

  //Controller deadzone
  public static double
  deadZone = 0.05;
}
