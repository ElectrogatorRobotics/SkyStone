package org.firstinspires.ftc.teamcode.library;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.motors.RevRobotics20HdHexMotor;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

public class ArmImpl implements Arm {
     public DcMotor rotate;
     public DcMotor extend;
     public Servo grip;

     public ArmImpl(HardwareMap hwm) {
         rotate = (DcMotorEx) hwm.dcMotor.get("rotate arm");
         rotate.setMotorType(MotorConfigurationType.getMotorType(RevRobotics20HdHexMotor.class));
         rotate.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         rotate.setDirection(DcMotorSimple.Direction.FORWARD);
         rotate.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

         extend = (DcMotorEx) hwm.dcMotor.get("extend arm");
         extend.setMotorType(MotorConfigurationType.getMotorType(RevRobotics20HdHexMotor.class));
         extend.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         extend.setDirection(DcMotorSimple.Direction.FORWARD);
         extend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

         grip = hwm.servo.get("grip arm");
     }

    @Override
    public void armAngle(double armAngle, LinearOpMode lom) {

    }

    @Override
    public void setAngleSpeed(double Power) {
        rotate.setPower(Power);
    }

    @Override
    public void setExtendSpeed(double Power) {
        extend.setPower(Power);
    }

    @Override
    public void setExtendPosition(int targetPosition) {

    }

    @Override
    public void grip() {
        grip.setPosition(.2); //TODO: WTH is the actual grip val
    }

    @Override
    public void release() {
        grip.setPosition(.8); //fling it wide open.
    }

    @Override
    public void setGripPosition(double targetPosition) {
        grip.setPosition(targetPosition);
    }


// function to set an x and y coordinate

    /* have servo 3 work on gripping
     * set servo to power (x)
     * set servo to power (y)
     * have the grip init
     * have the ribo let go
     */

}
