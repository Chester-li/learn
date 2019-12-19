package com.charles;

import org.apache.commons.lang.StringUtils;

/**
 * @author chaoshuai.li
 * @date 2019/9/12
 * @description
 */
public class ModelService {

    public void setForDescribe(Model model) {
        if (StringUtils.isEmpty(model.getName())) {
            model.setDescribe("hello this is null.");
        } else {
            model.setDescribe("hello this is " + model.getName());
        }
    }

}
