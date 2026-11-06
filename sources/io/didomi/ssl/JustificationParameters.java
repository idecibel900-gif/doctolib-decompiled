package io.didomi.ssl;

import android.text.Spanned;
import com.opentok.android.PublisherKit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.k7, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0080\b\u0018\u00002\u00020\u0001:\u0001\u000bB-\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a¨\u0006\u001e"}, d2 = {"Lio/didomi/sdk/k7;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "Lio/didomi/sdk/k7$a;", "a", "Ljava/util/List;", "()Ljava/util/List;", "lineInfoList", "Landroid/text/Spanned;", "b", "Landroid/text/Spanned;", "()Landroid/text/Spanned;", "originalContent", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "shrunkContent", "d", "Z", "()Z", "isFontFamilyCustomized", "<init>", "(Ljava/util/List;Landroid/text/Spanned;Ljava/lang/String;Z)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class JustificationParameters {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final List<LineInfo> lineInfoList;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final Spanned originalContent;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final String shrunkContent;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private final boolean isFontFamilyCustomized;

    /* JADX INFO: renamed from: io.didomi.sdk.k7$a, reason: from toString */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0014"}, d2 = {"Lio/didomi/sdk/k7$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "()I", "lineIndex", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "spaceIndexes", "<init>", "(ILjava/util/List;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class LineInfo {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final int lineIndex;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private final List<Integer> spaceIndexes;

        public LineInfo(int i, List<Integer> spaceIndexes) {
            Intrinsics.checkNotNullParameter(spaceIndexes, "spaceIndexes");
            this.lineIndex = i;
            this.spaceIndexes = spaceIndexes;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getLineIndex() {
            return this.lineIndex;
        }

        public final List<Integer> b() {
            return this.spaceIndexes;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LineInfo)) {
                return false;
            }
            LineInfo lineInfo = (LineInfo) other;
            return this.lineIndex == lineInfo.lineIndex && Intrinsics.areEqual(this.spaceIndexes, lineInfo.spaceIndexes);
        }

        public int hashCode() {
            return (Integer.hashCode(this.lineIndex) * 31) + this.spaceIndexes.hashCode();
        }

        public String toString() {
            return "LineInfo(lineIndex=" + this.lineIndex + ", spaceIndexes=" + this.spaceIndexes + ')';
        }
    }

    public JustificationParameters(List<LineInfo> lineInfoList, Spanned originalContent, String shrunkContent, boolean z) {
        Intrinsics.checkNotNullParameter(lineInfoList, "lineInfoList");
        Intrinsics.checkNotNullParameter(originalContent, "originalContent");
        Intrinsics.checkNotNullParameter(shrunkContent, "shrunkContent");
        this.lineInfoList = lineInfoList;
        this.originalContent = originalContent;
        this.shrunkContent = shrunkContent;
        this.isFontFamilyCustomized = z;
    }

    public final List<LineInfo> a() {
        return this.lineInfoList;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Spanned getOriginalContent() {
        return this.originalContent;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getShrunkContent() {
        return this.shrunkContent;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getIsFontFamilyCustomized() {
        return this.isFontFamilyCustomized;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JustificationParameters)) {
            return false;
        }
        JustificationParameters justificationParameters = (JustificationParameters) other;
        return Intrinsics.areEqual(this.lineInfoList, justificationParameters.lineInfoList) && Intrinsics.areEqual(this.originalContent, justificationParameters.originalContent) && Intrinsics.areEqual(this.shrunkContent, justificationParameters.shrunkContent) && this.isFontFamilyCustomized == justificationParameters.isFontFamilyCustomized;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((((this.lineInfoList.hashCode() * 31) + this.originalContent.hashCode()) * 31) + this.shrunkContent.hashCode()) * 31;
        boolean z = this.isFontFamilyCustomized;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "JustificationParameters(lineInfoList=" + this.lineInfoList + ", originalContent=" + ((Object) this.originalContent) + ", shrunkContent=" + this.shrunkContent + ", isFontFamilyCustomized=" + this.isFontFamilyCustomized + ')';
    }
}
