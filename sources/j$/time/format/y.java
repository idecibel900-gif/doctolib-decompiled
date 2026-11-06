package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.InterfaceC1168b;
import j$.time.temporal.TemporalAccessor;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    public final TemporalAccessor a;
    public final DateTimeFormatter b;
    public int c;

    public y(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        j$.time.chrono.m mVar = dateTimeFormatter.e;
        if (mVar != null) {
            j$.time.chrono.m mVar2 = (j$.time.chrono.m) temporalAccessor.b(j$.time.temporal.r.b);
            ZoneId zoneId = (ZoneId) temporalAccessor.b(j$.time.temporal.r.a);
            InterfaceC1168b interfaceC1168bH = null;
            mVar = Objects.equals(mVar, mVar2) ? null : mVar;
            if (mVar != null) {
                j$.time.chrono.m mVar3 = mVar != null ? mVar : mVar2;
                if (mVar != null) {
                    if (temporalAccessor.f(j$.time.temporal.a.EPOCH_DAY)) {
                        interfaceC1168bH = mVar3.H(temporalAccessor);
                    } else if (mVar != j$.time.chrono.t.c || mVar2 != null) {
                        for (j$.time.temporal.a aVar : j$.time.temporal.a.values()) {
                            if (aVar.isDateBased() && temporalAccessor.f(aVar)) {
                                throw new j$.time.c("Unable to apply override chronology '" + mVar + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + temporalAccessor);
                            }
                        }
                    }
                }
                temporalAccessor = new x(interfaceC1168bH, temporalAccessor, mVar3, zoneId);
            }
        }
        this.a = temporalAccessor;
        this.b = dateTimeFormatter;
    }

    public final Object b(j$.time.g gVar) {
        TemporalAccessor temporalAccessor = this.a;
        Object objB = temporalAccessor.b(gVar);
        if (objB != null || this.c != 0) {
            return objB;
        }
        throw new j$.time.c("Unable to extract " + gVar + " from temporal " + temporalAccessor);
    }

    public final Long a(j$.time.temporal.q qVar) {
        int i = this.c;
        TemporalAccessor temporalAccessor = this.a;
        if (i <= 0 || temporalAccessor.f(qVar)) {
            return Long.valueOf(temporalAccessor.g(qVar));
        }
        return null;
    }

    public final String toString() {
        return this.a.toString();
    }
}
