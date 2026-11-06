package androidx.compose.runtime.snapshots;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class SnapshotApplyResult {
    public /* synthetic */ SnapshotApplyResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SnapshotApplyResult() {
    }

    public static final class Success extends SnapshotApplyResult {
        public static final Success INSTANCE = new Success();

        private Success() {
            super(null);
        }
    }

    public static final class Failure extends SnapshotApplyResult {
        private final Snapshot snapshot;

        public Failure(Snapshot snapshot) {
            super(null);
            this.snapshot = snapshot;
        }
    }
}
