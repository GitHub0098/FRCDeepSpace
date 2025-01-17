/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.claw;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.*;
import frc.robot.commands.gantry.CenterGantry;
import frc.robot.subsystems.Gantry;
import frc.robot.subsystems.Vision;

public class DeployHatch extends CommandGroup {
  /**
   * Add your docs here.
   */

  public DeployHatch() {
    Vision.getInstance().finishedAligning = true;
    //addSequential(new OpenClaw());
    addSequential(new PushClawForward());
    addSequential(new Wait(0.25));
    addSequential(new OpenClaw());
    addSequential(new Wait(0.65));
    addSequential(new PullClawBack());
    //Vision.getInstance().setFinishedAligning(false);
    //addSequential(new CenterGantry());
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
