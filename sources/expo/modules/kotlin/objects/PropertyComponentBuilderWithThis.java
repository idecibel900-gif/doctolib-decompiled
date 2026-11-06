package expo.modules.kotlin.objects;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public final class PropertyComponentBuilderWithThis extends PropertyComponentBuilder {
    private final KType thisType;

    public final KType getThisType() {
        return this.thisType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertyComponentBuilderWithThis(KType thisType, String name) {
        super(name);
        Intrinsics.checkNotNullParameter(thisType, "thisType");
        Intrinsics.checkNotNullParameter(name, "name");
        this.thisType = thisType;
    }
}
