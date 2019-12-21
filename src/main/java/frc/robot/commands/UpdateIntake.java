/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.Robot;

public class UpdateIntake extends Command {

  XboxController 
  controller1,
  controller2;

  boolean 
  POVRightDepressed1,
  POVRightDepressed2,

  POVLeftDepressed1,
  POVLeftDepressed2;

  public UpdateIntake() {
    requires(Robot.intake);
    controller1 = new XboxController(RobotMap.controller1);
    controller2 = new XboxController(RobotMap.controller2);
    POVRightDepressed1 = false;
    POVRightDepressed2 = false;

    POVLeftDepressed1 = false;
    POVLeftDepressed2 = false;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.intake.stopIntake();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (DriverStation.getInstance().isOperatorControl()) {
      double 
      backPower1 = controller1.getTriggerAxis(Hand.kLeft),
      backPower2 = controller2.getTriggerAxis(Hand.kLeft),
      forwardPower1 = controller1.getTriggerAxis(Hand.kRight),
      forwardPower2 = controller2.getTriggerAxis(Hand.kRight),
      backPowerActual,
      forwardPowerActual;

      if (backPower1 > backPower2) backPowerActual = backPower1;
      else backPowerActual = backPower2;

      if (forwardPower1 > forwardPower2) forwardPowerActual = forwardPower1;
      else forwardPowerActual = forwardPower2;

      double speed = (backPowerActual - forwardPowerActual) * RobotMap.kIntake;

      Robot.intake.runIntake(speed);

      //POV Button debounce, right on controller 1
      if (controller1.getPOV() == 90) {
        POVRightDepressed1 = true;
      }
      else {
        if(POVRightDepressed1 && RobotMap.kIntake < 1) {
          RobotMap.kIntake =+ 0.1;
        }
        POVRightDepressed1 = false;
      }

      //POV Button debounce, left on controller 1
      if (controller1.getPOV() == 270) {
        POVLeftDepressed1 = true;
      }
      else {
        if(POVLeftDepressed1 && RobotMap.kIntake > 0) {
          RobotMap.kIntake =- 0.1;
        }
        POVLeftDepressed1 = false;
      }

      //POV Button debounce, right on controller 2
      if (controller2.getPOV() == 90) {
        POVRightDepressed2 = true;
      }
      else {
        if(POVRightDepressed2 && RobotMap.kIntake < 1) {
          RobotMap.kIntake =+ 0.1;
        }
        POVRightDepressed2 = false;
      }

      //POV Button debounce, left on controller 2
      if (controller2.getPOV() == 270) {
        POVLeftDepressed2 = true;
      }
      else {
        if(POVLeftDepressed2 && RobotMap.kIntake > 0) {
          RobotMap.kIntake =- 0.1;
        }
        POVLeftDepressed2 = false;
      }

    }

    Robot.intake.reportStats();
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
