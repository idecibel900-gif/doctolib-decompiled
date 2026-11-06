package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.TouchTargetHelper;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class PointerEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private static final Pools$SynchronizedPool EVENTS_POOL;
    private static final String TAG;
    private String _eventName;
    private short coalescingKey;
    private final Lazy eventAnimationDriverMatchSpec$delegate;
    private PointerEventState eventState;
    private MotionEvent motionEvent;
    private List pointersEventData;

    public /* synthetic */ PointerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final PointerEvent obtain(String str, int i, PointerEventState pointerEventState, MotionEvent motionEvent) {
        return Companion.obtain(str, i, pointerEventState, motionEvent);
    }

    public static final PointerEvent obtain(String str, int i, PointerEventState pointerEventState, MotionEvent motionEvent, short s) {
        return Companion.obtain(str, i, pointerEventState, motionEvent, s);
    }

    private PointerEvent() {
        this.coalescingKey = (short) -1;
        this.eventAnimationDriverMatchSpec$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.facebook.react.uimanager.events.PointerEvent$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PointerEvent.eventAnimationDriverMatchSpec_delegate$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init(String str, int i, PointerEventState pointerEventState, MotionEvent motionEvent, short s) {
        super.init(pointerEventState.getSurfaceId(), i, motionEvent.getEventTime());
        this._eventName = str;
        this.motionEvent = MotionEvent.obtain(motionEvent);
        this.coalescingKey = s;
        this.eventState = pointerEventState;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        String str = this._eventName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_eventName");
        return null;
    }

    private final boolean isClickEvent() {
        String str = this._eventName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_eventName");
            str = null;
        }
        return Intrinsics.areEqual(str, "topClick");
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        if (this.motionEvent == null) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Cannot dispatch a Pointer that has no MotionEvent; the PointerEvent has been recycled"));
            return;
        }
        if (this.pointersEventData == null) {
            this.pointersEventData = createPointersEventData();
        }
        List<WritableMap> list = this.pointersEventData;
        if (list == null) {
            return;
        }
        boolean z = list.size() > 1;
        for (WritableMap writableMapCopy : list) {
            if (z) {
                writableMapCopy = writableMapCopy.copy();
            }
            int viewTag = getViewTag();
            String str = this._eventName;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_eventName");
                str = null;
            }
            rctEventEmitter.receiveEvent(viewTag, str, writableMapCopy);
        }
    }

    @Override // com.facebook.react.uimanager.events.Event
    public Event.EventAnimationDriverMatchSpec getEventAnimationDriverMatchSpec() {
        return (Event.EventAnimationDriverMatchSpec) this.eventAnimationDriverMatchSpec$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Event.EventAnimationDriverMatchSpec eventAnimationDriverMatchSpec_delegate$lambda$1(final PointerEvent pointerEvent) {
        return new Event.EventAnimationDriverMatchSpec() { // from class: com.facebook.react.uimanager.events.PointerEvent$$ExternalSyntheticLambda1
            @Override // com.facebook.react.uimanager.events.Event.EventAnimationDriverMatchSpec
            public final boolean match(int i, String str) {
                return PointerEvent.eventAnimationDriverMatchSpec_delegate$lambda$1$lambda$0(this.f$0, i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean eventAnimationDriverMatchSpec_delegate$lambda$1$lambda$0(PointerEvent pointerEvent, int i, String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        String str = pointerEvent._eventName;
        PointerEventState pointerEventState = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_eventName");
            str = null;
        }
        if (!Intrinsics.areEqual(eventName, str)) {
            return false;
        }
        if (!PointerEventHelper.isBubblingEvent(eventName)) {
            return pointerEvent.getViewTag() == i;
        }
        PointerEventState pointerEventState2 = pointerEvent.eventState;
        if (pointerEventState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventState");
        } else {
            pointerEventState = pointerEventState2;
        }
        Iterator it = pointerEventState.getHitPathForActivePointer().iterator();
        while (it.hasNext()) {
            if (((TouchTargetHelper.ViewTarget) it.next()).getViewId() == i) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        this.pointersEventData = null;
        MotionEvent motionEvent = this.motionEvent;
        this.motionEvent = null;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        try {
            EVENTS_POOL.release(this);
        } catch (IllegalStateException e) {
            ReactSoftExceptionLogger.logSoftException(TAG, e);
        }
    }

    private final List createW3CPointerEvents() {
        ArrayList arrayList = new ArrayList();
        MotionEvent motionEvent = this.motionEvent;
        if (motionEvent == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            arrayList.add(createW3CPointerEvent(i));
        }
        return arrayList;
    }

    private final void addModifierKeyData(WritableMap writableMap, int i) {
        writableMap.putBoolean("ctrlKey", (i & 4096) != 0);
        writableMap.putBoolean("shiftKey", (i & 1) != 0);
        writableMap.putBoolean("altKey", (i & 2) != 0);
        writableMap.putBoolean("metaKey", (i & 65536) != 0);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004d  */
    private final WritableMap createW3CPointerEvent(int i) {
        boolean z;
        String str;
        double pressure;
        WritableMap writableMapCreateMap = Arguments.createMap();
        MotionEvent motionEvent = this.motionEvent;
        if (motionEvent == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int pointerId = motionEvent.getPointerId(i);
        writableMapCreateMap.putDouble("pointerId", pointerId);
        String w3CPointerType = PointerEventHelper.getW3CPointerType(motionEvent.getToolType(i));
        writableMapCreateMap.putString("pointerType", w3CPointerType);
        if (isClickEvent()) {
            z = false;
        } else {
            PointerEventState pointerEventState = this.eventState;
            if (pointerEventState == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventState");
                pointerEventState = null;
            }
            if (!pointerEventState.supportsHover(pointerId)) {
                PointerEventState pointerEventState2 = this.eventState;
                if (pointerEventState2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventState");
                    pointerEventState2 = null;
                }
                if (pointerId != pointerEventState2.getPrimaryPointerId()) {
                    z = false;
                }
            }
            z = true;
        }
        writableMapCreateMap.putBoolean("isPrimary", z);
        PointerEventState pointerEventState3 = this.eventState;
        if (pointerEventState3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventState");
            pointerEventState3 = null;
        }
        Object obj = pointerEventState3.getEventCoordinatesByPointerId().get(Integer.valueOf(pointerId));
        if (obj == null) {
            throw new IllegalStateException("Required value was null.");
        }
        float[] fArr = (float[]) obj;
        double dIPFromPixel = PixelUtil.toDIPFromPixel(fArr[0]);
        double dIPFromPixel2 = PixelUtil.toDIPFromPixel(fArr[1]);
        writableMapCreateMap.putDouble("clientX", dIPFromPixel);
        writableMapCreateMap.putDouble("clientY", dIPFromPixel2);
        PointerEventState pointerEventState4 = this.eventState;
        if (pointerEventState4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventState");
            pointerEventState4 = null;
        }
        Object obj2 = pointerEventState4.getScreenCoordinatesByPointerId().get(Integer.valueOf(pointerId));
        if (obj2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        float[] fArr2 = (float[]) obj2;
        double dIPFromPixel3 = PixelUtil.toDIPFromPixel(fArr2[0]);
        double dIPFromPixel4 = PixelUtil.toDIPFromPixel(fArr2[1]);
        writableMapCreateMap.putDouble("screenX", dIPFromPixel3);
        writableMapCreateMap.putDouble("screenY", dIPFromPixel4);
        writableMapCreateMap.putDouble("x", dIPFromPixel);
        writableMapCreateMap.putDouble("y", dIPFromPixel2);
        writableMapCreateMap.putDouble("pageX", dIPFromPixel);
        writableMapCreateMap.putDouble("pageY", dIPFromPixel2);
        PointerEventState pointerEventState5 = this.eventState;
        if (pointerEventState5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventState");
            pointerEventState5 = null;
        }
        Object obj3 = pointerEventState5.getOffsetByPointerId().get(Integer.valueOf(pointerId));
        if (obj3 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        float[] fArr3 = (float[]) obj3;
        writableMapCreateMap.putDouble("offsetX", PixelUtil.toDIPFromPixel(fArr3[0]));
        writableMapCreateMap.putDouble("offsetY", PixelUtil.toDIPFromPixel(fArr3[1]));
        writableMapCreateMap.putInt("target", getViewTag());
        writableMapCreateMap.putDouble(DiagnosticsEntry.TIMESTAMP_KEY, getTimestampMs());
        writableMapCreateMap.putInt("detail", 0);
        writableMapCreateMap.putDouble("tiltX", 0.0d);
        writableMapCreateMap.putDouble("tiltY", 0.0d);
        writableMapCreateMap.putInt("twist", 0);
        if (Intrinsics.areEqual(w3CPointerType, "mouse") || isClickEvent()) {
            writableMapCreateMap.putDouble("width", 1.0d);
            writableMapCreateMap.putDouble("height", 1.0d);
        } else {
            double dIPFromPixel5 = PixelUtil.toDIPFromPixel(motionEvent.getTouchMajor(i));
            writableMapCreateMap.putDouble("width", dIPFromPixel5);
            writableMapCreateMap.putDouble("height", dIPFromPixel5);
        }
        int buttonState = motionEvent.getButtonState();
        PointerEventState pointerEventState6 = this.eventState;
        if (pointerEventState6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventState");
            pointerEventState6 = null;
        }
        writableMapCreateMap.putInt("button", PointerEventHelper.getButtonChange(w3CPointerType, pointerEventState6.getLastButtonState(), buttonState));
        String str2 = this._eventName;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_eventName");
            str2 = null;
        }
        writableMapCreateMap.putInt("buttons", PointerEventHelper.getButtons(str2, w3CPointerType, buttonState));
        if (isClickEvent()) {
            pressure = 0.0d;
        } else {
            int i2 = writableMapCreateMap.getInt("buttons");
            String str3 = this._eventName;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_eventName");
                str = null;
            } else {
                str = str3;
            }
            pressure = PointerEventHelper.getPressure(i2, str);
        }
        writableMapCreateMap.putDouble("pressure", pressure);
        writableMapCreateMap.putDouble("tangentialPressure", 0.0d);
        addModifierKeyData(writableMapCreateMap, motionEvent.getMetaState());
        return writableMapCreateMap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        if (r1.equals("topPointerOut") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        if (r1.equals("topPointerCancel") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r1.equals("topClick") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        if (r1.equals("topPointerUp") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
    
        if (r1.equals("topPointerOver") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
    
        if (r1.equals("topPointerMove") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        return createW3CPointerEvents();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        if (r1.equals("topPointerDown") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
    
        if (r1.equals("topPointerLeave") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
    
        if (r1.equals("topPointerEnter") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
    
        return kotlin.collections.CollectionsKt.listOf(createW3CPointerEvent(r0));
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List createPointersEventData() {
        /*
            r4 = this;
            android.view.MotionEvent r0 = r4.motionEvent
            if (r0 == 0) goto L7a
            int r0 = r0.getActionIndex()
            java.lang.String r1 = r4._eventName
            r2 = 0
            if (r1 != 0) goto L13
            java.lang.String r1 = "_eventName"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r2
        L13:
            int r3 = r1.hashCode()
            switch(r3) {
                case -1786514288: goto L68;
                case -1780335505: goto L5f;
                case -1304584214: goto L56;
                case -1304316135: goto L48;
                case -1304250340: goto L3f;
                case -1065042973: goto L36;
                case -992108237: goto L2d;
                case 383186882: goto L24;
                case 1343400710: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L70
        L1b:
            java.lang.String r3 = "topPointerOut"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L71
            goto L70
        L24:
            java.lang.String r0 = "topPointerCancel"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L51
            goto L70
        L2d:
            java.lang.String r3 = "topClick"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L71
            goto L70
        L36:
            java.lang.String r3 = "topPointerUp"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L71
            goto L70
        L3f:
            java.lang.String r3 = "topPointerOver"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L71
            goto L70
        L48:
            java.lang.String r0 = "topPointerMove"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L51
            goto L70
        L51:
            java.util.List r0 = r4.createW3CPointerEvents()
            return r0
        L56:
            java.lang.String r3 = "topPointerDown"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L71
            goto L70
        L5f:
            java.lang.String r3 = "topPointerLeave"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L71
            goto L70
        L68:
            java.lang.String r3 = "topPointerEnter"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L71
        L70:
            return r2
        L71:
            com.facebook.react.bridge.WritableMap r0 = r4.createW3CPointerEvent(r0)
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            return r0
        L7a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Required value was null."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.events.PointerEvent.createPointersEventData():java.util.List");
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return this.coalescingKey;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatchModern(RCTModernEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        if (this.motionEvent == null) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Cannot dispatch a Pointer that has no MotionEvent; the PointerEvent has been recycled"));
            return;
        }
        if (this.pointersEventData == null) {
            this.pointersEventData = createPointersEventData();
        }
        List<WritableMap> list = this.pointersEventData;
        if (list == null) {
            return;
        }
        if (list == null) {
            throw new IllegalStateException("Required value was null.");
        }
        boolean z = list.size() > 1;
        for (WritableMap writableMapCopy : list) {
            if (z) {
                writableMapCopy = writableMapCopy.copy();
            }
            WritableMap writableMap = writableMapCopy;
            int surfaceId = getSurfaceId();
            int viewTag = getViewTag();
            String str = this._eventName;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_eventName");
                str = null;
            }
            short s = this.coalescingKey;
            boolean z2 = s != -1;
            String str3 = this._eventName;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_eventName");
            } else {
                str2 = str3;
            }
            rctEventEmitter.receiveEvent(surfaceId, viewTag, str, z2, s, writableMap, PointerEventHelper.getEventCategory(str2));
        }
    }

    public static final class PointerEventState {
        private final int activePointerId;
        private final Map eventCoordinatesByPointerId;
        private final Map hitPathByPointerId;
        private final Set hoveringPointerIds;
        private final int lastButtonState;
        private final Map offsetByPointerId;
        private final int primaryPointerId;
        private final Map screenCoordinatesByPointerId;
        private final int surfaceId;

        public PointerEventState(int i, int i2, int i3, int i4, Map offsetByPointerId, Map hitPathByPointerId, Map eventCoordinatesByPointerId, Map screenCoordinatesByPointerId, Set hoveringPointerIds) {
            Intrinsics.checkNotNullParameter(offsetByPointerId, "offsetByPointerId");
            Intrinsics.checkNotNullParameter(hitPathByPointerId, "hitPathByPointerId");
            Intrinsics.checkNotNullParameter(eventCoordinatesByPointerId, "eventCoordinatesByPointerId");
            Intrinsics.checkNotNullParameter(screenCoordinatesByPointerId, "screenCoordinatesByPointerId");
            Intrinsics.checkNotNullParameter(hoveringPointerIds, "hoveringPointerIds");
            this.primaryPointerId = i;
            this.activePointerId = i2;
            this.lastButtonState = i3;
            this.surfaceId = i4;
            this.offsetByPointerId = offsetByPointerId;
            this.hitPathByPointerId = hitPathByPointerId;
            this.eventCoordinatesByPointerId = eventCoordinatesByPointerId;
            this.screenCoordinatesByPointerId = screenCoordinatesByPointerId;
            this.hoveringPointerIds = new HashSet(hoveringPointerIds);
        }

        public final int getPrimaryPointerId() {
            return this.primaryPointerId;
        }

        public final int getActivePointerId() {
            return this.activePointerId;
        }

        public final int getLastButtonState() {
            return this.lastButtonState;
        }

        public final Map getOffsetByPointerId() {
            return this.offsetByPointerId;
        }

        public final Map getHitPathByPointerId() {
            return this.hitPathByPointerId;
        }

        public final Map getEventCoordinatesByPointerId() {
            return this.eventCoordinatesByPointerId;
        }

        public final Map getScreenCoordinatesByPointerId() {
            return this.screenCoordinatesByPointerId;
        }

        public final Set getHoveringPointerIds() {
            return this.hoveringPointerIds;
        }

        public final int getSurfaceId() {
            return this.surfaceId;
        }

        public final boolean supportsHover(int i) {
            return this.hoveringPointerIds.contains(Integer.valueOf(i));
        }

        public final List getHitPathForActivePointer() {
            Object obj = this.hitPathByPointerId.get(Integer.valueOf(this.activePointerId));
            if (obj != null) {
                return (List) obj;
            }
            throw new IllegalStateException("Required value was null.");
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PointerEvent obtain(String eventName, int i, PointerEventState eventState, MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(eventState, "eventState");
            PointerEvent pointerEvent = (PointerEvent) PointerEvent.EVENTS_POOL.acquire();
            if (pointerEvent == null) {
                pointerEvent = new PointerEvent(null);
            }
            PointerEvent pointerEvent2 = pointerEvent;
            Object objAssertNotNull = Assertions.assertNotNull(motionEvent);
            Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
            pointerEvent2.init(eventName, i, eventState, (MotionEvent) objAssertNotNull, (short) 0);
            return pointerEvent2;
        }

        public final PointerEvent obtain(String eventName, int i, PointerEventState eventState, MotionEvent motionEvent, short s) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(eventState, "eventState");
            PointerEvent pointerEvent = (PointerEvent) PointerEvent.EVENTS_POOL.acquire();
            if (pointerEvent == null) {
                pointerEvent = new PointerEvent(null);
            }
            PointerEvent pointerEvent2 = pointerEvent;
            Object objAssertNotNull = Assertions.assertNotNull(motionEvent);
            Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
            pointerEvent2.init(eventName, i, eventState, (MotionEvent) objAssertNotNull, s);
            return pointerEvent2;
        }
    }

    static {
        String simpleName = PointerEvent.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        TAG = simpleName;
        EVENTS_POOL = new Pools$SynchronizedPool(6);
    }
}
