package androidx.compose.ui.input.pointer;

import androidx.compose.ui.layout.LayoutCoordinates;

/* JADX INFO: loaded from: classes.dex */
public abstract class PointerInputFilter {
    private LayoutCoordinates layoutCoordinates;

    public boolean getInterceptOutOfBoundsChildEvents() {
        return false;
    }

    public abstract boolean getShareWithSiblings();

    public abstract void onCancel();

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public abstract void mo1790onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j);

    public final LayoutCoordinates getLayoutCoordinates$ui_release() {
        return this.layoutCoordinates;
    }

    public final void setLayoutCoordinates$ui_release(LayoutCoordinates layoutCoordinates) {
        this.layoutCoordinates = layoutCoordinates;
    }
}
