package com.opentokreactnative;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.OTRNPublisherManagerDelegate;
import com.facebook.react.viewmanagers.OTRNPublisherManagerInterface;
import com.opentok.android.SubscriberKit;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = OTRNPublisherManager.REACT_CLASS)
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001:B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u000fH\u0014J\u001a\u0010\u0010\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001dH\u0017J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001fH\u0017J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001dH\u0017J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001dH\u0017J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001fH\u0017J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001dH\u0017J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001dH\u0017J\u0018\u0010%\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001dH\u0017J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001dH\u0017J\u001a\u0010'\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010(\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0017J\u0018\u0010)\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001fH\u0017J\u001a\u0010*\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010+\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0017J\u0018\u0010,\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001dH\u0017J\u0018\u0010-\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020.H\u0017J\u0018\u0010/\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001dH\u0017J\u0018\u00100\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001fH\u0017J\u001a\u00101\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u00102\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0017J\u0018\u00103\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001dH\u0017J\u0018\u00104\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001dH\u0017J\u0018\u00105\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001dH\u0017J\u001a\u00106\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u00107\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0017J\u0014\u00108\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002090\u0011H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/opentokreactnative/OTRNPublisherManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/opentokreactnative/OTRNPublisher;", "Lcom/facebook/react/viewmanagers/OTRNPublisherManagerInterface;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "delegate", "Lcom/facebook/react/viewmanagers/OTRNPublisherManagerDelegate;", "getDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getNativeProps", "", "updateProperties", "", "viewToUpdate", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "setSessionId", "view", "value", "setPublisherId", "publisherId", "setPublishAudio", "", "setDegradationPreference", "", "setPublishVideo", "setPublishCaptions", "setAudioBitrate", "setPublisherAudioFallback", "setSubscriberAudioFallback", "setAudioTrack", "setVideoTrack", "setVideoSource", "setVideoContentHint", "setMaxVideoBitrate", "setVideoBitratePreset", "setCameraPosition", "setCameraTorch", "setCameraZoomFactor", "", "setEnableDtx", "setFrameRate", "setName", "setResolution", "setScalableScreenshare", "setAllowAudioCaptureWhileMuted", "setPublishSenderStats", "setScaleBehavior", "setPreferredVideoCodecs", "getExportedCustomBubblingEventTypeConstants", "", "Companion", "opentok-react-native_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OTRNPublisherManager extends SimpleViewManager<OTRNPublisher> implements OTRNPublisherManagerInterface {
    public static final String REACT_CLASS = "OTRNPublisher";
    private final OTRNPublisherManagerDelegate delegate;

    public OTRNPublisherManager(ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.delegate = new OTRNPublisherManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public OTRNPublisher createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Objects.toString(getNativeProps());
        return new OTRNPublisher(context);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, String> getNativeProps() {
        return super.getNativeProps();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateProperties(OTRNPublisher viewToUpdate, ReactStylesDiffMap props) {
        Intrinsics.checkNotNullParameter(viewToUpdate, "viewToUpdate");
        super.updateProperties(viewToUpdate, props);
        Objects.toString(props);
        viewToUpdate.updateProperties(props);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    public void setSessionId(OTRNPublisher view, String value) {
        if (view != null) {
            view.setSessionId(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    public void setPublisherId(OTRNPublisher view, String publisherId) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPublisherId(publisherId);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "publishAudio")
    public void setPublishAudio(OTRNPublisher view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPublishAudio(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "degradationPreference")
    public void setDegradationPreference(OTRNPublisher view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setDegradationPreference(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = SubscriberKit.VIDEO_REASON_PUBLISH_VIDEO)
    public void setPublishVideo(OTRNPublisher view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPublishVideo(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "publishCaptions")
    public void setPublishCaptions(OTRNPublisher view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPublishCaptions(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "audioBitrate")
    public void setAudioBitrate(OTRNPublisher view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAudioBitrate(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "publisherAudioFallback")
    public void setPublisherAudioFallback(OTRNPublisher view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPublisherAudioFallback(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "subscriberAudioFallback")
    public void setSubscriberAudioFallback(OTRNPublisher view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSubscriberAudioFallback(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "audioTrack")
    public void setAudioTrack(OTRNPublisher view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAudioTrack(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "videoTrack")
    public void setVideoTrack(OTRNPublisher view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVideoTrack(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "videoSource")
    public void setVideoSource(OTRNPublisher view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVideoSource(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "videoContentHint")
    public void setVideoContentHint(OTRNPublisher view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVideoContentHint(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "maxVideoBitrate")
    public void setMaxVideoBitrate(OTRNPublisher view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setMaxVideoBitrate(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "videoBitratePreset")
    public void setVideoBitratePreset(OTRNPublisher view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVideoBitratePreset(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "cameraPosition")
    public void setCameraPosition(OTRNPublisher view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setCameraPosition(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "cameraTorch")
    public void setCameraTorch(OTRNPublisher view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setCameraTorch(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "cameraZoomFactor")
    public void setCameraZoomFactor(OTRNPublisher view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setCameraZoomFactor(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "enableDtx")
    public void setEnableDtx(OTRNPublisher view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnableDtx(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "frameRate")
    public void setFrameRate(OTRNPublisher view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFrameRate(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "name")
    public void setName(OTRNPublisher view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setName(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "resolution")
    public void setResolution(OTRNPublisher view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setResolution(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "scalableScreenshare")
    public void setScalableScreenshare(OTRNPublisher view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScalableScreenshare(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "allowAudioCaptureWhileMuted")
    public void setAllowAudioCaptureWhileMuted(OTRNPublisher view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAllowAudioCaptureWhileMuted(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "publishSenderStats")
    public void setPublishSenderStats(OTRNPublisher view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPublishSenderStats(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "scaleBehavior")
    public void setScaleBehavior(OTRNPublisher view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScaleBehavior(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNPublisherManagerInterface
    @ReactProp(name = "preferredVideoCodecs")
    public void setPreferredVideoCodecs(OTRNPublisher view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPreferredVideoCodecs(value);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapsKt.mapOf(TuplesKt.to("onSubscriberConnected", MapsKt.mapOf(TuplesKt.to("phasedRegistrationNames", MapsKt.mapOf(TuplesKt.to("bubbled", "onSubscriberConnected"), TuplesKt.to("captured", "onSubscriberConnectedCapture"))))));
    }
}
