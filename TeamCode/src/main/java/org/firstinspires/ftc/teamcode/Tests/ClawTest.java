package org.firstinspires.ftc.teamcode.Tests;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@Config
@TeleOp
public class ClawTest extends LinearOpMode {
    public static int position = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        Servo servo;
        servo = hardwareMap.servo.get("top");
        waitForStart();
        while (opModeIsActive()) {

            servo.setPosition(position);

        }
    }
}
