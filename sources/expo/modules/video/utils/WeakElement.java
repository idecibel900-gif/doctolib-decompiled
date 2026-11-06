package expo.modules.video.utils;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
final class WeakElement extends WeakReference {
    private final int hash;

    public WeakElement(Object obj) {
        super(obj);
        this.hash = obj != null ? obj.hashCode() : 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeakElement(Object obj, ReferenceQueue q) {
        super(obj, q);
        Intrinsics.checkNotNullParameter(q, "q");
        this.hash = obj != null ? obj.hashCode() : 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WeakElement) {
            return this == obj || Intrinsics.areEqual(get(), ((WeakElement) obj).get());
        }
        return false;
    }

    public int hashCode() {
        return this.hash;
    }
}
