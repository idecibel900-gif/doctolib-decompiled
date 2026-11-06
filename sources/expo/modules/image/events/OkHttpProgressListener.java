package expo.modules.image.events;

import com.facebook.react.modules.network.ProgressListener;
import expo.modules.image.ExpoImageViewWrapper;
import expo.modules.image.records.ImageProgressEvent;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OkHttpProgressListener implements ProgressListener {
    private final WeakReference expoImageViewWrapper;

    public OkHttpProgressListener(WeakReference expoImageViewWrapper) {
        Intrinsics.checkNotNullParameter(expoImageViewWrapper, "expoImageViewWrapper");
        this.expoImageViewWrapper = expoImageViewWrapper;
    }

    @Override // com.facebook.react.modules.network.ProgressListener
    public void onProgress(long j, long j2, boolean z) {
        ExpoImageViewWrapper expoImageViewWrapper;
        ViewEventCallback onProgress$expo_image_release;
        if (j2 <= 0 || z || (expoImageViewWrapper = (ExpoImageViewWrapper) this.expoImageViewWrapper.get()) == null || (onProgress$expo_image_release = expoImageViewWrapper.getOnProgress$expo_image_release()) == null) {
            return;
        }
        onProgress$expo_image_release.invoke(new ImageProgressEvent((int) j, (int) j2));
    }
}
