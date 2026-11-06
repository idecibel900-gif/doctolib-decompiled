package expo.modules.kotlin.exception;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public final class RecordCastException extends DecoratedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordCastException(KType recordType, CodedException cause) {
        super("Cannot create a record of the type: '" + recordType + "'.", cause);
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
