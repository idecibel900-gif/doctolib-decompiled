package com.swmansion.rnscreens;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.fabric.FabricUIManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0086 ¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tH\u0086 ¢\u0006\u0004\b\f\u0010\u0003J\u0010\u0010\r\u001a\u00020\tH\u0086 ¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0014\u0010\u0003¨\u0006\u0016"}, d2 = {"Lcom/swmansion/rnscreens/NativeProxy;", "", "<init>", "()V", "Lcom/facebook/jni/HybridData;", "initHybrid", "()Lcom/facebook/jni/HybridData;", "Lcom/facebook/react/fabric/FabricUIManager;", "fabricUIManager", "", "nativeAddMutationsListener", "(Lcom/facebook/react/fabric/FabricUIManager;)V", "cleanupExpiredMountingCoordinators", "invalidateNative", "", "screenTag", "notifyScreenRemoved", "(I)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "getMHybridData$annotations", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeProxy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap viewsMap = new ConcurrentHashMap();

    @DoNotStrip
    private final HybridData mHybridData = initHybrid();

    private final native HybridData initHybrid();

    public final native void cleanupExpiredMountingCoordinators();

    public final native void invalidateNative();

    public final native void nativeAddMutationsListener(FabricUIManager fabricUIManager);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void addScreenToMap(int i, Screen view) {
            Intrinsics.checkNotNullParameter(view, "view");
            NativeProxy.viewsMap.put(Integer.valueOf(i), new WeakReference(view));
        }

        public final void removeScreenFromMap(int i) {
            NativeProxy.viewsMap.remove(Integer.valueOf(i));
        }

        public final void clearMapOnInvalidate() {
            NativeProxy.viewsMap.clear();
        }
    }

    @DoNotStrip
    public final void notifyScreenRemoved(int screenTag) {
        final Screen screen;
        WeakReference weakReference = (WeakReference) viewsMap.get(Integer.valueOf(screenTag));
        if (weakReference == null || (screen = (Screen) weakReference.get()) == null) {
            return;
        }
        screen.post(new Runnable() { // from class: com.swmansion.rnscreens.NativeProxy$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                screen.startRemovalTransition();
            }
        });
    }
}
