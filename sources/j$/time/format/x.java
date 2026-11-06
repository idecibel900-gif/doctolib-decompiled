package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.InterfaceC1168b;
import j$.time.temporal.TemporalAccessor;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements TemporalAccessor {
    public final /* synthetic */ InterfaceC1168b a;
    public final /* synthetic */ TemporalAccessor b;
    public final /* synthetic */ j$.time.chrono.m c;
    public final /* synthetic */ ZoneId d;

    public x(InterfaceC1168b interfaceC1168b, TemporalAccessor temporalAccessor, j$.time.chrono.m mVar, ZoneId zoneId) {
        this.a = interfaceC1168b;
        this.b = temporalAccessor;
        this.c = mVar;
        this.d = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.q qVar) {
        InterfaceC1168b interfaceC1168b = this.a;
        if (interfaceC1168b != null && qVar.isDateBased()) {
            return interfaceC1168b.f(qVar);
        }
        return this.b.f(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u k(j$.time.temporal.q qVar) {
        InterfaceC1168b interfaceC1168b = this.a;
        if (interfaceC1168b != null && qVar.isDateBased()) {
            return interfaceC1168b.k(qVar);
        }
        return this.b.k(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.q qVar) {
        InterfaceC1168b interfaceC1168b = this.a;
        if (interfaceC1168b != null && qVar.isDateBased()) {
            return interfaceC1168b.g(qVar);
        }
        return this.b.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(j$.time.g gVar) {
        if (gVar == j$.time.temporal.r.b) {
            return this.c;
        }
        if (gVar == j$.time.temporal.r.a) {
            return this.d;
        }
        if (gVar == j$.time.temporal.r.c) {
            return this.b.b(gVar);
        }
        return gVar.j(this);
    }

    public final String toString() {
        String str;
        String str2 = "";
        j$.time.chrono.m mVar = this.c;
        if (mVar != null) {
            str = " with chronology " + mVar;
        } else {
            str = "";
        }
        ZoneId zoneId = this.d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.b + str + str2;
    }
}
