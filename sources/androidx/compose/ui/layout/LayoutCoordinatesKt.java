package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;

/* JADX INFO: loaded from: classes.dex */
public abstract class LayoutCoordinatesKt {
    public static final long positionInRoot(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo1848localToRootMKHz9U(Offset.Companion.m1235getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo1849localToWindowMKHz9U(Offset.Companion.m1235getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates) {
        return LayoutCoordinates.localBoundingBoxOf$default(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = findRootCoordinates(layoutCoordinates);
        float fM2609getWidthimpl = IntSize.m2609getWidthimpl(layoutCoordinatesFindRootCoordinates.mo1845getSizeYbymL2g());
        float fM2608getHeightimpl = IntSize.m2608getHeightimpl(layoutCoordinatesFindRootCoordinates.mo1845getSizeYbymL2g());
        Rect rectBoundsInRoot = boundsInRoot(layoutCoordinates);
        float left = rectBoundsInRoot.getLeft();
        if (left < 0.0f) {
            left = 0.0f;
        }
        if (left > fM2609getWidthimpl) {
            left = fM2609getWidthimpl;
        }
        float top = rectBoundsInRoot.getTop();
        if (top < 0.0f) {
            top = 0.0f;
        }
        if (top > fM2608getHeightimpl) {
            top = fM2608getHeightimpl;
        }
        float right = rectBoundsInRoot.getRight();
        if (right < 0.0f) {
            right = 0.0f;
        }
        if (right <= fM2609getWidthimpl) {
            fM2609getWidthimpl = right;
        }
        float bottom = rectBoundsInRoot.getBottom();
        float f = bottom >= 0.0f ? bottom : 0.0f;
        if (f <= fM2608getHeightimpl) {
            fM2608getHeightimpl = f;
        }
        if (left == fM2609getWidthimpl || top == fM2608getHeightimpl) {
            return Rect.Companion.getZero();
        }
        long jMo1849localToWindowMKHz9U = layoutCoordinatesFindRootCoordinates.mo1849localToWindowMKHz9U(OffsetKt.Offset(left, top));
        long jMo1849localToWindowMKHz9U2 = layoutCoordinatesFindRootCoordinates.mo1849localToWindowMKHz9U(OffsetKt.Offset(fM2609getWidthimpl, top));
        long jMo1849localToWindowMKHz9U3 = layoutCoordinatesFindRootCoordinates.mo1849localToWindowMKHz9U(OffsetKt.Offset(fM2609getWidthimpl, fM2608getHeightimpl));
        long jMo1849localToWindowMKHz9U4 = layoutCoordinatesFindRootCoordinates.mo1849localToWindowMKHz9U(OffsetKt.Offset(left, fM2608getHeightimpl));
        float fM1223getXimpl = Offset.m1223getXimpl(jMo1849localToWindowMKHz9U);
        float fM1223getXimpl2 = Offset.m1223getXimpl(jMo1849localToWindowMKHz9U2);
        float fM1223getXimpl3 = Offset.m1223getXimpl(jMo1849localToWindowMKHz9U4);
        float fM1223getXimpl4 = Offset.m1223getXimpl(jMo1849localToWindowMKHz9U3);
        float fMin = Math.min(fM1223getXimpl, Math.min(fM1223getXimpl2, Math.min(fM1223getXimpl3, fM1223getXimpl4)));
        float fMax = Math.max(fM1223getXimpl, Math.max(fM1223getXimpl2, Math.max(fM1223getXimpl3, fM1223getXimpl4)));
        float fM1224getYimpl = Offset.m1224getYimpl(jMo1849localToWindowMKHz9U);
        float fM1224getYimpl2 = Offset.m1224getYimpl(jMo1849localToWindowMKHz9U2);
        float fM1224getYimpl3 = Offset.m1224getYimpl(jMo1849localToWindowMKHz9U4);
        float fM1224getYimpl4 = Offset.m1224getYimpl(jMo1849localToWindowMKHz9U3);
        return new Rect(fMin, Math.min(fM1224getYimpl, Math.min(fM1224getYimpl2, Math.min(fM1224getYimpl3, fM1224getYimpl4))), fMax, Math.max(fM1224getYimpl, Math.max(fM1224getYimpl2, Math.max(fM1224getYimpl3, fM1224getYimpl4))));
    }

    public static final Rect boundsInParent(LayoutCoordinates layoutCoordinates) {
        Rect rectLocalBoundingBoxOf$default;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (rectLocalBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(parentLayoutCoordinates, layoutCoordinates, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m2609getWidthimpl(layoutCoordinates.mo1845getSizeYbymL2g()), IntSize.m2608getHeightimpl(layoutCoordinates.mo1845getSizeYbymL2g())) : rectLocalBoundingBoxOf$default;
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy$ui_release;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        }
    }
}
