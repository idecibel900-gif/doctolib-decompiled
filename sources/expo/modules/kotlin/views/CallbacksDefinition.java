package expo.modules.kotlin.views;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CallbacksDefinition {
    private final String[] names;

    public CallbacksDefinition(String[] names) {
        Intrinsics.checkNotNullParameter(names, "names");
        this.names = names;
    }

    public final String[] getNames() {
        return this.names;
    }
}
