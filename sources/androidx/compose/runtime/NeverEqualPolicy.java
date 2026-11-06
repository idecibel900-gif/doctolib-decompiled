package androidx.compose.runtime;

/* JADX INFO: loaded from: classes.dex */
final class NeverEqualPolicy implements SnapshotMutationPolicy {
    public static final NeverEqualPolicy INSTANCE = new NeverEqualPolicy();

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public boolean equivalent(Object obj, Object obj2) {
        return false;
    }

    private NeverEqualPolicy() {
    }

    public String toString() {
        return "NeverEqualPolicy";
    }
}
