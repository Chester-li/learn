package effektif.element.workflow.activity;

import lombok.Data;

/**
 * @author chaoshuai.li
 * @date 2020/11/19
 * @description
 */
@Data
public class GateWay extends Activity{

    private int gatewayType;

    public GateWay(){
        super("exclusiveGateway");
    }

}
