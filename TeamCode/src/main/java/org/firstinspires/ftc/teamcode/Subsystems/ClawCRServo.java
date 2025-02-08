package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

public class ClawCRServo extends SubsystemBase {
    private CRServo topServo;
    private CRServo leftServo;
    private CRServo rightServo;
    private static final double speedRegulator = 4;
    private static final double STOP = 0;
    private static final double FORWARD = 1.0/speedRegulator;
    private static final double REVERSE = -1.0/speedRegulator;
    private static final double ROTATION_INCREMENT = 0.1; // Speed increment for rotation
    private static final double VERTICAL_INCREMENT = 0.05; // Speed increment for vertical movement

    public ClawCRServo(HardwareMap hardwareMap) {
        topServo = hardwareMap.get(CRServo.class, "top");
        leftServo = hardwareMap.get(CRServo.class, "left");
        rightServo = hardwareMap.get(CRServo.class, "right");

        // Initialize servos to stop
        topServo.setPower(STOP);
        leftServo.setPower(STOP);
        rightServo.setPower(STOP);
    }

    public void openClaw() {
        topServo.setPower(FORWARD);
    }

    public void closeClaw() {
        topServo.setPower(REVERSE);
    }

    public void stopClaw() {
        topServo.setPower(STOP);
    }

    public void incrementRotation() {
        leftServo.setPower(FORWARD);
        rightServo.setPower(REVERSE);
    }

    public void decrementRotation() {
        leftServo.setPower(REVERSE);
        rightServo.setPower(FORWARD);
    }

    public void stopRotation() {
        leftServo.setPower(STOP);
        rightServo.setPower(STOP);
    }

    public void moveToDownPosition() {
        leftServo.setPower(REVERSE);
        rightServo.setPower(REVERSE);
    }

    public void moveToUpPosition() {
        leftServo.setPower(FORWARD);
        rightServo.setPower(FORWARD);
    }

    public void stopVerticalMovement() {
        leftServo.setPower(STOP);
        rightServo.setPower(STOP);
    }

    public void incrementVerticalPosition() {
        leftServo.setPower(leftServo.getPower() + VERTICAL_INCREMENT);
        rightServo.setPower(rightServo.getPower() + VERTICAL_INCREMENT);
    }

    public void decrementVerticalPosition() {
        leftServo.setPower(leftServo.getPower() - VERTICAL_INCREMENT);
        rightServo.setPower(rightServo.getPower() - VERTICAL_INCREMENT);
    }
}
