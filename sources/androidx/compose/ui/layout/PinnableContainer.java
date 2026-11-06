package androidx.compose.ui.layout;

/* JADX INFO: loaded from: classes.dex */
public interface PinnableContainer {

    public interface PinnedHandle {
        void release();
    }

    PinnedHandle pin();
}
