package androidx.compose.foundation.contextmenu;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContextMenuState_androidKt {
    public static final void close(ContextMenuState contextMenuState) {
        contextMenuState.setStatus(ContextMenuState.Status.Closed.INSTANCE);
    }
}
