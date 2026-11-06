package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class OpaqueKey {
    private final String key;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OpaqueKey) && Intrinsics.areEqual(this.key, ((OpaqueKey) obj).key);
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return "OpaqueKey(key=" + this.key + ')';
    }

    public OpaqueKey(String str) {
        this.key = str;
    }
}
