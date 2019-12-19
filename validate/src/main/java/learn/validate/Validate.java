package learn.validate;

import org.apache.commons.lang.StringUtils;

import java.util.Objects;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author chaoshuai.li
 * @date 2019/12/19
 * @description
 */
public class Validate {

    /**
     * Validator的初始化依赖 hibernate-validator. hibernate-validator有对api的部分实现
     */
    private static final Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public static String validate(Object arg) {
        if (Objects.isNull(arg)) {
            return StringUtils.EMPTY;
        }
        Set<ConstraintViolation<Object>> validate = validator.validate(arg);
        StringBuilder stringBuilder = new StringBuilder();
        for (ConstraintViolation<Object> violation : validate) {
            System.out.println(violation.getInvalidValue());
            System.out.println(violation.getMessageTemplate());
            System.out.println(violation.getPropertyPath());
            stringBuilder.append(violation.getMessage()).append(",");
        }
        String message = stringBuilder.toString();
        if (StringUtils.isNotEmpty(message)) {
            return message.substring(0, message.lastIndexOf(","));
        }
        return StringUtils.EMPTY;
    }
}
