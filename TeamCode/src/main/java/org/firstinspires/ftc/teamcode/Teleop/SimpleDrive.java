package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.SimpleMecanumDrive;

@TeleOp(group = "match")
public class SimpleDrive extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        SimpleMecanumDrive drive = new SimpleMecanumDrive(hardwareMap);
        waitForStart();

        if (isStopRequested()) return;

        while(opModeIsActive()) {
        drive.robotDrive(gamepad1.left_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
        }

    }
}
