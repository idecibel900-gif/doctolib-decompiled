package com.adjust.sdk.sig;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class z implements r1 {
    public static final z a;
    public static final d2 b;

    static {
        z zVar = new z();
        a = zVar;
        d2 d2Var = new d2(zVar);
        String[] strArr = d2Var.c;
        int i = d2Var.b + 1;
        d2Var.b = i;
        strArr[i] = "os_name";
        d2Var.e[i] = true;
        d2Var.d[i] = null;
        if (i == 0) {
            HashMap map = new HashMap();
            int length = d2Var.c.length;
            for (int i2 = 0; i2 < length; i2++) {
                map.put(d2Var.c[i2], Integer.valueOf(i2));
            }
            d2Var.f = map;
        }
        b = d2Var;
    }

    @Override // com.adjust.sdk.sig.r1
    public final l2 a() {
        return b;
    }

    @Override // com.adjust.sdk.sig.r1
    public final void a(v2 v2Var, Object obj) {
        p3 p3Var;
        d2 d2Var = b;
        e3 e3Var = e3.a;
        if (e3Var == f3.a) {
            p3Var = p3.LIST;
        } else if (e3Var != g3.a) {
            p3Var = p3.OBJ;
        } else {
            l2 l2VarA = q3.a(d2Var.b(0));
            p2 p2VarD = l2VarA.d();
            if (!(p2VarD instanceof f2) && !g1.a(p2VarD, o2.a)) {
                throw new m1("Value of type '" + l2VarA.b() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + l2VarA.d() + '\'', "Use 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
            }
            p3Var = p3.MAP;
        }
        v2Var.a.a(p3Var.a);
        x xVar = v2Var.a;
        xVar.b = true;
        String str = v2Var.f;
        if (str != null) {
            String str2 = v2Var.g;
            if (str2 == null) {
                str2 = "com.adjust.sdk.sig.755f89ae93acbe52c30f8a09";
            }
            xVar.a();
            v2Var.a(str);
            v2Var.a.a(':');
            v2Var.a(str2);
            v2Var.f = null;
            v2Var.g = null;
        }
        if (v2Var.c != p3Var) {
            v2 v2Var2 = v2Var.d[p3Var.ordinal()];
            if (v2Var2 == null) {
                v2Var2 = new v2(v2Var.a, v2Var.b, p3Var, v2Var.d);
            }
            v2Var = v2Var2;
        }
        if (v2Var.e.a) {
            x2 x2Var = x2.a;
            int iOrdinal = v2Var.c.ordinal();
            if (iOrdinal == 1) {
                x xVar2 = v2Var.a;
                if (!xVar2.b) {
                    xVar2.a(',');
                }
                v2Var.a.a();
            } else if (iOrdinal == 2) {
                x xVar3 = v2Var.a;
                if (xVar3.b) {
                    xVar3.a();
                } else {
                    xVar3.a(',');
                    v2Var.a.a();
                }
            } else if (iOrdinal != 3) {
                x xVar4 = v2Var.a;
                if (!xVar4.b) {
                    xVar4.a(',');
                }
                v2Var.a.a();
                g1.a(e3Var, e3Var);
                v2Var.a(d2Var.c[0]);
                v2Var.a.a(':');
            }
            v2Var.a(x2Var, "android");
        }
        x xVar5 = v2Var.a;
        xVar5.b = false;
        xVar5.a(v2Var.c.b);
    }
}
