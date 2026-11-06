package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.opentok.android.SubscriberKit;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class OTRNPublisherManagerDelegate extends BaseViewManagerDelegate {
    public OTRNPublisherManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1891311609:
                if (str.equals("publishAudio")) {
                    b = 0;
                }
                break;
            case -1872275284:
                if (str.equals(SubscriberKit.VIDEO_REASON_PUBLISH_VIDEO)) {
                    b = 1;
                }
                break;
            case -1688626505:
                if (str.equals("audioBitrate")) {
                    b = 2;
                }
                break;
            case -1651485689:
                if (str.equals("cameraZoomFactor")) {
                    b = 3;
                }
                break;
            case -1628077680:
                if (str.equals("videoTrack")) {
                    b = 4;
                }
                break;
            case -1619104037:
                if (str.equals("publishSenderStats")) {
                    b = 5;
                }
                break;
            case -1613884938:
                if (str.equals("maxVideoBitrate")) {
                    b = 6;
                }
                break;
            case -1600030548:
                if (str.equals("resolution")) {
                    b = 7;
                }
                break;
            case -1355866786:
                if (str.equals("scalableScreenshare")) {
                    b = 8;
                }
                break;
            case -1000357903:
                if (str.equals("videoBitratePreset")) {
                    b = 9;
                }
                break;
            case -892851419:
                if (str.equals("videoContentHint")) {
                    b = 10;
                }
                break;
            case -704717769:
                if (str.equals("preferredVideoCodecs")) {
                    b = 11;
                }
                break;
            case -631679643:
                if (str.equals("enableDtx")) {
                    b = 12;
                }
                break;
            case -614130633:
                if (str.equals("publisherId")) {
                    b = 13;
                }
                break;
            case -464008338:
                if (str.equals("cameraPosition")) {
                    b = 14;
                }
                break;
            case -319836287:
                if (str.equals("degradationPreference")) {
                    b = 15;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = 16;
                }
                break;
            case 545057773:
                if (str.equals("frameRate")) {
                    b = 17;
                }
                break;
            case 585901436:
                if (str.equals("publishCaptions")) {
                    b = 18;
                }
                break;
            case 589970768:
                if (str.equals("subscriberAudioFallback")) {
                    b = 19;
                }
                break;
            case 607796817:
                if (str.equals("sessionId")) {
                    b = 20;
                }
                break;
            case 1038409846:
                if (str.equals("videoSource")) {
                    b = 21;
                }
                break;
            case 1228283411:
                if (str.equals("allowAudioCaptureWhileMuted")) {
                    b = 22;
                }
                break;
            case 1539136277:
                if (str.equals("audioTrack")) {
                    b = 23;
                }
                break;
            case 1964717500:
                if (str.equals("scaleBehavior")) {
                    b = 24;
                }
                break;
            case 2048872407:
                if (str.equals("cameraTorch")) {
                    b = 25;
                }
                break;
            case 2110462012:
                if (str.equals("publisherAudioFallback")) {
                    b = 26;
                }
                break;
        }
        switch (b) {
            case 0:
                ((OTRNPublisherManagerInterface) this.mViewManager).setPublishAudio(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((OTRNPublisherManagerInterface) this.mViewManager).setPublishVideo(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 2:
                ((OTRNPublisherManagerInterface) this.mViewManager).setAudioBitrate(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 3:
                ((OTRNPublisherManagerInterface) this.mViewManager).setCameraZoomFactor(view, obj == null ? 0.0f : ((Double) obj).floatValue());
                break;
            case 4:
                ((OTRNPublisherManagerInterface) this.mViewManager).setVideoTrack(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 5:
                ((OTRNPublisherManagerInterface) this.mViewManager).setPublishSenderStats(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 6:
                ((OTRNPublisherManagerInterface) this.mViewManager).setMaxVideoBitrate(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 7:
                ((OTRNPublisherManagerInterface) this.mViewManager).setResolution(view, obj != null ? (String) obj : null);
                break;
            case 8:
                ((OTRNPublisherManagerInterface) this.mViewManager).setScalableScreenshare(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 9:
                ((OTRNPublisherManagerInterface) this.mViewManager).setVideoBitratePreset(view, obj != null ? (String) obj : null);
                break;
            case 10:
                ((OTRNPublisherManagerInterface) this.mViewManager).setVideoContentHint(view, obj != null ? (String) obj : null);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((OTRNPublisherManagerInterface) this.mViewManager).setPreferredVideoCodecs(view, obj != null ? (String) obj : null);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((OTRNPublisherManagerInterface) this.mViewManager).setEnableDtx(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 13:
                ((OTRNPublisherManagerInterface) this.mViewManager).setPublisherId(view, obj != null ? (String) obj : null);
                break;
            case 14:
                ((OTRNPublisherManagerInterface) this.mViewManager).setCameraPosition(view, obj != null ? (String) obj : null);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((OTRNPublisherManagerInterface) this.mViewManager).setDegradationPreference(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 16:
                ((OTRNPublisherManagerInterface) this.mViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case 17:
                ((OTRNPublisherManagerInterface) this.mViewManager).setFrameRate(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 18:
                ((OTRNPublisherManagerInterface) this.mViewManager).setPublishCaptions(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 19:
                ((OTRNPublisherManagerInterface) this.mViewManager).setSubscriberAudioFallback(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 20:
                ((OTRNPublisherManagerInterface) this.mViewManager).setSessionId(view, obj != null ? (String) obj : null);
                break;
            case 21:
                ((OTRNPublisherManagerInterface) this.mViewManager).setVideoSource(view, obj != null ? (String) obj : null);
                break;
            case 22:
                ((OTRNPublisherManagerInterface) this.mViewManager).setAllowAudioCaptureWhileMuted(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 23:
                ((OTRNPublisherManagerInterface) this.mViewManager).setAudioTrack(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                ((OTRNPublisherManagerInterface) this.mViewManager).setScaleBehavior(view, obj != null ? (String) obj : null);
                break;
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                ((OTRNPublisherManagerInterface) this.mViewManager).setCameraTorch(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 26:
                ((OTRNPublisherManagerInterface) this.mViewManager).setPublisherAudioFallback(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
