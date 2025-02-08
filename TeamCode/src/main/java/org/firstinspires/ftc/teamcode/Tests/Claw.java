package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp
public class Claw extends LinearOpMode {
    private CRServo leftServo, rightServo, topServo;

    @Override
    public void runOpMode() throws InterruptedException {
        leftServo = hardwareMap.crservo.get("left");
        rightServo = hardwareMap.crservo.get("right");
        topServo = hardwareMap.crservo.get("top");

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.cross) {
                setServoPowers(0.01, -0.01, 0);
                telemetry.addLine("Claw up");
            } else if (gamepad1.circle) {
                setServoPowers(-0.01, 0.01, 0);
                telemetry.addLine("Claw down");
            } else if (gamepad1.triangle) {
                setServoPowers(0, 0, 0.01);
                telemetry.addLine("Claw open");
            } else if (gamepad1.square) {
                setServoPowers(0, 0, -0.01);
                telemetry.addLine("Claw close");
            } else {
                setServoPowers(0, 0, 0);
            }
            telemetry.update();
        }
    }

    private void setServoPowers(double leftPower, double rightPower, double topPower) {
        leftServo.setPower(leftPower);
        rightServo.setPower(rightPower);
        topServo.setPower(topPower);
    }
}
