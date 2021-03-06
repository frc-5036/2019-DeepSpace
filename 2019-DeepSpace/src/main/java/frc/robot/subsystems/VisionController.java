package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class VisionController extends Subsystem{
    private boolean is_enabled, driverVision, tapeVision, tape_Detected;
    private NetworkTableEntry tapeDetected, tapeYaw, driveWanted, tapeWanted, videoTimeStamp;
    private double targetAngle, timestamp;

    //TO DO:
    // add functions to change modes 

    NetworkTableInstance instance;
    NetworkTable devilVision;


    public VisionController(){

        instance = NetworkTableInstance.getDefault();
        devilVision = instance.getTable("devilVision");

        tapeDetected = devilVision.getEntry("tapeDetected");
        tapeYaw = devilVision.getEntry("tapeYaw");

        driveWanted = devilVision.getEntry("Driver");
        tapeWanted = devilVision.getEntry("Tape");

        //videoTimeStamp = devilVision.getEntry("VideoTimestamp");

        tapeVision = true;
        driverVision = false;

    }

    public void reset(){
        tapeVision = true;
        driverVision = false;
        driveWanted.setBoolean(driverVision);
        tapeWanted.setBoolean(tapeVision);
    }

    public void updateVision(){
            //targetAngle = tapeYaw.getDouble(999);
            //tape_Detected = tapeDetected.getBoolean(false);
            SmartDashboard.putBoolean("Tape Detected?", tape_Detected);
            //SmartDashboard.getNumber("target angle", targetYaw());
            SmartDashboard.putBoolean("Vision Enabled", isEnabled());
    }

    public double targetYaw() {
		return tapeYaw.getDouble(0);
	}
	
	public void enable() {
		is_enabled = true;
	}
	
	public void disable() {
		is_enabled = false;
	}
	
	public boolean isEnabled() {
		return is_enabled;
	}

    @Override
    protected void initDefaultCommand() {

    }

}