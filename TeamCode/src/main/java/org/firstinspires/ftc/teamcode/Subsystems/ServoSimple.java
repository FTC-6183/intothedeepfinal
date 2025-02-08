package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoSimple {

    Servo topServo;
    Servo leftServo;
    Servo rightServo;
    //.5 .5
    public ServoSimple(HardwareMap hardwareMap) {
        topServo = hardwareMap.get(Servo.class, "top");
        leftServo = hardwareMap.get(Servo.class, "left");
        rightServo = hardwareMap.get(Servo.class, "right");
        leftServo.setPosition(.2);
        rightServo.setPosition(.2);
    }

    public void openClaw() {
        topServo.setPosition(1.0);
    }
    public void goToIntake() {
        leftServo.setPosition(0);
        rightServo.setPosition(0);
    }
    public void goToScore() {
        leftServo.setPosition(1);
        rightServo.setPosition(1);
    }
    public void closeClaw() {
        topServo.setPosition(0);
    }
}
