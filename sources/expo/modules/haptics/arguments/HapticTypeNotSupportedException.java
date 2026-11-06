package expo.modules.haptics.arguments;

import expo.modules.core.errors.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class HapticTypeNotSupportedException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HapticTypeNotSupportedException(String type) {
        super("This device doesn't support the selected haptic type: " + type);
        Intrinsics.checkNotNullParameter(type, "type");
    }
}
