
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.library.ElectorgatorHardware;

import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name = "SysFunc Test")
public class SystemTest extends LinearOpMode {
    ElectorgatorHardware hardware = new ElectorgatorHardware();

    @Override
    public void runOpMode() throws InterruptedException {
        // initialise the motors
        telemetry.addLine("Initialising... please wait.");
        telemetry.update();

        hardware.initMotors(hardwareMap);

        telemetry.addLine("Ready to start... thank you for waiting!");
        telemetry.update();

        waitForStart();

        ElapsedTime et = new ElapsedTime();

        //Front Left Drive
        telemetry.addLine("Running Front Left Drive");
        telemetry.update();
        hardware.frontLeftDrive.setPower(.6);
        while (!gamepad1.a)
        et.reset();
        hardware.frontLeftDrive.setPower(0);
        while (et.milliseconds() < 1000);

        //Front Right Drive
        telemetry.addLine("Running Front Right Drive");
        telemetry.update();
        hardware.frontRightDrive.setPower(.6);
        while (!gamepad1.a)
        et.reset();
        hardware.frontRightDrive.setPower(0);
        while (et.milliseconds() < 1000) ;

        //Back Left Drive
        telemetry.addLine("Running Back Left Drive");
        telemetry.update();
        hardware.backLeftDrive.setPower(.6);
        while (!gamepad1.a)
        et.reset();
        hardware.backLeftDrive.setPower(0);
        while (et.milliseconds() < 1000) ;

        //Back Right Drive
        telemetry.addLine("Running Back Right Drive");
        telemetry.update();
        hardware.backRightDrive.setPower(.6);
        while (!gamepad1.a)
            et.reset();
        hardware.backRightDrive.setPower(0);
        while (et.milliseconds() < 1000) ;
    }
}
