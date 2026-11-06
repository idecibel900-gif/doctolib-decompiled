package com.revenuecat.purchases.ui.revenuecatui.activity;

import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"DEFAULT_DISPLAY_DISMISS_BUTTON", "", "defaultEdgeToEdge", "getDefaultEdgeToEdge", "()Z", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallActivityArgsKt {
    public static final boolean DEFAULT_DISPLAY_DISMISS_BUTTON = true;
    private static final boolean defaultEdgeToEdge;

    static {
        defaultEdgeToEdge = Build.VERSION.SDK_INT >= 35;
    }

    public static final boolean getDefaultEdgeToEdge() {
        return defaultEdgeToEdge;
    }
}
