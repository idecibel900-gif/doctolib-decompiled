package androidx.compose.runtime;

import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public interface Composition {
    void dispose();

    boolean getHasInvalidations();

    boolean isDisposed();

    void setContent(Function2 function2);
}
