package learn.validate;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.HibernateValidator;

import java.util.Objects;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

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

    /**
     * 参考代码：
     *
     */
    static {
        /**
         * 1. 采用默认的validateFactory生成 引入hibernate-validator 之后依然使用hibernate-validator做校验
         */
//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//        validator = validatorFactory.getValidator();
        /**
         * 2. 采用声明类的方式显示声明使用HibernateValidator的validator
         */
        validator = Validation.byProvider(HibernateValidator.class).configure().failFast(true)
                .buildValidatorFactory()
                .getValidator();
        /**
         * 3. 如果使用 spring的话 可以采用如下方注入
         */
//        <bean id = "validator"
//            class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean" >
//        <property name = "providerClass"
//            value = "org.hibernate.validator.HibernateValidator" / >
//        </bean >
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
