package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;
import com.vvftc.ninevolt.util.ExceptionHandling;

/**
 * Created by ryankoo on 9/19/17.
 */

@Autonomous(name = "BilAuto", group = "robot")
public class BilAutonomous extends LinearOpMode {

    public Movement movement;
    public Hardware hardware;


    @Override
    public void runOpMode() throws InterruptedException {

        try {
            HardwareBuilder hb = new HardwareBuilder(hardwareMap);
            hb.setMotorConfig(Hardware.MotorMode.TWO_MOTORS, Hardware.MotorType.TETRIX_PITSCO)
                    .addMotorFL("motor_l")
                    .addMotorFR("motor_r");
            this.hardware = hb.build();
            hb = null;
            hardware.init();
            movement = new Movement(hardware, this);
            movement.setVerbose(true);
        } catch (Exception e) {
            ExceptionHandling.standardExceptionHandling(e, this);
        }

        telemetry.addData("Status", "Ready to rumble");
        telemetry.update();

        //Press start to play
        waitForStart();

        while (opModeIsActive() || isStopRequested()) {
            movement.directDrive(0, 0);



        }

    }
}
