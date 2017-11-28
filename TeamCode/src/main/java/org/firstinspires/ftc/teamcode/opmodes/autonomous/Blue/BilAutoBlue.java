package org.firstinspires.ftc.teamcode.opmodes.autonomous.Blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;

import org.firstinspires.ftc.teamcode.HardwarePushbot;
import org.firstinspires.ftc.teamcode.opmodes.modes.SafetyZone_LONG;
import org.firstinspires.ftc.teamcode.opmodes.modes.SafetyZone_SHORT;

/**
 * Created by ryankoo on 9/19/17.
 */

@Autonomous(name = "blueShort", group = "robot")
public class BilAutoBlue extends LinearOpMode {


    public SafetyZone_SHORT safetyZone;

    @Override
    public void runOpMode() {

        safetyZone = new SafetyZone_SHORT();

        telemetry.addData("Status", "Ready to start");
        telemetry.update();

        waitForStart();

        safetyZone.run();

    }
}

