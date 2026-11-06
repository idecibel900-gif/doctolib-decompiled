package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.uimanager.common.ViewUtil;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TouchTargetHelper {
    public static final TouchTargetHelper INSTANCE = new TouchTargetHelper();
    private static final float[] eventCoords = new float[2];
    private static final PointF tempPoint = new PointF();
    private static final float[] matrixTransformCoords = new float[2];
    private static final Matrix inverseMatrix = new Matrix();

    private enum TouchTargetReturnType {
        SELF,
        CHILD;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEvents.values().length];
            try {
                iArr[PointerEvents.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerEvents.BOX_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerEvents.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PointerEvents.BOX_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TouchTargetHelper() {
    }

    public static final int findTargetTagForTouch(float f, float f2, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return findTargetTagAndCoordinatesForTouch(f, f2, viewGroup, eventCoords, null);
    }

    public static final int findTargetTagAndCoordinatesForTouch(float f, float f2, ViewGroup viewGroup, float[] viewCoords, int[] iArr) {
        View viewFindClosestReactAncestor;
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(viewCoords, "viewCoords");
        UiThreadUtil.assertOnUiThread();
        int id = viewGroup.getId();
        viewCoords[0] = f;
        viewCoords[1] = f2;
        TouchTargetHelper touchTargetHelper = INSTANCE;
        View viewFindTouchTargetViewWithPointerEvents = touchTargetHelper.findTouchTargetViewWithPointerEvents(viewCoords, viewGroup, null);
        if (viewFindTouchTargetViewWithPointerEvents == null || (viewFindClosestReactAncestor = touchTargetHelper.findClosestReactAncestor(viewFindTouchTargetViewWithPointerEvents)) == null) {
            return id;
        }
        if (iArr != null) {
            iArr[0] = viewFindClosestReactAncestor.getId();
        }
        return touchTargetHelper.getTouchTargetForView(viewFindClosestReactAncestor, viewCoords[0], viewCoords[1]);
    }

    public static final List findTargetPathAndCoordinatesForTouch(float f, float f2, ViewGroup viewGroup, float[] viewCoords) {
        int touchTargetForView;
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(viewCoords, "viewCoords");
        UiThreadUtil.assertOnUiThread();
        viewCoords[0] = f;
        viewCoords[1] = f2;
        ArrayList arrayList = new ArrayList();
        View viewFindTouchTargetViewWithPointerEvents = INSTANCE.findTouchTargetViewWithPointerEvents(viewCoords, viewGroup, arrayList);
        if (viewFindTouchTargetViewWithPointerEvents != null) {
            int i = 0;
            while (viewFindTouchTargetViewWithPointerEvents != null && viewFindTouchTargetViewWithPointerEvents.getId() <= 0) {
                Object parent = viewFindTouchTargetViewWithPointerEvents.getParent();
                viewFindTouchTargetViewWithPointerEvents = parent instanceof View ? (View) parent : null;
                i++;
            }
            if (i > 0 && i <= arrayList.size()) {
                arrayList.subList(i, arrayList.size());
            }
            if (viewFindTouchTargetViewWithPointerEvents != null && (touchTargetForView = INSTANCE.getTouchTargetForView(viewFindTouchTargetViewWithPointerEvents, viewCoords[0], viewCoords[1])) != viewFindTouchTargetViewWithPointerEvents.getId()) {
                arrayList.add(0, new ViewTarget(touchTargetForView, null));
            }
        }
        return arrayList;
    }

    private final View findClosestReactAncestor(View view) {
        while (view != null && view.getId() <= 0) {
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View findTouchTargetView(float[] fArr, View view, EnumSet enumSet, List list) {
        if (enumSet.contains(TouchTargetReturnType.CHILD) && (view instanceof ViewGroup)) {
            if (!isTouchPointInView(fArr[0], fArr[1], view)) {
                if (view instanceof ReactOverflowViewWithInset) {
                    if (ViewUtil.getUIManagerType(view.getId()) == 2 && !isTouchPointInViewWithOverflowInset(fArr[0], fArr[1], view)) {
                        return null;
                    }
                    String overflow = ((ReactOverflowView) view).getOverflow();
                    if (Intrinsics.areEqual("hidden", overflow) || Intrinsics.areEqual("scroll", overflow)) {
                        return null;
                    }
                }
                if (((ViewGroup) view).getClipChildren()) {
                    return null;
                }
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            ReactZIndexedViewGroup reactZIndexedViewGroup = view instanceof ReactZIndexedViewGroup ? (ReactZIndexedViewGroup) view : null;
            for (int i = childCount - 1; -1 < i; i--) {
                View childAt = viewGroup.getChildAt(reactZIndexedViewGroup != null ? reactZIndexedViewGroup.getZIndexMappedChildIndex(i) : i);
                PointF pointF = tempPoint;
                float f = fArr[0];
                float f2 = fArr[1];
                Intrinsics.checkNotNull(childAt);
                getChildPoint(f, f2, viewGroup, childAt, pointF);
                float f3 = fArr[0];
                float f4 = fArr[1];
                fArr[0] = pointF.x;
                fArr[1] = pointF.y;
                View viewFindTouchTargetViewWithPointerEvents = findTouchTargetViewWithPointerEvents(fArr, childAt, list);
                if (viewFindTouchTargetViewWithPointerEvents != null) {
                    return viewFindTouchTargetViewWithPointerEvents;
                }
                fArr[0] = f3;
                fArr[1] = f4;
            }
        }
        if (enumSet.contains(TouchTargetReturnType.SELF) && isTouchPointInView(fArr[0], fArr[1], view)) {
            return view;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isTouchPointInView(float f, float f2, View view) {
        ReactHitSlopView reactHitSlopView = view instanceof ReactHitSlopView ? (ReactHitSlopView) view : null;
        Rect hitSlopRect = reactHitSlopView != null ? reactHitSlopView.getHitSlopRect() : null;
        if (hitSlopRect != null) {
            return f >= ((float) (-hitSlopRect.left)) && f < ((float) (view.getWidth() + hitSlopRect.right)) && f2 >= ((float) (-hitSlopRect.top)) && f2 < ((float) (view.getHeight() + hitSlopRect.bottom));
        }
        return f >= 0.0f && f < ((float) view.getWidth()) && f2 >= 0.0f && f2 < ((float) view.getHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isTouchPointInViewWithOverflowInset(float f, float f2, View view) {
        if (!(view instanceof ReactOverflowViewWithInset)) {
            return false;
        }
        Rect overflowInset = ((ReactOverflowViewWithInset) view).getOverflowInset();
        return f >= ((float) overflowInset.left) && f < ((float) (view.getWidth() - overflowInset.right)) && f2 >= ((float) overflowInset.top) && f2 < ((float) (view.getHeight() - overflowInset.bottom));
    }

    private final void getChildPoint(float f, float f2, ViewGroup viewGroup, View view, PointF pointF) {
        float scrollX = (f + viewGroup.getScrollX()) - view.getLeft();
        float scrollY = (f2 + viewGroup.getScrollY()) - view.getTop();
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            float[] fArr = matrixTransformCoords;
            fArr[0] = scrollX;
            fArr[1] = scrollY;
            Matrix matrix2 = inverseMatrix;
            matrix.invert(matrix2);
            matrix2.mapPoints(fArr);
            float f3 = fArr[0];
            scrollY = fArr[1];
            scrollX = f3;
        }
        pointF.set(scrollX, scrollY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View findTouchTargetViewWithPointerEvents(float[] fArr, View view, List list) {
        PointerEvents pointerEvents;
        if (view instanceof ReactPointerEventsView) {
            pointerEvents = ((ReactPointerEventsView) view).getPointerEvents();
        } else {
            pointerEvents = PointerEvents.AUTO;
        }
        if (!view.isEnabled()) {
            int i = WhenMappings.$EnumSwitchMapping$0[pointerEvents.ordinal()];
            if (i == 1) {
                pointerEvents = PointerEvents.BOX_NONE;
            } else if (i == 2) {
                pointerEvents = PointerEvents.NONE;
            }
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[pointerEvents.ordinal()];
        if (i2 == 2) {
            EnumSet enumSetOf = EnumSet.of(TouchTargetReturnType.SELF);
            Intrinsics.checkNotNullExpressionValue(enumSetOf, "of(...)");
            View viewFindTouchTargetView = findTouchTargetView(fArr, view, enumSetOf, list);
            if (viewFindTouchTargetView != null && list != null) {
                list.add(new ViewTarget(view.getId(), view));
            }
            return viewFindTouchTargetView;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                EnumSet enumSetOf2 = EnumSet.of(TouchTargetReturnType.CHILD);
                Intrinsics.checkNotNullExpressionValue(enumSetOf2, "of(...)");
                View viewFindTouchTargetView2 = findTouchTargetView(fArr, view, enumSetOf2, list);
                if (viewFindTouchTargetView2 != null) {
                    if (list != null) {
                        list.add(new ViewTarget(view.getId(), view));
                    }
                    return viewFindTouchTargetView2;
                }
                if ((view instanceof ReactCompoundView) && isTouchPointInView(fArr[0], fArr[1], view) && ((ReactCompoundView) view).reactTagForTouch(fArr[0], fArr[1]) != view.getId()) {
                    if (list != null) {
                        list.add(new ViewTarget(view.getId(), view));
                    }
                }
            } else {
                if (pointerEvents != PointerEvents.AUTO) {
                    FLog.w("ReactNative", "Unknown pointer event type: " + pointerEvents);
                }
                if (!(view instanceof ReactCompoundViewGroup) || !isTouchPointInView(fArr[0], fArr[1], view) || !((ReactCompoundViewGroup) view).interceptsTouchEvent(fArr[0], fArr[1])) {
                    EnumSet enumSetOf3 = EnumSet.of(TouchTargetReturnType.SELF, TouchTargetReturnType.CHILD);
                    Intrinsics.checkNotNullExpressionValue(enumSetOf3, "of(...)");
                    View viewFindTouchTargetView3 = findTouchTargetView(fArr, view, enumSetOf3, list);
                    if (viewFindTouchTargetView3 != null && list != null) {
                        list.add(new ViewTarget(view.getId(), view));
                    }
                    return viewFindTouchTargetView3;
                }
                if (list != null) {
                    list.add(new ViewTarget(view.getId(), view));
                    return view;
                }
            }
            return view;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getTouchTargetForView(View view, float f, float f2) {
        if (view instanceof ReactCompoundView) {
            return ((ReactCompoundView) view).reactTagForTouch(f, f2);
        }
        return view.getId();
    }

    public static final class ViewTarget {
        private final View view;
        private final int viewId;

        public ViewTarget(int i, View view) {
            this.viewId = i;
            this.view = view;
        }

        public final int getViewId() {
            return this.viewId;
        }

        public final View getView() {
            return this.view;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ViewTarget) && ((ViewTarget) obj).getViewId() == this.viewId;
        }

        public int hashCode() {
            return Integer.hashCode(this.viewId);
        }
    }
}
