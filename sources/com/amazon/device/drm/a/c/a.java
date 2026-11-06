package com.amazon.device.drm.a.c;

import com.amazon.device.drm.model.LicenseResponse;
import com.amazon.device.drm.model.RequestId;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private RequestId a;
    private LicenseResponse.RequestStatus b;

    public LicenseResponse a() {
        return new LicenseResponse(this);
    }

    public a a(RequestId requestId) {
        this.a = requestId;
        return this;
    }

    public a a(LicenseResponse.RequestStatus requestStatus) {
        this.b = requestStatus;
        return this;
    }

    public RequestId b() {
        return this.a;
    }

    public LicenseResponse.RequestStatus c() {
        return this.b;
    }
}
