package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope {
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private GraphicsLayer explicitLayer;
    private boolean forceMeasureWithLookaheadConstraints;
    private boolean forcePlaceWithLookaheadOffset;
    private boolean isClipping;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1 layerBlock;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private Map oldAlignmentLines;
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;
    public static final Companion Companion = new Companion(null);
    private static final Function1 onCommitAffectingLayerParams = new Function1() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayerParams$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((NodeCoordinator) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(NodeCoordinator nodeCoordinator) {
            if (nodeCoordinator.isValidOwnerScope()) {
                LayerPositionalProperties layerPositionalProperties = nodeCoordinator.layerPositionalProperties;
                if (layerPositionalProperties != null) {
                    NodeCoordinator.tmpLayerPositionalProperties.copyFrom(layerPositionalProperties);
                    NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null);
                    if (NodeCoordinator.tmpLayerPositionalProperties.hasSameValuesAs(layerPositionalProperties)) {
                        return;
                    }
                    LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
                    LayoutNodeLayoutDelegate layoutDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release();
                    if (layoutDelegate$ui_release.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                        if (layoutDelegate$ui_release.getCoordinatesAccessedDuringModifierPlacement() || layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement()) {
                            LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                        }
                        layoutDelegate$ui_release.getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                    }
                    Owner owner$ui_release = layoutNode.getOwner$ui_release();
                    if (owner$ui_release != null) {
                        owner$ui_release.requestOnPositionedCallback(layoutNode);
                        return;
                    }
                    return;
                }
                NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null);
            }
        }
    };
    private static final Function1 onCommitAffectingLayer = new Function1() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((NodeCoordinator) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(NodeCoordinator nodeCoordinator) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
    };
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m1436constructorimpl$default(null, 1, null);
    private static final HitTestSource PointerInputSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode layoutNode) {
            return true;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* JADX INFO: renamed from: entityType-OLwlOKw, reason: not valid java name */
        public int mo1981entityTypeOLwlOKw() {
            return NodeKind.m1990constructorimpl(16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v1, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r10v12 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r10v9 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.runtime.collection.MutableVector] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.runtime.collection.MutableVector] */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference failed for: r5v4 */
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            int iM1990constructorimpl = NodeKind.m1990constructorimpl(16);
            ?? mutableVector = 0;
            while (node != 0) {
                if (!(node instanceof PointerInputModifierNode)) {
                    if ((node.getKindSet$ui_release() & iM1990constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                        Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release();
                        int i = 0;
                        while (delegate$ui_release != null) {
                            if ((delegate$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    mutableVector = mutableVector;
                                    node = node;
                                    mutableVector = mutableVector;
                                    node = delegate$ui_release;
                                } else {
                                    if (mutableVector == 0) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node != 0) {
                                        mutableVector.add(node);
                                        node = 0;
                                    }
                                    mutableVector.add(delegate$ui_release);
                                }
                            } else {
                                mutableVector = mutableVector;
                                node = node;
                            }
                            delegate$ui_release = delegate$ui_release.getChild$ui_release();
                            mutableVector = mutableVector;
                            node = node;
                        }
                        if (i == 1) {
                            mutableVector = mutableVector;
                            node = node;
                        } else {
                            mutableVector = mutableVector;
                            node = node;
                        }
                    }
                } else if (((PointerInputModifierNode) node).interceptOutOfBoundsChildEvents()) {
                    return true;
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* JADX INFO: renamed from: childHitTest-YqVAtuI, reason: not valid java name */
        public void mo1980childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
            layoutNode.m1904hitTestM_7yMNQ$ui_release(j, hitTestResult, z, z2);
        }
    };
    private static final HitTestSource SemanticsSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* JADX INFO: renamed from: entityType-OLwlOKw */
        public int mo1981entityTypeOLwlOKw() {
            return NodeKind.m1990constructorimpl(8);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode layoutNode) {
            SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
            boolean z = false;
            if (collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.isClearingSemantics()) {
                z = true;
            }
            return !z;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* JADX INFO: renamed from: childHitTest-YqVAtuI */
        public void mo1980childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
            layoutNode.m1905hitTestSemanticsM_7yMNQ$ui_release(j, hitTestResult, z, z2);
        }
    };
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    private float lastLayerAlpha = 0.8f;
    private long position = IntOffset.Companion.m2598getZeronOccac();
    private final Function2 drawBlock = new Function2() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Canvas) obj, (GraphicsLayer) obj2);
            return Unit.INSTANCE;
        }

        public final void invoke(final Canvas canvas, final GraphicsLayer graphicsLayer) {
            if (this.this$0.getLayoutNode().isPlaced()) {
                OwnerSnapshotObserver snapshotObserver = this.this$0.getSnapshotObserver();
                NodeCoordinator nodeCoordinator = this.this$0;
                Function1 function1 = NodeCoordinator.onCommitAffectingLayer;
                final NodeCoordinator nodeCoordinator2 = this.this$0;
                snapshotObserver.observeReads$ui_release(nodeCoordinator, function1, new Function0() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1982invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m1982invoke() {
                        nodeCoordinator2.drawContainedDrawModifiers(canvas, graphicsLayer);
                    }
                });
                this.this$0.lastLayerDrawingWasSkipped = false;
                return;
            }
            this.this$0.lastLayerDrawingWasSkipped = true;
        }
    };
    private final Function0 invalidateParentLayer = new Function0() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m1985invoke();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1985invoke() {
            NodeCoordinator wrappedBy$ui_release = this.this$0.getWrappedBy$ui_release();
            if (wrappedBy$ui_release != null) {
                wrappedBy$ui_release.invalidateLayer();
            }
        }
    };

    public interface HitTestSource {
        /* JADX INFO: renamed from: childHitTest-YqVAtuI */
        void mo1980childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2);

        /* JADX INFO: renamed from: entityType-OLwlOKw */
        int mo1981entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode layoutNode);
    }

    public abstract void ensureLookaheadDelegateCreated();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    public abstract LookaheadDelegate getLookaheadDelegate();

    public abstract Modifier.Node getTail();

    public abstract void performDraw(Canvas canvas, GraphicsLayer graphicsLayer);

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
    }

    public final void setForcePlaceWithLookaheadOffset$ui_release(boolean z) {
        this.forcePlaceWithLookaheadOffset = z;
    }

    public final boolean getForceMeasureWithLookaheadConstraints$ui_release() {
        return this.forceMeasureWithLookaheadConstraints;
    }

    public final NodeCoordinator getWrapped$ui_release() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final NodeCoordinator getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas, GraphicsLayer graphicsLayer) {
        Modifier.Node nodeM1973headH91voCI = m1973headH91voCI(NodeKind.m1990constructorimpl(4));
        if (nodeM1973headH91voCI == null) {
            performDraw(canvas, graphicsLayer);
        } else {
            getLayoutNode().getMDrawScope$ui_release().m1916draweZhPAX0$ui_release(canvas, IntSizeKt.m2615toSizeozmzZPI(mo1845getSizeYbymL2g()), this, nodeM1973headH91voCI, graphicsLayer);
        }
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v4 */
    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node nodeHeadNode = headNode(NodeKindKt.m1991getIncludeSelfInTraversalH91voCI(NodeKind.m1990constructorimpl(16)));
        if (nodeHeadNode != null && nodeHeadNode.isAttached()) {
            int iM1990constructorimpl = NodeKind.m1990constructorimpl(16);
            if (!nodeHeadNode.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
            }
            Modifier.Node node = nodeHeadNode.getNode();
            if ((node.getAggregateChildKindSet$ui_release() & iM1990constructorimpl) != 0) {
                while (node != null) {
                    if ((node.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                        ?? Pop = node;
                        ?? mutableVector = 0;
                        while (Pop != 0) {
                            if (!(Pop instanceof PointerInputModifierNode)) {
                                if ((Pop.getKindSet$ui_release() & iM1990constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node delegate$ui_release = ((DelegatingNode) Pop).getDelegate$ui_release();
                                    int i = 0;
                                    while (delegate$ui_release != null) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                Pop = Pop;
                                                mutableVector = mutableVector;
                                                mutableVector = mutableVector;
                                                Pop = delegate$ui_release;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (Pop != 0) {
                                                    mutableVector.add(Pop);
                                                    Pop = 0;
                                                }
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        } else {
                                            Pop = Pop;
                                            mutableVector = mutableVector;
                                        }
                                        delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    }
                                    if (i == 1) {
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    } else {
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    }
                                }
                            } else if (((PointerInputModifierNode) Pop).sharePointerInputWithSiblings()) {
                                return true;
                            }
                            Pop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    node = node.getChild$ui_release();
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v2, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final void onMeasured() {
        Modifier.Node parent$ui_release;
        if (m1959hasNodeH91voCI(NodeKind.m1990constructorimpl(128))) {
            Snapshot.Companion companion = Snapshot.Companion;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                int iM1990constructorimpl = NodeKind.m1990constructorimpl(128);
                boolean zM1991getIncludeSelfInTraversalH91voCI = NodeKindKt.m1991getIncludeSelfInTraversalH91voCI(iM1990constructorimpl);
                if (zM1991getIncludeSelfInTraversalH91voCI) {
                    parent$ui_release = getTail();
                } else {
                    parent$ui_release = getTail().getParent$ui_release();
                    if (parent$ui_release == null) {
                    }
                    Unit unit = Unit.INSTANCE;
                }
                for (Modifier.Node nodeHeadNode = headNode(zM1991getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet$ui_release() & iM1990constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild$ui_release()) {
                    if ((nodeHeadNode.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                        ?? mutableVector = 0;
                        ?? Pop = nodeHeadNode;
                        while (Pop != 0) {
                            if (!(Pop instanceof LayoutAwareModifierNode)) {
                                if ((Pop.getKindSet$ui_release() & iM1990constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node delegate$ui_release = ((DelegatingNode) Pop).getDelegate$ui_release();
                                    int i = 0;
                                    Pop = Pop;
                                    mutableVector = mutableVector;
                                    while (delegate$ui_release != null) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                mutableVector = mutableVector;
                                                Pop = delegate$ui_release;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (Pop != 0) {
                                                    mutableVector.add(Pop);
                                                    Pop = 0;
                                                }
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                        delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    }
                                    if (i == 1) {
                                    }
                                }
                            } else {
                                ((LayoutAwareModifierNode) Pop).mo195onRemeasuredozmzZPI(m1860getMeasuredSizeYbymL2g());
                            }
                            Pop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if (nodeHeadNode == parent$ui_release) {
                        break;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v4 */
    public final void onPlaced() {
        int iM1990constructorimpl = NodeKind.m1990constructorimpl(128);
        boolean zM1991getIncludeSelfInTraversalH91voCI = NodeKindKt.m1991getIncludeSelfInTraversalH91voCI(iM1990constructorimpl);
        Modifier.Node tail = getTail();
        if (!zM1991getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM1991getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet$ui_release() & iM1990constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild$ui_release()) {
            if ((nodeHeadNode.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                ?? Pop = nodeHeadNode;
                ?? mutableVector = 0;
                while (Pop != 0) {
                    if (!(Pop instanceof LayoutAwareModifierNode)) {
                        if ((Pop.getKindSet$ui_release() & iM1990constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = ((DelegatingNode) Pop).getDelegate$ui_release();
                            int i = 0;
                            Pop = Pop;
                            mutableVector = mutableVector;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        mutableVector = mutableVector;
                                        Pop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (Pop != 0) {
                                            mutableVector.add(Pop);
                                            Pop = 0;
                                        }
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                Pop = Pop;
                                mutableVector = mutableVector;
                            }
                            if (i == 1) {
                            }
                        }
                    } else {
                        ((LayoutAwareModifierNode) Pop).onPlaced(this);
                    }
                    Pop = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node headNode(boolean z) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes$ui_release().getHead$ui_release();
        }
        if (z) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null) {
                return null;
            }
            return tail.getChild$ui_release();
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            return nodeCoordinator2.getTail();
        }
        return null;
    }

    /* JADX INFO: renamed from: hasNode-H91voCI, reason: not valid java name */
    private final boolean m1959hasNodeH91voCI(int i) {
        Modifier.Node nodeHeadNode = headNode(NodeKindKt.m1991getIncludeSelfInTraversalH91voCI(i));
        return nodeHeadNode != null && DelegatableNodeKt.m1890has64DMado(nodeHeadNode, i);
    }

    /* JADX INFO: renamed from: head-H91voCI, reason: not valid java name */
    public final Modifier.Node m1973headH91voCI(int i) {
        boolean zM1991getIncludeSelfInTraversalH91voCI = NodeKindKt.m1991getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!zM1991getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return null;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM1991getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet$ui_release() & i) != 0; nodeHeadNode = nodeHeadNode.getChild$ui_release()) {
            if ((nodeHeadNode.getKindSet$ui_release() & i) != 0) {
                return nodeHeadNode;
            }
            if (nodeHeadNode == tail) {
                return null;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public final long mo1845getSizeYbymL2g() {
        return m1860getMeasuredSizeYbymL2g();
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        GraphicsLayer graphicsLayer = this.explicitLayer;
        if (graphicsLayer != null) {
            mo1862placeAtf8xVGno(mo1937getPositionnOccac(), this.zIndex, graphicsLayer);
        } else {
            mo1844placeAtf8xVGno(mo1937getPositionnOccac(), this.zIndex, this.layerBlock);
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getTail().isAttached();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("Asking for measurement result of unmeasured layout modifier");
    }

    public void setMeasureResult$ui_release(MeasureResult measureResult) {
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            if (measureResult2 == null || measureResult.getWidth() != measureResult2.getWidth() || measureResult.getHeight() != measureResult2.getHeight()) {
                onMeasureResultChanged(measureResult.getWidth(), measureResult.getHeight());
            }
            Map map = this.oldAlignmentLines;
            if (((map == null || map.isEmpty()) && measureResult.getAlignmentLines().isEmpty()) || Intrinsics.areEqual(measureResult.getAlignmentLines(), this.oldAlignmentLines)) {
                return;
            }
            getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            Map linkedHashMap = this.oldAlignmentLines;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                this.oldAlignmentLines = linkedHashMap;
            }
            linkedHashMap.clear();
            linkedHashMap.putAll(measureResult.getAlignmentLines());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v4 */
    protected void onMeasureResultChanged(int i, int i2) {
        NodeCoordinator nodeCoordinator;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo1996resizeozmzZPI(IntSizeKt.IntSize(i, i2));
        } else if (getLayoutNode().isPlaced() && (nodeCoordinator = this.wrappedBy) != null) {
            nodeCoordinator.invalidateLayer();
        }
        m1863setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
        if (this.layerBlock != null) {
            updateLayerParameters(false);
        }
        int iM1990constructorimpl = NodeKind.m1990constructorimpl(4);
        boolean zM1991getIncludeSelfInTraversalH91voCI = NodeKindKt.m1991getIncludeSelfInTraversalH91voCI(iM1990constructorimpl);
        Modifier.Node tail = getTail();
        if (zM1991getIncludeSelfInTraversalH91voCI || (tail = tail.getParent$ui_release()) != null) {
            for (Modifier.Node nodeHeadNode = headNode(zM1991getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet$ui_release() & iM1990constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild$ui_release()) {
                if ((nodeHeadNode.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                    ?? Pop = nodeHeadNode;
                    ?? mutableVector = 0;
                    while (Pop != 0) {
                        if (Pop instanceof DrawModifierNode) {
                            ((DrawModifierNode) Pop).onMeasureResultChanged();
                        } else if ((Pop.getKindSet$ui_release() & iM1990constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = ((DelegatingNode) Pop).getDelegate$ui_release();
                            int i3 = 0;
                            Pop = Pop;
                            mutableVector = mutableVector;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                                    i3++;
                                    if (i3 == 1) {
                                        mutableVector = mutableVector;
                                        Pop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (Pop != 0) {
                                            mutableVector.add(Pop);
                                            Pop = 0;
                                        }
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                Pop = Pop;
                                mutableVector = mutableVector;
                            }
                            if (i3 == 1) {
                            }
                        }
                        Pop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (nodeHeadNode == tail) {
                    break;
                }
            }
        }
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* JADX INFO: renamed from: getPosition-nOcc-ac */
    public long mo1937getPositionnOccac() {
        return this.position;
    }

    /* JADX INFO: renamed from: setPosition--gyyYBs, reason: not valid java name */
    protected void m1977setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v6 */
    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        if (!getLayoutNode().getNodes$ui_release().m1952hasH91voCI$ui_release(NodeKind.m1990constructorimpl(64))) {
            return null;
        }
        getTail();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        for (Modifier.Node tail$ui_release = getLayoutNode().getNodes$ui_release().getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if ((NodeKind.m1990constructorimpl(64) & tail$ui_release.getKindSet$ui_release()) != 0) {
                int iM1990constructorimpl = NodeKind.m1990constructorimpl(64);
                ?? mutableVector = 0;
                ?? Pop = tail$ui_release;
                while (Pop != 0) {
                    if (!(Pop instanceof ParentDataModifierNode)) {
                        if ((Pop.getKindSet$ui_release() & iM1990constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = ((DelegatingNode) Pop).getDelegate$ui_release();
                            int i = 0;
                            Pop = Pop;
                            mutableVector = mutableVector;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        mutableVector = mutableVector;
                                        Pop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (Pop != 0) {
                                            mutableVector.add(Pop);
                                            Pop = 0;
                                        }
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                Pop = Pop;
                                mutableVector = mutableVector;
                            }
                            if (i == 1) {
                            }
                        }
                    } else {
                        ref$ObjectRef.element = ((ParentDataModifierNode) Pop).modifyParentData(getLayoutNode().getDensity(), ref$ObjectRef.element);
                    }
                    Pop = DelegatableNodeKt.pop(mutableVector);
                }
            }
        }
        return ref$ObjectRef.element;
    }

    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate$ui_release().onCoordinatesUsed();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        onCoordinatesUsed$ui_release();
        return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
    }

    protected final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* JADX INFO: renamed from: getLastMeasurementConstraints-msEJaDk$ui_release, reason: not valid java name */
    public final long m1971getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return m1861getMeasurementConstraintsmsEJaDk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo1844placeAtf8xVGno(long j, float f, Function1 function1) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m1963placeSelfMLgxB_4(lookaheadDelegate.mo1937getPositionnOccac(), f, function1, null);
            return;
        }
        m1963placeSelfMLgxB_4(j, f, function1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo1862placeAtf8xVGno(long j, float f, GraphicsLayer graphicsLayer) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m1963placeSelfMLgxB_4(lookaheadDelegate.mo1937getPositionnOccac(), f, null, graphicsLayer);
            return;
        }
        m1963placeSelfMLgxB_4(j, f, null, graphicsLayer);
    }

    /* JADX INFO: renamed from: placeSelf-MLgxB_4, reason: not valid java name */
    private final void m1963placeSelfMLgxB_4(long j, float f, Function1 function1, GraphicsLayer graphicsLayer) {
        if (graphicsLayer != null) {
            if (!(function1 == null)) {
                InlineClassHelperKt.throwIllegalArgumentException("both ways to create layers shouldn't be used together");
            }
            if (this.explicitLayer != graphicsLayer) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
                this.explicitLayer = graphicsLayer;
            }
            if (this.layer == null) {
                OwnedLayer ownedLayerCreateLayer = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(this.drawBlock, this.invalidateParentLayer, graphicsLayer);
                ownedLayerCreateLayer.mo1996resizeozmzZPI(m1860getMeasuredSizeYbymL2g());
                ownedLayerCreateLayer.mo1995movegyyYBs(j);
                this.layer = ownedLayerCreateLayer;
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
            }
        } else {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
            }
            updateLayerBlock$default(this, function1, false, 2, null);
        }
        if (!IntOffset.m2590equalsimpl0(mo1937getPositionnOccac(), j)) {
            m1977setPositiongyyYBs(j);
            getLayoutNode().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo1995movegyyYBs(j);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = f;
        if (isPlacingForAlignment$ui_release()) {
            return;
        }
        captureRulers$ui_release(getMeasureResult$ui_release());
    }

    public final void releaseLayer() {
        if (this.layer != null) {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
            }
            updateLayerBlock$default(this, null, false, 2, null);
            LayoutNode.requestRelayout$ui_release$default(getLayoutNode(), false, 1, null);
        }
    }

    /* JADX INFO: renamed from: placeSelfApparentToRealOffset-MLgxB_4, reason: not valid java name */
    public final void m1976placeSelfApparentToRealOffsetMLgxB_4(long j, float f, Function1 function1, GraphicsLayer graphicsLayer) {
        m1963placeSelfMLgxB_4(IntOffset.m2595plusqkQi6aY(j, m1859getApparentToRealOffsetnOccac()), f, function1, graphicsLayer);
    }

    public final void draw(Canvas canvas, GraphicsLayer graphicsLayer) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas, graphicsLayer);
            return;
        }
        float fM2591getXimpl = IntOffset.m2591getXimpl(mo1937getPositionnOccac());
        float fM2592getYimpl = IntOffset.m2592getYimpl(mo1937getPositionnOccac());
        canvas.translate(fM2591getXimpl, fM2592getYimpl);
        drawContainedDrawModifiers(canvas, graphicsLayer);
        canvas.translate(-fM2591getXimpl, -fM2592getYimpl);
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        nodeCoordinator.updateLayerBlock(function1, z);
    }

    public final void updateLayerBlock(Function1 function1, boolean z) {
        Owner owner$ui_release;
        if (!(function1 == null || this.explicitLayer == null)) {
            InlineClassHelperKt.throwIllegalArgumentException("layerBlock can't be provided when explicitLayer is provided");
        }
        LayoutNode layoutNode = getLayoutNode();
        boolean z2 = (!z && this.layerBlock == function1 && Intrinsics.areEqual(this.layerDensity, layoutNode.getDensity()) && this.layerLayoutDirection == layoutNode.getLayoutDirection()) ? false : true;
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        if (layoutNode.isAttached() && function1 != null) {
            this.layerBlock = function1;
            if (this.layer != null) {
                if (z2) {
                    updateLayerParameters$default(this, false, 1, null);
                    return;
                }
                return;
            }
            OwnedLayer ownedLayerCreateLayer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(layoutNode), this.drawBlock, this.invalidateParentLayer, null, 4, null);
            ownedLayerCreateLayer$default.mo1996resizeozmzZPI(m1860getMeasuredSizeYbymL2g());
            ownedLayerCreateLayer$default.mo1995movegyyYBs(mo1937getPositionnOccac());
            this.layer = ownedLayerCreateLayer$default;
            updateLayerParameters$default(this, false, 1, null);
            layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            return;
        }
        this.layerBlock = null;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.destroy();
            layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            if (isAttached() && (owner$ui_release = layoutNode.getOwner$ui_release()) != null) {
                owner$ui_release.onLayoutChange(layoutNode);
            }
        }
        this.layer = null;
        this.lastLayerDrawingWasSkipped = false;
    }

    static /* synthetic */ void updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        nodeCoordinator.updateLayerParameters(z);
    }

    private final void updateLayerParameters(boolean z) {
        Owner owner$ui_release;
        if (this.explicitLayer != null) {
            return;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            final Function1 function1 = this.layerBlock;
            if (function1 == null) {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("updateLayerParameters requires a non-null layerBlock");
                throw new KotlinNothingValueException();
            }
            ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
            reusableGraphicsLayerScope.reset();
            reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
            reusableGraphicsLayerScope.setLayoutDirection$ui_release(getLayoutNode().getLayoutDirection());
            reusableGraphicsLayerScope.m1482setSizeuvyYCjk(IntSizeKt.m2615toSizeozmzZPI(mo1845getSizeYbymL2g()));
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new Function0() { // from class: androidx.compose.ui.node.NodeCoordinator.updateLayerParameters.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1987invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1987invoke() {
                    function1.invoke(NodeCoordinator.graphicsLayerScope);
                    NodeCoordinator.graphicsLayerScope.updateOutline$ui_release();
                }
            });
            LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
            if (layerPositionalProperties == null) {
                layerPositionalProperties = new LayerPositionalProperties();
                this.layerPositionalProperties = layerPositionalProperties;
            }
            layerPositionalProperties.copyFrom(reusableGraphicsLayerScope);
            ownedLayer.updateLayerProperties(reusableGraphicsLayerScope);
            this.isClipping = reusableGraphicsLayerScope.getClip();
            this.lastLayerAlpha = reusableGraphicsLayerScope.getAlpha();
            if (!z || (owner$ui_release = getLayoutNode().getOwner$ui_release()) == null) {
                return;
            }
            owner$ui_release.onLayoutChange(getLayoutNode());
            return;
        }
        if (this.layerBlock == null) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("null layer with a non-null layerBlock");
    }

    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return (this.layer == null || this.released || !getLayoutNode().isAttached()) ? false : true;
    }

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-NH-jbRc, reason: not valid java name */
    public final long m1972getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo232toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().mo1908getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* JADX INFO: renamed from: hitTest-YqVAtuI, reason: not valid java name */
    public final void m1974hitTestYqVAtuI(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        Modifier.Node nodeM1973headH91voCI = m1973headH91voCI(hitTestSource.mo1981entityTypeOLwlOKw());
        if (!m1979withinLayerBoundsk4lQ0M(j)) {
            if (z) {
                float fM1969distanceInMinimumTouchTargettz77jQw = m1969distanceInMinimumTouchTargettz77jQw(j, m1972getMinimumTouchTargetSizeNHjbRc());
                if (Float.isInfinite(fM1969distanceInMinimumTouchTargettz77jQw) || Float.isNaN(fM1969distanceInMinimumTouchTargettz77jQw) || !hitTestResult.isHitInMinimumTouchTargetBetter(fM1969distanceInMinimumTouchTargettz77jQw, false)) {
                    return;
                }
                m1961hitNearJHbHoSQ(nodeM1973headH91voCI, hitTestSource, j, hitTestResult, z, false, fM1969distanceInMinimumTouchTargettz77jQw);
                return;
            }
            return;
        }
        if (nodeM1973headH91voCI == null) {
            mo1897hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        if (m1975isPointerInBoundsk4lQ0M(j)) {
            m1960hit1hIXUjU(nodeM1973headH91voCI, hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        float fM1969distanceInMinimumTouchTargettz77jQw2 = !z ? Float.POSITIVE_INFINITY : m1969distanceInMinimumTouchTargettz77jQw(j, m1972getMinimumTouchTargetSizeNHjbRc());
        if (!Float.isInfinite(fM1969distanceInMinimumTouchTargettz77jQw2) && !Float.isNaN(fM1969distanceInMinimumTouchTargettz77jQw2) && hitTestResult.isHitInMinimumTouchTargetBetter(fM1969distanceInMinimumTouchTargettz77jQw2, z2)) {
            m1961hitNearJHbHoSQ(nodeM1973headH91voCI, hitTestSource, j, hitTestResult, z, z2, fM1969distanceInMinimumTouchTargettz77jQw2);
        } else {
            m1964speculativeHitJHbHoSQ(nodeM1973headH91voCI, hitTestSource, j, hitTestResult, z, z2, fM1969distanceInMinimumTouchTargettz77jQw2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hit-1hIXUjU, reason: not valid java name */
    public final void m1960hit1hIXUjU(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final boolean z, final boolean z2) {
        if (node == null) {
            mo1897hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hit(node, z2, new Function0() { // from class: androidx.compose.ui.node.NodeCoordinator$hit$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1983invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1983invoke() {
                    this.this$0.m1960hit1hIXUjU(NodeCoordinatorKt.m1989nextUntilhw7D004(node, hitTestSource.mo1981entityTypeOLwlOKw(), NodeKind.m1990constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hitNear-JHbHoSQ, reason: not valid java name */
    public final void m1961hitNearJHbHoSQ(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final boolean z, final boolean z2, final float f) {
        if (node == null) {
            mo1897hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hitInMinimumTouchTarget(node, f, z2, new Function0() { // from class: androidx.compose.ui.node.NodeCoordinator$hitNear$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1984invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1984invoke() {
                    this.this$0.m1961hitNearJHbHoSQ(NodeCoordinatorKt.m1989nextUntilhw7D004(node, hitTestSource.mo1981entityTypeOLwlOKw(), NodeKind.m1990constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: speculativeHit-JHbHoSQ, reason: not valid java name */
    public final void m1964speculativeHitJHbHoSQ(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final boolean z, final boolean z2, final float f) {
        if (node == null) {
            mo1897hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else if (!hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            m1964speculativeHitJHbHoSQ(NodeCoordinatorKt.m1989nextUntilhw7D004(node, hitTestSource.mo1981entityTypeOLwlOKw(), NodeKind.m1990constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
        } else {
            hitTestResult.speculativeHit(node, f, z2, new Function0() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1986invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1986invoke() {
                    this.this$0.m1964speculativeHitJHbHoSQ(NodeCoordinatorKt.m1989nextUntilhw7D004(node, hitTestSource.mo1981entityTypeOLwlOKw(), NodeKind.m1990constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
                }
            });
        }
    }

    /* JADX INFO: renamed from: hitTestChild-YqVAtuI */
    public void mo1897hitTestChildYqVAtuI(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m1974hitTestYqVAtuI(hitTestSource, m1958fromParentPosition8S9VItk$default(nodeCoordinator, j, false, 2, null), hitTestResult, z, z2);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long jM1968calculateMinimumTouchTargetPaddingE7KxVPU = m1968calculateMinimumTouchTargetPaddingE7KxVPU(m1972getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m1261getWidthimpl(jM1968calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setTop(-Size.m1259getHeightimpl(jM1968calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setRight(getMeasuredWidth() + Size.m1261getWidthimpl(jM1968calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setBottom(getMeasuredHeight() + Size.m1259getHeightimpl(jM1968calculateMinimumTouchTargetPaddingE7KxVPU));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != layoutCoordinatesFindRootCoordinates) {
            nodeCoordinator.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U */
    public long mo1850screenToLocalMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return mo1846localPositionOfR5De75A(LayoutCoordinatesKt.findRootCoordinates(this), LayoutNodeKt.requireOwner(getLayoutNode()).mo1811screenToLocalMKHz9U(j));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public long mo1853windowToLocalMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        return mo1846localPositionOfR5De75A(layoutCoordinatesFindRootCoordinates, Offset.m1227minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).mo1998calculateLocalPositionMKHz9U(j), LayoutCoordinatesKt.positionInRoot(layoutCoordinatesFindRootCoordinates)));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public long mo1849localToWindowMKHz9U(long j) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo1999calculatePositionInWindowMKHz9U(mo1848localToRootMKHz9U(j));
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        if (lookaheadLayoutCoordinates != null && (coordinator = lookaheadLayoutCoordinates.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public long mo1846localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        return mo1847localPositionOfS_NoaFU(layoutCoordinates, j, true);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-S_NoaFU */
    public long mo1847localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, long j, boolean z) {
        if (layoutCoordinates instanceof LookaheadLayoutCoordinates) {
            ((LookaheadLayoutCoordinates) layoutCoordinates).getCoordinator().onCoordinatesUsed$ui_release();
            return Offset.m1231unaryMinusF1C5BW0(layoutCoordinates.mo1847localPositionOfS_NoaFU(this, Offset.m1231unaryMinusF1C5BW0(j), z));
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != nodeCoordinatorFindCommonAncestor$ui_release) {
            j = coordinator.m1978toParentPosition8S9VItk(j, z);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m1957ancestorToLocalS_NoaFU(nodeCoordinatorFindCommonAncestor$ui_release, j, z);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformFrom-EL8BTi8 */
    public void mo1851transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m1441resetimpl(fArr);
        coordinator.m1967transformToAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui_release, fArr);
        m1966transformFromAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui_release, fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformToScreen-58bKbWc */
    public void mo1852transformToScreen58bKbWc(float[] fArr) {
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        m1967transformToAncestorEL8BTi8(toCoordinator(LayoutCoordinatesKt.findRootCoordinates(this)), fArr);
        ownerRequireOwner.mo1809localToScreen58bKbWc(fArr);
    }

    /* JADX INFO: renamed from: transformToAncestor-EL8BTi8, reason: not valid java name */
    private final void m1967transformToAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        NodeCoordinator nodeCoordinator2 = this;
        while (!Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator)) {
            OwnedLayer ownedLayer = nodeCoordinator2.layer;
            if (ownedLayer != null) {
                ownedLayer.mo1997transform58bKbWc(fArr);
            }
            long jMo1937getPositionnOccac = nodeCoordinator2.mo1937getPositionnOccac();
            if (!IntOffset.m2590equalsimpl0(jMo1937getPositionnOccac, IntOffset.Companion.m2598getZeronOccac())) {
                float[] fArr2 = tmpMatrix;
                Matrix.m1441resetimpl(fArr2);
                Matrix.m1450translateimpl$default(fArr2, IntOffset.m2591getXimpl(jMo1937getPositionnOccac), IntOffset.m2592getYimpl(jMo1937getPositionnOccac), 0.0f, 4, null);
                Matrix.m1447timesAssign58bKbWc(fArr, fArr2);
            }
            nodeCoordinator2 = nodeCoordinator2.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
        }
    }

    /* JADX INFO: renamed from: transformFromAncestor-EL8BTi8, reason: not valid java name */
    private final void m1966transformFromAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        if (Intrinsics.areEqual(nodeCoordinator, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        Intrinsics.checkNotNull(nodeCoordinator2);
        nodeCoordinator2.m1966transformFromAncestorEL8BTi8(nodeCoordinator, fArr);
        if (!IntOffset.m2590equalsimpl0(mo1937getPositionnOccac(), IntOffset.Companion.m2598getZeronOccac())) {
            float[] fArr2 = tmpMatrix;
            Matrix.m1441resetimpl(fArr2);
            Matrix.m1450translateimpl$default(fArr2, -IntOffset.m2591getXimpl(mo1937getPositionnOccac()), -IntOffset.m2592getYimpl(mo1937getPositionnOccac()), 0.0f, 4, null);
            Matrix.m1447timesAssign58bKbWc(fArr, fArr2);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo1992inverseTransform58bKbWc(fArr);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if (!layoutCoordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates " + layoutCoordinates + " is not attached!");
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight(IntSize.m2609getWidthimpl(layoutCoordinates.mo1845getSizeYbymL2g()));
        rectCache.setBottom(IntSize.m2608getHeightimpl(layoutCoordinates.mo1845getSizeYbymL2g()));
        NodeCoordinator nodeCoordinator = coordinator;
        while (nodeCoordinator != nodeCoordinatorFindCommonAncestor$ui_release) {
            boolean z2 = z;
            rectInParent$ui_release$default(nodeCoordinator, rectCache, z2, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            z = z2;
        }
        ancestorToLocal(nodeCoordinatorFindCommonAncestor$ui_release, rectCache, z);
        return MutableRectKt.toRect(rectCache);
    }

    /* JADX INFO: renamed from: ancestorToLocal-S_NoaFU, reason: not valid java name */
    private final long m1957ancestorToLocalS_NoaFU(NodeCoordinator nodeCoordinator, long j, boolean z) {
        if (nodeCoordinator == this) {
            return j;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 == null || Intrinsics.areEqual(nodeCoordinator, nodeCoordinator2)) {
            return m1970fromParentPosition8S9VItk(j, z);
        }
        return m1970fromParentPosition8S9VItk(nodeCoordinator2.m1957ancestorToLocalS_NoaFU(nodeCoordinator, j, z), z);
    }

    private final void ancestorToLocal(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z) {
        if (nodeCoordinator == this) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            nodeCoordinator2.ancestorToLocal(nodeCoordinator, mutableRect, z);
        }
        fromParentRect(mutableRect, z);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public long mo1848localToRootMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        onCoordinatesUsed$ui_release();
        long jM1965toParentPosition8S9VItk$default = j;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            jM1965toParentPosition8S9VItk$default = m1965toParentPosition8S9VItk$default(nodeCoordinator, jM1965toParentPosition8S9VItk$default, false, 2, null);
        }
        return jM1965toParentPosition8S9VItk$default;
    }

    /* JADX INFO: renamed from: toParentPosition-8S9VItk$default, reason: not valid java name */
    public static /* synthetic */ long m1965toParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return nodeCoordinator.m1978toParentPosition8S9VItk(j, z);
    }

    /* JADX INFO: renamed from: toParentPosition-8S9VItk, reason: not valid java name */
    public long m1978toParentPosition8S9VItk(long j, boolean z) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            j = ownedLayer.mo1994mapOffset8S9VItk(j, false);
        }
        return (z || !isPlacedUnderMotionFrameOfReference()) ? IntOffsetKt.m2600plusNvtHpc(j, mo1937getPositionnOccac()) : j;
    }

    /* JADX INFO: renamed from: fromParentPosition-8S9VItk$default, reason: not valid java name */
    public static /* synthetic */ long m1958fromParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return nodeCoordinator.m1970fromParentPosition8S9VItk(j, z);
    }

    /* JADX INFO: renamed from: fromParentPosition-8S9VItk, reason: not valid java name */
    public long m1970fromParentPosition8S9VItk(long j, boolean z) {
        if (z || !isPlacedUnderMotionFrameOfReference()) {
            j = IntOffsetKt.m2599minusNvtHpc(j, mo1937getPositionnOccac());
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.mo1994mapOffset8S9VItk(j, true) : j;
    }

    protected final void drawBorder(Canvas canvas, Paint paint) {
        canvas.drawRect(new Rect(0.5f, 0.5f, IntSize.m2609getWidthimpl(m1860getMeasuredSizeYbymL2g()) - 0.5f, IntSize.m2608getHeightimpl(m1860getMeasuredSizeYbymL2g()) - 0.5f), paint);
    }

    public final void onLayoutNodeAttach() {
        updateLayerBlock(this.layerBlock, true);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        releaseLayer();
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
    }

    public final void rectInParent$ui_release(MutableRect mutableRect, boolean z, boolean z2) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z2) {
                    long jM1972getMinimumTouchTargetSizeNHjbRc = m1972getMinimumTouchTargetSizeNHjbRc();
                    float fM1261getWidthimpl = Size.m1261getWidthimpl(jM1972getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    float fM1259getHeightimpl = Size.m1259getHeightimpl(jM1972getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    mutableRect.intersect(-fM1261getWidthimpl, -fM1259getHeightimpl, IntSize.m2609getWidthimpl(mo1845getSizeYbymL2g()) + fM1261getWidthimpl, IntSize.m2608getHeightimpl(mo1845getSizeYbymL2g()) + fM1259getHeightimpl);
                } else if (z) {
                    mutableRect.intersect(0.0f, 0.0f, IntSize.m2609getWidthimpl(mo1845getSizeYbymL2g()), IntSize.m2608getHeightimpl(mo1845getSizeYbymL2g()));
                }
                if (mutableRect.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(mutableRect, false);
        }
        float fM2591getXimpl = IntOffset.m2591getXimpl(mo1937getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() + fM2591getXimpl);
        mutableRect.setRight(mutableRect.getRight() + fM2591getXimpl);
        float fM2592getYimpl = IntOffset.m2592getYimpl(mo1937getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() + fM2592getYimpl);
        mutableRect.setBottom(mutableRect.getBottom() + fM2592getYimpl);
    }

    private final void fromParentRect(MutableRect mutableRect, boolean z) {
        float fM2591getXimpl = IntOffset.m2591getXimpl(mo1937getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() - fM2591getXimpl);
        mutableRect.setRight(mutableRect.getRight() - fM2591getXimpl);
        float fM2592getYimpl = IntOffset.m2592getYimpl(mo1937getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() - fM2592getYimpl);
        mutableRect.setBottom(mutableRect.getBottom() - fM2592getYimpl);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(mutableRect, true);
            if (this.isClipping && z) {
                mutableRect.intersect(0.0f, 0.0f, IntSize.m2609getWidthimpl(mo1845getSizeYbymL2g()), IntSize.m2608getHeightimpl(mo1845getSizeYbymL2g()));
                mutableRect.isEmpty();
            }
        }
    }

    /* JADX INFO: renamed from: withinLayerBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m1979withinLayerBoundsk4lQ0M(long j) {
        if (!OffsetKt.m1236isFinitek4lQ0M(j)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer == null || !this.isClipping || ownedLayer.mo1993isInLayerk4lQ0M(j);
    }

    /* JADX INFO: renamed from: isPointerInBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m1975isPointerInBoundsk4lQ0M(long j) {
        float fM1223getXimpl = Offset.m1223getXimpl(j);
        float fM1224getYimpl = Offset.m1224getYimpl(j);
        return fM1223getXimpl >= 0.0f && fM1224getYimpl >= 0.0f && fM1223getXimpl < ((float) getMeasuredWidth()) && fM1224getYimpl < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator nodeCoordinator) {
        LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
        LayoutNode layoutNode2 = getLayoutNode();
        if (layoutNode == layoutNode2) {
            Modifier.Node tail = nodeCoordinator.getTail();
            Modifier.Node tail2 = getTail();
            int iM1990constructorimpl = NodeKind.m1990constructorimpl(2);
            if (!tail2.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
            }
            for (Modifier.Node parent$ui_release = tail2.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                if ((parent$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0 && parent$ui_release == tail) {
                    return nodeCoordinator;
                }
            }
            return this;
        }
        while (layoutNode.getDepth$ui_release() > layoutNode2.getDepth$ui_release()) {
            layoutNode = layoutNode.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode);
        }
        while (layoutNode2.getDepth$ui_release() > layoutNode.getDepth$ui_release()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode != layoutNode2) {
            layoutNode = layoutNode.getParent$ui_release();
            layoutNode2 = layoutNode2.getParent$ui_release();
            if (layoutNode == null || layoutNode2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        if (layoutNode2 != getLayoutNode()) {
            if (layoutNode != nodeCoordinator.getLayoutNode()) {
                return layoutNode.getInnerCoordinator$ui_release();
            }
            return nodeCoordinator;
        }
        return this;
    }

    /* JADX INFO: renamed from: offsetFromEdge-MK-Hz9U, reason: not valid java name */
    private final long m1962offsetFromEdgeMKHz9U(long j) {
        float fM1223getXimpl = Offset.m1223getXimpl(j);
        float fMax = Math.max(0.0f, fM1223getXimpl < 0.0f ? -fM1223getXimpl : fM1223getXimpl - getMeasuredWidth());
        float fM1224getYimpl = Offset.m1224getYimpl(j);
        return OffsetKt.Offset(fMax, Math.max(0.0f, fM1224getYimpl < 0.0f ? -fM1224getYimpl : fM1224getYimpl - getMeasuredHeight()));
    }

    /* JADX INFO: renamed from: calculateMinimumTouchTargetPadding-E7KxVPU, reason: not valid java name */
    protected final long m1968calculateMinimumTouchTargetPaddingE7KxVPU(long j) {
        return SizeKt.Size(Math.max(0.0f, (Size.m1261getWidthimpl(j) - getMeasuredWidth()) / 2.0f), Math.max(0.0f, (Size.m1259getHeightimpl(j) - getMeasuredHeight()) / 2.0f));
    }

    /* JADX INFO: renamed from: distanceInMinimumTouchTarget-tz77jQw, reason: not valid java name */
    protected final float m1969distanceInMinimumTouchTargettz77jQw(long j, long j2) {
        if (getMeasuredWidth() >= Size.m1261getWidthimpl(j2) && getMeasuredHeight() >= Size.m1259getHeightimpl(j2)) {
            return Float.POSITIVE_INFINITY;
        }
        long jM1968calculateMinimumTouchTargetPaddingE7KxVPU = m1968calculateMinimumTouchTargetPaddingE7KxVPU(j2);
        float fM1261getWidthimpl = Size.m1261getWidthimpl(jM1968calculateMinimumTouchTargetPaddingE7KxVPU);
        float fM1259getHeightimpl = Size.m1259getHeightimpl(jM1968calculateMinimumTouchTargetPaddingE7KxVPU);
        long jM1962offsetFromEdgeMKHz9U = m1962offsetFromEdgeMKHz9U(j);
        if ((fM1261getWidthimpl > 0.0f || fM1259getHeightimpl > 0.0f) && Offset.m1223getXimpl(jM1962offsetFromEdgeMKHz9U) <= fM1261getWidthimpl && Offset.m1224getYimpl(jM1962offsetFromEdgeMKHz9U) <= fM1259getHeightimpl) {
            return Offset.m1222getDistanceSquaredimpl(jM1962offsetFromEdgeMKHz9U);
        }
        return Float.POSITIVE_INFINITY;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }
}
