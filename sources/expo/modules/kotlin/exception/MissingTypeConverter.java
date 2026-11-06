package expo.modules.kotlin.exception;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public final class MissingTypeConverter extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingTypeConverter(KType forType) {
        super("Cannot find type converter for '" + forType + "'. Make sure the class implements `expo.modules.kotlin.records.Record` (i.e. `class MyObj : Record`).", null, 2, null);
        Intrinsics.checkNotNullParameter(forType, "forType");
    }
}
