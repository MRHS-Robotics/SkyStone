package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="BE2019_TeleOp", group="Iterative Opmode")
public class BE2019_TeleOp extends OpMode
{
    private double power = 1;
    private double direction = 1;
    private double lowPower = 0.25;
    private double highPower = 1;
    private boolean xButtonHeld = false;
    private boolean yButtonHeld = false;


    RobotHardware robot = new RobotHardware();

    public void init() {
        telemetry.addData("Status", "BE2019 TeleOp Initialized");
        robot.init(hardwareMap);

    }

    public void loop() {

        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;

        ////          Driving         ////

        // Slow Down
        if (gamepad1.x) {
            if (!xButtonHeld) {
                if (power == highPower) {
                    power = lowPower;
                }
                else {
                    power = highPower;
                }
                xButtonHeld = true;
            }
        }
        else {
            xButtonHeld = false;
        }

        // Direction Change
        if (gamepad1.y) {
            if (!yButtonHeld) {
                direction *= -1;
            }
            yButtonHeld = true;
        }
        else {
            yButtonHeld = false;
        }



        // Driving Power
        robot.leftFront.setPower((y + (x * direction)) * power);
        robot.rightFront.setPower(((-y * direction) + x) * power);
        robot.leftBack.setPower(((-y * direction) + x) * power);
        robot.rightBack.setPower((y + (x * direction)) * power);

        // Spinning
        if (gamepad1.left_bumper){
            //Britta -1, 1, -1, 1
            robot.leftFront.setPower(1 * power);
            robot.rightFront.setPower(-1* power);
            robot.leftBack.setPower(1 * power);
            robot.rightBack.setPower(-1 * power);
        }
        else if (gamepad1.right_bumper){
            //Britta 1,-1,1,-1
            robot.leftFront.setPower(-1 * power);
            robot.rightFront.setPower(1* power);
            robot.leftBack.setPower(-1 * power);
            robot.rightBack.setPower(1 * power);
        }

        // Linear Slide Motor //
        //Britta if (up){}else if(down){}
        if (gamepad1.dpad_up){
            robot.armSlide.setPower(-0.5*power);
        }else if(gamepad1.dpad_down){
            robot.armSlide.setPower(0.5*power);
        }
        else {
            robot.armSlide.setPower(0);
        }


        /// Intake Motor ///
        if (gamepad1.right_trigger > 0) {
            robot.intake.setPower(gamepad1.right_trigger);
        }
        else {
            robot.intake.setPower(-gamepad1.left_trigger);
        }


        // All For Telemetry //
        double righty = gamepad1.right_stick_y;
        double rightx = gamepad1.right_stick_x;
        double lefty = gamepad1.left_stick_y;
        double leftx = gamepad1.left_stick_x;

        telemetry.addData("Status", "BE2019 TeleOp Running");
        telemetry.addData("Joysticks", "Right Y:(%.2f), Right X:(%.2f), Left Y:(%.2f), Left X:(%.2f)", righty, rightx, lefty, leftx);
        telemetry.addData("Speed", "Power: (%.2f)", power);
        telemetry.addData("Y button", gamepad1.y);


    }

    /*@Override
    public void stop() {
    }*/
}
