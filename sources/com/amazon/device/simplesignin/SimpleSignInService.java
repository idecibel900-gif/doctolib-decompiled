package com.amazon.device.simplesignin;

import android.content.Context;
import com.amazon.device.simplesignin.a.c;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.request.LinkUserAccountRequest;
import com.amazon.device.simplesignin.model.request.SSIEventRequest;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SimpleSignInService {
    public static final String SDK_VERSION = "1.0.0";
    private static final String TAG = "SimpleSignInService";

    public static void registerResponseHandler(@NonNull Context context, @NonNull ISimpleSignInResponseHandler iSimpleSignInResponseHandler) {
        if (context == null) {
            throw new NullPointerException("appContext is marked non-null but is null");
        }
        if (iSimpleSignInResponseHandler == null) {
            throw new NullPointerException("responseHandler is marked non-null but is null");
        }
        c.a().a(context, iSimpleSignInResponseHandler);
    }

    public static RequestId getUserAndLinks(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("identityProviderName is marked non-null but is null");
        }
        return c.a().a(str);
    }

    public static RequestId linkUserAccount(@NonNull LinkUserAccountRequest linkUserAccountRequest) {
        if (linkUserAccountRequest == null) {
            throw new NullPointerException("linkUserAccountRequest is marked non-null but is null");
        }
        return c.a().a(linkUserAccountRequest);
    }

    public static RequestId showLoginSelection(@NonNull Map<String, String> map) {
        if (map == null) {
            throw new NullPointerException("loginNames is marked non-null but is null");
        }
        return c.a().a(map);
    }

    public static String getSDKMode() {
        return c.a().b();
    }

    public static RequestId recordMetricEvent(@NonNull SSIEventRequest sSIEventRequest) {
        if (sSIEventRequest == null) {
            throw new NullPointerException("ssiEventRequest is marked non-null but is null");
        }
        return c.a().a(sSIEventRequest);
    }
}
