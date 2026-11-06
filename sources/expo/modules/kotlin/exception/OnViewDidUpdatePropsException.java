package expo.modules.kotlin.exception;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class OnViewDidUpdatePropsException extends DecoratedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnViewDidUpdatePropsException(KClass viewType, CodedException cause) {
        super("Error occurred when invoking 'onViewDidUpdateProps' on '" + viewType.getSimpleName() + "'", cause);
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
