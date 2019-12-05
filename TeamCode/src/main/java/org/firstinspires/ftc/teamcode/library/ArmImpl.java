package org.firstinspires.ftc.teamcode.library;
import android.app.job.JobInfo;

import com.firstinspires.ftc.teamcode.library.ElectorgatorHardware
import com. firstinspires.ftc.teamcode.library.Drive
import com.firstinspires.ftc.teamcode.library
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import com.qualcomm.hardware.motors.RevRobotics20HdHexMotor;

public class ArmImpl implements Servo {
     public Motor motor1 = HardwareMap..get ("Servo1");
     public Motor Motor2 = HardwareMap.Servo.get("Servo2");
     public Servo Servo1 = HardwareMap.Servo.get("Servo3");
// set speeds of servo2 movement

    int setServo (HardwareMap)

    public double getArmAngle (double armAngle, LinearOpMode) {
        angle = bno055IMU.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
        /**
         * set {@link angleToTurn} equal to the {@link imu}'s Z axes
         */
        setServo(setServo.POWER);
        double power = TURN_POWER;
        if(angleToTurn < 0) power *= -1;
        angleToTurn *= -1;
        double targetAngle = (angle.thirdAngle + angleToTurn + 180)%180;
        if(targetAngle >90){
            targetAngle -= 180;
        }
        stop();
        setMotorMode(setServo.ENCODER);
        return angleToTurn;
    }
public void setServoSpeed (double Power) {
    Servo1.setPower(Power);
    Servo2.setPower(Power);
    Servo3.setPower(Power);
}

public void setServoSpeed (double Servo1, double Servo2, double Servo3){
        Servo1.setPower(Servo1);
        Servo2.setPower(Servo2);
        Servo3.setPower(Servo3);
}
public void servoPosition (int targetPosition){
        Servo1.setTargetPosition(Servo1.getPosition()+targetPosition);
        Servo2.setTargetPosition(Servo2.getPosition()+targetPosition);
        Servo3.setTsrgetPostiton(Servo3.getPosition()+targetPosition);
}
public void stop (setServoSpeed(0.0))
//  function to bend servo2 with remote?
public void motorExtend(){
        if Gamepad  = 1;
        setServoSpeed(50);
        if Gamepad = 0.0;
        setServoSpeed(0);

        stop();

}
public void MotorRotate (){
        if Gamepad = 1;
        setMotorSpeed(-50);
        if Gamepad = 0;
        setMotorSpeed();

        stop();
}

public void servoSnagger (){
        if Gamepad = 1;
        setServoSpeed(1);
        if Gamepad = 0;
        setServoSpeed(0);
}
// function to set an x and y coordinate

    /* have servo 3 work on gripping
     * set servo to power (x)
     * set servo to power (y)
     * have the grip init
     * have the ribo let go
     */

}
