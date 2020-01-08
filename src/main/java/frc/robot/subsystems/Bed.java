/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Servo;

/**
 * Add your docs here.
 */
public class Bed extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Servo
  servo1,
  servo2;

  public Bed() {
    servo1 = new Servo(RobotMap.servo1);
    servo2 = new Servo(RobotMap.servo2);
  }

  public void setUp() {
    servo1.set(RobotMap.upPos);
    servo2.set(RobotMap.upPos);
  }

  public void setDown() {
    servo1.set(RobotMap.downPos1);
    servo2.set(RobotMap.downPos2);
  }

  public double getPos() {
    return servo1.get();
  }

  public void reportStats() {
    SmartDashboard.putNumber("Servo 1 Position", servo1.get());
    SmartDashboard.putNumber("Servo 2 Position", servo2.get());
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
