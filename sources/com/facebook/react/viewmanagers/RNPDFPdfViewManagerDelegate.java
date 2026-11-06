package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.TokenRequest;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class RNPDFPdfViewManagerDelegate extends BaseViewManagerDelegate {
    public RNPDFPdfViewManagerDelegate(BaseViewManager baseViewManager) {
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
            case -1790919953:
                if (str.equals("enablePaging")) {
                    b = 1;
                }
                break;
            case -1379690984:
                if (str.equals("minScale")) {
                    b = 2;
                }
                break;
            case -1151046732:
                if (str.equals("scrollEnabled")) {
                    b = 3;
                }
                break;
            case -922092170:
                if (str.equals("showsVerticalScrollIndicator")) {
                    b = 4;
                }
                break;
            case -657951334:
                if (str.equals("enableAnnotationRendering")) {
                    b = 5;
                }
                break;
            case -631667225:
                if (str.equals("enableRTL")) {
                    b = 6;
                }
                break;
            case 3433103:
                if (str.equals(AuthorizationRequest.Display.PAGE)) {
                    b = 7;
                }
                break;
            case 3433509:
                if (str.equals("path")) {
                    b = 8;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    b = 9;
                }
                break;
            case 396505670:
                if (str.equals("maxScale")) {
                    b = 10;
                }
                break;
            case 902106275:
                if (str.equals("fitPolicy")) {
                    b = 11;
                }
                break;
            case 913503991:
                if (str.equals("singlePage")) {
                    b = 12;
                }
                break;
            case 1216985755:
                if (str.equals(TokenRequest.GRANT_TYPE_PASSWORD)) {
                    b = 13;
                }
                break;
            case 1308044823:
                if (str.equals("enableAntialiasing")) {
                    b = 14;
                }
                break;
            case 1387629604:
                if (str.equals("horizontal")) {
                    b = 15;
                }
                break;
            case 1539343426:
                if (str.equals("enableDoubleTapZoom")) {
                    b = 16;
                }
                break;
            case 1915931784:
                if (str.equals("showsHorizontalScrollIndicator")) {
                    b = 17;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setSpacing(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 1:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setEnablePaging(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 2:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setMinScale(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 3:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setScrollEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 4:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setShowsVerticalScrollIndicator(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 5:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setEnableAnnotationRendering(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 6:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setEnableRTL(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 7:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setPage(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 8:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setPath(view, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setScale(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 10:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setMaxScale(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setFitPolicy(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setSinglePage(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 13:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setPassword(view, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setEnableAntialiasing(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setHorizontal(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 16:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setEnableDoubleTapZoom(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 17:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setShowsHorizontalScrollIndicator(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(View view, String str, ReadableArray readableArray) {
        str.getClass();
        if (str.equals("setNativePage")) {
            ((RNPDFPdfViewManagerInterface) this.mViewManager).setNativePage(view, readableArray.getInt(0));
        }
    }
}
