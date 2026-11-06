package expo.modules.kotlin.exception;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class PropSetException extends DecoratedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropSetException(String propName, KClass viewType, CodedException cause) {
        super("Cannot set prop '" + propName + "' on view '" + viewType + "'", cause);
        Intrinsics.checkNotNullParameter(propName, "propName");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
