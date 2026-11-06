package com.adjust.sdk.sig;

import kotlin.reflect.jvm.internal.ReflectionFactoryImpl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h2 {
    public static final i2 a;

    static {
        i2 i2Var;
        try {
            i2Var = (i2) ReflectionFactoryImpl.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            i2Var = null;
        }
        if (i2Var == null) {
            i2Var = new i2();
        }
        a = i2Var;
    }
}
