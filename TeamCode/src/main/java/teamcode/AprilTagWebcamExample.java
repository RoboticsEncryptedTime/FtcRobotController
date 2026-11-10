package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import teamcode.mechanisms.AprilTagWebcam;

@TeleOp
public class AprilTagWebcamExample extends OpMode {
    AprilTagWebcam aprilTagWebcam = new AprilTagWebcam();

    @Override
    public void init(){
        aprilTagWebcam.init(hardwareMap, telemetry);

    }

    @Override
    public void loop() {
        // update the vision portal
        aprilTagWebcam.update();
        AprilTagDetection id42 = aprilTagWebcam.getTagBySpecificId(42);
        telemetry.addData("id42 String", id42.toString());


    }
}
