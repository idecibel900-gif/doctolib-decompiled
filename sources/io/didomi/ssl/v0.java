package io.didomi.ssl;

import android.app.UiModeManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import androidx.preference.PreferenceManager;
import com.amazon.device.simplesignin.SimpleSignInService;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u001c\u0010\u0003\u001a\n \u001a*\u0004\u0018\u00010\u00020\u00028\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b\u0005\u0010 R\u001a\u0010$\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u0012\u0010 R\u001a\u0010&\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b\u001d\u0010 R\u001a\u0010(\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b'\u0010\u001e\u001a\u0004\b\"\u0010 R\u0014\u0010)\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010 ¨\u0006."}, d2 = {"Lio/didomi/sdk/v0;", "", "Landroid/content/SharedPreferences;", "sharedPreferences", "", "a", "", "gvlVersion", "languageCode", "apiKey", "noticeId", "name", "", "g", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lio/didomi/sdk/r7;", "b", "Lio/didomi/sdk/r7;", "localPropertiesRepository", "Lio/didomi/sdk/t8;", "c", "Lkotlin/Lazy;", "()Lio/didomi/sdk/t8;", "platformInfoProvider", "kotlin.jvm.PlatformType", "d", "Landroid/content/SharedPreferences;", "e", "Ljava/lang/String;", "getAdvertisingId", "()Ljava/lang/String;", "advertisingId", "f", "apiUrl", "packageName", "h", "sdkUrl", "i", "sdkVersionName", "platformSourceType", "Lio/didomi/sdk/DidomiInitializeParameters;", "parameters", "<init>", "(Landroid/content/Context;Lio/didomi/sdk/DidomiInitializeParameters;Lio/didomi/sdk/r7;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class v0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final r7 localPropertiesRepository;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Lazy platformInfoProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final SharedPreferences sharedPreferences;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final String advertisingId;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final String apiUrl;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final String packageName;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final String sdkUrl;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final String sdkVersionName;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/t8;", "a", "()Lio/didomi/sdk/t8;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0 {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t8 invoke() {
            UiModeManager uiModeManager = (UiModeManager) v0.this.context.getSystemService("uimode");
            return new u8(uiModeManager != null && uiModeManager.getCurrentModeType() == 4).a();
        }
    }

    public v0(Context context, DidomiInitializeParameters parameters, r7 localPropertiesRepository) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(localPropertiesRepository, "localPropertiesRepository");
        this.context = context;
        this.localPropertiesRepository = localPropertiesRepository;
        this.platformInfoProvider = LazyKt.lazy(new a());
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.sharedPreferences = sharedPreferences;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
        this.advertisingId = a(sharedPreferences);
        this.apiUrl = "https://mobile-1861.api.privacy-center.org/";
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        this.packageName = packageName;
        this.sdkUrl = "https://sdk.privacy-center.org/";
        this.sdkVersionName = "1.86.1";
        if (g() && !parameters.androidTvEnabled) {
            throw new Exception("TV device detected, but androidTvEnabled parameter is false");
        }
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public String getPackageName() {
        return this.packageName;
    }

    protected t8 c() {
        return (t8) this.platformInfoProvider.getValue();
    }

    public String d() {
        return c().getSourceType();
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public String getSdkUrl() {
        return this.sdkUrl;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public String getSdkVersionName() {
        return this.sdkVersionName;
    }

    public final boolean g() {
        return Intrinsics.areEqual(c().getSourceType(), "sdk-ctv");
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public String getApiUrl() {
        return this.apiUrl;
    }

    public String a(int gvlVersion) {
        return getSdkUrl() + "tcf/v" + gvlVersion + "/vendor-list.json";
    }

    public String a(int gvlVersion, String languageCode) {
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        return getSdkUrl() + "tcf/v" + gvlVersion + "/purposes-" + languageCode + ".json";
    }

    public String a(String apiKey, String noticeId) {
        String str;
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        StringBuilder sb = new StringBuilder(getSdkUrl() + apiKey + "/didomi_config.json?platform=" + c().getName() + "&os=android&version=1.86.1&");
        if (noticeId == null || StringsKt.isBlank(noticeId)) {
            str = "target=" + getPackageName();
        } else {
            str = "target_type=notice&target=" + noticeId;
        }
        sb.append(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("&config_version=");
        String strD = this.localPropertiesRepository.d();
        if (strD == null) {
            strD = SimpleSignInService.SDK_VERSION;
        }
        sb2.append(strD);
        sb.append(sb2.toString());
        String strA = this.localPropertiesRepository.a();
        if (strA != null) {
            sb.append("&country=" + strA);
        }
        String strB = this.localPropertiesRepository.b();
        if (strB != null) {
            sb.append("&region=" + strB);
        }
        String strC = this.localPropertiesRepository.c();
        if (strC != null) {
            sb.append("&regulation=" + strC);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(\"$sdkUrl$a…\n            }.toString()");
        return string;
    }

    public int a(String name) {
        Resources resources = this.context.getResources();
        if (name == null) {
            name = "";
        }
        return resources.getIdentifier(name, "drawable", this.context.getPackageName());
    }

    private String a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("Didomi_Fallback_Id", null);
        if (string != null) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        sharedPreferences.edit().putString("Didomi_Fallback_Id", string2).apply();
        return string2;
    }
}
