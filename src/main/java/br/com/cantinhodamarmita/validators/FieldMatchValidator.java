package br.com.cantinhodamarmita.validators;


import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch,Object> {
    private String firstFieldName;
    private String secondFieldName;
    private String errorMsg;

    @Override
    public void initialize(final FieldMatch constraintAnnotation)
    {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        errorMsg = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context)
    {

        boolean toReturn = true;
        try
        {
            final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
            final Object secondObj = BeanUtils.getProperty(value, secondFieldName);

            toReturn = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception ignore)
        {
            // ignore
        }

        if(!toReturn){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMsg).addNode(firstFieldName).addConstraintViolation();
        }

        return toReturn;
    }
}
