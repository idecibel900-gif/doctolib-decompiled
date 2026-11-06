package com.adjust.sdk.sig;

import com.adjust.sdk.AdjustConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class x1 {
    public final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
    public final boolean b;

    public x1(Map map) {
        this.b = AdjustConfig.ENVIRONMENT_SANDBOX.equals(map.get("environment"));
    }

    public final void a(String str) {
        if (this.b) {
            this.a.format(new Date(System.currentTimeMillis()));
        }
    }
}
