package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/didomi/sdk/n8;", "", "throwable", "<init>", "(Ljava/lang/Throwable;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class n8 extends Throwable {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n8(Throwable throwable) {
        super("Parsing error", throwable);
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }
}
