package expo.modules.filesystem;

import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lexpo/modules/filesystem/WriteOptions;", "Lexpo/modules/kotlin/records/Record;", "encoding", "Lexpo/modules/filesystem/EncodingType;", "append", "", "<init>", "(Lexpo/modules/filesystem/EncodingType;Z)V", "getEncoding$annotations", "()V", "getEncoding", "()Lexpo/modules/filesystem/EncodingType;", "getAppend$annotations", "getAppend", "()Z", "component1", "component2", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class WriteOptions implements Record {
    private final boolean append;
    private final EncodingType encoding;

    /* JADX WARN: Multi-variable type inference failed */
    public WriteOptions() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WriteOptions copy$default(WriteOptions writeOptions, EncodingType encodingType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            encodingType = writeOptions.encoding;
        }
        if ((i & 2) != 0) {
            z = writeOptions.append;
        }
        return writeOptions.copy(encodingType, z);
    }

    @Field
    public static /* synthetic */ void getAppend$annotations() {
    }

    @Field
    public static /* synthetic */ void getEncoding$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EncodingType getEncoding() {
        return this.encoding;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAppend() {
        return this.append;
    }

    public final WriteOptions copy(EncodingType encoding, boolean append) {
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        return new WriteOptions(encoding, append);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WriteOptions)) {
            return false;
        }
        WriteOptions writeOptions = (WriteOptions) other;
        return this.encoding == writeOptions.encoding && this.append == writeOptions.append;
    }

    public int hashCode() {
        return (this.encoding.hashCode() * 31) + Boolean.hashCode(this.append);
    }

    public String toString() {
        return "WriteOptions(encoding=" + this.encoding + ", append=" + this.append + ")";
    }

    public WriteOptions(EncodingType encoding, boolean z) {
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        this.encoding = encoding;
        this.append = z;
    }

    public final EncodingType getEncoding() {
        return this.encoding;
    }

    public /* synthetic */ WriteOptions(EncodingType encodingType, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? EncodingType.UTF8 : encodingType, (i & 2) != 0 ? false : z);
    }

    public final boolean getAppend() {
        return this.append;
    }
}
