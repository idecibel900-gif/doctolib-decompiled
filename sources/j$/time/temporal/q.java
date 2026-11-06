package j$.time.temporal;

import j$.time.format.D;
import j$.time.format.E;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface q {
    u B(TemporalAccessor temporalAccessor);

    u J();

    long Q(TemporalAccessor temporalAccessor);

    m X(m mVar, long j);

    boolean isDateBased();

    boolean s(TemporalAccessor temporalAccessor);

    default TemporalAccessor G(Map map, D d, E e) {
        return null;
    }
}
