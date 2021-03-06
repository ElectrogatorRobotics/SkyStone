package org.firstinspires.ftc.teamcode.Auto_wrapblock;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.library.Arm;
import org.firstinspires.ftc.teamcode.library.ArmImpl;
import org.firstinspires.ftc.teamcode.library.Camera;
import org.firstinspires.ftc.teamcode.library.CameraImpl;
import org.firstinspires.ftc.teamcode.library.Drive;
import org.firstinspires.ftc.teamcode.library.DriveImpl;

@Autonomous(name="Park Left Slide", group="Park")
public class AutoGrabBlockInside extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Drive drive = new DriveImpl();
        drive.initDrive(hardwareMap);
        drive.init_bno055IMU(hardwareMap);
        drive.passLinearOp(this);
        drive.setTelemetry(telemetry);

        Camera camera = new CameraImpl();
        camera.init(hardwareMap);
        camera.setTelemetry(telemetry);

        Arm arm = new ArmImpl(hardwareMap);

        int blockLocation = -1;

        waitForStart();
//        while(opModeIsActive()){
        arm.release();
              drive.forward(18);
              if(camera.scan(2000)){
                  blockLocation=0;
              }
              else{
                  drive.slide(8);
                  if (camera.scan(2000)){
                      blockLocation=1;
                  }
                  else{
                      drive.slide(-16);
                  }
              }

                ((ArmImpl)arm).armAngle_bytime(10,this);
                drive.forward(6);
                arm.grip();
                drive.forward(-6);
                drive.turnToAngle(-90,this);
                drive.forward(50 + (blockLocation * 8));
                arm.release();
                drive.forward(-20);


//            camera.scan(3000);
//            telemetry.addData("Cam X:",camera.getX());
//            telemetry.addData("Cam Y",camera.getY());
//            telemetry.addData("Cam Ang",camera.getAngle());
//            telemetry.update();
//            sleep(2000);
//        }
    }
}
