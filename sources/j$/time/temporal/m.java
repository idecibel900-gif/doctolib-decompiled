package j$.time.temporal;

import j$.time.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
public interface m extends TemporalAccessor {
    m i(long j, q qVar);

    /* JADX INFO: renamed from: j */
    m m(LocalDate localDate);

    m l(long j, s sVar);

    default m a(long j, s sVar) {
        return j == Long.MIN_VALUE ? l(Long.MAX_VALUE, sVar).l(1L, sVar) : l(-j, sVar);
    }
}
