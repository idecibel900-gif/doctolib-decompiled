package expo.modules.core.errors;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ContextDestroyedException extends CancellationException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextDestroyedException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public /* synthetic */ ContextDestroyedException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "App context destroyed. All coroutines are cancelled." : str);
    }
}
