package androidx.compose.ui.layout;

import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: loaded from: classes.dex */
public interface LayoutInfo {
    LayoutCoordinates getCoordinates();

    LayoutDirection getLayoutDirection();

    boolean isPlaced();
}
