/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.claw;

import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Gantry;
import edu.wpi.first.wpilibj.command.Command;
/**
 * This command triggers a pneumatic solenoid valve that pushes the claw assembly forward.
 */
public class PushClawForward extends Command {

  Claw claw;

  public PushClawForward() {
    requires(Claw.getInstance());
    claw = Claw.getInstance();
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
    claw.pushClawForward();
    Gantry.getInstance().setCommandFinished(true);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Gantry.getInstance().setCommandFinished(false);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
