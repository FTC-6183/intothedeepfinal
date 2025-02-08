package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class TimeBasedAuto extends LinearOpMode {
    private DcMotorEx backLeft;
    private DcMotorEx frontRight;
    private DcMotorEx backRight;
    private DcMotorEx frontLeft;

    @Override
    public void runOpMode() throws InterruptedException {

        backLeft = (DcMotorEx) hardwareMap.dcMotor.get("bl");
        frontRight = (DcMotorEx) hardwareMap.dcMotor.get("fr");
        backRight = (DcMotorEx) hardwareMap.dcMotor.get("br");
        frontLeft = (DcMotorEx) hardwareMap.dcMotor.get("fl");

        backLeft.setDirection(DcMotorEx.Direction.REVERSE);
        frontLeft.setDirection(DcMotorEx.Direction.REVERSE);
        frontRight.setDirection(DcMotorEx.Direction.REVERSE);

        waitForStart();
        if(isStopRequested()) {return;}

        backLeft.setPower(0.1);
        frontRight.setPower(0.1);
        backRight.setPower(0.1);
        frontLeft.setPower(0.1);

        sleep(2000);





    }




}
