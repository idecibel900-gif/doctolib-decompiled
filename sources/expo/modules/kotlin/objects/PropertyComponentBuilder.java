package expo.modules.kotlin.objects;

import expo.modules.kotlin.functions.SyncFunctionComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public class PropertyComponentBuilder {
    private SyncFunctionComponent getter;
    private final String name;
    private SyncFunctionComponent setter;

    public PropertyComponentBuilder(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public final void setGetter(SyncFunctionComponent syncFunctionComponent) {
        this.getter = syncFunctionComponent;
    }

    public final void setSetter(SyncFunctionComponent syncFunctionComponent) {
        this.setter = syncFunctionComponent;
    }

    public final PropertyComponent build() {
        return new PropertyComponent(this.name, this.getter, this.setter);
    }
}
