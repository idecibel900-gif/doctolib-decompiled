package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.composables.BackgroundUIConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.PurchaseParamsValidator;
import net.openid.appauth.CodeVerifierUtil;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class RNCWebViewManagerDelegate extends BaseViewManagerDelegate {
    public RNCWebViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -2014672109:
                if (str.equals("allowFileAccessFromFileURLs")) {
                    b = 0;
                }
                break;
            case -1843391113:
                if (str.equals("sharedCookiesEnabled")) {
                    b = 1;
                }
                break;
            case -1821622534:
                if (str.equals("allowsPictureInPictureMediaPlayback")) {
                    b = 2;
                }
                break;
            case -1737229888:
                if (str.equals("allowsProtectedMedia")) {
                    b = 3;
                }
                break;
            case -1725560121:
                if (str.equals("saveFormDataDisabled")) {
                    b = 4;
                }
                break;
            case -1714115364:
                if (str.equals("textInteractionEnabled")) {
                    b = 5;
                }
                break;
            case -1682637480:
                if (str.equals("paymentRequestEnabled")) {
                    b = 6;
                }
                break;
            case -1646494270:
                if (str.equals("injectedJavaScriptBeforeContentLoaded")) {
                    b = 7;
                }
                break;
            case -1642362548:
                if (str.equals("directionalLockEnabled")) {
                    b = 8;
                }
                break;
            case -1607633676:
                if (str.equals("javaScriptEnabled")) {
                    b = 9;
                }
                break;
            case -1562001507:
                if (str.equals("messagingEnabled")) {
                    b = 10;
                }
                break;
            case -1560813342:
                if (str.equals("indicatorStyle")) {
                    b = 11;
                }
                break;
            case -1555578679:
                if (str.equals("dataDetectorTypes")) {
                    b = 12;
                }
                break;
            case -1547082335:
                if (str.equals("menuItems")) {
                    b = 13;
                }
                break;
            case -1423657812:
                if (str.equals("incognito")) {
                    b = 14;
                }
                break;
            case -1397361343:
                if (str.equals("allowingReadAccessToURL")) {
                    b = 15;
                }
                break;
            case -1321236988:
                if (str.equals("overScrollMode")) {
                    b = 16;
                }
                break;
            case -1208332596:
                if (str.equals("isDoctolibMainApp")) {
                    b = 17;
                }
                break;
            case -1151046732:
                if (str.equals("scrollEnabled")) {
                    b = 18;
                }
                break;
            case -1150480790:
                if (str.equals("keyboardDisplayRequiresUserAction")) {
                    b = 19;
                }
                break;
            case -1146673624:
                if (str.equals("domStorageEnabled")) {
                    b = 20;
                }
                break;
            case -1138577980:
                if (str.equals("allowsLinkPreview")) {
                    b = 21;
                }
                break;
            case -1009029441:
                if (str.equals("useSharedProcessPool")) {
                    b = 22;
                }
                break;
            case -1003454816:
                if (str.equals("textZoom")) {
                    b = 23;
                }
                break;
            case -922092170:
                if (str.equals("showsVerticalScrollIndicator")) {
                    b = 24;
                }
                break;
            case -906998080:
                if (str.equals("forceDarkOn")) {
                    b = 25;
                }
                break;
            case -800676066:
                if (str.equals("minimumFontSize")) {
                    b = 26;
                }
                break;
            case -735485938:
                if (str.equals("hideKeyboardAccessoryView")) {
                    b = 27;
                }
                break;
            case -728016272:
                if (str.equals("allowUniversalAccessFromFileURLs")) {
                    b = 28;
                }
                break;
            case -726941883:
                if (str.equals("mediaCapturePermissionGrantType")) {
                    b = 29;
                }
                break;
            case -600226341:
                if (str.equals("newSource")) {
                    b = 30;
                }
                break;
            case -572048675:
                if (str.equals("hasOnFileDownload")) {
                    b = 31;
                }
                break;
            case -553792443:
                if (str.equals("cacheMode")) {
                    b = 32;
                }
                break;
            case -502352363:
                if (str.equals("pagingEnabled")) {
                    b = 33;
                }
                break;
            case -389349956:
                if (str.equals("contentMode")) {
                    b = 34;
                }
                break;
            case -380199621:
                if (str.equals("messagingModuleName")) {
                    b = 35;
                }
                break;
            case -305041273:
                if (str.equals("hasOnOpenWindowEvent")) {
                    b = 36;
                }
                break;
            case -227577491:
                if (str.equals("javaScriptCanOpenWindowsAutomatically")) {
                    b = 37;
                }
                break;
            case -181845559:
                if (str.equals("setDisplayZoomControls")) {
                    b = 38;
                }
                break;
            case -128312874:
                if (str.equals("allowsFullscreenVideo")) {
                    b = 39;
                }
                break;
            case -127745027:
                if (str.equals("nestedScrollEnabled")) {
                    b = 40;
                }
                break;
            case -104290151:
                if (str.equals("injectedJavaScriptBeforeContentLoadedForMainFrameOnly")) {
                    b = 41;
                }
                break;
            case 70220358:
                if (str.equals("hasOnScroll")) {
                    b = 42;
                }
                break;
            case 70310635:
                if (str.equals("bounces")) {
                    b = 43;
                }
                break;
            case 97678726:
                if (str.equals("setSupportMultipleWindows")) {
                    b = 44;
                }
                break;
            case 138148216:
                if (str.equals("lackPermissionToDownloadMessage")) {
                    b = 45;
                }
                break;
            case 215255965:
                if (str.equals("injectedJavaScript")) {
                    b = 46;
                }
                break;
            case 226157789:
                if (str.equals("automaticallyAdjustContentInsets")) {
                    b = 47;
                }
                break;
            case 311430650:
                if (str.equals("userAgent")) {
                    b = 48;
                }
                break;
            case 368381276:
                if (str.equals("allowsInlineMediaPlayback")) {
                    b = 49;
                }
                break;
            case 397237599:
                if (str.equals("cacheEnabled")) {
                    b = 50;
                }
                break;
            case 441950324:
                if (str.equals("injectedJavaScriptForMainFrameOnly")) {
                    b = 51;
                }
                break;
            case 475851404:
                if (str.equals("webviewDebuggingEnabled")) {
                    b = 52;
                }
                break;
            case 496513340:
                if (str.equals("injectedJavaScriptObject")) {
                    b = 53;
                }
                break;
            case 590869196:
                if (str.equals("applicationNameForUserAgent")) {
                    b = 54;
                }
                break;
            case 760962753:
                if (str.equals("mixedContentMode")) {
                    b = 55;
                }
                break;
            case 811343908:
                if (str.equals("contentInset")) {
                    b = 56;
                }
                break;
            case 830951634:
                if (str.equals("allowsBackForwardNavigationGestures")) {
                    b = 57;
                }
                break;
            case 1076208106:
                if (str.equals("allowsAirPlayForMediaPlayback")) {
                    b = 58;
                }
                break;
            case 1138246185:
                if (str.equals("allowFileAccess")) {
                    b = 59;
                }
                break;
            case 1170796208:
                if (str.equals("limitsNavigationsToAppBoundDomains")) {
                    b = 60;
                }
                break;
            case 1177556938:
                if (str.equals("setBuiltInZoomControls")) {
                    b = 61;
                }
                break;
            case 1219945382:
                if (str.equals("pullToRefreshEnabled")) {
                    b = 62;
                }
                break;
            case 1244240887:
                if (str.equals("refreshControlLightMode")) {
                    b = 63;
                }
                break;
            case 1309684816:
                if (str.equals("fraudulentWebsiteWarningEnabled")) {
                    b = 64;
                }
                break;
            case 1344414299:
                if (str.equals("geolocationEnabled")) {
                    b = 65;
                }
                break;
            case 1359182925:
                if (str.equals("downloadingMessage")) {
                    b = 66;
                }
                break;
            case 1512859629:
                if (str.equals("basicAuthCredential")) {
                    b = 67;
                }
                break;
            case 1523258769:
                if (str.equals("enableApplePay")) {
                    b = 68;
                }
                break;
            case 1774874798:
                if (str.equals("mediaPlaybackRequiresUserAction")) {
                    b = 69;
                }
                break;
            case 1812525393:
                if (str.equals("thirdPartyCookiesEnabled")) {
                    b = 70;
                }
                break;
            case 1813472596:
                if (str.equals("autoManageStatusBarEnabled")) {
                    b = 71;
                }
                break;
            case 1850310268:
                if (str.equals("androidLayerType")) {
                    b = 72;
                }
                break;
            case 1868864108:
                if (str.equals("suppressMenuItems")) {
                    b = 73;
                }
                break;
            case 1915931784:
                if (str.equals("showsHorizontalScrollIndicator")) {
                    b = 74;
                }
                break;
            case 2074641374:
                if (str.equals("scalesPageToFit")) {
                    b = 75;
                }
                break;
            case 2129019807:
                if (str.equals("decelerationRate")) {
                    b = 76;
                }
                break;
            case 2146755107:
                if (str.equals("contentInsetAdjustmentBehavior")) {
                    b = 77;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowFileAccessFromFileURLs(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNCWebViewManagerInterface) this.mViewManager).setSharedCookiesEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 2:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsPictureInPictureMediaPlayback(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 3:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsProtectedMedia(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 4:
                ((RNCWebViewManagerInterface) this.mViewManager).setSaveFormDataDisabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 5:
                ((RNCWebViewManagerInterface) this.mViewManager).setTextInteractionEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 6:
                ((RNCWebViewManagerInterface) this.mViewManager).setPaymentRequestEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 7:
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScriptBeforeContentLoaded(view, obj != null ? (String) obj : null);
                break;
            case 8:
                ((RNCWebViewManagerInterface) this.mViewManager).setDirectionalLockEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 9:
                ((RNCWebViewManagerInterface) this.mViewManager).setJavaScriptEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 10:
                ((RNCWebViewManagerInterface) this.mViewManager).setMessagingEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setIndicatorStyle(view, (String) obj);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setDataDetectorTypes(view, (ReadableArray) obj);
                break;
            case 13:
                ((RNCWebViewManagerInterface) this.mViewManager).setMenuItems(view, (ReadableArray) obj);
                break;
            case 14:
                ((RNCWebViewManagerInterface) this.mViewManager).setIncognito(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowingReadAccessToURL(view, obj != null ? (String) obj : null);
                break;
            case 16:
                ((RNCWebViewManagerInterface) this.mViewManager).setOverScrollMode(view, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNCWebViewManagerInterface) this.mViewManager).setIsDoctolibMainApp(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 18:
                ((RNCWebViewManagerInterface) this.mViewManager).setScrollEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 19:
                ((RNCWebViewManagerInterface) this.mViewManager).setKeyboardDisplayRequiresUserAction(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 20:
                ((RNCWebViewManagerInterface) this.mViewManager).setDomStorageEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 21:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsLinkPreview(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 22:
                ((RNCWebViewManagerInterface) this.mViewManager).setUseSharedProcessPool(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 23:
                ((RNCWebViewManagerInterface) this.mViewManager).setTextZoom(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setShowsVerticalScrollIndicator(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setForceDarkOn(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 26:
                ((RNCWebViewManagerInterface) this.mViewManager).setMinimumFontSize(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 27:
                ((RNCWebViewManagerInterface) this.mViewManager).setHideKeyboardAccessoryView(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 28:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowUniversalAccessFromFileURLs(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 29:
                ((RNCWebViewManagerInterface) this.mViewManager).setMediaCapturePermissionGrantType(view, (String) obj);
                break;
            case 30:
                ((RNCWebViewManagerInterface) this.mViewManager).setNewSource(view, (ReadableMap) obj);
                break;
            case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setHasOnFileDownload(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 32:
                ((RNCWebViewManagerInterface) this.mViewManager).setCacheMode(view, (String) obj);
                break;
            case 33:
                ((RNCWebViewManagerInterface) this.mViewManager).setPagingEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 34:
                ((RNCWebViewManagerInterface) this.mViewManager).setContentMode(view, (String) obj);
                break;
            case 35:
                ((RNCWebViewManagerInterface) this.mViewManager).setMessagingModuleName(view, obj != null ? (String) obj : null);
                break;
            case 36:
                ((RNCWebViewManagerInterface) this.mViewManager).setHasOnOpenWindowEvent(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 37:
                ((RNCWebViewManagerInterface) this.mViewManager).setJavaScriptCanOpenWindowsAutomatically(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 38:
                ((RNCWebViewManagerInterface) this.mViewManager).setSetDisplayZoomControls(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 39:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsFullscreenVideo(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 40:
                ((RNCWebViewManagerInterface) this.mViewManager).setNestedScrollEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 41:
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 42:
                ((RNCWebViewManagerInterface) this.mViewManager).setHasOnScroll(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case CodeVerifierUtil.MIN_CODE_VERIFIER_LENGTH /* 43 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setBounces(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 44:
                ((RNCWebViewManagerInterface) this.mViewManager).setSetSupportMultipleWindows(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 45:
                ((RNCWebViewManagerInterface) this.mViewManager).setLackPermissionToDownloadMessage(view, obj != null ? (String) obj : null);
                break;
            case 46:
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScript(view, obj != null ? (String) obj : null);
                break;
            case 47:
                ((RNCWebViewManagerInterface) this.mViewManager).setAutomaticallyAdjustContentInsets(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 48:
                ((RNCWebViewManagerInterface) this.mViewManager).setUserAgent(view, obj != null ? (String) obj : null);
                break;
            case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsInlineMediaPlayback(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 50:
                ((RNCWebViewManagerInterface) this.mViewManager).setCacheEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 51:
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScriptForMainFrameOnly(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 52:
                ((RNCWebViewManagerInterface) this.mViewManager).setWebviewDebuggingEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 53:
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScriptObject(view, obj != null ? (String) obj : null);
                break;
            case 54:
                ((RNCWebViewManagerInterface) this.mViewManager).setApplicationNameForUserAgent(view, obj != null ? (String) obj : null);
                break;
            case 55:
                ((RNCWebViewManagerInterface) this.mViewManager).setMixedContentMode(view, (String) obj);
                break;
            case 56:
                ((RNCWebViewManagerInterface) this.mViewManager).setContentInset(view, (ReadableMap) obj);
                break;
            case 57:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsBackForwardNavigationGestures(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 58:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsAirPlayForMediaPlayback(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 59:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowFileAccess(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 60:
                ((RNCWebViewManagerInterface) this.mViewManager).setLimitsNavigationsToAppBoundDomains(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 61:
                ((RNCWebViewManagerInterface) this.mViewManager).setSetBuiltInZoomControls(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 62:
                ((RNCWebViewManagerInterface) this.mViewManager).setPullToRefreshEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 63:
                ((RNCWebViewManagerInterface) this.mViewManager).setRefreshControlLightMode(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 64:
                ((RNCWebViewManagerInterface) this.mViewManager).setFraudulentWebsiteWarningEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 65:
                ((RNCWebViewManagerInterface) this.mViewManager).setGeolocationEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 66:
                ((RNCWebViewManagerInterface) this.mViewManager).setDownloadingMessage(view, obj != null ? (String) obj : null);
                break;
            case 67:
                ((RNCWebViewManagerInterface) this.mViewManager).setBasicAuthCredential(view, (ReadableMap) obj);
                break;
            case 68:
                ((RNCWebViewManagerInterface) this.mViewManager).setEnableApplePay(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 69:
                ((RNCWebViewManagerInterface) this.mViewManager).setMediaPlaybackRequiresUserAction(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 70:
                ((RNCWebViewManagerInterface) this.mViewManager).setThirdPartyCookiesEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 71:
                ((RNCWebViewManagerInterface) this.mViewManager).setAutoManageStatusBarEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 72:
                ((RNCWebViewManagerInterface) this.mViewManager).setAndroidLayerType(view, (String) obj);
                break;
            case 73:
                ((RNCWebViewManagerInterface) this.mViewManager).setSuppressMenuItems(view, (ReadableArray) obj);
                break;
            case 74:
                ((RNCWebViewManagerInterface) this.mViewManager).setShowsHorizontalScrollIndicator(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 75:
                ((RNCWebViewManagerInterface) this.mViewManager).setScalesPageToFit(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 76:
                ((RNCWebViewManagerInterface) this.mViewManager).setDecelerationRate(view, obj == null ? 0.0d : ((Double) obj).doubleValue());
                break;
            case 77:
                ((RNCWebViewManagerInterface) this.mViewManager).setContentInsetAdjustmentBehavior(view, (String) obj);
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
            case "goBack":
                ((RNCWebViewManagerInterface) this.mViewManager).goBack(view);
                break;
            case "stopLoading":
                ((RNCWebViewManagerInterface) this.mViewManager).stopLoading(view);
                break;
            case "reload":
                ((RNCWebViewManagerInterface) this.mViewManager).reload(view);
                break;
            case "clearCache":
                ((RNCWebViewManagerInterface) this.mViewManager).clearCache(view, readableArray.getBoolean(0));
                break;
            case "goForward":
                ((RNCWebViewManagerInterface) this.mViewManager).goForward(view);
                break;
            case "clearFormData":
                ((RNCWebViewManagerInterface) this.mViewManager).clearFormData(view);
                break;
            case "loadUrl":
                ((RNCWebViewManagerInterface) this.mViewManager).loadUrl(view, readableArray.getString(0));
                break;
            case "clearHistory":
                ((RNCWebViewManagerInterface) this.mViewManager).clearHistory(view);
                break;
            case "requestFocus":
                ((RNCWebViewManagerInterface) this.mViewManager).requestFocus(view);
                break;
            case "postMessage":
                ((RNCWebViewManagerInterface) this.mViewManager).postMessage(view, readableArray.getString(0));
                break;
            case "injectJavaScript":
                ((RNCWebViewManagerInterface) this.mViewManager).injectJavaScript(view, readableArray.getString(0));
                break;
        }
    }
}
