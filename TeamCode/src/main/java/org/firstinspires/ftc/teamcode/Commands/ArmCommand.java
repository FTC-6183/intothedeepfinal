package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Subsystems.Arm;

import java.util.function.BooleanSupplier;

public class ArmCommand extends CommandBase {

    private final Arm arm;

    private BooleanSupplier intake, lowBucket, lowRung, highRung;

    public ArmCommand(Arm arm, BooleanSupplier intake, BooleanSupplier lowBucket, BooleanSupplier lowRung, BooleanSupplier highRung) {
        this.arm = arm;
        this.intake = intake;
        this.lowBucket = lowBucket;
        this.lowRung = lowRung;
        this.highRung = highRung;
        addRequirements(arm);
    }

    @Override
    public void execute() {

        if (intake.getAsBoolean()) {
            arm.setRotatePosition(Arm.ARM_ROTATE_POSITION.INTAKE);
            arm.setExtendPosition(Arm.ARM_EXTEND_POSITION.INTAKE);
        } else if (lowBucket.getAsBoolean()) {
            arm.setRotatePosition(Arm.ARM_ROTATE_POSITION.LOW_BUCKET);
            arm.setExtendPosition(Arm.ARM_EXTEND_POSITION.LOW_BUCKET);
        } else if (lowRung.getAsBoolean()) {
            arm.setRotatePosition(Arm.ARM_ROTATE_POSITION.HIGH_RUNG_START);
            arm.setExtendPosition(Arm.ARM_EXTEND_POSITION.HIGH_RUNG_START);
        } else if (highRung.getAsBoolean()) {
            arm.setRotatePosition(Arm.ARM_ROTATE_POSITION.HIGH_RUNG);
            arm.setExtendPosition(Arm.ARM_EXTEND_POSITION.HIGH_RUNG);
        }
    }

}
