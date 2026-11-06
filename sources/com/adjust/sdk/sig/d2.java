package com.adjust.sdk.sig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class d2 implements l2, h {
    public final z a;
    public int b = -1;
    public final String[] c = {"[UNINITIALIZED]"};
    public final List[] d = new List[1];
    public final boolean[] e = new boolean[1];
    public Map f = d0.a;
    public final u1 g = v1.a(new g0() { // from class: com.adjust.sdk.sig.d2$$ExternalSyntheticLambda0
        @Override // com.adjust.sdk.sig.g0
        public final Object a() {
            return d2.b(this.f$0);
        }
    });
    public final u1 h = v1.a(new g0() { // from class: com.adjust.sdk.sig.d2$$ExternalSyntheticLambda1
        @Override // com.adjust.sdk.sig.g0
        public final Object a() {
            return d2.c(this.f$0);
        }
    });
    public final u1 i = v1.a(new g0() { // from class: com.adjust.sdk.sig.d2$$ExternalSyntheticLambda2
        @Override // com.adjust.sdk.sig.g0
        public final Object a() {
            return Integer.valueOf(d2.a(this.f$0));
        }
    });

    public d2(z zVar) {
        this.a = zVar;
    }

    public static final int a(d2 d2Var) {
        int iHashCode = Arrays.hashCode((l2[]) d2Var.h.getValue()) + 1231163861;
        int i = 1;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            int iHashCode2 = 0;
            if (i2 <= 0) {
                break;
            }
            int i4 = i2 - 1;
            int i5 = i3 * 31;
            String strB = d2Var.b(1 - i2).b();
            if (strB != null) {
                iHashCode2 = strB.hashCode();
            }
            i3 = i5 + iHashCode2;
            i2 = i4;
        }
        int iHashCode3 = 1;
        while (i > 0) {
            int i6 = i - 1;
            int i7 = iHashCode3 * 31;
            p2 p2VarD = d2Var.b(d2Var.e() - i).d();
            iHashCode3 = i7 + (p2VarD != null ? p2VarD.toString().hashCode() : 0);
            i = i6;
        }
        return (((iHashCode * 31) + i3) * 31) + iHashCode3;
    }

    @Override // com.adjust.sdk.sig.l2
    public final String b() {
        return "com.adjust.sdk.sig.755f89ae93acbe52c30f8a09";
    }

    @Override // com.adjust.sdk.sig.h
    public final Set c() {
        return this.f.keySet();
    }

    @Override // com.adjust.sdk.sig.l2
    public final p2 d() {
        return e3.a;
    }

    @Override // com.adjust.sdk.sig.l2
    public final int e() {
        return 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d2)) {
            return false;
        }
        l2 l2Var = (l2) obj;
        return "com.adjust.sdk.sig.755f89ae93acbe52c30f8a09".equals(l2Var.b()) && Arrays.equals((l2[]) this.h.getValue(), (l2[]) ((d2) obj).h.getValue()) && 1 == l2Var.e() && g1.a(b(0).b(), l2Var.b(0).b()) && g1.a(b(0).d(), l2Var.b(0).d());
    }

    @Override // com.adjust.sdk.sig.l2
    public final List getAnnotations() {
        return c0.a;
    }

    public final int hashCode() {
        return ((Number) this.i.getValue()).intValue();
    }

    public final String toString() {
        return e2.a(this);
    }

    public static final r1[] b(d2 d2Var) {
        z zVar = d2Var.a;
        return new r1[]{new z1()};
    }

    public static final l2[] c(d2 d2Var) {
        l2[] l2VarArr;
        z zVar = d2Var.a;
        ArrayList arrayList = new ArrayList(0);
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return (arrayList == null || (l2VarArr = (l2[]) arrayList.toArray(new l2[0])) == null) ? c2.a : l2VarArr;
    }

    @Override // com.adjust.sdk.sig.l2
    public final l2 b(int i) {
        return ((r1[]) this.g.getValue())[i].a();
    }

    @Override // com.adjust.sdk.sig.l2
    public final String a(int i) {
        return this.c[i];
    }
}
