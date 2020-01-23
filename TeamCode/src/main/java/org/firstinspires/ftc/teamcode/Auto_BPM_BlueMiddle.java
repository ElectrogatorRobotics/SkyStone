package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.library.Arm;
import org.firstinspires.ftc.teamcode.library.ArmImpl;
import org.firstinspires.ftc.teamcode.library.Drive;
import org.firstinspires.ftc.teamcode.library.DriveImpl;

@Autonomous(name="BPM - Blue Middle", group="BuildPlate")
public class Auto_BPM_BlueMiddle extends LinearOpMode {

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

        waitForStart();
//        while(opModeIsActive()){
                drive.slide(48);
              drive.forward(3);

              arm.grabFD();

              drive.slide(-36);



//            camera.scan(3000);
//            telemetry.addData("Cam X:",camera.getX());
//            telemetry.addData("Cam Y",camera.getY());
//            telemetry.addData("Cam Ang",camera.getAngle());
//            telemetry.update();
//            sleep(2000);
//        }
    }
}
