package effektif.element.workflow;

import java.util.List;

import effektif.element.workflow.activity.Activity;
import effektif.element.workflow.transition.Transition;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chaoshuai.li
 * @date 2020/11/19
 * @description
 */
@Data
@AllArgsConstructor
public class Workflow {

    private String id;
    private List<Activity> activities;
    private List<Transition> transitions;

}
