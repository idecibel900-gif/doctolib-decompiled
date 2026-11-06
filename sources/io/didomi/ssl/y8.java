package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0011¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0007\u001a\u00020\tH\u0011¢\u0006\u0004\b\u0007\u0010\nJ1\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0011¢\u0006\u0004\b\u0007\u0010\u0010¨\u0006\u0013"}, d2 = {"Lio/didomi/sdk/y8;", "", "Lio/didomi/sdk/v0;", "contextHelper", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/eh;", "a", "(Lio/didomi/sdk/v0;Lio/didomi/sdk/e0;)Lio/didomi/sdk/eh;", "Lio/didomi/sdk/jh;", "()Lio/didomi/sdk/jh;", "Lio/didomi/sdk/x6;", "imageUrlLoader", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "Lio/didomi/sdk/u7;", "(Lio/didomi/sdk/e0;Lio/didomi/sdk/v0;Lio/didomi/sdk/x6;Lkotlinx/coroutines/CoroutineDispatcher;)Lio/didomi/sdk/u7;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public class y8 {
    public eh a(v0 contextHelper, e0 configurationRepository) {
        Intrinsics.checkNotNullParameter(contextHelper, "contextHelper");
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        return contextHelper.g() ? new te() : new y7(configurationRepository);
    }

    public jh a() {
        return jh.INSTANCE.a();
    }

    public u7 a(e0 configurationRepository, v0 contextHelper, x6 imageUrlLoader, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(contextHelper, "contextHelper");
        Intrinsics.checkNotNullParameter(imageUrlLoader, "imageUrlLoader");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        return new u7(configurationRepository, contextHelper, imageUrlLoader, coroutineDispatcher);
    }
}
