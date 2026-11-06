package expo.modules.video.records;

import android.net.Uri;
import com.amazon.a.a.o.b;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lexpo/modules/video/records/VideoMetadata;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", b.S, "", "artist", "artwork", "Landroid/net/Uri;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "getTitle$annotations", "()V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getArtist$annotations", "getArtist", "setArtist", "getArtwork$annotations", "getArtwork", "()Landroid/net/Uri;", "setArtwork", "(Landroid/net/Uri;)V", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoMetadata implements Record, Serializable {
    private String artist;
    private Uri artwork;
    private String title;

    public VideoMetadata() {
        this(null, null, null, 7, null);
    }

    @Field
    public static /* synthetic */ void getArtist$annotations() {
    }

    @Field
    public static /* synthetic */ void getArtwork$annotations() {
    }

    @Field
    public static /* synthetic */ void getTitle$annotations() {
    }

    public VideoMetadata(String str, String str2, Uri uri) {
        this.title = str;
        this.artist = str2;
        this.artwork = uri;
    }

    public /* synthetic */ VideoMetadata(String str, String str2, Uri uri, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : uri);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final void setArtist(String str) {
        this.artist = str;
    }

    public final Uri getArtwork() {
        return this.artwork;
    }

    public final void setArtwork(Uri uri) {
        this.artwork = uri;
    }
}
