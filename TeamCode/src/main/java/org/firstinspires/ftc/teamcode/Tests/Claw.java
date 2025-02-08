package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Claw extends LinearOpMode {
    private Servo leftServo, rightServo, topServo;

    @Override
    public void runOpMode() throws InterruptedException {
        leftServo = hardwareMap.servo.get("leftServo");
        rightServo = hardwareMap.servo.get("rightServo");
        topServo = hardwareMap.servo.get("topServo");

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.cross) {
                //testing top servo position
                telemetry.addData("Servo current Position",topServo.getPosition());

                telemetry.update();
            }
        }


    }
}
