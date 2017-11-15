package org.firstinspires.ftc.teamcode.Red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;

import org.firstinspires.ftc.teamcode.HardwarePushbot;

/**
 * Created by ryankoo on 9/19/17.
 */

@Autonomous(name = "Bil Auto Blue Alliance1", group = "robot")
public class BilAutoRed extends LinearOpMode {

    private Movement movement;
    private Hardware hardware;

    private HardwarePushbot robot = new HardwarePushbot();

    private ElapsedTime runtime = new ElapsedTime();

    private double FORWARD_SPEED = 0.38;
    private double BACKWARDS_SPEED = -0.38;

    private double clawOffset = 1;

    private double ARM_UP_POWER = -0.35;

    private void autoinit() throws Exception {
        HardwareBuilder hb = new HardwareBuilder(hardwareMap);
        hb.setMotorConfig(Hardware.MotorMode.TWO_MOTORS, Hardware.MotorType.TETRIX_PITSCO)
                .addMotorFL("motor_l")
                .addMotorFR("motor_r");
        this.hardware = hb.build();
        hb = null;
        hardware.init();
        robot.init(hardwareMap);
        movement = new Movement(hardware, this);
        movement.setVerbose(true);
    }


    @Override
    public void runOpMode() {

        try {
            autoinit();

            telemetry.addData("Status", "Ready to start");
            telemetry.update();

            waitForStart();

            if (opModeIsActive()) {
                // Robot runs on time and power, hope for the best xd

                clawOffset = Range.clip(clawOffset, -0.5, 0.5);

                robot.leftArm.setPower(ARM_UP_POWER);
                robot.rightArm.setPower(ARM_UP_POWER);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                // Movement ( TIME AND POWER TO BE DETERMINED )
                // 1:  Stop and turn right 90 degrees
                movement.directTankDrive(FORWARD_SPEED, -FORWARD_SPEED);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                movement.directTankDrive(FORWARD_SPEED, FORWARD_SPEED);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.5)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                // 2: Stop and turn right 90 degrees
                movement.directTankDrive(-FORWARD_SPEED, FORWARD_SPEED);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 2.0)) {
                    // 2: Stop and turn left 90 degrees
                    movement.directTankDrive(0, FORWARD_SPEED);
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                // 3: Forward for [enter number here] seconds
                movement.directTankDrive(BACKWARDS_SPEED, BACKWARDS_SPEED);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

//                movement.directTankDrive(FORWARD_SPEED, -FORWARD_SPEED);
//                runtime.reset();
//                while (opModeIsActive() && (runtime.seconds() < 3.0)) {
//                    // 2: Stop and turn left 90 degrees
//                    movement.directTankDrive(0, FORWARD_SPEED);
//                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
//                    telemetry.update();
//                }


                idle();

            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

