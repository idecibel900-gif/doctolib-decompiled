package androidx.compose.material3.adaptive;

import androidx.window.core.layout.WindowSizeClass;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class WindowAdaptiveInfo {
    private final Posture windowPosture;
    private final WindowSizeClass windowSizeClass;

    public WindowAdaptiveInfo(WindowSizeClass windowSizeClass, Posture posture) {
        this.windowSizeClass = windowSizeClass;
        this.windowPosture = posture;
    }

    public final WindowSizeClass getWindowSizeClass() {
        return this.windowSizeClass;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowAdaptiveInfo)) {
            return false;
        }
        WindowAdaptiveInfo windowAdaptiveInfo = (WindowAdaptiveInfo) obj;
        return Intrinsics.areEqual(this.windowSizeClass, windowAdaptiveInfo.windowSizeClass) && Intrinsics.areEqual(this.windowPosture, windowAdaptiveInfo.windowPosture);
    }

    public int hashCode() {
        return (this.windowSizeClass.hashCode() * 31) + this.windowPosture.hashCode();
    }

    public String toString() {
        return "WindowAdaptiveInfo(windowSizeClass=" + this.windowSizeClass + ", windowPosture=" + this.windowPosture + ')';
    }
}
