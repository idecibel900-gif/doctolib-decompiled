package androidx.compose.ui.platform;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class InspectorValueInfo {
    private final Function1 info;

    public InspectorValueInfo(Function1 function1) {
        this.info = function1;
    }
}
