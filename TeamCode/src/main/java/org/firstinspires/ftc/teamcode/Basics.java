package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms;

@TeleOp()
public class Basics extends OpMode {

    Mechanisms robot;
    servoPosition servoPos;

    @Override
    public void init() {
        telemetry.addData("Purpose", "Runs on init");
        robot = new Mechanisms(hardwareMap);
        servoPos = servoPosition.OPEN;
        /* This should set things back to defaulted state.
        Otherwise, they will keep its value from the last time it was modified.
         */
    }

    private enum servoPosition{
        CLOSED,
        HALFWAY,
        OPEN
    }

    @Override
    public void loop() {
        // Runs during play
        double motorSpeed = robot.squareInputWithSign(-gamepad1.left_stick_y);
        robot.setMotorSpeed(motorSpeed);

        // A totally inaccurate example, but a demonstration of a simple state machine.
        switch (servoPos) {
            case OPEN:
                robot.setServoPosition(1.0);
                if (robot.isTouchSensorPressed()) {
                    servoPos = servoPosition.HALFWAY;
                }
            case HALFWAY:
                robot.setServoPosition(0.5);
                if (!robot.isTouchSensorPressed()) {
                    servoPos = servoPosition.CLOSED;
                }
            case CLOSED:
                robot.setServoPosition(0.0);
                break;
        }
    }

    /*INFO ABOUT GAMEPAD LOGIC*/
    // Controls can be individualized to gamepad 1 or 2.
    // All buttons are booleans.
    // Joysticks are double from -1.0 to 1.0. Up is - and down is +.
    // Triggers are doubles from 0.0 to 1.0
}