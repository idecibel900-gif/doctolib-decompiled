package com.facebook.react.modules.i18nmanager;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.text.TextUtilsCompat;
import com.amazon.a.a.o.b;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class I18nUtil {
    public static final Companion Companion = new Companion(null);
    private static final I18nUtil instance = new I18nUtil();

    public static final I18nUtil getInstance() {
        return Companion.getInstance();
    }

    private I18nUtil() {
    }

    public final boolean isRTL(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!applicationHasRtlSupport(context)) {
            return false;
        }
        if (isRTLForced(context)) {
            return true;
        }
        return isRTLAllowed(context) && isDevicePreferredLanguageRTL();
    }

    private final boolean applicationHasRtlSupport(Context context) {
        return (context.getApplicationInfo().flags & 4194304) != 0;
    }

    private final boolean isRTLAllowed(Context context) {
        return isPrefSet(context, "RCTI18nUtil_allowRTL", true);
    }

    public final void allowRTL(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        setPref(context, "RCTI18nUtil_allowRTL", z);
    }

    public final boolean doLeftAndRightSwapInRTL(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isPrefSet(context, "RCTI18nUtil_makeRTLFlipLeftAndRightStyles", true);
    }

    public final void swapLeftAndRightInRTL(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        setPref(context, "RCTI18nUtil_makeRTLFlipLeftAndRightStyles", z);
    }

    private final boolean isRTLForced(Context context) {
        return isPrefSet(context, "RCTI18nUtil_forceRTL", false) || StringsKt.equals(System.getProperty("FORCE_RTL_FOR_TESTING", b.ag), b.af, true);
    }

    public final void forceRTL(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        setPref(context, "RCTI18nUtil_forceRTL", z);
    }

    private final boolean isDevicePreferredLanguageRTL() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getAvailableLocales()[0]) == 1;
    }

    private final boolean isPrefSet(Context context, String str, boolean z) {
        return context.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).getBoolean(str, z);
    }

    private final void setPref(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final I18nUtil getInstance() {
            return I18nUtil.instance;
        }
    }
}
