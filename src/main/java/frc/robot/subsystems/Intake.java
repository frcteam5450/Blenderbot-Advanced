/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/**
 * Contributers:
 * Evan Garrison
 */

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.UpdateIntake;

/**
 * Subsystem for controller the intake motor
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX intakeMotor;

  public Intake() {
    intakeMotor = new WPI_TalonSRX(RobotMap.motorIntake);
  }

  public void runIntake(double speed) {
    intakeMotor.set(speed);
  }

  public void stopIntake() {
    intakeMotor.set(0);
  }

  public void reportStats() {
    double current = intakeMotor.getOutputCurrent();
    SmartDashboard.putNumber("Intake Motor (4)", current);

    if (current > RobotMap.motorWarningCurrent) {
      print("Motor is currently pulling > " + RobotMap.motorWarningCurrent + " Amps!");
    }
  }

  private void print(String str) {
    System.out.println("Intake: " + str);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new UpdateIntake());
  }
}
