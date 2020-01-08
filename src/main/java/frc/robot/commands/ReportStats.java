/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.OI;
import frc.robot.RobotMap;

public class ReportStats extends Command {
  public ReportStats() {
    //requires(Robot.intake);
    //requires(Robot.drivetrain);
    //requires(Robot.bed);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.bed.reportStats();
    Robot.drivetrain.reportStats();
    Robot.intake.reportStats();

    SmartDashboard.putNumber("Drivetrain Speed", RobotMap.kCurrent);
    SmartDashboard.putNumber("Intake Speed", RobotMap.kIntake);
    SmartDashboard.putNumber("POV", OI.controller1.getPOV());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
