package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;
import com.vvftc.ninevolt.util.ExceptionHandling;

/**
 * Created by ryankoo on 9/19/17.
 */

@Autonomous(name = "BilAuto", group = "robot")
public class BilAutonomous extends LinearOpMode {

    private Movement movement;
    private Hardware hardware;

    private ElapsedTime runtime = new ElapsedTime();

    private double FORWARD_SPEED = 0.5;
    private double BACKWARDS_SPEED = 0.5;

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

        telemetry.addData("Status", "Ready to start");
        telemetry.update();

        // Press start to play
        waitForStart();

        // Robot runs on time and power, hope for the best xd

        // Movement ( TIME AND POWER TO BE DETERMINED )
        // 1:  Stop and turn right 90 degrees
        movement.directTankDrive(FORWARD_SPEED, 0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() == 3.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
<<<<<<< Updated upstream
        }
            // 2: Stop and turn right 90 degrees
        movement.directTankDrive(0, FORWARD_SPEED);
        runtime.reset();
        while(opModeIsActive() && (runtime.seconds() == 3.0)) {
=======
            // 2: Stop and turn left 90 degrees
            movement.directTankDrive(0, FORWARD_SPEED);
>>>>>>> Stashed changes
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        // 3: Forward for [enter number here] seconds
        movement.directTankDrive(FORWARD_SPEED, FORWARD_SPEED);
<<<<<<< Updated upstream
        runtime.reset();
        while(opModeIsActive() && (runtime.seconds() == 2)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        idle();

=======
        telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
        telemetry.update();
// Movemnt
>>>>>>> Stashed changes
    }
}

