package expo.modules.documentpicker;

import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lexpo/modules/documentpicker/DocumentPickerResult;", "Lexpo/modules/kotlin/records/Record;", "canceled", "", "assets", "", "Lexpo/modules/documentpicker/DocumentInfo;", "<init>", "(ZLjava/util/List;)V", "getCanceled$annotations", "()V", "getCanceled", "()Z", "getAssets$annotations", "getAssets", "()Ljava/util/List;", "component1", "component2", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "expo-document-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DocumentPickerResult implements Record {
    private final List<DocumentInfo> assets;
    private final boolean canceled;

    /* JADX WARN: Multi-variable type inference failed */
    public DocumentPickerResult() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentPickerResult copy$default(DocumentPickerResult documentPickerResult, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = documentPickerResult.canceled;
        }
        if ((i & 2) != 0) {
            list = documentPickerResult.assets;
        }
        return documentPickerResult.copy(z, list);
    }

    @Field
    public static /* synthetic */ void getAssets$annotations() {
    }

    @Field
    public static /* synthetic */ void getCanceled$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanceled() {
        return this.canceled;
    }

    public final List<DocumentInfo> component2() {
        return this.assets;
    }

    public final DocumentPickerResult copy(boolean canceled, List<DocumentInfo> assets) {
        return new DocumentPickerResult(canceled, assets);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentPickerResult)) {
            return false;
        }
        DocumentPickerResult documentPickerResult = (DocumentPickerResult) other;
        return this.canceled == documentPickerResult.canceled && Intrinsics.areEqual(this.assets, documentPickerResult.assets);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.canceled) * 31;
        List<DocumentInfo> list = this.assets;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "DocumentPickerResult(canceled=" + this.canceled + ", assets=" + this.assets + ")";
    }

    public DocumentPickerResult(boolean z, List<DocumentInfo> list) {
        this.canceled = z;
        this.assets = list;
    }

    public /* synthetic */ DocumentPickerResult(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : list);
    }

    public final boolean getCanceled() {
        return this.canceled;
    }

    public final List<DocumentInfo> getAssets() {
        return this.assets;
    }
}
