package com.sebastian_daschner.javazone;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameNotTakenValidator implements ConstraintValidator<UsernameNotTaken, String> {

    @Inject
    JavaZone javaZone;

    public void initialize(UsernameNotTaken constraint) {
    }

    public boolean isValid(String string, ConstraintValidatorContext context) {
        return !javaZone.isUsernameTaken(string);
    }

}
