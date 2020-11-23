package effektif.element.workflow.transition;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chaoshuai.li
 * @date 2020/11/19
 * @description
 */
@Data
@AllArgsConstructor
public class Condition {
    private Left left;
    private Right right;
    private String type;

    public static Condition createByCondition(ConditionEnum conditionEnum){
        Left left = new Left("action");

        Type type = new Type("text");
        Right right = new Right(type, conditionEnum.name());

        return new Condition(left, right, "equals");
    }

}
