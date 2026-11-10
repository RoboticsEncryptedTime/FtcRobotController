package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import teamcode.mechanisms.AprilTagWebcam;

@TeleOp(name = "Drive1", group = "Controlled")
public class Drive1 extends OpMode {

    DcMotorEx FLmotor, FRmotor, BLmotor, BRmotor, TopLauncherMotor, BottomLauncherMotor, intakeMotor, midtakeMotor;
    static Servo autoTurret;
    double Servo_Position = 0.0;
    private DcMotorEx XrailL, XrailR;
    double TurnSpeed = -0.8;
    double drivespeed = .75;

//    double xrailspeed = .9

    boolean launch;
    boolean run;
    private boolean AprilTagDetection;


    public void init() {
        BLmotor = hardwareMap.get(DcMotorEx.class, "BLmotor");
        FLmotor = hardwareMap.get(DcMotorEx.class, "FLmotor");
        BRmotor = hardwareMap.get(DcMotorEx.class, "BRmotor");
        FRmotor = hardwareMap.get(DcMotorEx.class, "FRmotor");
        intakeMotor = hardwareMap.get(DcMotorEx.class, "IntakeMotor");
        BottomLauncherMotor = hardwareMap.get(DcMotorEx.class, "BottomLaunch");
        TopLauncherMotor = hardwareMap.get(DcMotorEx.class, "TopLaunch");
        midtakeMotor = hardwareMap.get(DcMotorEx.class, "MidtakeMotor");
        //XrailL = hardwareMap.get(DcMotorEx.class, "XrailL");
        //XrailR = hardwareMap.get(DcMotorEx.class, "XrailR");

        //making them brake
        BLmotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        FLmotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BRmotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        FRmotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        intakeMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BottomLauncherMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        TopLauncherMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        midtakeMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        //XrailR.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        //XrailL.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);


        //motor directions
        BLmotor.setDirection(DcMotorEx.Direction.FORWARD);
        FLmotor.setDirection(DcMotorEx.Direction.FORWARD);
        BRmotor.setDirection(DcMotorEx.Direction.FORWARD);
        FRmotor.setDirection(DcMotorEx.Direction.FORWARD);
        intakeMotor.setDirection(DcMotorEx.Direction.FORWARD);
        BottomLauncherMotor.setDirection(DcMotorEx.Direction.REVERSE);
        TopLauncherMotor.setDirection(DcMotorEx.Direction.REVERSE);
        midtakeMotor.setDirection(DcMotorEx.Direction.REVERSE);
        //XrailL.setDirection(DcMotorSimple.Direction.REVERSE);


        //getting servos
        autoTurret = hardwareMap.get(Servo.class, "autoTurret");
//        LeftClaw = hardwareMap.servo.get("LeftClaw");
//        LeftUp = hardwareMap.servo.get("LeftUp");
//        RightUp = hardwareMap.servo.get("RightUp");
//        sus = hardwareMap.servo.get("sus");


        //servo directions
//        ArmServ.setDirection(Servo.Direction.FORWARD);
//        LeftClaw.setDirection(Servo.Direction.FORWARD);
//        LeftUp.setDirection(Servo.Direction.FORWARD);
//        RightUp.setDirection(Servo.Direction.FORWARD);
//        sus.setDirection(Servo.Direction.FORWARD);
//
//
//        ClawUpint();
//        OpenClawL();
//        OpenClawR();
//        susint();

    }

    public void loop() {
        double drive = gamepad1.left_stick_y; // Forward/reverse
        double strafe = gamepad1.right_stick_x; // Left/right

        //Driving Controls
        if (gamepad1.right_bumper) {
            // Drive with strafing, forward/backward and turning
            BLmotor.setPower(((gamepad1.right_trigger - gamepad1.left_trigger) * (TurnSpeed / 2)) + (drive + strafe) * (drivespeed / 3));
            FLmotor.setPower(((gamepad1.right_trigger - gamepad1.left_trigger) * (TurnSpeed / 2)) - (drive + strafe) * (drivespeed / 3));
            BRmotor.setPower(((gamepad1.right_trigger - gamepad1.left_trigger) * (TurnSpeed / 2)) + (drive - strafe) * (drivespeed / 3));
            FRmotor.setPower(((gamepad1.right_trigger - gamepad1.left_trigger) * (TurnSpeed / 2)) - (drive - strafe) * (drivespeed / 3));
        } else {
            // Drive with strafing, forward/backward, and turning
            BLmotor.setPower(((gamepad1.right_trigger - gamepad1.left_trigger) * (TurnSpeed)) + (drive + strafe) * (drivespeed));
            FLmotor.setPower(((gamepad1.right_trigger - gamepad1.left_trigger) * (TurnSpeed)) - (drive + strafe) * (drivespeed));
            BRmotor.setPower(((gamepad1.right_trigger - gamepad1.left_trigger) * (TurnSpeed)) + (drive - strafe) * (drivespeed));
            FRmotor.setPower(((gamepad1.right_trigger - gamepad1.left_trigger) * (TurnSpeed)) - (drive - strafe) * (drivespeed));
        }


        if (gamepad2.right_bumper){
            //Run the launcher motors to launch the artifacts from close launch zone with right trigger
            if (gamepad2.right_trigger > 0.1) {
                BottomLauncherMotor.setPower(-0.93);
                TopLauncherMotor.setPower(1);
            } else {
                BottomLauncherMotor.setPower(0);
                TopLauncherMotor.setPower(0);
            }
        }
        else{
            //Run the launcher motors to launch the artifacts from far launch zone with right trigger
            if (gamepad2.right_trigger > 0.1) {
                BottomLauncherMotor.setPower(-0.73);
                TopLauncherMotor.setPower(1);
            } else {
                BottomLauncherMotor.setPower(0);
                TopLauncherMotor.setPower(0);
            }

        }

        //Find out rpm of motor
        double revolution_ticks = BottomLauncherMotor.getMotorType().getTicksPerRev();
        double vel = BottomLauncherMotor.getVelocity();
        double RPM = (vel * 60) / revolution_ticks;
        telemetry.addLine("RPM is " + RPM);

        telemetry.update();

//        if (RPM > 45.0 && gamepad2.right_trigger > 0.1) {
//            Push();
//            run = true;
//            telemetry.addLine("Servo Auto  " + run);
//
//            telemetry.update();
//        }
//
//        if (RPM < 40.0){
//            Pull();
//            run = false;
//            telemetry.addLine("Servo Auto  " + run);
//
//            telemetry.update();
//        }

        //Perform intake for robot
        if (gamepad2.yWasPressed()) {
            intakeMotor.setPower(intakeMotor.getPower() == 0 ? 0.9: 0);
            midtakeMotor.setPower(midtakeMotor.getPower() == 0 ? 0.6: 0);
        }
        if (gamepad1.right_bumper) {

        }

        //april tag stuff
        AprilTagWebcam aprilTagWebcam = new AprilTagWebcam();
            aprilTagWebcam.update();
        boolean autoenabler = false;
        //last direction drove left
        boolean lddl = false;
        //last direction drove right
        boolean lddr = false;

        //last direction turned left
        boolean ldtl = false;
        //last direction turned right
        boolean ldtr = false;

        //turn turret system I hope
        if (gamepad1.right_bumper) {
        ldtr = true;
        ldtl = false;
        }

        if (gamepad1.left_bumper) {
            ldtl = true;
            ldtr = false;
        }
        //need to test
        if (gamepad1.right_stick_x > 0){
            lddr = true;
            lddl = false;
        }
        //need to test
        if (gamepad1.right_stick_x < 0){
            lddl = true;
            lddr = false;
        }

        if (aprilTagWebcam.getDetectedTags() != null){
            autoenabler = true;
        }


            //red april tag ids(idk if these are correct ngl)
            int [] tagIdR = {0,1,2,3};
            //blue april tag ids (idk if these are correct ngl)
            int [] tagIdB = {42,43,44,45};
        //actually not quite sure what this does, but it might be needed
        AprilTagDetection id38 = aprilTagWebcam.getTagBySpecificId(38);
        AprilTagDetection id39 = aprilTagWebcam.getTagBySpecificId(39);
        AprilTagDetection id40 = aprilTagWebcam.getTagBySpecificId(40);
        AprilTagDetection id41 = aprilTagWebcam.getTagBySpecificId(41);
        AprilTagDetection id42 = aprilTagWebcam.getTagBySpecificId(42);
        AprilTagDetection id43 = aprilTagWebcam.getTagBySpecificId(43);
        AprilTagDetection id44 = aprilTagWebcam.getTagBySpecificId(44);
        AprilTagDetection id45 = aprilTagWebcam.getTagBySpecificId(45);
        //Simplifying red Ids
        AprilTagDetection id30 = aprilTagWebcam.getTagBySpecificId(30);
        AprilTagDetection id31 = aprilTagWebcam.getTagBySpecificId(31);
        AprilTagDetection id22 = aprilTagWebcam.getTagBySpecificId(32);
        AprilTagDetection id33 = aprilTagWebcam.getTagBySpecificId(33);
        AprilTagDetection id34 = aprilTagWebcam.getTagBySpecificId(34);
        AprilTagDetection id35 = aprilTagWebcam.getTagBySpecificId(35);
        AprilTagDetection id26 = aprilTagWebcam.getTagBySpecificId(36);
        AprilTagDetection id37 = aprilTagWebcam.getTagBySpecificId(37);

        //This is used so we can turn off the camera as a just incase
//        boolean tagcam = true;


        while (aprilTagWebcam.getDetectedTags() == null && autoenabler) {
            autoTurret.setPosition(Servo_Position);
            if ((ldtr) || (lddr))
            {
                Servo_Position -= 5;
            }
            if ((ldtl) || (lddl)){
                Servo_Position += 5;
        }







        /*if (  aprilTagWebcam.getDetectedTags().contains(id3) ) {
            /*use distance to correct direction
            ex,  if prev distance - current distance < 5{
            (prolly an if statment to decide which operation to use)
            direction -=/+= 0.1
            autoTurret.setdirection(direction)

            }

             */




        //Perform reverse intake for robot
        if (gamepad2.bWasPressed()) {
            intakeMotor.setPower(intakeMotor.getPower() == 0 ? -0.5: 0);
            midtakeMotor.setPower(midtakeMotor.getPower() == 0 ? -0.6: 0);
            }
        }
    }
}

/*        if (gamepad2.xWasPressed()) {
            ArmServ.setPosition(0.5);        }

        if (gamepad2.aWasPressed()) {
            ArmServ.setPosition(0.0);
        }



        bind the midtake motor to a button

        Test if the first test does not work
        XrailL.setPower(gamepad2.left_stick_y * xrailspeed);
       XrailR.setPower(gamepad2.left_stick_y * xrailspeed);


        //Claw UP and Down
        if (gamepad2.a) {
            ClawUp();
        }

        if (gamepad2.b){
            ClawMiddle();
        }
        if (gamepad2.y){
            ClawDown();
        }

        //OPEN/CLOSE Claw
        if (gamepad2.right_bumper) {
            CloseClawR();
            CloseClawL();
        } else {
            OpenClawR();
           OpenClawL();
        }

       if (gamepad1.b){
            sushang();
        }


        //Drone Shooter


        //Hanging Servo


        //MIGHT NOT WORK
    static void Push() {
        ArmServ.setPosition(0.5);
    }

    static void Pull() {
        ArmServ.setPosition(0.0);
   }

    //DONE
    static void CloseClawR(){
       LeftClaw.setPosition(0.05);
    }

    static void OpenClawL() {
        RightClaw.setPosition(.2);
    }
    //DONE
    static void OpenClawR(){
        LeftClaw.setPosition(.25);
    }

    static void ClawMiddle(){
       RightUp.setPosition(.45);
}


    static void ClawUp() {
        RightUp.setPosition(.78);}

   static void ClawDown() {
       RightUp.setPosition(0.12);
    }
    static void ClawUpint() {
       RightUp.setPosition(0.12);
    }

    static void susint(){
        sus.setPosition(0);
    }
   static void sushang(){
        sus.setPosition(.85);
    }

 */

