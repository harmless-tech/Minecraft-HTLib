package tech.harmless.minecraft.htlib.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The {@code NoRegister} annotation stops HTLib from automatically registering the {@code HTItem}, {@code HTBlock},
 * {@code HTBlockEntity}, etc. If this annotation is used then the thing will have to be registered with Fabric
 * manually.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoRegister {
}
