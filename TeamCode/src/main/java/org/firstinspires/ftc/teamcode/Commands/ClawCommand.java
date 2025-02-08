package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.ClawServo;
import org.firstinspires.ftc.teamcode.Tests.Claw;

import java.util.function.BooleanSupplier;

public class ClawCommand extends CommandBase {

    private final ClawServo claw;

    private  BooleanSupplier rotatePos45, rotateNeg45, openClaw, closeClaw, upPosition, downPosition; //get each of ur variables as Booleansupplier

    public ClawCommand(ClawServo claw, BooleanSupplier rotatePos45, BooleanSupplier rotateNeg45, BooleanSupplier openClaw, BooleanSupplier closeClaw, BooleanSupplier upPosition, BooleanSupplier downPosition) {
        this.claw = claw;
        this.rotatePos45 = rotatePos45;
        this.rotateNeg45 = rotateNeg45;
        this.openClaw = openClaw;
        this.closeClaw = closeClaw;
        this.upPosition = upPosition;
        this.downPosition = downPosition;
    }

    //fill out the thingy with each of the increments according to the BooleanSupplier stuff
    @Override
    public void execute() {
        if (rotatePos45.getAsBoolean()) {
            claw.incrementRotation();
        } else if (rotateNeg45.getAsBoolean()) {
            claw.decrementRotation();
        } else if (openClaw.getAsBoolean()) {
            claw.openClaw();
        } else if (closeClaw.getAsBoolean()) {
            claw.closeClaw(0.5);
        } else if (upPosition.getAsBoolean()) {
            claw.moveToUpPosition();
        } else if (downPosition.getAsBoolean()) {
            claw.moveToDownPosition();
        }
    }


}
