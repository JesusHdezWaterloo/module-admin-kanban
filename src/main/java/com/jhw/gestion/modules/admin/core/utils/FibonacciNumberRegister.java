package com.jhw.gestion.modules.admin.core.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class FibonacciNumberRegister implements ConstraintValidator<FibonacciNumber, Integer> {

    @Override
    public void initialize(FibonacciNumber a) {
        ConstraintValidator.super.initialize(a);
    }

    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext cvc) {
        return FibonacciNumberUtils.isFibo(number);
    }

}
