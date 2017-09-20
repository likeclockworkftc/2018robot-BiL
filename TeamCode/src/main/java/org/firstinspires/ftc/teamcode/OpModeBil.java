package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by ryankoo on 9/19/17.
 */

@TeleOp(name = "Bil", group = "Robot")
public class OpModeBil extends OpMode {

    private DcMotor leftWheel;
    private DcMotor rightWheel;

    private Servo forkLift;

    double leftPower;
    double rightPower;

    double moveForward = leftPower + rightPower;

    @Override
    public void init() {
        leftWheel = hardwareMap.dcMotor.get("");
        rightWheel = hardwareMap.dcMotor.get("right_wheel");
        forkLift.equals(hardwareMap.dcMotor.get(""));



    }

    @Override
    public void loop() {
        leftPower = gamepad1.left_stick_y;
        rightPower = gamepad1.left_stick_x;

        moveForward = gamepad1.right_stick_y;


    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {

    }


}
