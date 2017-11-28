package org.firstinspires.ftc.teamcode.opmodes.autonomous.Blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.opmodes.modes.SafetyZone_LONG;

/**
 * Created by ryankoo on 9/19/17.
 */

@Autonomous(name = "BilAutoBlue1", group = "robot")
public class BilAutoBlue1 extends LinearOpMode {

    public SafetyZone_LONG safetyZone;

    @Override
    public void runOpMode() {

        safetyZone = new SafetyZone_LONG();
        telemetry.addData("Status", "Ready to start");
        telemetry.update();

        waitForStart();


        sleep(2000);

        safetyZone.run(); // move robot to safety zone

    }
}

