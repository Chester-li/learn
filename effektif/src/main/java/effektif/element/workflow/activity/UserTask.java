package effektif.element.workflow.activity;

import java.util.Map;
import java.util.Set;

import lombok.Data;

/**
 * @author chaoshuai.li
 * @date 2020/11/19
 * @description
 */
@Data
public class UserTask extends Activity {
    private Map<String, Set<String>> assignee;
    private String name;
    private String taskType;

    public UserTask() {
        super("userTask");
    }

    public UserTask(Map<String, Set<String>> assignee) {
        super("userTask");
        this.taskType = "single";
        this.name = "单人审批";
        this.assignee = assignee;
    }
}
