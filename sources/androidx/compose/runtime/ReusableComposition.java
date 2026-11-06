package androidx.compose.runtime;

import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public interface ReusableComposition extends Composition {
    void deactivate();

    void setContentWithReuse(Function2 function2);
}
