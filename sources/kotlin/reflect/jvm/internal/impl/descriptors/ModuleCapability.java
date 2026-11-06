package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ModuleCapability {
    private final String name;

    public ModuleCapability(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
