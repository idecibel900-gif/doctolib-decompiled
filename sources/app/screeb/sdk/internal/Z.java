package app.screeb.sdk.internal;

import android.os.Build;
import app.notifee.core.event.LogEvent;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.ExceptionsKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Z {
    public static final Z b = new Z();
    public static final ExecutorService c = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: app.screeb.sdk.internal.Z$$ExternalSyntheticLambda0
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return Z.a(runnable);
        }
    });
    public volatile String a;

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "screeb-log");
        thread.setDaemon(true);
        return thread;
    }

    public static void a(String text) {
        Z z = b;
        Intrinsics.checkNotNullParameter("Mirror", "tag");
        Intrinsics.checkNotNullParameter(text, "text");
        z.a("info", "Mirror", text, null, null);
    }

    public static void a(String tag, String text) {
        Z z = b;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(text, "text");
        z.a("debug", tag, text, null, null);
    }

    public static void a(String tag, String text, Throwable th, int i) {
        Z z = b;
        if ((i & 4) != 0) {
            th = null;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(text, "text");
        z.a("error", tag, text, th, null);
    }

    public static final void a(Throwable th, Object obj, String str, String str2, String str3, String str4, String str5) {
        try {
            ArrayList arrayList = new ArrayList();
            if (th != null) {
                arrayList.add(ExceptionsKt.stackTraceToString(th));
            }
            if (obj != null) {
                arrayList.add(obj.toString());
            }
            HashMap map = new HashMap();
            map.put("arguments", arrayList);
            map.put("visitor", MapsKt.hashMapOf(TuplesKt.to("channel_id", str)));
            String str6 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault()).format(new Date());
            HashMap map2 = new HashMap();
            map2.put("name", "screeb/sdk-android");
            map2.put(DiagnosticsEntry.VERSION_KEY, "4.4.0");
            HashMap map3 = new HashMap();
            map3.put("category", str2);
            map3.put("AndroidVersion", String.valueOf(Build.VERSION.SDK_INT));
            HashMap map4 = new HashMap();
            map4.put("environment", str3);
            map4.put("extra", map);
            map4.put("level", str4);
            map4.put("logger", str2);
            map4.put("message", str5);
            map4.put("platform", "android");
            map4.put("release", "4.4.0");
            map4.put("sdk", map2);
            map4.put("tags", map3);
            map4.put(DiagnosticsEntry.TIMESTAMP_KEY, str6);
            String string = new JSONObject(map4).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            URLConnection uRLConnectionOpenConnection = new URL("https://r.screeb.app/rpc/1.3.0/l?source=sdk-android").openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            try {
                httpURLConnection.setDoOutput(true);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes(string);
                dataOutputStream.flush();
                dataOutputStream.close();
                httpURLConnection.getResponseCode();
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(String tag, String text) {
        Z z = b;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(text, "text");
        z.a(LogEvent.LEVEL_WARN, tag, text, null, null);
    }

    public final void a(final String str, final String str2, final String str3, final Throwable th, final Object obj) {
        final String str4;
        int iHashCode = str.hashCode();
        if (iHashCode == 3237038 ? str.equals("info") : iHashCode == 3641990 ? str.equals(LogEvent.LEVEL_WARN) : iHashCode == 95458899 ? str.equals("debug") : iHashCode == 96784904 && str.equals("error")) {
            Objects.toString(th);
            Objects.toString(obj);
        }
        final String str5 = "prod";
        if ((Intrinsics.areEqual("prod", "dev") || Intrinsics.areEqual(str, "error")) && (str4 = this.a) != null) {
            c.execute(new Runnable() { // from class: app.screeb.sdk.internal.Z$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Z.a(th, obj, str4, str2, str5, str, str3);
                }
            });
        }
    }
}
