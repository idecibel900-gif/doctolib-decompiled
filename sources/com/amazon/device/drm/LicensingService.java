package com.amazon.device.drm;

import android.content.Context;
import com.amazon.a.a;
import com.amazon.device.drm.a.d;
import com.amazon.device.drm.model.RequestId;

/* JADX INFO: loaded from: classes3.dex */
public class LicensingService {
    private static final String APPSTORE_SDK_NAME = "Amazon Digital Rights Management Android SDK :2.9.0.0";
    public static final String SDK_VERSION = "2.9.0.0";
    private static final String TAG = "LicensingService";

    public static RequestId verifyLicense(Context context, LicensingListener licensingListener) {
        d dVarD = d.d();
        Context applicationContext = context.getApplicationContext();
        a.a(applicationContext);
        dVarD.a(applicationContext, licensingListener);
        return dVarD.e();
    }

    public static String getAppstoreSDKMode() {
        return d.d().a();
    }
}
