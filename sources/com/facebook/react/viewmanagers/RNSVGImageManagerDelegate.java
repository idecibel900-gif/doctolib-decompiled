package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
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
public class RNSVGImageManagerDelegate extends BaseViewManagerDelegate {
    public RNSVGImageManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1274492040:
                if (str.equals("filter")) {
                    b = 0;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    b = 1;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    b = 2;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    b = 3;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    b = 4;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    b = 5;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    b = 6;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    b = 7;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    b = 8;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    b = 9;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    b = 10;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    b = 11;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    b = 12;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    b = 13;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    b = 14;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    b = 15;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    b = 16;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = 17;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = 18;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    b = 19;
                }
                break;
            case 92903173:
                if (str.equals("align")) {
                    b = 20;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    b = 21;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    b = 22;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b = 23;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = 24;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    b = 25;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = 26;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = 27;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    b = 28;
                }
                break;
            case 1671764162:
                if (str.equals(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)) {
                    b = 29;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    b = 30;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = 31;
                }
                break;
            case 1908075304:
                if (str.equals("meetOrSlice")) {
                    b = 32;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    b = 33;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGImageManagerInterface) this.mViewManager).setFilter(view, obj != null ? (String) obj : null);
                break;
            case 1:
                this.mViewManager.setOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 2:
                ((RNSVGImageManagerInterface) this.mViewManager).setHeight(view, new DynamicFromObject(obj));
                break;
            case 3:
                ((RNSVGImageManagerInterface) this.mViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGImageManagerInterface) this.mViewManager).setPropList(view, (ReadableArray) obj);
                break;
            case 5:
                ((RNSVGImageManagerInterface) this.mViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGImageManagerInterface) this.mViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGImageManagerInterface) this.mViewManager).setStroke(view, new DynamicFromObject(obj));
                break;
            case 8:
                ((RNSVGImageManagerInterface) this.mViewManager).setFillRule(view, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 9:
                ((RNSVGImageManagerInterface) this.mViewManager).setStrokeOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 10:
                ((RNSVGImageManagerInterface) this.mViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNSVGImageManagerInterface) this.mViewManager).setFillOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNSVGImageManagerInterface) this.mViewManager).setStrokeDashoffset(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 13:
                ((RNSVGImageManagerInterface) this.mViewManager).setX(view, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGImageManagerInterface) this.mViewManager).setY(view, new DynamicFromObject(obj));
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNSVGImageManagerInterface) this.mViewManager).setSrc(view, (ReadableMap) obj);
                break;
            case 16:
                ((RNSVGImageManagerInterface) this.mViewManager).setFill(view, new DynamicFromObject(obj));
                break;
            case 17:
                ((RNSVGImageManagerInterface) this.mViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case 18:
                ((RNSVGImageManagerInterface) this.mViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case 19:
                ((RNSVGImageManagerInterface) this.mViewManager).setStrokeMiterlimit(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 20:
                ((RNSVGImageManagerInterface) this.mViewManager).setAlign(view, obj != null ? (String) obj : null);
                break;
            case 21:
                ((RNSVGImageManagerInterface) this.mViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 22:
                ((RNSVGImageManagerInterface) this.mViewManager).setVectorEffect(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 23:
                ((RNSVGImageManagerInterface) this.mViewManager).setWidth(view, new DynamicFromObject(obj));
                break;
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                ((RNSVGImageManagerInterface) this.mViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                ((RNSVGImageManagerInterface) this.mViewManager).setStrokeDasharray(view, new DynamicFromObject(obj));
                break;
            case 26:
                ((RNSVGImageManagerInterface) this.mViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case 27:
                ((RNSVGImageManagerInterface) this.mViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 28:
                ((RNSVGImageManagerInterface) this.mViewManager).setStrokeLinecap(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 29:
                ((RNSVGImageManagerInterface) this.mViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case 30:
                ((RNSVGImageManagerInterface) this.mViewManager).setStrokeLinejoin(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                ((RNSVGImageManagerInterface) this.mViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 32:
                ((RNSVGImageManagerInterface) this.mViewManager).setMeetOrSlice(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 33:
                ((RNSVGImageManagerInterface) this.mViewManager).setStrokeWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
