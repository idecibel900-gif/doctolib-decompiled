package expo.modules.clipboard;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CopyFailureException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CopyFailureException(Throwable th, String kind) {
        super("Failed to save " + kind + " into clipboard", th);
        Intrinsics.checkNotNullParameter(kind, "kind");
    }
}
