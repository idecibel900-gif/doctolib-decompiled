package j$.time.chrono;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public interface m extends Comparable {
    List A();

    n C(int i);

    int D(n nVar, int i);

    InterfaceC1168b H(TemporalAccessor temporalAccessor);

    InterfaceC1168b N();

    InterfaceC1168b R(int i, int i2, int i3);

    InterfaceC1168b T(Map map, j$.time.format.E e);

    InterfaceC1176j U(Instant instant, ZoneId zoneId);

    boolean Y(long j);

    boolean equals(Object obj);

    int hashCode();

    InterfaceC1168b p(long j);

    String q();

    String toString();

    String u();

    InterfaceC1168b v(int i, int i2);

    j$.time.temporal.u z(j$.time.temporal.a aVar);

    static m r(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        m mVar = (m) temporalAccessor.b(j$.time.temporal.r.b);
        t tVar = t.c;
        if (mVar != null) {
            return mVar;
        }
        Objects.requireNonNull(tVar, "defaultObj");
        return tVar;
    }

    static m of(String str) {
        ConcurrentHashMap concurrentHashMap = AbstractC1167a.a;
        Objects.requireNonNull(str, DiagnosticsEntry.ID_KEY);
        while (true) {
            ConcurrentHashMap concurrentHashMap2 = AbstractC1167a.a;
            m mVar = (m) concurrentHashMap2.get(str);
            if (mVar == null) {
                mVar = (m) AbstractC1167a.b.get(str);
            }
            if (mVar != null) {
                return mVar;
            }
            if (concurrentHashMap2.get("ISO") != null) {
                for (m mVar2 : ServiceLoader.load(m.class)) {
                    if (str.equals(mVar2.q()) || str.equals(mVar2.u())) {
                        return mVar2;
                    }
                }
                throw new j$.time.c("Unknown chronology: ".concat(str));
            }
            p pVar = p.l;
            pVar.getClass();
            AbstractC1167a.B(pVar, "Hijrah-umalqura");
            w wVar = w.c;
            wVar.getClass();
            AbstractC1167a.B(wVar, "Japanese");
            B b = B.c;
            b.getClass();
            AbstractC1167a.B(b, "Minguo");
            H h = H.c;
            h.getClass();
            AbstractC1167a.B(h, "ThaiBuddhist");
            try {
                for (AbstractC1167a abstractC1167a : Arrays.asList(new AbstractC1167a[0])) {
                    if (!abstractC1167a.q().equals("ISO")) {
                        AbstractC1167a.B(abstractC1167a, abstractC1167a.q());
                    }
                }
                t tVar = t.c;
                tVar.getClass();
                AbstractC1167a.B(tVar, "ISO");
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    default InterfaceC1171e I(LocalDateTime localDateTime) {
        try {
            return H(localDateTime).M(j$.time.k.G(localDateTime));
        } catch (j$.time.c e) {
            throw new j$.time.c("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e);
        }
    }
}
