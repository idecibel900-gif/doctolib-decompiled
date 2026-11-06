package expo.modules.kotlin.events;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class KModuleEventEmitterWrapperKt {
    public static final String normalizeEventName(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (!StringsKt.startsWith$default(eventName, "on", false, 2, (Object) null)) {
            return eventName;
        }
        String strSubstring = eventName.substring(2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return "top" + strSubstring;
    }
}
