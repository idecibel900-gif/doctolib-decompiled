package com.amazon.a.a.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes3.dex */
public class g extends h implements com.amazon.a.a.k.d {
    public static final long b = 31536000;
    private static final com.amazon.a.a.o.c e = new com.amazon.a.a.o.c("ShutdownPrompt");
    private static final String f = "https://www.amazon.com/appstore-error-help";
    private static final String g = "badcert";
    private static final String h = "1.1";

    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a i;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c j;

    @Override // com.amazon.a.a.e.c
    protected long h() {
        return b;
    }

    public g(c cVar) {
        super(cVar, h.a.EXTENDED);
        e.a("new ShutdownPrompt called!");
    }

    @Override // com.amazon.a.a.i.h
    protected void i() {
        a(0);
    }

    @Override // com.amazon.a.a.i.h
    protected void a(int i) {
        com.amazon.a.a.o.c cVar = e;
        cVar.a("doAction(" + i + ")");
        c.a[] aVarArrC = ((h) this).c.c();
        c.a aVar = c.a.DEFAULT;
        c.a aVar2 = i < aVarArrC.length ? aVarArrC[i] : aVar;
        if (aVar2 == c.a.HELP) {
            cVar.a("doAction() help");
            m();
        } else if (aVar2 == c.a.DEEPLINK) {
            cVar.a("doAction() deeplink");
            a(g);
        } else if (aVar2 == aVar) {
            b(this.i);
        }
    }

    @Override // com.amazon.a.a.e.a
    public void b() {
        this.i.g();
    }

    public String toString() {
        return "ShutdownPrompt";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.amazon.a.a.a.a aVar) {
        com.amazon.a.a.o.c cVar = e;
        cVar.a("doShutdown()");
        cVar.c("Killing application");
        System.exit(0);
    }

    protected void m() {
        com.amazon.a.a.o.c cVar = e;
        cVar.a("Store contains " + this.j.toString());
        if (!((h) this).c.i()) {
            cVar.a("Should not show fixup");
            new a(this.i).execute(new Void[0]);
        } else {
            cVar.a("Should show fixup");
            Activity activityA = this.i.a();
            a(activityA, a((Context) activityA));
            cVar.a("Attempted to start browser.");
        }
    }

    private final Intent a(Context context) {
        String packageName = context.getPackageName();
        StringBuilder sb = new StringBuilder(f);
        PackageManager packageManager = context.getPackageManager();
        a(sb, "?k=", h);
        a(sb, "&m=", ((h) this).c.e());
        a(sb, "&ec=", String.valueOf(((h) this).c.g()));
        String str = (String) this.j.a(com.amazon.a.a.m.c.f);
        if (str != null) {
            a(sb, "&t=", str);
            a(sb, "&tv=", str, packageManager);
        }
        String str2 = (String) this.j.a(com.amazon.a.a.m.c.g);
        if (str2 != null) {
            a(sb, "&c=", str2);
        }
        String str3 = (String) this.j.a(com.amazon.a.a.m.c.d);
        if (str3 != null) {
            a(sb, "&e=", str3);
        }
        String str4 = Build.PRODUCT;
        if (str4 != null) {
            a(sb, "&d=", str4);
        }
        String str5 = Build.MANUFACTURER;
        if (str5 != null) {
            a(sb, "&ma=", str5);
        }
        String str6 = Build.MODEL;
        if (str6 != null) {
            a(sb, "&mo=", str6);
        }
        String str7 = Build.ID;
        if (str7 != null) {
            a(sb, "&bn=", str7);
        }
        a(sb, "&sz=", String.valueOf(context.getResources().getConfiguration().screenLayout & 15));
        a(sb, "&s=", String.valueOf(Build.VERSION.SDK_INT));
        a(sb, "&p=", packageName);
        a(sb, "&pv=", packageName, packageManager);
        a(sb, "&l=", n());
        String strB = b(context);
        if (!TextUtils.isEmpty(strB)) {
            a(sb, "&mc=", strB);
        }
        String string = sb.toString();
        e.a("Starting browser for uri " + string);
        return new Intent("android.intent.action.VIEW", Uri.parse(string));
    }

    private final void a(StringBuilder sb, String str, String str2, PackageManager packageManager) {
        try {
            a(sb, str, String.valueOf(packageManager.getPackageInfo(str2, 0).versionCode));
        } catch (PackageManager.NameNotFoundException unused) {
            e.b("Could not find information for package " + str2);
        }
    }

    private final void a(StringBuilder sb, String str, String str2) {
        try {
            String strEncode = URLEncoder.encode(str2, Constants.ENCODING);
            sb.append(str);
            sb.append(strEncode);
        } catch (UnsupportedEncodingException e2) {
            e.b("Failed to URL-encode argument", e2);
        }
    }

    private String n() {
        return Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
    }

    private String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AuthorizationRequest.Scope.PHONE);
        if (telephonyManager == null) {
            e.a("tm was null!");
            return null;
        }
        com.amazon.a.a.o.c cVar = e;
        cVar.a("tm was not null.");
        int simState = telephonyManager.getSimState();
        if (simState != 5) {
            cVar.a("SIM not ready, returning null.  State was " + simState);
            return null;
        }
        return telephonyManager.getSimOperator();
    }

    private void a(String str) {
        e.a("Attempting to deep link to appstore.");
        Activity activityA = this.i.a();
        a(activityA, a(activityA, str));
    }

    private Intent a(Context context, String str) {
        return new Intent("android.intent.action.VIEW", Uri.parse("amzn://apps/android?p=" + context.getPackageName() + "&ref=" + str));
    }

    private void a(Context context, Intent intent) {
        if (!b(context, intent)) {
            e.b("Could not start activity, nothing resolves for the given data.");
            b(this.i);
        } else {
            new b(context, this.i).execute(intent);
        }
    }

    private boolean b(Context context, Intent intent) {
        intent.addFlags(268435456);
        return intent.resolveActivity(context.getPackageManager()) != null;
    }

    private static class a extends AsyncTask<Void, Void, Void> {
        private final com.amazon.a.a.a.a a;

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            return null;
        }

        private a(com.amazon.a.a.a.a aVar) {
            this.a = aVar;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r1) {
            g.b(this.a);
        }
    }

    @Override // com.amazon.a.a.i.h
    protected boolean a(c.a aVar) {
        Intent intentA;
        if (aVar == c.a.DEFAULT) {
            return true;
        }
        Activity activityA = this.i.a();
        if (aVar == c.a.DEEPLINK) {
            intentA = a(activityA, g);
        } else {
            intentA = aVar == c.a.HELP ? a((Context) activityA) : null;
        }
        if (intentA == null) {
            e.b("Unexpected action " + aVar + ", could not create intent.");
            return false;
        }
        return b(activityA, intentA);
    }

    private static class b extends AsyncTask<Intent, Void, Void> {
        private final Context a;
        private final com.amazon.a.a.a.a b;

        private b(Context context, com.amazon.a.a.a.a aVar) {
            this.a = context;
            this.b = aVar;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Intent... intentArr) {
            this.a.startActivity(intentArr[0]);
            return null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r1) {
            g.b(this.b);
        }
    }
}
