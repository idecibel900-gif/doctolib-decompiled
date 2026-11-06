package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;

/* JADX INFO: loaded from: classes.dex */
final class RenderEffectVerificationHelper {
    public static final RenderEffectVerificationHelper INSTANCE = new RenderEffectVerificationHelper();

    private RenderEffectVerificationHelper() {
    }

    /* JADX INFO: renamed from: createBlurEffect-8A-3gB4, reason: not valid java name */
    public final android.graphics.RenderEffect m1476createBlurEffect8A3gB4(RenderEffect renderEffect, float f, float f2, int i) {
        if (renderEffect == null) {
            return android.graphics.RenderEffect.createBlurEffect(f, f2, AndroidTileMode_androidKt.m1310toAndroidTileMode0vamqd0(i));
        }
        return android.graphics.RenderEffect.createBlurEffect(f, f2, renderEffect.asAndroidRenderEffect(), AndroidTileMode_androidKt.m1310toAndroidTileMode0vamqd0(i));
    }

    /* JADX INFO: renamed from: createOffsetEffect-Uv8p0NA, reason: not valid java name */
    public final android.graphics.RenderEffect m1477createOffsetEffectUv8p0NA(RenderEffect renderEffect, long j) {
        if (renderEffect == null) {
            return android.graphics.RenderEffect.createOffsetEffect(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j));
        }
        return android.graphics.RenderEffect.createOffsetEffect(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j), renderEffect.asAndroidRenderEffect());
    }
}
