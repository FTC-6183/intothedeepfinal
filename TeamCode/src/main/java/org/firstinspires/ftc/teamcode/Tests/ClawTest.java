package org.firstinspires.ftc.teamcode.Tests;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Subsystems.ClawServo;

@Config
@TeleOp
public class ClawTest extends LinearOpMode {
    public static int position = 0;
    public static double topServoPosition = 0;
    public static double leftServoPosition = 0;
    public static double rightServoPosition = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        Servo topServo;
        Servo leftServo;
        Servo rightServo;
        topServo = hardwareMap.get(Servo.class, "top");
        leftServo = hardwareMap.get(Servo.class, "left");
        rightServo = hardwareMap.get(Servo.class, "right");







        ClawServo claw = new ClawServo(hardwareMap);
        ;
        waitForStart();
        while (opModeIsActive()) {
            topServo.setPosition(topServoPosition);
            leftServo.setPosition(leftServoPosition);
            rightServo.setPosition(rightServoPosition);

        }
    }
}