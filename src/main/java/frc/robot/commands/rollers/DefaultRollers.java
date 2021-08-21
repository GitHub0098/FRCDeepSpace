/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.rollers;

import frc.robot.OI;
import frc.robot.input.XboxController;
import frc.robot.input.XboxController.XboxAxis;
import frc.robot.subsystems.Rollers;

import java.lang.Math;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Gives the operator control of the rollers.
 * Currently bound to the right joystick on the Xbox Controller
 */
public class DefaultRollers extends CommandBase {
  double speed, speedLeft, speedRight;
  double dspeed;
  XboxAxis rightJoystickY = XboxAxis.kYRight;
  public DefaultRollers() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(Rollers.getInstance());
    //requires(BallIntake.getInstance());

  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    Rollers.getInstance().spinRollers(0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    //speed = OI.getInstance().getXbox().getAxis(XboxController.XboxAxis.kXLeft);
    speed = 0;
    //if(Math.abs(OI.getInstance().getXbox().getAxis(XboxController.XboxAxis.kXRight)) > .05) {
    speed = OI.getInstance().getXbox().getAxis(XboxController.XboxAxis.kXRight);
    
    speedLeft = OI.getInstance().getXbox().getAxis(XboxController.XboxAxis.kLeftTrigger);
    speedRight = OI.getInstance().getXbox().getAxis(XboxController.XboxAxis.kRightTrigger);

    double maxTrig = Math.max(speedLeft, speedRight);

    if(Math.abs(maxTrig) > Math.abs(speed)){
      if(maxTrig == speedLeft){
        Rollers.getInstance().spinRollers(maxTrig/3.5);
      }
      else if(maxTrig == speedRight){
        Rollers.getInstance().spinRollers(-maxTrig/4);
      }
    }
    else{
      if(speed > 0){
        Rollers.getInstance().rollersIn(speed);
      }
      else if(speed < 0){
        Rollers.getInstance().rollersIn(speed/2);
      }
      else{
        Rollers.getInstance().rollersIn(0);
      }
    }

    /*
    else if(Math.abs(OI.getInstance().getXboxClimb().getAxis(XboxController.XboxAxis.kXRight)) > .05) {
      speed = OI.getInstance().getXboxClimb().getAxis(XboxController.XboxAxis.kXRight);
    }
    */
    
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
  }

 
 
}
