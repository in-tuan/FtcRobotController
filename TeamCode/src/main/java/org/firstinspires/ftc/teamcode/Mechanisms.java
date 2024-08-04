package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class Mechanisms {

    private final TouchSensor touchSensor;
    private final DcMotorEx dcMotorEx;

    public Mechanisms (HardwareMap hardwareMap) {
        touchSensor = hardwareMap.get(TouchSensor.class, "touch");
        dcMotorEx = hardwareMap.get(DcMotorEx.class, "motor");
    }

    public boolean isTouchSensorPressed() {
        return touchSensor.isPressed();
    }

    public void setMotorSpeed (double speed) {
        dcMotorEx.setPower(speed);
    }

    public double squareInputWithSign(double input) {
        double output = input * input;
        if (input < 0) {
            output *= -1;
        }
        return output;
    }
}
