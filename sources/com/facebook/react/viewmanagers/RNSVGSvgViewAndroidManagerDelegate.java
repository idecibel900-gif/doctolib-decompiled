package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.composables.BackgroundUIConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import net.openid.appauth.CodeVerifierUtil;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGSvgViewAndroidManagerDelegate extends BaseViewManagerDelegate {
    public RNSVGSvgViewAndroidManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -2064426617:
                if (str.equals("bbHeight")) {
                    b = 0;
                }
                break;
            case -1989576717:
                if (str.equals("borderRightColor")) {
                    b = 1;
                }
                break;
            case -1697814026:
                if (str.equals("backfaceVisibility")) {
                    b = 2;
                }
                break;
            case -1567958285:
                if (str.equals("vbHeight")) {
                    b = 3;
                }
                break;
            case -1470826662:
                if (str.equals("borderTopColor")) {
                    b = 4;
                }
                break;
            case -1308858324:
                if (str.equals("borderBottomColor")) {
                    b = 5;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    b = 6;
                }
                break;
            case -1141400650:
                if (str.equals("accessible")) {
                    b = 7;
                }
                break;
            case -1122140597:
                if (str.equals("borderTopStartRadius")) {
                    b = 8;
                }
                break;
            case -867333731:
                if (str.equals("borderBottomStartRadius")) {
                    b = 9;
                }
                break;
            case -679581037:
                if (str.equals("hasTVPreferredFocus")) {
                    b = 10;
                }
                break;
            case -631506969:
                if (str.equals("nextFocusDown")) {
                    b = 11;
                }
                break;
            case -631278772:
                if (str.equals("nextFocusLeft")) {
                    b = 12;
                }
                break;
            case -483490364:
                if (str.equals("borderTopEndRadius")) {
                    b = 13;
                }
                break;
            case -329721498:
                if (str.equals("bbWidth")) {
                    b = 14;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    b = 15;
                }
                break;
            case -252105751:
                if (str.equals("removeClippedSubviews")) {
                    b = 16;
                }
                break;
            case -242276144:
                if (str.equals("borderLeftColor")) {
                    b = 17;
                }
                break;
            case -223134121:
                if (str.equals("borderStartEndRadius")) {
                    b = 18;
                }
                break;
            case -148030058:
                if (str.equals("borderBottomEndRadius")) {
                    b = 19;
                }
                break;
            case -109689771:
                if (str.equals("nativeForegroundAndroid")) {
                    b = 20;
                }
                break;
            case -27894242:
                if (str.equals("borderStartStartRadius")) {
                    b = 21;
                }
                break;
            case 3351622:
                if (str.equals("minX")) {
                    b = 22;
                }
                break;
            case 3351623:
                if (str.equals("minY")) {
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
            case 240482938:
                if (str.equals("vbWidth")) {
                    b = 26;
                }
                break;
            case 306963138:
                if (str.equals("borderBlockStartColor")) {
                    b = 27;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    b = 28;
                }
                break;
            case 503397728:
                if (str.equals("nextFocusForward")) {
                    b = 29;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    b = 30;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    b = 31;
                }
                break;
            case 660795168:
                if (str.equals("nextFocusUp")) {
                    b = 32;
                }
                break;
            case 684610594:
                if (str.equals("borderBlockColor")) {
                    b = 33;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    b = 34;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    b = 35;
                }
                break;
            case 762983977:
                if (str.equals("borderBlockEndColor")) {
                    b = 36;
                }
                break;
            case 910681861:
                if (str.equals("borderEndStartRadius")) {
                    b = 37;
                }
                break;
            case 926871597:
                if (str.equals("hitSlop")) {
                    b = 38;
                }
                break;
            case 1220735892:
                if (str.equals("borderEndColor")) {
                    b = 39;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    b = 40;
                }
                break;
            case 1629011506:
                if (str.equals("focusable")) {
                    b = 41;
                }
                break;
            case 1667773924:
                if (str.equals("needsOffscreenAlphaCompositing")) {
                    b = 42;
                }
                break;
            case 1735382270:
                if (str.equals("borderEndEndRadius")) {
                    b = 43;
                }
                break;
            case 1747724810:
                if (str.equals("nativeBackgroundAndroid")) {
                    b = 44;
                }
                break;
            case 1908075304:
                if (str.equals("meetOrSlice")) {
                    b = 45;
                }
                break;
            case 1910855543:
                if (str.equals("nextFocusRight")) {
                    b = 46;
                }
                break;
            case 2119889261:
                if (str.equals("borderStartColor")) {
                    b = 47;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBbHeight(view, new DynamicFromObject(obj));
                break;
            case 1:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderRightColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 2:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBackfaceVisibility(view, obj != null ? (String) obj : null);
                break;
            case 3:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setVbHeight(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 4:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderTopColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 5:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBottomColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 6:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderTopLeftRadius(view, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setAccessible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 8:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderTopStartRadius(view, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBottomStartRadius(view, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setHasTVPreferredFocus(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNextFocusDown(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNextFocusLeft(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 13:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderTopEndRadius(view, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBbWidth(view, new DynamicFromObject(obj));
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case 16:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setRemoveClippedSubviews(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 17:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderLeftColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 18:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderStartEndRadius(view, new DynamicFromObject(obj));
                break;
            case 19:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBottomEndRadius(view, new DynamicFromObject(obj));
                break;
            case 20:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNativeForegroundAndroid(view, (ReadableMap) obj);
                break;
            case 21:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderStartStartRadius(view, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setMinX(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 23:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setMinY(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setAlign(view, obj != null ? (String) obj : null);
                break;
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 26:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setVbWidth(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 27:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBlockStartColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 28:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderTopRightRadius(view, new DynamicFromObject(obj));
                break;
            case 29:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNextFocusForward(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 30:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBottomLeftRadius(view, new DynamicFromObject(obj));
                break;
            case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBottomRightRadius(view, new DynamicFromObject(obj));
                break;
            case 32:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNextFocusUp(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 33:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBlockColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 34:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 35:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderStyle(view, obj != null ? (String) obj : null);
                break;
            case 36:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderBlockEndColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 37:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderEndStartRadius(view, new DynamicFromObject(obj));
                break;
            case 38:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setHitSlop(view, new DynamicFromObject(obj));
                break;
            case 39:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderEndColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 40:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderRadius(view, new DynamicFromObject(obj));
                break;
            case 41:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setFocusable(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 42:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNeedsOffscreenAlphaCompositing(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case CodeVerifierUtil.MIN_CODE_VERIFIER_LENGTH /* 43 */:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderEndEndRadius(view, new DynamicFromObject(obj));
                break;
            case 44:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNativeBackgroundAndroid(view, (ReadableMap) obj);
                break;
            case 45:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setMeetOrSlice(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 46:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setNextFocusRight(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 47:
                ((RNSVGSvgViewAndroidManagerInterface) this.mViewManager).setBorderStartColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
