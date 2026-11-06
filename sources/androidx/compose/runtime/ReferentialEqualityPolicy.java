package androidx.compose.runtime;

/* JADX INFO: loaded from: classes.dex */
final class ReferentialEqualityPolicy implements SnapshotMutationPolicy {
    public static final ReferentialEqualityPolicy INSTANCE = new ReferentialEqualityPolicy();

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public boolean equivalent(Object obj, Object obj2) {
        return obj == obj2;
    }

    private ReferentialEqualityPolicy() {
    }

    public String toString() {
        return "ReferentialEqualityPolicy";
    }
}
