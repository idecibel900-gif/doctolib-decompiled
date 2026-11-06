package com.facebook.react.uimanager;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.yoga.YogaConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseViewManagerDelegate implements ViewManagerDelegate {
    protected final BaseViewManager mViewManager;

    @Override // com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(View view, String commandName, ReadableArray args) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(commandName, "commandName");
        Intrinsics.checkNotNullParameter(args, "args");
    }

    public BaseViewManagerDelegate(BaseViewManager mViewManager) {
        Intrinsics.checkNotNullParameter(mViewManager, "mViewManager");
        this.mViewManager = mViewManager;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String propName, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propName, "propName");
        switch (propName.hashCode()) {
            case -2018402664:
                if (propName.equals("mixBlendMode")) {
                    this.mViewManager.setMixBlendMode(view, (String) obj);
                    break;
                }
                break;
            case -1898517556:
                if (propName.equals("onPointerEnterCapture")) {
                    Boolean bool = (Boolean) obj;
                    this.mViewManager.setPointerEnterCapture(view, bool != null ? bool.booleanValue() : false);
                    break;
                }
                break;
            case -1721943862:
                if (propName.equals("translateX")) {
                    Double d = (Double) obj;
                    this.mViewManager.setTranslateX(view, d != null ? (float) d.doubleValue() : 0.0f);
                    break;
                }
                break;
            case -1721943861:
                if (propName.equals("translateY")) {
                    Double d2 = (Double) obj;
                    this.mViewManager.setTranslateY(view, d2 != null ? (float) d2.doubleValue() : 0.0f);
                    break;
                }
                break;
            case -1589741021:
                if (propName.equals("shadowColor")) {
                    BaseViewManager baseViewManager = this.mViewManager;
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    baseViewManager.setShadowColor(view, ColorPropConverter.getColor(obj, context, 0));
                    break;
                }
                break;
            case -1489432511:
                if (propName.equals("outlineColor")) {
                    this.mViewManager.setOutlineColor(view, (Integer) obj);
                    break;
                }
                break;
            case -1474494833:
                if (propName.equals("outlineStyle")) {
                    this.mViewManager.setOutlineStyle(view, (String) obj);
                    break;
                }
                break;
            case -1471148380:
                if (propName.equals("outlineWidth")) {
                    Double d3 = (Double) obj;
                    this.mViewManager.setOutlineWidth(view, d3 != null ? (float) d3.doubleValue() : YogaConstants.UNDEFINED);
                    break;
                }
                break;
            case -1351902487:
                if (propName.equals("onClick")) {
                    Boolean bool2 = (Boolean) obj;
                    this.mViewManager.setClick(view, bool2 != null ? bool2.booleanValue() : false);
                    break;
                }
                break;
            case -1274492040:
                if (propName.equals("filter")) {
                    this.mViewManager.setFilter(view, (ReadableArray) obj);
                    break;
                }
                break;
            case -1267206133:
                if (propName.equals("opacity")) {
                    Double d4 = (Double) obj;
                    this.mViewManager.setOpacity(view, d4 != null ? (float) d4.doubleValue() : 1.0f);
                    break;
                }
                break;
            case -1247970794:
                if (propName.equals("onPointerOutCapture")) {
                    Boolean bool3 = (Boolean) obj;
                    this.mViewManager.setPointerOutCapture(view, bool3 != null ? bool3.booleanValue() : false);
                    break;
                }
                break;
            case -1228066334:
                if (propName.equals("borderTopLeftRadius")) {
                    Double d5 = (Double) obj;
                    this.mViewManager.setBorderTopLeftRadius(view, d5 != null ? (float) d5.doubleValue() : YogaConstants.UNDEFINED);
                    break;
                }
                break;
            case -1219666915:
                if (propName.equals("onClickCapture")) {
                    Boolean bool4 = (Boolean) obj;
                    this.mViewManager.setClickCapture(view, bool4 != null ? bool4.booleanValue() : false);
                    break;
                }
                break;
            case -1036769289:
                if (propName.equals("onPointerMoveCapture")) {
                    Boolean bool5 = (Boolean) obj;
                    this.mViewManager.setPointerMoveCapture(view, bool5 != null ? bool5.booleanValue() : false);
                    break;
                }
                break;
            case -994557277:
                if (propName.equals("screenReaderFocusable")) {
                    Boolean bool6 = (Boolean) obj;
                    this.mViewManager.setScreenReaderFocusable(view, bool6 != null ? bool6.booleanValue() : false);
                    break;
                }
                break;
            case -908189618:
                if (propName.equals("scaleX")) {
                    Double d6 = (Double) obj;
                    this.mViewManager.setScaleX(view, d6 != null ? (float) d6.doubleValue() : 1.0f);
                    break;
                }
                break;
            case -908189617:
                if (propName.equals("scaleY")) {
                    Double d7 = (Double) obj;
                    this.mViewManager.setScaleY(view, d7 != null ? (float) d7.doubleValue() : 1.0f);
                    break;
                }
                break;
            case -877170387:
                if (propName.equals("testID")) {
                    this.mViewManager.setTestId(view, (String) obj);
                    break;
                }
                break;
            case -781597262:
                if (propName.equals("transformOrigin")) {
                    this.mViewManager.setTransformOrigin(view, (ReadableArray) obj);
                    break;
                }
                break;
            case -731417480:
                if (propName.equals("zIndex")) {
                    Double d8 = (Double) obj;
                    this.mViewManager.setZIndex(view, d8 != null ? (float) d8.doubleValue() : 0.0f);
                    break;
                }
                break;
            case -112141555:
                if (propName.equals("onPointerLeaveCapture")) {
                    Boolean bool7 = (Boolean) obj;
                    this.mViewManager.setPointerLeaveCapture(view, bool7 != null ? bool7.booleanValue() : false);
                    break;
                }
                break;
            case -101663499:
                if (propName.equals("accessibilityHint")) {
                    this.mViewManager.setAccessibilityHint(view, (String) obj);
                    break;
                }
                break;
            case -101359900:
                if (propName.equals("accessibilityRole")) {
                    this.mViewManager.setAccessibilityRole(view, (String) obj);
                    break;
                }
                break;
            case -80891667:
                if (propName.equals("renderToHardwareTextureAndroid")) {
                    Boolean bool8 = (Boolean) obj;
                    this.mViewManager.setRenderToHardwareTexture(view, bool8 != null ? bool8.booleanValue() : false);
                    break;
                }
                break;
            case -40300674:
                if (propName.equals("rotation")) {
                    Double d9 = (Double) obj;
                    this.mViewManager.setRotation(view, d9 != null ? (float) d9.doubleValue() : 0.0f);
                    break;
                }
                break;
            case -4379043:
                if (propName.equals("elevation")) {
                    Double d10 = (Double) obj;
                    this.mViewManager.setElevation(view, d10 != null ? (float) d10.doubleValue() : 0.0f);
                    break;
                }
                break;
            case 3506294:
                if (propName.equals("role")) {
                    this.mViewManager.setRole(view, (String) obj);
                    break;
                }
                break;
            case 17941018:
                if (propName.equals("onPointerEnter")) {
                    Boolean bool9 = (Boolean) obj;
                    this.mViewManager.setPointerEnter(view, bool9 != null ? bool9.booleanValue() : false);
                    break;
                }
                break;
            case 24119801:
                if (propName.equals("onPointerLeave")) {
                    Boolean bool10 = (Boolean) obj;
                    this.mViewManager.setPointerLeave(view, bool10 != null ? bool10.booleanValue() : false);
                    break;
                }
                break;
            case 36255470:
                if (propName.equals("accessibilityLiveRegion")) {
                    this.mViewManager.setAccessibilityLiveRegion(view, (String) obj);
                    break;
                }
                break;
            case 132353428:
                if (propName.equals("onPointerOverCapture")) {
                    Boolean bool11 = (Boolean) obj;
                    this.mViewManager.setPointerOverCapture(view, bool11 != null ? bool11.booleanValue() : false);
                    break;
                }
                break;
            case 317346576:
                if (propName.equals("onPointerOut")) {
                    Boolean bool12 = (Boolean) obj;
                    this.mViewManager.setPointerOut(view, bool12 != null ? bool12.booleanValue() : false);
                    break;
                }
                break;
            case 333432965:
                if (propName.equals("borderTopRightRadius")) {
                    Double d11 = (Double) obj;
                    this.mViewManager.setBorderTopRightRadius(view, d11 != null ? (float) d11.doubleValue() : YogaConstants.UNDEFINED);
                    break;
                }
                break;
            case 581268560:
                if (propName.equals("borderBottomLeftRadius")) {
                    Double d12 = (Double) obj;
                    this.mViewManager.setBorderBottomLeftRadius(view, d12 != null ? (float) d12.doubleValue() : YogaConstants.UNDEFINED);
                    break;
                }
                break;
            case 588239831:
                if (propName.equals("borderBottomRightRadius")) {
                    Double d13 = (Double) obj;
                    this.mViewManager.setBorderBottomRightRadius(view, d13 != null ? (float) d13.doubleValue() : YogaConstants.UNDEFINED);
                    break;
                }
                break;
            case 743055051:
                if (propName.equals("boxShadow")) {
                    this.mViewManager.setBoxShadow(view, (ReadableArray) obj);
                    break;
                }
                break;
            case 746986311:
                if (propName.equals("importantForAccessibility")) {
                    this.mViewManager.setImportantForAccessibility(view, (String) obj);
                    break;
                }
                break;
            case 1052666732:
                if (propName.equals("transform")) {
                    this.mViewManager.setTransform(view, (ReadableArray) obj);
                    break;
                }
                break;
            case 1146842694:
                if (propName.equals("accessibilityLabel")) {
                    this.mViewManager.setAccessibilityLabel(view, (String) obj);
                    break;
                }
                break;
            case 1153872867:
                if (propName.equals("accessibilityState")) {
                    this.mViewManager.setViewState(view, (ReadableMap) obj);
                    break;
                }
                break;
            case 1156088003:
                if (propName.equals("accessibilityValue")) {
                    this.mViewManager.setAccessibilityValue(view, (ReadableMap) obj);
                    break;
                }
                break;
            case 1247744079:
                if (propName.equals("onPointerMove")) {
                    Boolean bool13 = (Boolean) obj;
                    this.mViewManager.setPointerMove(view, bool13 != null ? bool13.booleanValue() : false);
                    break;
                }
                break;
            case 1247809874:
                if (propName.equals("onPointerOver")) {
                    Boolean bool14 = (Boolean) obj;
                    this.mViewManager.setPointerOver(view, bool14 != null ? bool14.booleanValue() : false);
                    break;
                }
                break;
            case 1287124693:
                if (propName.equals("backgroundColor")) {
                    BaseViewManager baseViewManager2 = this.mViewManager;
                    Context context2 = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    baseViewManager2.setBackgroundColor(view, ColorPropConverter.getColor(obj, context2, 0));
                    break;
                }
                break;
            case 1349188574:
                if (propName.equals("borderRadius")) {
                    Double d14 = (Double) obj;
                    this.mViewManager.setBorderRadius(view, d14 != null ? (float) d14.doubleValue() : YogaConstants.UNDEFINED);
                    break;
                }
                break;
            case 1407295349:
                if (propName.equals("outlineOffset")) {
                    Double d15 = (Double) obj;
                    this.mViewManager.setOutlineOffset(view, d15 != null ? (float) d15.doubleValue() : YogaConstants.UNDEFINED);
                    break;
                }
                break;
            case 1505602511:
                if (propName.equals("accessibilityActions")) {
                    this.mViewManager.setAccessibilityActions(view, (ReadableArray) obj);
                    break;
                }
                break;
            case 1761903244:
                if (propName.equals("accessibilityCollection")) {
                    this.mViewManager.setAccessibilityCollection(view, (ReadableMap) obj);
                    break;
                }
                break;
            case 1865277756:
                if (propName.equals("accessibilityLabelledBy")) {
                    this.mViewManager.setAccessibilityLabelledBy(view, new DynamicFromObject(obj));
                    break;
                }
                break;
            case 1993034687:
                if (propName.equals("accessibilityCollectionItem")) {
                    this.mViewManager.setAccessibilityCollectionItem(view, (ReadableMap) obj);
                    break;
                }
                break;
            case 2045685618:
                if (propName.equals("nativeID")) {
                    this.mViewManager.setNativeId(view, (String) obj);
                    break;
                }
                break;
        }
    }
}
