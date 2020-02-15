
package org.firstinspires.ftc.teamcode.Auto_wrapblock;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.library.Arm;
import org.firstinspires.ftc.teamcode.library.ArmImpl;
import org.firstinspires.ftc.teamcode.library.Drive;
import org.firstinspires.ftc.teamcode.library.DriveImpl;
import org.firstinspires.ftc.teamcode.library.ElectorgatorHardware;

/**
 * Created by Luke on 10/1/2017.
 */

@TeleOp(name = "Test Arm")
public class TestArmDeploy extends LinearOpMode {
    ElectorgatorHardware hardware = new ElectorgatorHardware();
	Drive drive;
	Arm arm;

    double frontLeftDrive, frontRightDrive, backRightDrive, backLeftDrive;
    double rotate, extend;

    @Override
    public void runOpMode() throws InterruptedException {
        // initialise the motors
        telemetry.addLine("Initialising... please wait.");
        telemetry.update();

        arm = new ArmImpl(hardwareMap);

        telemetry.addLine("Ready to start... thank you for waiting!");
        telemetry.update();

        waitForStart();

        double targetPosition = 0;

        while (opModeIsActive()) {

            if(gamepad2.b){
                while(gamepad2.b);
                targetPosition += 100;
            }
            else if(gamepad2.x){
                while(gamepad2.x);
                targetPosition -= 100;
            }
            else if(gamepad2.a){
                arm.armAngle(targetPosition, this);
            }


            rotate = -gamepad2.left_stick_y * .5;
            arm.setAngleSpeed(rotate);

            //TELEMETRY

            telemetry.addData("target position = ", "%u", targetPosition);
            telemetry.addData("angle speed = ", "%1.2f", rotate);
            telemetry.update();
        }
    }

}
