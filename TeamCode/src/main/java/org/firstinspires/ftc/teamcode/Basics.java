package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms;

@TeleOp()
public class Basics extends OpMode {

    Mechanisms robot;

    @Override
    public void init() {
        telemetry.addData("Purpose", "Runs on init");
        robot = new Mechanisms(hardwareMap);
        /* This should set things back to defaulted state.
        Otherwise, they will keep its value from the last time it was modified.
         */
    }

    @Override
    public void loop() {
        // Runs during play
        double motorSpeed = robot.squareInputWithSign(-gamepad1.left_stick_y);
        robot.setMotorSpeed(motorSpeed);
    }

    /*INFO ABOUT GAMEPAD LOGIC*/
    // Controls can be individualized to gamepad 1 or 2.
    // All buttons are booleans.
    // Joysticks are double from -1.0 to 1.0. Up is - and down is +.
    // Triggers are doubles from 0.0 to 1.0
}