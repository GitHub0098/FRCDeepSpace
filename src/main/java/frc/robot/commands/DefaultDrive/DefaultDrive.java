package frc.robot.commands.DefaultDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.input.AttackThree.AttackThreeAxis;
import frc.robot.subsystems.Drive;


/**
 * This command runs as a default command and allows user drive with two joystick in the TankDrive configuration.
 */
public class DefaultDrive extends CommandBase {

    double left, right;
    AttackThreeAxis yAxis = AttackThreeAxis.kY;

    public DefaultDrive() {
        addRequirements(Drive.getInstance()); 
    }

    /**
     * Not Used
     */


    /**
     * Runs when command is executed. (In this case always because command is default command.)
     * 
     * Reads value of left and right joysticks and drives robot in TankDrive configuration using those values.
     */
    public void execute() {
        left  = OI.getInstance().getLeftStick().getAxis(yAxis);
        right = OI.getInstance().getRightStick().getAxis(yAxis);
        Drive.getInstance().tankDrive(-left, -right);
    }

    /**
     * Never ends because command is default command for Drive subsytem.
     */
    public boolean isFinished() {
        return false;
    }

    /**
     * Not Used
     */
    protected void end() {
    }

    /**
     * Not Used
     */
    protected void interrupted() {
    }
}
