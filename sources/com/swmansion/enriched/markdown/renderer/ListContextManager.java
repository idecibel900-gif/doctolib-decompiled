package com.swmansion.enriched.markdown.renderer;

import com.swmansion.enriched.markdown.styles.ListStyle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ListContextManager {
    private final BlockStyleContext context;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlockStyleContext.ListType.values().length];
            try {
                iArr[BlockStyleContext.ListType.ORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BlockStyleContext.ListType.UNORDERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ListContextManager(BlockStyleContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public static final class ListEntryState {
        private final BlockStyleContext.ListType parentListType;
        private final int previousDepth;
        private final boolean wasNestedInOrderedList;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListEntryState)) {
                return false;
            }
            ListEntryState listEntryState = (ListEntryState) obj;
            return this.previousDepth == listEntryState.previousDepth && this.parentListType == listEntryState.parentListType && this.wasNestedInOrderedList == listEntryState.wasNestedInOrderedList;
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.previousDepth) * 31;
            BlockStyleContext.ListType listType = this.parentListType;
            return ((iHashCode + (listType == null ? 0 : listType.hashCode())) * 31) + Boolean.hashCode(this.wasNestedInOrderedList);
        }

        public String toString() {
            return "ListEntryState(previousDepth=" + this.previousDepth + ", parentListType=" + this.parentListType + ", wasNestedInOrderedList=" + this.wasNestedInOrderedList + ")";
        }

        public ListEntryState(int i, BlockStyleContext.ListType listType, boolean z) {
            this.previousDepth = i;
            this.parentListType = listType;
            this.wasNestedInOrderedList = z;
        }

        public final int getPreviousDepth() {
            return this.previousDepth;
        }

        public final BlockStyleContext.ListType getParentListType() {
            return this.parentListType;
        }

        public final boolean getWasNestedInOrderedList() {
            return this.wasNestedInOrderedList;
        }
    }

    public final ListEntryState enterList(BlockStyleContext.ListType listType, ListStyle style, int i) {
        Intrinsics.checkNotNullParameter(listType, "listType");
        Intrinsics.checkNotNullParameter(style, "style");
        int listDepth = this.context.getListDepth();
        boolean z = false;
        boolean z2 = listDepth > 0;
        BlockStyleContext.ListType listType2 = z2 ? this.context.getListType() : null;
        boolean z3 = listType2 == BlockStyleContext.ListType.ORDERED;
        if (z2 && z3) {
            this.context.pushOrderedListItemNumber();
        }
        this.context.setListDepth(listDepth + 1);
        int i2 = WhenMappings.$EnumSwitchMapping$0[listType.ordinal()];
        if (i2 == 1) {
            this.context.setOrderedListStyle(style);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.context.setUnorderedListStyle(style);
        }
        this.context.resetListItemNumber(i);
        if (z2 && z3) {
            z = true;
        }
        return new ListEntryState(listDepth, listType2, z);
    }

    public final void exitList(ListEntryState entryState) {
        Intrinsics.checkNotNullParameter(entryState, "entryState");
        this.context.setListDepth(entryState.getPreviousDepth());
        this.context.clearListStyle();
        if (entryState.getWasNestedInOrderedList()) {
            this.context.popOrderedListItemNumber();
        }
        if (entryState.getPreviousDepth() > 0) {
            this.context.setListType(entryState.getParentListType());
        }
    }
}
