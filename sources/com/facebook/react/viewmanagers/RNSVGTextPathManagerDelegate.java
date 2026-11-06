package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.google.firebase.messaging.Constants;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.composables.BackgroundUIConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import net.openid.appauth.CodeVerifierUtil;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGTextPathManagerDelegate extends BaseViewManagerDelegate {
    public RNSVGTextPathManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -2012158909:
                if (str.equals("spacing")) {
                    b = 0;
                }
                break;
            case -1993948267:
                if (str.equals("startOffset")) {
                    b = 1;
                }
                break;
            case -1603134955:
                if (str.equals("lengthAdjust")) {
                    b = 2;
                }
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    b = 3;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    b = 4;
                }
                break;
            case -1171891896:
                if (str.equals("alignmentBaseline")) {
                    b = 5;
                }
                break;
            case -1139902161:
                if (str.equals("verticalAlign")) {
                    b = 6;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    b = 7;
                }
                break;
            case -1077554975:
                if (str.equals("method")) {
                    b = 8;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    b = 9;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    b = 10;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    b = 11;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    b = 12;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    b = 13;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    b = 14;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    b = 15;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    b = 16;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    b = 17;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    b = 18;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    b = 19;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    b = 20;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    b = 21;
                }
                break;
            case 3220:
                if (str.equals("dx")) {
                    b = 22;
                }
                break;
            case 3221:
                if (str.equals("dy")) {
                    b = 23;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    b = 24;
                }
                break;
            case 3148879:
                if (str.equals("font")) {
                    b = 25;
                }
                break;
            case 3211051:
                if (str.equals("href")) {
                    b = 26;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = 27;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = 28;
                }
                break;
            case 3530071:
                if (str.equals("side")) {
                    b = 29;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    b = 30;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    b = 31;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    b = 32;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = 33;
                }
                break;
            case 275888445:
                if (str.equals("baselineShift")) {
                    b = 34;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    b = 35;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    b = 36;
                }
                break;
            case 778043962:
                if (str.equals("inlineSize")) {
                    b = 37;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = 38;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = 39;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    b = 40;
                }
                break;
            case 1054434908:
                if (str.equals("midLine")) {
                    b = 41;
                }
                break;
            case 1637488243:
                if (str.equals("textLength")) {
                    b = 42;
                }
                break;
            case 1671764162:
                if (str.equals(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)) {
                    b = 43;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    b = 44;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = 45;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    b = 46;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setSpacing(view, obj != null ? (String) obj : null);
                break;
            case 1:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStartOffset(view, new DynamicFromObject(obj));
                break;
            case 2:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setLengthAdjust(view, obj != null ? (String) obj : null);
                break;
            case 3:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFilter(view, obj != null ? (String) obj : null);
                break;
            case 4:
                this.mViewManager.setOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 5:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setAlignmentBaseline(view, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setVerticalAlign(view, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case 8:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMethod(view, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setPropList(view, (ReadableArray) obj);
                break;
            case 10:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setRotate(view, new DynamicFromObject(obj));
                break;
            case 13:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStroke(view, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFontWeight(view, new DynamicFromObject(obj));
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFillRule(view, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 16:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 17:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case 18:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFillOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 19:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeDashoffset(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 20:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setX(view, new DynamicFromObject(obj));
                break;
            case 21:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setY(view, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setDx(view, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setDy(view, new DynamicFromObject(obj));
                break;
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFill(view, new DynamicFromObject(obj));
                break;
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFont(view, new DynamicFromObject(obj));
                break;
            case 26:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setHref(view, obj != null ? (String) obj : null);
                break;
            case 27:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case 28:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case 29:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setSide(view, obj != null ? (String) obj : null);
                break;
            case 30:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeMiterlimit(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 32:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setVectorEffect(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 33:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case 34:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setBaselineShift(view, new DynamicFromObject(obj));
                break;
            case 35:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFontSize(view, new DynamicFromObject(obj));
                break;
            case 36:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeDasharray(view, new DynamicFromObject(obj));
                break;
            case 37:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setInlineSize(view, new DynamicFromObject(obj));
                break;
            case 38:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case 39:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 40:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeLinecap(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 41:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMidLine(view, obj != null ? (String) obj : null);
                break;
            case 42:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setTextLength(view, new DynamicFromObject(obj));
                break;
            case CodeVerifierUtil.MIN_CODE_VERIFIER_LENGTH /* 43 */:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case 44:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeLinejoin(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 45:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 46:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
