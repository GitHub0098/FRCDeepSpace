/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.rollers;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Rollers;

/**
 * This command spins the rollers inwards.
 * Meant to be used on the ground when picking up a ball.
 */
public class RollersIn extends CommandBase {

  Rollers rollers;

  public RollersIn() {
    addRequirements(Rollers.getInstance());
    rollers = Rollers.getInstance();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    //setTimeout(3);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    rollers.rollersIn(-.35);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    //return isTimedOut();
    return false;
  } 

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    rollers.rollersIn(0);
  }
  
}
