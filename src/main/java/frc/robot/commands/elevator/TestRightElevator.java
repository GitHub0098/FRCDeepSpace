package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.input.XboxController.XboxAxis;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.Timer;


public class TestRightElevator extends Command {
    double speed;
    XboxAxis leftJoystickY = XboxAxis.kYLeft;
    Timer timer;
    boolean end;

    public TestRightElevator() {
        requires(Elevator.getInstance());
        timer.start();
    }
    
    /**
     * Not Used
     */
    protected void initialize() {
    }

    /**
     * Uses left stick of xbox controller to move elevator up and down
     */
    protected void execute() {
	    speed = OI.getInstance().getXbox().getAxis(leftJoystickY);
	    Elevator.getInstance().extendRight(speed);
      if(timer.get() >= 240){
        end = true;
      }
    }
    
    /**
     * Always false because default commands never stop
     */
    protected boolean isFinished() {
        return end;
    }
    
    /**
     * Not Used
     */
    protected void end() {
        timer.stop();
    }
    
    /**
     * Not Used
     */
    protected void interrupted() {
    }
}
