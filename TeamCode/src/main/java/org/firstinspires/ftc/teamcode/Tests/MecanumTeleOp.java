package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class MecanumTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Declare our motors
        // Make sure your ID's match your configuration
        DcMotorEx frontLeftMotor = (DcMotorEx) hardwareMap.dcMotor.get("fl");
        DcMotorEx backLeftMotor = (DcMotorEx) hardwareMap.dcMotor.get("bl");
        DcMotorEx frontRightMotor = (DcMotorEx) hardwareMap.dcMotor.get("fr");
        DcMotorEx backRightMotor = (DcMotorEx) hardwareMap.dcMotor.get("br");

        //  DcMotorEx armMotor = (DcMotorEx) hardwareMap.dcMotor.get("arm");
        //  DcMotorEx slideMotor = (DcMotorEx) hardwareMap.dcMotor.get("slide");

        //  Servo claw = hardwareMap.servo.get("claw");
        //  armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //  slideMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        // backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);




        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {


     /*       if(gamepad1.y) {

                armMotor.setPower(1);

            }

            else if(gamepad1.a) {
                armMotor.setPower(-1);
            }
            else
            {

                armMotor.setPower(0);
            }

            if(gamepad1.x) {

                slideMotor.setPower(1);
            }

            else if (gamepad1.b){

                slideMotor.setPower(-1);
            }


            if(gamepad1.right_bumper) {
                claw.setPosition(.1);
            }
            else if(gamepad1.left_bumper) {
                claw.setPosition(1);

            }

            */
            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), .25);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y + x - rx) / denominator;
            double backRightPower = (y - x - rx) / denominator;

            telemetry.addData("Left stick X", x);
            telemetry.addData("Front Left Power", frontLeftPower);
            telemetry.addData("Back Left Power", backLeftPower);

            telemetry.addData("Front Right Power", frontRightPower);
            telemetry.addData("Back Right Power", backRightPower);

            telemetry.update();
            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);
        }
    }
}
