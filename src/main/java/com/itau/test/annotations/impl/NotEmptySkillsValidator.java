package com.itau.test.annotations.impl;

import com.itau.test.annotations.NotEmptySkills;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NotEmptySkillsValidator implements ConstraintValidator<NotEmptySkills, List<String>> {

    @Override
    public void initialize(NotEmptySkills notEmptySkills) {
    }

    @Override
    public boolean isValid(List<String> objects, ConstraintValidatorContext context) {
        return objects.stream().allMatch(nef -> nef != null && !nef.trim().isEmpty());
    }
}
