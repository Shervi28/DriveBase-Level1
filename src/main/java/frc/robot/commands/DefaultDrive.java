package frc.robot.commands;

import frc.robot.subsystems.Drive;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DefaultDrive extends CommandBase {

    private DoubleSupplier speed;
    private DoubleSupplier rot;
    private Drive drive;
   
   
    public DefaultDrive(DoubleSupplier speed, DoubleSupplier rot, Drive drive) {
        this.speed = speed;
        this.rot = rot;
        this.drive = drive;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(drive);
      }
    
    @Override
    public void initialize(){
        
    }

    @Override
    public void execute() {
    
    }

        // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

}
