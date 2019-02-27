/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ProximitySensor extends Subsystem {

  private static ProximitySensor proximitySensor;
  private DigitalInput prox;

  public ProximitySensor() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    prox = new DigitalInput(RobotMap.E_PROXIMITY);
  }

  public static ProximitySensor getInstance(){
    if (proximitySensor == null){
      proximitySensor = new ProximitySensor();
    }
    return proximitySensor;
  }

  public DigitalInput getProximitySensor() {
    return prox;
  }

  public boolean get() {
    return !prox.get();
  }

  public void initDefaultCommand() {

  }

}
