package io.didomi.ssl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001c\u0010\u0004\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0007\u001a\n\u0010\u000b\u001a\u00020\n*\u00020\u0000¨\u0006\f"}, d2 = {"Landroid/content/Context;", "", "b", "Landroid/view/accessibility/AccessibilityManager;", "a", "", "path", "name", "type", "", "", "c", "android_release"}, k = 2, mv = {1, 8, 0})
public final class w0 {
    public static final AccessibilityManager a(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        return (AccessibilityManager) systemService;
    }

    public static final boolean c(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.getPackageManager().getPackageInfo("com.google.android.webview", PackageManager.PackageInfoFlags.of(1L));
            } else {
                context.getPackageManager().getPackageInfo("com.google.android.webview", 1);
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static final String a(Context context, String path) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            InputStream inputStreamOpen = context.getAssets().open(path);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "assets.open(path)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charsets.UTF_8), 8192);
            try {
                String text = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                return text;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReader, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            Log.e("Can't open '" + path + "' from assets", e);
            return "";
        }
    }

    public static final float b(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    @SuppressLint({"DiscouragedApi"})
    public static final int a(Context context, String name, String type) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            return context.getResources().getIdentifier(name, type, context.getPackageName());
        } catch (Exception e) {
            Log.e("Can't get '" + name + "' as '" + type + "' from resources", e);
            return -1;
        }
    }
}
