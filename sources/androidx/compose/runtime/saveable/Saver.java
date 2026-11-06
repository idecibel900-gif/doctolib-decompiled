package androidx.compose.runtime.saveable;

/* JADX INFO: loaded from: classes.dex */
public interface Saver {
    Object restore(Object obj);

    Object save(SaverScope saverScope, Object obj);
}
