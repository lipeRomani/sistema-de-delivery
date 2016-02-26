package br.com.cantinhodamarmita.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(value={
        ElementType.TYPE,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=UniqueValidator.class)
public @interface Unique {

    String message() default "{unique.value.violation}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default { };
    String uniqueField();
    String primaryKey();
    Class<? extends UniqueValidatorService> service();
}
