package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.opentok.android.SubscriberKit;

/* JADX INFO: loaded from: classes3.dex */
public class OTRNSubscriberManagerDelegate extends BaseViewManagerDelegate {
    public OTRNSubscriberManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1157722158:
                if (str.equals("subscribeToCaptions")) {
                    b = 0;
                }
                break;
            case -1087278067:
                if (str.equals("preferredResolution")) {
                    b = 1;
                }
                break;
            case 523417232:
                if (str.equals("audioVolume")) {
                    b = 2;
                }
                break;
            case 607796817:
                if (str.equals("sessionId")) {
                    b = 3;
                }
                break;
            case 977240172:
                if (str.equals("preferredFrameRate")) {
                    b = 4;
                }
                break;
            case 1443136881:
                if (str.equals("subscribeToAudio")) {
                    b = 5;
                }
                break;
            case 1462173206:
                if (str.equals(SubscriberKit.VIDEO_REASON_SUBSCRIBE_TO_VIDEO)) {
                    b = 6;
                }
                break;
            case 1790933179:
                if (str.equals("streamId")) {
                    b = 7;
                }
                break;
            case 1964717500:
                if (str.equals("scaleBehavior")) {
                    b = 8;
                }
                break;
        }
        switch (b) {
            case 0:
                ((OTRNSubscriberManagerInterface) this.mViewManager).setSubscribeToCaptions(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((OTRNSubscriberManagerInterface) this.mViewManager).setPreferredResolution(view, obj != null ? (String) obj : null);
                break;
            case 2:
                ((OTRNSubscriberManagerInterface) this.mViewManager).setAudioVolume(view, obj == null ? 0.0f : ((Double) obj).floatValue());
                break;
            case 3:
                ((OTRNSubscriberManagerInterface) this.mViewManager).setSessionId(view, obj != null ? (String) obj : null);
                break;
            case 4:
                ((OTRNSubscriberManagerInterface) this.mViewManager).setPreferredFrameRate(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 5:
                ((OTRNSubscriberManagerInterface) this.mViewManager).setSubscribeToAudio(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 6:
                ((OTRNSubscriberManagerInterface) this.mViewManager).setSubscribeToVideo(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 7:
                ((OTRNSubscriberManagerInterface) this.mViewManager).setStreamId(view, obj != null ? (String) obj : null);
                break;
            case 8:
                ((OTRNSubscriberManagerInterface) this.mViewManager).setScaleBehavior(view, obj != null ? (String) obj : null);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
