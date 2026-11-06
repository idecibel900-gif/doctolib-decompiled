package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements n {
    public static final s AH;
    public static final /* synthetic */ s[] a;

    @Override // j$.time.chrono.n
    public final int getValue() {
        return 1;
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) a.clone();
    }

    static {
        s sVar = new s("AH", 0);
        AH = sVar;
        a = new s[]{sVar};
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u k(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.ERA) {
            return j$.time.temporal.u.f(1L, 1L);
        }
        return super.k(qVar);
    }
}
