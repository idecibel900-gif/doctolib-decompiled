package com.facebook.react.views.progressbar;

import android.R;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidProgressBarManagerDelegate;
import com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = ReactProgressBarViewManager.REACT_CLASS)
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0001\u0018\u0000 82\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u0004:\u00018B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0017J\u001f\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0017¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u001aH\u0017J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u001cH\u0017J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u001aH\u0017J\u001a\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0017J\b\u0010 \u001a\u00020\u0003H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\"H\u0016J\u0018\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0014J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0014JR\u0010)\u001a\u00020*2\u0006\u0010\u0011\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002012\u0006\u00105\u001a\u0002032\b\u00106\u001a\u0004\u0018\u000107H\u0016R,\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\n0\bX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/react/views/progressbar/ReactProgressBarViewManager;", "Lcom/facebook/react/uimanager/BaseViewManager;", "Lcom/facebook/react/views/progressbar/ProgressBarContainerView;", "Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;", "Lcom/facebook/react/viewmanagers/AndroidProgressBarManagerInterface;", "<init>", "()V", "measuredStyles", "Ljava/util/WeakHashMap;", "", "Landroid/util/Pair;", "getMeasuredStyles$annotations", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setStyleAttr", "", "view", "value", "setColor", "(Lcom/facebook/react/views/progressbar/ProgressBarContainerView;Ljava/lang/Integer;)V", "setIndeterminate", "", "setProgress", "", "setAnimating", "setTestID", "setTypeAttr", "createShadowNodeInstance", "getShadowNodeClass", "Ljava/lang/Class;", "updateExtraData", "root", "extraData", "", "onAfterUpdateTransaction", "getDelegate", "measure", "", "Landroid/content/Context;", "localData", "Lcom/facebook/react/bridge/ReadableMap;", "props", "state", "width", "", "widthMode", "Lcom/facebook/yoga/YogaMeasureMode;", "height", "heightMode", "attachmentsPositions", "", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactProgressBarViewManager extends BaseViewManager<ProgressBarContainerView, ProgressBarShadowNode> implements AndroidProgressBarManagerInterface {
    public static final String DEFAULT_STYLE = "Normal";
    public static final String PROP_ANIMATING = "animating";
    public static final String PROP_ATTR = "typeAttr";
    public static final String PROP_INDETERMINATE = "indeterminate";
    public static final String PROP_PROGRESS = "progress";
    public static final String PROP_STYLE = "styleAttr";
    public static final String REACT_CLASS = "AndroidProgressBar";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object progressBarCtorLock = new Object();
    private final WeakHashMap<Integer, Pair<Integer, Integer>> measuredStyles = new WeakHashMap<>();
    private final ViewManagerDelegate delegate = new AndroidProgressBarManagerDelegate(this);

    private static /* synthetic */ void getMeasuredStyles$annotations() {
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = PROP_ATTR)
    public void setTypeAttr(ProgressBarContainerView view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(ProgressBarContainerView root, Object extraData) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ProgressBarContainerView createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ProgressBarContainerView(context);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = PROP_STYLE)
    public void setStyleAttr(ProgressBarContainerView view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStyle$ReactAndroid_release(value);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(customType = "Color", name = "color")
    public void setColor(ProgressBarContainerView view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setColor$ReactAndroid_release(value);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = PROP_INDETERMINATE)
    public void setIndeterminate(ProgressBarContainerView view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setIndeterminate$ReactAndroid_release(value);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = PROP_PROGRESS)
    public void setProgress(ProgressBarContainerView view, double value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setProgress$ReactAndroid_release(value);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = PROP_ANIMATING)
    public void setAnimating(ProgressBarContainerView view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAnimating$ReactAndroid_release(value);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    public void setTestID(ProgressBarContainerView view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setTestId(view, value);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ProgressBarShadowNode createShadowNodeInstance() {
        return new ProgressBarShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<ProgressBarShadowNode> getShadowNodeClass() {
        return ProgressBarShadowNode.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ProgressBarContainerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.apply$ReactAndroid_release();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public long measure(Context context, ReadableMap localData, ReadableMap props, ReadableMap state, float width, YogaMeasureMode widthMode, float height, YogaMeasureMode heightMode, float[] attachmentsPositions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(localData, "localData");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(widthMode, "widthMode");
        Intrinsics.checkNotNullParameter(heightMode, "heightMode");
        Companion companion = INSTANCE;
        int styleFromString$ReactAndroid_release = companion.getStyleFromString$ReactAndroid_release(props.getString(PROP_STYLE));
        WeakHashMap<Integer, Pair<Integer, Integer>> weakHashMap = this.measuredStyles;
        Integer numValueOf = Integer.valueOf(styleFromString$ReactAndroid_release);
        Pair<Integer, Integer> pairCreate = weakHashMap.get(numValueOf);
        if (pairCreate == null) {
            ProgressBar progressBarCreateProgressBar = companion.createProgressBar(context, styleFromString$ReactAndroid_release);
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            progressBarCreateProgressBar.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            pairCreate = Pair.create(Integer.valueOf(progressBarCreateProgressBar.getMeasuredWidth()), Integer.valueOf(progressBarCreateProgressBar.getMeasuredHeight()));
            weakHashMap.put(numValueOf, pairCreate);
        }
        Pair<Integer, Integer> pair = pairCreate;
        return YogaMeasureOutput.make(PixelUtil.toDIPFromPixel(((Number) pair.first).intValue()), PixelUtil.toDIPFromPixel(((Number) pair.second).intValue()));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ProgressBar createProgressBar(Context context, int i) {
            ProgressBar progressBar;
            synchronized (ReactProgressBarViewManager.progressBarCtorLock) {
                progressBar = new ProgressBar(context, null, i);
            }
            return progressBar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:39:0x0065  */
        /* JADX WARN: Instruction removed from duplicated block: B:39:0x0065, please report this as an issue */
        public final int getStyleFromString$ReactAndroid_release(String str) {
            if (str == null) {
                FLog.w("ReactNative", "ProgressBar needs to have a style, null received");
                return R.attr.progressBarStyle;
            }
            switch (str) {
                case "Normal":
                    if (!str.equals(ReactProgressBarViewManager.DEFAULT_STYLE)) {
                        FLog.w("ReactNative", "Unknown ProgressBar style: " + str);
                    }
                    return R.attr.progressBarStyle;
                case "SmallInverse":
                    return R.attr.progressBarStyleSmallInverse;
                case "Horizontal":
                    return R.attr.progressBarStyleHorizontal;
                case "Inverse":
                    return R.attr.progressBarStyleInverse;
                case "LargeInverse":
                    return R.attr.progressBarStyleLargeInverse;
                case "Large":
                    return R.attr.progressBarStyleLarge;
                case "Small":
                    return R.attr.progressBarStyleSmall;
                default:
                    FLog.w("ReactNative", "Unknown ProgressBar style: " + str);
            }
        }
    }
}
