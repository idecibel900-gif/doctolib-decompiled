package androidx.compose.ui.graphics;

/* JADX INFO: loaded from: classes.dex */
final class BlendModeColorFilterHelper {
    public static final BlendModeColorFilterHelper INSTANCE = new BlendModeColorFilterHelper();

    private BlendModeColorFilterHelper() {
    }

    /* JADX INFO: renamed from: BlendModeColorFilter-xETnrds, reason: not valid java name */
    public final android.graphics.BlendModeColorFilter m1346BlendModeColorFilterxETnrds(long j, int i) {
        BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline1.m();
        return BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline0.m(ColorKt.m1393toArgb8_81llA(j), AndroidBlendMode_androidKt.m1270toAndroidBlendModes9anfk8(i));
    }

    public final BlendModeColorFilter createBlendModeColorFilter(android.graphics.BlendModeColorFilter blendModeColorFilter) {
        return new BlendModeColorFilter(ColorKt.Color(blendModeColorFilter.getColor()), AndroidBlendMode_androidKt.toComposeBlendMode(blendModeColorFilter.getMode()), blendModeColorFilter, null);
    }
}
