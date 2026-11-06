package androidx.compose.ui.graphics;

import android.graphics.Shader;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidTileMode_androidKt {
    /* JADX INFO: renamed from: toAndroidTileMode-0vamqd0, reason: not valid java name */
    public static final Shader.TileMode m1310toAndroidTileMode0vamqd0(int i) {
        TileMode.Companion companion = TileMode.Companion;
        if (TileMode.m1511equalsimpl0(i, companion.m1514getClamp3opZhB0())) {
            return Shader.TileMode.CLAMP;
        }
        if (TileMode.m1511equalsimpl0(i, companion.m1517getRepeated3opZhB0())) {
            return Shader.TileMode.REPEAT;
        }
        if (TileMode.m1511equalsimpl0(i, companion.m1516getMirror3opZhB0())) {
            return Shader.TileMode.MIRROR;
        }
        if (TileMode.m1511equalsimpl0(i, companion.m1515getDecal3opZhB0())) {
            if (Build.VERSION.SDK_INT >= 31) {
                return TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal();
            }
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.CLAMP;
    }
}
