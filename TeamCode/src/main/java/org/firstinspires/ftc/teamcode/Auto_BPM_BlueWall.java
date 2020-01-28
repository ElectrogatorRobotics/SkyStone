package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.library.Arm;
import org.firstinspires.ftc.teamcode.library.ArmImpl;
import org.firstinspires.ftc.teamcode.library.Drive;
import org.firstinspires.ftc.teamcode.library.DriveImpl;

@Autonomous(name="BPM - Blue Wall", group="BuildPlate")
public class Auto_BPM_BlueWall extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Drive drive = new DriveImpl();
        drive.initDrive(hardwareMap);
        drive.init_bno055IMU(hardwareMap);
        drive.passLinearOp(this);
        drive.setTelemetry(telemetry);

//        Camera camera = new CameraImpl();
//        camera.init(hardwareMap);
//        camera.setTelemetry(telemetry);

        Arm arm = new ArmImpl(hardwareMap);

        ElapsedTime timer = new ElapsedTime();

        waitForStart();
//        while(opModeIsActive()){
            arm.releaseFD();
            drive.slide(10);
            drive.forward(-29);
            ((DriveImpl)drive).forward(-2,.1);
            timer.reset();
            arm.grabFD();
            while(timer.milliseconds() < 1500);
            drive.forward(31);
            timer.reset();
            arm.releaseFD();
            while(timer.milliseconds() < 1500);
            ((DriveImpl)drive).power_slide(-2,.2);
            drive.slide(-29);
            drive.forward(-10);
            drive.slide(5);
            drive.forward(10);
            ((DriveImpl)drive).power_slide(-2,.2);
            drive.slide(-20);

//            camera.scan(3000);
//            telemetry.addData("Cam X:",camera.getX());
//            telemetry.addData("Cam Y",camera.getY());
//            telemetry.addData("Cam Ang",camera.getAngle());
//            telemetry.update();
//            sleep(2000);
//        }
    }
}
