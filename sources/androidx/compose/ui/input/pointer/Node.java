package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;
    private final Modifier.Node modifierNode;
    private PointerEvent pointerEvent;
    private boolean wasIn;
    private final PointerIdArray pointerIds = new PointerIdArray();
    private final LongSparseArray relevantChanges = new LongSparseArray(2);
    private boolean isIn = true;
    private boolean hasExited = true;

    public Node(Modifier.Node node) {
        this.modifierNode = node;
    }

    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void removeInvalidPointerIdsAndChanges(long j, MutableObjectList mutableObjectList) {
        if (this.pointerIds.contains(j) && !mutableObjectList.contains(this)) {
            this.pointerIds.remove(j);
            this.relevantChanges.remove(j);
        }
        MutableVector children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Object[] content = children.getContent();
            int i = 0;
            do {
                ((Node) content[i]).removeInvalidPointerIdsAndChanges(j, mutableObjectList);
                i++;
            } while (i < size);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0255  */
    /* JADX WARN: Code duplicated, block: B:104:0x0263  */
    /* JADX WARN: Code duplicated, block: B:95:0x0235  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean buildCache(LongSparseArray longSparseArray, LayoutCoordinates layoutCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        Object obj;
        boolean z2;
        int iM1751getType7fucELk;
        PointerEventType.Companion companion;
        int iM1758getExit7fucELk;
        boolean z3;
        int i;
        boolean zBuildCache = super.buildCache(longSparseArray, layoutCoordinates, internalPointerEvent, z);
        boolean z4 = true;
        if (!this.modifierNode.isAttached()) {
            return true;
        }
        ?? Pop = this.modifierNode;
        int iM1990constructorimpl = NodeKind.m1990constructorimpl(16);
        ?? mutableVector = 0;
        while (Pop != 0) {
            if (!(Pop instanceof PointerInputModifierNode)) {
                if ((Pop.getKindSet$ui_release() & iM1990constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                    Modifier.Node delegate$ui_release = ((DelegatingNode) Pop).getDelegate$ui_release();
                    int i2 = 0;
                    while (delegate$ui_release != null) {
                        if ((delegate$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                            i2++;
                            if (i2 == 1) {
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
                    if (i2 == 1) {
                        Pop = Pop;
                        mutableVector = mutableVector;
                    } else {
                        Pop = Pop;
                        mutableVector = mutableVector;
                    }
                }
            } else {
                this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode) Pop);
            }
            Pop = DelegatableNodeKt.pop(mutableVector);
        }
        int i3 = 0;
        for (int size = longSparseArray.size(); i3 < size; size = size) {
            long jKeyAt = longSparseArray.keyAt(i3);
            PointerInputChange pointerInputChange = (PointerInputChange) longSparseArray.valueAt(i3);
            if (this.pointerIds.contains(jKeyAt)) {
                boolean z5 = z4;
                int i4 = i3;
                long jM1779getPreviousPositionF1C5BW0 = pointerInputChange.m1779getPreviousPositionF1C5BW0();
                z3 = z5;
                long jM1778getPositionF1C5BW0 = pointerInputChange.m1778getPositionF1C5BW0();
                if (Offset.m1226isValidimpl(jM1779getPreviousPositionF1C5BW0) && Offset.m1226isValidimpl(jM1778getPositionF1C5BW0)) {
                    ArrayList arrayList = new ArrayList(pointerInputChange.getHistorical().size());
                    List historical = pointerInputChange.getHistorical();
                    int size2 = historical.size();
                    int i5 = 0;
                    while (i5 < size2) {
                        HistoricalChange historicalChange = (HistoricalChange) historical.get(i5);
                        int i6 = size2;
                        int i7 = i5;
                        long jM1743getPositionF1C5BW0 = historicalChange.m1743getPositionF1C5BW0();
                        if (Offset.m1226isValidimpl(jM1743getPositionF1C5BW0)) {
                            long uptimeMillis = historicalChange.getUptimeMillis();
                            LayoutCoordinates layoutCoordinates2 = this.coordinates;
                            Intrinsics.checkNotNull(layoutCoordinates2);
                            arrayList.add(new HistoricalChange(uptimeMillis, layoutCoordinates2.mo1846localPositionOfR5De75A(layoutCoordinates, jM1743getPositionF1C5BW0), historicalChange.m1742getOriginalEventPositionF1C5BW0$ui_release(), null));
                        }
                        i5 = i7 + 1;
                        size2 = i6;
                        i4 = i4;
                    }
                    i = i4;
                    LongSparseArray longSparseArray2 = this.relevantChanges;
                    LayoutCoordinates layoutCoordinates3 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates3);
                    long jMo1846localPositionOfR5De75A = layoutCoordinates3.mo1846localPositionOfR5De75A(layoutCoordinates, jM1779getPreviousPositionF1C5BW0);
                    LayoutCoordinates layoutCoordinates4 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates4);
                    longSparseArray2.put(jKeyAt, PointerInputChange.m1773copyOHpmEuE$default(pointerInputChange, 0L, 0L, layoutCoordinates4.mo1846localPositionOfR5De75A(layoutCoordinates, jM1778getPositionF1C5BW0), false, 0L, jMo1846localPositionOfR5De75A, false, 0, arrayList, 0L, 731, null));
                } else {
                    i = i4;
                }
            } else {
                z3 = z4;
                i = i3;
            }
            i3 = i + 1;
            z4 = z3;
            zBuildCache = zBuildCache;
        }
        boolean z6 = zBuildCache;
        boolean z7 = z4;
        if (!this.relevantChanges.isEmpty()) {
            int size3 = this.pointerIds.getSize();
            while (true) {
                size3--;
                if (-1 >= size3) {
                    break;
                }
                if (!longSparseArray.containsKey(this.pointerIds.m1818get_I2yYro(size3))) {
                    this.pointerIds.removeAt(size3);
                }
            }
            ArrayList arrayList2 = new ArrayList(this.relevantChanges.size());
            int size4 = this.relevantChanges.size();
            for (int i8 = 0; i8 < size4; i8++) {
                arrayList2.add(this.relevantChanges.valueAt(i8));
            }
            PointerEvent pointerEvent = new PointerEvent(arrayList2, internalPointerEvent);
            List changes = pointerEvent.getChanges();
            int size5 = changes.size();
            int i9 = 0;
            while (true) {
                if (i9 >= size5) {
                    obj = null;
                    break;
                }
                Object obj2 = changes.get(i9);
                if (internalPointerEvent.m1745activeHoverEvent0FcD4WY(((PointerInputChange) obj2).m1776getIdJ3iCeTQ())) {
                    obj = obj2;
                    break;
                }
                i9++;
            }
            PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
            if (pointerInputChange2 != null) {
                if (!z) {
                    z2 = false;
                    this.isIn = false;
                } else {
                    z2 = false;
                    if (!this.isIn && (pointerInputChange2.getPressed() || pointerInputChange2.getPreviousPressed())) {
                        LayoutCoordinates layoutCoordinates5 = this.coordinates;
                        Intrinsics.checkNotNull(layoutCoordinates5);
                        this.isIn = !PointerEventKt.m1753isOutOfBoundsO0kMr_c(pointerInputChange2, layoutCoordinates5.mo1845getSizeYbymL2g());
                    }
                }
                if (this.isIn != this.wasIn) {
                    int iM1751getType7fucELk2 = pointerEvent.m1751getType7fucELk();
                    PointerEventType.Companion companion2 = PointerEventType.Companion;
                    if (PointerEventType.m1756equalsimpl0(iM1751getType7fucELk2, companion2.m1759getMove7fucELk()) || PointerEventType.m1756equalsimpl0(pointerEvent.m1751getType7fucELk(), companion2.m1757getEnter7fucELk()) || PointerEventType.m1756equalsimpl0(pointerEvent.m1751getType7fucELk(), companion2.m1758getExit7fucELk())) {
                        if (this.isIn) {
                            iM1758getExit7fucELk = companion2.m1757getEnter7fucELk();
                        } else {
                            iM1758getExit7fucELk = companion2.m1758getExit7fucELk();
                        }
                        pointerEvent.m1752setTypeEhbLWgg$ui_release(iM1758getExit7fucELk);
                    } else {
                        iM1751getType7fucELk = pointerEvent.m1751getType7fucELk();
                        companion = PointerEventType.Companion;
                        if (!PointerEventType.m1756equalsimpl0(iM1751getType7fucELk, companion.m1757getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                            pointerEvent.m1752setTypeEhbLWgg$ui_release(companion.m1759getMove7fucELk());
                        } else if (PointerEventType.m1756equalsimpl0(pointerEvent.m1751getType7fucELk(), companion.m1758getExit7fucELk()) && this.isIn && pointerInputChange2.getPressed()) {
                            pointerEvent.m1752setTypeEhbLWgg$ui_release(companion.m1759getMove7fucELk());
                        }
                    }
                } else {
                    iM1751getType7fucELk = pointerEvent.m1751getType7fucELk();
                    companion = PointerEventType.Companion;
                    if (!PointerEventType.m1756equalsimpl0(iM1751getType7fucELk, companion.m1757getEnter7fucELk())) {
                        if (PointerEventType.m1756equalsimpl0(pointerEvent.m1751getType7fucELk(), companion.m1758getExit7fucELk())) {
                            pointerEvent.m1752setTypeEhbLWgg$ui_release(companion.m1759getMove7fucELk());
                        }
                    } else if (PointerEventType.m1756equalsimpl0(pointerEvent.m1751getType7fucELk(), companion.m1758getExit7fucELk())) {
                        pointerEvent.m1752setTypeEhbLWgg$ui_release(companion.m1759getMove7fucELk());
                    }
                }
            } else {
                z2 = false;
            }
            boolean z8 = (z6 || !PointerEventType.m1756equalsimpl0(pointerEvent.m1751getType7fucELk(), PointerEventType.Companion.m1759getMove7fucELk()) || hasPositionChanged(this.pointerEvent, pointerEvent)) ? z7 : z2;
            this.pointerEvent = pointerEvent;
            return z8;
        }
        this.pointerIds.clear();
        getChildren().clear();
        return z7;
    }

    private final boolean hasPositionChanged(PointerEvent pointerEvent, PointerEvent pointerEvent2) {
        if (pointerEvent == null || pointerEvent.getChanges().size() != pointerEvent2.getChanges().size()) {
            return true;
        }
        int size = pointerEvent2.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m1220equalsimpl0(((PointerInputChange) pointerEvent.getChanges().get(i)).m1778getPositionF1C5BW0(), ((PointerInputChange) pointerEvent2.getChanges().get(i)).m1778getPositionF1C5BW0())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.compose.ui.Modifier$Node] */
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
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector children;
        int size;
        boolean z = false;
        int i = 0;
        z = false;
        if (!this.relevantChanges.isEmpty() && this.modifierNode.isAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long jMo1845getSizeYbymL2g = layoutCoordinates.mo1845getSizeYbymL2g();
            ?? Pop = this.modifierNode;
            int iM1990constructorimpl = NodeKind.m1990constructorimpl(16);
            ?? mutableVector = 0;
            while (Pop != 0) {
                if (!(Pop instanceof PointerInputModifierNode)) {
                    if ((Pop.getKindSet$ui_release() & iM1990constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                        Modifier.Node delegate$ui_release = ((DelegatingNode) Pop).getDelegate$ui_release();
                        int i2 = 0;
                        while (delegate$ui_release != null) {
                            if ((delegate$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                                i2++;
                                if (i2 == 1) {
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
                        if (i2 == 1) {
                            Pop = Pop;
                            mutableVector = mutableVector;
                        } else {
                            Pop = Pop;
                            mutableVector = mutableVector;
                        }
                    }
                } else {
                    ((PointerInputModifierNode) Pop).mo103onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, jMo1845getSizeYbymL2g);
                }
                Pop = DelegatableNodeKt.pop(mutableVector);
            }
            if (this.modifierNode.isAttached() && (size = (children = getChildren()).getSize()) > 0) {
                Object[] content = children.getContent();
                do {
                    ((Node) content[i]).dispatchFinalEventPass(internalPointerEvent);
                    i++;
                } while (i < size);
            }
            z = true;
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(LongSparseArray longSparseArray, LayoutCoordinates layoutCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        MutableVector children;
        int size;
        if (this.relevantChanges.isEmpty() || !this.modifierNode.isAttached()) {
            return false;
        }
        PointerEvent pointerEvent = this.pointerEvent;
        Intrinsics.checkNotNull(pointerEvent);
        LayoutCoordinates layoutCoordinates2 = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates2);
        long jMo1845getSizeYbymL2g = layoutCoordinates2.mo1845getSizeYbymL2g();
        ?? Pop = this.modifierNode;
        int iM1990constructorimpl = NodeKind.m1990constructorimpl(16);
        ?? mutableVector = 0;
        while (Pop != 0) {
            if (Pop instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) Pop).mo103onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, jMo1845getSizeYbymL2g);
            } else if ((Pop.getKindSet$ui_release() & iM1990constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
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
            Pop = DelegatableNodeKt.pop(mutableVector);
        }
        if (this.modifierNode.isAttached() && (size = (children = getChildren()).getSize()) > 0) {
            Object[] content = children.getContent();
            int i2 = 0;
            do {
                Node node = (Node) content[i2];
                LongSparseArray longSparseArray2 = this.relevantChanges;
                LayoutCoordinates layoutCoordinates3 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates3);
                node.dispatchMainEventPass(longSparseArray2, layoutCoordinates3, internalPointerEvent, z);
                i2++;
            } while (i2 < size);
        }
        if (this.modifierNode.isAttached()) {
            ?? Pop2 = this.modifierNode;
            int iM1990constructorimpl2 = NodeKind.m1990constructorimpl(16);
            ?? mutableVector2 = 0;
            while (Pop2 != 0) {
                if (Pop2 instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) Pop2).mo103onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, jMo1845getSizeYbymL2g);
                } else if ((Pop2.getKindSet$ui_release() & iM1990constructorimpl2) != 0 && (Pop2 instanceof DelegatingNode)) {
                    Modifier.Node delegate$ui_release2 = ((DelegatingNode) Pop2).getDelegate$ui_release();
                    int i3 = 0;
                    while (delegate$ui_release2 != null) {
                        if ((delegate$ui_release2.getKindSet$ui_release() & iM1990constructorimpl2) != 0) {
                            i3++;
                            if (i3 == 1) {
                                mutableVector2 = mutableVector2;
                                Pop2 = Pop2;
                                mutableVector2 = mutableVector2;
                                Pop2 = delegate$ui_release2;
                            } else {
                                if (mutableVector2 == 0) {
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (Pop2 != 0) {
                                    mutableVector2.add(Pop2);
                                    Pop2 = 0;
                                }
                                mutableVector2.add(delegate$ui_release2);
                            }
                        } else {
                            mutableVector2 = mutableVector2;
                            Pop2 = Pop2;
                        }
                        delegate$ui_release2 = delegate$ui_release2.getChild$ui_release();
                        mutableVector2 = mutableVector2;
                        Pop2 = Pop2;
                    }
                    if (i3 == 1) {
                        mutableVector2 = mutableVector2;
                        Pop2 = Pop2;
                    } else {
                        mutableVector2 = mutableVector2;
                        Pop2 = Pop2;
                    }
                }
                Pop2 = DelegatableNodeKt.pop(mutableVector2);
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
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
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Object[] content = children.getContent();
            int i = 0;
            do {
                ((Node) content[i]).dispatchCancel();
                i++;
            } while (i < size);
        }
        ?? Pop = this.modifierNode;
        int iM1990constructorimpl = NodeKind.m1990constructorimpl(16);
        ?? mutableVector = 0;
        while (Pop != 0) {
            if (!(Pop instanceof PointerInputModifierNode)) {
                if ((Pop.getKindSet$ui_release() & iM1990constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                    Modifier.Node delegate$ui_release = ((DelegatingNode) Pop).getDelegate$ui_release();
                    int i2 = 0;
                    while (delegate$ui_release != null) {
                        if ((delegate$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                            i2++;
                            if (i2 == 1) {
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
                    if (i2 == 1) {
                        Pop = Pop;
                        mutableVector = mutableVector;
                    } else {
                        Pop = Pop;
                        mutableVector = mutableVector;
                    }
                }
            } else {
                ((PointerInputModifierNode) Pop).onCancelPointerInput();
            }
            Pop = DelegatableNodeKt.pop(mutableVector);
        }
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = (PointerInputChange) changes.get(i);
            boolean pressed = pointerInputChange.getPressed();
            boolean zM1745activeHoverEvent0FcD4WY = internalPointerEvent.m1745activeHoverEvent0FcD4WY(pointerInputChange.m1776getIdJ3iCeTQ());
            boolean z = this.isIn;
            if ((!pressed && !zM1745activeHoverEvent0FcD4WY) || (!pressed && !z)) {
                this.pointerIds.m1819remove0FcD4WY(pointerInputChange.m1776getIdJ3iCeTQ());
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m1756equalsimpl0(pointerEvent.m1751getType7fucELk(), PointerEventType.Companion.m1758getExit7fucELk());
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }
}
