package teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@Disabled
@Autonomous(name="Basic Auto", group="LinearOpMode")
public class AutonomousLaunch extends LinearOpMode {

    DcMotorEx TopLauncherMotor, BottomLauncherMotor, intakeMotor, midtakeMotor;


    @Override
    public void runOpMode() {
       // FLmotor = hardwareMap.get(DcMotorEx.class, "FLmotor");
        //FRmotor = hardwareMap.get(DcMotorEx.class, "FRmotor");
        //BLmotor = hardwareMap.get(DcMotorEx.class, "BLmotor");
        //BRmotor = hardwareMap.get(DcMotorEx.class,"BRmotor");
        TopLauncherMotor = hardwareMap.get(DcMotorEx.class, "TopLaunch");
        BottomLauncherMotor = hardwareMap.get(DcMotorEx.class, "BottomLaunch");
        intakeMotor = hardwareMap.get(DcMotorEx.class, "IntakeMotor");
        midtakeMotor = hardwareMap.get(DcMotorEx.class, "MidtakeMotor");

        // Initialize hardware, reverse motors if necessary
        //FLmotor.setDirection(DcMotorEx.Direction.FORWARD);
       // FRmotor.setDirection(DcMotorEx.Direction.FORWARD);
        //BLmotor.setDirection(DcMotorEx.Direction.FORWARD);
        //BRmotor.setDirection(DcMotorEx.Direction.FORWARD);
        intakeMotor.setDirection(DcMotorEx.Direction.FORWARD);
        BottomLauncherMotor.setDirection(DcMotorEx.Direction.REVERSE);
        TopLauncherMotor.setDirection(DcMotorEx.Direction.REVERSE);
        midtakeMotor.setDirection(DcMotorEx.Direction.REVERSE);

        waitForStart();

        if (opModeIsActive()) {
            // Drive forward at x power
           // FLmotor.setPower(1);
            //FRmotor.setPower(1);
          //  BLmotor.setPower(1);
           // BRmotor.setPower(1);
            TopLauncherMotor.setPower(1);
            BottomLauncherMotor.setPower(-0.73);
            sleep(1000);
            intakeMotor.setPower(1);
            midtakeMotor.setPower(1);


            sleep(10000); // controls how long you want it to run

            // Stop motors
            // FLmotor.setPower(0);
            //FRmotor.setPower(0);
        }
    }
}

