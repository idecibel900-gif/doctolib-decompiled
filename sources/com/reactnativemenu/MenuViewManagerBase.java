package com.reactnativemenu;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.views.view.ReactClippingViewManager;
import com.facebook.react.views.view.ReactDrawableHelper;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.yoga.YogaConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\b&\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0007J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000eH\u0007J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0007J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J \u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0007J\u001c\u0010$\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010&\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\n\b\u0001\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u001c\u0010)\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\n\b\u0001\u0010*\u001a\u0004\u0018\u00010(H\u0007J\u001c\u0010+\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\n\b\u0001\u0010,\u001a\u0004\u0018\u00010(H\u0007J\u0018\u0010-\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u000eH\u0007J \u0010/\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001b2\u0006\u00100\u001a\u00020#H\u0007J'\u00101\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001b2\b\u00102\u001a\u0004\u0018\u00010\u001bH'¢\u0006\u0002\u00103J\u001a\u00104\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\b\u00105\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u00106\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0006H\u0007J\u001a\u00108\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00022\u0006\u00109\u001a\u00020#H\u0016J\u001e\u0010:\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00022\n\b\u0001\u0010;\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0012H\u0016J\"\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u001b2\b\u0010@\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006B"}, d2 = {"Lcom/reactnativemenu/MenuViewManagerBase;", "Lcom/facebook/react/views/view/ReactClippingViewManager;", "Lcom/reactnativemenu/MenuView;", "<init>", "()V", "getName", "", "setActions", "", "view", "actions", "Lcom/facebook/react/bridge/ReadableArray;", "setIsAnchoredToRight", "isAnchoredToRight", "", "setIsOnLongPress", "isOnLongPress", "getExportedCustomDirectEventTypeConstants", "", "", "setAccessible", "accessible", "setTVPreferredFocus", "Lcom/facebook/react/views/view/ReactViewGroup;", "hasTVPreferredFocus", "nextFocusDown", "viewId", "", "nextFocusForward", "nextFocusLeft", "nextFocusRight", "nextFocusUp", "setBorderRadius", "index", "borderRadius", "", "setBorderStyle", "borderStyle", "setHitSlop", "hitSlop", "Lcom/facebook/react/bridge/ReadableMap;", "setNativeBackground", "bg", "setNativeForeground", "fg", "setNeedsOffscreenAlphaCompositing", "needsOffscreenAlphaCompositing", "setBorderWidth", "width", "setBorderColor", "color", "(Lcom/facebook/react/views/view/ReactViewGroup;ILjava/lang/Integer;)V", "setOverflow", "overflow", "setBackfaceVisibility", "backfaceVisibility", "setOpacity", "opacity", "setTransform", "matrix", "getCommandsMap", "receiveCommand", "root", "commandId", "args", "Companion", "react-native-menu_menu_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class MenuViewManagerBase extends ReactClippingViewManager<MenuView> {
    private static final int COMMAND_SHOW = 1;
    private static final Integer[] SPACING_TYPES = {8, 0, 2, 1, 3, 4, 5};

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor", "borderStartColor", "borderEndColor"})
    public abstract void setBorderColor(ReactViewGroup view, int index, Integer color);

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "MenuView";
    }

    @ReactProp(name = "actions")
    public final void setActions(MenuView view, ReadableArray actions) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(actions, "actions");
        view.setActions(actions);
    }

    @ReactProp(defaultBoolean = false, name = "isAnchoredToRight")
    public final void setIsAnchoredToRight(MenuView view, boolean isAnchoredToRight) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setIsAnchoredToRight(isAnchoredToRight);
    }

    @ReactProp(defaultBoolean = false, name = "shouldOpenOnLongPress")
    public final void setIsOnLongPress(MenuView view, boolean isOnLongPress) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setIsOpenOnLongPress(isOnLongPress);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onPressAction", MapBuilder.of("registrationName", "onPressAction"), "onCloseMenu", MapBuilder.of("registrationName", "onCloseMenu"), "onOpenMenu", MapBuilder.of("registrationName", "onOpenMenu"));
    }

    @ReactProp(name = "accessible")
    public final void setAccessible(MenuView view, boolean accessible) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFocusable(accessible);
    }

    @ReactProp(name = "hasTVPreferredFocus")
    public final void setTVPreferredFocus(ReactViewGroup view, boolean hasTVPreferredFocus) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (hasTVPreferredFocus) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        }
    }

    @ReactProp(defaultInt = -1, name = "nextFocusDown")
    public final void nextFocusDown(ReactViewGroup view, int viewId) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusDownId(viewId);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusForward")
    public final void nextFocusForward(ReactViewGroup view, int viewId) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusForwardId(viewId);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusLeft")
    public final void nextFocusLeft(ReactViewGroup view, int viewId) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusLeftId(viewId);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusRight")
    public final void nextFocusRight(ReactViewGroup view, int viewId) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusRightId(viewId);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusUp")
    public final void nextFocusUp(ReactViewGroup view, int viewId) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusUpId(viewId);
    }

    @ReactPropGroup(names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius", "borderTopStartRadius", "borderTopEndRadius", "borderBottomStartRadius", "borderBottomEndRadius"})
    public final void setBorderRadius(ReactViewGroup view, int index, float borderRadius) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!YogaConstants.isUndefined(borderRadius) && borderRadius < 0.0f) {
            borderRadius = YogaConstants.UNDEFINED;
        }
        if (!YogaConstants.isUndefined(borderRadius)) {
            borderRadius = PixelUtil.toPixelFromDIP(borderRadius);
        }
        if (index == 0) {
            view.setBorderRadius(borderRadius);
        } else {
            view.setBorderRadius(borderRadius, index - 1);
        }
    }

    @ReactProp(name = "borderStyle")
    public final void setBorderStyle(ReactViewGroup view, String borderStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderStyle(borderStyle);
    }

    @ReactProp(name = "hitSlop")
    public final void setHitSlop(ReactViewGroup view, ReadableMap hitSlop) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (hitSlop == null) {
            view.setHitSlopRect(null);
        } else {
            view.setHitSlopRect(new Rect(hitSlop.hasKey("left") ? (int) PixelUtil.toPixelFromDIP(hitSlop.getDouble("left")) : 0, hitSlop.hasKey("top") ? (int) PixelUtil.toPixelFromDIP(hitSlop.getDouble("top")) : 0, hitSlop.hasKey("right") ? (int) PixelUtil.toPixelFromDIP(hitSlop.getDouble("right")) : 0, hitSlop.hasKey("bottom") ? (int) PixelUtil.toPixelFromDIP(hitSlop.getDouble("bottom")) : 0));
        }
    }

    @ReactProp(name = "nativeBackgroundAndroid")
    public final void setNativeBackground(ReactViewGroup view, ReadableMap bg) {
        Drawable drawableCreateDrawableFromJSDescription;
        Intrinsics.checkNotNullParameter(view, "view");
        if (bg == null) {
            drawableCreateDrawableFromJSDescription = null;
        } else {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            drawableCreateDrawableFromJSDescription = ReactDrawableHelper.createDrawableFromJSDescription(context, bg);
        }
        view.setTranslucentBackgroundDrawable(drawableCreateDrawableFromJSDescription);
    }

    @ReactProp(name = "nativeForegroundAndroid")
    @TargetApi(23)
    public final void setNativeForeground(ReactViewGroup view, ReadableMap fg) {
        Drawable drawableCreateDrawableFromJSDescription;
        Intrinsics.checkNotNullParameter(view, "view");
        if (fg == null) {
            drawableCreateDrawableFromJSDescription = null;
        } else {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            drawableCreateDrawableFromJSDescription = ReactDrawableHelper.createDrawableFromJSDescription(context, fg);
        }
        view.setForeground(drawableCreateDrawableFromJSDescription);
    }

    @ReactProp(name = "needsOffscreenAlphaCompositing")
    public final void setNeedsOffscreenAlphaCompositing(ReactViewGroup view, boolean needsOffscreenAlphaCompositing) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNeedsOffscreenAlphaCompositing(needsOffscreenAlphaCompositing);
    }

    @ReactPropGroup(names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth", "borderStartWidth", "borderEndWidth"})
    public final void setBorderWidth(ReactViewGroup view, int index, float width) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!YogaConstants.isUndefined(width) && width < 0.0f) {
            width = YogaConstants.UNDEFINED;
        }
        if (!YogaConstants.isUndefined(width)) {
            width = PixelUtil.toPixelFromDIP(width);
        }
        view.setBorderWidth(SPACING_TYPES[index].intValue(), width);
    }

    @ReactProp(name = "overflow")
    public final void setOverflow(ReactViewGroup view, String overflow) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOverflow(overflow);
    }

    @ReactProp(name = "backfaceVisibility")
    public final void setBackfaceVisibility(ReactViewGroup view, String backfaceVisibility) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(backfaceVisibility, "backfaceVisibility");
        view.setBackfaceVisibility(backfaceVisibility);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setOpacity(MenuView view, float opacity) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOpacityIfPossible(opacity);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setTransform(MenuView view, ReadableArray matrix) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setTransform(view, matrix);
        view.setBackfaceVisibilityDependantOpacity();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("show", Integer.valueOf(COMMAND_SHOW));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(MenuView root, int commandId, ReadableArray args) {
        Intrinsics.checkNotNullParameter(root, "root");
        if (commandId == COMMAND_SHOW) {
            root.show();
        }
    }
}
