package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
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



    }

    @Override
    public void loop() {
        movement.directDrive(gamepad1.left_stick_y, gamepad1.left_stick_x);


    }


}
