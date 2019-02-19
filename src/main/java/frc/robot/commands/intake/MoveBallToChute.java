/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Timer;

public class MoveBallToChute extends Command {
  
  BallIntake intake;
  Rollers rollers;
  Timer t;
  double time;
  
  public MoveBallToChute(double time) {
    requires(BallIntake.getInstance());
    requires(Rollers.getInstance());
    intake = BallIntake.getInstance();
    rollers = Rollers.getInstance();
    this.time = time;
    t = new Timer();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    t.start();
    rollers.rollersIn(.5);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    rollers.rollersIn(.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return t.get() > this.time;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    rollers.rollersOff();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    rollers.rollersOff();
  }
}
