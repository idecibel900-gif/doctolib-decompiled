package androidx.compose.ui.focus;

/* JADX INFO: loaded from: classes.dex */
public abstract class FocusOwnerImplKt {
    /* JADX INFO: renamed from: is1dFocusSearch-3ESFkO8, reason: not valid java name */
    public static final boolean m1180is1dFocusSearch3ESFkO8(int i) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m1155equalsimpl0(i, companion.m1163getNextdhqQ8s())) {
            return true;
        }
        return FocusDirection.m1155equalsimpl0(i, companion.m1164getPreviousdhqQ8s());
    }
}
