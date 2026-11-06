package io.didomi.ssl;

import androidx.annotation.Keep;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\rJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003Jo\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0012\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lio/didomi/sdk/DidomiInitializeParameters;", "", "apiKey", "", "localConfigurationPath", "remoteConfigurationUrl", "providerId", "disableDidomiRemoteConfig", "", "languageCode", "noticeId", "tvNoticeId", "androidTvEnabled", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDisableDidomiRemoteConfig$annotations", "()V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DidomiInitializeParameters {
    public final boolean androidTvEnabled;
    public final String apiKey;
    public final boolean disableDidomiRemoteConfig;
    public final String languageCode;
    public final String localConfigurationPath;
    public final String noticeId;
    public final String providerId;
    public final String remoteConfigurationUrl;
    public final String tvNoticeId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DidomiInitializeParameters(String apiKey) {
        this(apiKey, null, null, null, false, null, null, null, false, 510, null);
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
    }

    public static /* synthetic */ DidomiInitializeParameters copy$default(DidomiInitializeParameters didomiInitializeParameters, String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = didomiInitializeParameters.apiKey;
        }
        if ((i & 2) != 0) {
            str2 = didomiInitializeParameters.localConfigurationPath;
        }
        if ((i & 4) != 0) {
            str3 = didomiInitializeParameters.remoteConfigurationUrl;
        }
        if ((i & 8) != 0) {
            str4 = didomiInitializeParameters.providerId;
        }
        if ((i & 16) != 0) {
            z = didomiInitializeParameters.disableDidomiRemoteConfig;
        }
        if ((i & 32) != 0) {
            str5 = didomiInitializeParameters.languageCode;
        }
        if ((i & 64) != 0) {
            str6 = didomiInitializeParameters.noticeId;
        }
        if ((i & 128) != 0) {
            str7 = didomiInitializeParameters.tvNoticeId;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            z2 = didomiInitializeParameters.androidTvEnabled;
        }
        String str8 = str7;
        boolean z3 = z2;
        String str9 = str5;
        String str10 = str6;
        boolean z4 = z;
        String str11 = str3;
        return didomiInitializeParameters.copy(str, str2, str11, str4, z4, str9, str10, str8, z3);
    }

    @Deprecated
    public static /* synthetic */ void getDisableDidomiRemoteConfig$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLocalConfigurationPath() {
        return this.localConfigurationPath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRemoteConfigurationUrl() {
        return this.remoteConfigurationUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getProviderId() {
        return this.providerId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getDisableDidomiRemoteConfig() {
        return this.disableDidomiRemoteConfig;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLanguageCode() {
        return this.languageCode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getNoticeId() {
        return this.noticeId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTvNoticeId() {
        return this.tvNoticeId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getAndroidTvEnabled() {
        return this.androidTvEnabled;
    }

    public final DidomiInitializeParameters copy(String apiKey, String localConfigurationPath, String remoteConfigurationUrl, String providerId, boolean disableDidomiRemoteConfig, String languageCode, String noticeId, String tvNoticeId, boolean androidTvEnabled) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        return new DidomiInitializeParameters(apiKey, localConfigurationPath, remoteConfigurationUrl, providerId, disableDidomiRemoteConfig, languageCode, noticeId, tvNoticeId, androidTvEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidomiInitializeParameters)) {
            return false;
        }
        DidomiInitializeParameters didomiInitializeParameters = (DidomiInitializeParameters) other;
        return Intrinsics.areEqual(this.apiKey, didomiInitializeParameters.apiKey) && Intrinsics.areEqual(this.localConfigurationPath, didomiInitializeParameters.localConfigurationPath) && Intrinsics.areEqual(this.remoteConfigurationUrl, didomiInitializeParameters.remoteConfigurationUrl) && Intrinsics.areEqual(this.providerId, didomiInitializeParameters.providerId) && this.disableDidomiRemoteConfig == didomiInitializeParameters.disableDidomiRemoteConfig && Intrinsics.areEqual(this.languageCode, didomiInitializeParameters.languageCode) && Intrinsics.areEqual(this.noticeId, didomiInitializeParameters.noticeId) && Intrinsics.areEqual(this.tvNoticeId, didomiInitializeParameters.tvNoticeId) && this.androidTvEnabled == didomiInitializeParameters.androidTvEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = this.apiKey.hashCode() * 31;
        String str = this.localConfigurationPath;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.remoteConfigurationUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.providerId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z = this.disableDidomiRemoteConfig;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode4 + r1) * 31;
        String str4 = this.languageCode;
        int iHashCode5 = (i + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.noticeId;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.tvNoticeId;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z2 = this.androidTvEnabled;
        return iHashCode7 + (z2 ? 1 : z2);
    }

    public String toString() {
        return "DidomiInitializeParameters(apiKey=" + this.apiKey + ", localConfigurationPath=" + this.localConfigurationPath + ", remoteConfigurationUrl=" + this.remoteConfigurationUrl + ", providerId=" + this.providerId + ", disableDidomiRemoteConfig=" + this.disableDidomiRemoteConfig + ", languageCode=" + this.languageCode + ", noticeId=" + this.noticeId + ", tvNoticeId=" + this.tvNoticeId + ", androidTvEnabled=" + this.androidTvEnabled + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DidomiInitializeParameters(String apiKey, String str) {
        this(apiKey, str, null, null, false, null, null, null, false, 508, null);
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DidomiInitializeParameters(String apiKey, String str, String str2) {
        this(apiKey, str, str2, null, false, null, null, null, false, 504, null);
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DidomiInitializeParameters(String apiKey, String str, String str2, String str3) {
        this(apiKey, str, str2, str3, false, null, null, null, false, 496, null);
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DidomiInitializeParameters(String apiKey, String str, String str2, String str3, boolean z) {
        this(apiKey, str, str2, str3, z, null, null, null, false, 480, null);
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DidomiInitializeParameters(String apiKey, String str, String str2, String str3, boolean z, String str4) {
        this(apiKey, str, str2, str3, z, str4, null, null, false, 448, null);
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DidomiInitializeParameters(String apiKey, String str, String str2, String str3, boolean z, String str4, String str5) {
        this(apiKey, str, str2, str3, z, str4, str5, null, false, 384, null);
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DidomiInitializeParameters(String apiKey, String str, String str2, String str3, boolean z, String str4, String str5, String str6) {
        this(apiKey, str, str2, str3, z, str4, str5, str6, false, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, null);
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
    }

    public DidomiInitializeParameters(String apiKey, String str, String str2, String str3, boolean z, String str4, String str5, String str6, boolean z2) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.apiKey = apiKey;
        this.localConfigurationPath = str;
        this.remoteConfigurationUrl = str2;
        this.providerId = str3;
        this.disableDidomiRemoteConfig = z;
        this.languageCode = str4;
        this.noticeId = str5;
        this.tvNoticeId = str6;
        this.androidTvEnabled = z2;
    }

    public /* synthetic */ DidomiInitializeParameters(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? false : z2);
    }
}
