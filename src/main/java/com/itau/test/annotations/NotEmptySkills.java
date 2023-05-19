package com.itau.test.annotations;

import com.itau.test.annotations.impl.NotEmptySkillsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmptySkillsValidator.class)
public @interface NotEmptySkills {

    String message() default "List cannot contain empty skills";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}