package app.utils;

import javax.validation.Validation;
import javax.validation.Validator;

public class ValidatorUtilImpl implements ValidatorUtil {

    private final Validator validator;

    public ValidatorUtilImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public<M> boolean isValid(M model) {
        return this.validator.validate(model).size() == 0;
    }
}
