package androidx.compose.ui.platform;

/* JADX INFO: loaded from: classes.dex */
public abstract class NestedScrollInteropConnectionKt {
    private static final float ceilAwayFromZero(float f) {
        return (float) (f >= 0.0f ? Math.ceil(f) : Math.floor(f));
    }

    public static final int composeToViewOffset(float f) {
        return ((int) ceilAwayFromZero(f)) * (-1);
    }
}
