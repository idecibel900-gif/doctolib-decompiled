package com.facebook.react.uimanager;

import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.R$id;
import com.facebook.react.R$string;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.BlurEvent;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.FocusEvent;
import com.facebook.react.uimanager.events.PointerEventHelper;
import com.facebook.react.uimanager.style.OutlineStyle;
import com.facebook.react.uimanager.util.ReactFindViewUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseViewManager<T extends View, C extends LayoutShadowNode> extends ViewManager<T, C> implements View.OnLayoutChangeListener {
    private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    private static final String STATE_BUSY = "busy";
    private static final String STATE_CHECKED = "checked";
    private static final String STATE_EXPANDED = "expanded";
    private static final String STATE_MIXED = "mixed";
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = (float) Math.sqrt(5.0d);
    private static final MatrixMathHelper.MatrixDecompositionContext sMatrixDecompositionContext = new MatrixMathHelper.MatrixDecompositionContext();
    private static final double[] sTransformDecompositionArray = new double[16];

    @ReactProp(name = "onMoveShouldSetResponder")
    public void setMoveShouldSetResponder(T t, boolean z) {
    }

    @ReactProp(name = "onMoveShouldSetResponderCapture")
    public void setMoveShouldSetResponderCapture(T t, boolean z) {
    }

    @ReactProp(name = "onResponderEnd")
    public void setResponderEnd(T t, boolean z) {
    }

    @ReactProp(name = "onResponderGrant")
    public void setResponderGrant(T t, boolean z) {
    }

    @ReactProp(name = "onResponderMove")
    public void setResponderMove(T t, boolean z) {
    }

    @ReactProp(name = "onResponderReject")
    public void setResponderReject(T t, boolean z) {
    }

    @ReactProp(name = "onResponderRelease")
    public void setResponderRelease(T t, boolean z) {
    }

    @ReactProp(name = "onResponderStart")
    public void setResponderStart(T t, boolean z) {
    }

    @ReactProp(name = "onResponderTerminate")
    public void setResponderTerminate(T t, boolean z) {
    }

    @ReactProp(name = "onResponderTerminationRequest")
    public void setResponderTerminationRequest(T t, boolean z) {
    }

    @ReactProp(name = "onShouldBlockNativeResponder")
    public void setShouldBlockNativeResponder(T t, boolean z) {
    }

    @ReactProp(name = "onStartShouldSetResponder")
    public void setStartShouldSetResponder(T t, boolean z) {
    }

    @ReactProp(name = "onStartShouldSetResponderCapture")
    public void setStartShouldSetResponderCapture(T t, boolean z) {
    }

    @ReactProp(name = "onTouchCancel")
    public void setTouchCancel(T t, boolean z) {
    }

    @ReactProp(name = "onTouchEnd")
    public void setTouchEnd(T t, boolean z) {
    }

    @ReactProp(name = "onTouchMove")
    public void setTouchMove(T t, boolean z) {
    }

    @ReactProp(name = "onTouchStart")
    public void setTouchStart(T t, boolean z) {
    }

    public BaseViewManager() {
        super(null);
    }

    public BaseViewManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected T prepareToRecycleView(ThemedReactContext themedReactContext, T t) {
        t.setTag(null);
        t.setTag(R$id.pointer_events, null);
        t.setTag(R$id.react_test_id, null);
        t.setTag(R$id.view_tag_native_id, null);
        t.setTag(R$id.labelled_by, null);
        t.setTag(R$id.accessibility_label, null);
        t.setTag(R$id.accessibility_hint, null);
        t.setTag(R$id.accessibility_role, null);
        t.setTag(R$id.accessibility_state, null);
        t.setTag(R$id.accessibility_actions, null);
        t.setTag(R$id.accessibility_value, null);
        t.setTag(R$id.accessibility_state_expanded, null);
        t.setTag(R$id.view_clipped, null);
        setTransformProperty(t, null, null);
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            return null;
        }
        t.resetPivot();
        t.setTop(0);
        t.setBottom(0);
        t.setLeft(0);
        t.setRight(0);
        t.setElevation(0.0f);
        if (i >= 29) {
            t.setAnimationMatrix(null);
        }
        t.setTag(R$id.transform, null);
        t.setTag(R$id.transform_origin, null);
        t.setTag(R$id.invalidate_transform, null);
        t.removeOnLayoutChangeListener(this);
        t.setTag(R$id.use_hardware_layer, null);
        t.setTag(R$id.filter, null);
        t.setTag(R$id.mix_blend_mode, null);
        LayerEffectsHelper.apply(t, null, null);
        if (i >= 28) {
            t.setOutlineAmbientShadowColor(-16777216);
            t.setOutlineSpotShadowColor(-16777216);
        }
        t.setNextFocusDownId(-1);
        t.setNextFocusForwardId(-1);
        t.setNextFocusRightId(-1);
        t.setNextFocusUpId(-1);
        t.setFocusable(false);
        t.setFocusableInTouchMode(false);
        t.setElevation(0.0f);
        t.setAlpha(1.0f);
        setPadding(t, 0, 0, 0, 0);
        t.setForeground(null);
        return t;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected void addEventEmitters(ThemedReactContext themedReactContext, T t) {
        super.addEventEmitters(themedReactContext, t);
        new BaseVMFocusChangeListener(t.getOnFocusChangeListener()).attach(t);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(T t) {
        super.onDropViewInstance(t);
        View.OnFocusChangeListener onFocusChangeListener = t.getOnFocusChangeListener();
        if (onFocusChangeListener instanceof BaseVMFocusChangeListener) {
            ((BaseVMFocusChangeListener) onFocusChangeListener).detach(t);
        }
        if (t instanceof ViewGroup) {
            ((ViewGroup) t).setOnHierarchyChangeListener(null);
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i7 - i5;
        int i10 = i3 - i;
        if (i4 - i2 == i8 - i6 && i10 == i9) {
            return;
        }
        ReadableArray readableArray = (ReadableArray) view.getTag(R$id.transform_origin);
        ReadableArray readableArray2 = (ReadableArray) view.getTag(R$id.transform);
        if (readableArray2 == null && readableArray == null) {
            return;
        }
        setTransformProperty(view, readableArray2, readableArray);
    }

    @ReactProp(customType = "Color", defaultInt = 0, name = "backgroundColor")
    public void setBackgroundColor(T t, int i) {
        BackgroundStyleApplicator.setBackgroundColor(t, Integer.valueOf(i));
    }

    @ReactProp(customType = "Filter", name = "filter")
    public void setFilter(T t, ReadableArray readableArray) {
        if (ViewUtil.getUIManagerType(t) == 2) {
            t.setTag(R$id.filter, readableArray);
        }
    }

    @ReactProp(name = "mixBlendMode")
    public void setMixBlendMode(T t, String str) {
        if (ViewUtil.getUIManagerType(t) == 2) {
            t.setTag(R$id.mix_blend_mode, BlendModeHelper.parseMixBlendMode(str));
            if (t.getParent() instanceof View) {
                ((View) t.getParent()).invalidate();
            }
        }
    }

    @ReactProp(name = "transform")
    public void setTransform(T t, ReadableArray readableArray) {
        if (Objects.equals((ReadableArray) t.getTag(R$id.transform), readableArray)) {
            return;
        }
        t.setTag(R$id.transform, readableArray);
        t.setTag(R$id.invalidate_transform, Boolean.TRUE);
    }

    @ReactProp(name = "transformOrigin")
    public void setTransformOrigin(T t, ReadableArray readableArray) {
        if (Objects.equals((ReadableArray) t.getTag(R$id.transform_origin), readableArray)) {
            return;
        }
        t.setTag(R$id.transform_origin, readableArray);
        t.setTag(R$id.invalidate_transform, Boolean.TRUE);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(T t, float f) {
        t.setAlpha(f);
    }

    @ReactProp(name = "elevation")
    public void setElevation(T t, float f) {
        ViewCompat.setElevation(t, PixelUtil.toPixelFromDIP(f));
    }

    @ReactProp(customType = "Color", defaultInt = -16777216, name = "shadowColor")
    public void setShadowColor(T t, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            t.setOutlineAmbientShadowColor(i);
            t.setOutlineSpotShadowColor(i);
        }
    }

    @ReactProp(name = "zIndex")
    public void setZIndex(T t, float f) {
        ViewGroupManager.setViewZIndex(t, Math.round(f));
        ViewParent parent = t.getParent();
        if (parent instanceof ReactZIndexedViewGroup) {
            ((ReactZIndexedViewGroup) parent).updateDrawingOrder();
        }
    }

    @ReactProp(name = "renderToHardwareTextureAndroid")
    public void setRenderToHardwareTexture(T t, boolean z) {
        t.setTag(R$id.use_hardware_layer, Boolean.valueOf(z));
    }

    @ReactProp(name = "testID")
    public void setTestId(T t, String str) {
        t.setTag(R$id.react_test_id, str);
        t.setTag(str);
    }

    @ReactProp(name = "nativeID")
    public void setNativeId(T t, String str) {
        t.setTag(R$id.view_tag_native_id, str);
        ReactFindViewUtil.notifyViewRendered(t);
    }

    @ReactProp(name = "accessibilityLabelledBy")
    public void setAccessibilityLabelledBy(T t, Dynamic dynamic) {
        if (dynamic.isNull()) {
            return;
        }
        if (dynamic.getType() == ReadableType.String) {
            t.setTag(R$id.labelled_by, dynamic.asString());
        } else if (dynamic.getType() == ReadableType.Array) {
            t.setTag(R$id.labelled_by, dynamic.asArray().getString(0));
        }
    }

    @ReactProp(name = "accessibilityLabel")
    public void setAccessibilityLabel(T t, String str) {
        t.setTag(R$id.accessibility_label, str);
        updateViewContentDescription(t);
    }

    @ReactProp(name = "accessibilityHint")
    public void setAccessibilityHint(T t, String str) {
        t.setTag(R$id.accessibility_hint, str);
        updateViewContentDescription(t);
    }

    @ReactProp(name = "accessibilityRole")
    public void setAccessibilityRole(T t, String str) {
        if (str == null) {
            t.setTag(R$id.accessibility_role, null);
        } else {
            t.setTag(R$id.accessibility_role, ReactAccessibilityDelegate.AccessibilityRole.fromValue(str));
        }
    }

    @ReactProp(name = "accessibilityCollection")
    public void setAccessibilityCollection(T t, ReadableMap readableMap) {
        t.setTag(R$id.accessibility_collection, readableMap);
    }

    @ReactProp(name = "accessibilityCollectionItem")
    public void setAccessibilityCollectionItem(T t, ReadableMap readableMap) {
        t.setTag(R$id.accessibility_collection_item, readableMap);
    }

    @ReactProp(name = "accessibilityState")
    public void setViewState(T t, ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        if (readableMap.hasKey(STATE_EXPANDED)) {
            t.setTag(R$id.accessibility_state_expanded, Boolean.valueOf(readableMap.getBoolean(STATE_EXPANDED)));
        }
        if (readableMap.hasKey("selected")) {
            boolean zIsSelected = t.isSelected();
            boolean z = readableMap.getBoolean("selected");
            t.setSelected(z);
            if (t.isAccessibilityFocused() && zIsSelected && !z) {
                t.announceForAccessibility(t.getContext().getString(R$string.state_unselected_description));
            }
        } else {
            t.setSelected(false);
        }
        t.setTag(R$id.accessibility_state, readableMap);
        if (readableMap.hasKey("disabled") && !readableMap.getBoolean("disabled")) {
            t.setEnabled(true);
        }
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            if (strNextKey.equals(STATE_BUSY) || strNextKey.equals(STATE_EXPANDED) || (strNextKey.equals(STATE_CHECKED) && readableMap.getType(STATE_CHECKED) == ReadableType.String)) {
                updateViewContentDescription(t);
                return;
            } else if (t.isAccessibilityFocused()) {
                t.sendAccessibilityEvent(1);
            }
        }
    }

    private void updateViewContentDescription(T t) {
        Dynamic dynamic;
        String str = (String) t.getTag(R$id.accessibility_label);
        ReadableMap readableMap = (ReadableMap) t.getTag(R$id.accessibility_state);
        ArrayList arrayList = new ArrayList();
        ReadableMap readableMap2 = (ReadableMap) t.getTag(R$id.accessibility_value);
        if (str != null) {
            arrayList.add(str);
        }
        if (readableMap != null) {
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                Dynamic dynamic2 = readableMap.getDynamic(strNextKey);
                if (strNextKey.equals(STATE_CHECKED) && dynamic2.getType() == ReadableType.String && dynamic2.asString().equals(STATE_MIXED)) {
                    arrayList.add(t.getContext().getString(R$string.state_mixed_description));
                } else if (strNextKey.equals(STATE_BUSY) && dynamic2.getType() == ReadableType.Boolean && dynamic2.asBoolean()) {
                    arrayList.add(t.getContext().getString(R$string.state_busy_description));
                }
            }
        }
        if (readableMap2 != null && readableMap2.hasKey("text") && (dynamic = readableMap2.getDynamic("text")) != null && dynamic.getType() == ReadableType.String) {
            arrayList.add(dynamic.asString());
        }
        if (arrayList.isEmpty()) {
            return;
        }
        t.setContentDescription(TextUtils.join(", ", arrayList));
    }

    @ReactProp(name = "accessibilityActions")
    public void setAccessibilityActions(T t, ReadableArray readableArray) {
        if (readableArray == null) {
            return;
        }
        t.setTag(R$id.accessibility_actions, readableArray);
    }

    @ReactProp(name = "accessibilityValue")
    public void setAccessibilityValue(T t, ReadableMap readableMap) {
        if (readableMap == null) {
            t.setTag(R$id.accessibility_value, null);
            t.setContentDescription(null);
        } else {
            t.setTag(R$id.accessibility_value, readableMap);
            if (readableMap.hasKey("text")) {
                updateViewContentDescription(t);
            }
        }
    }

    @ReactProp(name = "importantForAccessibility")
    public void setImportantForAccessibility(T t, String str) {
        if (str == null || str.equals("auto")) {
            ViewCompat.setImportantForAccessibility(t, 0);
            return;
        }
        if (str.equals("yes")) {
            ViewCompat.setImportantForAccessibility(t, 1);
        } else if (str.equals("no")) {
            ViewCompat.setImportantForAccessibility(t, 2);
        } else if (str.equals("no-hide-descendants")) {
            ViewCompat.setImportantForAccessibility(t, 4);
        }
    }

    @ReactProp(name = "screenReaderFocusable")
    public void setScreenReaderFocusable(T t, boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            t.setScreenReaderFocusable(z);
        }
    }

    @ReactProp(name = "role")
    public void setRole(T t, String str) {
        if (str == null) {
            t.setTag(R$id.role, null);
        } else {
            t.setTag(R$id.role, ReactAccessibilityDelegate.Role.fromValue(str));
        }
    }

    @ReactProp(name = "rotation")
    @Deprecated
    public void setRotation(T t, float f) {
        t.setRotation(f);
    }

    @ReactProp(defaultFloat = 1.0f, name = "scaleX")
    @Deprecated
    public void setScaleX(T t, float f) {
        t.setScaleX(f);
    }

    @ReactProp(defaultFloat = 1.0f, name = "scaleY")
    @Deprecated
    public void setScaleY(T t, float f) {
        t.setScaleY(f);
    }

    @ReactProp(defaultFloat = 0.0f, name = "translateX")
    @Deprecated
    public void setTranslateX(T t, float f) {
        t.setTranslationX(PixelUtil.toPixelFromDIP(f));
    }

    @ReactProp(defaultFloat = 0.0f, name = "translateY")
    @Deprecated
    public void setTranslateY(T t, float f) {
        t.setTranslationY(PixelUtil.toPixelFromDIP(f));
    }

    @ReactProp(name = "accessibilityLiveRegion")
    public void setAccessibilityLiveRegion(T t, String str) {
        if (str == null || str.equals("none")) {
            ViewCompat.setAccessibilityLiveRegion(t, 0);
        } else if (str.equals("polite")) {
            ViewCompat.setAccessibilityLiveRegion(t, 1);
        } else if (str.equals("assertive")) {
            ViewCompat.setAccessibilityLiveRegion(t, 2);
        }
    }

    private static class LayerEffectsHelper {
        public static void apply(View view, ReadableArray readableArray, Boolean bool) {
            Paint paint;
            int i = Build.VERSION.SDK_INT;
            if (i >= 31) {
                view.setRenderEffect(null);
            }
            if (readableArray == null) {
                paint = null;
            } else if (FilterHelper.isOnlyColorMatrixFilters(readableArray)) {
                paint = new Paint();
                paint.setColorFilter(FilterHelper.parseColorMatrixFilters(readableArray));
            } else {
                if (i >= 31) {
                    view.setRenderEffect(FilterHelper.parseFilters(readableArray));
                }
                paint = null;
            }
            if (paint == null) {
                view.setLayerType((bool == null || !bool.booleanValue()) ? 0 : 2, null);
            } else {
                view.setLayerType(2, paint);
            }
        }
    }

    protected void setTransformProperty(T t, ReadableArray readableArray, ReadableArray readableArray2) {
        if (readableArray == null) {
            t.setTranslationX(PixelUtil.toPixelFromDIP(0.0f));
            t.setTranslationY(PixelUtil.toPixelFromDIP(0.0f));
            t.setRotation(0.0f);
            t.setRotationX(0.0f);
            t.setRotationY(0.0f);
            t.setScaleX(1.0f);
            t.setScaleY(1.0f);
            t.setCameraDistance(0.0f);
            return;
        }
        boolean z = ViewUtil.getUIManagerType(t) == 2;
        MatrixMathHelper.MatrixDecompositionContext matrixDecompositionContext = sMatrixDecompositionContext;
        matrixDecompositionContext.reset();
        double[] dArr = sTransformDecompositionArray;
        TransformHelper.processTransform(readableArray, dArr, PixelUtil.toDIPFromPixel(t.getWidth()), PixelUtil.toDIPFromPixel(t.getHeight()), readableArray2, z);
        MatrixMathHelper.decomposeMatrix(dArr, matrixDecompositionContext);
        t.setTranslationX(PixelUtil.toPixelFromDIP(sanitizeFloatPropertyValue((float) matrixDecompositionContext.translation[0])));
        t.setTranslationY(PixelUtil.toPixelFromDIP(sanitizeFloatPropertyValue((float) matrixDecompositionContext.translation[1])));
        t.setRotation(sanitizeFloatPropertyValue((float) matrixDecompositionContext.rotationDegrees[2]));
        t.setRotationX(sanitizeFloatPropertyValue((float) matrixDecompositionContext.rotationDegrees[0]));
        t.setRotationY(sanitizeFloatPropertyValue((float) matrixDecompositionContext.rotationDegrees[1]));
        t.setScaleX(sanitizeFloatPropertyValue((float) matrixDecompositionContext.scale[0]));
        t.setScaleY(sanitizeFloatPropertyValue((float) matrixDecompositionContext.scale[1]));
        double[] dArr2 = matrixDecompositionContext.perspective;
        if (dArr2.length > 2) {
            float f = (float) dArr2[2];
            if (f == 0.0f) {
                f = 7.8125E-4f;
            }
            float f2 = (-1.0f) / f;
            float f3 = DisplayMetricsHolder.getScreenDisplayMetrics().density;
            t.setCameraDistance(sanitizeFloatPropertyValue(f3 * f3 * f2 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        }
    }

    private static float sanitizeFloatPropertyValue(float f) {
        if (f >= -3.4028235E38f && f <= Float.MAX_VALUE) {
            return f;
        }
        if (f < -3.4028235E38f || f == Float.NEGATIVE_INFINITY) {
            return -3.4028235E38f;
        }
        if (f > Float.MAX_VALUE || f == Float.POSITIVE_INFINITY) {
            return Float.MAX_VALUE;
        }
        if (Float.isNaN(f)) {
            return 0.0f;
        }
        throw new IllegalStateException("Invalid float property value: " + f);
    }

    protected void updateViewAccessibility(T t) {
        ReactAccessibilityDelegate.setDelegate(t, t.isFocusable(), t.getImportantForAccessibility());
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected void onAfterUpdateTransaction(T t) {
        super.onAfterUpdateTransaction(t);
        updateViewAccessibility(t);
        Boolean bool = (Boolean) t.getTag(R$id.invalidate_transform);
        if (bool != null && bool.booleanValue()) {
            t.addOnLayoutChangeListener(this);
            setTransformProperty(t, (ReadableArray) t.getTag(R$id.transform), (ReadableArray) t.getTag(R$id.transform_origin));
            t.setTag(R$id.invalidate_transform, Boolean.FALSE);
        }
        LayerEffectsHelper.apply(t, (ReadableArray) t.getTag(R$id.filter), (Boolean) t.getTag(R$id.use_hardware_layer));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        MapBuilder.Builder builderPut = MapBuilder.builder().put("topPointerCancel", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerCancel", "captured", "onPointerCancelCapture"))).put("topPointerDown", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerDown", "captured", "onPointerDownCapture")));
        Boolean bool = Boolean.TRUE;
        exportedCustomDirectEventTypeConstants.putAll(builderPut.put("topPointerEnter", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerEnter", "captured", "onPointerEnterCapture", "skipBubbling", bool))).put("topPointerLeave", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerLeave", "captured", "onPointerLeaveCapture", "skipBubbling", bool))).put("topPointerMove", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerMove", "captured", "onPointerMoveCapture"))).put("topPointerUp", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerUp", "captured", "onPointerUpCapture"))).put("topPointerOut", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerOut", "captured", "onPointerOutCapture"))).put("topPointerOver", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerOver", "captured", "onPointerOverCapture"))).put("topClick", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onClick", "captured", "onClickCapture"))).put("topBlur", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onBlur", "captured", "onBlurCapture"))).put("topFocus", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onFocus", "captured", "onFocusCapture"))).build());
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapBuilder.builder().put("topAccessibilityAction", MapBuilder.of("registrationName", "onAccessibilityAction")).build());
        return exportedCustomDirectEventTypeConstants;
    }

    public void setBorderRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderRadius");
    }

    public void setBorderBottomLeftRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderBottomLeftRadius");
    }

    public void setBorderBottomRightRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderBottomRightRadius");
    }

    public void setBorderTopLeftRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderTopLeftRadius");
    }

    public void setBorderTopRightRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderTopRightRadius");
    }

    @ReactProp(customType = "Color", name = "outlineColor")
    public void setOutlineColor(T t, Integer num) {
        BackgroundStyleApplicator.setOutlineColor(t, num);
    }

    @ReactProp(name = "outlineOffset")
    public void setOutlineOffset(T t, float f) {
        BackgroundStyleApplicator.setOutlineOffset(t, f);
    }

    @ReactProp(name = "outlineStyle")
    public void setOutlineStyle(T t, String str) {
        BackgroundStyleApplicator.setOutlineStyle(t, str == null ? null : OutlineStyle.fromString(str));
    }

    @ReactProp(name = "outlineWidth")
    public void setOutlineWidth(T t, float f) {
        BackgroundStyleApplicator.setOutlineWidth(t, f);
    }

    @ReactProp(customType = "BoxShadow", name = "boxShadow")
    public void setBoxShadow(T t, ReadableArray readableArray) {
        BackgroundStyleApplicator.setBoxShadow(t, readableArray);
    }

    private void logUnsupportedPropertyWarning(String str) {
        FLog.w("ReactNative", "%s doesn't support property '%s'", getName(), str);
    }

    private static void setPointerEventsFlag(View view, PointerEventHelper.EVENT event, boolean z) {
        Integer num = (Integer) view.getTag(R$id.pointer_events);
        int iIntValue = num != null ? num.intValue() : 0;
        int iOrdinal = 1 << event.ordinal();
        view.setTag(R$id.pointer_events, Integer.valueOf(z ? iOrdinal | iIntValue : (~iOrdinal) & iIntValue));
    }

    @ReactProp(name = "onPointerEnter")
    public void setPointerEnter(T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.ENTER, z);
    }

    @ReactProp(name = "onPointerEnterCapture")
    public void setPointerEnterCapture(T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.ENTER_CAPTURE, z);
    }

    @ReactProp(name = "onPointerOver")
    public void setPointerOver(T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.OVER, z);
    }

    @ReactProp(name = "onPointerOverCapture")
    public void setPointerOverCapture(T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.OVER_CAPTURE, z);
    }

    @ReactProp(name = "onPointerOut")
    public void setPointerOut(T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.OUT, z);
    }

    @ReactProp(name = "onPointerOutCapture")
    public void setPointerOutCapture(T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.OUT_CAPTURE, z);
    }

    @ReactProp(name = "onPointerLeave")
    public void setPointerLeave(T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.LEAVE, z);
    }

    @ReactProp(name = "onPointerLeaveCapture")
    public void setPointerLeaveCapture(T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.LEAVE_CAPTURE, z);
    }

    @ReactProp(name = "onPointerMove")
    public void setPointerMove(T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.MOVE, z);
    }

    @ReactProp(name = "onPointerMoveCapture")
    public void setPointerMoveCapture(T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.MOVE_CAPTURE, z);
    }

    @ReactProp(name = "onClick")
    public void setClick(T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.CLICK, z);
    }

    @ReactProp(name = "onClickCapture")
    public void setClickCapture(T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.CLICK_CAPTURE, z);
    }

    private class BaseVMFocusChangeListener implements View.OnFocusChangeListener {
        private View.OnFocusChangeListener mOriginalFocusChangeListener;

        public BaseVMFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
            this.mOriginalFocusChangeListener = onFocusChangeListener;
        }

        public void attach(View view) {
            view.setOnFocusChangeListener(this);
        }

        public void detach(View view) {
            view.setOnFocusChangeListener(this.mOriginalFocusChangeListener);
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            EventDispatcher eventDispatcherForReactTag;
            View.OnFocusChangeListener onFocusChangeListener = this.mOriginalFocusChangeListener;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(view, z);
            }
            int surfaceId = UIManagerHelper.getSurfaceId(view.getContext());
            if (surfaceId == -1 || !(view.getContext() instanceof ThemedReactContext) || (eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ThemedReactContext) view.getContext(), view.getId())) == null) {
                return;
            }
            if (z) {
                eventDispatcherForReactTag.dispatchEvent(new FocusEvent(surfaceId, view.getId()));
            } else {
                eventDispatcherForReactTag.dispatchEvent(new BlurEvent(surfaceId, view.getId()));
            }
        }
    }
}
