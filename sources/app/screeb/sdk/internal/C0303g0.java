package app.screeb.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.PermissionRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import app.screeb.sdk.R$id;
import app.screeb.sdk.Screeb;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.revenuecat.purchases.common.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: app.screeb.sdk.internal.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0303g0 extends WebView {
    public static final /* synthetic */ int $r8$clinit = 0;
    public int A;
    public boolean B;
    public final int[] C;
    public final X a;
    public final Function0 b;
    public Function0 c;
    public Function2 d;
    public volatile boolean e;
    public ConcurrentHashMap f;
    public final ConcurrentHashMap g;
    public final ConcurrentHashMap h;
    public boolean i;
    public C0291a0 j;
    public boolean k;
    public boolean l;
    public String m;
    public String n;
    public int o;
    public boolean p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public ChoreographerFrameCallbackC0301f0 u;
    public long v;
    public long w;
    public int x;
    public double y;
    public double z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0303g0(final Context context, X onRecover, boolean z, Function0 currentActivityProvider, boolean z2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onRecover, "onRecover");
        Intrinsics.checkNotNullParameter(currentActivityProvider, "currentActivityProvider");
        this.a = onRecover;
        this.b = currentActivityProvider;
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.h = new ConcurrentHashMap();
        this.q = LazyKt.lazy(new Function0() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return C0303g0.e();
            }
        });
        this.r = LazyKt.lazy(new Function0() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return C0303g0.b(this.f$0);
            }
        });
        this.s = LazyKt.lazy(new Function0() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return C0303g0.a();
            }
        });
        this.t = LazyKt.lazy(new Function0() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return C0303g0.b();
            }
        });
        this.k = z;
        setScrollBarSize(0);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setFitsSystemWindows(false);
        getSettings().setUserAgentString("Screeb android 4.4.0");
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setAllowFileAccess(true);
        getSettings().setAllowContentAccess(true);
        getSettings().setLoadsImagesAutomatically(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().setSupportZoom(false);
        getSettings().setUseWideViewPort(false);
        getSettings().setLoadWithOverviewMode(false);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setDisplayZoomControls(false);
        getSettings().setNeedInitialFocus(false);
        setLayerType(z2 ? 2 : 0, null);
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            getSettings().setSafeBrowsingEnabled(false);
        }
        getSettings().setMixedContentMode(2);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        final String strA = AbstractC0298e.a(context, "app.screeb.sdk.PLATFORM");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        setLayoutParams(new FrameLayout.LayoutParams(displayMetrics.widthPixels, displayMetrics.heightPixels));
        setBackgroundColor(0);
        boolean z3 = o0.a;
        Intrinsics.checkNotNullParameter(this, "view");
        setTag(R$id.screeb_no_capture_tag, Boolean.TRUE);
        if (i >= 26) {
            setRendererPriorityPolicy(2, false);
        }
        setWebViewClient(new C0295c0(this));
        setWebChromeClient(new C0297d0(this, context));
        b((String) null);
        if (this.i) {
            d();
        }
        addJavascriptInterface(new C0299e0(this), "webviewSdk");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() throws UnsupportedEncodingException {
                C0303g0.a(strA, context, this);
            }
        });
        this.C = new int[2];
    }

    public static final Paint a() {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.argb(185, 0, 0, 0));
        return paint;
    }

    public static final void a(C0303g0 c0303g0, PermissionRequest permissionRequest) {
        c0303g0.getClass();
        String[] resources = permissionRequest.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        ArrayList arrayList = new ArrayList();
        for (String str : resources) {
            Intrinsics.checkNotNull(str);
            String str2 = Intrinsics.areEqual(str, "android.webkit.resource.VIDEO_CAPTURE") ? "android.permission.CAMERA" : Intrinsics.areEqual(str, "android.webkit.resource.AUDIO_CAPTURE") ? "android.permission.RECORD_AUDIO" : null;
            if (str2 == null || ContextCompat.checkSelfPermission(c0303g0.getContext(), str2) == 0) {
                arrayList.add(str);
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        if (strArr.length == 0) {
            permissionRequest.deny();
        } else {
            permissionRequest.grant(strArr);
        }
    }

    public static final void a(C0303g0 c0303g0, ReviewManager reviewManager, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            Z z = Z.b;
            Z.a("Core", "error while launching app store rating", task.getException(), 8);
            return;
        }
        ReviewInfo reviewInfo = (ReviewInfo) task.getResult();
        Activity activity = (Activity) c0303g0.b.invoke();
        if (activity != null) {
            reviewManager.launchReviewFlow(activity, reviewInfo);
        }
    }

    public static final void a(C0303g0 c0303g0, String str) {
        try {
            c0303g0.evaluateJavascript(str, null);
        } catch (Exception e) {
            Z z = Z.b;
            Y.a();
            Z z2 = Z.b;
            Z.a("Core", "error while updating mirror root: " + e.getMessage(), null, 12);
        }
    }

    public static final void a(C0303g0 c0303g0, String str, List list, Function2 function2, List list2) {
        if (!c0303g0.e) {
            if (str != null) {
                c0303g0.g.remove(str);
            }
            Function2 function3 = c0303g0.d;
            if (function3 != null) {
                function3.invoke(list, function2);
                return;
            }
            return;
        }
        try {
            String string = new JSONArray((Collection) list2).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String strSubstring = string.substring(1, string.length() - 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            c0303g0.evaluateJavascript("window[window[\"ScreebObject\"]](" + strSubstring + ")", null);
        } catch (Exception e) {
            Z z = Z.b;
            Y.a();
            Z.a("Command", "error while sending command: " + CollectionsKt.firstOrNull(list), e, 8);
        }
    }

    public static final void a(C0303g0 c0303g0, boolean z, U u) {
        Activity activity = (Activity) c0303g0.b.invoke();
        if (activity == null) {
            Z.b("Mirror", "no Activity context — start skipped");
            return;
        }
        C0291a0 c0291a0 = c0303g0.j;
        if (c0291a0 != null) {
            J j = c0291a0.a;
            if (j.e != z) {
                j.e = z;
                j.R = 0;
                j.S = 0;
                j.J0 = true;
            }
        }
        C0291a0 c0291a1 = c0303g0.j;
        if (c0291a1 != null) {
            c0291a1.a(activity, u);
        }
        c0303g0.a("el.style.display = 'block'; el.style.opacity = '0'; el.style.pointerEvents = 'none'; el.style.userSelect = 'none'; el.style.webkitUserSelect = 'none'; el.style.webkitTouchCallout = 'none';");
    }

    public static final void a(String str, Context context, C0303g0 c0303g0) throws UnsupportedEncodingException {
        String strA = AbstractC0305h0.a(str, AbstractC0298e.a(context, "app.screeb.sdk.TAG_VERSION"), c0303g0.k);
        c0303g0.m = AbstractC0305h0.a(strA);
        c0303g0.n = strA;
        c0303g0.loadUrl(strA);
    }

    public static final void a(String str, Object obj, C0303g0 c0303g0) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "hook.result");
            jSONObject.put("hook", str);
            jSONObject.put("result", obj);
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            c0303g0.evaluateJavascript("document.getElementById('screeb-core').contentWindow.postMessage({ screeb: { from: 'core', to: 'loader', event: " + string + "}}, '" + c0303g0.m + "');", null);
        } catch (Exception e) {
            Z z = Z.b;
            Y.a();
            Z.a("Core", "error while sending hook result", e, 8);
        }
    }

    public static final boolean a(C0303g0 c0303g0, WebView webView, String str) {
        c0303g0.getClass();
        if (str == null) {
            return false;
        }
        String url = webView.getUrl();
        return url == null || Intrinsics.areEqual(url, "about:blank") || Intrinsics.areEqual(url, str);
    }

    public static final Paint b(C0303g0 c0303g0) {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(92, 255, 157));
        paint.setTextSize(c0303g0.getResources().getDisplayMetrics().scaledDensity * 11.0f);
        return paint;
    }

    public static final RectF b() {
        return new RectF();
    }

    public static final void b(C0303g0 c0303g0, String str) {
        try {
            try {
                c0303g0.loadUrl(str);
            } catch (Exception e) {
                Z z = Z.b;
                Z z2 = Z.b;
                Z z3 = Z.b;
                Z.a("Core", "error while retrying webview load", e, 8);
            }
        } finally {
            c0303g0.p = false;
        }
    }

    public static final void c(C0303g0 c0303g0) {
        C0291a0 c0291a0 = c0303g0.j;
        if (c0291a0 != null) {
            c0291a0.a.g();
            A a = c0291a0.c;
            if (a != null) {
                a.b();
            }
            c0291a0.c = null;
        }
        c0303g0.l = false;
        c0303g0.a("el.style.display = 'none'; el.style.opacity = ''; el.style.pointerEvents = 'none';");
    }

    public static final void c(C0303g0 c0303g0, String str) {
        c0303g0.b(str);
    }

    public static final void d(C0303g0 c0303g0) {
        c0303g0.e = false;
        c0303g0.evaluateJavascript("sessionStorage.clear();", null);
        c0303g0.reload();
    }

    public static final Paint e() {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-65536);
        return paint;
    }

    public static final void e(C0303g0 c0303g0) {
        c0303g0.bringToFront();
    }

    private final Paint getDebugOverlayBackgroundPaint() {
        return (Paint) this.s.getValue();
    }

    private final RectF getDebugOverlayRect() {
        return (RectF) this.t.getValue();
    }

    private final Paint getDebugOverlayTextPaint() {
        return (Paint) this.r.getValue();
    }

    private final Paint getHitBoxPaint() {
        return (Paint) this.q.getValue();
    }

    public final void a(Canvas canvas) {
        String strA;
        List listSplit$default;
        float f = getResources().getDisplayMetrics().density;
        float f2 = 8.0f * f;
        float textSize = getDebugOverlayTextPaint().getTextSize() * 1.35f;
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add("Screeb Lab native");
        Locale locale = Locale.US;
        String str = String.format(locale, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(this.y)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        String str2 = String.format(locale, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(this.z)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        listCreateListBuilder.add("app " + str + " fps  frame " + str2 + "ms");
        int i = this.A;
        StringBuilder sb = new StringBuilder();
        sb.append("jank >24ms ");
        sb.append(i);
        listCreateListBuilder.add(sb.toString());
        C0291a0 c0291a0 = this.j;
        if (c0291a0 != null && (strA = c0291a0.a()) != null && (listSplit$default = StringsKt.split$default((CharSequence) strA, new char[]{'\n'}, false, 0, 6, (Object) null)) != null) {
            listCreateListBuilder.addAll(listSplit$default);
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        Iterator it = listBuild.iterator();
        float fMax = 0.0f;
        while (it.hasNext()) {
            fMax = Math.max(fMax, getDebugOverlayTextPaint().measureText((String) it.next()));
        }
        float f3 = 2 * f2;
        getDebugOverlayRect().set(f2, f2, fMax + f2 + f3, (listBuild.size() * textSize) + f3 + f2);
        float f4 = f * 4.0f;
        canvas.drawRoundRect(getDebugOverlayRect(), f4, f4, getDebugOverlayBackgroundPaint());
        float f5 = f2 + f2;
        float f6 = f5 - getDebugOverlayTextPaint().getFontMetrics().ascent;
        Iterator it2 = listBuild.iterator();
        while (it2.hasNext()) {
            canvas.drawText((String) it2.next(), f5, f6, getDebugOverlayTextPaint());
            f6 += textSize;
        }
    }

    public final void a(String str) {
        final String str2 = "var el = document.getElementById('screeb-webview-app'); if (el) { " + str + " }";
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                C0303g0.a(this.f$0, str2);
            }
        });
    }

    public final void a(final String hook, final Object obj) {
        Intrinsics.checkNotNullParameter(hook, "hook");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C0303g0.a(hook, obj, this);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0030  */
    public final void a(String str, String str2, boolean z) {
        boolean zA;
        URI uri;
        String str3 = this.m;
        if (str == null || Intrinsics.areEqual(str, "about:blank")) {
            zA = false;
        } else if (str3 != null) {
            zA = StringsKt.startsWith$default(str, str3, false, 2, (Object) null);
        } else {
            try {
                uri = new URI(str);
            } catch (Exception unused) {
                uri = null;
            }
            if (uri == null) {
                zA = false;
            } else {
                zA = AbstractC0305h0.a(uri.getHost(), uri.getPath());
            }
        }
        if (zA && !this.p) {
            this.p = true;
            try {
                final String str4 = this.n;
                if (str4 == null || this.o >= 3) {
                    str4 = null;
                }
                String str5 = "webview main-frame load failed: " + str2 + ", url=" + str;
                if (z || str4 != null) {
                    Z z2 = Z.b;
                    Y.a();
                    Z.b("Core", str5);
                } else {
                    Z z3 = Z.b;
                    Y.a();
                    Z.a("Core", str5, null, 12);
                }
                setInspect(false);
                b((String) null);
                try {
                    stopLoading();
                } catch (Exception unused2) {
                }
                loadUrl("about:blank");
                if (str4 == null) {
                    this.o = 0;
                    this.p = false;
                } else {
                    int i = this.o;
                    this.o = i + 1;
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda9
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0303g0.b(this.f$0, str4);
                        }
                    }, (1 << i) * 1000);
                }
            } catch (Exception e) {
                this.p = false;
                Z z4 = Z.b;
                Y.a();
                Z.a("Core", "error while handling webview load failure", e, 8);
            }
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("hitbox");
        Double dValueOf = jSONObjectOptJSONObject != null ? Double.valueOf(jSONObjectOptJSONObject.optDouble("width", 0.0d)) : null;
        Double dValueOf2 = jSONObjectOptJSONObject != null ? Double.valueOf(jSONObjectOptJSONObject.optDouble("height", 0.0d)) : null;
        Double dValueOf3 = jSONObjectOptJSONObject != null ? Double.valueOf(jSONObjectOptJSONObject.optDouble("x", 0.0d)) : null;
        Double dValueOf4 = jSONObjectOptJSONObject != null ? Double.valueOf(jSONObjectOptJSONObject.optDouble("y", 0.0d)) : null;
        boolean zOptBoolean = jSONObject.optBoolean("visible", false);
        if (dValueOf3 != null && dValueOf4 != null && dValueOf != null && !Intrinsics.areEqual(dValueOf, 0.0d) && dValueOf2 != null && !Intrinsics.areEqual(dValueOf2, 0.0d) && zOptBoolean) {
            double d = getResources().getDisplayMetrics().density;
            this.h.put(str, new Rect((int) (dValueOf3.doubleValue() * d), (int) (dValueOf4.doubleValue() * d), (int) ((dValueOf.doubleValue() + dValueOf3.doubleValue()) * d), (int) ((dValueOf2.doubleValue() + dValueOf4.doubleValue()) * d)));
            h();
            return;
        }
        if (this.i) {
            Z z = Z.b;
            Y.a();
            Z.a("Core", "iframe '" + str + "' hidden (hitbox " + dValueOf + "x" + dValueOf2 + " visible:" + zOptBoolean + ") — webview viewport " + getWidth() + "x" + getHeight() + "px");
        }
        b(str);
    }

    public final void a(final List cmd, final Function2 function2) {
        final List list;
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        final String string = function2 != null ? UUID.randomUUID().toString() : null;
        if (string != null) {
            ConcurrentHashMap concurrentHashMap = this.g;
            Intrinsics.checkNotNull(function2);
            concurrentHashMap.put(string, function2);
            List mutableList = CollectionsKt.toMutableList((Collection) cmd);
            if (!mutableList.isEmpty() && (mutableList.get(0) instanceof String)) {
                mutableList.set(0, mutableList.get(0) + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + string);
            }
            list = mutableList;
        } else {
            list = cmd;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0303g0.a(this.f$0, string, cmd, function2, list);
            }
        });
    }

    public final void a(JSONObject jSONObject) {
        Function2 function2;
        String strOptString;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("args");
        String strOptString2 = (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) ? null : jSONArrayOptJSONArray.optString(0);
        if (strOptString2 != null && ((Intrinsics.areEqual(strOptString2, "targeting.debug") || Intrinsics.areEqual(strOptString2, "debug")) && (strOptString = jSONObject.optString("response")) != null)) {
            Intrinsics.areEqual(strOptString, "");
        }
        String strOptString3 = jSONObject.optString("cmd_id");
        if (strOptString3 == null || strOptString3.length() <= 0 || (function2 = (Function2) this.g.remove(strOptString3)) == null) {
            String strOptString4 = jSONObject.optString("error");
            if (strOptString4 != null) {
                Intrinsics.areEqual(strOptString4, "");
                return;
            }
            return;
        }
        String strOptString5 = jSONObject.optString("error");
        if (strOptString5 == null || strOptString5.length() <= 0) {
            function2.invoke(jSONObject.opt("response"), null);
        } else {
            function2.invoke(null, new Exception(strOptString5));
        }
    }

    public final void b(String str) {
        if (this.l) {
            if (str != null) {
                this.h.remove(str);
            }
            h();
            return;
        }
        if (str != null) {
            this.h.remove(str);
        } else {
            this.h.clear();
        }
        if (this.h.isEmpty()) {
            if (this.i) {
                Z.a("Core", getVisibility() != 8 ? "Screeb frame is now hidden" : "Screeb frame remains hidden");
            }
            setVisibility(4);
            setImportantForAccessibility(2);
            setClickable(false);
            setZ(0.0f);
        }
    }

    public final void b(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("hook");
        Intrinsics.checkNotNull(strOptString);
        if (strOptString.length() == 0) {
            return;
        }
        Object obj = this.f.get(strOptString);
        Function1 function1 = TypeIntrinsics.isFunctionOfArity(obj, 1) ? (Function1) obj : null;
        if (function1 == null) {
            return;
        }
        Object objOpt = jSONObject.opt("payload");
        if (objOpt == null) {
            objOpt = new JSONObject();
        }
        Object objInvoke = function1.invoke(objOpt);
        if (Screeb.INSTANCE.isPendingHookResult$sdk_release(objInvoke)) {
            return;
        }
        a(strOptString, objInvoke);
    }

    public final void c() {
        final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(getContext());
        Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
        Task<ReviewInfo> taskRequestReviewFlow = reviewManagerCreate.requestReviewFlow();
        Intrinsics.checkNotNullExpressionValue(taskRequestReviewFlow, "requestReviewFlow(...)");
        taskRequestReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda13
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                C0303g0.a(this.f$0, reviewManagerCreate, task);
            }
        });
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void c(String str) {
        JSONObject jSONObjectOptJSONObject;
        String strOptString;
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString2 = jSONObject.optString(com.google.firebase.messaging.Constants.MessagePayloadKeys.FROM);
            if (strOptString2 != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("event")) != null && (strOptString = jSONObjectOptJSONObject.optString("type")) != null) {
                if (this.i) {
                    Z z = Z.b;
                    Y.a();
                    Z.a("Command", "message type received: " + strOptString + ", object: " + jSONObject);
                }
                switch (strOptString.hashCode()) {
                    case -1982282012:
                        if (strOptString.equals("query.dom-element.pick")) {
                            setInspect(true);
                            return;
                        }
                        return;
                    case -1922744303:
                        if (strOptString.equals("side-effect.close")) {
                            g();
                            return;
                        }
                        return;
                    case -1837741773:
                        if (strOptString.equals("command.return")) {
                            a(jSONObjectOptJSONObject);
                            return;
                        }
                        return;
                    case -1533497108:
                        if (strOptString.equals("webview.schedule")) {
                            long jOptLong = -1;
                            if (jSONObjectOptJSONObject.has("inMs") && !jSONObjectOptJSONObject.isNull("inMs")) {
                                jOptLong = jSONObjectOptJSONObject.optLong("inMs", -1L);
                            }
                            Screeb.INSTANCE.onWebviewSchedule$sdk_release(jOptLong >= 0 ? Long.valueOf(jOptLong) : null, jSONObjectOptJSONObject.optBoolean("needsActivity", false));
                            return;
                        }
                        return;
                    case -1383378159:
                        if (strOptString.equals("booted") && Intrinsics.areEqual(strOptString2, "core")) {
                            f();
                            return;
                        }
                        return;
                    case -1240787712:
                        if (strOptString.equals("widget.appstore-rating")) {
                            c();
                            return;
                        }
                        return;
                    case -810476964:
                        if (strOptString.equals("webview.mirror.stop")) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda12
                                @Override // java.lang.Runnable
                                public final void run() {
                                    C0303g0.c(this.f$0);
                                }
                            });
                            return;
                        }
                        return;
                    case 3208483:
                        if (strOptString.equals("hook")) {
                            b(jSONObjectOptJSONObject);
                            return;
                        }
                        return;
                    case 645004616:
                        if (strOptString.equals("webview.mirror.start") && !this.k) {
                            String strOptString3 = jSONObjectOptJSONObject.optString("mode", "screenshot");
                            Intrinsics.checkNotNull(strOptString3);
                            String lowerCase = strOptString3.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            final U u = Intrinsics.areEqual(lowerCase, "outline") ? U.OUTLINE : U.SCREENSHOT;
                            if (this.j == null) {
                                C0291a0 c0291a0 = new C0291a0(this, u);
                                c0291a0.c();
                                this.j = c0291a0;
                            }
                            final boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("anonymize", false);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda11
                                @Override // java.lang.Runnable
                                public final void run() {
                                    C0303g0.a(this.f$0, zOptBoolean, u);
                                }
                            });
                            return;
                        }
                        return;
                    case 706010727:
                        if (!strOptString.equals("query.dom-element.pick.result")) {
                            return;
                        }
                        break;
                    case 780786515:
                        if (strOptString.equals("iframe.update")) {
                            a(strOptString2, jSONObjectOptJSONObject);
                            return;
                        }
                        return;
                    case 871322352:
                        if (!strOptString.equals("query.dom-element.pick.destroy")) {
                            return;
                        }
                        break;
                    case 948051998:
                        if (strOptString.equals("webview.debug")) {
                            setDebugMode(!this.i);
                            return;
                        }
                        return;
                    case 1384416848:
                        if (strOptString.equals("widget.destroy")) {
                            final String strOptString4 = jSONObjectOptJSONObject.optString("iframeId", "");
                            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                            if (Intrinsics.areEqual(strOptString4, "")) {
                                return;
                            }
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda10
                                @Override // java.lang.Runnable
                                public final void run() {
                                    C0303g0.c(this.f$0, strOptString4);
                                }
                            }, 100L);
                            return;
                        }
                        return;
                    default:
                        return;
                }
                setInspect(false);
            }
        } catch (Throwable th) {
            Z z2 = Z.b;
            Y.a();
            Z.a("Command", "error while handling message", th, 8);
        }
    }

    public final void d() {
        if (this.i) {
            h();
            if (this.u == null) {
                this.v = 0L;
                this.w = 0L;
                this.x = 0;
                this.y = 0.0d;
                this.z = 0.0d;
                this.A = 0;
                ChoreographerFrameCallbackC0301f0 choreographerFrameCallbackC0301f0 = new ChoreographerFrameCallbackC0301f0(this);
                this.u = choreographerFrameCallbackC0301f0;
                Choreographer.getInstance().postFrameCallback(choreographerFrameCallbackC0301f0);
            }
        } else {
            ChoreographerFrameCallbackC0301f0 choreographerFrameCallbackC0301f1 = this.u;
            if (choreographerFrameCallbackC0301f1 != null) {
                Choreographer.getInstance().removeFrameCallback(choreographerFrameCallbackC0301f1);
            }
            this.u = null;
        }
        WebView.setWebContentsDebuggingEnabled(this.i);
        invalidate();
    }

    @Override // android.webkit.WebView
    public final void destroy() {
        this.e = false;
        ChoreographerFrameCallbackC0301f0 choreographerFrameCallbackC0301f0 = this.u;
        if (choreographerFrameCallbackC0301f0 != null) {
            Choreographer.getInstance().removeFrameCallback(choreographerFrameCallbackC0301f0);
        }
        this.u = null;
        C0291a0 c0291a0 = this.j;
        if (c0291a0 != null) {
            c0291a0.a.g();
            A a = c0291a0.c;
            if (a != null) {
                a.b();
            }
            c0291a0.c = null;
        }
        super.destroy();
    }

    public final void f() {
        this.h.clear();
        if (!this.g.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.g.values());
            this.g.clear();
            Exception exc = new Exception("webview reloaded before the command completed");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    ((Function2) it.next()).invoke(null, exc);
                } catch (Exception e) {
                    Z z = Z.b;
                    Z z2 = Z.b;
                    Z z3 = Z.b;
                    Z.a("Command", "error in stale command callback", e, 8);
                }
            }
        }
        this.e = true;
        Function0 function0 = this.c;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void g() {
        b((String) null);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                C0303g0.d(this.f$0);
            }
        });
    }

    public final ConcurrentHashMap<String, Object> getHooksRegistry() {
        return this.f;
    }

    public final boolean getInspectMode() {
        return this.l;
    }

    public final C0291a0 getMirror$sdk_release() {
        return this.j;
    }

    public final boolean getMirrorDisabled() {
        return this.k;
    }

    public final Function2 getOnBridgeUnavailable() {
        return this.d;
    }

    public final Function0 getOnRecover() {
        return this.a;
    }

    public final Function0 getOnSdkLoaded() {
        return this.c;
    }

    public final boolean getReplayTelemetry() {
        return this.B;
    }

    public final String getSdkOrigin() {
        return this.m;
    }

    public final void h() {
        if (this.i) {
            Z.a("Core", getVisibility() != 0 ? "Screeb frame is now visible" : "Screeb frame remains visible");
        }
        setVisibility(0);
        setImportantForAccessibility(1);
        setClickable(true);
        setZ(1000000.0f);
        bringToFront();
        post(new Runnable() { // from class: app.screeb.sdk.internal.g0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0303g0.e(this.f$0);
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.i) {
            if (!this.h.isEmpty()) {
                getHitBoxPaint().setStrokeWidth(getResources().getDisplayMetrics().density * 3.0f);
                for (Object obj : this.h.values()) {
                    Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                    canvas.drawRect((Rect) obj, getHitBoxPaint());
                }
            }
            a(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.l || !this.h.isEmpty();
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        C0291a0 c0291a0 = this.j;
        if (c0291a0 != null) {
            c0291a0.b();
        }
        if (this.l) {
            return super.onTouchEvent(event);
        }
        if (this.h.isEmpty()) {
            return false;
        }
        for (Object obj : this.h.values()) {
            Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
            if (((Rect) obj).contains((int) event.getX(), (int) event.getY())) {
                return super.onTouchEvent(event);
            }
        }
        return false;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onVisibilityChanged(View changedView, int i) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, i);
        if (Build.VERSION.SDK_INT >= 26) {
            if (i == 0) {
                setRendererPriorityPolicy(2, false);
            } else {
                setRendererPriorityPolicy(1, true);
            }
        }
    }

    public final void setDebugMode(boolean z) {
        this.i = z;
        C0291a0 c0291a0 = this.j;
        if (c0291a0 != null) {
            c0291a0.a.getClass();
        }
        d();
        if (this.i || this.B) {
            Intrinsics.checkNotNullParameter(this, "view");
        }
    }

    public final void setHardwareLayer(boolean z) {
        int i = z ? 2 : 0;
        if (getLayerType() != i) {
            setLayerType(i, null);
        }
    }

    public final void setHooksRegistry(ConcurrentHashMap<String, Object> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
        this.f = concurrentHashMap;
    }

    public final void setInspect(boolean z) {
        if (this.l == z) {
            return;
        }
        this.l = z;
        a("el.style.pointerEvents = '" + (z ? "auto" : "none") + "';" + (z ? " el.style.userSelect='none'; el.style.webkitUserSelect='none'; el.style.webkitTouchCallout='none';" : ""));
        if (z) {
            h();
            invalidate();
        }
    }

    public final void setInspectMode(boolean z) {
        this.l = z;
    }

    public final void setMirror$sdk_release(C0291a0 c0291a0) {
        this.j = c0291a0;
    }

    public final void setMirrorDisabled(boolean z) {
        this.k = z;
    }

    public final void setOnBridgeUnavailable(Function2 function2) {
        this.d = function2;
    }

    public final void setOnSdkLoaded(Function0 function0) {
        this.c = function0;
    }

    public final void setReplayTelemetry(boolean z) {
        this.B = z;
        C0291a0 c0291a0 = this.j;
        if (c0291a0 != null) {
            c0291a0.a.getClass();
        }
        if (this.i || this.B) {
            Intrinsics.checkNotNullParameter(this, "view");
        }
    }

    public final void setSdkLoaded(boolean z) {
        this.e = z;
    }

    public final void setSdkOrigin(String str) {
        this.m = str;
    }
}
