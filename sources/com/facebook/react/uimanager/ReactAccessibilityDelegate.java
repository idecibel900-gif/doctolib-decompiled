package com.facebook.react.uimanager;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R$id;
import com.facebook.react.R$string;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.util.ReactFindViewUtil;
import com.google.firebase.messaging.Constants;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.composables.BackgroundUIConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class ReactAccessibilityDelegate extends ExploreByTouchHelper {
    public static final Companion Companion = new Companion(null);
    private static final Map actionIdMap = MapsKt.mapOf(TuplesKt.to("activate", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK.getId())), TuplesKt.to("longpress", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_LONG_CLICK.getId())), TuplesKt.to("increment", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId())), TuplesKt.to("decrement", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId())), TuplesKt.to("expand", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND.getId())), TuplesKt.to("collapse", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE.getId())));
    private static int customActionCounter = 1056964608;
    private static final Map customActionIdMap = new HashMap();
    private final HashMap accessibilityActionsMap;
    private final Handler accessibilityEventHandler;
    private View accessibilityLabelledBy;
    private final View hostView;

    public static final void setDelegate(View view, boolean z, int i) {
        Companion.setDelegate(view, z, i);
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return null;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected int getVirtualViewAt(float f, float f2) {
        return LinearLayoutManager.INVALID_OFFSET;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected void getVisibleVirtualViews(List virtualViewIds) {
        Intrinsics.checkNotNullParameter(virtualViewIds, "virtualViewIds");
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        return false;
    }

    protected final View getHostView() {
        return this.hostView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactAccessibilityDelegate(View hostView, boolean z, int i) {
        super(hostView);
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        this.hostView = hostView;
        this.accessibilityEventHandler = new Handler() { // from class: com.facebook.react.uimanager.ReactAccessibilityDelegate$accessibilityEventHandler$1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                View view = (View) msg.obj;
                if (view != null) {
                    view.sendAccessibilityEvent(4);
                }
            }
        };
        this.accessibilityActionsMap = new HashMap();
        hostView.setFocusable(z);
        hostView.setImportantForAccessibility(i);
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(host, info);
        if (host.getTag(R$id.accessibility_state_expanded) != null) {
            Object tag = host.getTag(R$id.accessibility_state_expanded);
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Boolean");
            info.addAction(((Boolean) tag).booleanValue() ? 524288 : 262144);
        }
        AccessibilityRole accessibilityRoleFromViewTag = AccessibilityRole.Companion.fromViewTag(host);
        String str = (String) host.getTag(R$id.accessibility_hint);
        if (accessibilityRoleFromViewTag != null) {
            Companion companion = Companion;
            Context context = host.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            companion.setRole(info, accessibilityRoleFromViewTag, context);
        }
        if (str != null) {
            info.setTooltipText(str);
        }
        Object tag2 = host.getTag(R$id.labelled_by);
        if (tag2 != null) {
            View rootView = host.getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
            View viewFindView = ReactFindViewUtil.findView(rootView, (String) tag2);
            this.accessibilityLabelledBy = viewFindView;
            if (viewFindView != null) {
                info.setLabeledBy(viewFindView);
            }
        }
        ReadableMap readableMap = (ReadableMap) host.getTag(R$id.accessibility_state);
        if (readableMap != null) {
            Companion.setState(info, readableMap);
        }
        ReadableArray readableArray = (ReadableArray) host.getTag(R$id.accessibility_actions);
        ReadableMap readableMap2 = (ReadableMap) host.getTag(R$id.accessibility_collection_item);
        if (readableMap2 != null) {
            info.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(readableMap2.getInt("rowIndex"), readableMap2.getInt("rowSpan"), readableMap2.getInt("columnIndex"), readableMap2.getInt("columnSpan"), readableMap2.getBoolean("heading")));
        }
        if (readableArray != null) {
            int size = readableArray.size();
            for (int i = 0; i < size; i++) {
                ReadableMap map = readableArray.getMap(i);
                if (map == null || !map.hasKey("name")) {
                    throw new IllegalArgumentException("Unknown accessibility action.");
                }
                String string = map.getString("name");
                String str2 = map.hasKey(Constants.ScionAnalytics.PARAM_LABEL) ? (String) Assertions.assertNotNull(map.getString(Constants.ScionAnalytics.PARAM_LABEL)) : "";
                Integer num = (Integer) actionIdMap.get(string);
                if (num != null) {
                    iIntValue = num.intValue();
                } else {
                    Map map2 = customActionIdMap;
                    Object objValueOf = map2.get(string);
                    if (objValueOf == null) {
                        int i2 = customActionCounter;
                        customActionCounter = i2 + 1;
                        objValueOf = Integer.valueOf(i2);
                        map2.put(string, objValueOf);
                    }
                    iIntValue = ((Number) objValueOf).intValue();
                }
                this.accessibilityActionsMap.put(Integer.valueOf(iIntValue), string);
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(iIntValue, str2));
            }
        }
        ReadableMap readableMap3 = (ReadableMap) host.getTag(R$id.accessibility_value);
        if (readableMap3 != null && readableMap3.hasKey("min") && readableMap3.hasKey("now") && readableMap3.hasKey("max")) {
            Dynamic dynamic = readableMap3.getDynamic("min");
            Dynamic dynamic2 = readableMap3.getDynamic("now");
            Dynamic dynamic3 = readableMap3.getDynamic("max");
            ReadableType type = dynamic.getType();
            ReadableType readableType = ReadableType.Number;
            if (type == readableType && dynamic2.getType() == readableType && dynamic3.getType() == readableType) {
                int iAsInt = dynamic.asInt();
                int iAsInt2 = dynamic2.asInt();
                int iAsInt3 = dynamic3.asInt();
                if (iAsInt3 > iAsInt && iAsInt2 >= iAsInt && iAsInt3 >= iAsInt2) {
                    info.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(0, iAsInt, iAsInt3, iAsInt2));
                }
            }
        }
        String str3 = (String) host.getTag(R$id.react_test_id);
        if (str3 != null) {
            info.setViewIdResourceName(str3);
        }
        CharSequence contentDescription = info.getContentDescription();
        boolean z = contentDescription == null || contentDescription.length() == 0;
        CharSequence text = info.getText();
        boolean z2 = z && (text == null || text.length() == 0);
        boolean z3 = (readableArray == null && readableMap == null && tag2 == null && accessibilityRoleFromViewTag == null) ? false : true;
        if (z2 && z3) {
            info.setContentDescription(Companion.getTalkbackDescription(host, info));
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(event, "event");
        super.onInitializeAccessibilityEvent(host, event);
        ReadableMap readableMap = (ReadableMap) host.getTag(R$id.accessibility_value);
        if (readableMap != null && readableMap.hasKey("min") && readableMap.hasKey("now") && readableMap.hasKey("max")) {
            Dynamic dynamic = readableMap.getDynamic("min");
            Dynamic dynamic2 = readableMap.getDynamic("now");
            Dynamic dynamic3 = readableMap.getDynamic("max");
            ReadableType type = dynamic.getType();
            ReadableType readableType = ReadableType.Number;
            if (type == readableType && dynamic2.getType() == readableType && dynamic3.getType() == readableType) {
                int iAsInt = dynamic.asInt();
                int iAsInt2 = dynamic2.asInt();
                int iAsInt3 = dynamic3.asInt();
                if (iAsInt3 <= iAsInt || iAsInt2 < iAsInt || iAsInt3 < iAsInt2) {
                    return;
                }
                event.setItemCount(iAsInt3 - iAsInt);
                event.setCurrentItemIndex(iAsInt2);
            }
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View host, int i, Bundle bundle) {
        Intrinsics.checkNotNullParameter(host, "host");
        if (i == 524288) {
            host.setTag(R$id.accessibility_state_expanded, Boolean.FALSE);
        }
        if (i == 262144) {
            host.setTag(R$id.accessibility_state_expanded, Boolean.TRUE);
        }
        if (this.accessibilityActionsMap.containsKey(Integer.valueOf(i))) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("actionName", (String) this.accessibilityActionsMap.get(Integer.valueOf(i)));
            Context context = host.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            ReactContext reactContext = (ReactContext) context;
            if (reactContext.hasActiveReactInstance()) {
                int id = host.getId();
                int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
                UIManager uIManager = UIManagerHelper.getUIManager(reactContext, ViewUtil.getUIManagerType(id));
                if (uIManager != null) {
                    uIManager.getEventDispatcher().dispatchEvent(new AccessibilityActionEvent(writableMapCreateMap, surfaceId, id));
                }
            } else {
                ReactSoftExceptionLogger.logSoftException("ReactAccessibilityDelegate", new ReactNoCrashSoftException("Cannot get RCTEventEmitter, no CatalystInstance"));
            }
            Object tag = host.getTag(R$id.accessibility_role);
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole");
            AccessibilityRole accessibilityRole = (AccessibilityRole) tag;
            ReadableMap readableMap = (ReadableMap) host.getTag(R$id.accessibility_value);
            if (accessibilityRole != AccessibilityRole.ADJUSTABLE) {
                return true;
            }
            if (i != AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId() && i != AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId()) {
                return true;
            }
            if (readableMap != null && !readableMap.hasKey("text")) {
                scheduleAccessibilityEventSender(host);
            }
            return super.performAccessibilityAction(host, i, bundle);
        }
        return super.performAccessibilityAction(host, i, bundle);
    }

    private final void scheduleAccessibilityEventSender(View view) {
        if (this.accessibilityEventHandler.hasMessages(1, view)) {
            this.accessibilityEventHandler.removeMessages(1, view);
        }
        Message messageObtainMessage = this.accessibilityEventHandler.obtainMessage(1, view);
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        this.accessibilityEventHandler.sendMessageDelayed(messageObtainMessage, 200L);
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setContentDescription("");
        node.setBoundsInParent(new Rect(0, 0, 1, 1));
    }

    protected final AccessibilityNodeProviderCompat superGetAccessibilityNodeProvider(View host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return super.getAccessibilityNodeProvider(host);
    }

    public enum Role {
        ALERT,
        ALERTDIALOG,
        APPLICATION,
        ARTICLE,
        BANNER,
        BUTTON,
        CELL,
        CHECKBOX,
        COLUMNHEADER,
        COMBOBOX,
        COMPLEMENTARY,
        CONTENTINFO,
        DEFINITION,
        DIALOG,
        DIRECTORY,
        DOCUMENT,
        FEED,
        FIGURE,
        FORM,
        GRID,
        GROUP,
        HEADING,
        IMG,
        LINK,
        LIST,
        LISTITEM,
        LOG,
        MAIN,
        MARQUEE,
        MATH,
        MENU,
        MENUBAR,
        MENUITEM,
        METER,
        NAVIGATION,
        NONE,
        NOTE,
        OPTION,
        PRESENTATION,
        PROGRESSBAR,
        RADIO,
        RADIOGROUP,
        REGION,
        ROW,
        ROWGROUP,
        ROWHEADER,
        SCROLLBAR,
        SEARCHBOX,
        SEPARATOR,
        SLIDER,
        SPINBUTTON,
        STATUS,
        SUMMARY,
        SWITCH,
        TAB,
        TABLE,
        TABLIST,
        TABPANEL,
        TERM,
        TIMER,
        TOOLBAR,
        TOOLTIP,
        TREE,
        TREEGRID,
        TREEITEM;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        public static final Companion Companion = new Companion(null);

        public static final Role fromValue(String str) {
            return Companion.fromValue(str);
        }

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Role fromValue(String str) {
                for (Role role : Role.getEntries()) {
                    if (StringsKt.equals(role.name(), str, true)) {
                        return role;
                    }
                }
                return null;
            }
        }
    }

    private static final class AccessibilityActionEvent extends Event {
        private final WritableMap accessibilityEventData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AccessibilityActionEvent(WritableMap accessibilityEventData, int i, int i2) {
            super(i, i2);
            Intrinsics.checkNotNullParameter(accessibilityEventData, "accessibilityEventData");
            this.accessibilityEventData = accessibilityEventData;
        }

        @Override // com.facebook.react.uimanager.events.Event
        public String getEventName() {
            return "topAccessibilityAction";
        }

        @Override // com.facebook.react.uimanager.events.Event
        public WritableMap getEventData() {
            return this.accessibilityEventData;
        }
    }

    public enum AccessibilityRole {
        NONE,
        BUTTON,
        DROPDOWNLIST,
        TOGGLEBUTTON,
        LINK,
        SEARCH,
        IMAGE,
        IMAGEBUTTON,
        KEYBOARDKEY,
        TEXT,
        ADJUSTABLE,
        SUMMARY,
        HEADER,
        ALERT,
        CHECKBOX,
        COMBOBOX,
        MENU,
        MENUBAR,
        MENUITEM,
        PROGRESSBAR,
        RADIO,
        RADIOGROUP,
        SCROLLBAR,
        SPINBUTTON,
        SWITCH,
        TAB,
        TABLIST,
        TIMER,
        LIST,
        GRID,
        PAGER,
        SCROLLVIEW,
        HORIZONTALSCROLLVIEW,
        VIEWGROUP,
        WEBVIEW,
        DRAWERLAYOUT,
        SLIDINGDRAWER,
        ICONMENU,
        TOOLBAR;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        public static final Companion Companion = new Companion(null);

        public static final AccessibilityRole fromValue(String str) {
            return Companion.fromValue(str);
        }

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }

        public static final class Companion {

            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;
                public static final /* synthetic */ int[] $EnumSwitchMapping$1;

                static {
                    int[] iArr = new int[AccessibilityRole.values().length];
                    try {
                        iArr[AccessibilityRole.BUTTON.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[AccessibilityRole.DROPDOWNLIST.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[AccessibilityRole.TOGGLEBUTTON.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[AccessibilityRole.SEARCH.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[AccessibilityRole.IMAGE.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[AccessibilityRole.IMAGEBUTTON.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[AccessibilityRole.KEYBOARDKEY.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[AccessibilityRole.TEXT.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr[AccessibilityRole.ADJUSTABLE.ordinal()] = 9;
                    } catch (NoSuchFieldError unused9) {
                    }
                    try {
                        iArr[AccessibilityRole.CHECKBOX.ordinal()] = 10;
                    } catch (NoSuchFieldError unused10) {
                    }
                    try {
                        iArr[AccessibilityRole.RADIO.ordinal()] = 11;
                    } catch (NoSuchFieldError unused11) {
                    }
                    try {
                        iArr[AccessibilityRole.SPINBUTTON.ordinal()] = 12;
                    } catch (NoSuchFieldError unused12) {
                    }
                    try {
                        iArr[AccessibilityRole.SWITCH.ordinal()] = 13;
                    } catch (NoSuchFieldError unused13) {
                    }
                    try {
                        iArr[AccessibilityRole.LIST.ordinal()] = 14;
                    } catch (NoSuchFieldError unused14) {
                    }
                    try {
                        iArr[AccessibilityRole.GRID.ordinal()] = 15;
                    } catch (NoSuchFieldError unused15) {
                    }
                    try {
                        iArr[AccessibilityRole.SCROLLVIEW.ordinal()] = 16;
                    } catch (NoSuchFieldError unused16) {
                    }
                    try {
                        iArr[AccessibilityRole.HORIZONTALSCROLLVIEW.ordinal()] = 17;
                    } catch (NoSuchFieldError unused17) {
                    }
                    try {
                        iArr[AccessibilityRole.PAGER.ordinal()] = 18;
                    } catch (NoSuchFieldError unused18) {
                    }
                    try {
                        iArr[AccessibilityRole.DRAWERLAYOUT.ordinal()] = 19;
                    } catch (NoSuchFieldError unused19) {
                    }
                    try {
                        iArr[AccessibilityRole.SLIDINGDRAWER.ordinal()] = 20;
                    } catch (NoSuchFieldError unused20) {
                    }
                    try {
                        iArr[AccessibilityRole.ICONMENU.ordinal()] = 21;
                    } catch (NoSuchFieldError unused21) {
                    }
                    try {
                        iArr[AccessibilityRole.VIEWGROUP.ordinal()] = 22;
                    } catch (NoSuchFieldError unused22) {
                    }
                    try {
                        iArr[AccessibilityRole.WEBVIEW.ordinal()] = 23;
                    } catch (NoSuchFieldError unused23) {
                    }
                    try {
                        iArr[AccessibilityRole.NONE.ordinal()] = 24;
                    } catch (NoSuchFieldError unused24) {
                    }
                    try {
                        iArr[AccessibilityRole.LINK.ordinal()] = 25;
                    } catch (NoSuchFieldError unused25) {
                    }
                    try {
                        iArr[AccessibilityRole.SUMMARY.ordinal()] = 26;
                    } catch (NoSuchFieldError unused26) {
                    }
                    try {
                        iArr[AccessibilityRole.HEADER.ordinal()] = 27;
                    } catch (NoSuchFieldError unused27) {
                    }
                    try {
                        iArr[AccessibilityRole.ALERT.ordinal()] = 28;
                    } catch (NoSuchFieldError unused28) {
                    }
                    try {
                        iArr[AccessibilityRole.COMBOBOX.ordinal()] = 29;
                    } catch (NoSuchFieldError unused29) {
                    }
                    try {
                        iArr[AccessibilityRole.MENU.ordinal()] = 30;
                    } catch (NoSuchFieldError unused30) {
                    }
                    try {
                        iArr[AccessibilityRole.MENUBAR.ordinal()] = 31;
                    } catch (NoSuchFieldError unused31) {
                    }
                    try {
                        iArr[AccessibilityRole.MENUITEM.ordinal()] = 32;
                    } catch (NoSuchFieldError unused32) {
                    }
                    try {
                        iArr[AccessibilityRole.PROGRESSBAR.ordinal()] = 33;
                    } catch (NoSuchFieldError unused33) {
                    }
                    try {
                        iArr[AccessibilityRole.RADIOGROUP.ordinal()] = 34;
                    } catch (NoSuchFieldError unused34) {
                    }
                    try {
                        iArr[AccessibilityRole.SCROLLBAR.ordinal()] = 35;
                    } catch (NoSuchFieldError unused35) {
                    }
                    try {
                        iArr[AccessibilityRole.TAB.ordinal()] = 36;
                    } catch (NoSuchFieldError unused36) {
                    }
                    try {
                        iArr[AccessibilityRole.TABLIST.ordinal()] = 37;
                    } catch (NoSuchFieldError unused37) {
                    }
                    try {
                        iArr[AccessibilityRole.TIMER.ordinal()] = 38;
                    } catch (NoSuchFieldError unused38) {
                    }
                    try {
                        iArr[AccessibilityRole.TOOLBAR.ordinal()] = 39;
                    } catch (NoSuchFieldError unused39) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                    int[] iArr2 = new int[Role.values().length];
                    try {
                        iArr2[Role.ALERT.ordinal()] = 1;
                    } catch (NoSuchFieldError unused40) {
                    }
                    try {
                        iArr2[Role.BUTTON.ordinal()] = 2;
                    } catch (NoSuchFieldError unused41) {
                    }
                    try {
                        iArr2[Role.CHECKBOX.ordinal()] = 3;
                    } catch (NoSuchFieldError unused42) {
                    }
                    try {
                        iArr2[Role.COMBOBOX.ordinal()] = 4;
                    } catch (NoSuchFieldError unused43) {
                    }
                    try {
                        iArr2[Role.GRID.ordinal()] = 5;
                    } catch (NoSuchFieldError unused44) {
                    }
                    try {
                        iArr2[Role.HEADING.ordinal()] = 6;
                    } catch (NoSuchFieldError unused45) {
                    }
                    try {
                        iArr2[Role.IMG.ordinal()] = 7;
                    } catch (NoSuchFieldError unused46) {
                    }
                    try {
                        iArr2[Role.LINK.ordinal()] = 8;
                    } catch (NoSuchFieldError unused47) {
                    }
                    try {
                        iArr2[Role.LIST.ordinal()] = 9;
                    } catch (NoSuchFieldError unused48) {
                    }
                    try {
                        iArr2[Role.MENU.ordinal()] = 10;
                    } catch (NoSuchFieldError unused49) {
                    }
                    try {
                        iArr2[Role.MENUBAR.ordinal()] = 11;
                    } catch (NoSuchFieldError unused50) {
                    }
                    try {
                        iArr2[Role.MENUITEM.ordinal()] = 12;
                    } catch (NoSuchFieldError unused51) {
                    }
                    try {
                        iArr2[Role.NONE.ordinal()] = 13;
                    } catch (NoSuchFieldError unused52) {
                    }
                    try {
                        iArr2[Role.PROGRESSBAR.ordinal()] = 14;
                    } catch (NoSuchFieldError unused53) {
                    }
                    try {
                        iArr2[Role.RADIO.ordinal()] = 15;
                    } catch (NoSuchFieldError unused54) {
                    }
                    try {
                        iArr2[Role.RADIOGROUP.ordinal()] = 16;
                    } catch (NoSuchFieldError unused55) {
                    }
                    try {
                        iArr2[Role.SCROLLBAR.ordinal()] = 17;
                    } catch (NoSuchFieldError unused56) {
                    }
                    try {
                        iArr2[Role.SEARCHBOX.ordinal()] = 18;
                    } catch (NoSuchFieldError unused57) {
                    }
                    try {
                        iArr2[Role.SLIDER.ordinal()] = 19;
                    } catch (NoSuchFieldError unused58) {
                    }
                    try {
                        iArr2[Role.SPINBUTTON.ordinal()] = 20;
                    } catch (NoSuchFieldError unused59) {
                    }
                    try {
                        iArr2[Role.SUMMARY.ordinal()] = 21;
                    } catch (NoSuchFieldError unused60) {
                    }
                    try {
                        iArr2[Role.SWITCH.ordinal()] = 22;
                    } catch (NoSuchFieldError unused61) {
                    }
                    try {
                        iArr2[Role.TAB.ordinal()] = 23;
                    } catch (NoSuchFieldError unused62) {
                    }
                    try {
                        iArr2[Role.TABLIST.ordinal()] = 24;
                    } catch (NoSuchFieldError unused63) {
                    }
                    try {
                        iArr2[Role.TIMER.ordinal()] = 25;
                    } catch (NoSuchFieldError unused64) {
                    }
                    try {
                        iArr2[Role.TOOLBAR.ordinal()] = 26;
                    } catch (NoSuchFieldError unused65) {
                    }
                    $EnumSwitchMapping$1 = iArr2;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String getValue(AccessibilityRole role) {
                Intrinsics.checkNotNullParameter(role, "role");
                switch (WhenMappings.$EnumSwitchMapping$0[role.ordinal()]) {
                    case 1:
                        return "android.widget.Button";
                    case 2:
                        return "android.widget.Spinner";
                    case 3:
                        return "android.widget.ToggleButton";
                    case 4:
                        return "android.widget.EditText";
                    case 5:
                        return "android.widget.ImageView";
                    case 6:
                        return "android.widget.ImageButton";
                    case 7:
                        return "android.inputmethodservice.Keyboard$Key";
                    case 8:
                        return "android.widget.TextView";
                    case 9:
                        return "android.widget.SeekBar";
                    case 10:
                        return "android.widget.CheckBox";
                    case BaseVideoCapturer.RGBA /* 11 */:
                        return "android.widget.RadioButton";
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                        return "android.widget.SpinButton";
                    case 13:
                        return "android.widget.Switch";
                    case 14:
                        return "android.widget.AbsListView";
                    case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        return "android.widget.GridView";
                    case 16:
                        return "android.widget.ScrollView";
                    case 17:
                        return "android.widget.HorizontalScrollView";
                    case 18:
                        return "androidx.viewpager.widget.ViewPager";
                    case 19:
                        return "androidx.drawerlayout.widget.DrawerLayout";
                    case 20:
                        return "android.widget.SlidingDrawer";
                    case 21:
                        return "com.android.internal.view.menu.IconMenuView";
                    case 22:
                        return "android.view.ViewGroup";
                    case 23:
                        return "android.webkit.WebView";
                    case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                    case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                        return "android.view.View";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }

            public final AccessibilityRole fromValue(String str) {
                if (str == null) {
                    return AccessibilityRole.NONE;
                }
                for (AccessibilityRole accessibilityRole : AccessibilityRole.getEntries()) {
                    if (StringsKt.equals(accessibilityRole.name(), str, true)) {
                        return accessibilityRole;
                    }
                }
                throw new IllegalArgumentException("Invalid accessibility role value: " + str);
            }

            public final AccessibilityRole fromRole(Role role) {
                Intrinsics.checkNotNullParameter(role, "role");
                switch (WhenMappings.$EnumSwitchMapping$1[role.ordinal()]) {
                    case 1:
                        return AccessibilityRole.ALERT;
                    case 2:
                        return AccessibilityRole.BUTTON;
                    case 3:
                        return AccessibilityRole.CHECKBOX;
                    case 4:
                        return AccessibilityRole.COMBOBOX;
                    case 5:
                        return AccessibilityRole.GRID;
                    case 6:
                        return AccessibilityRole.HEADER;
                    case 7:
                        return AccessibilityRole.IMAGE;
                    case 8:
                        return AccessibilityRole.LINK;
                    case 9:
                        return AccessibilityRole.LIST;
                    case 10:
                        return AccessibilityRole.MENU;
                    case BaseVideoCapturer.RGBA /* 11 */:
                        return AccessibilityRole.MENUBAR;
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                        return AccessibilityRole.MENUITEM;
                    case 13:
                        return AccessibilityRole.NONE;
                    case 14:
                        return AccessibilityRole.PROGRESSBAR;
                    case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        return AccessibilityRole.RADIO;
                    case 16:
                        return AccessibilityRole.RADIOGROUP;
                    case 17:
                        return AccessibilityRole.SCROLLBAR;
                    case 18:
                        return AccessibilityRole.SEARCH;
                    case 19:
                        return AccessibilityRole.ADJUSTABLE;
                    case 20:
                        return AccessibilityRole.SPINBUTTON;
                    case 21:
                        return AccessibilityRole.SUMMARY;
                    case 22:
                        return AccessibilityRole.SWITCH;
                    case 23:
                        return AccessibilityRole.TAB;
                    case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                        return AccessibilityRole.TABLIST;
                    case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                        return AccessibilityRole.TIMER;
                    case 26:
                        return AccessibilityRole.TOOLBAR;
                    default:
                        return null;
                }
            }

            public final AccessibilityRole fromViewTag(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                Role role = (Role) view.getTag(R$id.role);
                if (role != null) {
                    return fromRole(role);
                }
                return (AccessibilityRole) view.getTag(R$id.accessibility_role);
            }
        }
    }

    public static final class Companion {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AccessibilityRole.values().length];
                try {
                    iArr[AccessibilityRole.LINK.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AccessibilityRole.IMAGE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AccessibilityRole.IMAGEBUTTON.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AccessibilityRole.BUTTON.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AccessibilityRole.TOGGLEBUTTON.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AccessibilityRole.SUMMARY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AccessibilityRole.HEADER.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[AccessibilityRole.ALERT.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[AccessibilityRole.COMBOBOX.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[AccessibilityRole.MENU.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[AccessibilityRole.MENUBAR.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[AccessibilityRole.MENUITEM.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[AccessibilityRole.PROGRESSBAR.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[AccessibilityRole.RADIOGROUP.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr[AccessibilityRole.SCROLLBAR.ordinal()] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    iArr[AccessibilityRole.SPINBUTTON.ordinal()] = 16;
                } catch (NoSuchFieldError unused16) {
                }
                try {
                    iArr[AccessibilityRole.TAB.ordinal()] = 17;
                } catch (NoSuchFieldError unused17) {
                }
                try {
                    iArr[AccessibilityRole.TABLIST.ordinal()] = 18;
                } catch (NoSuchFieldError unused18) {
                }
                try {
                    iArr[AccessibilityRole.TIMER.ordinal()] = 19;
                } catch (NoSuchFieldError unused19) {
                }
                try {
                    iArr[AccessibilityRole.TOOLBAR.ordinal()] = 20;
                } catch (NoSuchFieldError unused20) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setDelegate(View view, boolean z, int i) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (ViewCompat.hasAccessibilityDelegate(view)) {
                return;
            }
            if (view.getTag(R$id.accessibility_role) == null && view.getTag(R$id.accessibility_state) == null && view.getTag(R$id.accessibility_actions) == null && view.getTag(R$id.react_test_id) == null && view.getTag(R$id.accessibility_collection_item) == null && view.getTag(R$id.accessibility_links) == null && view.getTag(R$id.role) == null) {
                return;
            }
            ViewCompat.setAccessibilityDelegate(view, new ReactAccessibilityDelegate(view, z, i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setState(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ReadableMap readableMap) {
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                Dynamic dynamic = readableMap.getDynamic(strNextKey);
                if (Intrinsics.areEqual(strNextKey, "selected") && dynamic.getType() == ReadableType.Boolean) {
                    accessibilityNodeInfoCompat.setSelected(dynamic.asBoolean());
                } else if (Intrinsics.areEqual(strNextKey, "disabled") && dynamic.getType() == ReadableType.Boolean) {
                    accessibilityNodeInfoCompat.setEnabled(!dynamic.asBoolean());
                } else if (Intrinsics.areEqual(strNextKey, "checked") && dynamic.getType() == ReadableType.Boolean) {
                    boolean zAsBoolean = dynamic.asBoolean();
                    accessibilityNodeInfoCompat.setCheckable(true);
                    accessibilityNodeInfoCompat.setChecked(zAsBoolean);
                }
            }
        }

        public final void setRole(AccessibilityNodeInfoCompat nodeInfo, AccessibilityRole accessibilityRole, Context context) {
            Intrinsics.checkNotNullParameter(nodeInfo, "nodeInfo");
            Intrinsics.checkNotNullParameter(context, "context");
            if (accessibilityRole == null) {
                accessibilityRole = AccessibilityRole.NONE;
            }
            nodeInfo.setClassName(AccessibilityRole.Companion.getValue(accessibilityRole));
            switch (WhenMappings.$EnumSwitchMapping$0[accessibilityRole.ordinal()]) {
                case 1:
                    nodeInfo.setRoleDescription(context.getString(R$string.link_description));
                    break;
                case 2:
                    nodeInfo.setRoleDescription(context.getString(R$string.image_description));
                    break;
                case 3:
                    nodeInfo.setRoleDescription(context.getString(R$string.imagebutton_description));
                    nodeInfo.setClickable(true);
                    break;
                case 4:
                    nodeInfo.setClickable(true);
                    break;
                case 5:
                    nodeInfo.setClickable(true);
                    nodeInfo.setCheckable(true);
                    break;
                case 6:
                    nodeInfo.setRoleDescription(context.getString(R$string.summary_description));
                    break;
                case 7:
                    nodeInfo.setHeading(true);
                    break;
                case 8:
                    nodeInfo.setRoleDescription(context.getString(R$string.alert_description));
                    break;
                case 9:
                    nodeInfo.setRoleDescription(context.getString(R$string.combobox_description));
                    break;
                case 10:
                    nodeInfo.setRoleDescription(context.getString(R$string.menu_description));
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    nodeInfo.setRoleDescription(context.getString(R$string.menubar_description));
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    nodeInfo.setRoleDescription(context.getString(R$string.menuitem_description));
                    break;
                case 13:
                    nodeInfo.setRoleDescription(context.getString(R$string.progressbar_description));
                    break;
                case 14:
                    nodeInfo.setRoleDescription(context.getString(R$string.radiogroup_description));
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    nodeInfo.setRoleDescription(context.getString(R$string.scrollbar_description));
                    break;
                case 16:
                    nodeInfo.setRoleDescription(context.getString(R$string.spinbutton_description));
                    break;
                case 17:
                    nodeInfo.setRoleDescription(context.getString(R$string.rn_tab_description));
                    break;
                case 18:
                    nodeInfo.setRoleDescription(context.getString(R$string.tablist_description));
                    break;
                case 19:
                    nodeInfo.setRoleDescription(context.getString(R$string.timer_description));
                    break;
                case 20:
                    nodeInfo.setRoleDescription(context.getString(R$string.toolbar_description));
                    break;
            }
        }

        public final boolean hasNonActionableSpeakingDescendants(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
            if (accessibilityNodeInfoCompat != null && view != null && (view instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain();
                        ViewCompat.onInitializeAccessibilityNodeInfo(childAt, accessibilityNodeInfoCompatObtain);
                        if (accessibilityNodeInfoCompatObtain.isVisibleToUser() && !isAccessibilityFocusable(accessibilityNodeInfoCompatObtain, childAt) && isSpeakingNode(accessibilityNodeInfoCompatObtain, childAt)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public final boolean hasValidRangeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat.RangeInfoCompat rangeInfo;
            if (accessibilityNodeInfoCompat == null || (rangeInfo = accessibilityNodeInfoCompat.getRangeInfo()) == null) {
                return false;
            }
            float max = rangeInfo.getMax();
            float min = rangeInfo.getMin();
            float current = rangeInfo.getCurrent();
            return max - min > 0.0f && current >= min && current <= max;
        }

        private final boolean hasStateDescription(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (accessibilityNodeInfoCompat == null) {
                return false;
            }
            CharSequence stateDescription = accessibilityNodeInfoCompat.getStateDescription();
            return !(stateDescription == null || stateDescription.length() == 0) || accessibilityNodeInfoCompat.isCheckable() || hasValidRangeInfo(accessibilityNodeInfoCompat);
        }

        public final boolean isSpeakingNode(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
            int importantForAccessibility;
            if (accessibilityNodeInfoCompat == null || view == null || (importantForAccessibility = ViewCompat.getImportantForAccessibility(view)) == 4 || (importantForAccessibility == 2 && accessibilityNodeInfoCompat.getChildCount() <= 0)) {
                return false;
            }
            return hasText(accessibilityNodeInfoCompat) || hasStateDescription(accessibilityNodeInfoCompat) || accessibilityNodeInfoCompat.isCheckable() || hasNonActionableSpeakingDescendants(accessibilityNodeInfoCompat, view);
        }

        public final boolean hasText(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (accessibilityNodeInfoCompat == null || accessibilityNodeInfoCompat.getCollectionInfo() != null) {
                return false;
            }
            CharSequence text = accessibilityNodeInfoCompat.getText();
            if (text != null && text.length() != 0) {
                return true;
            }
            CharSequence contentDescription = accessibilityNodeInfoCompat.getContentDescription();
            if (contentDescription != null && contentDescription.length() != 0) {
                return true;
            }
            CharSequence hintText = accessibilityNodeInfoCompat.getHintText();
            return (hintText == null || hintText.length() == 0) ? false : true;
        }

        public final boolean isAccessibilityFocusable(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
            if (accessibilityNodeInfoCompat == null || view == null || !accessibilityNodeInfoCompat.isVisibleToUser()) {
                return false;
            }
            return accessibilityNodeInfoCompat.isScreenReaderFocusable() || isActionableForAccessibility(accessibilityNodeInfoCompat);
        }

        public final boolean isActionableForAccessibility(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (accessibilityNodeInfoCompat == null) {
                return false;
            }
            if (accessibilityNodeInfoCompat.isClickable() || accessibilityNodeInfoCompat.isLongClickable() || accessibilityNodeInfoCompat.isFocusable()) {
                return true;
            }
            List actionList = accessibilityNodeInfoCompat.getActionList();
            Intrinsics.checkNotNullExpressionValue(actionList, "getActionList(...)");
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> list = actionList;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            for (AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat : list) {
                if (Intrinsics.areEqual(accessibilityActionCompat, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK) || Intrinsics.areEqual(accessibilityActionCompat, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_LONG_CLICK) || Intrinsics.areEqual(accessibilityActionCompat, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS)) {
                    return true;
                }
            }
            return false;
        }

        public final AccessibilityNodeInfoCompat createNodeInfoFromView(View view) {
            if (view == null) {
                return null;
            }
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain();
            try {
                ViewCompat.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompatObtain);
                return accessibilityNodeInfoCompatObtain;
            } catch (NullPointerException unused) {
                return null;
            }
        }

        public final CharSequence getTalkbackDescription(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain;
            Intrinsics.checkNotNullParameter(view, "view");
            if (accessibilityNodeInfoCompat == null) {
                accessibilityNodeInfoCompatObtain = createNodeInfoFromView(view);
            } else {
                accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            }
            if (accessibilityNodeInfoCompatObtain == null) {
                return null;
            }
            CharSequence contentDescription = accessibilityNodeInfoCompatObtain.getContentDescription();
            CharSequence text = accessibilityNodeInfoCompatObtain.getText();
            boolean z = text == null || text.length() == 0;
            boolean z2 = view instanceof EditText;
            StringBuilder sb = new StringBuilder();
            if (contentDescription != null && contentDescription.length() != 0 && (!z2 || z)) {
                sb.append(contentDescription);
                return sb;
            }
            if (!z) {
                sb.append(text);
                return sb;
            }
            if (!(view instanceof ViewGroup)) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain2 = AccessibilityNodeInfoCompat.obtain();
                ViewCompat.onInitializeAccessibilityNodeInfo(childAt, accessibilityNodeInfoCompatObtain2);
                if (isSpeakingNode(accessibilityNodeInfoCompatObtain2, childAt) && !isAccessibilityFocusable(accessibilityNodeInfoCompatObtain2, childAt)) {
                    Intrinsics.checkNotNull(childAt);
                    CharSequence talkbackDescription = getTalkbackDescription(childAt, null);
                    if (talkbackDescription != null && talkbackDescription.length() != 0) {
                        sb2.append(((Object) talkbackDescription) + ", ");
                    }
                }
            }
            return removeFinalDelimiter(sb2);
        }

        private final String removeFinalDelimiter(StringBuilder sb) {
            int length = sb.length();
            if (length > 0) {
                sb.delete(length - 2, length);
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }
}
