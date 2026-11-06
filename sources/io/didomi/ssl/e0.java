package io.didomi.ssl;

import android.content.Context;
import com.amazon.device.simplesignin.SimpleSignInService;
import com.google.gson.Gson;
import io.didomi.ssl.models.DeviceStorageDisclosures;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 L2\u00020\u0001:\u0001\u000eB'\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KJ\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00070\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u000e\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u000e\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0016\u0010!\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001bR\u0014\u0010#\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0018\u0010(\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001bR\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b \u00100R$\u00105\u001a\u00020)2\u0006\u00102\u001a\u00020)8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0011\u0010A\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\"\u0010@R\u0011\u0010C\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010BR\u0011\u0010\u0011\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0006\u0010DR\u0013\u0010E\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\b\u0010\u001c¨\u0006M"}, d2 = {"Lio/didomi/sdk/e0;", "", "Landroid/content/Context;", "context", "Lio/didomi/sdk/kb;", "kotlin.jvm.PlatformType", "b", "Lio/didomi/sdk/mb;", "c", "Lio/didomi/sdk/s6;", "h", "", "i", "iabConfigurationJson", "a", "Lio/didomi/sdk/l;", "g", "appConfiguration", "", "Lio/didomi/sdk/Vendor;", "vendor", "Lio/didomi/sdk/bb;", "Lio/didomi/sdk/bb;", "remoteFilesHelper", "Lio/didomi/sdk/v0;", "Lio/didomi/sdk/v0;", "contextHelper", "Ljava/lang/String;", "()Ljava/lang/String;", "apiKey", "d", "providerId", "e", "noticeId", "f", "cacheFileName", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "gson", "localConfigurationPath", "remoteConfigurationUrl", "", "j", "Ljava/lang/Boolean;", "disableDidomiRemoteConfig", "Lio/didomi/sdk/Regulation;", "k", "Lkotlin/Lazy;", "()Lio/didomi/sdk/Regulation;", "regulation", "<set-?>", "l", "Z", "isConfigLoadedFromDidomi", "()Z", "m", "Lio/didomi/sdk/kb;", "internalSdkConfiguration", "n", "Lio/didomi/sdk/s6;", "internalIabConfiguration", "o", "Lio/didomi/sdk/l;", "internalAppConfiguration", "()Lio/didomi/sdk/kb;", "sdkConfiguration", "()Lio/didomi/sdk/s6;", "iabConfiguration", "()Lio/didomi/sdk/l;", "deploymentId", "Lio/didomi/sdk/r7;", "localPropertiesRepository", "Lio/didomi/sdk/DidomiInitializeParameters;", "parameters", "<init>", "(Lio/didomi/sdk/bb;Lio/didomi/sdk/v0;Lio/didomi/sdk/r7;Lio/didomi/sdk/DidomiInitializeParameters;)V", "p", "android_release"}, k = 1, mv = {1, 8, 0})
public final class e0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final bb remoteFilesHelper;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final v0 contextHelper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String apiKey;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String providerId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final String noticeId;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final String cacheFileName;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Gson gson;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private String localConfigurationPath;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private String remoteConfigurationUrl;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private Boolean disableDidomiRemoteConfig;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final Lazy regulation;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private boolean isConfigLoadedFromDidomi;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private kb internalSdkConfiguration;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private s6 internalIabConfiguration;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private AppConfiguration internalAppConfiguration;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/Regulation;", "a", "()Lio/didomi/sdk/Regulation;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Regulation invoke() {
            return m.c(e0.this.b());
        }
    }

    public e0(bb remoteFilesHelper, v0 contextHelper, r7 localPropertiesRepository, DidomiInitializeParameters parameters) {
        Intrinsics.checkNotNullParameter(remoteFilesHelper, "remoteFilesHelper");
        Intrinsics.checkNotNullParameter(contextHelper, "contextHelper");
        Intrinsics.checkNotNullParameter(localPropertiesRepository, "localPropertiesRepository");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.remoteFilesHelper = remoteFilesHelper;
        this.contextHelper = contextHelper;
        String str = parameters.apiKey;
        this.apiKey = str;
        this.gson = new Gson();
        this.regulation = LazyKt.lazy(new b());
        if (contextHelper.g()) {
            if (parameters.localConfigurationPath != null || parameters.remoteConfigurationUrl != null || parameters.disableDidomiRemoteConfig) {
                Log.w$default("TV device detected: Only remote console configuration is allowed", null, 2, null);
            }
            this.localConfigurationPath = null;
            this.remoteConfigurationUrl = null;
            this.disableDidomiRemoteConfig = Boolean.FALSE;
        } else {
            String str2 = parameters.localConfigurationPath;
            this.localConfigurationPath = str2 == null ? "didomi_config.json" : str2;
            this.remoteConfigurationUrl = parameters.remoteConfigurationUrl;
            this.disableDidomiRemoteConfig = Boolean.valueOf(parameters.disableDidomiRemoteConfig);
        }
        this.providerId = parameters.providerId;
        String str3 = contextHelper.g() ? parameters.tvNoticeId : parameters.noticeId;
        this.noticeId = str3;
        String strD = localPropertiesRepository.d();
        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str, str3, strD == null ? SimpleSignInService.SDK_VERSION : strD, localPropertiesRepository.a(), localPropertiesRepository.b(), localPropertiesRepository.c()}), "_", null, null, 0, null, null, 62, null);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str4 = String.format("didomi_config_cache_%s.json", Arrays.copyOf(new Object[]{strJoinToString$default}, 1));
        Intrinsics.checkNotNullExpressionValue(str4, "format(format, *args)");
        this.cacheFileName = str4;
    }

    private final SDKConfigurationTCFV2 c(Context context) {
        return (SDKConfigurationTCFV2) this.gson.fromJson(w0.a(context, "didomi_master_config.json"), SDKConfigurationTCFV2.class);
    }

    private final AppConfiguration g() {
        RemoteFile abVar;
        RemoteFile abVar2;
        AppConfiguration lVar = this.internalAppConfiguration;
        if (lVar != null) {
            a(lVar);
            return lVar;
        }
        this.isConfigLoadedFromDidomi = false;
        String str = this.remoteConfigurationUrl;
        if (str != null) {
            abVar2 = new RemoteFile(str, true, this.cacheFileName, 3600, this.localConfigurationPath, false, 0L, false, 224, null);
        } else {
            if (Intrinsics.areEqual(this.disableDidomiRemoteConfig, Boolean.FALSE)) {
                this.isConfigLoadedFromDidomi = true;
                abVar = new RemoteFile(this.contextHelper.a(this.apiKey, this.noticeId), true, this.cacheFileName, 3600, this.localConfigurationPath, false, 0L, false, 224, null);
            } else {
                Log.e$default("The parameter `disableDidomiRemoteConfig` is deprecated, in the future it will be mandatory to create your notice from the console (see https://developers.didomi.io/cmp/mobile-sdk/android/setup#from-the-console-recommended for more information).", null, 2, null);
                abVar = new RemoteFile(null, false, this.cacheFileName, 3600, this.localConfigurationPath, false, 0L, false, 224, null);
            }
            abVar2 = abVar;
        }
        AppConfiguration appConfiguration = (AppConfiguration) this.gson.fromJson(this.remoteFilesHelper.b(abVar2), AppConfiguration.class);
        Intrinsics.checkNotNullExpressionValue(appConfiguration, "appConfiguration");
        a(appConfiguration);
        return appConfiguration;
    }

    private final s6 h() {
        s6 s6VarA = this.internalIabConfiguration;
        if (s6VarA == null) {
            s6VarA = a(i());
        }
        t6.a(s6VarA, f());
        return s6VarA;
    }

    private final String i() throws Exception {
        String str;
        int iB = m.b(b());
        boolean zI = b().getApp().getVendors().getIab().getRequireUpdatedGVL();
        int iK = b().getApp().getVendors().getIab().getUpdateGVLTimeout() * 1000;
        String strA = this.contextHelper.a(iB);
        String str2 = "didomi_iab_config_v" + iB;
        if (zI) {
            str = null;
        } else {
            str = "didomi_iab_config_v" + iB + ".json";
        }
        String strB = this.remoteFilesHelper.b(new RemoteFile(strA, true, str2, 604800, str, false, iK, iK == 0 && zI));
        if (strB != null) {
            return strB;
        }
        Log.e$default("Unable to download the IAB vendors list", null, 2, null);
        throw new Exception("Unable to download the IAB vendors list");
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    public final AppConfiguration b() {
        AppConfiguration lVar = this.internalAppConfiguration;
        if (lVar != null) {
            return lVar;
        }
        throw new IllegalStateException("Configuration was not loaded");
    }

    public final s6 d() {
        s6 s6Var = this.internalIabConfiguration;
        if (s6Var != null) {
            return s6Var;
        }
        throw new IllegalStateException("Configuration was not loaded");
    }

    public final Regulation e() {
        return (Regulation) this.regulation.getValue();
    }

    public final kb f() {
        kb kbVar = this.internalSdkConfiguration;
        if (kbVar != null) {
            return kbVar;
        }
        throw new IllegalStateException("Configuration was not loaded");
    }

    private final kb b(Context context) {
        kb kbVar = this.internalSdkConfiguration;
        return kbVar == null ? c(context) : kbVar;
    }

    public final void a(Context context) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            this.internalAppConfiguration = g();
            this.internalSdkConfiguration = b(context);
            this.internalIabConfiguration = h();
        } catch (Exception e) {
            Log.e("Unable to load the configuration for the Didomi SDK", e);
            throw new Exception("Unable to load the configuration for the Didomi SDK", e);
        }
    }

    public final String c() {
        return b().getApp().getDeploymentId();
    }

    private final s6 a(String iabConfigurationJson) {
        Object objFromJson = this.gson.fromJson(iabConfigurationJson, IABConfigurationTCFV2.class);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "gson.fromJson(\n         …FV2::class.java\n        )");
        return (s6) objFromJson;
    }

    private final void a(AppConfiguration appConfiguration) {
        appConfiguration.getApp().getVendors().getIab().a(this.isConfigLoadedFromDidomi);
    }

    public final void a(Vendor vendor) {
        DeviceStorageDisclosures deviceStorageDisclosures;
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        String deviceStorageDisclosureUrl = vendor.getDeviceStorageDisclosureUrl();
        if (deviceStorageDisclosureUrl == null) {
            return;
        }
        DeviceStorageDisclosures deviceStorageDisclosures2 = null;
        try {
            deviceStorageDisclosures = (DeviceStorageDisclosures) this.gson.fromJson(this.remoteFilesHelper.b(new RemoteFile(deviceStorageDisclosureUrl, true, null, 0, null, false, 0L, false, 224, null)), DeviceStorageDisclosures.class);
        } catch (Exception e) {
            Log.e$default("Error while loading vendor device storage disclosures : " + e, null, 2, null);
            deviceStorageDisclosures = null;
        }
        if (deviceStorageDisclosures != null && deviceStorageDisclosures.isValid()) {
            deviceStorageDisclosures2 = deviceStorageDisclosures;
        }
        yh.a(vendor, deviceStorageDisclosures2);
    }
}
