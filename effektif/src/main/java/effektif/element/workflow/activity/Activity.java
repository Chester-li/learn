package effektif.element.workflow.activity;

import lombok.Data;

/**
 * @author chaoshuai.li
 * @date 2020/11/19
 * @description
 */
@Data
public class Activity {

    private String id;
    private String type;

    public Activity() {

    }

    public Activity(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public Activity(String type) {
        this.id = String.valueOf(System.nanoTime());
        this.type = type;
    }

}
