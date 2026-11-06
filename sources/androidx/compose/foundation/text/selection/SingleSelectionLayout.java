package androidx.compose.foundation.text.selection;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
final class SingleSelectionLayout implements SelectionLayout {
    public static final Companion Companion = new Companion(null);
    private final int endSlot;
    private final SelectableInfo info;
    private final boolean isStartHandle;
    private final Selection previousSelection;
    private final int startSlot;

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public void forEachMiddleInfo(Function1 function1) {
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getSize() {
        return 1;
    }

    public SingleSelectionLayout(boolean z, int i, int i2, Selection selection, SelectableInfo selectableInfo) {
        this.isStartHandle = z;
        this.startSlot = i;
        this.endSlot = i2;
        this.previousSelection = selection;
        this.info = selectableInfo;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean isStartHandle() {
        return this.isStartHandle;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getStartSlot() {
        return this.startSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getEndSlot() {
        return this.endSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public Selection getPreviousSelection() {
        return this.previousSelection;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public CrossStatus getCrossStatus() {
        if (getStartSlot() < getEndSlot()) {
            return CrossStatus.NOT_CROSSED;
        }
        return getStartSlot() > getEndSlot() ? CrossStatus.CROSSED : this.info.getRawCrossStatus();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getStartInfo() {
        return this.info;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getEndInfo() {
        return this.info;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getCurrentInfo() {
        return this.info;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getFirstInfo() {
        return this.info;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean shouldRecomputeSelection(SelectionLayout selectionLayout) {
        if (getPreviousSelection() == null || selectionLayout == null || !(selectionLayout instanceof SingleSelectionLayout)) {
            return true;
        }
        SingleSelectionLayout singleSelectionLayout = (SingleSelectionLayout) selectionLayout;
        return (getStartSlot() == singleSelectionLayout.getStartSlot() && getEndSlot() == singleSelectionLayout.getEndSlot() && isStartHandle() == singleSelectionLayout.isStartHandle() && !this.info.shouldRecomputeSelection(singleSelectionLayout.info)) ? false : true;
    }

    public String toString() {
        return "SingleSelectionLayout(isStartHandle=" + isStartHandle() + ", crossed=" + getCrossStatus() + ", info=\n\t" + this.info + ')';
    }
}
