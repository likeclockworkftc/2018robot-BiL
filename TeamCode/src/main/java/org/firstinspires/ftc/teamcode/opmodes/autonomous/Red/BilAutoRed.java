package org.firstinspires.ftc.teamcode.opmodes.autonomous.Red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;

import org.firstinspires.ftc.teamcode.HardwarePushbot;
import org.firstinspires.ftc.teamcode.opmodes.modes.SafetyZone_SHORT;

/**
 * Created by ryankoo on 9/19/17.
 */

@Autonomous(name = "BilAutoRed0", group = "robot")
public class BilAutoRed extends LinearOpMode {

    private Movement movement;
    private Hardware hardware;
    private HardwarePushbot robot;
    private LinearOpMode ctx;

    public SafetyZone_SHORT safetyZone;


    @Override
    public void runOpMode() {

            robot.init(hardwareMap);
            safetyZone = new SafetyZone_SHORT(hardware, movement, robot, ctx);

            telemetry.addData("Status", "Ready to start");
            telemetry.update();

            waitForStart();

            safetyZone.run();

    }
}

