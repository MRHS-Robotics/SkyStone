package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.phases.AutonomousPhase;
import org.firstinspires.ftc.teamcode.phases.DoNothingPhase;
import org.firstinspires.ftc.teamcode.phases.ForwardDistancePhase;
import org.firstinspires.ftc.teamcode.phases.ForwardDurationPhase;
import org.firstinspires.ftc.teamcode.phases.TurnDurationPhase;

import java.util.LinkedList;

@Autonomous(name="BE2019_Auto", group="Iterative Opmode")
public class BE2019_Auto extends AutoAbstract
{
    void setPhases(LinkedList<AutonomousPhase> phaseList) {
        //phaseList.add(new ForwardDurationPhase(3000, 0.5, false));
        //phaseList.add(new ForwardDurationPhase(3000, -0.5, false));
       // phaseList.add(new TurnDurationPhase(3450, 0.5, true));
        //phaseList.add(new TurnDurationPhase(2000, 0.5));
        phaseList.add(new ForwardDurationPhase(3500, 0.25, false));

        //phaseList.add(new TurnDurationPhase(3, -0.5));
        //phaseList.add(new TurnDurationPhase(3, 0.5));

        //phaseList.add(new TurnDurationPhase(1000, -0.5));
        //phaseList.add(new TurnDurationPhase(1000, 0.5));
        //phaseList.add(new TurnDurationPhase(1500, 0.5));
        // phaseList.add(new ForwardDurationPhase(1000, 0.5, true));

        //Do nothing phase
        phaseList.add(new DoNothingPhase());

    }
}


