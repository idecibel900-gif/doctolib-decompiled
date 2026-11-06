package com.amazon.device.drm.a.a;

import com.amazon.a.a.n.a.h;
import com.amazon.device.drm.model.LicenseResponse;
import com.amazon.device.drm.model.RequestId;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.amazon.device.drm.a.b.b {
    private static final String c = "b";

    public b(RequestId requestId) {
        super(requestId);
        a((h) new a(this));
    }

    @Override // com.amazon.device.drm.a.b.b, com.amazon.a.a.j.a
    public void b() {
        a((LicenseResponse) a().b());
    }

    @Override // com.amazon.device.drm.a.b.b, com.amazon.a.a.j.a
    public void c() {
        LicenseResponse licenseResponseA = (LicenseResponse) a().b();
        if (licenseResponseA == null) {
            licenseResponseA = new com.amazon.device.drm.a.c.a().a(d()).a(LicenseResponse.RequestStatus.UNKNOWN_ERROR).a();
        }
        com.amazon.device.drm.a.e.b.b(c, "LicenseRequest failed with error: " + licenseResponseA.getRequestStatus());
        a(licenseResponseA);
    }
}
