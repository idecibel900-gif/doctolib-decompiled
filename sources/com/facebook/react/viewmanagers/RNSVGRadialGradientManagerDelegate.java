package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.google.firebase.messaging.Constants;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGRadialGradientManagerDelegate extends BaseViewManagerDelegate {
    public RNSVGRadialGradientManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1932235233:
                if (str.equals("gradientUnits")) {
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
            case -933864895:
                if (str.equals("markerEnd")) {
                    b = 3;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    b = 4;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    b = 5;
                }
                break;
            case 3189:
                if (str.equals("cx")) {
                    b = 6;
                }
                break;
            case 3190:
                if (str.equals("cy")) {
                    b = 7;
                }
                break;
            case 3282:
                if (str.equals("fx")) {
                    b = 8;
                }
                break;
            case 3283:
                if (str.equals("fy")) {
                    b = 9;
                }
                break;
            case 3654:
                if (str.equals("rx")) {
                    b = 10;
                }
                break;
            case 3655:
                if (str.equals("ry")) {
                    b = 11;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = 12;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = 13;
                }
                break;
            case 89650992:
                if (str.equals("gradient")) {
                    b = 14;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = 15;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = 16;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = 17;
                }
                break;
            case 1671764162:
                if (str.equals(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)) {
                    b = 18;
                }
                break;
            case 1822665244:
                if (str.equals("gradientTransform")) {
                    b = 19;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = 20;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setGradientUnits(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 1:
                this.mViewManager.setOpacity(view, obj == null ? 1.0f : ((Double) obj).floatValue());
                break;
            case 2:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case 4:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setCx(view, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setCy(view, new DynamicFromObject(obj));
                break;
            case 8:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setFx(view, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setFy(view, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setRx(view, new DynamicFromObject(obj));
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setRy(view, new DynamicFromObject(obj));
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case 13:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setGradient(view, (ReadableArray) obj);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case 16:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 18:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case 19:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setGradientTransform(view, (ReadableArray) obj);
                break;
            case 20:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
