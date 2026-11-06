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
public class RNSVGLinearGradientManagerDelegate extends BaseViewManagerDelegate {
    public RNSVGLinearGradientManagerDelegate(BaseViewManager baseViewManager) {
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
            case 3769:
                if (str.equals("x1")) {
                    b = 6;
                }
                break;
            case 3770:
                if (str.equals("x2")) {
                    b = 7;
                }
                break;
            case 3800:
                if (str.equals("y1")) {
                    b = 8;
                }
                break;
            case 3801:
                if (str.equals("y2")) {
                    b = 9;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    b = 10;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = 11;
                }
                break;
            case 89650992:
                if (str.equals("gradient")) {
                    b = 12;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    b = 13;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    b = 14;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    b = 15;
                }
                break;
            case 1671764162:
                if (str.equals(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)) {
                    b = 16;
                }
                break;
            case 1822665244:
                if (str.equals("gradientTransform")) {
                    b = 17;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    b = 18;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setGradientUnits(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 1:
                this.mViewManager.setOpacity(view, obj == null ? 1.0f : ((Double) obj).floatValue());
                break;
            case 2:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case 4:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setX1(view, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setX2(view, new DynamicFromObject(obj));
                break;
            case 8:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setY1(view, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setY2(view, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setGradient(view, (ReadableArray) obj);
                break;
            case 13:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 16:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setGradientTransform(view, (ReadableArray) obj);
                break;
            case 18:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
