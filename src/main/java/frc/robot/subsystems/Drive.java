/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Drive drive;
  public static DifferentialDrive drivetrain;
  private WPI_TalonSRX frontLeft, frontRight, backLeft, backRight;
  private SpeedControllerGroup left, right;

  /**
   * Contructor that sets up speed controllers and the drive train.
   */
  private Drive() {
      //TODO:Update with names and proper ports
      frontLeft = new WPI_TalonSRX(RobotMap.D_FRONT_LEFT);
      frontRight = new WPI_TalonSRX(RobotMap.D_FRONT_RIGHT);
      backLeft = new WPI_TalonSRX(RobotMap.D_BACK_LEFT);
      backRight = new WPI_TalonSRX(RobotMap.D_BACK_RIGHT);

      left = new SpeedControllerGroup(frontLeft, backLeft);
      right = new SpeedControllerGroup(frontRight, backRight);

      drivetrain = new DifferentialDrive(left, right);
  }

  /**
   * Used in UserDrive command to take user input and drive with it.
   * @param leftSpeed Plug in left joystick value.
   * @param rightSpeed Plug in right joystuck value.
   */
  public void tankDrive(double leftSpeed, double rightSpeed){
    drivetrain.tankDrive(leftSpeed, rightSpeed);
  }

  /**
   * Used outside of the Drive subsystem to return an instance of Drive subsystem.
   * @return Returns instance of Drive subsystem formed from constructor.
   */
  public static Drive getInstance(){
    if (drive == null){
      drive = new Drive();
    }
    return drive;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //TODO:Set default command
  }

}