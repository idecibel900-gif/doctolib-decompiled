package com.adjust.sdk.sig;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k3 {
    public static Map a(Map map) {
        if (map instanceof q1) {
            throw ((ClassCastException) g1.a((RuntimeException) new ClassCastException(map.getClass().getName().concat(" cannot be cast to kotlin.collections.MutableMap")), k3.class.getName()));
        }
        return map;
    }
}
