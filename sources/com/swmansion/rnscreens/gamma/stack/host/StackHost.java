package com.swmansion.rnscreens.gamma.stack.host;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreen;
import com.swmansion.rnscreens.utils.RNSLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StackHost extends ViewGroup implements UIManagerListener, StackContainerDelegate, StackContainerParent {
    public static final Companion Companion = new Companion(null);
    private final StackContainer container;
    private final StackContainerUpdateCoordinator containerUpdateCoordinator;
    private final ThemedReactContext reactContext;
    private final ArrayList renderedScreens;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StackScreen.ActivityMode.values().length];
            try {
                iArr[StackScreen.ActivityMode.DETACHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StackScreen.ActivityMode.ATTACHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didDispatchMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didScheduleMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willDispatchViewUpdates(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackHost(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.renderedScreens = new ArrayList();
        StackContainer stackContainer = new StackContainer(reactContext, new WeakReference(this));
        this.container = stackContainer;
        this.containerUpdateCoordinator = new StackContainerUpdateCoordinator();
        addView(stackContainer);
        UIManager uIManager = UIManagerHelper.getUIManager(reactContext, 2);
        if (uIManager == null) {
            throw new IllegalStateException("[RNScreens] UIManager must not be null.");
        }
        uIManager.addUIManagerEventListener(this);
    }

    public final ArrayList<StackScreen> getRenderedScreens$react_native_screens_release() {
        return this.renderedScreens;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        RNSLog.INSTANCE.d("StackHost", "StackHost [" + getId() + "] attached to window");
        super.onAttachedToWindow();
    }

    public final void mountReactSubviewAt$react_native_screens_release(StackScreen stackScreen, int i) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        this.renderedScreens.add(i, stackScreen);
        stackScreen.setStackHost$react_native_screens_release(new WeakReference<>(this));
        addPushOperationIfNeeded(stackScreen);
    }

    public final void unmountReactSubviewAt$react_native_screens_release(int i) {
        Object objRemove = this.renderedScreens.remove(i);
        Intrinsics.checkNotNullExpressionValue(objRemove, "removeAt(...)");
        addPopOperationIfNeeded((StackScreen) objRemove);
    }

    public final void unmountReactSubview$react_native_screens_release(StackScreen reactSubview) {
        Intrinsics.checkNotNullParameter(reactSubview, "reactSubview");
        this.renderedScreens.remove(reactSubview);
        addPopOperationIfNeeded(reactSubview);
    }

    public final void unmountAllReactSubviews$react_native_screens_release() {
        Iterator it = CollectionsKt.asReversedMutable(this.renderedScreens).iterator();
        while (it.hasNext()) {
            addPopOperationIfNeeded((StackScreen) it.next());
        }
        this.renderedScreens.clear();
    }

    private final void addPushOperationIfNeeded(StackScreen stackScreen) {
        if (stackScreen.getActivityMode() == StackScreen.ActivityMode.ATTACHED) {
            this.containerUpdateCoordinator.addPushOperation$react_native_screens_release(stackScreen);
        }
    }

    private final void addPopOperationIfNeeded(StackScreen stackScreen) {
        if (stackScreen.getActivityMode() == StackScreen.ActivityMode.ATTACHED && !stackScreen.isNativelyDismissed$react_native_screens_release()) {
            this.containerUpdateCoordinator.addPopOperation$react_native_screens_release(stackScreen);
        } else {
            stackScreen.getScreenKey();
        }
    }

    public final void stackScreenChangedActivityMode$react_native_screens_release(StackScreen stackScreen) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        int i = WhenMappings.$EnumSwitchMapping$0[stackScreen.getActivityMode().ordinal()];
        if (i == 1) {
            this.containerUpdateCoordinator.addPopOperation$react_native_screens_release(stackScreen);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.containerUpdateCoordinator.addPushOperation$react_native_screens_release(stackScreen);
        }
    }

    @Override // com.swmansion.rnscreens.gamma.stack.host.StackContainerDelegate
    public void onScreenDismissCommitted(StackScreen stackScreen) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        if (stackScreen.getActivityMode() == StackScreen.ActivityMode.ATTACHED) {
            stackScreen.setNativelyDismissed$react_native_screens_release(true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.container.measure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.container.layout(i, i2, i3, i4);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.host.StackContainerParent
    public void layoutContainerNow() {
        if (getMeasuredWidth() != this.container.getMeasuredWidth() || getMeasuredHeight() != this.container.getMeasuredHeight()) {
            this.container.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        }
        this.container.layout(getLeft(), getTop(), getRight(), getBottom());
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        this.containerUpdateCoordinator.executePendingOperationsIfNeeded$react_native_screens_release(this.container, this.renderedScreens);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
