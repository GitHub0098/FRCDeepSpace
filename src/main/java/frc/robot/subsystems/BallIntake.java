/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class BallIntake extends Subsystem {

  public static BallIntake intake;
  private WPI_TalonSRX rollers, axis_movement;

  public static BallIntake ballintake;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private BallIntake() {
    rollers = new WPI_TalonSRX(RobotMap.B_ROLLERS);
    axis_movement = new WPI_TalonSRX(RobotMap.B_AXIS_MOVEMENT);
  }

  public static BallIntake getInstance(){
    if (intake == null){
      intake = new BallIntake();
    }
    return intake;
  }

 // public void intakeUp(double intakeSpeed){
//  axis_movement.set(intakeSpeed);
//  rollers.set(0);
 // }

// public void intakeDown(double intakeSpeed, double rollersSpeed) {
//		rollers.set(rollersSpeed);
//		axis_movement.set(intakeSpeed);
// }

  public void intakeUp(double intakeSpeed){
    axis_movement.set(intakeSpeed);
  }

  public void intakeDown(double intakeSpeed){
    axis_movement.set(intakeSpeed);
  }

  public void rollersIn(double rollersSpeed){
    rollers.set(rollersSpeed);
  }

  public void rollersOff(){
    rollers.set(0);
  }

  public void spitBall(double rollersSpeed) {
    rollers.set(rollersSpeed);
  }

  public void spinOut(double rollersSpeed) {
    rollers.setInverted(true);
    rollers.set(rollersSpeed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
