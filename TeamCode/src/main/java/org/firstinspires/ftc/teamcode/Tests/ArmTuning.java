package org.firstinspires.ftc.teamcode.Tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Config
@TeleOp(group = "tests&tuning")
public class ArmTuning extends LinearOpMode {
    private PIDController rotateController;
    private PIDController extendController;

    public static double rotateP = 0, rotateI = 0, rotateD = 0;
    public static double extendP = 0, extendI = 0, extendD = 0;

    public static double feedforward = 0;

    public static int rotateTarget = 0;
    public static int extendTarget = 0;

    private final double ticks_in_degree = 145.1/360; //might be wrong idek

    private DcMotorEx rotateMotor1;
    private DcMotorEx rotateMotor2;
    private DcMotorEx extendMotor1;
    private DcMotorEx extendMotor2;

    @Override
    public void runOpMode() throws InterruptedException {

        rotateController = new PIDController(rotateP, rotateI, rotateD);
        extendController = new PIDController(extendP, extendI, extendD);

        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        rotateMotor1 = hardwareMap.get(DcMotorEx.class, "rotate1");
        rotateMotor2 = hardwareMap.get(DcMotorEx.class, "rotate2");
        extendMotor1 = hardwareMap.get(DcMotorEx.class, "extend1");
        extendMotor2 = hardwareMap.get(DcMotorEx.class, "extend2");

        waitForStart();
        if(isStopRequested()) {return;}
        while(opModeIsActive()) {

            rotateController.setPID(rotateP, rotateI, rotateD);
            extendController.setPID(extendP, extendI, extendD);

            int rotatePosition = rotateMotor1.getCurrentPosition();
            int extendPosition = extendMotor1.getCurrentPosition();

            double rotatePower = rotateController.calculate(rotatePosition, rotateTarget);
            double extendPower = extendController.calculate(extendPosition, extendTarget);
            double feedforwardPower = Math.cos(Math.toRadians(rotateTarget * ticks_in_degree)) * feedforward;

            rotatePower += feedforwardPower;

            rotateMotor1.setPower(rotatePower);
            rotateMotor2.setPower(rotatePower);
            extendMotor1.setPower(extendPower);
            extendMotor2.setPower(extendPower);

            telemetry.addData("Rotate Position", rotatePosition);
            telemetry.addData("Extend Position", extendPosition);
            //target
            telemetry.addData("Rotate Target", rotateTarget);
            telemetry.addData("Extend Target", extendTarget);
            //power
            telemetry.addData("Rotate Power", rotatePower);
            telemetry.addData("Extend Power", extendPower);
            //feedforward
            telemetry.addData("Feedforward Power", feedforwardPower);
            telemetry.update();





        }

    }
}
