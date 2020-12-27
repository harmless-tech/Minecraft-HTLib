package tech.harmless.minecraft.htlib.lib.annotations;

import org.atteo.classindex.IndexAnnotated;

@IndexAnnotated
//TODO This should be used with HTItem to register that item.
//TODO Use the class filter.
@Deprecated
public @interface RegisterItem {
    String itemGroup() default ""; //TODO Change to ItemGroup.
}
