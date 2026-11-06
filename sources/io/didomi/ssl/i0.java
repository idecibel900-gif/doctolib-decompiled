package io.didomi.ssl;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J@\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017J\u0010\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0017¨\u0006\u0017"}, d2 = {"Lio/didomi/sdk/i0;", "", "Landroid/content/SharedPreferences;", "sharedPreferences", "Lio/didomi/sdk/zh;", "vendorRepository", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/h1;", "dcsRepository", "Lio/didomi/sdk/w6;", "iabStorageRepository", "Lio/didomi/sdk/n7;", "languagesHelper", "Lio/didomi/sdk/d1;", "countryHelper", "Lio/didomi/sdk/r0;", "a", "Landroid/content/Context;", "context", "Lio/didomi/sdk/j7;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public class i0 {
    public r0 a(SharedPreferences sharedPreferences, zh vendorRepository, e0 configurationRepository, h1 dcsRepository, w6 iabStorageRepository, n7 languagesHelper, d1 countryHelper) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(vendorRepository, "vendorRepository");
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(dcsRepository, "dcsRepository");
        Intrinsics.checkNotNullParameter(iabStorageRepository, "iabStorageRepository");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        Intrinsics.checkNotNullParameter(countryHelper, "countryHelper");
        return new r0(sharedPreferences, vendorRepository, configurationRepository, dcsRepository, iabStorageRepository, languagesHelper, countryHelper);
    }

    public j7 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return w0.c(context) ? new qi(context) : new y5();
    }
}
