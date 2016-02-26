package br.com.cantinhodamarmita.validators;



import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    @Autowired
    private ApplicationContext context;

    private String uniqueField;
    private String uniqueFieldValue;
    private String defaultMessage;
    private String primaryKey;
    private String primaryKeyValue;
    private Class<?> clazz;
    UniqueValidatorService validatorService;

    @Override
    public void initialize(Unique unique) {
        uniqueField = unique.uniqueField();
        defaultMessage = unique.message();
        primaryKey = unique.primaryKey();
        validatorService = context.getBean(unique.service());
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        getValues(object);

        UniqueEntity uniqueEntity = validatorService.getUniqueEntity(uniqueFieldValue);

        if(uniqueEntity != null){
            if(primaryKeyValue != null) {
                if (primaryKeyValue.equals(uniqueEntity.getId()))
                    return true;
                else
                    return false;
            }
            return false;
        }
        return true;
    }

    private void getValues(Object o) {
        clazz = o.getClass();
        try {
            uniqueFieldValue = BeanUtils.getProperty(o,uniqueField);
            primaryKeyValue = BeanUtils.getProperty(o,primaryKey);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
