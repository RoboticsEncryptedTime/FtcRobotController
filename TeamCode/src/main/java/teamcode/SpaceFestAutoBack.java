package teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;




@Autonomous(name="SpaceFestAutoBack", group="LinearOpMode")
public class SpaceFestAutoBack extends LinearOpMode {

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
            sleep(2000); // controls how long you want it to run

            FLmotor.setPower(0);
            BLmotor.setPower(0);
            FRmotor.setPower(0);
            BRmotor.setPower(0);
            sleep(1000); // controls how long you want it to run


            TopLauncherMotor.setPower(1);
            BottomLauncherMotor.setPower(-.75);
            sleep(6000);
            intakeMotor.setPower(1);
            midtakeMotor.setPower(1);

            sleep(6000);



        }
    }
}