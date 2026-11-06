package io.didomi.ssl;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0010\u0010\t\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0017J*\u0010\t\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0017J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¨\u0006\u0017"}, d2 = {"Lio/didomi/sdk/i6;", "", "Landroid/content/Context;", "context", "Lio/didomi/sdk/DidomiInitializeParameters;", "parameters", "Lio/didomi/sdk/r7;", "localPropertiesRepository", "Lio/didomi/sdk/v0;", "a", "Lio/didomi/sdk/g0;", "Lio/didomi/sdk/gh;", "userAgentRepository", "Lio/didomi/sdk/o6;", "connectivityHelper", "httpRequestHelper", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "Lio/didomi/sdk/bb;", "Lio/didomi/sdk/ib;", "b", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public class i6 {
    public v0 a(Context context, DidomiInitializeParameters parameters, r7 localPropertiesRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(localPropertiesRepository, "localPropertiesRepository");
        return new v0(context, parameters, localPropertiesRepository);
    }

    public ib b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ib(context);
    }

    public g0 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new g0(context);
    }

    public o6 a(gh userAgentRepository) {
        Intrinsics.checkNotNullParameter(userAgentRepository, "userAgentRepository");
        return new o6(userAgentRepository);
    }

    public bb a(Context context, g0 connectivityHelper, o6 httpRequestHelper, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(connectivityHelper, "connectivityHelper");
        Intrinsics.checkNotNullParameter(httpRequestHelper, "httpRequestHelper");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        return new bb(context, connectivityHelper, httpRequestHelper, coroutineDispatcher);
    }
}
