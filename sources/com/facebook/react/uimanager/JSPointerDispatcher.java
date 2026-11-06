package com.facebook.react.uimanager;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.PointerEvent;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class JSPointerDispatcher {
    private static final int[] sRootScreenCoords = {0, 0};
    private Map mLastEventCoordinatesByPointerId;
    private Map mLastHitPathByPointerId;
    private final ViewGroup mRootViewGroup;
    private final Set mHoveringPointerIds = new HashSet();
    private int mChildHandlingNativeGesture = -1;
    private int mPrimaryPointerId = -1;
    private int mCoalescingKey = 0;
    private int mLastButtonState = 0;
    private Map mCurrentlyDownPointerIdsToHitPath = new HashMap();

    public JSPointerDispatcher(ViewGroup viewGroup) {
        this.mRootViewGroup = viewGroup;
    }

    public void onChildStartedNativeGesture(View view, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.mChildHandlingNativeGesture != -1 || view == null) {
            return;
        }
        MotionEvent motionEventConvertMotionToRootFrame = convertMotionToRootFrame(view, motionEvent);
        motionEventConvertMotionToRootFrame.setAction(3);
        handleMotionEvent(motionEventConvertMotionToRootFrame, eventDispatcher, false);
        this.mChildHandlingNativeGesture = view.getId();
    }

    private MotionEvent convertMotionToRootFrame(View view, MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int[] iArr = new int[2];
        this.mRootViewGroup.getLocationOnScreen(iArr);
        motionEventObtain.setLocation(motionEvent.getRawX() - iArr[0], motionEvent.getRawY() - iArr[1]);
        return motionEventObtain;
    }

    public void onChildEndedNativeGesture() {
        this.mChildHandlingNativeGesture = -1;
    }

    private static List findHitPathIntersection(List list, List list2) {
        if (list.isEmpty()) {
            return new ArrayList();
        }
        if (list2.isEmpty()) {
            return new ArrayList();
        }
        HashSet hashSet = new HashSet(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            TouchTargetHelper.ViewTarget viewTarget = (TouchTargetHelper.ViewTarget) it.next();
            if (hashSet.contains(viewTarget)) {
                arrayList.add(viewTarget);
            }
        }
        return arrayList;
    }

    private void onUp(int i, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        int activePointerId = pointerEventState.getActivePointerId();
        List list = (List) pointerEventState.getHitPathByPointerId().get(Integer.valueOf(activePointerId));
        if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.UP, PointerEventHelper.EVENT.UP_CAPTURE)) {
            eventDispatcher.dispatchEvent(PointerEvent.obtain("topPointerUp", i, pointerEventState, motionEvent));
        }
        if (!this.mHoveringPointerIds.contains(Integer.valueOf(activePointerId))) {
            if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.OUT, PointerEventHelper.EVENT.OUT_CAPTURE)) {
                eventDispatcher.dispatchEvent(PointerEvent.obtain("topPointerOut", i, pointerEventState, motionEvent));
            }
            dispatchEventForViewTargets("topPointerLeave", pointerEventState, motionEvent, filterByShouldDispatch(list, PointerEventHelper.EVENT.LEAVE, PointerEventHelper.EVENT.LEAVE_CAPTURE, false), eventDispatcher);
        }
        List list2 = (List) this.mCurrentlyDownPointerIdsToHitPath.remove(Integer.valueOf(activePointerId));
        if (list2 != null && isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.CLICK, PointerEventHelper.EVENT.CLICK_CAPTURE)) {
            List listFindHitPathIntersection = findHitPathIntersection(list2, list);
            if (!listFindHitPathIntersection.isEmpty()) {
                eventDispatcher.dispatchEvent(PointerEvent.obtain("topClick", ((TouchTargetHelper.ViewTarget) listFindHitPathIntersection.get(0)).getViewId(), pointerEventState, motionEvent));
            }
        }
        if (motionEvent.getActionMasked() == 1) {
            this.mPrimaryPointerId = -1;
        }
        this.mHoveringPointerIds.remove(Integer.valueOf(activePointerId));
    }

    private void incrementCoalescingKey() {
        this.mCoalescingKey = (this.mCoalescingKey + 1) % Integer.MAX_VALUE;
    }

    private short getCoalescingKey() {
        return (short) (65535 & this.mCoalescingKey);
    }

    private void onDown(int i, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        List list = (List) pointerEventState.getHitPathByPointerId().get(Integer.valueOf(pointerEventState.getActivePointerId()));
        incrementCoalescingKey();
        if (!this.mHoveringPointerIds.contains(Integer.valueOf(pointerEventState.getActivePointerId()))) {
            if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.OVER, PointerEventHelper.EVENT.OVER_CAPTURE)) {
                eventDispatcher.dispatchEvent(PointerEvent.obtain("topPointerOver", i, pointerEventState, motionEvent));
            }
            List listFilterByShouldDispatch = filterByShouldDispatch(list, PointerEventHelper.EVENT.ENTER, PointerEventHelper.EVENT.ENTER_CAPTURE, false);
            Collections.reverse(listFilterByShouldDispatch);
            dispatchEventForViewTargets("topPointerEnter", pointerEventState, motionEvent, listFilterByShouldDispatch, eventDispatcher);
        }
        if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.CLICK, PointerEventHelper.EVENT.CLICK_CAPTURE)) {
            this.mCurrentlyDownPointerIdsToHitPath.put(Integer.valueOf(pointerEventState.getActivePointerId()), new ArrayList(list));
        }
        if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.DOWN, PointerEventHelper.EVENT.DOWN_CAPTURE)) {
            eventDispatcher.dispatchEvent(PointerEvent.obtain("topPointerDown", i, pointerEventState, motionEvent));
        }
    }

    private float[] eventCoordsToScreenCoords(float[] fArr) {
        ViewGroup viewGroup = this.mRootViewGroup;
        int[] iArr = sRootScreenCoords;
        viewGroup.getLocationOnScreen(iArr);
        return new float[]{fArr[0] + iArr[0], fArr[1] + iArr[1]};
    }

    private PointerEvent.PointerEventState createEventState(int i, MotionEvent motionEvent) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            float[] fArr = new float[2];
            float[] fArr2 = {motionEvent.getX(i2), motionEvent.getY(i2)};
            List listFindTargetPathAndCoordinatesForTouch = TouchTargetHelper.findTargetPathAndCoordinatesForTouch(fArr2[0], fArr2[1], this.mRootViewGroup, fArr);
            int pointerId = motionEvent.getPointerId(i2);
            map.put(Integer.valueOf(pointerId), fArr);
            map2.put(Integer.valueOf(pointerId), listFindTargetPathAndCoordinatesForTouch);
            map3.put(Integer.valueOf(pointerId), fArr2);
            map4.put(Integer.valueOf(pointerId), eventCoordsToScreenCoords(fArr2));
        }
        return new PointerEvent.PointerEventState(this.mPrimaryPointerId, i, this.mLastButtonState, UIManagerHelper.getSurfaceId(this.mRootViewGroup), map, map2, map3, map4, this.mHoveringPointerIds);
    }

    public void handleMotionEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher, boolean z) {
        int viewId;
        View view;
        float[] fArr;
        if (this.mChildHandlingNativeGesture != -1) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 10 || motionEvent.getButtonState() == 0) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (actionMasked == 0) {
                this.mPrimaryPointerId = motionEvent.getPointerId(0);
            } else if (actionMasked == 7) {
                this.mHoveringPointerIds.add(Integer.valueOf(pointerId));
            }
            PointerEvent.PointerEventState pointerEventStateCreateEventState = createEventState(pointerId, motionEvent);
            boolean z2 = z && actionMasked == 10;
            if (z2) {
                Map map = this.mLastHitPathByPointerId;
                List list = map != null ? (List) map.get(Integer.valueOf(pointerEventStateCreateEventState.getActivePointerId())) : null;
                if (list == null || list.isEmpty()) {
                    return;
                }
                TouchTargetHelper.ViewTarget viewTarget = (TouchTargetHelper.ViewTarget) list.get(list.size() - 1);
                viewId = viewTarget.getViewId();
                view = viewTarget.getView();
                pointerEventStateCreateEventState.getHitPathByPointerId().put(Integer.valueOf(pointerId), new ArrayList());
            } else {
                List list2 = (List) pointerEventStateCreateEventState.getHitPathByPointerId().get(Integer.valueOf(pointerId));
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                TouchTargetHelper.ViewTarget viewTarget2 = (TouchTargetHelper.ViewTarget) list2.get(0);
                viewId = viewTarget2.getViewId();
                view = viewTarget2.getView();
            }
            handleHitStateDivergence(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
            switch (actionMasked) {
                case 0:
                case 5:
                    onDown(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    break;
                case 1:
                case 6:
                    incrementCoalescingKey();
                    onUp(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    break;
                case 2:
                    onMove(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    break;
                case 3:
                    dispatchCancelEventForTarget(view, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    handleHitStateDivergence(-1, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    break;
                case 4:
                case 8:
                default:
                    FLog.w("ReactNative", "Motion Event was ignored. Action=" + actionMasked + " Target=" + viewId);
                    return;
                case 7:
                    float[] fArr2 = (float[]) pointerEventStateCreateEventState.getEventCoordinatesByPointerId().get(Integer.valueOf(pointerId));
                    Map map2 = this.mLastEventCoordinatesByPointerId;
                    if (map2 != null && map2.containsKey(Integer.valueOf(pointerId))) {
                        fArr = (float[]) this.mLastEventCoordinatesByPointerId.get(Integer.valueOf(pointerId));
                    } else {
                        fArr = new float[]{0.0f, 0.0f};
                    }
                    if (!qualifiedMove(fArr2, fArr)) {
                        return;
                    } else {
                        onMove(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    }
                    break;
                case 9:
                    return;
                case 10:
                    if (z2) {
                        onMove(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    }
                    break;
            }
            this.mLastEventCoordinatesByPointerId = new HashMap(pointerEventStateCreateEventState.getEventCoordinatesByPointerId());
            this.mLastButtonState = motionEvent.getButtonState();
            this.mHoveringPointerIds.retainAll(this.mLastEventCoordinatesByPointerId.keySet());
        }
    }

    private static boolean isAnyoneListeningForBubblingEvent(List list, PointerEventHelper.EVENT event, PointerEventHelper.EVENT event2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TouchTargetHelper.ViewTarget viewTarget = (TouchTargetHelper.ViewTarget) it.next();
            if (PointerEventHelper.isListening(viewTarget.getView(), event) || PointerEventHelper.isListening(viewTarget.getView(), event2)) {
                return true;
            }
        }
        return false;
    }

    private static List filterByShouldDispatch(List list, PointerEventHelper.EVENT event, PointerEventHelper.EVENT event2, boolean z) {
        ArrayList arrayList = new ArrayList(list);
        if (!z) {
            boolean z2 = false;
            for (int size = list.size() - 1; size >= 0; size--) {
                View view = ((TouchTargetHelper.ViewTarget) list.get(size)).getView();
                if (!z2 && !PointerEventHelper.isListening(view, event2) && !PointerEventHelper.isListening(view, event)) {
                    arrayList.remove(size);
                } else if (!z2 && PointerEventHelper.isListening(view, event2)) {
                    z2 = true;
                }
            }
        }
        return arrayList;
    }

    private static void dispatchEventForViewTargets(String str, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, List list, EventDispatcher eventDispatcher) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            eventDispatcher.dispatchEvent(PointerEvent.obtain(str, ((TouchTargetHelper.ViewTarget) it.next()).getViewId(), pointerEventState, motionEvent));
        }
    }

    private static boolean qualifiedMove(float[] fArr, float[] fArr2) {
        return Math.abs(fArr2[0] - fArr[0]) > 0.1f || Math.abs(fArr2[1] - fArr[1]) > 0.1f;
    }

    private void handleHitStateDivergence(int i, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        List arrayList;
        List arrayList2;
        int activePointerId = pointerEventState.getActivePointerId();
        if (i != -1) {
            arrayList = (List) pointerEventState.getHitPathByPointerId().get(Integer.valueOf(activePointerId));
        } else {
            arrayList = new ArrayList();
        }
        Map map = this.mLastHitPathByPointerId;
        if (map != null && map.containsKey(Integer.valueOf(activePointerId))) {
            arrayList2 = (List) this.mLastHitPathByPointerId.get(Integer.valueOf(activePointerId));
        } else {
            arrayList2 = new ArrayList();
        }
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (i2 < Math.min(arrayList.size(), arrayList2.size()) && ((TouchTargetHelper.ViewTarget) arrayList.get((arrayList.size() - 1) - i2)).equals(arrayList2.get((arrayList2.size() - 1) - i2))) {
            View view = ((TouchTargetHelper.ViewTarget) arrayList.get((arrayList.size() - 1) - i2)).getView();
            if (!z && PointerEventHelper.isListening(view, PointerEventHelper.EVENT.ENTER_CAPTURE)) {
                z = true;
            }
            if (!z2 && PointerEventHelper.isListening(view, PointerEventHelper.EVENT.LEAVE_CAPTURE)) {
                z2 = true;
            }
            i2++;
        }
        if (i2 < Math.max(arrayList.size(), arrayList2.size())) {
            incrementCoalescingKey();
            if (arrayList2.size() > 0) {
                int viewId = ((TouchTargetHelper.ViewTarget) arrayList2.get(0)).getViewId();
                if (isAnyoneListeningForBubblingEvent(arrayList2, PointerEventHelper.EVENT.OUT, PointerEventHelper.EVENT.OUT_CAPTURE)) {
                    eventDispatcher.dispatchEvent(PointerEvent.obtain("topPointerOut", viewId, pointerEventState, motionEvent));
                }
                List listFilterByShouldDispatch = filterByShouldDispatch(arrayList2.subList(0, arrayList2.size() - i2), PointerEventHelper.EVENT.LEAVE, PointerEventHelper.EVENT.LEAVE_CAPTURE, z2);
                if (listFilterByShouldDispatch.size() > 0) {
                    dispatchEventForViewTargets("topPointerLeave", pointerEventState, motionEvent, listFilterByShouldDispatch, eventDispatcher);
                }
            }
            if (isAnyoneListeningForBubblingEvent(arrayList, PointerEventHelper.EVENT.OVER, PointerEventHelper.EVENT.OVER_CAPTURE)) {
                eventDispatcher.dispatchEvent(PointerEvent.obtain("topPointerOver", i, pointerEventState, motionEvent));
            }
            List listFilterByShouldDispatch2 = filterByShouldDispatch(arrayList.subList(0, arrayList.size() - i2), PointerEventHelper.EVENT.ENTER, PointerEventHelper.EVENT.ENTER_CAPTURE, z);
            if (listFilterByShouldDispatch2.size() > 0) {
                Collections.reverse(listFilterByShouldDispatch2);
                dispatchEventForViewTargets("topPointerEnter", pointerEventState, motionEvent, listFilterByShouldDispatch2, eventDispatcher);
            }
        }
        HashMap map2 = new HashMap(pointerEventState.getHitPathByPointerId());
        if (i == -1) {
            map2.remove(Integer.valueOf(activePointerId));
        }
        this.mLastHitPathByPointerId = map2;
    }

    private void onMove(int i, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (isAnyoneListeningForBubblingEvent((List) pointerEventState.getHitPathByPointerId().get(Integer.valueOf(pointerEventState.getActivePointerId())), PointerEventHelper.EVENT.MOVE, PointerEventHelper.EVENT.MOVE_CAPTURE)) {
            eventDispatcher.dispatchEvent(PointerEvent.obtain("topPointerMove", i, pointerEventState, motionEvent, getCoalescingKey()));
        }
    }

    private void dispatchCancelEventForTarget(View view, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        Assertions.assertCondition(this.mChildHandlingNativeGesture == -1, "Expected to not have already sent a cancel for this gesture");
        List list = (List) pointerEventState.getHitPathByPointerId().get(Integer.valueOf(pointerEventState.getActivePointerId()));
        if (list.isEmpty() || view == null) {
            return;
        }
        if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.CANCEL, PointerEventHelper.EVENT.CANCEL_CAPTURE)) {
            int viewId = ((TouchTargetHelper.ViewTarget) list.get(0)).getViewId();
            int[] childOffsetRelativeToRoot = getChildOffsetRelativeToRoot(view);
            ((EventDispatcher) Assertions.assertNotNull(eventDispatcher)).dispatchEvent(PointerEvent.obtain("topPointerCancel", viewId, normalizeToRoot(pointerEventState, childOffsetRelativeToRoot[0], childOffsetRelativeToRoot[1]), motionEvent));
        }
        incrementCoalescingKey();
        this.mPrimaryPointerId = -1;
    }

    private int[] getChildOffsetRelativeToRoot(View view) {
        Rect rect = new Rect(0, 0, 1, 1);
        this.mRootViewGroup.offsetDescendantRectToMyCoords(view, rect);
        return new int[]{rect.top, rect.left};
    }

    private PointerEvent.PointerEventState normalizeToRoot(PointerEvent.PointerEventState pointerEventState, float f, float f2) {
        HashMap map = new HashMap(pointerEventState.getOffsetByPointerId());
        HashMap map2 = new HashMap(pointerEventState.getEventCoordinatesByPointerId());
        HashMap map3 = new HashMap(pointerEventState.getScreenCoordinatesByPointerId());
        float[] fArr = {f, f2};
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            ((Map.Entry) it.next()).setValue(fArr);
        }
        float[] fArr2 = {0.0f, 0.0f};
        Iterator it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            ((Map.Entry) it2.next()).setValue(fArr2);
        }
        float[] fArrEventCoordsToScreenCoords = eventCoordsToScreenCoords(fArr);
        Iterator it3 = map3.entrySet().iterator();
        while (it3.hasNext()) {
            ((Map.Entry) it3.next()).setValue(fArrEventCoordsToScreenCoords);
        }
        return new PointerEvent.PointerEventState(pointerEventState.getPrimaryPointerId(), pointerEventState.getActivePointerId(), pointerEventState.getLastButtonState(), pointerEventState.getSurfaceId(), map, new HashMap(pointerEventState.getHitPathByPointerId()), map2, map3, new HashSet(pointerEventState.getHoveringPointerIds()));
    }
}
