package com.swmansion.enriched.markdown.input.editing;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EditContext {
    private final int deletedLength;
    private final int editStart;
    private final int insertedLength;
    private final Set pendingStyleRemovals;
    private final Set pendingStyles;
    private final int preEditSelectionEnd;
    private final int preEditSelectionStart;
    private final String preEditText;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EditContext)) {
            return false;
        }
        EditContext editContext = (EditContext) obj;
        return this.editStart == editContext.editStart && this.deletedLength == editContext.deletedLength && this.insertedLength == editContext.insertedLength && Intrinsics.areEqual(this.preEditText, editContext.preEditText) && this.preEditSelectionStart == editContext.preEditSelectionStart && this.preEditSelectionEnd == editContext.preEditSelectionEnd && Intrinsics.areEqual(this.pendingStyles, editContext.pendingStyles) && Intrinsics.areEqual(this.pendingStyleRemovals, editContext.pendingStyleRemovals);
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.editStart) * 31) + Integer.hashCode(this.deletedLength)) * 31) + Integer.hashCode(this.insertedLength)) * 31) + this.preEditText.hashCode()) * 31) + Integer.hashCode(this.preEditSelectionStart)) * 31) + Integer.hashCode(this.preEditSelectionEnd)) * 31) + this.pendingStyles.hashCode()) * 31) + this.pendingStyleRemovals.hashCode();
    }

    public String toString() {
        return "EditContext(editStart=" + this.editStart + ", deletedLength=" + this.deletedLength + ", insertedLength=" + this.insertedLength + ", preEditText=" + this.preEditText + ", preEditSelectionStart=" + this.preEditSelectionStart + ", preEditSelectionEnd=" + this.preEditSelectionEnd + ", pendingStyles=" + this.pendingStyles + ", pendingStyleRemovals=" + this.pendingStyleRemovals + ")";
    }

    public EditContext(int i, int i2, int i3, String preEditText, int i4, int i5, Set pendingStyles, Set pendingStyleRemovals) {
        Intrinsics.checkNotNullParameter(preEditText, "preEditText");
        Intrinsics.checkNotNullParameter(pendingStyles, "pendingStyles");
        Intrinsics.checkNotNullParameter(pendingStyleRemovals, "pendingStyleRemovals");
        this.editStart = i;
        this.deletedLength = i2;
        this.insertedLength = i3;
        this.preEditText = preEditText;
        this.preEditSelectionStart = i4;
        this.preEditSelectionEnd = i5;
        this.pendingStyles = pendingStyles;
        this.pendingStyleRemovals = pendingStyleRemovals;
    }

    public final int getEditStart() {
        return this.editStart;
    }

    public final int getDeletedLength() {
        return this.deletedLength;
    }

    public final int getInsertedLength() {
        return this.insertedLength;
    }

    public final String getPreEditText() {
        return this.preEditText;
    }

    public final int getPreEditSelectionStart() {
        return this.preEditSelectionStart;
    }

    public final int getPreEditSelectionEnd() {
        return this.preEditSelectionEnd;
    }

    public final Set getPendingStyles() {
        return this.pendingStyles;
    }

    public final Set getPendingStyleRemovals() {
        return this.pendingStyleRemovals;
    }
}
