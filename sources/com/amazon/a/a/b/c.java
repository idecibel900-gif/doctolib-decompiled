package com.amazon.a.a.b;

import android.app.ActivityManager;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import com.amazon.a.a.o.e;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class c implements Serializable {
    private static final String A = "deviceDisplay";
    private static final String B = "deviceBrand";
    private static final String C = "deviceBoard";
    private static final String D = "androidVersion";
    private static final String E = "deviceModel";
    private static final String F = "packageFilePath";
    private static final String G = "packageName";
    private static final String H = "packageVersionName";
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("CrashReport");
    private static final long b = 1;
    private static final String c = "([a-zA-Z0-9_.]+(Exception|Error))|(at\\s.*\\(.*\\))";
    private static final String d = "SHA1";
    private static final String e = "crashTime";
    private static final String f = "UTF-8";
    private static final String g = "crashId";
    private static final String h = "threadDump";
    private static final String i = "stackTrace";
    private static final String j = "threadAllocSize";
    private static final String k = "threadAllocCount";
    private static final String l = "nativeHeapFreeSize";
    private static final String m = "nativeHeapSize";
    private static final String n = "memLowThreshold";
    private static final String o = "memLowFlag";
    private static final String p = "availableInternalMemorySize";
    private static final String q = "totalInternalMemorySize";
    private static final String r = "deviceUser";
    private static final String s = "deviceType";
    private static final String t = "deviceTime";
    private static final String u = "deviceTags";
    private static final String v = "deviceProduct";
    private static final String w = "deviceManufacturer";
    private static final String x = "deviceId";
    private static final String y = "deviceHost";
    private static final String z = "deviceFingerPrint";
    private final HashMap<String, String> I = new LinkedHashMap();

    public c(Application application, Throwable th) {
        try {
            a(application, th);
        } catch (Throwable th2) {
            if (com.amazon.a.a.o.c.b) {
                a.b("Error collection crash report details", th2);
            }
        }
    }

    private void a(Application application, Throwable th) {
        b();
        a(application);
        c(application);
        a(th);
        e();
        f();
    }

    private void b() {
        this.I.put(e, new Date().toString());
    }

    private void a(Application application) {
        PackageInfo packageInfoB = b(application);
        if (packageInfoB == null) {
            return;
        }
        this.I.put(H, packageInfoB.versionName);
        this.I.put(G, packageInfoB.packageName);
        this.I.put(F, application.getFilesDir().getAbsolutePath());
    }

    private PackageInfo b(Application application) {
        try {
            return application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (!com.amazon.a.a.o.c.b) {
                return null;
            }
            a.b("Unable to fetch package info", e2);
            return null;
        }
    }

    private void c(Application application) {
        this.I.put(E, Build.MODEL);
        this.I.put(D, Build.VERSION.RELEASE);
        this.I.put(C, Build.BOARD);
        this.I.put(B, Build.BRAND);
        this.I.put(A, Build.DISPLAY);
        this.I.put(z, Build.FINGERPRINT);
        this.I.put(y, Build.HOST);
        this.I.put(x, Build.ID);
        this.I.put(w, Build.MANUFACTURER);
        this.I.put(v, Build.PRODUCT);
        this.I.put(u, Build.TAGS);
        this.I.put(t, Long.toString(Build.TIME));
        this.I.put(s, Build.TYPE);
        this.I.put(r, Build.USER);
        this.I.put(q, Long.toString(d()));
        this.I.put(p, Long.toString(c()));
        ActivityManager activityManager = (ActivityManager) application.getSystemService("activity");
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            this.I.put(o, Boolean.toString(memoryInfo.lowMemory));
            this.I.put(n, Long.toString(memoryInfo.threshold));
        }
        this.I.put(m, Long.toString(Debug.getNativeHeapSize()));
        this.I.put(l, Long.toString(Debug.getNativeHeapAllocatedSize()));
        this.I.put(k, Long.toString(Debug.getThreadAllocCount()));
        this.I.put(j, Long.toString(Debug.getThreadAllocSize()));
    }

    private long c() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    private long d() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    private void a(Throwable th) {
        StringBuilder sb = new StringBuilder();
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        sb.append(stringWriter.toString());
        sb.append("\n");
        Throwable cause = th.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            sb.append(stringWriter.toString());
            cause = cause.getCause();
            sb.append("\n\n");
        }
        printWriter.close();
        this.I.put(i, sb.toString());
    }

    private void e() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            sb.append("Thread : " + key.getId());
            if (!e.a(key.getName())) {
                sb.append("/" + key.getName());
            }
            sb.append("\n");
            sb.append("isAlive : " + key.isAlive() + "\n");
            sb.append("isInterrupted : " + key.isInterrupted() + "\n");
            sb.append("isDaemon : " + key.isDaemon() + "\n");
            for (StackTraceElement stackTraceElement : value) {
                sb.append("\tat " + stackTraceElement + "\n");
            }
            sb.append("\n\n");
        }
        this.I.put(h, sb.toString());
    }

    private void f() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.I.get(G));
            sb.append(this.I.get(H));
            sb.append(this.I.get(D));
            String str = this.I.get(i);
            if (str != null) {
                Matcher matcher = Pattern.compile(c).matcher(str);
                while (matcher.find()) {
                    sb.append(matcher.group());
                }
            }
            this.I.put(g, new BigInteger(MessageDigest.getInstance(d).digest(sb.toString().getBytes("UTF-8"))).abs().toString(16));
        } catch (Exception e2) {
            if (com.amazon.a.a.o.c.b) {
                a.b("Error capturing crash id", e2);
            }
        }
    }

    public Map<String, String> a() {
        return this.I;
    }
}
