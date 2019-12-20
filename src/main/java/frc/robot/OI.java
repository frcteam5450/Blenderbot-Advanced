/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  XboxController controller1 = new XboxController(RobotMap.controller1);
  Button A1 = new JoystickButton(controller1, 1);
  Button B1 = new JoystickButton(controller1, 2);
  Button X1 = new JoystickButton(controller1, 3);
  Button Y1 = new JoystickButton(controller1, 4);
  Button RB1 = new JoystickButton(controller1, 6);

  XboxController controller2 = new XboxController(RobotMap.controller2);
  Button A2 = new JoystickButton(controller2, 1);
  Button B2 = new JoystickButton(controller2, 2);
  Button X2 = new JoystickButton(controller2, 3);
  Button Y2 = new JoystickButton(controller2, 4);
  Button RB2 = new JoystickButton(controller2, 6);

  public OI() {
    Y1.whenPressed(new ToggleSpeed());
    RB1.whenPressed(new ToggleBed());

    Y2.whenPressed(new ToggleSpeed());
    RB2.whenPressed(new ToggleBed());
  }
}
