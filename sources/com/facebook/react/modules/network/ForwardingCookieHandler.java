package com.facebook.react.modules.network;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactContext;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ForwardingCookieHandler extends CookieHandler {
    private static final Companion Companion = new Companion(null);
    private CookieManager cookieManager;

    public final void destroy() {
    }

    public ForwardingCookieHandler() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForwardingCookieHandler(ReactContext reactContext) {
        this();
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // java.net.CookieHandler
    public Map get(URI uri, Map headers) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(headers, "headers");
        CookieManager cookieManager = getCookieManager();
        String cookie = cookieManager != null ? cookieManager.getCookie(uri.toString()) : null;
        if (cookie == null || cookie.length() == 0) {
            return MapsKt.emptyMap();
        }
        return MapsKt.mapOf(TuplesKt.to("Cookie", CollectionsKt.listOf(cookie)));
    }

    @Override // java.net.CookieHandler
    public void put(URI uri, Map headers) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(headers, "headers");
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        for (Map.Entry entry : headers.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (Companion.isCookieHeader(str)) {
                addCookies(string, list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearCookies$lambda$0(Callback callback, Boolean bool) {
        callback.invoke(bool);
    }

    public final void clearCookies(final Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        CookieManager cookieManager = getCookieManager();
        if (cookieManager != null) {
            cookieManager.removeAllCookies(new ValueCallback() { // from class: com.facebook.react.modules.network.ForwardingCookieHandler$$ExternalSyntheticLambda0
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    ForwardingCookieHandler.clearCookies$lambda$0(callback, (Boolean) obj);
                }
            });
        }
    }

    public final void addCookies(String url, List cookies) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        Iterator it = cookies.iterator();
        while (it.hasNext()) {
            addCookieAsync(url, (String) it.next());
        }
        CookieManager cookieManager = getCookieManager();
        if (cookieManager != null) {
            cookieManager.flush();
        }
    }

    private final void addCookieAsync(String str, String str2) {
        CookieManager cookieManager = getCookieManager();
        if (cookieManager != null) {
            cookieManager.setCookie(str, str2, null);
        }
    }

    private final CookieManager getCookieManager() {
        if (this.cookieManager == null) {
            try {
                this.cookieManager = CookieManager.getInstance();
            } catch (IllegalArgumentException | Exception unused) {
                return null;
            }
        }
        return this.cookieManager;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isCookieHeader(String str) {
            return StringsKt.equals(str, "Set-cookie", true) || StringsKt.equals(str, "Set-cookie2", true);
        }
    }
}
