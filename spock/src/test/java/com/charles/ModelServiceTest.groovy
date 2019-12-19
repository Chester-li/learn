package com.charles

import org.apache.commons.lang.StringUtils
import spock.lang.Specification

class ModelServiceTest extends Specification {
    def "SetForDescribe"() {
        given:
        Model model = new Model()
        ModelService modelService = new ModelService();
        when:
        modelService.setForDescribe(model)
        then:
        StringUtils.isNotEmpty(model.getDescribe())

        and:
        StringUtils.isNotEmpty(model.getName())
    }

    def "test expect"() {
        expect:
        name.trim().size() == totalChars
        where:
        name       || totalChars
        "jone "    || 4
        "ang "     || 3
        " charles" || 7
    }
}
