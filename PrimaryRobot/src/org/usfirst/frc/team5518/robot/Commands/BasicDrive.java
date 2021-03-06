package org.usfirst.frc.team5518.robot.Commands;

import org.usfirst.frc.team5518.robot.Robot;
import org.usfirst.frc.team5518.robot.RobotMap;
import org.usfirst.frc.team5518.robot.OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BasicDrive extends Command {
	
	public double moveValue, turnValue;
	public boolean fineControl;
	public boolean invertButton;
	
    public BasicDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    	moveValue = 0;
    	turnValue = 0;
    	fineControl = true;
    	invertButton = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // This method runs repeatedly while the robot
    protected void execute() {
    	moveValue = OI.driveController.getRawAxis(RobotMap.XBOX_LSTICKY);
    	turnValue = OI.driveController.getRawAxis(RobotMap.XBOX_LSTICKX);
    	Robot.driveTrain.drive(moveValue, turnValue, fineControl);
    	
    	invertButton = OI.getButton(OI.driveController, RobotMap.XBOX_LBUMPER);
    	Robot.driveTrain.invert(invertButton);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.drive(0, 0, true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
