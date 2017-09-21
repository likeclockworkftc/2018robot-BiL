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


/**
 * Created by ryankoo on 9/19/17.
 */

@TeleOp (name = "Bil", group = "robot")
public class BilTeleOp extends OpMode{

    private Hardware hardware;
    private Movement movement;

    private HardwareMap hwMap = null;
    private HardwareClaws robot = new HardwareClaws();

    private DcMotor arm = null;

    private Servo leftClaw = null;
    private Servo rightClaw = null;

    public double clawOffset =  0.5;
    public double clawSpeed = 0.01;


    @Override
    public void init() {
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
        } catch(Exception e) {
            ExceptionHandling.standardExceptionHandling(e, this);
        }


        leftClaw = hwMap.get(Servo.class, "left_hand");
        rightClaw = hwMap.get(Servo.class, "right_hand");
        leftClaw.setPosition(clawOffset);
        rightClaw.setPosition(clawOffset);
    }

    @Override
    public void loop() {
        //robot moves from person 1's controller
        movement.directDrive(gamepad1.left_stick_y, gamepad1.left_stick_x);


        //person 2 controls robots arms/claws
        if (gamepad2.b)
            clawOffset += clawSpeed;
        else if (gamepad2.x)
            clawOffset -= clawSpeed;

        clawOffset = Range.clip(clawOffset, -0.5, 0.5);
        robot.leftClaw.setPosition(robot.MID_SERVO + clawOffset);
        robot.rightClaw.setPosition(robot.MID_SERVO - clawOffset);

        if (gamepad2.y)
            robot.Arm.setPower(robot.ARM_UP_POWER);
        else if (gamepad2.a)
            robot.Arm.setPower(robot.ARM_DOWN_POWER);
        else
            robot.Arm.setPower(0.0);
    }
}
