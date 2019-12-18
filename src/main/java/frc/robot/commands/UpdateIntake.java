/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.Robot;

public class UpdateIntake extends Command {

  XboxController controller;

  public UpdateIntake() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.intake);
    controller = new XboxController(RobotMap.controller1);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.intake.stopIntake();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double backPower = controller.getTriggerAxis(Hand.kLeft);
    double forwardPower = controller.getTriggerAxis(Hand.kRight);

    double speed = (backPower - forwardPower) * RobotMap.kIntake;

    Robot.intake.runIntake(speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.intake.stopIntake();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
