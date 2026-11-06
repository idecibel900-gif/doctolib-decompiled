package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¨\u0006\u0003"}, d2 = {"Lio/didomi/sdk/DidomiInitializeParameters;", "", "a", "android_release"}, k = 2, mv = {1, 8, 0})
public final class g5 {
    public static final void a(DidomiInitializeParameters didomiInitializeParameters) throws Exception {
        Intrinsics.checkNotNullParameter(didomiInitializeParameters, "<this>");
        if (!za.a.j().matches(didomiInitializeParameters.apiKey)) {
            throw new Exception("Invalid Didomi API key");
        }
    }
}
