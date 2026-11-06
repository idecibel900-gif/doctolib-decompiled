package com.facebook.react.uimanager;

import android.widget.ImageView;
import com.facebook.react.uimanager.events.TouchEventType;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class UIManagerModuleConstants {
    public static final UIManagerModuleConstants INSTANCE = new UIManagerModuleConstants();
    public static final Map bubblingEventTypeConstants;
    public static final Map constants;
    public static final Map directEventTypeConstants;

    private UIManagerModuleConstants() {
    }

    static {
        Pair pair = TuplesKt.to("topChange", MapsKt.mapOf(TuplesKt.to("phasedRegistrationNames", MapsKt.mapOf(TuplesKt.to("bubbled", "onChange"), TuplesKt.to("captured", "onChangeCapture")))));
        Pair pair2 = TuplesKt.to("topSelect", MapsKt.mapOf(TuplesKt.to("phasedRegistrationNames", MapsKt.mapOf(TuplesKt.to("bubbled", "onSelect"), TuplesKt.to("captured", "onSelectCapture")))));
        TouchEventType.Companion companion = TouchEventType.Companion;
        bubblingEventTypeConstants = MapsKt.mapOf(pair, pair2, TuplesKt.to(companion.getJSEventName(TouchEventType.START), MapsKt.mapOf(TuplesKt.to("phasedRegistrationNames", MapsKt.mapOf(TuplesKt.to("bubbled", "onTouchStart"), TuplesKt.to("captured", "onTouchStartCapture"))))), TuplesKt.to(companion.getJSEventName(TouchEventType.MOVE), MapsKt.mapOf(TuplesKt.to("phasedRegistrationNames", MapsKt.mapOf(TuplesKt.to("bubbled", "onTouchMove"), TuplesKt.to("captured", "onTouchMoveCapture"))))), TuplesKt.to(companion.getJSEventName(TouchEventType.END), MapsKt.mapOf(TuplesKt.to("phasedRegistrationNames", MapsKt.mapOf(TuplesKt.to("bubbled", "onTouchEnd"), TuplesKt.to("captured", "onTouchEndCapture"))))), TuplesKt.to(companion.getJSEventName(TouchEventType.CANCEL), MapsKt.mapOf(TuplesKt.to("phasedRegistrationNames", MapsKt.mapOf(TuplesKt.to("bubbled", "onTouchCancel"), TuplesKt.to("captured", "onTouchCancelCapture"))))));
        directEventTypeConstants = MapsKt.mapOf(TuplesKt.to("topContentSizeChange", MapsKt.mapOf(TuplesKt.to("registrationName", "onContentSizeChange"))), TuplesKt.to("topLayout", MapsKt.mapOf(TuplesKt.to("registrationName", "onLayout"))), TuplesKt.to("topLoadingError", MapsKt.mapOf(TuplesKt.to("registrationName", "onLoadingError"))), TuplesKt.to("topLoadingFinish", MapsKt.mapOf(TuplesKt.to("registrationName", "onLoadingFinish"))), TuplesKt.to("topLoadingStart", MapsKt.mapOf(TuplesKt.to("registrationName", "onLoadingStart"))), TuplesKt.to("topSelectionChange", MapsKt.mapOf(TuplesKt.to("registrationName", "onSelectionChange"))), TuplesKt.to("topMessage", MapsKt.mapOf(TuplesKt.to("registrationName", "onMessage"))), TuplesKt.to("topScrollBeginDrag", MapsKt.mapOf(TuplesKt.to("registrationName", "onScrollBeginDrag"))), TuplesKt.to("topScrollEndDrag", MapsKt.mapOf(TuplesKt.to("registrationName", "onScrollEndDrag"))), TuplesKt.to("topScroll", MapsKt.mapOf(TuplesKt.to("registrationName", "onScroll"))), TuplesKt.to("topMomentumScrollBegin", MapsKt.mapOf(TuplesKt.to("registrationName", "onMomentumScrollBegin"))), TuplesKt.to("topMomentumScrollEnd", MapsKt.mapOf(TuplesKt.to("registrationName", "onMomentumScrollEnd"))));
        constants = MapsKt.mapOf(TuplesKt.to("UIView", MapsKt.mapOf(TuplesKt.to("ContentMode", MapsKt.mapOf(TuplesKt.to("ScaleAspectFit", Integer.valueOf(ImageView.ScaleType.FIT_CENTER.ordinal())), TuplesKt.to("ScaleAspectFill", Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal())), TuplesKt.to("ScaleAspectCenter", Integer.valueOf(ImageView.ScaleType.CENTER_INSIDE.ordinal())))))), TuplesKt.to("StyleConstants", MapsKt.mapOf(TuplesKt.to("PointerEventsValues", MapsKt.mapOf(TuplesKt.to("none", Integer.valueOf(PointerEvents.NONE.ordinal())), TuplesKt.to("boxNone", Integer.valueOf(PointerEvents.BOX_NONE.ordinal())), TuplesKt.to("boxOnly", Integer.valueOf(PointerEvents.BOX_ONLY.ordinal())), TuplesKt.to("unspecified", Integer.valueOf(PointerEvents.AUTO.ordinal())))))), TuplesKt.to("AccessibilityEventTypes", MapsKt.mapOf(TuplesKt.to("typeWindowStateChanged", 32), TuplesKt.to("typeViewFocused", 8), TuplesKt.to("typeViewClicked", 1))));
    }
}
