package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {

    public final CANSparkMax leftFrontMotor;
    public final CANSparkMax leftBackMotor;
    public final CANSparkMax rightFrontMotor;
    public final CANSparkMax rightBackMotor;
    // main set of wheels
    DifferentialDrive diffDrive;
    public double speed;

    public Drive(double speed) {
        this.speed = speed;

        leftFrontMotor = new CANSparkMax(0, MotorType.kBrushless); 
        rightFrontMotor = new CANSparkMax(1, MotorType.kBrushless); 
        leftBackMotor = new CANSparkMax(2, MotorType.kBrushless);
        rightBackMotor = new CANSparkMax(3, MotorType.kBrushless); 

        leftBackMotor.follow(leftFrontMotor);
        rightBackMotor.follow(rightFrontMotor);

        leftFrontMotor.setInverted(true);
        rightFrontMotor.setInverted(true);

    }

    //controller stuff
    public void goUp(){
        leftFrontMotor.set(speed);
        rightFrontMotor.set(speed);
    }
    public void goDown(){
        leftFrontMotor.set(speed);
        rightFrontMotor.set(speed);
    }
    public void decrementSpeed(){
        if(speed==0){
            speed-=0;
        } else{
            speed-=0.1;
            leftFrontMotor.set(speed);
            rightFrontMotor.set(speed);
        }
    }
    public void incrementSpeed(){
        if(speed==1){
            speed+=0;
        } else{
            speed+=0.1; 
            leftFrontMotor.set(speed);
            rightFrontMotor.set(speed);
        }
    }
    public double getSpeed(int s){
        return leftFrontMotor.get();
    }

    public void turnOff(){
        leftFrontMotor.set(0);
        rightFrontMotor.set(0);
    }

    public void turnRight(){
        rightFrontMotor.set(1);
        leftFrontMotor.set(0);

    }

    public void turnLeft(){
        rightFrontMotor.set(0);
        leftFrontMotor.set(1);

    }


}