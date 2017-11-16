package org.firstinspires.ftc.teamcode.Blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;
import com.vvftc.ninevolt.util.ExceptionHandling;

import org.firstinspires.ftc.teamcode.HardwarePushbot;

/**
 * Created by ryankoo on 9/19/17.
 */

@Autonomous(name = "BilAutoBlue0", group = "robot")
public class BilAutoBlue extends LinearOpMode {

    private Movement movement;
    private Hardware hardware;

    private HardwarePushbot robot = new HardwarePushbot();
    private ElapsedTime runtime = new ElapsedTime();


    private double FORWARD_SPEED = 0.35;
    private double TURN_SPEED = 0.30;
    private double BACKWARDS_SPEED = -0.37;

    private double clawOffset = 1;

    private double ARM_UP_POWER = -0.35;
    private double ARM_DOWN_POWER = 0.35;

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

                // close claws
                clawOffset = Range.clip(clawOffset, -0.5, 0.5);

                // Move Arm up
                robot.leftArm.setPower(ARM_UP_POWER);
                robot.rightArm.setPower(ARM_UP_POWER);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                // 1:  Move Forward
                movement.directTankDrive(FORWARD_SPEED, FORWARD_SPEED);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.5)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                // 2: Turn
                movement.directTankDrive(-TURN_SPEED, TURN_SPEED);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                // 3: Move forward SLIGHTLY
                movement.directTankDrive(FORWARD_SPEED, FORWARD_SPEED);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 0.35)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                // Move arm down, claw releases crypto block
                robot.leftArm.setPower(ARM_DOWN_POWER);
                robot.rightArm.setPower(ARM_DOWN_POWER);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                telemetry.addData("Status", "Complete");
                telemetry.update();

                idle();

            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

