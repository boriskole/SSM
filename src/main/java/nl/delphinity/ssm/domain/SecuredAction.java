package nl.delphinity.ssm.domain;

import nl.delphinity.ssm.domain.type.PersoonType;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SecuredAction {

    PersoonType type() default PersoonType.KLANT;

}
