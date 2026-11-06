package io.didomi.ssl;

import android.content.SharedPreferences;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.consent.model.ConsentToken;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J>\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH&J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H&R\u0014\u0010\u0018\u001a\u00020\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lio/didomi/sdk/w6;", "", "Landroid/content/SharedPreferences;", "sharedPreferences", "Lio/didomi/sdk/consent/model/ConsentToken;", "consentToken", "Lio/didomi/sdk/l;", "appConfiguration", "Lio/didomi/sdk/s6;", "vendorList", "", "Lio/didomi/sdk/c9;", "publisherRestrictions", "", "languageCode", "", "a", "Lio/didomi/sdk/e0;", "configurationRepository", "", "subjectToGDPR", "", "getVersion", "()I", DiagnosticsEntry.VERSION_KEY, "android_release"}, k = 1, mv = {1, 8, 0})
public interface w6 {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public static void a(w6 w6Var, e0 configurationRepository, SharedPreferences sharedPreferences) {
            Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
            Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        }

        public static void a(w6 w6Var, SharedPreferences sharedPreferences, boolean z) {
            Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        }
    }

    String a(SharedPreferences sharedPreferences);

    void a(SharedPreferences sharedPreferences, ConsentToken consentToken, AppConfiguration appConfiguration, s6 vendorList, List<PublisherRestriction> publisherRestrictions, String languageCode);

    void a(SharedPreferences sharedPreferences, boolean subjectToGDPR);

    void a(e0 configurationRepository, SharedPreferences sharedPreferences);

    int getVersion();
}
