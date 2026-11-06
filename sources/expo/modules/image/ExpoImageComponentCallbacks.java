package expo.modules.image;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import expo.modules.image.blurhash.BlurhashDecoder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ExpoImageComponentCallbacks implements ComponentCallbacks2 {
    public static final ExpoImageComponentCallbacks INSTANCE = new ExpoImageComponentCallbacks();

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    private ExpoImageComponentCallbacks() {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        BlurhashDecoder.INSTANCE.clearCache();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 15) {
            onLowMemory();
        }
    }
}
