package expo.modules.core.errors;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ModuleDestroyedException extends CancellationException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModuleDestroyedException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public /* synthetic */ ModuleDestroyedException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Module destroyed. All coroutines are cancelled." : str);
    }
}
