package expo.modules.image.okhttp;

import android.webkit.CookieManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
final class SharedCookieJar implements CookieJar {
    public static final SharedCookieJar INSTANCE = new SharedCookieJar();

    private SharedCookieJar() {
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(HttpUrl url, List cookies) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        CookieManager cookieManager = getCookieManager();
        if (cookieManager == null) {
            return;
        }
        String url2 = url.getUrl();
        Iterator it = cookies.iterator();
        while (it.hasNext()) {
            cookieManager.setCookie(url2, ((Cookie) it.next()).toString());
        }
        cookieManager.flush();
    }

    @Override // okhttp3.CookieJar
    public List loadForRequest(HttpUrl url) {
        String cookie;
        Intrinsics.checkNotNullParameter(url, "url");
        CookieManager cookieManager = getCookieManager();
        if (cookieManager != null && (cookie = cookieManager.getCookie(url.getUrl())) != null) {
            List listSplit$default = StringsKt.split$default((CharSequence) cookie, new String[]{";"}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                Cookie cookie2 = Cookie.INSTANCE.parse(url, StringsKt.trim((String) it.next()).toString());
                if (cookie2 != null) {
                    arrayList.add(cookie2);
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    private final CookieManager getCookieManager() {
        Object objM5243constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(CookieManager.getInstance());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m5248isFailureimpl(objM5243constructorimpl)) {
            objM5243constructorimpl = null;
        }
        return (CookieManager) objM5243constructorimpl;
    }
}
