package expo.modules.core.logging;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LoggerUtilsKt {
    public static final String localizedMessageWithCauseLocalizedMessage(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        String localizedMessage = th.getLocalizedMessage();
        Throwable cause = th.getCause();
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{localizedMessage, cause != null ? localizedMessageWithCauseLocalizedMessage(cause) : null}), ": ", null, null, 0, null, null, 62, null);
    }
}
