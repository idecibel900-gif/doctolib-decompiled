package com.swmansion.rnscreens.gamma.stack.screen;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.react.uimanager.ThemedReactContext;
import com.swmansion.rnscreens.ext.ViewExtKt;
import com.swmansion.rnscreens.gamma.common.FragmentProviding;
import com.swmansion.rnscreens.gamma.stack.host.StackHost;
import java.lang.ref.WeakReference;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
public final class StackScreen extends ViewGroup implements FragmentProviding {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackScreen.class, "isPreventNativeDismissEnabled", "isPreventNativeDismissEnabled$react_native_screens_release()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackScreen.class, "activityMode", "getActivityMode()Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen$ActivityMode;", 0))};
    private final ReadWriteProperty activityMode$delegate;
    public StackScreenEventEmitter eventEmitter;
    private boolean isNativelyDismissed;
    private final ReadWriteProperty isPreventNativeDismissEnabled$delegate;
    private PreventNativeDismissChangeObserver preventNativeDismissChangeObserver;
    private final ThemedReactContext reactContext;
    private String screenKey;
    private WeakReference stackHost;

    public enum ActivityMode {
        DETACHED,
        ATTACHED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackScreen(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        setTransitionGroup(true);
        Delegates delegates = Delegates.INSTANCE;
        final Boolean bool = Boolean.FALSE;
        this.isPreventNativeDismissEnabled$delegate = new ObservableProperty(bool) { // from class: com.swmansion.rnscreens.gamma.stack.screen.StackScreen$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                PreventNativeDismissChangeObserver preventNativeDismissChangeObserver$react_native_screens_release;
                Intrinsics.checkNotNullParameter(property, "property");
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                if (((Boolean) obj).booleanValue() == zBooleanValue || (preventNativeDismissChangeObserver$react_native_screens_release = this.getPreventNativeDismissChangeObserver$react_native_screens_release()) == null) {
                    return;
                }
                preventNativeDismissChangeObserver$react_native_screens_release.preventNativeDismissChanged(zBooleanValue);
            }
        };
        this.stackHost = new WeakReference(null);
        final ActivityMode activityMode = ActivityMode.DETACHED;
        this.activityMode$delegate = new ObservableProperty(activityMode) { // from class: com.swmansion.rnscreens.gamma.stack.screen.StackScreen$special$$inlined$observable$2
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                StackHost stackHost;
                Intrinsics.checkNotNullParameter(property, "property");
                if (((StackScreen.ActivityMode) obj) == ((StackScreen.ActivityMode) obj2) || (stackHost = this.getStackHost$react_native_screens_release().get()) == null) {
                    return;
                }
                stackHost.stackScreenChangedActivityMode$react_native_screens_release(this);
            }
        };
    }

    public final boolean isPreventNativeDismissEnabled$react_native_screens_release() {
        return ((Boolean) this.isPreventNativeDismissEnabled$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setPreventNativeDismissEnabled$react_native_screens_release(boolean z) {
        this.isPreventNativeDismissEnabled$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final boolean isNativelyDismissed$react_native_screens_release() {
        return this.isNativelyDismissed;
    }

    public final void setNativelyDismissed$react_native_screens_release(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("[RNScreens] Natively dismissed StackScreen must remain dismissed.");
        }
        this.isNativelyDismissed = true;
    }

    public final WeakReference<StackHost> getStackHost$react_native_screens_release() {
        return this.stackHost;
    }

    public final void setStackHost$react_native_screens_release(WeakReference<StackHost> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.stackHost = weakReference;
    }

    public final ActivityMode getActivityMode() {
        return (ActivityMode) this.activityMode$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setActivityMode(ActivityMode activityMode) {
        Intrinsics.checkNotNullParameter(activityMode, "<set-?>");
        this.activityMode$delegate.setValue(this, $$delegatedProperties[1], activityMode);
    }

    public final String getScreenKey() {
        return this.screenKey;
    }

    public final void setScreenKey(String str) {
        if (this.screenKey != null) {
            throw new IllegalArgumentException("[RNScreens] StackScreen can't change its screenKey.");
        }
        this.screenKey = str;
    }

    public final StackScreenEventEmitter getEventEmitter$react_native_screens_release() {
        StackScreenEventEmitter stackScreenEventEmitter = this.eventEmitter;
        if (stackScreenEventEmitter != null) {
            return stackScreenEventEmitter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
        return null;
    }

    public final void setEventEmitter$react_native_screens_release(StackScreenEventEmitter stackScreenEventEmitter) {
        Intrinsics.checkNotNullParameter(stackScreenEventEmitter, "<set-?>");
        this.eventEmitter = stackScreenEventEmitter;
    }

    public final PreventNativeDismissChangeObserver getPreventNativeDismissChangeObserver$react_native_screens_release() {
        return this.preventNativeDismissChangeObserver;
    }

    public final void setPreventNativeDismissChangeObserver$react_native_screens_release(PreventNativeDismissChangeObserver preventNativeDismissChangeObserver) {
        this.preventNativeDismissChangeObserver = preventNativeDismissChangeObserver;
    }

    public final void onViewManagerAddEventEmitters$react_native_screens_release() {
        if (getId() == -1) {
            throw new IllegalStateException("[RNScreens] StackScreen must have its tag set when registering event emitters");
        }
        setEventEmitter$react_native_screens_release(new StackScreenEventEmitter(this.reactContext, getId()));
    }

    public final StackScreenAppearanceEventsEmitter createAppearanceEventsEmitter$react_native_screens_release(LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        return new StackScreenAppearanceEventsEmitter(viewLifecycleOwner.getLifecycle(), getEventEmitter$react_native_screens_release());
    }

    public final void onDismiss$react_native_screens_release() {
        if (getActivityMode() == ActivityMode.ATTACHED) {
            setNativelyDismissed$react_native_screens_release(true);
        }
        getEventEmitter$react_native_screens_release().emitOnDismiss$react_native_screens_release(this.isNativelyDismissed);
    }

    public final void onNativeDismissPrevented$react_native_screens_release() {
        getEventEmitter$react_native_screens_release().emitOnNativeDismissPrevented$react_native_screens_release();
    }

    @Override // com.swmansion.rnscreens.gamma.common.FragmentProviding
    public Fragment getAssociatedFragment() {
        Fragment fragmentFindFragmentOrNull = ViewExtKt.findFragmentOrNull(this);
        if (fragmentFindFragmentOrNull == null) {
            return null;
        }
        if (fragmentFindFragmentOrNull instanceof StackScreenFragment) {
            return fragmentFindFragmentOrNull;
        }
        throw new IllegalStateException(("[RNScreens] Unexpected fragment type: " + fragmentFindFragmentOrNull.getClass().getSimpleName()).toString());
    }
}
