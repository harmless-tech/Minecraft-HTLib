package tech.harmless.minecraft.htlib.util;

import java.lang.reflect.Constructor;

public final class HTReflection {

    public static boolean hasDefaultConstructor(Class<?> c) {
        boolean hasDefault = false;
        Constructor<?>[] constructors = c.getConstructors();

        for(int i = 0; i < constructors.length && !hasDefault; i++)
            hasDefault = constructors[i].getParameterCount() == 0;

        return hasDefault;
    }
}
