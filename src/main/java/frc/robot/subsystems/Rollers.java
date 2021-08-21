/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class Rollers extends SubsystemBase {

  public static Rollers rollers;
  private VictorSPX rollersMotors;
  VictorSPX axis_movement_right;
  VictorSPX axis_movement_left;
  //DigitalInput topSwitch;
  boolean canGoUp, canGoDown = false;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Rollers() {
    rollersMotors = new VictorSPX(RobotMap.B_ROLLERS);
    //topSwitch = new DigitalInput(RobotMap.B_TOP_SWITCH);
  }

  public static Rollers getInstance(){
    if (rollers == null){
      rollers = new Rollers();
    }
    return rollers;
  }

  public void spinRollers(double rollerSpeed) {
    rollersMotors.set(ControlMode.PercentOutput, rollerSpeed);
  }


  //public boolean isUp() {
    //return topSwitch.get();
  //}



  public void rollersIn(double rollersSpeed){
    spinRollers(-rollersSpeed);
  }

  public void rollersOff(){
    spinRollers(0);
  }

  public void spitBall(double rollersSpeed) {
    spinRollers(rollersSpeed);
  }

  public void spinOut(double rollersSpeed) {
    rollersSpeed = -Math.abs(rollersSpeed);
    spinRollers(rollersSpeed);
  }

  
}
