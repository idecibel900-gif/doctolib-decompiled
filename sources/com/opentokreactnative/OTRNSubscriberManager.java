package com.opentokreactnative;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.OTRNSubscriberManagerDelegate;
import com.facebook.react.viewmanagers.OTRNSubscriberManagerInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = OTRNSubscriberManager.REACT_CLASS)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001(B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u000fH\u0014J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010\u0018\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0019H\u0016J\u001a\u0010\u001b\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0019H\u0016J\u001a\u0010\u001c\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u001fH\u0016J\u001c\u0010 \u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020'0&H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/opentokreactnative/OTRNSubscriberManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/opentokreactnative/OTRNSubscriber;", "Lcom/facebook/react/viewmanagers/OTRNSubscriberManagerInterface;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "delegate", "Lcom/facebook/react/viewmanagers/OTRNSubscriberManagerDelegate;", "getDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setStreamId", "", "view", "streamId", "setSessionId", "sessionId", "setScaleBehavior", "value", "setSubscribeToAudio", "", "setSubscribeToVideo", "setSubscribeToCaptions", "setAudioVolume", "", "setPreferredFrameRate", "", "setPreferredResolution", "updateProperties", "viewToUpdate", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "getExportedCustomBubblingEventTypeConstants", "", "", "Companion", "opentok-react-native_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OTRNSubscriberManager extends SimpleViewManager<OTRNSubscriber> implements OTRNSubscriberManagerInterface {
    public static final String REACT_CLASS = "OTRNSubscriber";
    private final OTRNSubscriberManagerDelegate delegate;

    public OTRNSubscriberManager(ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.delegate = new OTRNSubscriberManagerDelegate(this);
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
    public OTRNSubscriber createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new OTRNSubscriber(context);
    }

    @Override // com.facebook.react.viewmanagers.OTRNSubscriberManagerInterface
    @ReactProp(name = "streamId")
    public void setStreamId(OTRNSubscriber view, String streamId) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStreamId(streamId);
    }

    @Override // com.facebook.react.viewmanagers.OTRNSubscriberManagerInterface
    @ReactProp(name = "sessionId")
    public void setSessionId(OTRNSubscriber view, String sessionId) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSessionId(sessionId);
    }

    @Override // com.facebook.react.viewmanagers.OTRNSubscriberManagerInterface
    @ReactProp(name = "scaleBehavior")
    public void setScaleBehavior(OTRNSubscriber view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScaleBehavior(value);
    }

    @Override // com.facebook.react.viewmanagers.OTRNSubscriberManagerInterface
    public void setSubscribeToAudio(OTRNSubscriber view, boolean value) {
        if (view != null) {
            view.setSubscribeToAudio(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.OTRNSubscriberManagerInterface
    public void setSubscribeToVideo(OTRNSubscriber view, boolean value) {
        if (view != null) {
            view.setSubscribeToVideo(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.OTRNSubscriberManagerInterface
    public void setSubscribeToCaptions(OTRNSubscriber view, boolean value) {
        if (view != null) {
            view.setSubscribeToCaptions(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.OTRNSubscriberManagerInterface
    public void setAudioVolume(OTRNSubscriber view, float value) {
        if (view != null) {
            view.setAudioVolume(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.OTRNSubscriberManagerInterface
    public void setPreferredFrameRate(OTRNSubscriber view, int value) {
        if (view != null) {
            view.setPreferredFrameRate(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.OTRNSubscriberManagerInterface
    public void setPreferredResolution(OTRNSubscriber view, String value) {
        if (view != null) {
            view.setPreferredResolution(value);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateProperties(OTRNSubscriber viewToUpdate, ReactStylesDiffMap props) {
        Intrinsics.checkNotNullParameter(viewToUpdate, "viewToUpdate");
        super.updateProperties(viewToUpdate, props);
        viewToUpdate.updateProperties(props);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapsKt.mapOf(TuplesKt.to("onSubscriberConnected", MapsKt.mapOf(TuplesKt.to("phasedRegistrationNames", MapsKt.mapOf(TuplesKt.to("bubbled", "onSubscriberConnected"), TuplesKt.to("captured", "onSubscriberConnectedCapture"))))));
    }
}
