package expo.modules.imagepicker;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MissingModuleException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingModuleException(String moduleName) {
        super("Module '" + moduleName + "' not found. Are you sure all modules are linked correctly?", null, 2, null);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
    }
}
