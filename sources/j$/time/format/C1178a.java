package j$.time.format;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: j$.time.format.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1178a extends B {
    public final /* synthetic */ A d;

    public C1178a(A a) {
        this.d = a;
    }

    @Override // j$.time.format.B
    public final String b(j$.time.chrono.m mVar, j$.time.temporal.q qVar, long j, G g, Locale locale) {
        return this.d.a(j, g);
    }

    @Override // j$.time.format.B
    public final String c(j$.time.temporal.q qVar, long j, G g, Locale locale) {
        return this.d.a(j, g);
    }

    @Override // j$.time.format.B
    public final Iterator d(j$.time.chrono.m mVar, j$.time.temporal.q qVar, G g, Locale locale) {
        List list = (List) ((HashMap) this.d.b).get(g);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }

    @Override // j$.time.format.B
    public final Iterator e(j$.time.temporal.q qVar, G g, Locale locale) {
        List list = (List) ((HashMap) this.d.b).get(g);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }
}
