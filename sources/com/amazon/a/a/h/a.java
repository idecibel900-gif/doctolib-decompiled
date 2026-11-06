package com.amazon.a.a.h;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a implements Serializable {
    public static final String a = "name";
    public static final String b = "time";
    private static final long c = 1;
    private final Map<String, String> d;

    public a(String str) {
        HashMap map = new HashMap();
        this.d = map;
        map.put("name", str);
        map.put(b, String.valueOf(System.currentTimeMillis()));
    }

    public a a(String str, String str2) {
        this.d.put(str, str2);
        return this;
    }

    public Map<String, String> a() {
        return this.d;
    }

    public String toString() {
        return "Metric: [" + this.d.toString() + "]";
    }
}
