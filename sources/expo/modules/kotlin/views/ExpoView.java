package expo.modules.kotlin.views;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.StateWrapper;
import expo.modules.kotlin.AppContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ExpoView extends LinearLayout {
    private final AppContext appContext;
    private final ShadowNodeProxy shadowNodeProxy;
    private final boolean shouldUseAndroidLayout;
    private StateWrapper stateWrapper;

    public final AppContext getAppContext() {
        return this.appContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoView(Context context, AppContext appContext) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
        this.shadowNodeProxy = new ShadowNodeProxy(this);
    }

    public final StateWrapper getStateWrapper() {
        return this.stateWrapper;
    }

    public final void setStateWrapper(StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    public final ShadowNodeProxy getShadowNodeProxy() {
        return this.shadowNodeProxy;
    }

    public boolean getShouldUseAndroidLayout() {
        return this.shouldUseAndroidLayout;
    }

    public final void measureAndLayout() {
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        if (getShouldUseAndroidLayout()) {
            post(new Runnable() { // from class: expo.modules.kotlin.views.ExpoView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.measureAndLayout();
                }
            });
        }
    }

    public void clipToPaddingBox(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getClipToPadding()) {
            BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        clipToPaddingBox(canvas);
        super.dispatchDraw(canvas);
    }
}
