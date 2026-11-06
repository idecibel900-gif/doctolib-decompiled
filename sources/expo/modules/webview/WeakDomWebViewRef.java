package expo.modules.webview;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class WeakDomWebViewRef {
    private final WeakReference ref;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WeakDomWebViewRef) && Intrinsics.areEqual(this.ref, ((WeakDomWebViewRef) obj).ref);
    }

    public int hashCode() {
        return this.ref.hashCode();
    }

    public String toString() {
        return "WeakDomWebViewRef(ref=" + this.ref + ")";
    }

    public WeakDomWebViewRef(WeakReference ref) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        this.ref = ref;
    }

    public final WeakReference getRef() {
        return this.ref;
    }
}
