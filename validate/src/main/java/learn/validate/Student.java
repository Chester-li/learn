package learn.validate;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author chaoshuai.li
 * @date 2019/12/19
 * @description
 */
@Data
public class Student {
    @NotNull(message = "name 不能为空")
    private String name;

}
