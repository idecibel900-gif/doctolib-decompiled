package com.airbnb.android.react.lottie;

import android.animation.Animator;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.amazon.device.iap.internal.c.b;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.LottieAnimationViewManagerDelegate;
import com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = "LottieAnimationView")
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0014J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0002H\u0014J\"\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010\u001f\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u001a\u0010&\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u0010H\u0017J\u001a\u0010(\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u0010H\u0017J\u001a\u0010*\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u0017J\u001a\u0010,\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u0017J\u0018\u0010-\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/H\u0017J\u001a\u00100\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u0010H\u0017J\u001a\u00102\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\u0010H\u0017J\u0018\u00104\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\u0006\u00105\u001a\u000206H\u0017J\u0018\u00107\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\u0006\u00108\u001a\u000209H\u0017J\u0018\u0010:\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010;\u001a\u00020/H\u0017J\u0018\u0010<\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010=\u001a\u00020/H\u0017J\u001a\u0010>\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\b\u0010?\u001a\u0004\u0018\u00010\u0010H\u0017J\u0018\u0010@\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010A\u001a\u00020/H\u0017J\u0018\u0010B\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010C\u001a\u00020/H\u0017J\u0018\u0010D\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010E\u001a\u00020/H\u0017J\u001a\u0010F\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\b\u0010G\u001a\u0004\u0018\u00010\u001eH\u0017J\u001a\u0010H\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\b\u0010I\u001a\u0004\u0018\u00010\u001eH\u0017J\u001c\u0010J\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010K\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010L\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00022\b\u0010K\u001a\u0004\u0018\u00010MH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/airbnb/android/react/lottie/LottieAnimationViewManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/facebook/react/viewmanagers/LottieAnimationViewManagerInterface;", "<init>", "()V", "propManagersMap", "Ljava/util/WeakHashMap;", "Lcom/airbnb/android/react/lottie/LottieAnimationViewPropertyManager;", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getOrCreatePropertyManager", "view", "getDelegate", "getExportedViewConstants", "", "", "", "getName", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getExportedCustomDirectEventTypeConstants", "", "onAfterUpdateTransaction", "", "receiveCommand", "root", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "play", "startFrame", "", "endFrame", b.au, "pause", "resume", "setSourceName", "name", "setSourceJson", "json", "setSourceURL", "urlString", "setSourceDotLottieURI", "setCacheComposition", "cacheComposition", "", "setResizeMode", "resizeMode", "setRenderMode", "renderMode", "setProgress", ReactProgressBarViewManager.PROP_PROGRESS, "", "setSpeed", "speed", "", "setLoop", "loop", "setAutoPlay", "autoPlay", "setImageAssetsFolder", "imageAssetsFolder", "setEnableMergePathsAndroidForKitKatAndAbove", "enableMergePaths", "setEnableSafeModeAndroid", "enableSafeMode", "setHardwareAccelerationAndroid", "hardwareAccelerationAndroid", "setColorFilters", "colorFilters", "setTextFiltersAndroid", "textFilters", "setTextFiltersIOS", "value", "setDummy", "Lcom/facebook/react/bridge/ReadableMap;", "lottie-react-native_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LottieAnimationViewManager extends SimpleViewManager<LottieAnimationView> implements LottieAnimationViewManagerInterface {
    private final WeakHashMap<LottieAnimationView, LottieAnimationViewPropertyManager> propManagersMap = new WeakHashMap<>();
    private final ViewManagerDelegate delegate = new LottieAnimationViewManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    public void setDummy(LottieAnimationView view, ReadableMap value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    public void setTextFiltersIOS(LottieAnimationView view, ReadableArray value) {
    }

    private final LottieAnimationViewPropertyManager getOrCreatePropertyManager(LottieAnimationView view) {
        LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager = this.propManagersMap.get(view);
        if (lottieAnimationViewPropertyManager != null) {
            return lottieAnimationViewPropertyManager;
        }
        LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager2 = new LottieAnimationViewPropertyManager(view);
        this.propManagersMap.put(view, lottieAnimationViewPropertyManager2);
        return lottieAnimationViewPropertyManager2;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedViewConstants() {
        return LottieAnimationViewManagerImpl.getExportedViewConstants();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "LottieAnimationView";
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public LottieAnimationView createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final LottieAnimationView lottieAnimationViewCreateViewInstance = LottieAnimationViewManagerImpl.createViewInstance(context);
        lottieAnimationViewCreateViewInstance.setFailureListener(new LottieListener() { // from class: com.airbnb.android.react.lottie.LottieAnimationViewManager$$ExternalSyntheticLambda0
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                LottieAnimationViewManager.createViewInstance$lambda$0(lottieAnimationViewCreateViewInstance, (Throwable) obj);
            }
        });
        lottieAnimationViewCreateViewInstance.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() { // from class: com.airbnb.android.react.lottie.LottieAnimationViewManager$$ExternalSyntheticLambda1
            @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
            public final void onCompositionLoaded(LottieComposition lottieComposition) {
                LottieAnimationViewManagerImpl.sendAnimationLoadedEvent(lottieAnimationViewCreateViewInstance);
            }
        });
        lottieAnimationViewCreateViewInstance.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.airbnb.android.react.lottie.LottieAnimationViewManager.createViewInstance.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                LottieAnimationViewManagerImpl.sendOnAnimationFinishEvent(lottieAnimationViewCreateViewInstance, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                LottieAnimationViewManagerImpl.sendOnAnimationFinishEvent(lottieAnimationViewCreateViewInstance, true);
            }
        });
        return lottieAnimationViewCreateViewInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createViewInstance$lambda$0(LottieAnimationView lottieAnimationView, Throwable th) {
        Intrinsics.checkNotNull(th);
        LottieAnimationViewManagerImpl.sendAnimationFailureEvent(lottieAnimationView, th);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return LottieAnimationViewManagerImpl.getExportedCustomDirectEventTypeConstants();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(LottieAnimationView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        getOrCreatePropertyManager(view).commitChanges();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(LottieAnimationView root, String commandId, ReadableArray args) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        this.delegate.kotlinCompat$receiveCommandNullableArgs(root, commandId, args);
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    public void play(LottieAnimationView view, int startFrame, int endFrame) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.play(view, startFrame, endFrame);
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    public void reset(LottieAnimationView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.reset(view);
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    public void pause(LottieAnimationView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.pause(view);
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    public void resume(LottieAnimationView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.resume(view);
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "sourceName")
    public void setSourceName(LottieAnimationView view, String name) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setSourceName(name, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "sourceJson")
    public void setSourceJson(LottieAnimationView view, String json) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setSourceJson(json, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "sourceURL")
    public void setSourceURL(LottieAnimationView view, String urlString) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setSourceURL(urlString, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "sourceDotLottieURI")
    public void setSourceDotLottieURI(LottieAnimationView view, String urlString) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setSourceDotLottieURI(urlString, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "cacheComposition")
    public void setCacheComposition(LottieAnimationView view, boolean cacheComposition) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setCacheComposition(view, cacheComposition);
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "resizeMode")
    public void setResizeMode(LottieAnimationView view, String resizeMode) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setResizeMode(resizeMode, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "renderMode")
    public void setRenderMode(LottieAnimationView view, String renderMode) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setRenderMode(renderMode, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = ReactProgressBarViewManager.PROP_PROGRESS)
    public void setProgress(LottieAnimationView view, float progress) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setProgress(progress, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "speed")
    public void setSpeed(LottieAnimationView view, double speed) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setSpeed(speed, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "loop")
    public void setLoop(LottieAnimationView view, boolean loop) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setLoop(loop, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "autoPlay")
    public void setAutoPlay(LottieAnimationView view, boolean autoPlay) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setAutoPlay(autoPlay, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "imageAssetsFolder")
    public void setImageAssetsFolder(LottieAnimationView view, String imageAssetsFolder) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setImageAssetsFolder(imageAssetsFolder, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "enableMergePathsAndroidForKitKatAndAbove")
    public void setEnableMergePathsAndroidForKitKatAndAbove(LottieAnimationView view, boolean enableMergePaths) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setEnableMergePaths(enableMergePaths, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "enableSafeModeAndroid")
    public void setEnableSafeModeAndroid(LottieAnimationView view, boolean enableSafeMode) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setEnableSafeMode(enableSafeMode, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "hardwareAccelerationAndroid")
    public void setHardwareAccelerationAndroid(LottieAnimationView view, boolean hardwareAccelerationAndroid) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setHardwareAcceleration(hardwareAccelerationAndroid, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "colorFilters")
    public void setColorFilters(LottieAnimationView view, ReadableArray colorFilters) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setColorFilters(colorFilters, getOrCreatePropertyManager(view));
    }

    @Override // com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface
    @ReactProp(name = "textFiltersAndroid")
    public void setTextFiltersAndroid(LottieAnimationView view, ReadableArray textFilters) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewManagerImpl.setTextFilters(textFilters, getOrCreatePropertyManager(view));
    }
}
