/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Generic toggle command to switch between two command with a button press or 
 * any other trigger.
 */
public class ToggleCommand extends Command {
  Command commandA;
  Command commandB;

  boolean state = true;

  public ToggleCommand(Command a, Command b) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    commandA = a;
    commandB = b;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(state){
      commandB.cancel();
      commandA.start();
    } else{
      commandA.cancel();
      commandB.start();
    }

    state = !state;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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
