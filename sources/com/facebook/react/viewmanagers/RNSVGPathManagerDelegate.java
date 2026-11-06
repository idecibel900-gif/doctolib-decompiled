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
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGPathManagerDelegate extends BaseViewManagerDelegate {
    public RNSVGPathManagerDelegate(BaseViewManager baseViewManager) {
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
            case -1081239615:
                if (str.equals("matrix")) {
                    b = 2;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    b = 3;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    b = 4;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    b = 5;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    b = 6;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    b = 7;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    b = 8;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    b = 9;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    b = 10;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    b = 11;
                }
                break;
            case 100:
                if (str.equals("d")) {
                    b = 12;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    b = 13;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = 14;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = 15;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    b = 16;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    b = 17;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    b = 18;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = 19;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    b = 20;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = 21;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = 22;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    b = 23;
                }
                break;
            case 1671764162:
                if (str.equals(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)) {
                    b = 24;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    b = 25;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = 26;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    b = 27;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGPathManagerInterface) this.mViewManager).setFilter(view, obj != null ? (String) obj : null);
                break;
            case 1:
                this.mViewManager.setOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 2:
                ((RNSVGPathManagerInterface) this.mViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGPathManagerInterface) this.mViewManager).setPropList(view, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGPathManagerInterface) this.mViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGPathManagerInterface) this.mViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGPathManagerInterface) this.mViewManager).setStroke(view, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGPathManagerInterface) this.mViewManager).setFillRule(view, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 8:
                ((RNSVGPathManagerInterface) this.mViewManager).setStrokeOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 9:
                ((RNSVGPathManagerInterface) this.mViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case 10:
                ((RNSVGPathManagerInterface) this.mViewManager).setFillOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNSVGPathManagerInterface) this.mViewManager).setStrokeDashoffset(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNSVGPathManagerInterface) this.mViewManager).setD(view, obj != null ? (String) obj : null);
                break;
            case 13:
                ((RNSVGPathManagerInterface) this.mViewManager).setFill(view, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGPathManagerInterface) this.mViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNSVGPathManagerInterface) this.mViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case 16:
                ((RNSVGPathManagerInterface) this.mViewManager).setStrokeMiterlimit(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 17:
                ((RNSVGPathManagerInterface) this.mViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 18:
                ((RNSVGPathManagerInterface) this.mViewManager).setVectorEffect(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 19:
                ((RNSVGPathManagerInterface) this.mViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case 20:
                ((RNSVGPathManagerInterface) this.mViewManager).setStrokeDasharray(view, new DynamicFromObject(obj));
                break;
            case 21:
                ((RNSVGPathManagerInterface) this.mViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case 22:
                ((RNSVGPathManagerInterface) this.mViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 23:
                ((RNSVGPathManagerInterface) this.mViewManager).setStrokeLinecap(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                ((RNSVGPathManagerInterface) this.mViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                ((RNSVGPathManagerInterface) this.mViewManager).setStrokeLinejoin(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 26:
                ((RNSVGPathManagerInterface) this.mViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 27:
                ((RNSVGPathManagerInterface) this.mViewManager).setStrokeWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
