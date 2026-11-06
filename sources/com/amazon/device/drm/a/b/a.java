package com.amazon.device.drm.a.b;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.amazon.device.drm.a.b {
    private static final Map<Class, Class> a;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put(com.amazon.device.drm.a.c.class, c.class);
    }

    @Override // com.amazon.device.drm.a.b
    public <T> Class<T> a(Class<T> cls) {
        return a.get(cls);
    }
}
