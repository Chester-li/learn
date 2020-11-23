package effektif.element.operation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import effektif.element.workflow.Workflow;
import effektif.element.workflow.activity.Activity;
import effektif.element.workflow.activity.EndEvent;
import effektif.element.workflow.activity.GateWay;
import effektif.element.workflow.activity.StartEvent;
import effektif.element.workflow.activity.UserTask;
import effektif.element.workflow.transition.ConditionEnum;
import effektif.element.workflow.transition.Transition;

/**
 * @author chaoshuai.li
 * @date 2020/11/19
 * @description
 */
public class Operator {

    private static Gson gsonWithNull = new GsonBuilder().serializeNulls().create();

    public static Workflow createWorkflow() {
        List<Activity> activities = new ArrayList<>();
        List<Transition> transitions = new ArrayList<>();

        StartEvent startEvent = new StartEvent();
        activities.add(startEvent);
        UserTask previousUserTask = new UserTask(getDefaultAssignee());
        activities.add(previousUserTask);
        transitions.add(new Transition(startEvent.getId(), previousUserTask.getId()));

        EndEvent endEvent = new EndEvent();
        activities.add(endEvent);

        GateWay previousGateWay = new GateWay();
        activities.add(previousGateWay);
        transitions.add(new Transition(previousUserTask.getId(), previousGateWay.getId()));
        transitions.add(new Transition(previousGateWay.getId(), endEvent.getId(), ConditionEnum.reject));

        for (int i = 0; i < 199; i++) {
            UserTask currentUserTask = new UserTask(getDefaultAssignee());
            GateWay currentGateWay = new GateWay();
            activities.add(currentUserTask);
            activities.add(currentGateWay);

            transitions.add(new Transition(previousGateWay.getId(), currentUserTask.getId(), ConditionEnum.agree));
            transitions.add(new Transition(currentUserTask.getId(), currentGateWay.getId()));
            transitions.add(new Transition(currentGateWay.getId(), endEvent.getId(), ConditionEnum.reject));
            transitions.add(new Transition(currentGateWay.getId(), previousUserTask.getId(), ConditionEnum.go_back));


            previousGateWay = currentGateWay;
            previousUserTask = currentUserTask;
        }

        transitions.add(new Transition(previousGateWay.getId(), endEvent.getId(), ConditionEnum.agree));

        return new Workflow(UUID.randomUUID().toString(), activities, transitions);
    }



    public static Map<String, Set<String>> getDefaultAssignee() {
        Map<String, Set<String>> assignee = new HashMap<>();
        Set<String> set = new HashSet<>();
        set.add("applicant");
        assignee.put("applicant", set);
        return assignee;
    }

    public static void main(String[] args) {
        Workflow workflow = createWorkflow();
        System.out.println(gsonWithNull.toJson(workflow));
    }
}
