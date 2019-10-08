package org.firstinspires.ftc.teamcode.library;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.motors.RevRobotics20HdHexMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class DriveV2_Impl implements DriveV2 {
    public DcMotorEx frontRightDrive = null;
    public DcMotorEx frontLeftDrive = null;
    public DcMotorEx backRightDrive = null;
    public DcMotorEx backLeftDrive = null;

    public Servo frontRightServo = null;
    public Servo frontLeftServo = null;
    public Servo backRightServo = null;
    public Servo backLeftServo = null;

    public BNO055IMU bno055IMU = null;

    private ElapsedTime runtime = new ElapsedTime();

    public Orientation angle = null;

    private final static double MIN_SERVO_SCALE_VALUE = 0.18;
    private static final double DRIVE_POWER = .3;
    private static final double TURN_POWER = .2;
    private static final double SLIDE_POWER = .5;
    private static final double TURN_THRESHOLD = .5;

    public DriveV2_Impl(){}

    public void initDrive(HardwareMap hardwareMap) {
        frontRightDrive = (DcMotorEx) hardwareMap.dcMotor.get("front right drive");
        frontRightDrive.setMotorType(MotorConfigurationType.getMotorType(RevRobotics20HdHexMotor.class));
        frontRightDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontRightServo = hardwareMap.servo.get("front right servo");
        frontRightServo.scaleRange(MIN_SERVO_SCALE_VALUE, 0.8);
        frontRightServo.setDirection(Servo.Direction.FORWARD);

        frontLeftDrive = (DcMotorEx) hardwareMap.dcMotor.get("front left drive");
        frontLeftDrive.setMotorType(MotorConfigurationType.getMotorType(RevRobotics20HdHexMotor.class));
        frontLeftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontLeftServo = hardwareMap.servo.get("front left servo");
        frontLeftServo.scaleRange(MIN_SERVO_SCALE_VALUE, 0.8);
        frontLeftServo.setDirection(Servo.Direction.FORWARD);

        backRightDrive = (DcMotorEx) hardwareMap.dcMotor.get("back right drive");
        backRightDrive.setMotorType(MotorConfigurationType.getMotorType(RevRobotics20HdHexMotor.class));
        backRightDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        backRightServo = hardwareMap.servo.get("back right servo");
        backRightServo.scaleRange(MIN_SERVO_SCALE_VALUE, 0.8);
        backRightServo.setDirection(Servo.Direction.FORWARD);

        backLeftDrive = (DcMotorEx) hardwareMap.dcMotor.get("back left drive");
        backLeftDrive.setMotorType(MotorConfigurationType.getMotorType(RevRobotics20HdHexMotor.class));
        backLeftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        backLeftServo = hardwareMap.servo.get("back left servo");
        backLeftServo.scaleRange(MIN_SERVO_SCALE_VALUE, 0.8);
        backLeftServo.setDirection(Servo.Direction.FORWARD);

        setMotorMode(MotorMode.ENCODER);
    }

    public void setMotorMode(MotorMode mode){
        switch(mode){
            case POWER:
                frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                break;
            case ENCODER:
                frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                break;
            case POSITION:
                frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                break;
        backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    }

    public void init_bno055IMU (HardwareMap hardwareMap) {
        bno055IMU = hardwareMap.get( BNO055IMU.class, "imu");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
//        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.gyroPowerMode = BNO055IMU.GyroPowerMode.NORMAL;
        parameters.gyroBandwidth = BNO055IMU.GyroBandwidth.HZ64;
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
//        parameters.mode = BNO055IMU.SensorMode.GYRONLY;
        bno055IMU.initialize(parameters);
    }

    public void setDriveSpeed (double power){
        frontRightDrive.setPower(power);
        frontLeftDrive.setPower(power);
        backRightDrive.setPower(power);
        backLeftDrive.setPower(power);
    }

    public void setDriveSpeed (double frontRight, double backRight, double frontLeft, double backLeft) {
        frontRightDrive.setPower(frontRight);
        frontLeftDrive.setPower(frontLeft);
        backRightDrive.setPower(backRight);
        backLeftDrive.setPower(backLeft);
    }

    public void setServoPosition (double frontPosition, double backPosition) {
        frontRightServo.setPosition(frontPosition);
        frontLeftServo.setPosition(frontPosition);
        backRightServo.setPosition(backPosition);
        backLeftServo.setPosition(backPosition);
    }

    public void setTargetPosition (int targetPosition) {
        frontLeftDrive.setTargetPosition(frontLeftDrive.getCurrentPosition() + targetPosition);
        frontRightDrive.setTargetPosition(frontRightDrive.getCurrentPosition() + targetPosition);
        backLeftDrive.setTargetPosition(backLeftDrive.getCurrentPosition() + targetPosition);
        backRightDrive.setTargetPosition(backRightDrive.getCurrentPosition() + targetPosition);
    }

    /**
     * tolerance is measured in encoder ticks
     * @param tolerance
     */
    public void setTargetTolerance(int tolerance) {
        frontRightDrive.setTargetPositionTolerance(tolerance);
        frontLeftDrive.setTargetPositionTolerance(tolerance);
        backRightDrive.setTargetPositionTolerance(tolerance);
        backLeftDrive.setTargetPositionTolerance(tolerance);
    }

    public void driveByPosition(double power, LinearOpMode lom){
        setMotorMode(MotorMode.POSITION);
        setDriveSpeed(power);
        do {
            Thread.yield(); //effectively what the LinearOpMode idle call does
        } while (frontRightDrive.isBusy() && lom.opModeIsActive());
        stop();
        setMotorMode(MotorMode.POWER);
    }

    public void slideOff(int targetPosition, LinearOpMode lom){
        setMotorMode(MotorMode.POSITION);
        setTargetTolerance(50);
        frontLeftDrive.setTargetPosition(frontLeftDrive.getCurrentPosition() + targetPosition);
        frontRightDrive.setTargetPosition(frontRightDrive.getCurrentPosition() - targetPosition);
        backLeftDrive.setTargetPosition(backLeftDrive.getCurrentPosition() - targetPosition);
        backRightDrive.setTargetPosition(backRightDrive.getCurrentPosition() + targetPosition);
        setDriveSpeed(SLIDE_POWER, SLIDE_POWER*-1, SLIDE_POWER*-1, SLIDE_POWER);
        do {
            Thread.yield(); //effectively what the LinearOpMode idle call does
        } while (frontRightDrive.isBusy() && lom.opModeIsActive());
        stop();
        setMotorMode(MotorMode.ENCODER);
    }

    public double turnToAngle (double angleToTurn, LinearOpMode lom, Telemetry telemetry) {
        angle = bno055IMU.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
        /**
         * set {@link angleToTurn} equal to the {@link imu}'s Z axes
         */
        setMotorMode(MotorMode.ENCODER);
        double power = TURN_POWER;
        telemetry.addData("Angle to turn, before if", angleToTurn);
        telemetry.update();

        boolean targeted = false;
        boolean ccw = (angle.thirdAngle < angleToTurn);

        runtime.reset();
        while(!targeted && runtime.seconds() < 10 && lom.opModeIsActive()){
            angle = bno055IMU.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
            if(Math.abs(angleToTurn - angle.thirdAngle) < TURN_THRESHOLD){
                targeted = true;
                break;
            }
            else if(angle.thirdAngle < angleToTurn){
                if(!ccw){
                    power = -0.5 * TURN_POWER;
                }
                else power = Math.abs(power)*-1;
            }
            else{
                if(ccw){
                    power = TURN_POWER * .5;
                }
                else power = Math.abs(power);
            }
            telemetry.addData("angle", angle.thirdAngle);
            telemetry.addData("target", angleToTurn);
            telemetry.update();
            setDriveSpeed(power*-1, power*-1, power*1, power*1);
        }
        stop();
        setMotorMode(MotorMode.ENCODER);
        return angleToTurn;
    }

    public void stop () {
        setDriveSpeed(0.0);
    }

}
