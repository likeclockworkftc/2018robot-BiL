package org.firstinspires.ftc.teamcode.opmodes.autonomous.Blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.opmodes.modes.JewelColor;
import org.firstinspires.ftc.teamcode.opmodes.modes.SafetyZone;

/**
 * Created by ryankoo on 9/19/17.
 */

@Autonomous(name = "BilAutoBlue1", group = "robot")
public class BilAutoBlue1 extends LinearOpMode {

    public SafetyZone safetyZone = new SafetyZone();
    public JewelColor jewelColor = new JewelColor();

    @Override
    public void runOpMode() {



        safetyZone.runOpMode(); // move robot to safety zone

    }
}

