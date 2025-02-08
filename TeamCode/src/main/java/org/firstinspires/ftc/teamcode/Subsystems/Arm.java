package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.HashMap;
import java.util.Map;

public class Arm extends SubsystemBase {
    private PIDController rotateController;
    private PIDController extendController;

    public static double rotateP = 0.004, rotateI = 0, rotateD = 0;
    public static double extendP = 0.04, extendI = 0, extendD = 0;

    public static double feedforward = 0;

    public static int rotateTarget = 0;
    public static int extendTarget = 0;

    private final double ticks_in_degree = 145.1/360; //might be wrong idek

    private DcMotorEx rotateMotor1;
    private DcMotorEx rotateMotor2;
    private DcMotorEx extendMotor1;
    private DcMotorEx extendMotor2;

    public enum ARM_ROTATE_POSITION  {
        INTAKE_CLIP,
            INTAKE,
        LOW_BUCKET,
        HIGH_RUNG_START,
        HIGH_RUNG
    }
    public enum ARM_EXTEND_POSITION {
        INTAKE_CLIP,
        INTAKE,
        LOW_BUCKET,
        HIGH_RUNG_START,
        HIGH_RUNG
    }

    private Map<ARM_ROTATE_POSITION, Integer> rotatePositions =
            new HashMap<>(Map.of(
                    ARM_ROTATE_POSITION.INTAKE_CLIP, 535,
                    ARM_ROTATE_POSITION.INTAKE, 800,
                    ARM_ROTATE_POSITION.LOW_BUCKET, -1015,
                    ARM_ROTATE_POSITION.HIGH_RUNG_START, -750,
                    ARM_ROTATE_POSITION.HIGH_RUNG, -750
            ));
    private HashMap<ARM_EXTEND_POSITION, Integer> extendPositions = new HashMap<>(
            Map.of(
                    ARM_EXTEND_POSITION.INTAKE_CLIP, 500,
                    ARM_EXTEND_POSITION.INTAKE, 500,
                    ARM_EXTEND_POSITION.LOW_BUCKET, 600,
                    ARM_EXTEND_POSITION.HIGH_RUNG_START, 700,
                    ARM_EXTEND_POSITION.HIGH_RUNG, 300
            )
    );


    public Arm(HardwareMap hardwareMap) {
        rotateController = new PIDController(rotateP, rotateI, rotateD);
        extendController = new PIDController(extendP, extendI, extendD);

        rotateMotor1 = hardwareMap.get(DcMotorEx.class, "rotate1");
        rotateMotor2 = hardwareMap.get(DcMotorEx.class, "rotate2");
        extendMotor1 = hardwareMap.get(DcMotorEx.class, "extend1");
        extendMotor2 = hardwareMap.get(DcMotorEx.class, "extend2");

        rotateMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rotateMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extendMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extendMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        rotateMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rotateMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extendMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extendMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    public void setRotatePosition(ARM_ROTATE_POSITION position) {
        rotateTarget = rotatePositions.get(position);
    }
    public void setExtendPosition(ARM_EXTEND_POSITION position) {
        extendTarget = extendPositions.get(position);
    }

    public void manuallySetTarget(int rotateTarget, int extendTarget) {
        this.rotateTarget = rotateTarget;
        this.extendTarget = extendTarget;
    }


    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        int rotatePosition = rotateMotor1.getCurrentPosition();
        int extendPosition = extendMotor1.getCurrentPosition();

        double rotatePower = rotateController.calculate(rotatePosition, rotateTarget);
        double extendPower = extendController.calculate(extendPosition, extendTarget);
    //    double feedforwardPower = Math.cos(Math.toRadians(rotateTarget * ticks_in_degree)) * feedforward;

    //    rotatePower += feedforwardPower;

        rotateMotor1.setPower(-rotatePower);
        rotateMotor2.setPower(-rotatePower);
        extendMotor1.setPower(extendPower);
        extendMotor2.setPower(extendPower);

    }




}
