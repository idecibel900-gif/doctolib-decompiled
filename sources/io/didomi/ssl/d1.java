package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0015\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0005B!\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR(\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001b\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\f\u0010\u001a¨\u0006\u001f"}, d2 = {"Lio/didomi/sdk/d1;", "", "", "b", "Lio/didomi/sdk/e0;", "a", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/g0;", "Lio/didomi/sdk/g0;", "connectivityHelper", "Lio/didomi/sdk/o6;", "c", "Lio/didomi/sdk/o6;", "httpRequestHelper", "", "<set-?>", "d", "Ljava/lang/String;", "()Ljava/lang/String;", ResponseTypeValues.CODE, "io/didomi/sdk/d1$b", "e", "Lio/didomi/sdk/d1$b;", "listener", "", "()Z", "isGDPRCountry", "<init>", "(Lio/didomi/sdk/e0;Lio/didomi/sdk/g0;Lio/didomi/sdk/o6;)V", "f", "android_release"}, k = 1, mv = {1, 8, 0})
public final class d1 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e0 configurationRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final g0 connectivityHelper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final o6 httpRequestHelper;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private String code;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final b listener;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"io/didomi/sdk/d1$b", "Lio/didomi/sdk/p6;", "Lorg/json/JSONObject;", "jsonObject", "", "b", "a", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements p6 {
        b() {
        }

        @Override // io.didomi.ssl.p6
        public void a(JSONObject jsonObject) {
            Log.e$default("Unable to get the country code from API response: " + jsonObject, null, 2, null);
            d1.this.code = null;
        }

        @Override // io.didomi.ssl.p6
        public void b(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            if (!jsonObject.has("country_code") || jsonObject.isNull("country_code")) {
                return;
            }
            try {
                String string = jsonObject.getString("country_code");
                d1 d1Var = d1.this;
                if (string.length() != 2) {
                    string = null;
                }
                d1Var.code = string;
            } catch (JSONException e) {
                Log.e("Unable to get the country code from API response", e);
                d1.this.code = null;
            }
        }
    }

    public d1(e0 configurationRepository, g0 connectivityHelper, o6 httpRequestHelper) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(connectivityHelper, "connectivityHelper");
        Intrinsics.checkNotNullParameter(httpRequestHelper, "httpRequestHelper");
        this.configurationRepository = configurationRepository;
        this.connectivityHelper = connectivityHelper;
        this.httpRequestHelper = httpRequestHelper;
        this.listener = new b();
        if (configurationRepository.b().getApp().getGdprAppliesGlobally()) {
            this.code = null;
        } else {
            b();
        }
    }

    private final void b() {
        if (this.connectivityHelper.c()) {
            o6.a(this.httpRequestHelper, "https://mobile-1861.api.privacy-center.org/locations/current", this.listener, 0, 0L, 12, (Object) null);
        } else {
            Log.i$default("No connection to API server.", null, 2, null);
        }
    }

    public final boolean c() {
        return CollectionsKt.contains(this.configurationRepository.f().d(), this.code);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCode() {
        return this.code;
    }
}
