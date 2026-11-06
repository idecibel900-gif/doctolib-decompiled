package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;

/* JADX INFO: loaded from: classes.dex */
public final class PointerInputEventProcessor {
    private final HitPathTracker hitPathTracker;
    private boolean isProcessing;
    private final LayoutNode root;
    private final PointerInputChangeEventProducer pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
    private final HitTestResult hitResult = new HitTestResult();

    public PointerInputEventProcessor(LayoutNode layoutNode) {
        this.root = layoutNode;
        this.hitPathTracker = new HitPathTracker(layoutNode.getCoordinates());
    }

    /* JADX INFO: renamed from: process-BIzXfog, reason: not valid java name */
    public final int m1789processBIzXfog(PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator, boolean z) {
        int i;
        boolean z2;
        if (this.isProcessing) {
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        boolean z3 = true;
        try {
            this.isProcessing = true;
            InternalPointerEvent internalPointerEventProduce = this.pointerInputChangeEventProducer.produce(pointerInputEvent, positionCalculator);
            int size = internalPointerEventProduce.getChanges().size();
            while (true) {
                if (i >= size) {
                    z2 = true;
                    break;
                }
                PointerInputChange pointerInputChange = (PointerInputChange) internalPointerEventProduce.getChanges().valueAt(i);
                i = (pointerInputChange.getPressed() || pointerInputChange.getPreviousPressed()) ? 0 : i + 1;
                z2 = false;
                break;
            }
            int size2 = internalPointerEventProduce.getChanges().size();
            for (int i2 = 0; i2 < size2; i2++) {
                PointerInputChange pointerInputChange2 = (PointerInputChange) internalPointerEventProduce.getChanges().valueAt(i2);
                if (z2 || PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange2)) {
                    LayoutNode.m1900hitTestM_7yMNQ$ui_release$default(this.root, pointerInputChange2.m1778getPositionF1C5BW0(), this.hitResult, PointerType.m1801equalsimpl0(pointerInputChange2.m1781getTypeT8wyACA(), PointerType.Companion.m1807getTouchT8wyACA()), false, 8, null);
                    if (!this.hitResult.isEmpty()) {
                        this.hitPathTracker.m1744addHitPathQJqDSyo(pointerInputChange2.m1776getIdJ3iCeTQ(), this.hitResult, PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange2));
                        this.hitResult.clear();
                    }
                }
            }
            this.hitPathTracker.removeDetachedPointerInputNodes();
            boolean zDispatchChanges = this.hitPathTracker.dispatchChanges(internalPointerEventProduce, z);
            if (internalPointerEventProduce.getSuppressMovementConsumption()) {
                z3 = false;
                break;
            }
            int size3 = internalPointerEventProduce.getChanges().size();
            int i3 = 0;
            while (true) {
                if (i3 >= size3) {
                    z3 = false;
                    break;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) internalPointerEventProduce.getChanges().valueAt(i3);
                if (PointerEventKt.positionChangedIgnoreConsumed(pointerInputChange3) && pointerInputChange3.isConsumed()) {
                    break;
                }
                i3++;
            }
            return PointerInputEventProcessorKt.ProcessResult(zDispatchChanges, z3);
        } finally {
            this.isProcessing = false;
        }
    }

    public final void processCancel() {
        if (this.isProcessing) {
            return;
        }
        this.pointerInputChangeEventProducer.clear();
        this.hitPathTracker.processCancel();
    }

    public final void clearPreviouslyHitModifierNodes() {
        this.hitPathTracker.clearPreviouslyHitModifierNodeCache();
    }
}
