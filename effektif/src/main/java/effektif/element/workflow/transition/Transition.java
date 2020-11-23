package effektif.element.workflow.transition;

import lombok.Data;

/**
 * @author chaoshuai.li
 * @date 2020/11/19
 * @description
 */
@Data
public class Transition {

    private String id = String.valueOf(System.nanoTime());
    private String fromId;
    private String toId;
    private int serialNumber = 0;
    private Condition condition;

    public Transition(String fromId, String toId, ConditionEnum conditionEnum){
        this.fromId = fromId;
        this.toId = toId;
        this.condition = Condition.createByCondition(conditionEnum);
    }

    public Transition(String fromId, String toId){
        this.fromId = fromId;
        this.toId = toId;
    }
}
