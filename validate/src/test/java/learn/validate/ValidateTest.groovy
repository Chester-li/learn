package learn.validate

import spock.lang.Specification

class ValidateTest extends Specification {

    def "Validate"() {
        given:
        Student student = new Student()
        when:
        def validate = Validate.validate(student)
        then :
        println(validate)
    }
}
