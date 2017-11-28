package org.firstinspires.ftc.teamcode.opmodes.autonomous.Blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;

import org.firstinspires.ftc.teamcode.HardwarePushbot;
import org.firstinspires.ftc.teamcode.opmodes.modes.SafetyZone_LONG;

/**
 * Created by ryankoo on 9/19/17.
 */

@Autonomous(name = "blueLong", group = "robot")
public class BilAutoBlue1 extends LinearOpMode {

    private Movement movement;
    private Hardware hardware;
    private HardwarePushbot robot;
    private LinearOpMode ctx;

    public SafetyZone_LONG safetyZone;

    @Override
    public void runOpMode() {


        safetyZone = new SafetyZone_LONG(hardware,movement,robot,ctx);

        telemetry.addData("Status", "Ready to start");
        telemetry.update();

        waitForStart();

        sleep(2000);
        // Makes sure claw doesn't open at init
        robot.init(hardwareMap);

        safetyZone.run(); // move robot to safety zone

    }
}

