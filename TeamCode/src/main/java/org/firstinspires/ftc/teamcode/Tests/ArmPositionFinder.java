package org.firstinspires.ftc.teamcode.Tests;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Arm;


@Config
@TeleOp(group = "tests&tuning")
public class ArmPositionFinder extends LinearOpMode {
    Arm arm;

    public static int rotatePosition = 0;

    public static int extendPosition = 0;


    @Override
    public void runOpMode() throws InterruptedException {

        arm = new Arm(hardwareMap);
        waitForStart();

        if (isStopRequested()) return;

        while(opModeIsActive()) {

            arm.manuallySetTarget(rotatePosition, extendPosition);

            // Get arm position
        }

    }
}
