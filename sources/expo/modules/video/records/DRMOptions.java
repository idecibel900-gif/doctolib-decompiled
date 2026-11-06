package expo.modules.video.records;

import androidx.media3.common.MediaItem;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.video.enums.DRMType;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\"\u001a\u00020#R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R2\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lexpo/modules/video/records/DRMOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "type", "Lexpo/modules/video/enums/DRMType;", "licenseServer", "", "headers", "", "multiKey", "", "<init>", "(Lexpo/modules/video/enums/DRMType;Ljava/lang/String;Ljava/util/Map;Z)V", "getType$annotations", "()V", "getType", "()Lexpo/modules/video/enums/DRMType;", "setType", "(Lexpo/modules/video/enums/DRMType;)V", "getLicenseServer$annotations", "getLicenseServer", "()Ljava/lang/String;", "setLicenseServer", "(Ljava/lang/String;)V", "getHeaders$annotations", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getMultiKey$annotations", "getMultiKey", "()Z", "setMultiKey", "(Z)V", "toDRMConfiguration", "Landroidx/media3/common/MediaItem$DrmConfiguration;", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DRMOptions implements Record, Serializable {
    private Map<String, String> headers;
    private String licenseServer;
    private boolean multiKey;
    private DRMType type;

    public DRMOptions() {
        this(null, null, null, false, 15, null);
    }

    @Field
    public static /* synthetic */ void getHeaders$annotations() {
    }

    @Field
    public static /* synthetic */ void getLicenseServer$annotations() {
    }

    @Field
    public static /* synthetic */ void getMultiKey$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    public DRMOptions(DRMType type, String str, Map<String, String> map, boolean z) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.licenseServer = str;
        this.headers = map;
        this.multiKey = z;
    }

    public /* synthetic */ DRMOptions(DRMType dRMType, String str, Map map, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DRMType.WIDEVINE : dRMType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : map, (i & 8) != 0 ? false : z);
    }

    public final DRMType getType() {
        return this.type;
    }

    public final void setType(DRMType dRMType) {
        Intrinsics.checkNotNullParameter(dRMType, "<set-?>");
        this.type = dRMType;
    }

    public final String getLicenseServer() {
        return this.licenseServer;
    }

    public final void setLicenseServer(String str) {
        this.licenseServer = str;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public final boolean getMultiKey() {
        return this.multiKey;
    }

    public final void setMultiKey(boolean z) {
        this.multiKey = z;
    }

    public final MediaItem.DrmConfiguration toDRMConfiguration() {
        MediaItem.DrmConfiguration.Builder builder = new MediaItem.DrmConfiguration.Builder(this.type.toUUID());
        String str = this.licenseServer;
        if (str != null) {
            builder.setLicenseUri(str);
        }
        Map<String, String> map = this.headers;
        if (map != null) {
            builder.setLicenseRequestHeaders(map);
        }
        builder.setMultiSession(this.multiKey);
        MediaItem.DrmConfiguration drmConfigurationBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(drmConfigurationBuild, "build(...)");
        return drmConfigurationBuild;
    }
}
