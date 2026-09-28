package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(name="Drive2", group="Controlled")
@Disabled
public class mainDrive extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    //pre init
    //motors
    DcMotorEx FrontLeftmotor;
    DcMotorEx FrontRightmotor;
    DcMotorEx BackLeftmotor;
    DcMotorEx BackRightmotor;
//    DcMotorEx Intake1;
//    DcMotorEx Intake2;

    //Servos

//    Servo Servo1;
//    double servoPosition = 0.0;
//    Servo Servo2;
//    double ServoPosition = 0.0;
//
//    Servo Servo3;
//    double Servo_Position = 0.0;
//    Servo Servo4;
//    double ServoPosition_;


    //speed variables
    double TurnSpeed = 1;
    double drivespeed = 1.2;


    //servo positions

    public void runOpMode() {

        //getting motors
        BackLeftmotor = hardwareMap.get(DcMotorEx.class, "BLmotor");
        FrontLeftmotor = hardwareMap.get(DcMotorEx.class, "FLmotor");
        BackRightmotor = hardwareMap.get(DcMotorEx.class, "BRmotor");
        FrontRightmotor = hardwareMap.get(DcMotorEx.class, "FRmotor");
//        Intake1 = hardwareMap.get(DcMotorEx.class,"Intake1");
//        Intake2 = hardwareMap.get(DcMotorEx.class,"Intake2");


        BackRightmotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        FrontLeftmotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BackRightmotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        FrontRightmotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//        Intake2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //motor directions
        BackLeftmotor.setDirection(DcMotorEx.Direction.REVERSE);
        FrontLeftmotor.setDirection(DcMotorEx.Direction.REVERSE);
        BackRightmotor.setDirection(DcMotorEx.Direction.REVERSE);
        FrontRightmotor.setDirection(DcMotorEx.Direction.REVERSE);
//        Intake1.setDirection(DcMotor.Direction.FORWARD);
//        Intake2.setDirection(DcMotor.Direction.FORWARD);


        //getting servos
//        Servo1 = hardwareMap.get(Servo.class, "Servo1");
//        Servo2 = hardwareMap.get(Servo.class, "Servo2");
//        Servo3 = hardwareMap.get(Servo.class, "Servo3");
//        Servo4 = hardwareMap.get(Servo.class, "Servo4");
//
//        //servo directions
//        // Servo1.setDirection(Servo.Direction.REVERSE);
//        Servo1.setDirection(Servo.Direction.FORWARD);
//        Servo2.setDirection(Servo.Direction.REVERSE);
//        Servo3.setDirection(Servo.Direction.FORWARD);
//        Servo4.setDirection(Servo.Direction.REVERSE);


        waitForStart();
        runtime.reset();


        while (opModeIsActive()) {
            double drive = gamepad1.left_stick_y; // Forward/reverse
            double strafe = gamepad1.left_stick_x; // Left/right

            // Calculate power for each wheel
            double frontLeftPower = ((gamepad1.right_trigger - gamepad1.left_trigger) * TurnSpeed) - (drive - strafe)*(drivespeed);
            double frontRightPower = ((gamepad1.right_trigger - gamepad1.left_trigger) * TurnSpeed) + (drive + strafe)*(drivespeed);
            double backLeftPower = ((gamepad1.right_trigger - gamepad1.left_trigger) * TurnSpeed) - (drive + strafe)*(drivespeed);
            double backRightPower = ((gamepad1.right_trigger - gamepad1.left_trigger) * TurnSpeed) + (drive - strafe)*(drivespeed);

            // Normalize the power values to ensure they are within range
            double maxPower = Math.max(Math.abs(frontLeftPower), Math.max(Math.abs(frontRightPower),
                    Math.max(Math.abs(backLeftPower), Math.abs(backRightPower))));

            if (maxPower > 1.0) {
                frontLeftPower /= maxPower;
                frontRightPower /= maxPower;
                backLeftPower /= maxPower;
                backRightPower /= maxPower;
            }

            FrontLeftmotor.setPower(frontLeftPower);
            FrontRightmotor.setPower(frontRightPower);
            BackLeftmotor.setPower(backLeftPower);
            BackRightmotor.setPower(backRightPower);



            //drive
//            BackLeftmotor.setPower(((gamepad1.right_trigger - gamepad1.left_trigger) * TurnSpeed) - (gamepad1.left_stick_y + gamepad1.right_stick_x)*(drivespeed));
//            FrontLeftmotor.setPower(((gamepad1.right_trigger - gamepad1.left_trigger) * TurnSpeed) - (gamepad1.left_stick_y - gamepad1.right_stick_x)*(drivespeed));
//            BackRightmotor.setPower(((gamepad1.right_trigger - gamepad1.left_trigger) * TurnSpeed) + (gamepad1.left_stick_y - gamepad1.right_stick_x)*(drivespeed));
//            FrontRightmotor.setPower(((gamepad1.right_trigger - gamepad1.left_trigger) * TurnSpeed) + (gamepad1.left_stick_y + gamepad1.right_stick_x)*(drivespeed));
            //end of drive

            // Add a small delay to help with control responsiveness
            sleep(10);
        }
    }

}

