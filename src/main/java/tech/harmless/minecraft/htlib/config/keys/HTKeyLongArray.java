package tech.harmless.minecraft.htlib.config.keys;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HTKeyLongArray {
    @NotNull String key();

    long[] defaultValue();

    @NotNull String comment() default "";
}
