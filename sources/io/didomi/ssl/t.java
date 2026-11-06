package io.didomi.ssl;

import android.content.SharedPreferences;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.consent.model.ConsentToken;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J>\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0015\u001a\u00020\u00118\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lio/didomi/sdk/t;", "Lio/didomi/sdk/w6;", "Landroid/content/SharedPreferences;", "sharedPreferences", "Lio/didomi/sdk/consent/model/ConsentToken;", "consentToken", "Lio/didomi/sdk/l;", "appConfiguration", "Lio/didomi/sdk/s6;", "vendorList", "", "Lio/didomi/sdk/c9;", "publisherRestrictions", "", "languageCode", "", "a", "", "I", "getVersion", "()I", DiagnosticsEntry.VERSION_KEY, "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class t implements w6 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int version = 1;

    @Override // io.didomi.ssl.w6
    public void a(e0 e0Var, SharedPreferences sharedPreferences) {
        w6.a.a(this, e0Var, sharedPreferences);
    }

    @Override // io.didomi.ssl.w6
    public int getVersion() {
        return this.version;
    }

    @Override // io.didomi.ssl.w6
    public void a(SharedPreferences sharedPreferences, boolean z) {
        w6.a.a(this, sharedPreferences, z);
    }

    @Override // io.didomi.ssl.w6
    public void a(SharedPreferences sharedPreferences, ConsentToken consentToken, AppConfiguration appConfiguration, s6 vendorList, List<PublisherRestriction> publisherRestrictions, String languageCode) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(consentToken, "consentToken");
        Intrinsics.checkNotNullParameter(appConfiguration, "appConfiguration");
        Intrinsics.checkNotNullParameter(vendorList, "vendorList");
        Intrinsics.checkNotNullParameter(publisherRestrictions, "publisherRestrictions");
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        String str = "N";
        String str2 = u0.k(consentToken) ? "Y" : "N";
        String str3 = u0.j(consentToken) ? "Y" : "N";
        AppConfiguration.Regulation.Ccpa ccpa = appConfiguration.getRegulation().getCcpa();
        if (ccpa != null && ccpa.getLspa()) {
            str = "Y";
        }
        sharedPreferences.edit().putString("IABUSPrivacy_String", getVersion() + str2 + str3 + str).apply();
    }

    @Override // io.didomi.ssl.w6
    public String a(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        return sharedPreferences.getString("IABUSPrivacy_String", null);
    }
}
