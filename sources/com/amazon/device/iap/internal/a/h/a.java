package com.amazon.device.iap.internal.a.h;

import android.os.RemoteException;
import com.amazon.a.a.d.b;
import com.amazon.a.a.n.a.h;
import com.amazon.d.a.j;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.a.c;

/* JADX INFO: loaded from: classes3.dex */
public class a extends h {
    private static final String b = "submit_metric";
    private static final String c = "metricName";
    private static final String d = "metricAttributes";

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws b, RemoteException {
        return true;
    }

    public a(c cVar, String str, String str2) {
        super(cVar, b, "1.0", cVar.d().toString(), PurchasingService.SDK_VERSION);
        a(c, str);
        a(d, str2);
        b(false);
    }
}
