package com.amazon.device.iap.internal.b;

import com.amazon.a.a.o.f;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    private static final e b = new e();
    private final Set<String> a = new ConcurrentSkipListSet();

    public boolean a(String str) {
        if (f.a(str)) {
            return false;
        }
        return this.a.remove(str);
    }

    public void b(String str) {
        if (f.a(str)) {
            return;
        }
        this.a.add(str);
    }

    public static e a() {
        return b;
    }
}
