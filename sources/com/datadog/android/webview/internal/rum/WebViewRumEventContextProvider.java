package com.datadog.android.webview.internal.rum;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.webview.internal.rum.domain.RumContext;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class WebViewRumEventContextProvider {
    public static final Companion Companion = new Companion(null);
    private final InternalLogger internalLogger;
    private boolean rumFeatureDisabled;

    public WebViewRumEventContextProvider(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    public final RumContext getRumContext(DatadogContext datadogContext) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        if (this.rumFeatureDisabled) {
            return null;
        }
        Map map = (Map) datadogContext.getFeaturesContext().get("rum");
        Object obj = map != null ? map.get("application_id") : null;
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map != null ? map.get("session_id") : null;
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map != null ? map.get("session_state") : null;
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        if (str != null) {
            RumContext.Companion companion = RumContext.Companion;
            if (!Intrinsics.areEqual(str, companion.getNULL_UUID()) && str2 != null && !Intrinsics.areEqual(str2, companion.getNULL_UUID()) && str3 != null && !StringsKt.isBlank(str3)) {
                return new RumContext(str, str2, str3);
            }
        }
        this.rumFeatureDisabled = true;
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.webview.internal.rum.WebViewRumEventContextProvider.getRumContext.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "You are trying to use the WebView tracking API but the RUM feature was not properly initialized.";
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
