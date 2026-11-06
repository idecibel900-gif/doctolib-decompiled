package io.didomi.ssl;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0017¨\u0006\u0010"}, d2 = {"Lio/didomi/sdk/c0;", "", "Landroid/content/Context;", "context", "Lio/didomi/sdk/v0;", "contextHelper", "Lio/didomi/sdk/r7;", "localPropertiesRepository", "Lio/didomi/sdk/DidomiInitializeParameters;", "parameters", "Lio/didomi/sdk/bb;", "remoteFilesHelper", "Lio/didomi/sdk/e0;", "a", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public class c0 {
    public e0 a(Context context, v0 contextHelper, r7 localPropertiesRepository, DidomiInitializeParameters parameters, bb remoteFilesHelper) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contextHelper, "contextHelper");
        Intrinsics.checkNotNullParameter(localPropertiesRepository, "localPropertiesRepository");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(remoteFilesHelper, "remoteFilesHelper");
        e0 e0Var = new e0(remoteFilesHelper, contextHelper, localPropertiesRepository, parameters);
        e0Var.a(context);
        return e0Var;
    }
}
