package org.firstinspires.ftc.teamcode.library;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Hal on 11/14/2017.
 */

public interface Camera {
    public void init(HardwareMap hardwareMap);
    public boolean scan(int timeout);
    public void setTelemetry(Telemetry telemetry);

    public Float getX();
    public Float getY();
    public Float getAngle();
}
