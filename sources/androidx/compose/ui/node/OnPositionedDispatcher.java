package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class OnPositionedDispatcher {
    private LayoutNode[] cachedNodes;
    private final MutableVector layoutNodes = new MutableVector(new LayoutNode[16], 0);
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public final boolean isNotEmpty() {
        return this.layoutNodes.isNotEmpty();
    }

    public final void onNodePositioned(LayoutNode layoutNode) {
        this.layoutNodes.add(layoutNode);
        layoutNode.setNeedsOnPositionedDispatch$ui_release(true);
    }

    public final void remove(LayoutNode layoutNode) {
        this.layoutNodes.remove(layoutNode);
    }

    public final void onRootNodePositioned(LayoutNode layoutNode) {
        this.layoutNodes.clear();
        this.layoutNodes.add(layoutNode);
        layoutNode.setNeedsOnPositionedDispatch$ui_release(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatch() {
        LayoutNode[] layoutNodeArr;
        this.layoutNodes.sortWith(Companion.DepthComparator.INSTANCE);
        int size = this.layoutNodes.getSize();
        LayoutNode[] layoutNodeArr2 = this.cachedNodes;
        if (layoutNodeArr2 == null || layoutNodeArr2.length < size) {
            layoutNodeArr = layoutNodeArr2;
            layoutNodeArr = new LayoutNode[Math.max(16, this.layoutNodes.getSize())];
        }
        layoutNodeArr = layoutNodeArr2;
        this.cachedNodes = null;
        for (int i = 0; i < size; i++) {
            layoutNodeArr[i] = this.layoutNodes.getContent()[i];
        }
        this.layoutNodes.clear();
        while (true) {
            size--;
            if (-1 < size) {
                LayoutNode layoutNode = layoutNodeArr[size];
                Intrinsics.checkNotNull(layoutNode);
                if (layoutNode.getNeedsOnPositionedDispatch$ui_release()) {
                    dispatchHierarchy(layoutNode);
                }
            } else {
                this.cachedNodes = layoutNodeArr;
                return;
            }
        }
    }

    private final void dispatchHierarchy(LayoutNode layoutNode) {
        layoutNode.dispatchOnPositionedCallbacks$ui_release();
        int i = 0;
        layoutNode.setNeedsOnPositionedDispatch$ui_release(false);
        MutableVector mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            do {
                dispatchHierarchy((LayoutNode) content[i]);
                i++;
            } while (i < size);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private static final class DepthComparator implements Comparator {
            public static final DepthComparator INSTANCE = new DepthComparator();

            private DepthComparator() {
            }

            @Override // java.util.Comparator
            public int compare(LayoutNode layoutNode, LayoutNode layoutNode2) {
                int iCompare = Intrinsics.compare(layoutNode2.getDepth$ui_release(), layoutNode.getDepth$ui_release());
                return iCompare != 0 ? iCompare : Intrinsics.compare(layoutNode.hashCode(), layoutNode2.hashCode());
            }
        }
    }
}
