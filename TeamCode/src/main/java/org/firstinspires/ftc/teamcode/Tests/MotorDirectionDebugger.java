package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(group = "tests&tuning")
public class MotorDirectionDebugger extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("fl");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("fr");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("bl");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("br");
        // frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addLine("Press play to begin the debugging opmode");
            telemetry.update();
            waitForStart();
            if (isStopRequested()) return;
            telemetry.clearAll();
            telemetry.setDisplayFormat(Telemetry.DisplayFormat.HTML);
            while (!isStopRequested()) {
                telemetry.addLine("Press each button to turn on its respective motor");
                telemetry.addLine();
                telemetry.addLine("<font face=\"monospace\">Xbox/PS4 Button - Motor</font>");
                telemetry.addLine("<font face=\"monospace\">&nbsp;&nbsp;X / ▢&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Front Left</font>");
                telemetry.addLine("<font face=\"monospace\">&nbsp;&nbsp;Y / Δ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Front Right</font>");
                telemetry.addLine("<font face=\"monospace\">&nbsp;&nbsp;B / O&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Rear&nbsp;&nbsp;Right</font>");
                telemetry.addLine("<font face=\"monospace\">&nbsp;&nbsp;A / X&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Rear&nbsp;&nbsp;Left</font>");
                telemetry.addLine();

                if (gamepad1.x) {
                    frontLeftMotor.setPower(.3);
                    frontRightMotor.setPower(0);
                    backRightMotor.setPower(0);
                    backLeftMotor.setPower(0);
                    telemetry.addLine("Running Motor: Front Left");
                } else if (gamepad1.y) {
                    frontRightMotor.setPower(.3);
                    frontLeftMotor.setPower(0);
                    backRightMotor.setPower(0);
                    backLeftMotor.setPower(0);

                    telemetry.addLine("Running Motor: Front Right");
                } else if (gamepad1.b) {
                    backRightMotor.setPower(.3);
                    frontLeftMotor.setPower(0);
                    frontRightMotor.setPower(0);
                    backLeftMotor.setPower(0);

                    telemetry.addLine("Running Motor: Rear Right");

                } else if (gamepad1.a) {
                    backLeftMotor.setPower(.3);
                    frontLeftMotor.setPower(0);
                    frontRightMotor.setPower(0);
                    backRightMotor.setPower(0);
                    telemetry.addLine("Running Motor: Rear Left");
                } else {
                    frontLeftMotor.setPower(0);
                    frontRightMotor.setPower(0);
                    backRightMotor.setPower(0);
                    backLeftMotor.setPower(0);
                    telemetry.addLine("Running Motor: None");
                }

                telemetry.update();
            }

        }
    }
}