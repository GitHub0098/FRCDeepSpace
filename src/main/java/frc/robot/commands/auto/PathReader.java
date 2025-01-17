/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import java.io.File;
import java.io.IOException;

import edu.wpi.first.wpilibj.Notifier;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;
import jaci.pathfinder.PathfinderFRC;


public class PathReader extends Command {

  EncoderFollower leftFollower;
  EncoderFollower rightFollower;

  Drive chassis = Drive.getInstance();

  File leftCSV;
  File rightCSV;

  Trajectory rightTrajectory;
  Trajectory leftTrajectory;

  Notifier notifier;

  double dt;

  double p = 0.067;
  double i = 0.02;
  double d = .2;
  double v = 1 / 10.5;
  double a = 0;

  boolean forward;
  
  boolean ioerror = false;
  
  public PathReader(String FileName, boolean forward) {
    requires(Drive.getInstance());

    ioerror = false;

    try {
      leftTrajectory = PathfinderFRC.getTrajectory(FileName + ".left");
      rightTrajectory = PathfinderFRC.getTrajectory(FileName + ".right");
    } catch (IOException e) {
      System.out.println("Error reading pathweaver CSV file!");
      e.printStackTrace();
      ioerror = true;
    }
    
    // If an IO Error happened, then return early and do not use
    // left/right trajectory variables
    if (ioerror) {
      return;
    }

    notifier = new Notifier(new RunProfile());
    dt = leftTrajectory.get(0).dt;

    System.out.println("CSV has been locked and loaded");
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // If an IO Error happened in the constructor,
    // then do not initialize anything
    if (ioerror) {
      return;
    }
    leftFollower = new EncoderFollower(leftTrajectory);
    rightFollower = new EncoderFollower(rightTrajectory);

    leftFollower.reset();
    rightFollower.reset();

    leftFollower.configureEncoder((int)chassis.getLeftEncoder().get(), 128, 6 / 12);
    rightFollower.configureEncoder((int)chassis.getRightEncoder().get(), 128, 6 / 12);

    leftFollower.configurePIDVA( p,  i, d, v, a);
    rightFollower.configurePIDVA(p , i, d , v , a);
    notifier.startPeriodic(dt);

    System.out.println("Initialized");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // If an IOError happened in the constructor, then
    // this command is done.
    if (ioerror) {
      return true;
    }
    return leftFollower.isFinished() && rightFollower.isFinished();
    //return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    // If an IOError happened in the constructor, then
    // this command is done.
    if (ioerror) {
      return;
    }
    notifier.stop();
    chassis.tankDrive(0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
  class RunProfile implements java.lang.Runnable{
    int segmentNumber = 0;
    
    @Override
    public void run(){
    
    
    double leftOutput = leftFollower.calculate((int) chassis.getLeftEncoder().get());
    double rightOutput = rightFollower.calculate((int) chassis.getRightEncoder().get());
    
    double gyroHeading = 0;
    
    double desiredHeading = Pathfinder.d2r(leftFollower.getHeading());
    
    double angleDifference = Pathfinder.boundHalfDegrees(desiredHeading - gyroHeading);
    
    double turn = 0.08 *  (-1. / 80.) * angleDifference;
    if(forward == true) {
      chassis.tankDrive(leftOutput - turn, rightOutput - turn);
    } else {
      chassis.tankDrive(-1*(rightOutput - turn), -1*(leftOutput - turn));
    }
    
    segmentNumber++;
    }
  }
}
