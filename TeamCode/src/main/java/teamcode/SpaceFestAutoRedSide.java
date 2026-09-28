//created by Gagoo
//This is the autonomous program for the season decode


package teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@Autonomous(name="SpaceFestAutoRedSide", group="LinearOpMode")
public class SpaceFestAutoRedSide extends LinearOpMode {

    DcMotorEx FLmotor, FRmotor, BLmotor, BRmotor,TopLauncherMotor, BottomLauncherMotor, intakeMotor, midtakeMotor;


    @Override
    public void runOpMode() {
        FLmotor = hardwareMap.get(DcMotorEx.class, "FLmotor");
        FRmotor = hardwareMap.get(DcMotorEx.class, "FRmotor");
        BLmotor = hardwareMap.get(DcMotorEx.class, "BLmotor");
        BRmotor = hardwareMap.get(DcMotorEx.class, "BRmotor");
        TopLauncherMotor = hardwareMap.get(DcMotorEx.class, "TopLaunch");
        BottomLauncherMotor = hardwareMap.get(DcMotorEx.class, "BottomLaunch");
        intakeMotor = hardwareMap.get(DcMotorEx.class, "IntakeMotor");
        midtakeMotor = hardwareMap.get(DcMotorEx.class, "MidtakeMotor");


        // Initialize hardware, reverse motors if necessary
        FLmotor.setDirection(DcMotorEx.Direction.FORWARD);
        FRmotor.setDirection(DcMotorEx.Direction.FORWARD);
        BLmotor.setDirection(DcMotorEx.Direction.REVERSE);
        BRmotor.setDirection(DcMotorEx.Direction.REVERSE);
        intakeMotor.setDirection(DcMotorEx.Direction.FORWARD);
        BottomLauncherMotor.setDirection(DcMotorEx.Direction.REVERSE);
        TopLauncherMotor.setDirection(DcMotorEx.Direction.REVERSE);
        midtakeMotor.setDirection(DcMotorEx.Direction.REVERSE);


        waitForStart();

        if (opModeIsActive()) {
            // Drive forward at 50% power
            FLmotor.setPower(0.5);
            FRmotor.setPower(0.5);
            BLmotor.setPower(0.5);
            BRmotor.setPower(0.5);
            sleep(2850); // controls how long you want it to run

            FLmotor.setDirection(DcMotorEx.Direction.FORWARD);
            FRmotor.setDirection(DcMotorEx.Direction.FORWARD);
            BLmotor.setDirection(DcMotorEx.Direction.FORWARD);
            BRmotor.setDirection(DcMotorEx.Direction.FORWARD);

            FLmotor.setPower(-0.5);
            FRmotor.setPower(-0.5);
            BLmotor.setPower(-0.5);
            BRmotor.setPower(-0.5);
            sleep(500);

            FLmotor.setPower(0);
            FRmotor.setPower(0);
            BLmotor.setPower(0);
            BRmotor.setPower(0);
            sleep(500);

                                         //main system

            TopLauncherMotor.setPower(0.85);
            BottomLauncherMotor.setPower(-0.85);
            sleep(3000);
            intakeMotor.setPower(0.85);
            midtakeMotor.setPower(0.85);

            sleep(3000);




//.................................................
           /* FLmotor.setDirection(DcMotorEx.Direction.FORWARD);
            FRmotor.setDirection(DcMotorEx.Direction.FORWARD);
            BLmotor.setDirection(DcMotorEx.Direction.FORWARD);
            BRmotor.setDirection(DcMotorEx.Direction.FORWARD);

              FLmotor.setPower(0.5);
              FRmotor.setPower(0.5);
              BLmotor.setPower(0.5);
              BRmotor.setPower(0.5);
              sleep(1250);
                                                //This makes a 90 degree angle
            FLmotor.setPower(0);
            FRmotor.setPower(0);
            BLmotor.setPower(0);
            BRmotor.setPower(0);
            sleep(500);


//................................................
            FLmotor.setDirection(DcMotorEx.Direction.FORWARD);
            FRmotor.setDirection(DcMotorEx.Direction.FORWARD);
            BLmotor.setDirection(DcMotorEx.Direction.REVERSE);
            BRmotor.setDirection(DcMotorEx.Direction.REVERSE);

            //go right
            FLmotor.setPower(-0.5);
            BLmotor.setPower(-0.5);
            FRmotor.setPower(0.5);
            BRmotor.setPower(0.5);
            sleep(325);

            FLmotor.setPower(0);
            BLmotor.setPower(0);
            FRmotor.setPower(0);
            BRmotor.setPower(0);
            sleep(325);


            //back-up
            FLmotor.setPower(0.5);
            BLmotor.setPower(0.5);
            FRmotor.setPower(0.5);
            BRmotor.setPower(0.5);
            sleep(1000); //adjust as needed

            FLmotor.setPower(0);
            BLmotor.setPower(0);
            FRmotor.setPower(0);
            BRmotor.setPower(0);
            sleep(300);
            //turns on the intake and midtake motors
            intakeMotor.setPower(1);
            midtakeMotor.setPower(1);

//.....................................................
            //go forward
            FLmotor.setPower(-0.5);
            BLmotor.setPower(-0.5);
            FRmotor.setPower(-0.5);
            BRmotor.setPower(-0.5);
            sleep(1000); //adjust as needed

            //do a turn to face the goal
            FLmotor.setDirection(DcMotorEx.Direction.FORWARD);
            FRmotor.setDirection(DcMotorEx.Direction.FORWARD);
            BLmotor.setDirection(DcMotorEx.Direction.FORWARD);
            BRmotor.setDirection(DcMotorEx.Direction.FORWARD);

            FLmotor.setPower(-0.5);
            FRmotor.setPower(-0.5);
            BLmotor.setPower(-0.5);
            BRmotor.setPower(-0.5);
            sleep(1200); //adjust as needed

            FLmotor.setPower(0);
            FRmotor.setPower(0);
            BLmotor.setPower(0);
            BRmotor.setPower(0);
            sleep(300);
//.....................................................................
            //shoots the second batch of balls
            TopLauncherMotor.setPower(1);
            BottomLauncherMotor.setPower(-1);
            sleep(3000);
            intakeMotor.setPower(1);
            midtakeMotor.setPower(1);

            sleep(3000);


            */



        }
    }
}