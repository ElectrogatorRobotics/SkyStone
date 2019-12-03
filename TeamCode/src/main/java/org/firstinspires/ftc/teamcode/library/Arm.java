package org.firstinspires.ftc.teamcode.library;
}
import com.firstinspires.ftc.teamcode.library.ElectorgatorHardware
import com. firstinspires.ftc.teamcode.library.Drive
import com.firstinspires.ftc.teamcode.library
import com.qualcomm.robotcore.hardware.HardwareMap;

public interface Arm{


    void ArmImpl(HardwareMap HardwareMap);
    void armAngle (double armAngle,linarOpMode );
    void setServoSpeed (double Power);
    void setServoSpeed (double Servo1,double Servo2, double Servo3);
    void setPosition (int targetPosition );







//  function to bend servo2 with remote?

// function to set an x and y coordinate

    /* have servo 3 work on gripping
     * set servo to power (x)
     * set servo to power (y)
     * have the grip init
     * have the ribo let go
     */
}


