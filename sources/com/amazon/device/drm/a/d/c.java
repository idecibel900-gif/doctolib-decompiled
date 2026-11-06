package com.amazon.device.drm.a.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.amazon.a.a.o.f;
import com.amazon.device.drm.LicensingListener;
import com.amazon.device.drm.LicensingService;
import com.amazon.device.drm.a.d;
import com.amazon.device.drm.model.LicenseResponse;
import com.amazon.device.drm.model.RequestId;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c implements com.amazon.device.drm.a.c {
    private static final String a = "c";
    private static final String b = "com.amazon.sdktestclient";
    private static final String c = "com.amazon.sdktestclient.command.CommandBroker";

    @Override // com.amazon.device.drm.a.c
    public void a(RequestId requestId) {
        com.amazon.device.drm.a.e.b.a(a, "sendGetLicenseRequest");
        try {
            Context contextC = d.d().c();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", requestId);
            jSONObject.put("packageName", contextC.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, LicensingService.SDK_VERSION);
            bundle.putString("getLicenseInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.drm.getLicense");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextC.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.drm.a.e.b.b(a, "Error in sendGetUserDataRequest.");
        }
    }

    private Intent a(String str) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(b, c));
        return intent;
    }

    @Override // com.amazon.device.drm.a.c
    public void a(Context context, Intent intent) {
        com.amazon.device.drm.a.e.b.a(a, "handleResponse");
        intent.setComponent(new ComponentName(b, c));
        try {
            if (intent.getExtras().getString("responseType").equalsIgnoreCase("com.amazon.testclient.drm.getLicense")) {
                a(a(intent));
            }
        } catch (Exception unused) {
        }
    }

    private LicenseResponse a(Intent intent) {
        RequestId requestIdFromString;
        LicenseResponse.RequestStatus requestStatusValueOf = LicenseResponse.RequestStatus.UNKNOWN_ERROR;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("getLicenseOutput"));
            requestStatusValueOf = LicenseResponse.RequestStatus.valueOf(jSONObject.optString("status"));
            requestIdFromString = RequestId.fromString(jSONObject.optString("requestId"));
        } catch (Exception unused) {
            requestIdFromString = null;
        }
        return new com.amazon.device.drm.a.c.a().a(requestIdFromString).a(requestStatusValueOf).a();
    }

    protected void a(final Object obj) {
        f.a(obj, "response");
        Context contextC = d.d().c();
        final LicensingListener licensingListenerB = d.d().b();
        if (contextC == null || licensingListenerB == null) {
            com.amazon.device.drm.a.e.b.a(a, "LicensingListener is not set. Dropping response: " + obj);
            return;
        }
        new Handler(contextC.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.drm.a.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Object obj2 = obj;
                    if (!(obj2 instanceof LicenseResponse)) {
                        com.amazon.device.drm.a.e.b.b(c.a, "Unknown response type:" + obj.getClass().getName());
                        return;
                    }
                    licensingListenerB.onLicenseCommandResponse((LicenseResponse) obj2);
                } catch (Exception e) {
                    com.amazon.device.drm.a.e.b.b(c.a, "Error in sendResponse: " + e);
                }
            }
        });
    }
}
