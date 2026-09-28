package teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;



@Disabled
@Autonomous(name="Basic Auto", group="LinearOpMode")
public class BasicAuto extends LinearOpMode {

    DcMotorEx FLmotor, FRmotor, BLmotor, BRmotor;


    @Override
    public void runOpMode() {
        FLmotor = hardwareMap.get(DcMotorEx.class, "FLmotor");
        FRmotor = hardwareMap.get(DcMotorEx.class, "FRmotor");
        BLmotor = hardwareMap.get(DcMotorEx.class, "BLmotor");
        BRmotor = hardwareMap.get(DcMotorEx.class,"BRmotor");

        // Initialize hardware, reverse motors if necessary
        FLmotor.setDirection(DcMotorEx.Direction.FORWARD);
        FRmotor.setDirection(DcMotorEx.Direction.FORWARD);
        BLmotor.setDirection(DcMotorEx.Direction.FORWARD);
        BRmotor.setDirection(DcMotorEx.Direction.FORWARD);

        waitForStart();

        if (opModeIsActive()) {
            // Drive forward at 50% power
            FLmotor.setPower(1);
            FRmotor.setPower(1);
            BLmotor.setPower(1);
            BRmotor.setPower(1);
            sleep(10000); // controls how long you want it to run

            // Stop motors
           // FLmotor.setPower(0);
            //FRmotor.setPower(0);
        }
    }
}
