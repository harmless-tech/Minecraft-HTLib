package tech.harmless.minecraft.htlib.config.keys;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HTKeyLong {
    @NotNull String key();

    long defaultValue();

    @NotNull String comment() default "";

    //TODO Maybe limit values?
    //long min() default Long.MIN_VALUE;
    //long max() default Long.MAX_VALUE;
}
