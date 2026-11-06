package com.dylanvann.fastimage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PorterDuff;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.model.GlideUrl;
import com.dylanvann.fastimage.events.FastImageProgressEvent;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.FastImageViewManagerDelegate;
import com.facebook.react.viewmanagers.FastImageViewManagerInterface;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
class FastImageViewManager extends SimpleViewManager<FastImageViewWithUrl> implements FastImageProgressListener, FastImageViewManagerInterface {
    static final String REACT_CLASS = "FastImageView";
    static final String REACT_ON_LOAD_START_EVENT = "onFastImageLoadStart";
    static final String REACT_ON_PROGRESS_EVENT = "onFastImageProgress";
    private static final Map<String, List<FastImageViewWithUrl>> VIEWS_FOR_URLS = new WeakHashMap();
    private RequestManager requestManager = null;
    private final ViewManagerDelegate mDelegate = new FastImageViewManagerDelegate(this);

    public float getGranularityPercentage() {
        return 0.5f;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public FastImageViewWithUrl createViewInstance(ThemedReactContext themedReactContext) {
        if (isValidContextForGlide(themedReactContext)) {
            this.requestManager = Glide.with(themedReactContext);
        }
        return new FastImageViewWithUrl(themedReactContext);
    }

    @Override // com.facebook.react.viewmanagers.FastImageViewManagerInterface
    @ReactProp(name = Constants.ScionAnalytics.PARAM_SOURCE)
    public void setSource(FastImageViewWithUrl fastImageViewWithUrl, ReadableMap readableMap) {
        fastImageViewWithUrl.setSource(readableMap);
    }

    @Override // com.facebook.react.viewmanagers.FastImageViewManagerInterface
    @ReactProp(name = "defaultSource")
    public void setDefaultSource(FastImageViewWithUrl fastImageViewWithUrl, String str) {
        ResourceDrawableIdHelper.getInstance();
        fastImageViewWithUrl.setDefaultSource(ResourceDrawableIdHelper.getResourceDrawable(fastImageViewWithUrl.getContext(), str));
    }

    @Override // com.facebook.react.viewmanagers.FastImageViewManagerInterface
    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(FastImageViewWithUrl fastImageViewWithUrl, Integer num) {
        if (num == null) {
            fastImageViewWithUrl.clearColorFilter();
        } else {
            fastImageViewWithUrl.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @Override // com.facebook.react.viewmanagers.FastImageViewManagerInterface
    @ReactProp(name = "resizeMode")
    public void setResizeMode(FastImageViewWithUrl fastImageViewWithUrl, String str) {
        fastImageViewWithUrl.setScaleType(FastImageViewConverter.getScaleType(str));
    }

    @Override // com.facebook.react.viewmanagers.FastImageViewManagerInterface
    @ReactProp(name = "blurRadius")
    public void setBlurRadius(FastImageViewWithUrl fastImageViewWithUrl, int i) {
        fastImageViewWithUrl.setBlurRadius(Integer.valueOf(i));
    }

    @Override // com.facebook.react.viewmanagers.FastImageViewManagerInterface
    @ReactProp(name = "transition")
    public void setTransition(FastImageViewWithUrl fastImageViewWithUrl, String str) {
        fastImageViewWithUrl.setTransition(str);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(FastImageViewWithUrl fastImageViewWithUrl) {
        fastImageViewWithUrl.clearView(this.requestManager);
        GlideUrl glideUrl = fastImageViewWithUrl.glideUrl;
        if (glideUrl != null) {
            String string = glideUrl.toString();
            FastImageOkHttpProgressGlideModule.forget(string);
            Map<String, List<FastImageViewWithUrl>> map = VIEWS_FOR_URLS;
            List<FastImageViewWithUrl> list = map.get(string);
            if (list != null) {
                list.remove(fastImageViewWithUrl);
                if (list.size() == 0) {
                    map.remove(string);
                }
            }
        }
        super.onDropViewInstance(fastImageViewWithUrl);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put(REACT_ON_LOAD_START_EVENT, MapBuilder.of("registrationName", REACT_ON_LOAD_START_EVENT)).put(REACT_ON_PROGRESS_EVENT, MapBuilder.of("registrationName", REACT_ON_PROGRESS_EVENT)).put("onFastImageLoad", MapBuilder.of("registrationName", "onFastImageLoad")).put("onFastImageError", MapBuilder.of("registrationName", "onFastImageError")).put("onFastImageLoadEnd", MapBuilder.of("registrationName", "onFastImageLoadEnd")).build();
    }

    public void onProgress(String str, long j, long j2) {
        List<FastImageViewWithUrl> list = VIEWS_FOR_URLS.get(str);
        if (list != null) {
            for (FastImageViewWithUrl fastImageViewWithUrl : list) {
                ThemedReactContext themedReactContext = (ThemedReactContext) fastImageViewWithUrl.getContext();
                EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(themedReactContext, fastImageViewWithUrl.getId());
                FastImageProgressEvent fastImageProgressEvent = new FastImageProgressEvent(UIManagerHelper.getSurfaceId(themedReactContext), fastImageViewWithUrl.getId(), (int) j, (int) j2);
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(fastImageProgressEvent);
                }
            }
        }
    }

    private static boolean isValidContextForGlide(Context context) {
        Activity activityFromContext = getActivityFromContext(context);
        if (activityFromContext == null) {
            return false;
        }
        return !isActivityDestroyed(activityFromContext);
    }

    private static Activity getActivityFromContext(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ThemedReactContext)) {
            return null;
        }
        Context baseContext = ((ThemedReactContext) context).getBaseContext();
        if (baseContext instanceof Activity) {
            return (Activity) baseContext;
        }
        if (!(baseContext instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext2 = ((ContextWrapper) baseContext).getBaseContext();
        if (baseContext2 instanceof Activity) {
            return (Activity) baseContext2;
        }
        return null;
    }

    private static boolean isActivityDestroyed(Activity activity) {
        return activity.isDestroyed() || activity.isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(FastImageViewWithUrl fastImageViewWithUrl) {
        super.onAfterUpdateTransaction(fastImageViewWithUrl);
        fastImageViewWithUrl.onAfterUpdate(this, this.requestManager, VIEWS_FOR_URLS);
    }
}
