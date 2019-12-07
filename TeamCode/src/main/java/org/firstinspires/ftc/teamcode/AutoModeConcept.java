package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.library.Camera;
import org.firstinspires.ftc.teamcode.library.CameraImpl;
import org.firstinspires.ftc.teamcode.library.Drive;
import org.firstinspires.ftc.teamcode.library.DriveImplGB;

@Autonomous(name="Auto Test", group="Testing")
public class AutoModeConcept extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Drive drive = new DriveImplGB();
        drive.initDrive(hardwareMap);
        drive.init_bno055IMU(hardwareMap);
        drive.passLinearOp(this);
        drive.setTelemetry(telemetry);

        Camera camera = new CameraImpl();
        camera.init(hardwareMap);
        camera.setTelemetry(telemetry);

        waitForStart();
        while(opModeIsActive()){
            camera.scan(3000);
            telemetry.addData("Cam X:",camera.getX());
            telemetry.addData("Cam Y",camera.getY());
            telemetry.addData("Cam Ang",camera.getAngle());
            telemetry.update();
            sleep(2000);
        }
    }
}
