package com.swmansion.rnscreens;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.events.HeaderBackButtonClickedEvent;
import com.swmansion.rnscreens.events.ScreenAppearEvent;
import com.swmansion.rnscreens.events.ScreenDisappearEvent;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import com.swmansion.rnscreens.events.ScreenWillAppearEvent;
import com.swmansion.rnscreens.events.ScreenWillDisappearEvent;
import com.swmansion.rnscreens.ext.ViewExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0012\b\u0016\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0003RSQB\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u0004J-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b&\u0010\"J\u000f\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010\u0004J\u001f\u0010+\u001a\u00020\b2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0014H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\b2\u0006\u0010\r\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\b2\u0006\u0010\r\u001a\u00020-H\u0016¢\u0006\u0004\b0\u0010/J\u000f\u00101\u001a\u00020\bH\u0016¢\u0006\u0004\b1\u0010\u0004J\u000f\u00102\u001a\u00020\bH\u0016¢\u0006\u0004\b2\u0010\u0004J\u000f\u00103\u001a\u00020\bH\u0016¢\u0006\u0004\b3\u0010\u0004J\u000f\u00104\u001a\u00020\bH\u0002¢\u0006\u0004\b4\u0010\u0004J\u000f\u00105\u001a\u00020\bH\u0002¢\u0006\u0004\b5\u0010\u0004J\u000f\u00106\u001a\u00020\bH\u0002¢\u0006\u0004\b6\u0010\u0004J\u000f\u00107\u001a\u00020\bH\u0002¢\u0006\u0004\b7\u0010\u0004J\u000f\u00108\u001a\u00020\bH\u0002¢\u0006\u0004\b8\u0010\u0004J\u0017\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u00020\u0014H\u0002¢\u0006\u0004\b:\u0010;R(\u0010<\u001a\u00020\u00058\u0016@\u0016X\u0096.¢\u0006\u0018\n\u0004\b<\u0010=\u0012\u0004\bA\u0010\u0004\u001a\u0004\b>\u0010?\"\u0004\b@\u0010\u0007R \u0010C\u001a\b\u0012\u0004\u0012\u00020-0B8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010HR\u0016\u0010L\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010HR\u0016\u0010M\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010HR\u0014\u0010P\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006T"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "<init>", "()V", "Lcom/swmansion/rnscreens/Screen;", "screenView", "(Lcom/swmansion/rnscreens/Screen;)V", "", "onResume", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onContainerUpdate", "", "isTranslucent", "()Z", "Landroid/app/Activity;", "tryGetActivity", "()Landroid/app/Activity;", "Lcom/facebook/react/bridge/ReactContext;", "tryGetContext", "()Lcom/facebook/react/bridge/ReactContext;", "Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;", "event", "canDispatchLifecycleEvent", "(Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;)Z", "updateLastEventDispatched", "(Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;)V", "fragmentWrapper", "dispatchLifecycleEvent", "(Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;Lcom/swmansion/rnscreens/ScreenFragmentWrapper;)V", "dispatchLifecycleEventInChildContainers", "dispatchHeaderBackButtonClickedEvent", "", "alpha", "closing", "dispatchTransitionProgressEvent", "(FZ)V", "Lcom/swmansion/rnscreens/ScreenContainer;", "addChildScreenContainer", "(Lcom/swmansion/rnscreens/ScreenContainer;)V", "removeChildScreenContainer", "onViewAnimationStart", "onViewAnimationEnd", "onDestroy", "updateWindowTraits", "dispatchOnWillAppear", "dispatchOnAppear", "dispatchOnWillDisappear", "dispatchOnDisappear", "animationEnd", "dispatchViewAnimationEvent", "(Z)V", "screen", "Lcom/swmansion/rnscreens/Screen;", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "setScreen", "getScreen$annotations", "", "childScreenContainers", "Ljava/util/List;", "getChildScreenContainers", "()Ljava/util/List;", "shouldUpdateOnResume", "Z", "transitionProgress", "F", "canDispatchWillAppear", "canDispatchAppear", "isTransitioning", "getFragment", "()Landroidx/fragment/app/Fragment;", AuthorizationRequest.ResponseMode.FRAGMENT, "Companion", "ScreenLifecycleEvent", "ScreensFrameLayout", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ScreenFragment extends Fragment implements ScreenFragmentWrapper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean canDispatchAppear;
    private boolean canDispatchWillAppear;
    private final List childScreenContainers;
    private boolean isTransitioning;
    public Screen screen;
    private boolean shouldUpdateOnResume;
    private float transitionProgress;

    public enum ScreenLifecycleEvent {
        DID_APPEAR,
        WILL_APPEAR,
        DID_DISAPPEAR,
        WILL_DISAPPEAR;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScreenLifecycleEvent.values().length];
            try {
                iArr[ScreenLifecycleEvent.WILL_APPEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScreenLifecycleEvent.DID_APPEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScreenLifecycleEvent.WILL_DISAPPEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ScreenLifecycleEvent.DID_DISAPPEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.swmansion.rnscreens.FragmentHolder
    public Fragment getFragment() {
        return this;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public boolean isTranslucent() {
        return false;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public Screen getScreen() {
        Screen screen = this.screen;
        if (screen != null) {
            return screen;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screen");
        return null;
    }

    public void setScreen(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<set-?>");
        this.screen = screen;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public List getChildScreenContainers() {
        return this.childScreenContainers;
    }

    public ScreenFragment() {
        this.childScreenContainers = new ArrayList();
        this.transitionProgress = -1.0f;
        this.canDispatchWillAppear = true;
        this.canDispatchAppear = true;
        throw new IllegalStateException("Screen fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    public ScreenFragment(Screen screenView) {
        Intrinsics.checkNotNullParameter(screenView, "screenView");
        this.childScreenContainers = new ArrayList();
        this.transitionProgress = -1.0f;
        this.canDispatchWillAppear = true;
        this.canDispatchAppear = true;
        setScreen(screenView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.shouldUpdateOnResume) {
            this.shouldUpdateOnResume = false;
            ScreenWindowTraits.INSTANCE.trySetWindowTraits$react_native_screens_release(getScreen(), tryGetActivity(), tryGetContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        getScreen().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = getContext();
        if (context == null) {
            return null;
        }
        ScreensFrameLayout screensFrameLayout = new ScreensFrameLayout(context);
        screensFrameLayout.addView(ViewExtKt.recycle(getScreen()));
        return screensFrameLayout;
    }

    private static final class ScreensFrameLayout extends FrameLayout {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScreensFrameLayout(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // android.view.ViewGroup, android.view.View
        public void clearFocus() {
            if (getVisibility() != 4) {
                super.clearFocus();
            }
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onContainerUpdate() {
        updateWindowTraits();
    }

    private final void updateWindowTraits() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            this.shouldUpdateOnResume = true;
        } else {
            ScreenWindowTraits.INSTANCE.trySetWindowTraits$react_native_screens_release(getScreen(), activity, tryGetContext());
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public Activity tryGetActivity() {
        Fragment fragment;
        FragmentActivity activity;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            return activity2;
        }
        Context context = getScreen().getContext();
        if (context instanceof ReactContext) {
            ReactContext reactContext = (ReactContext) context;
            if (reactContext.getCurrentActivity() != null) {
                return reactContext.getCurrentActivity();
            }
        }
        for (ViewParent container = getScreen().getContainer(); container != null; container = container.getParent()) {
            if ((container instanceof Screen) && (fragment = ((Screen) container).getFragment()) != null && (activity = fragment.getActivity()) != null) {
                return activity;
            }
        }
        return null;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public ReactContext tryGetContext() {
        if (getContext() instanceof ReactContext) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context;
        }
        if (getScreen().getContext() instanceof ReactContext) {
            Context context2 = getScreen().getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context2;
        }
        for (ViewParent container = getScreen().getContainer(); container != null; container = container.getParent()) {
            if (container instanceof Screen) {
                Screen screen = (Screen) container;
                if (screen.getContext() instanceof ReactContext) {
                    Context context3 = screen.getContext();
                    Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                    return (ReactContext) context3;
                }
            }
        }
        return null;
    }

    public boolean canDispatchLifecycleEvent(ScreenLifecycleEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            return this.canDispatchWillAppear;
        }
        if (i == 2) {
            return this.canDispatchAppear;
        }
        if (i == 3) {
            return !this.canDispatchWillAppear;
        }
        if (i == 4) {
            return !this.canDispatchAppear;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void updateLastEventDispatched(ScreenLifecycleEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            this.canDispatchWillAppear = false;
            return;
        }
        if (i == 2) {
            this.canDispatchAppear = false;
        } else if (i == 3) {
            this.canDispatchWillAppear = true;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            this.canDispatchAppear = true;
        }
    }

    private final void dispatchOnWillAppear() {
        dispatchLifecycleEvent(ScreenLifecycleEvent.WILL_APPEAR, this);
        dispatchTransitionProgressEvent(0.0f, false);
    }

    private final void dispatchOnAppear() {
        dispatchLifecycleEvent(ScreenLifecycleEvent.DID_APPEAR, this);
        dispatchTransitionProgressEvent(1.0f, false);
    }

    private final void dispatchOnWillDisappear() {
        dispatchLifecycleEvent(ScreenLifecycleEvent.WILL_DISAPPEAR, this);
        dispatchTransitionProgressEvent(0.0f, true);
    }

    private final void dispatchOnDisappear() {
        dispatchLifecycleEvent(ScreenLifecycleEvent.DID_DISAPPEAR, this);
        dispatchTransitionProgressEvent(1.0f, true);
    }

    public void dispatchLifecycleEvent(ScreenLifecycleEvent event, ScreenFragmentWrapper fragmentWrapper) {
        Event screenWillAppearEvent;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragmentWrapper");
        Fragment fragment = fragmentWrapper.getFragment();
        if (fragment instanceof ScreenStackFragment) {
            ScreenStackFragment screenStackFragment = (ScreenStackFragment) fragment;
            if (screenStackFragment.canDispatchLifecycleEvent(event)) {
                Screen screen = screenStackFragment.getScreen();
                fragmentWrapper.updateLastEventDispatched(event);
                int surfaceId = UIManagerHelper.getSurfaceId(screen);
                int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                if (i == 1) {
                    screenWillAppearEvent = new ScreenWillAppearEvent(surfaceId, screen.getId());
                } else if (i == 2) {
                    screenWillAppearEvent = new ScreenAppearEvent(surfaceId, screen.getId());
                } else if (i == 3) {
                    screenWillAppearEvent = new ScreenWillDisappearEvent(surfaceId, screen.getId());
                } else {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    screenWillAppearEvent = new ScreenDisappearEvent(surfaceId, screen.getId());
                }
                Context context = getScreen().getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getScreen().getId());
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(screenWillAppearEvent);
                }
                fragmentWrapper.dispatchLifecycleEventInChildContainers(event);
            }
        }
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void dispatchLifecycleEventInChildContainers(ScreenLifecycleEvent event) {
        ScreenFragmentWrapper fragmentWrapper;
        Intrinsics.checkNotNullParameter(event, "event");
        List childScreenContainers = getChildScreenContainers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : childScreenContainers) {
            if (((ScreenContainer) obj).getScreenCount() > 0) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Screen topScreen = ((ScreenContainer) it.next()).getTopScreen();
            if (topScreen != null && (fragmentWrapper = topScreen.getFragmentWrapper()) != null) {
                dispatchLifecycleEvent(event, fragmentWrapper);
            }
        }
    }

    public void dispatchHeaderBackButtonClickedEvent() {
        Context context = getScreen().getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getScreen().getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new HeaderBackButtonClickedEvent(surfaceId, getScreen().getId()));
        }
    }

    public void dispatchTransitionProgressEvent(float alpha, boolean closing) {
        if (!(this instanceof ScreenStackFragment) || this.transitionProgress == alpha) {
            return;
        }
        float fMax = Math.max(0.0f, Math.min(1.0f, alpha));
        this.transitionProgress = fMax;
        short coalescingKey = INSTANCE.getCoalescingKey(fMax);
        ScreenStackFragment screenStackFragment = (ScreenStackFragment) this;
        ScreenContainer container = screenStackFragment.getScreen().getContainer();
        boolean goingForward = container instanceof ScreenStack ? ((ScreenStack) container).getGoingForward() : false;
        Context context = screenStackFragment.getScreen().getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, screenStackFragment.getScreen().getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new ScreenTransitionProgressEvent(UIManagerHelper.getSurfaceId(reactContext), screenStackFragment.getScreen().getId(), this.transitionProgress, closing, goingForward, coalescingKey));
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void addChildScreenContainer(ScreenContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        getChildScreenContainers().add(container);
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void removeChildScreenContainer(ScreenContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        getChildScreenContainers().remove(container);
    }

    public void onViewAnimationStart() {
        dispatchViewAnimationEvent(false);
    }

    public void onViewAnimationEnd() {
        dispatchViewAnimationEvent(true);
    }

    private final void dispatchViewAnimationEvent(final boolean animationEnd) {
        this.isTransitioning = !animationEnd;
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null || ((parentFragment instanceof ScreenFragment) && !((ScreenFragment) parentFragment).isTransitioning)) {
            if (isResumed()) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.rnscreens.ScreenFragment$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScreenFragment.dispatchViewAnimationEvent$lambda$8(animationEnd, this);
                    }
                });
            } else if (animationEnd) {
                dispatchOnDisappear();
            } else {
                dispatchOnWillDisappear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchViewAnimationEvent$lambda$8(boolean z, ScreenFragment screenFragment) {
        if (z) {
            screenFragment.dispatchOnAppear();
        } else {
            screenFragment.dispatchOnWillAppear();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ScreenContainer container = getScreen().getContainer();
        if (container == null || !container.hasScreen(getScreen().getFragmentWrapper())) {
            Context context = getScreen().getContext();
            if (context instanceof ReactContext) {
                int surfaceId = UIManagerHelper.getSurfaceId(context);
                EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getScreen().getId());
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(new ScreenDismissedEvent(surfaceId, getScreen().getId()));
                }
            }
        }
        getChildScreenContainers().clear();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final short getCoalescingKey(float f) {
            int i;
            if (f == 0.0f) {
                i = 1;
            } else {
                i = f == 1.0f ? 2 : 3;
            }
            return (short) i;
        }

        private Companion() {
        }
    }
}
