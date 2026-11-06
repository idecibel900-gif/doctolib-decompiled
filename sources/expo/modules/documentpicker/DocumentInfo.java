package expo.modules.documentpicker;

import android.net.Uri;
import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010 \u001a\u00020\bHÆ\u0003JD\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lexpo/modules/documentpicker/DocumentInfo;", "Lexpo/modules/kotlin/records/Record;", "uri", "Landroid/net/Uri;", "name", "", "mimeType", "size", "", "lastModified", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;J)V", "getUri$annotations", "()V", "getUri", "()Landroid/net/Uri;", "getName$annotations", "getName", "()Ljava/lang/String;", "getMimeType$annotations", "getMimeType", "getSize$annotations", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLastModified$annotations", "getLastModified", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;J)Lexpo/modules/documentpicker/DocumentInfo;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "expo-document-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DocumentInfo implements Record {
    private final long lastModified;
    private final String mimeType;
    private final String name;
    private final Long size;
    private final Uri uri;

    public static /* synthetic */ DocumentInfo copy$default(DocumentInfo documentInfo, Uri uri, String str, String str2, Long l, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = documentInfo.uri;
        }
        if ((i & 2) != 0) {
            str = documentInfo.name;
        }
        if ((i & 4) != 0) {
            str2 = documentInfo.mimeType;
        }
        if ((i & 8) != 0) {
            l = documentInfo.size;
        }
        if ((i & 16) != 0) {
            j = documentInfo.lastModified;
        }
        long j2 = j;
        return documentInfo.copy(uri, str, str2, l, j2);
    }

    @Field
    public static /* synthetic */ void getLastModified$annotations() {
    }

    @Field
    public static /* synthetic */ void getMimeType$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    public static /* synthetic */ void getSize$annotations() {
    }

    @Field
    public static /* synthetic */ void getUri$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getLastModified() {
        return this.lastModified;
    }

    public final DocumentInfo copy(Uri uri, String name, String mimeType, Long size, long lastModified) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(name, "name");
        return new DocumentInfo(uri, name, mimeType, size, lastModified);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentInfo)) {
            return false;
        }
        DocumentInfo documentInfo = (DocumentInfo) other;
        return Intrinsics.areEqual(this.uri, documentInfo.uri) && Intrinsics.areEqual(this.name, documentInfo.name) && Intrinsics.areEqual(this.mimeType, documentInfo.mimeType) && Intrinsics.areEqual(this.size, documentInfo.size) && this.lastModified == documentInfo.lastModified;
    }

    public int hashCode() {
        int iHashCode = ((this.uri.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.mimeType;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.size;
        return ((iHashCode2 + (l != null ? l.hashCode() : 0)) * 31) + Long.hashCode(this.lastModified);
    }

    public String toString() {
        return "DocumentInfo(uri=" + this.uri + ", name=" + this.name + ", mimeType=" + this.mimeType + ", size=" + this.size + ", lastModified=" + this.lastModified + ")";
    }

    public DocumentInfo(Uri uri, String name, String str, Long l, long j) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(name, "name");
        this.uri = uri;
        this.name = name;
        this.mimeType = str;
        this.size = l;
        this.lastModified = j;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final String getName() {
        return this.name;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final Long getSize() {
        return this.size;
    }

    public final long getLastModified() {
        return this.lastModified;
    }
}
