package tech.harmless.minecraft.htlib.lib.annotations;

import org.atteo.classindex.IndexAnnotated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IndexAnnotated
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HTMod {
    String id();
    String name();
    String version();
    String topPackage() default ""; // This will use the package that the annotated class is in, by default.
}
