package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class Mechanisms {

    private final TouchSensor touchSensor;
    private final DcMotorEx dcMotorEx;
    private final Servo servo;

    public Mechanisms (HardwareMap hardwareMap) {
        touchSensor = hardwareMap.touchSensor.get("touch");
        dcMotorEx = (DcMotorEx) hardwareMap.dcMotor.get("motor");
        servo = hardwareMap.servo.get("servo");
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

    public void setServoPosition(double pos) {
        servo.setPosition(pos);
    }
}
