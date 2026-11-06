package expo.modules.kotlin.views;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ShadowNodeProxy {
    private final WeakReference weakExpoView;

    public ShadowNodeProxy(ExpoView expoView) {
        Intrinsics.checkNotNullParameter(expoView, "expoView");
        this.weakExpoView = new WeakReference(expoView);
    }
}
