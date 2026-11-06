package com.amazon.device.iap.internal.a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.amazon.device.iap.internal.c {
    private static final Map<Class, Class> a;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put(com.amazon.device.iap.internal.e.class, d.class);
    }

    @Override // com.amazon.device.iap.internal.c
    public <T> Class<T> a(Class<T> cls) {
        return a.get(cls);
    }
}
