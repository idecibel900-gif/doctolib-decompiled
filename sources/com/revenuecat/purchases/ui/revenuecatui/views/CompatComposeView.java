package com.revenuecat.purchases.ui.revenuecatui.views;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ContextExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0017\b'\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002<=B%\b\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0004J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020%H\u0002J\b\u0010+\u001a\u00020%H\u0014J\b\u0010,\u001a\u00020%H\u0016J\b\u0010-\u001a\u00020%H\u0002J\b\u0010.\u001a\u00020%H\u0014J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\n\u00102\u001a\u0004\u0018\u000101H\u0014J\u0010\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020\rH\u0016J\u0010\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020\nH\u0014J\u0012\u00107\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0012\u00108\u001a\u0002092\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u000e\u0010:\u001a\u0004\u0018\u00010;*\u00020;H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006>"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/views/CompatComposeView;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isManagingLifecycle", "", "isManagingSavedState", "isManagingViewModelStore", "isManagingViewTree", "()Z", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycleObserver", "com/revenuecat/purchases/ui/revenuecatui/views/CompatComposeView$lifecycleObserver$1", "Lcom/revenuecat/purchases/ui/revenuecatui/views/CompatComposeView$lifecycleObserver$1;", "lifecycleOwner", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "deinitViewTreeOwners", "", "destroy", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "initViewTreeOwners", "onAttachedToWindow", "onBackPressed", "onDestroy", "onDetachedFromWindow", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "onWindowFocusChanged", "hasWindowFocus", "onWindowVisibilityChanged", "visibility", "performRestore", "performSave", "Landroid/os/Bundle;", "findWindowRoot", "Landroid/view/View;", "Companion", "ViewLifecycleOwner", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class CompatComposeView extends AbstractComposeView implements LifecycleOwner, SavedStateRegistryOwner, ViewModelStoreOwner {
    private static final String KEY_SAVED_INSTANCE_STATE = "com.revenuecat.CompatComposeView.saved_instance_state";
    private boolean isManagingLifecycle;
    private boolean isManagingSavedState;
    private boolean isManagingViewModelStore;
    private final CompatComposeView$lifecycleObserver$1 lifecycleObserver;
    private LifecycleOwner lifecycleOwner;
    private final SavedStateRegistry savedStateRegistry;
    private final SavedStateRegistryController savedStateRegistryController;
    private final ViewModelStore viewModelStore;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompatComposeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompatComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CompatComposeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.revenuecat.purchases.ui.revenuecatui.views.CompatComposeView$lifecycleObserver$1] */
    public CompatComposeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.lifecycleObserver = new DefaultLifecycleObserver() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CompatComposeView$lifecycleObserver$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                this.this$0.onDestroy();
            }
        };
        SavedStateRegistryController savedStateRegistryControllerCreate = SavedStateRegistryController.Companion.create(this);
        this.savedStateRegistryController = savedStateRegistryControllerCreate;
        this.savedStateRegistry = savedStateRegistryControllerCreate.getSavedStateRegistry();
        this.viewModelStore = new ViewModelStore();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/views/CompatComposeView$Companion;", "", "()V", "KEY_SAVED_INSTANCE_STATE", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/views/CompatComposeView$ViewLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityLifecycleCallbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "destroy", "", "onAttachedToWindow", "onDetachedFromWindow", "onWindowFocusChanged", "hasWindowFocus", "", "onWindowVisibilityChanged", "visibility", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class ViewLifecycleOwner implements LifecycleOwner {
        private final Activity activity;
        private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

        public ViewLifecycleOwner(final Activity activity) {
            this.activity = activity;
            if (activity != null) {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CompatComposeView$ViewLifecycleOwner$1$1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity2, Bundle savedInstanceState) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity2, Bundle outState) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                        Intrinsics.checkNotNullParameter(outState, "outState");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity destroyedActivity) {
                        Intrinsics.checkNotNullParameter(destroyedActivity, "destroyedActivity");
                        if (destroyedActivity == activity) {
                            this.destroy();
                        }
                    }
                };
                Application application = activity.getApplication();
                if (application != null) {
                    application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
                this.activityLifecycleCallbacks = activityLifecycleCallbacks;
            }
        }

        @Override // androidx.lifecycle.LifecycleOwner
        public Lifecycle getLifecycle() {
            return this.lifecycleRegistry;
        }

        public final void onAttachedToWindow() {
            this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        }

        public final void onDetachedFromWindow() {
            destroy();
        }

        public final void onWindowVisibilityChanged(int visibility) {
            if (visibility == 0) {
                this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
            } else {
                this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            }
        }

        public final void onWindowFocusChanged(boolean hasWindowFocus) {
            if (hasWindowFocus) {
                this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            } else {
                this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
            }
        }

        public final void destroy() {
            Application application;
            if (this.lifecycleRegistry.getCurrentState() == Lifecycle.State.DESTROYED) {
                return;
            }
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.activityLifecycleCallbacks;
            if (activityLifecycleCallbacks != null) {
                Activity activity = this.activity;
                if (activity != null && (application = activity.getApplication()) != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
                this.activityLifecycleCallbacks = null;
            }
            if (this.lifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            }
            this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
    }

    private final boolean isManagingViewTree() {
        return this.isManagingLifecycle || this.isManagingSavedState || this.isManagingViewModelStore;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        return (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? new Lifecycle() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CompatComposeView$lifecycle$1
            @Override // androidx.lifecycle.Lifecycle
            public Lifecycle.State getCurrentState() {
                return Lifecycle.State.INITIALIZED;
            }

            @Override // androidx.lifecycle.Lifecycle
            public void addObserver(LifecycleObserver observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                Logger.INSTANCE.e("CompatComposeView: Attempted to add a LifecycleObserver when no LifecycleOwner is set.");
            }

            @Override // androidx.lifecycle.Lifecycle
            public void removeObserver(LifecycleObserver observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                Logger.INSTANCE.e("CompatComposeView: Attempted to remove LifecycleObserver when no LifecycleOwner is set.");
            }
        } : lifecycle;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return this.viewModelStore;
    }

    public void onBackPressed() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (this.isManagingSavedState) {
            performSave(parcelableOnSaveInstanceState);
        }
        return parcelableOnSaveInstanceState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        if (this.isManagingSavedState) {
            performRestore(state);
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycleOwner instanceof ViewLifecycleOwner)) {
            Logger.INSTANCE.w("Attaching a previously-detached view to a window. Resetting state");
            ((ViewLifecycleOwner) lifecycleOwner).destroy();
            onDestroy();
        }
        initViewTreeOwners();
        if (this.isManagingSavedState) {
            this.savedStateRegistryController.performAttach();
            performRestore(null);
        }
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
        ViewLifecycleOwner viewLifecycleOwner = lifecycleOwner2 instanceof ViewLifecycleOwner ? (ViewLifecycleOwner) lifecycleOwner2 : null;
        if (viewLifecycleOwner != null) {
            viewLifecycleOwner.onAttachedToWindow();
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        ViewLifecycleOwner viewLifecycleOwner = lifecycleOwner instanceof ViewLifecycleOwner ? (ViewLifecycleOwner) lifecycleOwner : null;
        if (viewLifecycleOwner != null) {
            viewLifecycleOwner.onWindowVisibilityChanged(visibility);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus && isManagingViewTree()) {
            setFocusableInTouchMode(true);
            setFocusable(true);
            requestFocus();
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        ViewLifecycleOwner viewLifecycleOwner = lifecycleOwner instanceof ViewLifecycleOwner ? (ViewLifecycleOwner) lifecycleOwner : null;
        if (viewLifecycleOwner != null) {
            viewLifecycleOwner.onWindowFocusChanged(hasWindowFocus);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        ViewLifecycleOwner viewLifecycleOwner = lifecycleOwner instanceof ViewLifecycleOwner ? (ViewLifecycleOwner) lifecycleOwner : null;
        if (viewLifecycleOwner != null) {
            viewLifecycleOwner.onDetachedFromWindow();
        }
        deinitViewTreeOwners();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isManagingViewTree()) {
            return super.dispatchKeyEvent(event);
        }
        if (event.getKeyCode() == 4 && event.getAction() == 1) {
            onBackPressed();
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    protected final void destroy() {
        Logger.INSTANCE.d("CompatComposeView: Destroying lifecycle owner since destroy() was called.");
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        ViewLifecycleOwner viewLifecycleOwner = lifecycleOwner instanceof ViewLifecycleOwner ? (ViewLifecycleOwner) lifecycleOwner : null;
        if (viewLifecycleOwner != null) {
            viewLifecycleOwner.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDestroy() {
        Lifecycle lifecycle;
        if (this.isManagingViewModelStore) {
            getViewModelStore().clear();
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.lifecycleObserver);
        }
        this.lifecycleOwner = null;
    }

    private final Bundle performSave(Parcelable state) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_SAVED_INSTANCE_STATE, state);
        this.savedStateRegistryController.performSave(bundle);
        return bundle;
    }

    private final void performRestore(Parcelable state) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_SAVED_INSTANCE_STATE, state);
        this.savedStateRegistryController.performRestore(bundle);
    }

    private final void initViewTreeOwners() {
        LifecycleOwner viewLifecycleOwner;
        View viewFindWindowRoot = findWindowRoot(this);
        if (viewFindWindowRoot == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(viewFindWindowRoot);
        if (this.lifecycleOwner == null) {
            if (lifecycleOwner == null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                viewLifecycleOwner = new ViewLifecycleOwner(ContextExtensionsKt.getActivity(context));
            } else {
                viewLifecycleOwner = lifecycleOwner;
            }
            this.lifecycleOwner = viewLifecycleOwner;
            getLifecycle().addObserver(this.lifecycleObserver);
        }
        if (lifecycleOwner == null) {
            ViewTreeLifecycleOwner.set(viewFindWindowRoot, this);
            this.isManagingLifecycle = true;
        }
        if (ViewTreeSavedStateRegistryOwner.get(viewFindWindowRoot) == null) {
            ViewTreeSavedStateRegistryOwner.set(viewFindWindowRoot, this);
            this.isManagingSavedState = true;
        }
        if (ViewTreeViewModelStoreOwner.get(viewFindWindowRoot) == null) {
            ViewTreeViewModelStoreOwner.set(viewFindWindowRoot, this);
            this.isManagingViewModelStore = true;
        }
    }

    private final void deinitViewTreeOwners() {
        View viewFindWindowRoot;
        if (isManagingViewTree() && (viewFindWindowRoot = findWindowRoot(this)) != null) {
            if (ViewTreeLifecycleOwner.get(viewFindWindowRoot) == this) {
                ViewTreeLifecycleOwner.set(viewFindWindowRoot, null);
            }
            if (ViewTreeSavedStateRegistryOwner.get(viewFindWindowRoot) == this) {
                ViewTreeSavedStateRegistryOwner.set(viewFindWindowRoot, null);
            }
            if (ViewTreeViewModelStoreOwner.get(viewFindWindowRoot) == this) {
                ViewTreeViewModelStoreOwner.set(viewFindWindowRoot, null);
            }
        }
    }

    private final View findWindowRoot(View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = null;
        while (parent != null && (parent instanceof ViewGroup)) {
            viewGroup = (ViewGroup) parent;
            parent = viewGroup.getParent();
        }
        return viewGroup;
    }
}
