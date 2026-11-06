package j$.time.format;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class C {
    public static final C a = new C();

    public final int hashCode() {
        return 182;
    }

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof C);
    }

    public final String toString() {
        return "DecimalStyle[0+-.]";
    }
}
