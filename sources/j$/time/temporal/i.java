package j$.time.temporal;

import j$.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
public enum i implements s {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");

    public final String a;

    static {
        Duration.B(31556952L, 0);
        Duration.B(7889238L, 0);
    }

    i(String str) {
        this.a = str;
    }

    @Override // j$.time.temporal.s
    public final m s(m mVar, long j) {
        int i = c.a[ordinal()];
        if (i == 1) {
            h hVar = j.c;
            return mVar.i(Math.addExact(mVar.e(hVar), j), hVar);
        }
        if (i == 2) {
            return mVar.l(j / 4, b.YEARS).l((j % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.a;
    }
}
