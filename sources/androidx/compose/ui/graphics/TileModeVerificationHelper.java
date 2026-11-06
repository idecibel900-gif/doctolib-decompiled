package androidx.compose.ui.graphics;

import android.graphics.Shader;

/* JADX INFO: loaded from: classes.dex */
final class TileModeVerificationHelper {
    public static final TileModeVerificationHelper INSTANCE = new TileModeVerificationHelper();

    private TileModeVerificationHelper() {
    }

    public final Shader.TileMode getFrameworkTileModeDecal() {
        return Shader.TileMode.DECAL;
    }

    /* JADX INFO: renamed from: getComposeTileModeDecal-3opZhB0, reason: not valid java name */
    public final int m1518getComposeTileModeDecal3opZhB0() {
        return TileMode.Companion.m1515getDecal3opZhB0();
    }
}
