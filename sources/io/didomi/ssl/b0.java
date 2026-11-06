package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/didomi/sdk/b0;", "", "", "message", "<init>", "(Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class b0 extends Throwable {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
