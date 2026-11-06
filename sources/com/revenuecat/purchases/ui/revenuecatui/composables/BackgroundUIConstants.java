package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/BackgroundUIConstants;", "", "()V", "blurAlpha", "", "blurSize", "Landroidx/compose/ui/unit/Dp;", "getBlurSize-D9Ej5fM", "()F", "F", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "minSDKVersionSupportingBlur", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BackgroundUIConstants {
    public static final float blurAlpha = 0.7f;
    public static final int minSDKVersionSupportingBlur = 31;
    public static final BackgroundUIConstants INSTANCE = new BackgroundUIConstants();
    private static final float blurSize = Dp.m2551constructorimpl(60);
    private static final ContentScale contentScale = ContentScale.Companion.getCrop();

    private BackgroundUIConstants() {
    }

    /* JADX INFO: renamed from: getBlurSize-D9Ej5fM, reason: not valid java name */
    public final float m4226getBlurSizeD9Ej5fM() {
        return blurSize;
    }

    public final ContentScale getContentScale() {
        return contentScale;
    }
}
