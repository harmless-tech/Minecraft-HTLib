package tech.harmless.minecraft.htlib.config.keys;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HTKeyBooleanArray {
    @NotNull String key();

    boolean[] defaultValue();

    @NotNull String comment() default "";
}
