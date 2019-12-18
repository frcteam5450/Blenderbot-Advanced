/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * An example command.  You can replace me with your own command.
 */
public class TeleopDrive extends Command {

  XboxController controller1;

  public TeleopDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
    controller1 = new XboxController(RobotMap.controller1);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drivetrain.stop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (DriverStation.getInstance().isOperatorControl()) {
      double leftPower = controller1.getY(Hand.kLeft) * RobotMap.kCurrent;
      double rightPower = controller1.getY(Hand.kRight) * RobotMap.kCurrent;

      if (Math.abs(leftPower) < RobotMap.deadZone) leftPower = 0;
      if (Math.abs(rightPower) < RobotMap.deadZone) rightPower = 0;

      if (leftPower == 0 && rightPower == 0 && controller1.getPOV() == 0) {
        leftPower = RobotMap.kCreep;
        rightPower = RobotMap.kCreep;
      }

      Robot.drivetrain.drive(leftPower, rightPower);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //Should never return true, we always want this to run.
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
