package expo.modules.video.records;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.RawResourceDataSource;
import androidx.media3.exoplayer.source.MediaSource;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.video.DataSourceUtilsKt;
import expo.modules.video.UnsupportedDRMTypeException;
import expo.modules.video.enums.ContentType;
import expo.modules.video.enums.DRMType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010/\u001a\u00020\u000bH\u0002J\u0010\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203J\u000e\u00104\u001a\u0002052\u0006\u00102\u001a\u000203J\u001c\u00106\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u00102\u001a\u000203H\u0003R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R2\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0013\u001a\u0004\b-\u0010.¨\u00067"}, d2 = {"Lexpo/modules/video/records/VideoSource;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "uri", "Landroid/net/Uri;", "drm", "Lexpo/modules/video/records/DRMOptions;", "metadata", "Lexpo/modules/video/records/VideoMetadata;", "headers", "", "", "useCaching", "", "contentType", "Lexpo/modules/video/enums/ContentType;", "<init>", "(Landroid/net/Uri;Lexpo/modules/video/records/DRMOptions;Lexpo/modules/video/records/VideoMetadata;Ljava/util/Map;ZLexpo/modules/video/enums/ContentType;)V", "getUri$annotations", "()V", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "getDrm$annotations", "getDrm", "()Lexpo/modules/video/records/DRMOptions;", "setDrm", "(Lexpo/modules/video/records/DRMOptions;)V", "getMetadata$annotations", "getMetadata", "()Lexpo/modules/video/records/VideoMetadata;", "setMetadata", "(Lexpo/modules/video/records/VideoMetadata;)V", "getHeaders$annotations", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getUseCaching$annotations", "getUseCaching", "()Z", "setUseCaching", "(Z)V", "getContentType$annotations", "getContentType", "()Lexpo/modules/video/enums/ContentType;", "toMediaId", "toMediaSource", "Landroidx/media3/exoplayer/source/MediaSource;", "context", "Landroid/content/Context;", "toMediaItem", "Landroidx/media3/common/MediaItem;", "parseLocalAssetId", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoSource implements Record, Serializable {
    private final ContentType contentType;
    private DRMOptions drm;
    private Map<String, String> headers;
    private VideoMetadata metadata;
    private Uri uri;
    private boolean useCaching;

    public VideoSource() {
        this(null, null, null, null, false, null, 63, null);
    }

    @Field
    public static /* synthetic */ void getContentType$annotations() {
    }

    @Field
    public static /* synthetic */ void getDrm$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeaders$annotations() {
    }

    @Field
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @Field
    public static /* synthetic */ void getUri$annotations() {
    }

    @Field
    public static /* synthetic */ void getUseCaching$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toMediaId$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toMediaId$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    public VideoSource(Uri uri, DRMOptions dRMOptions, VideoMetadata videoMetadata, Map<String, String> map, boolean z, ContentType contentType) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.uri = uri;
        this.drm = dRMOptions;
        this.metadata = videoMetadata;
        this.headers = map;
        this.useCaching = z;
        this.contentType = contentType;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void setUri(Uri uri) {
        this.uri = uri;
    }

    public final DRMOptions getDrm() {
        return this.drm;
    }

    public final void setDrm(DRMOptions dRMOptions) {
        this.drm = dRMOptions;
    }

    public final VideoMetadata getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(VideoMetadata videoMetadata) {
        this.metadata = videoMetadata;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public final boolean getUseCaching() {
        return this.useCaching;
    }

    public final void setUseCaching(boolean z) {
        this.useCaching = z;
    }

    public /* synthetic */ VideoSource(Uri uri, DRMOptions dRMOptions, VideoMetadata videoMetadata, Map map, boolean z, ContentType contentType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : uri, (i & 2) != 0 ? null : dRMOptions, (i & 4) != 0 ? null : videoMetadata, (i & 8) != 0 ? null : map, (i & 16) != 0 ? false : z, (i & 32) != 0 ? ContentType.AUTO : contentType);
    }

    public final ContentType getContentType() {
        return this.contentType;
    }

    private final String toMediaId() {
        Uri artwork;
        Map<String, String> headers;
        Collection<String> collectionValues;
        Map<String, String> headers2;
        Set<String> setKeySet;
        Uri uri = this.uri;
        Map<String, String> map = this.headers;
        DRMOptions dRMOptions = this.drm;
        String path = null;
        DRMType type = dRMOptions != null ? dRMOptions.getType() : null;
        DRMOptions dRMOptions2 = this.drm;
        String licenseServer = dRMOptions2 != null ? dRMOptions2.getLicenseServer() : null;
        DRMOptions dRMOptions3 = this.drm;
        Boolean boolValueOf = dRMOptions3 != null ? Boolean.valueOf(dRMOptions3.getMultiKey()) : null;
        DRMOptions dRMOptions4 = this.drm;
        String strJoinToString$default = (dRMOptions4 == null || (headers2 = dRMOptions4.getHeaders()) == null || (setKeySet = headers2.keySet()) == null) ? null : CollectionsKt.joinToString$default(setKeySet, null, null, null, 0, null, new Function1() { // from class: expo.modules.video.records.VideoSource$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoSource.toMediaId$lambda$0((String) obj);
            }
        }, 31, null);
        DRMOptions dRMOptions5 = this.drm;
        String strJoinToString$default2 = (dRMOptions5 == null || (headers = dRMOptions5.getHeaders()) == null || (collectionValues = headers.values()) == null) ? null : CollectionsKt.joinToString$default(collectionValues, null, null, null, 0, null, new Function1() { // from class: expo.modules.video.records.VideoSource$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoSource.toMediaId$lambda$1((String) obj);
            }
        }, 31, null);
        VideoMetadata videoMetadata = this.metadata;
        String title = videoMetadata != null ? videoMetadata.getTitle() : null;
        VideoMetadata videoMetadata2 = this.metadata;
        String artist = videoMetadata2 != null ? videoMetadata2.getArtist() : null;
        VideoMetadata videoMetadata3 = this.metadata;
        if (videoMetadata3 != null && (artwork = videoMetadata3.getArtwork()) != null) {
            path = artwork.getPath();
        }
        return "uri:" + uri + "Headers: " + map + "DrmType:" + type + "DrmLicenseServer:" + licenseServer + "DrmMultiKey:" + boolValueOf + "DRMHeadersKeys:" + strJoinToString$default + "}DRMHeadersValues:" + strJoinToString$default2 + "}NotificationDataTitle:" + title + "NotificationDataSecondaryText:" + artist + "NotificationDataArtwork:" + path + "ContentType:" + this.contentType.getValue();
    }

    public final MediaSource toMediaSource(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.uri == null) {
            return null;
        }
        return DataSourceUtilsKt.buildExpoVideoMediaSource(context, this);
    }

    public final MediaItem toMediaItem(Context context) throws UnsupportedDRMTypeException {
        Intrinsics.checkNotNullParameter(context, "context");
        MediaItem.Builder builder = new MediaItem.Builder();
        builder.setUri(parseLocalAssetId(this.uri, context));
        String mimeTypeString = this.contentType.toMimeTypeString();
        if (mimeTypeString != null) {
            builder.setMimeType(mimeTypeString);
        }
        DRMOptions dRMOptions = this.drm;
        if (dRMOptions != null) {
            if (dRMOptions.getType().isSupported()) {
                builder.setDrmConfiguration(dRMOptions.toDRMConfiguration());
            } else {
                throw new UnsupportedDRMTypeException(dRMOptions.getType());
            }
        }
        MediaMetadata.Builder builder2 = new MediaMetadata.Builder();
        VideoMetadata videoMetadata = this.metadata;
        if (videoMetadata != null) {
            builder2.setTitle(videoMetadata.getTitle());
            builder2.setArtist(videoMetadata.getArtist());
            Uri artwork = videoMetadata.getArtwork();
            if (artwork != null) {
                builder2.setArtworkUri(artwork);
            }
        }
        builder.setMediaMetadata(builder2.build());
        MediaItem mediaItemBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(mediaItemBuild, "build(...)");
        return mediaItemBuild;
    }

    @SuppressLint({"DiscouragedApi"})
    private final Uri parseLocalAssetId(Uri uri, Context context) {
        if (uri == null || uri.getScheme() != null) {
            return uri;
        }
        try {
            DataSpec dataSpec = new DataSpec(new Uri.Builder().scheme("android.resource").appendPath(String.valueOf(context.getResources().getIdentifier(uri.toString(), "raw", context.getPackageName()))).build());
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(context);
            rawResourceDataSource.open(dataSpec);
            return rawResourceDataSource.getUri();
        } catch (RawResourceDataSource.RawResourceDataSourceException unused) {
            return uri;
        }
    }
}
