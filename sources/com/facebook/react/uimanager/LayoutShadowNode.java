package com.facebook.react.uimanager;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaWrap;
import com.google.firebase.messaging.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class LayoutShadowNode extends ReactShadowNodeImpl {
    boolean mCollapsable;
    private final MutableYogaValue mTempYogaValue = new MutableYogaValue();

    @ReactProp(name = "collapsableChildren")
    public void setCollapsableChildren(boolean z) {
    }

    @ReactProp(name = "inset")
    public void setInset(Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"insetBlock", "insetBlockEnd", "insetBlockStart"})
    public void setInsetBlock(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"insetInline", "insetInlineEnd", "insetInlineStart"})
    public void setInsetInline(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"marginBlock", "marginBlockEnd", "marginBlockStart"})
    public void setMarginBlock(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"marginInline", "marginInlineEnd", "marginInlineStart"})
    public void setMarginInline(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"paddingBlock", "paddingBlockEnd", "paddingBlockStart"})
    public void setPaddingBlock(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"paddingInline", "paddingInlineEnd", "paddingInlineStart"})
    public void setPaddingInline(int i, Dynamic dynamic) {
    }

    @ReactProp(name = "onPointerEnter")
    public void setShouldNotifyPointerEnter(boolean z) {
    }

    @ReactProp(name = "onPointerLeave")
    public void setShouldNotifyPointerLeave(boolean z) {
    }

    @ReactProp(name = "onPointerMove")
    public void setShouldNotifyPointerMove(boolean z) {
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("LayoutShadowNode", LegacyArchitectureLogLevel.ERROR);
    }

    private static class MutableYogaValue {
        YogaUnit unit;
        float value;

        private MutableYogaValue() {
        }

        void setFromDynamic(Dynamic dynamic) {
            if (dynamic.isNull()) {
                this.unit = YogaUnit.UNDEFINED;
                this.value = YogaConstants.UNDEFINED;
                return;
            }
            if (dynamic.getType() == ReadableType.String) {
                String strAsString = dynamic.asString();
                if (strAsString.equals("auto")) {
                    this.unit = YogaUnit.AUTO;
                    this.value = YogaConstants.UNDEFINED;
                    return;
                } else {
                    if (strAsString.endsWith("%")) {
                        this.unit = YogaUnit.PERCENT;
                        this.value = Float.parseFloat(strAsString.substring(0, strAsString.length() - 1));
                        return;
                    }
                    FLog.w("ReactNative", "Unknown value: " + strAsString);
                    this.unit = YogaUnit.UNDEFINED;
                    this.value = YogaConstants.UNDEFINED;
                    return;
                }
            }
            if (dynamic.getType() == ReadableType.Number) {
                this.unit = YogaUnit.POINT;
                this.value = PixelUtil.toPixelFromDIP(dynamic.asDouble());
            } else {
                this.unit = YogaUnit.UNDEFINED;
                this.value = YogaConstants.UNDEFINED;
            }
        }
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleWidth(this.mTempYogaValue.value);
        } else if (i == 3) {
            setStyleWidthAuto();
        } else if (i == 4) {
            setStyleWidthPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    /* JADX INFO: renamed from: com.facebook.react.uimanager.LayoutShadowNode$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$yoga$YogaUnit;

        static {
            int[] iArr = new int[YogaUnit.values().length];
            $SwitchMap$com$facebook$yoga$YogaUnit = iArr;
            try {
                iArr[YogaUnit.POINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.UNDEFINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.PERCENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @ReactProp(name = "minWidth")
    public void setMinWidth(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleMinWidth(this.mTempYogaValue.value);
        } else if (i == 4) {
            setStyleMinWidthPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = "collapsable")
    public void setCollapsable(boolean z) {
        this.mCollapsable = z;
    }

    @ReactProp(name = "maxWidth")
    public void setMaxWidth(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleMaxWidth(this.mTempYogaValue.value);
        } else if (i == 4) {
            setStyleMaxWidthPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleHeight(this.mTempYogaValue.value);
        } else if (i == 3) {
            setStyleHeightAuto();
        } else if (i == 4) {
            setStyleHeightPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = "minHeight")
    public void setMinHeight(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleMinHeight(this.mTempYogaValue.value);
        } else if (i == 4) {
            setStyleMinHeightPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = "maxHeight")
    public void setMaxHeight(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleMaxHeight(this.mTempYogaValue.value);
        } else if (i == 4) {
            setStyleMaxHeightPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    @ReactProp(defaultFloat = 0.0f, name = "flex")
    public void setFlex(float f) {
        if (isVirtual()) {
            return;
        }
        super.setFlex(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    @ReactProp(defaultFloat = 0.0f, name = "flexGrow")
    public void setFlexGrow(float f) {
        if (isVirtual()) {
            return;
        }
        super.setFlexGrow(f);
    }

    @ReactProp(name = "rowGap")
    public void setRowGap(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            setRowGap(this.mTempYogaValue.value);
        } else if (i == 4) {
            setRowGapPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = "columnGap")
    public void setColumnGap(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            setColumnGap(this.mTempYogaValue.value);
        } else if (i == 4) {
            setColumnGapPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = "gap")
    public void setGap(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            setGap(this.mTempYogaValue.value);
        } else if (i == 4) {
            setGapPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    @ReactProp(defaultFloat = 0.0f, name = "flexShrink")
    public void setFlexShrink(float f) {
        if (isVirtual()) {
            return;
        }
        super.setFlexShrink(f);
    }

    @ReactProp(name = "flexBasis")
    public void setFlexBasis(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setFlexBasis(this.mTempYogaValue.value);
        } else if (i == 3) {
            setFlexBasisAuto();
        } else if (i == 4) {
            setFlexBasisPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "aspectRatio")
    public void setAspectRatio(float f) {
        setStyleAspectRatio(f);
    }

    @ReactProp(name = "flexDirection")
    public void setFlexDirection(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setFlexDirection(YogaFlexDirection.COLUMN);
            return;
        }
        switch (str) {
            case "row-reverse":
                setFlexDirection(YogaFlexDirection.ROW_REVERSE);
                break;
            case "column":
                setFlexDirection(YogaFlexDirection.COLUMN);
                break;
            case "row":
                setFlexDirection(YogaFlexDirection.ROW);
                break;
            case "column-reverse":
                setFlexDirection(YogaFlexDirection.COLUMN_REVERSE);
                break;
            default:
                FLog.w("ReactNative", "invalid value for flexDirection: " + str);
                setFlexDirection(YogaFlexDirection.COLUMN);
                break;
        }
    }

    @ReactProp(name = "flexWrap")
    public void setFlexWrap(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setFlexWrap(YogaWrap.NO_WRAP);
            return;
        }
        switch (str) {
            case "nowrap":
                setFlexWrap(YogaWrap.NO_WRAP);
                break;
            case "wrap-reverse":
                setFlexWrap(YogaWrap.WRAP_REVERSE);
                break;
            case "wrap":
                setFlexWrap(YogaWrap.WRAP);
                break;
            default:
                FLog.w("ReactNative", "invalid value for flexWrap: " + str);
                setFlexWrap(YogaWrap.NO_WRAP);
                break;
        }
    }

    @ReactProp(name = "alignSelf")
    public void setAlignSelf(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setAlignSelf(YogaAlign.AUTO);
            return;
        }
        switch (str) {
            case "stretch":
                setAlignSelf(YogaAlign.STRETCH);
                break;
            case "baseline":
                setAlignSelf(YogaAlign.BASELINE);
                break;
            case "center":
                setAlignSelf(YogaAlign.CENTER);
                break;
            case "flex-start":
                setAlignSelf(YogaAlign.FLEX_START);
                break;
            case "auto":
                setAlignSelf(YogaAlign.AUTO);
                break;
            case "space-between":
                setAlignSelf(YogaAlign.SPACE_BETWEEN);
                break;
            case "flex-end":
                setAlignSelf(YogaAlign.FLEX_END);
                break;
            case "space-around":
                setAlignSelf(YogaAlign.SPACE_AROUND);
                break;
            default:
                FLog.w("ReactNative", "invalid value for alignSelf: " + str);
                setAlignSelf(YogaAlign.AUTO);
                break;
        }
    }

    @ReactProp(name = "alignItems")
    public void setAlignItems(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setAlignItems(YogaAlign.STRETCH);
            return;
        }
        switch (str) {
            case "stretch":
                setAlignItems(YogaAlign.STRETCH);
                break;
            case "baseline":
                setAlignItems(YogaAlign.BASELINE);
                break;
            case "center":
                setAlignItems(YogaAlign.CENTER);
                break;
            case "flex-start":
                setAlignItems(YogaAlign.FLEX_START);
                break;
            case "auto":
                setAlignItems(YogaAlign.AUTO);
                break;
            case "space-between":
                setAlignItems(YogaAlign.SPACE_BETWEEN);
                break;
            case "flex-end":
                setAlignItems(YogaAlign.FLEX_END);
                break;
            case "space-around":
                setAlignItems(YogaAlign.SPACE_AROUND);
                break;
            default:
                FLog.w("ReactNative", "invalid value for alignItems: " + str);
                setAlignItems(YogaAlign.STRETCH);
                break;
        }
    }

    @ReactProp(name = "alignContent")
    public void setAlignContent(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setAlignContent(YogaAlign.FLEX_START);
            return;
        }
        switch (str) {
            case "stretch":
                setAlignContent(YogaAlign.STRETCH);
                break;
            case "baseline":
                setAlignContent(YogaAlign.BASELINE);
                break;
            case "center":
                setAlignContent(YogaAlign.CENTER);
                break;
            case "flex-start":
                setAlignContent(YogaAlign.FLEX_START);
                break;
            case "auto":
                setAlignContent(YogaAlign.AUTO);
                break;
            case "space-between":
                setAlignContent(YogaAlign.SPACE_BETWEEN);
                break;
            case "flex-end":
                setAlignContent(YogaAlign.FLEX_END);
                break;
            case "space-around":
                setAlignContent(YogaAlign.SPACE_AROUND);
                break;
            case "space-evenly":
                setAlignContent(YogaAlign.SPACE_EVENLY);
                break;
            default:
                FLog.w("ReactNative", "invalid value for alignContent: " + str);
                setAlignContent(YogaAlign.FLEX_START);
                break;
        }
    }

    @ReactProp(name = "justifyContent")
    public void setJustifyContent(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setJustifyContent(YogaJustify.FLEX_START);
            return;
        }
        switch (str) {
            case "center":
                setJustifyContent(YogaJustify.CENTER);
                break;
            case "flex-start":
                setJustifyContent(YogaJustify.FLEX_START);
                break;
            case "space-between":
                setJustifyContent(YogaJustify.SPACE_BETWEEN);
                break;
            case "flex-end":
                setJustifyContent(YogaJustify.FLEX_END);
                break;
            case "space-around":
                setJustifyContent(YogaJustify.SPACE_AROUND);
                break;
            case "space-evenly":
                setJustifyContent(YogaJustify.SPACE_EVENLY);
                break;
            default:
                FLog.w("ReactNative", "invalid value for justifyContent: " + str);
                setJustifyContent(YogaJustify.FLEX_START);
                break;
        }
    }

    @ReactProp(name = "overflow")
    public void setOverflow(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setOverflow(YogaOverflow.VISIBLE);
            return;
        }
        switch (str) {
            case "hidden":
                setOverflow(YogaOverflow.HIDDEN);
                break;
            case "scroll":
                setOverflow(YogaOverflow.SCROLL);
                break;
            case "visible":
                setOverflow(YogaOverflow.VISIBLE);
                break;
            default:
                FLog.w("ReactNative", "invalid value for overflow: " + str);
                setOverflow(YogaOverflow.VISIBLE);
                break;
        }
    }

    @ReactProp(name = Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)
    public void setDisplay(String str) {
        if (isVirtual()) {
            return;
        }
        if (str == null) {
            setDisplay(YogaDisplay.FLEX);
            return;
        }
        if (str.equals("flex")) {
            setDisplay(YogaDisplay.FLEX);
            return;
        }
        if (str.equals("none")) {
            setDisplay(YogaDisplay.NONE);
            return;
        }
        FLog.w("ReactNative", "invalid value for display: " + str);
        setDisplay(YogaDisplay.FLEX);
    }

    @ReactPropGroup(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i, Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        int iMaybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i2 == 1 || i2 == 2) {
            setMargin(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        } else if (i2 == 3) {
            setMarginAuto(iMaybeTransformLeftRightToStartEnd);
        } else if (i2 == 4) {
            setMarginPercent(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactPropGroup(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i, Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        int iMaybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i2 == 1 || i2 == 2) {
            setPadding(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        } else if (i2 == 4) {
            setPaddingPercent(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
    public void setBorderWidths(int i, float f) {
        if (isVirtual()) {
            return;
        }
        setBorder(maybeTransformLeftRightToStartEnd(ViewProps.BORDER_SPACING_TYPES[i]), PixelUtil.toPixelFromDIP(f));
    }

    @ReactPropGroup(names = {"start", "end", "left", "right", "top", "bottom"})
    public void setPositionValues(int i, Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        int iMaybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(new int[]{4, 5, 0, 2, 1, 3}[i]);
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i2 == 1 || i2 == 2) {
            setPosition(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        } else if (i2 == 4) {
            setPositionPercent(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    private int maybeTransformLeftRightToStartEnd(int i) {
        if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(getThemedContext())) {
            if (i == 0) {
                return 4;
            }
            if (i == 2) {
                return 5;
            }
        }
        return i;
    }

    @ReactProp(name = "position")
    public void setPosition(String str) {
        if (isVirtual()) {
            return;
        }
        if (str == null) {
            setPositionType(YogaPositionType.RELATIVE);
            return;
        }
        if (str.equals("relative")) {
            setPositionType(YogaPositionType.RELATIVE);
            return;
        }
        if (str.equals("absolute")) {
            setPositionType(YogaPositionType.ABSOLUTE);
            return;
        }
        FLog.w("ReactNative", "invalid value for position: " + str);
        setPositionType(YogaPositionType.RELATIVE);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    @ReactProp(name = "onLayout")
    public void setShouldNotifyOnLayout(boolean z) {
        super.setShouldNotifyOnLayout(z);
    }
}
