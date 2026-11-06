package androidx.compose.ui.node;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.collection.MutableObjectFloatMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScope, MotionReferencePlacementDelegate {
    public static final Companion Companion = new Companion(null);
    private static final Function1 onCommitAffectingRuler = new Function1() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PlaceableResult) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(PlaceableResult placeableResult) {
            if (placeableResult.isValidOwnerScope()) {
                placeableResult.getPlaceable().captureRulers(placeableResult);
            }
        }
    };
    private RulerScope _rulerScope;
    private boolean isPlacedUnderMotionFrameOfReference;
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;
    private final Placeable.PlacementScope placementScope = PlaceableKt.PlacementScope(this);
    private MutableScatterMap rulerReaders;
    private MutableObjectFloatMap rulerValues;
    private MutableObjectFloatMap rulerValuesCache;

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui_release();

    public abstract LookaheadCapablePlaceable getParent();

    /* JADX INFO: renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public abstract long mo1937getPositionnOccac();

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return false;
    }

    public abstract void replace$ui_release();

    public boolean isPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void setPlacedUnderMotionFrameOfReference(boolean z) {
        this.isPlacedUnderMotionFrameOfReference = z;
    }

    public final RulerScope getRulerScope() {
        RulerScope rulerScope = this._rulerScope;
        return rulerScope == null ? new RulerScope() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$rulerScope$1
            @Override // androidx.compose.ui.unit.Density
            public float getDensity() {
                return this.this$0.getDensity();
            }

            @Override // androidx.compose.ui.unit.FontScaling
            public float getFontScale() {
                return this.this$0.getFontScale();
            }
        } : rulerScope;
    }

    @Override // androidx.compose.ui.layout.Measured
    public final int get(AlignmentLine alignmentLine) {
        int iCalculateAlignmentLine;
        return (getHasMeasureResult() && (iCalculateAlignmentLine = calculateAlignmentLine(alignmentLine)) != Integer.MIN_VALUE) ? iCalculateAlignmentLine + IntOffset.m2592getYimpl(m1859getApparentToRealOffsetnOccac()) : LinearLayoutManager.INVALID_OFFSET;
    }

    public final boolean isShallowPlacing$ui_release() {
        return this.isShallowPlacing;
    }

    public final void setShallowPlacing$ui_release(boolean z) {
        this.isShallowPlacing = z;
    }

    public final boolean isPlacingForAlignment$ui_release() {
        return this.isPlacingForAlignment;
    }

    public final void setPlacingForAlignment$ui_release(boolean z) {
        this.isPlacingForAlignment = z;
    }

    public final Placeable.PlacementScope getPlacementScope() {
        return this.placementScope;
    }

    protected final void invalidateAlignmentLinesFromPositionChange(NodeCoordinator nodeCoordinator) {
        AlignmentLines alignmentLines;
        NodeCoordinator wrapped$ui_release = nodeCoordinator.getWrapped$ui_release();
        if (!Intrinsics.areEqual(wrapped$ui_release != null ? wrapped$ui_release.getLayoutNode() : null, nodeCoordinator.getLayoutNode())) {
            nodeCoordinator.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = nodeCoordinator.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null || (alignmentLines = parentAlignmentLinesOwner.getAlignmentLines()) == null) {
            return;
        }
        alignmentLines.onAlignmentsChanged();
    }

    private final LookaheadCapablePlaceable findAncestorRulerDefiner(Ruler ruler) {
        LookaheadCapablePlaceable parent;
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            MutableObjectFloatMap mutableObjectFloatMap = lookaheadCapablePlaceable.rulerValues;
            if ((mutableObjectFloatMap != null && mutableObjectFloatMap.contains(ruler)) || (parent = lookaheadCapablePlaceable.getParent()) == null) {
                return lookaheadCapablePlaceable;
            }
            lookaheadCapablePlaceable = parent;
        }
    }

    private final void invalidateChildrenOfDefiningRuler(Ruler ruler) {
        MutableScatterMap mutableScatterMap = findAncestorRulerDefiner(ruler).rulerReaders;
        MutableScatterSet mutableScatterSet = mutableScatterMap != null ? (MutableScatterSet) mutableScatterMap.remove(ruler) : null;
        if (mutableScatterSet != null) {
            notifyRulerValueChange(mutableScatterSet);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0051 A[LOOP:0: B:10:0x001a->B:20:0x0051, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x0054 A[EDGE_INSN: B:29:0x0054->B:21:0x0054 BREAK  A[LOOP:0: B:10:0x001a->B:20:0x0051], SYNTHETIC] */
    public final void captureRulers$ui_release(MeasureResult measureResult) {
        if (measureResult != null) {
            captureRulers(new PlaceableResult(measureResult, this));
            return;
        }
        MutableScatterMap mutableScatterMap = this.rulerReaders;
        if (mutableScatterMap != null) {
            Object[] objArr = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                notifyRulerValueChange((MutableScatterSet) objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        MutableScatterMap mutableScatterMap2 = this.rulerReaders;
        if (mutableScatterMap2 != null) {
            mutableScatterMap2.clear();
        }
        MutableObjectFloatMap mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap != null) {
            mutableObjectFloatMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:58:0x0109 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x010b A[LOOP:2: B:43:0x00c1->B:59:0x010b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:60:0x0111  */
    /* JADX WARN: Code duplicated, block: B:90:0x0113 A[EDGE_INSN: B:90:0x0113->B:61:0x0113 BREAK  A[LOOP:2: B:43:0x00c1->B:59:0x010b], SYNTHETIC] */
    public final void captureRulers(final PlaceableResult placeableResult) {
        long j;
        LookaheadCapablePlaceable parent;
        MutableScatterSet mutableScatterSet;
        OwnerSnapshotObserver snapshotObserver;
        char c;
        if (this.isPlacingForAlignment) {
            return;
        }
        Function1 rulers = placeableResult.getResult().getRulers();
        MutableScatterMap mutableScatterMap = this.rulerReaders;
        char c2 = 7;
        int i = 0;
        int i2 = 8;
        if (rulers == null) {
            if (mutableScatterMap != null) {
                Object[] objArr = mutableScatterMap.values;
                long[] jArr = mutableScatterMap.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i3 = 0;
                    while (true) {
                        long j2 = jArr[i3];
                        if ((((~j2) << c2) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i4 = 8 - ((~(i3 - length)) >>> 31);
                            int i5 = 0;
                            while (i5 < i4) {
                                if ((j2 & 255) < 128) {
                                    notifyRulerValueChange((MutableScatterSet) objArr[(i3 << 3) + i5]);
                                }
                                j2 >>= 8;
                                i5++;
                                c2 = c2;
                            }
                            c = c2;
                            if (i4 != 8) {
                                break;
                            }
                        } else {
                            c = c2;
                        }
                        if (i3 == length) {
                            break;
                        }
                        i3++;
                        c2 = c;
                    }
                }
                mutableScatterMap.clear();
                return;
            }
            return;
        }
        MutableObjectFloatMap mutableObjectFloatMap = this.rulerValuesCache;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i6 = 1;
        if (mutableObjectFloatMap == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap(i, i6, defaultConstructorMarker);
            this.rulerValuesCache = mutableObjectFloatMap;
        }
        MutableObjectFloatMap mutableObjectFloatMap2 = this.rulerValues;
        if (mutableObjectFloatMap2 == null) {
            mutableObjectFloatMap2 = new MutableObjectFloatMap(i, i6, defaultConstructorMarker);
            this.rulerValues = mutableObjectFloatMap2;
        }
        mutableObjectFloatMap.putAll(mutableObjectFloatMap2);
        mutableObjectFloatMap2.clear();
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null && (snapshotObserver = owner$ui_release.getSnapshotObserver()) != null) {
            snapshotObserver.observeReads$ui_release(placeableResult, onCommitAffectingRuler, new Function0() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable.captureRulers.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1938invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1938invoke() {
                    Function1 rulers2 = placeableResult.getResult().getRulers();
                    if (rulers2 != null) {
                        rulers2.invoke(this.getRulerScope());
                    }
                }
            });
        }
        if (mutableScatterMap != null) {
            Object[] objArr2 = mutableObjectFloatMap.keys;
            float[] fArr = mutableObjectFloatMap.values;
            long[] jArr2 = mutableObjectFloatMap.metadata;
            int length2 = jArr2.length - 2;
            if (length2 >= 0) {
                j = -9187201950435737472L;
                int i7 = 0;
                while (true) {
                    long j3 = jArr2[i7];
                    int i8 = i2;
                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i9 = 8 - ((~(i7 - length2)) >>> 31);
                        for (int i10 = 0; i10 < i9; i10++) {
                            if ((j3 & 255) < 128) {
                                int i11 = (i7 << 3) + i10;
                                Object obj = objArr2[i11];
                                float f = fArr[i11];
                                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
                                if (mutableObjectFloatMap2.getOrDefault(null, Float.NaN) != f && (mutableScatterSet = (MutableScatterSet) mutableScatterMap.remove(null)) != null) {
                                    notifyRulerValueChange(mutableScatterSet);
                                }
                            }
                            j3 >>= i8;
                        }
                        if (i9 != i8) {
                            break;
                        }
                        if (i7 != length2) {
                            break;
                        }
                        i7++;
                        i2 = 8;
                    } else if (i7 != length2) {
                        break;
                        break;
                    } else {
                        i7++;
                        i2 = 8;
                    }
                }
            } else {
                j = -9187201950435737472L;
            }
        } else {
            j = -9187201950435737472L;
        }
        Object[] objArr3 = mutableObjectFloatMap2.keys;
        long[] jArr3 = mutableObjectFloatMap2.metadata;
        int length3 = jArr3.length - 2;
        if (length3 >= 0) {
            int i12 = 0;
            while (true) {
                long j4 = jArr3[i12];
                if ((((~j4) << 7) & j4 & j) != j) {
                    int i13 = 8 - ((~(i12 - length3)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((j4 & 255) < 128) {
                            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(objArr3[(i12 << 3) + i14]);
                            if (!mutableObjectFloatMap.contains(null) && (parent = getParent()) != null) {
                                parent.invalidateChildrenOfDefiningRuler(null);
                            }
                        }
                        j4 >>= 8;
                    }
                    if (i13 != 8) {
                        break;
                    }
                }
                if (i12 == length3) {
                    break;
                } else {
                    i12++;
                }
            }
        }
        mutableObjectFloatMap.clear();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(final int i, final int i2, final Map map, final Function1 function1, final Function1 function2) {
        if (!((i & (-16777216)) == 0 && ((-16777216) & i2) == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable.layout.1
            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return i;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return i2;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map getAlignmentLines() {
                return map;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1 getRulers() {
                return function1;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
                function2.invoke(this.getPlacementScope());
            }
        };
    }

    private final void notifyRulerValueChange(MutableScatterSet mutableScatterSet) {
        LayoutNode layoutNode;
        Object[] objArr = mutableScatterSet.elements;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128 && (layoutNode = (LayoutNode) ((WeakReference) objArr[(i << 3) + i3]).get()) != null) {
                        if (isLookingAhead()) {
                            layoutNode.requestLookaheadRelayout$ui_release(false);
                        } else {
                            layoutNode.requestRelayout$ui_release(false);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }
}
