package org.firstinspires.ftc.teamcode.Teleop;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.UtilityOctoQuadConfigMenu;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.ArmCommand;
import org.firstinspires.ftc.teamcode.Commands.ClawCommand;
import org.firstinspires.ftc.teamcode.Commands.ManualDriveCommand;
import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.ClawServo;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.Tests.Claw;

import java.util.List;

@TeleOp
public class UIUC extends LinearOpMode {
    private MecanumDrive drive;
    private Arm arm;
    private ClawServo claw;

    private GamepadEx controller1;
    private GamepadEx controller2;

    private ElapsedTime time;

    Telemetry telemetry;

    @Override
    public void runOpMode() throws InterruptedException {

        drive = new MecanumDrive(hardwareMap);
        arm = new Arm(hardwareMap);
        claw = new ClawServo(hardwareMap);





        controller1 = new GamepadEx(gamepad1);
        controller2 = new GamepadEx(gamepad2);

        time = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);



        drive.setDefaultCommand(new ManualDriveCommand(
                drive,
                controller1::getLeftY,
                controller1::getRightX,
                controller1::getLeftX
        ));

        arm.setDefaultCommand(new ArmCommand(
                arm,
                () -> controller1.getButton(GamepadKeys.Button.B),
                () -> controller1.getButton(GamepadKeys.Button.A),
                () -> controller1.getButton(GamepadKeys.Button.X),
                () -> controller1.getButton(GamepadKeys.Button.Y),
                () -> controller1.getButton(GamepadKeys.Button.RIGHT_BUMPER)
        ));

        claw.setDefaultCommand(
                new ClawCommand(
                        claw,
                        () -> controller2.getButton(GamepadKeys.Button.LEFT_BUMPER),
                        () -> controller2.getButton(GamepadKeys.Button.RIGHT_BUMPER),
                        () -> controller2.getButton(GamepadKeys.Button.B),
                        () -> controller2.getButton(GamepadKeys.Button.A),
                        () -> controller2.getButton(GamepadKeys.Button.Y) ,
                        () -> controller2.getButton(GamepadKeys.Button.X)

                ));

//        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);
//
//        for (LynxModule hub : allHubs) {
//            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
//        }

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
//            for (LynxModule hub : allHubs) {
//                hub.clearBulkCache();
//            }


            time.reset();
            CommandScheduler.getInstance().run();
            arm.periodic();

            double loop = 1000/time.milliseconds();



           // telemetry.addData("Loop (hz)", loop);
          //  telemetry.update();

        }
    }

}