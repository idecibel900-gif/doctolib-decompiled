package io.didomi.ssl;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\b\u0010\u0005\u001a\u00020\u0006H\u0017J \u0010\u0005\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0017J0\u0010\u0005\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0017¨\u0006\u0015"}, d2 = {"Lio/didomi/sdk/cb;", "", "Lio/didomi/sdk/e0;", "configuration", "Lio/didomi/sdk/w6;", "a", "Lio/didomi/sdk/fh;", "configurationRepository", "Lio/didomi/sdk/n7;", "languagesHelper", "Lio/didomi/sdk/qa;", "purposesTranslationsRepository", "Lio/didomi/sdk/zh;", "Landroid/content/Context;", "context", "Lio/didomi/sdk/bb;", "remoteFilesHelper", "Lio/didomi/sdk/v0;", "contextHelper", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public class cb {
    public w6 a(e0 configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (f0.g(configuration)) {
            return new t();
        }
        if (f0.k(configuration)) {
            return new w7();
        }
        return !m.a(configuration.b().getApp().getVendors().getIab()) ? new v6() : new pc();
    }

    public UIStateRepository a() {
        return new UIStateRepository(false, 1, null);
    }

    public zh a(e0 configurationRepository, n7 languagesHelper, qa purposesTranslationsRepository) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        Intrinsics.checkNotNullParameter(purposesTranslationsRepository, "purposesTranslationsRepository");
        return new zh(configurationRepository, languagesHelper, purposesTranslationsRepository);
    }

    public qa a(Context context, bb remoteFilesHelper, v0 contextHelper, n7 languagesHelper, e0 configurationRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteFilesHelper, "remoteFilesHelper");
        Intrinsics.checkNotNullParameter(contextHelper, "contextHelper");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        qa qaVar = new qa(remoteFilesHelper, contextHelper, languagesHelper, configurationRepository);
        qaVar.b();
        return qaVar;
    }
}
