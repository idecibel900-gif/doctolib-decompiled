package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lio/didomi/sdk/x8;", "", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/n7;", "languagesHelper", "", "a", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class x8 {
    public static final x8 a = new x8();

    private x8() {
    }

    public final String a(e0 configurationRepository, n7 languagesHelper) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        String name = configurationRepository.b().getApp().getName();
        String strA = n7.a(languagesHelper, configurationRepository.b().getPreferences().getContent().l(), null, 2, null);
        return strA.length() == 0 ? name : strA;
    }
}
