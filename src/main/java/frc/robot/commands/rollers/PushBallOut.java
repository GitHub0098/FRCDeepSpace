/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.rollers;

import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.Rollers;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command will run the rollers outwards in order to spit a ball out.
 */
public class PushBallOut extends Command {

  Rollers rollers;
  double time;

  public PushBallOut(double period) {
    requires(Rollers.getInstance());
    rollers = Rollers.getInstance();
    time = period;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setTimeout(time);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    rollers.spinOut(.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
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
