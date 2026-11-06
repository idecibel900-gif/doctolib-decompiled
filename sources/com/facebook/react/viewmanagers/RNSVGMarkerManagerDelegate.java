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
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGMarkerManagerDelegate extends BaseViewManagerDelegate {
    public RNSVGMarkerManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1567958285:
                if (str.equals("vbHeight")) {
                    b = 0;
                }
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    b = 1;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    b = 2;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    b = 3;
                }
                break;
            case -1008621499:
                if (str.equals("orient")) {
                    b = 4;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    b = 5;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    b = 6;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    b = 7;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    b = 8;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    b = 9;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    b = 10;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    b = 11;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    b = 12;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    b = 13;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    b = 14;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    b = 15;
                }
                break;
            case 3148879:
                if (str.equals("font")) {
                    b = 16;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = 17;
                }
                break;
            case 3351622:
                if (str.equals("minX")) {
                    b = 18;
                }
                break;
            case 3351623:
                if (str.equals("minY")) {
                    b = 19;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = 20;
                }
                break;
            case 3496485:
                if (str.equals("refX")) {
                    b = 21;
                }
                break;
            case 3496486:
                if (str.equals("refY")) {
                    b = 22;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    b = 23;
                }
                break;
            case 92903173:
                if (str.equals("align")) {
                    b = 24;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    b = 25;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    b = 26;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = 27;
                }
                break;
            case 218785621:
                if (str.equals("markerUnits")) {
                    b = 28;
                }
                break;
            case 220478892:
                if (str.equals("markerWidth")) {
                    b = 29;
                }
                break;
            case 240482938:
                if (str.equals("vbWidth")) {
                    b = 30;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    b = 31;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    b = 32;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = 33;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = 34;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    b = 35;
                }
                break;
            case 1671764162:
                if (str.equals(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)) {
                    b = 36;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    b = 37;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = 38;
                }
                break;
            case 1908075304:
                if (str.equals("meetOrSlice")) {
                    b = 39;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    b = 40;
                }
                break;
            case 2106883585:
                if (str.equals("markerHeight")) {
                    b = 41;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setVbHeight(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 1:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFilter(view, obj != null ? (String) obj : null);
                break;
            case 2:
                this.mViewManager.setOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 3:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setOrient(view, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setPropList(view, (ReadableArray) obj);
                break;
            case 6:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case 8:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStroke(view, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFontWeight(view, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFillRule(view, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case 13:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFillOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 14:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeDashoffset(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFill(view, new DynamicFromObject(obj));
                break;
            case 16:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFont(view, new DynamicFromObject(obj));
                break;
            case 17:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case 18:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMinX(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 19:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMinY(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 20:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case 21:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setRefX(view, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setRefY(view, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeMiterlimit(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setAlign(view, obj != null ? (String) obj : null);
                break;
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 26:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setVectorEffect(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 27:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case 28:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerUnits(view, obj != null ? (String) obj : null);
                break;
            case 29:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerWidth(view, new DynamicFromObject(obj));
                break;
            case 30:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setVbWidth(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFontSize(view, new DynamicFromObject(obj));
                break;
            case 32:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeDasharray(view, new DynamicFromObject(obj));
                break;
            case 33:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case 34:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 35:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeLinecap(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 36:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case 37:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeLinejoin(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 38:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 39:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMeetOrSlice(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 40:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeWidth(view, new DynamicFromObject(obj));
                break;
            case 41:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerHeight(view, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
