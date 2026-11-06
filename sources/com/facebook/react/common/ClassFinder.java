package com.facebook.react.common;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ClassFinder {
    public static final ClassFinder INSTANCE = new ClassFinder();

    public static final boolean canLoadClassesFromAnnotationProcessors() {
        return false;
    }

    private ClassFinder() {
    }

    public static final Class findClass(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        if (canLoadClassesFromAnnotationProcessors()) {
            return Class.forName(className);
        }
        return null;
    }
}
