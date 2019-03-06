/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.BallIntake;

public class Intake_Up_CargoBay extends Command {

  BallIntake intake;
  double pot_value;

  public Intake_Up_CargoBay() {
    requires(BallIntake.getInstance());
    intake = BallIntake.getInstance();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    intake.intakeDown(.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return intake.getVoltage() == pot_value;
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