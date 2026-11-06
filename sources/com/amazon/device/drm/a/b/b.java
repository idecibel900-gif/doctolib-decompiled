package com.amazon.device.drm.a.b;

import android.content.Context;
import android.os.Handler;
import com.amazon.a.a.n.a.h;
import com.amazon.a.a.o.f;
import com.amazon.device.drm.LicensingListener;
import com.amazon.device.drm.a.d;
import com.amazon.device.drm.model.LicenseResponse;
import com.amazon.device.drm.model.RequestId;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.amazon.a.a.j.a {
    private static final String c = "b";
    private final RequestId d;

    @Override // com.amazon.a.a.j.a
    public void b() {
    }

    @Override // com.amazon.a.a.j.a
    public void c() {
    }

    public b(RequestId requestId) {
        this.d = requestId;
    }

    @Override // com.amazon.a.a.j.a
    protected void a(h hVar) {
        this.b = hVar;
    }

    protected void a(final Object obj) {
        f.a(obj, "response");
        Context contextC = d.d().c();
        final LicensingListener licensingListenerB = d.d().b();
        if (contextC == null || licensingListenerB == null) {
            com.amazon.device.drm.a.e.b.a(c, "LicensingListener is not set. Dropping response: " + obj);
            return;
        }
        new Handler(contextC.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.drm.a.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Object obj2 = obj;
                    if (!(obj2 instanceof LicenseResponse)) {
                        com.amazon.device.drm.a.e.b.b(b.c, "Unknown response type:" + obj.getClass().getName());
                        return;
                    }
                    licensingListenerB.onLicenseCommandResponse((LicenseResponse) obj2);
                } catch (Throwable th) {
                    com.amazon.device.drm.a.e.b.b(b.c, "Error in sendResponse: " + th);
                }
            }
        });
    }

    public RequestId d() {
        return this.d;
    }

    @Override // com.amazon.a.a.j.a
    public com.amazon.a.a.j.b a() {
        return this.a;
    }

    public void e() {
        h hVar = this.b;
        if (hVar != null) {
            hVar.l();
        } else {
            b();
        }
    }
}
