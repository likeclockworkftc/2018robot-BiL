package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;
import com.vvftc.ninevolt.util.ExceptionHandling;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;


/**
 * Created by ryankoo on 9/19/17.
 */

@TeleOp (name = "Bil", group = "robot")
public class BilTeleOp extends OpMode{

    private Hardware hardware;
    private Movement movement;

    private HardwareMap hwMap = null;
    HardwareClaws robot = new HardwareClaws();

    public double clawOffset =  0.5;
    public double CLAW_SPEED = 0.02;


    @Override
    public void init() {
        try {
            HardwareBuilder hb = new HardwareBuilder(hardwareMap);
            hb.setMotorConfig(Hardware.MotorMode.TWO_MOTORS, Hardware.MotorType.TETRIX_PITSCO)
                    .addMotorFL("motor_l")
                    .addMotorFR("motor_r");
            this.hardware = hb.build();
            hb = null;
            //initialize robot parts
            hardware.init();
            //initialize servos
            robot.init(hardwareMap);
            movement = new Movement(hardware, this);
            movement.setVerbose(true);
        } catch(Exception e) {
            ExceptionHandling.standardExceptionHandling(e, this);
        }

    }

    @Override
    public void loop() {
        //robot moves from person 1's controller

        //- = goes forward
        //+ = goes backwards


        movement.directTankDrive(gamepad1.left_stick_y, gamepad1.right_stick_y);



        //person 2 controls robots arms/claws

        // Use gamepad left & right Bumpers to open and close the claw
        if (gamepad2.right_bumper)
            clawOffset += CLAW_SPEED;
        else if (gamepad2.left_bumper)
            clawOffset -= CLAW_SPEED;

        // Move both servos to new position.  Assume servos are mirror image of each other.
        clawOffset = Range.clip(clawOffset, -0.5, 0.5);
        robot.leftClaw.setPosition(robot.MID_SERVO + clawOffset);
        robot.rightClaw.setPosition(robot.MID_SERVO - clawOffset);

//        if (gamepad2.y)
//            robot.Arm.setPower(robot.ARM_UP_POWER);
//        else if (gamepad2.a)
//            robot.Arm.setPower(robot.ARM_DOWN_POWER);
//        else
//            robot.Arm.setPower(0.0);
    }
}
