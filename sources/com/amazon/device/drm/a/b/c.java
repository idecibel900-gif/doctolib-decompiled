package com.amazon.device.drm.a.b;

import android.content.Context;
import android.content.Intent;
import com.amazon.device.drm.model.RequestId;

/* JADX INFO: loaded from: classes3.dex */
public class c implements com.amazon.device.drm.a.c {
    private static final String a = "c";

    @Override // com.amazon.device.drm.a.c
    public void a(Context context, Intent intent) {
    }

    @Override // com.amazon.device.drm.a.c
    public void a(RequestId requestId) {
        com.amazon.device.drm.a.e.b.a(a, "sendGetLicense");
        new com.amazon.device.drm.a.a.b(requestId).e();
    }
}
