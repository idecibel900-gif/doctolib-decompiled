package j$.time;

import j$.time.temporal.TemporalAccessor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements TemporalAccessor, j$.time.temporal.n {
    public static final e FRIDAY;
    public static final e MONDAY;
    public static final e SATURDAY;
    public static final e SUNDAY;
    public static final e THURSDAY;
    public static final e TUESDAY;
    public static final e WEDNESDAY;
    public static final e[] a;
    public static final /* synthetic */ e[] b;

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) b.clone();
    }

    static {
        e eVar = new e("MONDAY", 0);
        MONDAY = eVar;
        e eVar2 = new e("TUESDAY", 1);
        TUESDAY = eVar2;
        e eVar3 = new e("WEDNESDAY", 2);
        WEDNESDAY = eVar3;
        e eVar4 = new e("THURSDAY", 3);
        THURSDAY = eVar4;
        e eVar5 = new e("FRIDAY", 4);
        FRIDAY = eVar5;
        e eVar6 = new e("SATURDAY", 5);
        SATURDAY = eVar6;
        e eVar7 = new e("SUNDAY", 6);
        SUNDAY = eVar7;
        b = new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7};
        a = values();
    }

    public static e s(int i) {
        if (i < 1 || i > 7) {
            throw new c("Invalid value for DayOfWeek: " + i);
        }
        return a[i - 1];
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return qVar == j$.time.temporal.a.DAY_OF_WEEK;
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u k(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.DAY_OF_WEEK) {
            return qVar.J();
        }
        return super.k(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int e(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.DAY_OF_WEEK) {
            return getValue();
        }
        return super.e(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.DAY_OF_WEEK) {
            return getValue();
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
        return qVar.Q(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(g gVar) {
        if (gVar == j$.time.temporal.r.c) {
            return j$.time.temporal.b.DAYS;
        }
        return super.b(gVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m c(j$.time.temporal.m mVar) {
        return mVar.i(getValue(), j$.time.temporal.a.DAY_OF_WEEK);
    }
}
