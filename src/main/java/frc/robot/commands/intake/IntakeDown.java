/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import frc.robot.OI;
import frc.robot.input.XboxController;
import frc.robot.subsystems.BallIntake;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeDown extends Command {
  
  BallIntake intake;
  final int THREE_SECONDS = 3;
  private double speed;

  public IntakeDown() {
    requires(BallIntake.getInstance());
    intake = BallIntake.getInstance();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setTimeout(120);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    speed = OI.getInstance().getXbox().getAxis(XboxController.XboxAxis.kYLeft);
    intake.intakeDown(-speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    intake.intakeUp(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
