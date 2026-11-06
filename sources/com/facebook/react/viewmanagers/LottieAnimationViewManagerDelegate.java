package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class LottieAnimationViewManagerDelegate extends BaseViewManagerDelegate {
    public LottieAnimationViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1931191604:
                if (str.equals("imageAssetsFolder")) {
                    b = 0;
                }
                break;
            case -1698420908:
                if (str.equals("sourceURL")) {
                    b = 1;
                }
                break;
            case -1620771041:
                if (str.equals("textFiltersIOS")) {
                    b = 2;
                }
                break;
            case -1111735389:
                if (str.equals("sourceJson")) {
                    b = 3;
                }
                break;
            case -1111633594:
                if (str.equals("sourceName")) {
                    b = 4;
                }
                break;
            case -1073046328:
                if (str.equals("cacheComposition")) {
                    b = 5;
                }
                break;
            case -1001078227:
                if (str.equals(ReactProgressBarViewManager.PROP_PROGRESS)) {
                    b = 6;
                }
                break;
            case -413415295:
                if (str.equals("textFiltersAndroid")) {
                    b = 7;
                }
                break;
            case -204076609:
                if (str.equals("sourceDotLottieURI")) {
                    b = 8;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    b = 9;
                }
                break;
            case 95945896:
                if (str.equals("dummy")) {
                    b = 10;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    b = 11;
                }
                break;
            case 399078087:
                if (str.equals("hardwareAccelerationAndroid")) {
                    b = 12;
                }
                break;
            case 1192042876:
                if (str.equals("enableSafeModeAndroid")) {
                    b = 13;
                }
                break;
            case 1193882713:
                if (str.equals("renderMode")) {
                    b = 14;
                }
                break;
            case 1410565912:
                if (str.equals("colorFilters")) {
                    b = 15;
                }
                break;
            case 1438608771:
                if (str.equals("autoPlay")) {
                    b = 16;
                }
                break;
            case 2049757303:
                if (str.equals("resizeMode")) {
                    b = 17;
                }
                break;
            case 2111299681:
                if (str.equals("enableMergePathsAndroidForKitKatAndAbove")) {
                    b = 18;
                }
                break;
        }
        switch (b) {
            case 0:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setImageAssetsFolder(view, obj != null ? (String) obj : null);
                break;
            case 1:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setSourceURL(view, obj != null ? (String) obj : null);
                break;
            case 2:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setTextFiltersIOS(view, (ReadableArray) obj);
                break;
            case 3:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setSourceJson(view, obj != null ? (String) obj : null);
                break;
            case 4:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setSourceName(view, obj != null ? (String) obj : null);
                break;
            case 5:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setCacheComposition(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 6:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setProgress(view, obj == null ? 0.0f : ((Double) obj).floatValue());
                break;
            case 7:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setTextFiltersAndroid(view, (ReadableArray) obj);
                break;
            case 8:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setSourceDotLottieURI(view, obj != null ? (String) obj : null);
                break;
            case 9:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setLoop(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 10:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setDummy(view, (ReadableMap) obj);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setSpeed(view, obj == null ? 0.0d : ((Double) obj).doubleValue());
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setHardwareAccelerationAndroid(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 13:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setEnableSafeModeAndroid(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 14:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setRenderMode(view, obj != null ? (String) obj : null);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setColorFilters(view, (ReadableArray) obj);
                break;
            case 16:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setAutoPlay(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 17:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setResizeMode(view, obj != null ? (String) obj : null);
                break;
            case 18:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setEnableMergePathsAndroidForKitKatAndAbove(view, obj != null ? ((Boolean) obj).booleanValue() : false);
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
        switch (str) {
            case "resume":
                ((LottieAnimationViewManagerInterface) this.mViewManager).resume(view);
                break;
            case "play":
                ((LottieAnimationViewManagerInterface) this.mViewManager).play(view, readableArray.getInt(0), readableArray.getInt(1));
                break;
            case "pause":
                ((LottieAnimationViewManagerInterface) this.mViewManager).pause(view);
                break;
            case "reset":
                ((LottieAnimationViewManagerInterface) this.mViewManager).reset(view);
                break;
        }
    }
}
