package expo.modules.kotlin.exception;

import com.facebook.react.bridge.ReadableType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public final class CollectionElementCastException extends DecoratedException {
    private CollectionElementCastException(KType kType, KType kType2, String str, CodedException codedException) {
        super("Cannot cast '" + str + "' to '" + kType2 + "' required by the collection of type: '" + kType + "'.", codedException);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CollectionElementCastException(KType collectionType, KType elementType, ReadableType providedType, CodedException cause) {
        this(collectionType, elementType, providedType.name(), cause);
        Intrinsics.checkNotNullParameter(collectionType, "collectionType");
        Intrinsics.checkNotNullParameter(elementType, "elementType");
        Intrinsics.checkNotNullParameter(providedType, "providedType");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CollectionElementCastException(KType collectionType, KType elementType, KClass providedType, CodedException cause) {
        this(collectionType, elementType, providedType.toString(), cause);
        Intrinsics.checkNotNullParameter(collectionType, "collectionType");
        Intrinsics.checkNotNullParameter(elementType, "elementType");
        Intrinsics.checkNotNullParameter(providedType, "providedType");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
