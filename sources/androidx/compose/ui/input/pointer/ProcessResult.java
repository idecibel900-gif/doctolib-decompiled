package androidx.compose.ui.input.pointer;

/* JADX INFO: loaded from: classes.dex */
public abstract class ProcessResult {
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1812constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: getAnyMovementConsumed-impl, reason: not valid java name */
    public static final boolean m1813getAnyMovementConsumedimpl(int i) {
        return (i & 2) != 0;
    }

    /* JADX INFO: renamed from: getDispatchedToAPointerInputModifier-impl, reason: not valid java name */
    public static final boolean m1814getDispatchedToAPointerInputModifierimpl(int i) {
        return (i & 1) != 0;
    }
}
