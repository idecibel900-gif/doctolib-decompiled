package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class E implements n {
    public static final E BEFORE_ROC;
    public static final E ROC;
    public static final /* synthetic */ E[] a;

    public static E valueOf(String str) {
        return (E) Enum.valueOf(E.class, str);
    }

    public static E[] values() {
        return (E[]) a.clone();
    }

    static {
        E e = new E("BEFORE_ROC", 0);
        BEFORE_ROC = e;
        E e2 = new E("ROC", 1);
        ROC = e2;
        a = new E[]{e, e2};
    }

    @Override // j$.time.chrono.n
    public final int getValue() {
        return ordinal();
    }
}
