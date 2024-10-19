package frc.robot.Commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class PIDTurnccw extends Command{
    DriveTrain dt;
    double setPointAngle;
    PIDController PID = new PIDController(0.9, 0, 0);

    
    
    
    public PIDTurnccw(DriveTrain dt, double setPoint){
        
        this.dt = dt;
        this.setPointAngle = setPoint;
      
        PID.setTolerance(5);
        addRequirements(this.dt);
    }

    @Override
    public void initialize() {
        dt.reset();
        dt.tankDrive(0, 0);
    }

    double output = PID.calculate(90.0);
    @Override
    public void execute() {
        if (output > 0) {
            dt.tankDrive(output, -(output));
        } else {
            dt.tankDrive(-(output), output);
        }
        
    }

    @Override
    public void end(boolean interrupted) {
        dt.tankDrive(0,0);
    }
    
    @Override
    public boolean isFinished() {
       return PID.atSetpoint();
    }


}