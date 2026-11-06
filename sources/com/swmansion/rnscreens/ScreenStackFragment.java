package com.swmansion.rnscreens;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.Animation;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.swmansion.rnscreens.bottomsheet.BottomSheetTransitionCoordinator;
import com.swmansion.rnscreens.bottomsheet.BottomSheetWindowInsetListenerChain;
import com.swmansion.rnscreens.bottomsheet.DimmingViewManager;
import com.swmansion.rnscreens.bottomsheet.SheetDelegate;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.ext.ViewExtKt;
import com.swmansion.rnscreens.stack.views.ScreensCoordinatorLayout;
import com.swmansion.rnscreens.utils.DeviceUtils;
import com.swmansion.rnscreens.utils.ViewBackgroundUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0006J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0019\u0010*\u001a\u00020)2\b\b\u0002\u0010(\u001a\u00020\u0016H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0016H\u0016¢\u0006\u0004\b/\u0010\u0018J\u000f\u00100\u001a\u00020\bH\u0016¢\u0006\u0004\b0\u0010\u0007J\u0017\u00103\u001a\u00020\b2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020\u0016H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\b2\u0006\u00108\u001a\u00020\u0016H\u0016¢\u0006\u0004\b9\u00107J\u000f\u0010:\u001a\u00020\bH\u0016¢\u0006\u0004\b:\u0010\u0007J\u000f\u0010;\u001a\u00020\bH\u0016¢\u0006\u0004\b;\u0010\u0007J\u000f\u0010=\u001a\u00020\bH\u0000¢\u0006\u0004\b<\u0010\u0007J\u0019\u0010@\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010>H\u0016¢\u0006\u0004\b@\u0010AJ+\u0010F\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020B2\b\u0010E\u001a\u0004\u0018\u00010D2\b\u0010?\u001a\u0004\u0018\u00010>H\u0016¢\u0006\u0004\bF\u0010GJ!\u0010I\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u001d2\b\u0010?\u001a\u0004\u0018\u00010>H\u0016¢\u0006\u0004\bI\u0010JJ)\u0010O\u001a\u0004\u0018\u00010N2\u0006\u0010K\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020\u0012H\u0016¢\u0006\u0004\bO\u0010PJ)\u0010Q\u001a\u0004\u0018\u00010\n2\u0006\u0010K\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020\u0012H\u0016¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\bH\u0016¢\u0006\u0004\bS\u0010\u0007J\u000f\u0010T\u001a\u00020\bH\u0016¢\u0006\u0004\bT\u0010\u0007J\u0017\u0010U\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\bU\u0010\u001cJ\u001f\u0010W\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010C\u001a\u00020VH\u0016¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\u0016H\u0016¢\u0006\u0004\bY\u0010\u0018J\u000f\u0010Z\u001a\u00020\bH\u0016¢\u0006\u0004\bZ\u0010\u0007J\u000f\u0010^\u001a\u00020[H\u0000¢\u0006\u0004\b\\\u0010]R\u0018\u0010`\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010bR\u0016\u0010c\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010e\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010dR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010fR\u0018\u0010g\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR$\u0010j\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR0\u0010q\u001a\u0010\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u00020\b\u0018\u00010p8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0016\u0010x\u001a\u00020w8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010z\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R%\u0010|\u001a\u0004\u0018\u00010,8\u0000@\u0000X\u0080\u000e¢\u0006\u0013\n\u0004\b|\u0010}\u001a\u0004\b~\u0010.\"\u0005\b\u007f\u0010\u0080\u0001R*\u0010\u0081\u0001\u001a\u0004\u0018\u00010[8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0005\b\u0083\u0001\u0010]\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u008b\u0001\u001a\u00030\u0088\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001¨\u0006\u008c\u0001"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment;", "Lcom/swmansion/rnscreens/ScreenFragment;", "Lcom/swmansion/rnscreens/ScreenStackFragmentWrapper;", "Lcom/swmansion/rnscreens/Screen;", "screenView", "<init>", "(Lcom/swmansion/rnscreens/Screen;)V", "()V", "", "notifyViewAppearTransitionEnd", "Landroid/animation/Animator;", "createSheetEnterAnimator", "()Landroid/animation/Animator;", "createSheetExitAnimator", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "createBottomSheetBehaviour", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "screen", "", "resolveBackgroundColor", "(Lcom/swmansion/rnscreens/Screen;)Ljava/lang/Integer;", "attachShapeToScreen", "", "shouldShowSearchBar", "()Z", "Landroid/view/Menu;", "menu", "updateToolbarMenu", "(Landroid/view/Menu;)V", "Landroid/view/View;", "findLastFocusedChild", "()Landroid/view/View;", "Lcom/swmansion/rnscreens/bottomsheet/BottomSheetTransitionCoordinator;", "sheetTransitionCoordinator", "attachInsetsAndLayoutListenersToBottomSheet", "(Lcom/swmansion/rnscreens/bottomsheet/BottomSheetTransitionCoordinator;)V", "Landroidx/core/view/WindowInsetsCompat;", "insetsCompat", "handleInsetsUpdateAndNotifyTransition", "(Landroidx/core/view/WindowInsetsCompat;)V", "forceCreation", "Lcom/swmansion/rnscreens/bottomsheet/DimmingViewManager;", "requireDimmingDelegate", "(Z)Lcom/swmansion/rnscreens/bottomsheet/DimmingViewManager;", "Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate;", "requireSheetDelegate", "()Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate;", "isTranslucent", "removeToolbar", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "hidden", "setToolbarShadowHidden", "(Z)V", "translucent", "setToolbarTranslucent", "onContainerUpdate", "onViewAnimationEnd", "dismissSelf$react_native_screens_release", "dismissSelf", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "transit", "enter", "nextAnim", "Landroid/view/animation/Animation;", "onCreateAnimation", "(IZI)Landroid/view/animation/Animation;", "onCreateAnimator", "(IZI)Landroid/animation/Animator;", "onStart", "onStop", "onPrepareOptionsMenu", "Landroid/view/MenuInflater;", "onCreateOptionsMenu", "(Landroid/view/Menu;Landroid/view/MenuInflater;)V", "canNavigateBack", "dismissFromContainer", "Lcom/swmansion/rnscreens/bottomsheet/BottomSheetWindowInsetListenerChain;", "requireBottomSheetWindowInsetsListenerChain$react_native_screens_release", "()Lcom/swmansion/rnscreens/bottomsheet/BottomSheetWindowInsetListenerChain;", "requireBottomSheetWindowInsetsListenerChain", "Lcom/swmansion/rnscreens/CustomAppBarLayout;", "appBarLayout", "Lcom/swmansion/rnscreens/CustomAppBarLayout;", "Landroidx/appcompat/widget/Toolbar;", "isToolbarShadowHidden", "Z", "isToolbarTranslucent", "Lcom/swmansion/rnscreens/bottomsheet/BottomSheetTransitionCoordinator;", "lastFocusedChild", "Landroid/view/View;", "Lcom/swmansion/rnscreens/CustomSearchView;", "searchView", "Lcom/swmansion/rnscreens/CustomSearchView;", "getSearchView", "()Lcom/swmansion/rnscreens/CustomSearchView;", "setSearchView", "(Lcom/swmansion/rnscreens/CustomSearchView;)V", "Lkotlin/Function1;", "onSearchViewCreate", "Lkotlin/jvm/functions/Function1;", "getOnSearchViewCreate", "()Lkotlin/jvm/functions/Function1;", "setOnSearchViewCreate", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/swmansion/rnscreens/stack/views/ScreensCoordinatorLayout;", "coordinatorLayout", "Lcom/swmansion/rnscreens/stack/views/ScreensCoordinatorLayout;", "dimmingDelegate", "Lcom/swmansion/rnscreens/bottomsheet/DimmingViewManager;", "sheetDelegate", "Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate;", "getSheetDelegate$react_native_screens_release", "setSheetDelegate$react_native_screens_release", "(Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate;)V", "bottomSheetWindowInsetListenerChain", "Lcom/swmansion/rnscreens/bottomsheet/BottomSheetWindowInsetListenerChain;", "getBottomSheetWindowInsetListenerChain$react_native_screens_release", "setBottomSheetWindowInsetListenerChain$react_native_screens_release", "(Lcom/swmansion/rnscreens/bottomsheet/BottomSheetWindowInsetListenerChain;)V", "lastInsetsCompat", "Landroidx/core/view/WindowInsetsCompat;", "Lcom/swmansion/rnscreens/ScreenStack;", "getScreenStack", "()Lcom/swmansion/rnscreens/ScreenStack;", "screenStack", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenStackFragment extends ScreenFragment implements ScreenStackFragmentWrapper {
    private CustomAppBarLayout appBarLayout;
    private BottomSheetWindowInsetListenerChain bottomSheetWindowInsetListenerChain;
    private ScreensCoordinatorLayout coordinatorLayout;
    private DimmingViewManager dimmingDelegate;
    private boolean isToolbarShadowHidden;
    private boolean isToolbarTranslucent;
    private View lastFocusedChild;
    private WindowInsetsCompat lastInsetsCompat;
    private Function1 onSearchViewCreate;
    private CustomSearchView searchView;
    private SheetDelegate sheetDelegate;
    private BottomSheetTransitionCoordinator sheetTransitionCoordinator;
    private Toolbar toolbar;

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return null;
    }

    public final CustomSearchView getSearchView() {
        return this.searchView;
    }

    public final void setOnSearchViewCreate(Function1 function1) {
        this.onSearchViewCreate = function1;
    }

    private final ScreenStack getScreenStack() {
        ScreenContainer container = getScreen().getContainer();
        if (!(container instanceof ScreenStack)) {
            throw new IllegalStateException("ScreenStackFragment added into a non-stack container");
        }
        return (ScreenStack) container;
    }

    /* JADX INFO: renamed from: getSheetDelegate$react_native_screens_release, reason: from getter */
    public final SheetDelegate getSheetDelegate() {
        return this.sheetDelegate;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenStackFragment(Screen screenView) {
        super(screenView);
        Intrinsics.checkNotNullParameter(screenView, "screenView");
    }

    public ScreenStackFragment() {
        throw new IllegalStateException("ScreenStack fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    @Override // com.swmansion.rnscreens.ScreenFragment, com.swmansion.rnscreens.ScreenFragmentWrapper
    public boolean isTranslucent() {
        return getScreen().isTranslucent();
    }

    public void removeToolbar() {
        Toolbar toolbar;
        CustomAppBarLayout customAppBarLayout = this.appBarLayout;
        if (customAppBarLayout != null && (toolbar = this.toolbar) != null && toolbar.getParent() == customAppBarLayout) {
            customAppBarLayout.removeView(toolbar);
        }
        this.toolbar = null;
    }

    public void setToolbar(Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        CustomAppBarLayout customAppBarLayout = this.appBarLayout;
        if (customAppBarLayout != null) {
            customAppBarLayout.addView(toolbar);
        }
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -2);
        layoutParams.setScrollFlags(0);
        toolbar.setLayoutParams(layoutParams);
        this.toolbar = toolbar;
    }

    public void setToolbarShadowHidden(boolean hidden) {
        if (this.isToolbarShadowHidden != hidden) {
            CustomAppBarLayout customAppBarLayout = this.appBarLayout;
            if (customAppBarLayout != null) {
                customAppBarLayout.setElevation(hidden ? 0.0f : PixelUtil.toPixelFromDIP(4.0f));
            }
            CustomAppBarLayout customAppBarLayout2 = this.appBarLayout;
            if (customAppBarLayout2 != null) {
                customAppBarLayout2.setStateListAnimator(null);
            }
            this.isToolbarShadowHidden = hidden;
        }
    }

    public void setToolbarTranslucent(boolean translucent) {
        if (this.isToolbarTranslucent != translucent) {
            ViewGroup.LayoutParams layoutParams = getScreen().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(translucent ? null : new AppBarLayout.ScrollingViewBehavior());
            this.isToolbarTranslucent = translucent;
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragment, com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onContainerUpdate() {
        super.onContainerUpdate();
        ScreenStackHeaderConfig headerConfig = getScreen().getHeaderConfig();
        if (headerConfig != null) {
            headerConfig.onUpdate();
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragment
    public void onViewAnimationEnd() {
        super.onViewAnimationEnd();
        notifyViewAppearTransitionEnd();
        getScreen().endRemovalTransition();
    }

    private final void notifyViewAppearTransitionEnd() {
        View view = getView();
        ViewParent parent = view != null ? view.getParent() : null;
        if (parent instanceof ScreenStack) {
            ((ScreenStack) parent).onViewAppearTransitionEnd();
        }
    }

    public final void dismissSelf$react_native_screens_release() {
        if (isRemoving() && isDetached()) {
            return;
        }
        ThemedReactContext reactContext = getScreen().getReactContext();
        int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getScreen().getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new ScreenDismissedEvent(surfaceId, getScreen().getId()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.swmansion.rnscreens.ScreenFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CoordinatorLayout.Behavior scrollingViewBehavior;
        CustomAppBarLayout customAppBarLayout;
        CustomAppBarLayout customAppBarLayout2;
        CustomAppBarLayout customAppBarLayout3;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.coordinatorLayout = new ScreensCoordinatorLayout(contextRequireContext, this);
        Screen screen = getScreen();
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        if (SheetUtilsKt.usesFormSheetPresentation(getScreen())) {
            scrollingViewBehavior = createBottomSheetBehaviour();
        } else {
            scrollingViewBehavior = this.isToolbarTranslucent ? null : new AppBarLayout.ScrollingViewBehavior();
        }
        layoutParams.setBehavior(scrollingViewBehavior);
        screen.setLayoutParams(layoutParams);
        ScreensCoordinatorLayout screensCoordinatorLayout = this.coordinatorLayout;
        if (screensCoordinatorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
            screensCoordinatorLayout = null;
        }
        screensCoordinatorLayout.addView(ViewExtKt.recycle(getScreen()));
        if (!SheetUtilsKt.usesFormSheetPresentation(getScreen())) {
            Context context = getContext();
            if (context != null) {
                customAppBarLayout = new CustomAppBarLayout(context);
                customAppBarLayout.setBackgroundColor(0);
                customAppBarLayout.setLayoutParams(new AppBarLayout.LayoutParams(-1, -2));
            } else {
                customAppBarLayout = null;
            }
            this.appBarLayout = customAppBarLayout;
            ScreensCoordinatorLayout screensCoordinatorLayout2 = this.coordinatorLayout;
            if (screensCoordinatorLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout2 = null;
            }
            screensCoordinatorLayout2.addView(this.appBarLayout);
            if (this.isToolbarShadowHidden && (customAppBarLayout3 = this.appBarLayout) != null) {
                customAppBarLayout3.setTargetElevation(0.0f);
            }
            Toolbar toolbar = this.toolbar;
            if (toolbar != null && (customAppBarLayout2 = this.appBarLayout) != null) {
                customAppBarLayout2.addView(ViewExtKt.recycle(toolbar));
            }
            setHasOptionsMenu(true);
        } else {
            getScreen().setClipToOutline(true);
            attachShapeToScreen(getScreen());
            getScreen().setElevation(getScreen().getSheetElevation());
            final SheetDelegate sheetDelegateRequireSheetDelegate = requireSheetDelegate();
            BottomSheetBehavior<Screen> sheetBehavior = getScreen().getSheetBehavior();
            Intrinsics.checkNotNull(sheetBehavior);
            SheetDelegate.configureBottomSheetBehaviour$react_native_screens_release$default(sheetDelegateRequireSheetDelegate, sheetBehavior, null, 0, 6, null);
            DimmingViewManager dimmingViewManagerRequireDimmingDelegate = requireDimmingDelegate(true);
            Screen screen2 = getScreen();
            ScreensCoordinatorLayout screensCoordinatorLayout3 = this.coordinatorLayout;
            if (screensCoordinatorLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout3 = null;
            }
            dimmingViewManagerRequireDimmingDelegate.onViewHierarchyCreated(screen2, screensCoordinatorLayout3);
            Screen screen3 = getScreen();
            BottomSheetBehavior<Screen> sheetBehavior2 = getScreen().getSheetBehavior();
            Intrinsics.checkNotNull(sheetBehavior2);
            dimmingViewManagerRequireDimmingDelegate.onBehaviourAttached(screen3, sheetBehavior2);
            if (!getScreen().getSheetShouldOverflowTopInset()) {
                BottomSheetTransitionCoordinator bottomSheetTransitionCoordinator = new BottomSheetTransitionCoordinator();
                this.sheetTransitionCoordinator = bottomSheetTransitionCoordinator;
                attachInsetsAndLayoutListenersToBottomSheet(bottomSheetTransitionCoordinator);
            }
            ScreenContainer container2 = getScreen().getContainer();
            Intrinsics.checkNotNull(container2);
            ScreensCoordinatorLayout screensCoordinatorLayout4 = this.coordinatorLayout;
            if (screensCoordinatorLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout4 = null;
            }
            screensCoordinatorLayout4.measure(View.MeasureSpec.makeMeasureSpec(container2.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(container2.getHeight(), 1073741824));
            ScreensCoordinatorLayout screensCoordinatorLayout5 = this.coordinatorLayout;
            if (screensCoordinatorLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout5 = null;
            }
            screensCoordinatorLayout5.layout(0, 0, container2.getWidth(), container2.getHeight());
            if (Build.VERSION.SDK_INT < 30) {
                BottomSheetWindowInsetListenerChain bottomSheetWindowInsetListenerChainRequireBottomSheetWindowInsetsListenerChain$react_native_screens_release = requireBottomSheetWindowInsetsListenerChain$react_native_screens_release();
                bottomSheetWindowInsetListenerChainRequireBottomSheetWindowInsetsListenerChain$react_native_screens_release.addListener(new OnApplyWindowInsetsListener() { // from class: com.swmansion.rnscreens.ScreenStackFragment$$ExternalSyntheticLambda0
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        return ScreenStackFragment.onCreateView$lambda$8(sheetDelegateRequireSheetDelegate, view, windowInsetsCompat);
                    }
                });
                ViewCompat.setOnApplyWindowInsetsListener(getScreen(), bottomSheetWindowInsetListenerChainRequireBottomSheetWindowInsetsListenerChain$react_native_screens_release);
            }
            ViewCompat.setWindowInsetsAnimationCallback(getScreen(), new WindowInsetsAnimationCompat.Callback() { // from class: com.swmansion.rnscreens.ScreenStackFragment$onCreateView$insetsAnimationCallback$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
                public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List runningAnimations) {
                    Intrinsics.checkNotNullParameter(insets, "insets");
                    Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
                    if (Build.VERSION.SDK_INT >= 30) {
                        sheetDelegateRequireSheetDelegate.handleKeyboardInsetsProgress$react_native_screens_release(insets);
                    }
                    return insets;
                }

                @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
                public void onEnd(WindowInsetsAnimationCompat animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onEnd(animation);
                    this.getScreen().onSheetYTranslationChanged$react_native_screens_release();
                }
            });
        }
        ScreensCoordinatorLayout screensCoordinatorLayout6 = this.coordinatorLayout;
        if (screensCoordinatorLayout6 != null) {
            return screensCoordinatorLayout6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreateView$lambda$8(SheetDelegate sheetDelegate, View view, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        sheetDelegate.handleKeyboardInsetsProgress$react_native_screens_release(windowInsets);
        return windowInsets;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        if (SheetUtilsKt.usesFormSheetPresentation(getScreen())) {
            return enter ? createSheetEnterAnimator() : createSheetExitAnimator();
        }
        return null;
    }

    private final Animator createSheetEnterAnimator() {
        SheetDelegate sheetDelegateRequireSheetDelegate = requireSheetDelegate();
        ScreensCoordinatorLayout screensCoordinatorLayout = null;
        DimmingViewManager dimmingViewManagerRequireDimmingDelegate$default = requireDimmingDelegate$default(this, false, 1, null);
        Screen screen = getScreen();
        ScreensCoordinatorLayout screensCoordinatorLayout2 = this.coordinatorLayout;
        if (screensCoordinatorLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
        } else {
            screensCoordinatorLayout = screensCoordinatorLayout2;
        }
        return sheetDelegateRequireSheetDelegate.createSheetEnterAnimator$react_native_screens_release(new SheetDelegate.SheetAnimationContext(this, screen, screensCoordinatorLayout, dimmingViewManagerRequireDimmingDelegate$default));
    }

    private final Animator createSheetExitAnimator() {
        SheetDelegate sheetDelegateRequireSheetDelegate = requireSheetDelegate();
        ScreensCoordinatorLayout screensCoordinatorLayout = null;
        DimmingViewManager dimmingViewManagerRequireDimmingDelegate$default = requireDimmingDelegate$default(this, false, 1, null);
        Screen screen = getScreen();
        ScreensCoordinatorLayout screensCoordinatorLayout2 = this.coordinatorLayout;
        if (screensCoordinatorLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
        } else {
            screensCoordinatorLayout = screensCoordinatorLayout2;
        }
        return sheetDelegateRequireSheetDelegate.createSheetExitAnimator$react_native_screens_release(new SheetDelegate.SheetAnimationContext(this, screen, screensCoordinatorLayout, dimmingViewManagerRequireDimmingDelegate$default));
    }

    private final BottomSheetBehavior createBottomSheetBehaviour() {
        return new BottomSheetBehavior();
    }

    private final Integer resolveBackgroundColor(Screen screen) {
        Integer numValueOf;
        ColorStateList tintList;
        Drawable background = screen.getBackground();
        ColorDrawable colorDrawable = background instanceof ColorDrawable ? (ColorDrawable) background : null;
        if (colorDrawable != null) {
            numValueOf = Integer.valueOf(colorDrawable.getColor());
        } else {
            Drawable background2 = screen.getBackground();
            MaterialShapeDrawable materialShapeDrawable = background2 instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background2 : null;
            numValueOf = (materialShapeDrawable == null || (tintList = materialShapeDrawable.getTintList()) == null) ? null : Integer.valueOf(tintList.getDefaultColor());
        }
        if (numValueOf != null) {
            return numValueOf;
        }
        ScreenContentWrapper contentWrapper = screen.getContentWrapper();
        if (contentWrapper == null) {
            return null;
        }
        return ViewBackgroundUtilsKt.resolveBackgroundColor(contentWrapper);
    }

    private final void attachShapeToScreen(Screen screen) {
        float fMax = Math.max(PixelUtil.toPixelFromDIP(screen.getSheetCornerRadius()), 0.0f);
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
        builder.setTopLeftCorner(0, fMax);
        builder.setTopRightCorner(0, fMax);
        ShapeAppearanceModel shapeAppearanceModelBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(shapeAppearanceModelBuild, "build(...)");
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModelBuild);
        Integer numResolveBackgroundColor = resolveBackgroundColor(screen);
        materialShapeDrawable.setTint(numResolveBackgroundColor != null ? numResolveBackgroundColor.intValue() : 0);
        screen.setBackground(materialShapeDrawable);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        View view = this.lastFocusedChild;
        if (view != null) {
            view.requestFocus();
        }
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        if (DeviceUtils.INSTANCE.isPlatformAndroidTV(getContext())) {
            this.lastFocusedChild = findLastFocusedChild();
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        ScreenStackHeaderConfig headerConfig;
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (!getScreen().isTranslucent() || ((headerConfig = getScreen().getHeaderConfig()) != null && !headerConfig.isHeaderHidden())) {
            updateToolbarMenu(menu);
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        updateToolbarMenu(menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private final boolean shouldShowSearchBar() {
        ScreenStackHeaderConfig headerConfig = getScreen().getHeaderConfig();
        int configSubviewsCount = headerConfig != null ? headerConfig.getConfigSubviewsCount() : 0;
        if (headerConfig != null && configSubviewsCount > 0) {
            for (int i = 0; i < configSubviewsCount; i++) {
                if (headerConfig.getConfigSubview(i).getType() == ScreenStackHeaderSubview.Type.SEARCH_BAR) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void updateToolbarMenu(Menu menu) {
        menu.clear();
        if (shouldShowSearchBar()) {
            Context context = getContext();
            if (this.searchView == null && context != null) {
                CustomSearchView customSearchView = new CustomSearchView(context, this);
                this.searchView = customSearchView;
                Function1 function1 = this.onSearchViewCreate;
                if (function1 != null) {
                    function1.invoke(customSearchView);
                }
            }
            MenuItem menuItemAdd = menu.add("");
            menuItemAdd.setShowAsAction(2);
            menuItemAdd.setActionView(this.searchView);
        }
    }

    private final View findLastFocusedChild() {
        View screen = getScreen();
        while (screen != null) {
            if (screen.isFocused()) {
                return screen;
            }
            screen = screen instanceof ViewGroup ? ((ViewGroup) screen).getFocusedChild() : null;
        }
        return null;
    }

    public boolean canNavigateBack() {
        ScreenContainer container = getScreen().getContainer();
        if (!(container instanceof ScreenStack)) {
            throw new IllegalStateException("ScreenStackFragment added into a non-stack container");
        }
        if (!Intrinsics.areEqual(((ScreenStack) container).getRootScreen(), getScreen())) {
            return true;
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof ScreenStackFragment) {
            return ((ScreenStackFragment) parentFragment).canNavigateBack();
        }
        return false;
    }

    public void dismissFromContainer() {
        getScreenStack().dismiss(this);
    }

    private final void attachInsetsAndLayoutListenersToBottomSheet(final BottomSheetTransitionCoordinator sheetTransitionCoordinator) {
        final ScreenContainer container = getScreen().getContainer();
        if (container != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                container.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.swmansion.rnscreens.ScreenStackFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        return ScreenStackFragment.attachInsetsAndLayoutListenersToBottomSheet$lambda$14$lambda$12(container, this, view, windowInsets);
                    }
                });
            } else {
                requireBottomSheetWindowInsetsListenerChain$react_native_screens_release().addListener(new OnApplyWindowInsetsListener() { // from class: com.swmansion.rnscreens.ScreenStackFragment$$ExternalSyntheticLambda2
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        return ScreenStackFragment.attachInsetsAndLayoutListenersToBottomSheet$lambda$14$lambda$13(this.f$0, view, windowInsetsCompat);
                    }
                });
            }
        }
        ScreenContainer container2 = getScreen().getContainer();
        if (container2 != null) {
            container2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.swmansion.rnscreens.ScreenStackFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    ScreenStackFragment.attachInsetsAndLayoutListenersToBottomSheet$lambda$15(sheetTransitionCoordinator, this, view, i, i2, i3, i4, i5, i6, i7, i8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets attachInsetsAndLayoutListenersToBottomSheet$lambda$14$lambda$12(ScreenContainer screenContainer, ScreenStackFragment screenStackFragment, View view, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(insets, screenContainer);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "toWindowInsetsCompat(...)");
        screenStackFragment.handleInsetsUpdateAndNotifyTransition(windowInsetsCompat);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat attachInsetsAndLayoutListenersToBottomSheet$lambda$14$lambda$13(ScreenStackFragment screenStackFragment, View view, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        screenStackFragment.handleInsetsUpdateAndNotifyTransition(windowInsets);
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachInsetsAndLayoutListenersToBottomSheet$lambda$15(BottomSheetTransitionCoordinator bottomSheetTransitionCoordinator, ScreenStackFragment screenStackFragment, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        bottomSheetTransitionCoordinator.onScreenContainerLayoutChanged$react_native_screens_release(screenStackFragment.getScreen());
    }

    private final void handleInsetsUpdateAndNotifyTransition(WindowInsetsCompat insetsCompat) {
        if (Intrinsics.areEqual(this.lastInsetsCompat, insetsCompat)) {
            return;
        }
        this.lastInsetsCompat = insetsCompat;
        SheetDelegate sheetDelegateRequireSheetDelegate = requireSheetDelegate();
        BottomSheetBehavior<Screen> sheetBehavior = getScreen().getSheetBehavior();
        Intrinsics.checkNotNull(sheetBehavior);
        sheetDelegateRequireSheetDelegate.updateBottomSheetMetrics$react_native_screens_release(sheetBehavior);
        ScreenContainer container = getScreen().getContainer();
        BottomSheetTransitionCoordinator bottomSheetTransitionCoordinator = null;
        if (container != null) {
            ScreensCoordinatorLayout screensCoordinatorLayout = this.coordinatorLayout;
            if (screensCoordinatorLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout = null;
            }
            screensCoordinatorLayout.forceLayout();
            ScreensCoordinatorLayout screensCoordinatorLayout2 = this.coordinatorLayout;
            if (screensCoordinatorLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout2 = null;
            }
            screensCoordinatorLayout2.measure(View.MeasureSpec.makeMeasureSpec(container.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(container.getHeight(), 1073741824));
            ScreensCoordinatorLayout screensCoordinatorLayout3 = this.coordinatorLayout;
            if (screensCoordinatorLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout3 = null;
            }
            screensCoordinatorLayout3.layout(0, 0, container.getWidth(), container.getHeight());
        }
        getScreen().onBottomSheetBehaviorDidLayout$react_native_screens_release(true);
        BottomSheetTransitionCoordinator bottomSheetTransitionCoordinator2 = this.sheetTransitionCoordinator;
        if (bottomSheetTransitionCoordinator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetTransitionCoordinator");
        } else {
            bottomSheetTransitionCoordinator = bottomSheetTransitionCoordinator2;
        }
        bottomSheetTransitionCoordinator.onScreenContainerInsetsApplied$react_native_screens_release(getScreen());
    }

    static /* synthetic */ DimmingViewManager requireDimmingDelegate$default(ScreenStackFragment screenStackFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return screenStackFragment.requireDimmingDelegate(z);
    }

    private final DimmingViewManager requireDimmingDelegate(boolean forceCreation) {
        DimmingViewManager dimmingViewManager = this.dimmingDelegate;
        if (dimmingViewManager == null || forceCreation) {
            if (dimmingViewManager != null) {
                dimmingViewManager.invalidate(getScreen().getSheetBehavior());
            }
            this.dimmingDelegate = new DimmingViewManager(getScreen().getReactContext(), getScreen());
        }
        DimmingViewManager dimmingViewManager2 = this.dimmingDelegate;
        Intrinsics.checkNotNull(dimmingViewManager2);
        return dimmingViewManager2;
    }

    private final SheetDelegate requireSheetDelegate() {
        if (this.sheetDelegate == null) {
            this.sheetDelegate = new SheetDelegate(getScreen());
        }
        SheetDelegate sheetDelegate = this.sheetDelegate;
        Intrinsics.checkNotNull(sheetDelegate);
        return sheetDelegate;
    }

    public final BottomSheetWindowInsetListenerChain requireBottomSheetWindowInsetsListenerChain$react_native_screens_release() {
        if (this.bottomSheetWindowInsetListenerChain == null) {
            this.bottomSheetWindowInsetListenerChain = new BottomSheetWindowInsetListenerChain();
        }
        BottomSheetWindowInsetListenerChain bottomSheetWindowInsetListenerChain = this.bottomSheetWindowInsetListenerChain;
        Intrinsics.checkNotNull(bottomSheetWindowInsetListenerChain);
        return bottomSheetWindowInsetListenerChain;
    }
}
