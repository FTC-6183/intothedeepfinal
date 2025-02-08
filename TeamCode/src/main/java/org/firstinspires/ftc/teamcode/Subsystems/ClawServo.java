package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ClawServo extends SubsystemBase {
    private Servo topServo;
    private Servo leftServo;
    private Servo rightServo;
    private static final double SERVO_RANGE = 355;
    private static final double OPEN_POSITION = 0.0;
    private static final double START_POSITION = 0.5;
    private static final double MAX_POSITION = 1.0;
    private static final double MIN_POSITION = 0.0;
    private static final double ROTATION_INCREMENT = 45.0 / SERVO_RANGE; // 45 degrees in servo range
    private static final double VERTICAL_INCREMENT = 10.0 / SERVO_RANGE; // 10 degrees in servo range
    private static final double DOWN_POSITION = 0.25; // Less than start position
    private static final double UP_POSITION = START_POSITION; // Reset to start position

    private double leftServoPosition;
    private double rightServoPosition;
    private double topServoPosition;

    public ClawServo(HardwareMap hardwareMap) {
        topServo = hardwareMap.get(Servo.class, "top");
        leftServo = hardwareMap.get(Servo.class, "left");
        rightServo = hardwareMap.get(Servo.class, "right");

        // Initialize servos to start position
        topServoPosition = OPEN_POSITION;
        leftServoPosition = START_POSITION;
        rightServoPosition = START_POSITION;
        topServo.setPosition(OPEN_POSITION);
        leftServo.setPosition(leftServoPosition);
        rightServo.setPosition(rightServoPosition);
    }

    public void openClaw() {
        topServo.setPosition(OPEN_POSITION);
    }

    public void closeClaw(double closedPosition) {
        topServo.setPosition(closedPosition);
    }

    public void incrementRotation() {
        if (leftServoPosition + ROTATION_INCREMENT <= MAX_POSITION && rightServoPosition - ROTATION_INCREMENT >= MIN_POSITION) {
            leftServoPosition += ROTATION_INCREMENT;
            rightServoPosition -= ROTATION_INCREMENT;
            leftServo.setPosition(leftServoPosition);
            rightServo.setPosition(rightServoPosition);
        } else {
            decrementRotation();
        }
    }

    public void decrementRotation() {
        if (leftServoPosition - ROTATION_INCREMENT >= MIN_POSITION && rightServoPosition + ROTATION_INCREMENT <= MAX_POSITION) {
            leftServoPosition -= ROTATION_INCREMENT;
            rightServoPosition += ROTATION_INCREMENT;
            leftServo.setPosition(leftServoPosition);
            rightServo.setPosition(rightServoPosition);
        } else {
            incrementRotation();
        }
    }


    public void moveToDownPosition() {
        leftServo.setPosition(DOWN_POSITION);
        rightServo.setPosition(DOWN_POSITION);
    }

    public void moveToUpPosition() {
        leftServo.setPosition(UP_POSITION);
        rightServo.setPosition(UP_POSITION);
    }

    public void incrementVerticalPosition() {
        if (leftServoPosition + VERTICAL_INCREMENT <= MAX_POSITION && rightServoPosition + VERTICAL_INCREMENT <= MAX_POSITION) {
            leftServoPosition += VERTICAL_INCREMENT;
            rightServoPosition += VERTICAL_INCREMENT;
            leftServo.setPosition(leftServoPosition);
            rightServo.setPosition(rightServoPosition);
        }
    }

    public void decrementVerticalPosition() {
        if (leftServoPosition - VERTICAL_INCREMENT >= MIN_POSITION && rightServoPosition - VERTICAL_INCREMENT >= MIN_POSITION) {
            leftServoPosition -= VERTICAL_INCREMENT;
            rightServoPosition -= VERTICAL_INCREMENT;
            leftServo.setPosition(leftServoPosition);
            rightServo.setPosition(rightServoPosition);
        }
    }
}