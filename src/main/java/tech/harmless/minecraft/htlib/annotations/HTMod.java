package tech.harmless.minecraft.htlib.annotations;

import org.atteo.classindex.IndexAnnotated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The HTMod annotation should be used on the class that implements ModInitializer. This allows for HTLib to detect the
 * mod and begin its processes. The class with the annotation attached should be in the root package, unless you
 * override the property {@code rootPackage()}, then HTLib will search using the indexes starting there.
 */
@IndexAnnotated
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HTMod {

    /**
     * @return The id of the mod.
     */
    String id();

    /**
     * @return The name of the mod.
     */
    String name();

    /**
     * @return The version of the mod.
     */
    String version();

    /**
     * @return The root package of the mod. A blank {@code String} if the root package is the same as the class.
     */
    String rootPackage() default ""; // This will use the package that the annotated class is in, by default.
}
