package expo.modules.kotlin.exception;

import com.facebook.react.bridge.ReadableType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public final class FieldCastException extends DecoratedException {
    private FieldCastException(String str, CodedException codedException) {
        super(str, codedException);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FieldCastException(String fieldName, KType fieldType, ReadableType providedType, CodedException cause) {
        this("Cannot cast '" + providedType.name() + "' for field '" + fieldName + "' ('" + fieldType + "').", cause);
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        Intrinsics.checkNotNullParameter(providedType, "providedType");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FieldCastException(String fieldName, KType fieldType, KType recordType, CodedException cause) {
        this("Cannot cast value for field '" + fieldName + "' ('" + fieldType + "') in record '" + recordType + "'.", cause);
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
