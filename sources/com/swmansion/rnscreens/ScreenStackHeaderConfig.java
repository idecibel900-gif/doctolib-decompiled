package com.swmansion.rnscreens;

import android.R;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.swmansion.rnscreens.events.HeaderAttachedEvent;
import com.swmansion.rnscreens.events.HeaderDetachedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ScreenStackHeaderConfig extends FabricEnabledHeaderConfigViewGroup implements ReactPointerEventsView {
    public static final Companion Companion = new Companion(null);
    private boolean backButtonInCustomView;
    private final View.OnClickListener backClickListener;
    private Integer backgroundColor;
    private final ArrayList configSubviews;
    private final int defaultStartInset;
    private final int defaultStartInsetWithNavigation;
    private String direction;
    private final ScreenStackHeaderHeightUpdateProxy headerHeightUpdateProxy;
    private boolean isAttachedToWindow;
    private boolean isBackButtonHidden;
    private boolean isDestroyed;
    private boolean isHeaderHidden;
    private boolean isHeaderTranslucent;
    private boolean isShadowHidden;
    private boolean isTitleEmpty;
    private final ReactPointerEventsView pointerEventsImpl;
    private int tintColor;
    private String title;
    private int titleColor;
    private String titleFontFamily;
    private float titleFontSize;
    private int titleFontWeight;
    private final CustomToolbar toolbar;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScreenStackHeaderSubview.Type.values().length];
            try {
                iArr[ScreenStackHeaderSubview.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScreenStackHeaderSubview.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScreenStackHeaderSubview.Type.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return this.pointerEventsImpl.getPointerEvents();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenStackHeaderConfig(Context context, ReactPointerEventsView pointerEventsImpl) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pointerEventsImpl, "pointerEventsImpl");
        this.pointerEventsImpl = pointerEventsImpl;
        this.configSubviews = new ArrayList(3);
        this.backClickListener = new View.OnClickListener() { // from class: com.swmansion.rnscreens.ScreenStackHeaderConfig$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScreenStackHeaderConfig.backClickListener$lambda$1(this.f$0, view);
            }
        };
        this.headerHeightUpdateProxy = new ScreenStackHeaderHeightUpdateProxy();
        setVisibility(8);
        CustomToolbar customToolbar = new CustomToolbar(context, this);
        this.toolbar = customToolbar;
        this.defaultStartInset = customToolbar.getContentInsetStart();
        this.defaultStartInsetWithNavigation = customToolbar.getContentInsetStartWithNavigation();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
            customToolbar.setBackgroundColor(typedValue.data);
        }
        customToolbar.setClipChildren(false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScreenStackHeaderConfig(Context context) {
        this(context, new PointerEventsBoxNoneImpl());
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final CustomToolbar getToolbar() {
        return this.toolbar;
    }

    public final boolean isHeaderHidden() {
        return this.isHeaderHidden;
    }

    public final void setHeaderHidden(boolean z) {
        this.isHeaderHidden = z;
    }

    public final boolean isHeaderTranslucent() {
        return this.isHeaderTranslucent;
    }

    public final void setHeaderTranslucent(boolean z) {
        this.isHeaderTranslucent = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void backClickListener$lambda$1(ScreenStackHeaderConfig screenStackHeaderConfig, View view) {
        ScreenStackFragment screenFragment = screenStackHeaderConfig.getScreenFragment();
        if (screenFragment != null) {
            ScreenStack screenStack = screenStackHeaderConfig.getScreenStack();
            if (screenStack != null && Intrinsics.areEqual(screenStack.getRootScreen(), screenFragment.getScreen())) {
                Fragment parentFragment = screenFragment.getParentFragment();
                if (parentFragment instanceof ScreenStackFragment) {
                    ScreenStackFragment screenStackFragment = (ScreenStackFragment) parentFragment;
                    if (screenStackFragment.getScreen().getNativeBackButtonDismissalEnabled()) {
                        screenStackFragment.dismissFromContainer();
                        return;
                    } else {
                        screenStackFragment.dispatchHeaderBackButtonClickedEvent();
                        return;
                    }
                }
                return;
            }
            if (screenFragment.getScreen().getNativeBackButtonDismissalEnabled()) {
                screenFragment.dismissFromContainer();
            } else {
                screenFragment.dispatchHeaderBackButtonClickedEvent();
            }
        }
    }

    public final void setTitleEmpty(boolean z) {
        this.isTitleEmpty = z;
    }

    public final int getPreferredContentInsetStart() {
        return this.defaultStartInset;
    }

    public final int getPreferredContentInsetEnd() {
        return this.defaultStartInset;
    }

    public final int getPreferredContentInsetStartWithNavigation() {
        if (this.isTitleEmpty) {
            return 0;
        }
        return this.defaultStartInsetWithNavigation;
    }

    public final ScreenStackHeaderHeightUpdateProxy getHeaderHeightUpdateProxy() {
        return this.headerHeightUpdateProxy;
    }

    public final void destroy() {
        this.isDestroyed = true;
    }

    public final void onNativeToolbarLayout(Toolbar toolbar, boolean z) {
        int iMax;
        Object next;
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        if (z) {
            if (toolbar.getNavigationIcon() != null) {
                iMax = toolbar.getCurrentContentInsetStart() + toolbar.getPaddingStart();
            } else {
                iMax = Math.max(toolbar.getCurrentContentInsetStart(), toolbar.getPaddingStart());
            }
            Iterator it = this.configSubviews.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((ScreenStackHeaderSubview) next).getType() != ScreenStackHeaderSubview.Type.LEFT);
            ScreenStackHeaderSubview screenStackHeaderSubview = (ScreenStackHeaderSubview) next;
            if (screenStackHeaderSubview != null) {
                iMax = screenStackHeaderSubview.getLeft();
            }
            int currentContentInsetEnd = toolbar.getCurrentContentInsetEnd() + toolbar.getPaddingEnd();
            this.headerHeightUpdateProxy.updateHeaderHeightIfNeeded(this, getScreen());
            updateHeaderConfigState(toolbar.getWidth(), toolbar.getHeight(), iMax, currentContentInsetEnd);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        int surfaceId = UIManagerHelper.getSurfaceId(this);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new HeaderAttachedEvent(surfaceId, getId()));
        }
        onUpdate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        int surfaceId = UIManagerHelper.getSurfaceId(this);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new HeaderDetachedEvent(surfaceId, getId()));
        }
    }

    private final Screen getScreen() {
        ViewParent parent = getParent();
        if (parent instanceof Screen) {
            return (Screen) parent;
        }
        return null;
    }

    private final ScreenStack getScreenStack() {
        Screen screen = getScreen();
        ScreenContainer container = screen != null ? screen.getContainer() : null;
        if (container instanceof ScreenStack) {
            return (ScreenStack) container;
        }
        return null;
    }

    public final ScreenStackFragment getScreenFragment() {
        ViewParent parent = getParent();
        if (!(parent instanceof Screen)) {
            return null;
        }
        Fragment fragment = ((Screen) parent).getFragment();
        if (fragment instanceof ScreenStackFragment) {
            return (ScreenStackFragment) fragment;
        }
        return null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onUpdate() {
        Drawable navigationIcon;
        ScreenStackFragment screenFragment;
        ScreenStackFragment screenFragment2;
        ReactContext reactContextTryGetContext;
        ScreenStack screenStack = getScreenStack();
        boolean z = screenStack == null || Intrinsics.areEqual(screenStack.getTopScreen(), getParent());
        if (this.isAttachedToWindow && z && !this.isDestroyed) {
            ScreenStackFragment screenFragment3 = getScreenFragment();
            AppCompatActivity appCompatActivity = (AppCompatActivity) (screenFragment3 != null ? screenFragment3.getActivity() : null);
            if (appCompatActivity == null) {
                return;
            }
            String str = this.direction;
            if (str != null) {
                if (Intrinsics.areEqual(str, "rtl")) {
                    this.toolbar.setLayoutDirection(1);
                } else if (Intrinsics.areEqual(this.direction, "ltr")) {
                    this.toolbar.setLayoutDirection(0);
                }
            }
            Screen screen = getScreen();
            if (screen != null) {
                if (getContext() instanceof ReactContext) {
                    Context context = getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                    reactContextTryGetContext = (ReactContext) context;
                } else {
                    ScreenFragmentWrapper fragmentWrapper = screen.getFragmentWrapper();
                    reactContextTryGetContext = fragmentWrapper != null ? fragmentWrapper.tryGetContext() : null;
                }
                ScreenWindowTraits.INSTANCE.trySetWindowTraits$react_native_screens_release(screen, appCompatActivity, reactContextTryGetContext);
            }
            if (this.isHeaderHidden) {
                if (this.toolbar.getParent() != null && (screenFragment2 = getScreenFragment()) != null) {
                    screenFragment2.removeToolbar();
                }
                this.headerHeightUpdateProxy.updateHeaderHeightIfNeeded(this, getScreen());
                return;
            }
            if (this.toolbar.getParent() == null && (screenFragment = getScreenFragment()) != null) {
                screenFragment.setToolbar(this.toolbar);
            }
            appCompatActivity.setSupportActionBar(this.toolbar);
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            ScreenStackFragment screenFragment4 = getScreenFragment();
            supportActionBar.setDisplayHomeAsUpEnabled((screenFragment4 == null || !screenFragment4.canNavigateBack() || this.isBackButtonHidden) ? false : true);
            supportActionBar.setTitle(this.title);
            if (TextUtils.isEmpty(this.title)) {
                this.isTitleEmpty = true;
            }
            this.toolbar.updateContentInsets();
            this.toolbar.setNavigationOnClickListener(this.backClickListener);
            ScreenStackFragment screenFragment5 = getScreenFragment();
            if (screenFragment5 != null) {
                screenFragment5.setToolbarShadowHidden(this.isShadowHidden);
            }
            ScreenStackFragment screenFragment6 = getScreenFragment();
            if (screenFragment6 != null) {
                screenFragment6.setToolbarTranslucent(this.isHeaderTranslucent);
            }
            TextView textViewFindTitleTextViewInToolbar = Companion.findTitleTextViewInToolbar(this.toolbar);
            int i = this.titleColor;
            if (i != 0) {
                this.toolbar.setTitleTextColor(i);
            }
            if (textViewFindTitleTextViewInToolbar != null) {
                String str2 = this.titleFontFamily;
                if (str2 != null || this.titleFontWeight > 0) {
                    int i2 = this.titleFontWeight;
                    AssetManager assets = getContext().getAssets();
                    Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
                    textViewFindTitleTextViewInToolbar.setTypeface(ReactTypefaceUtils.applyStyles(null, 0, i2, str2, assets));
                }
                float f = this.titleFontSize;
                if (f > 0.0f) {
                    textViewFindTitleTextViewInToolbar.setTextSize(f);
                }
            }
            Integer num = this.backgroundColor;
            if (num != null) {
                this.toolbar.setBackgroundColor(num.intValue());
            }
            if (this.tintColor != 0 && (navigationIcon = this.toolbar.getNavigationIcon()) != null) {
                navigationIcon.setColorFilter(new PorterDuffColorFilter(this.tintColor, PorterDuff.Mode.SRC_ATOP));
            }
            for (int childCount = this.toolbar.getChildCount() - 1; -1 < childCount; childCount--) {
                if (this.toolbar.getChildAt(childCount) instanceof ScreenStackHeaderSubview) {
                    this.toolbar.removeViewAt(childCount);
                }
            }
            int size = this.configSubviews.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = this.configSubviews.get(i3);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                ScreenStackHeaderSubview screenStackHeaderSubview = (ScreenStackHeaderSubview) obj;
                ScreenStackHeaderSubview.Type type = screenStackHeaderSubview.getType();
                if (type == ScreenStackHeaderSubview.Type.BACK) {
                    View childAt = screenStackHeaderSubview.getChildAt(0);
                    ImageView imageView = childAt instanceof ImageView ? (ImageView) childAt : null;
                    if (imageView == null) {
                        throw new JSApplicationIllegalArgumentException("Back button header config view should have Image as first child");
                    }
                    supportActionBar.setHomeAsUpIndicator(imageView.getDrawable());
                } else {
                    Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -1);
                    int i4 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                    if (i4 == 1) {
                        if (!this.backButtonInCustomView) {
                            this.toolbar.setNavigationIcon((Drawable) null);
                        }
                        this.toolbar.setTitle((CharSequence) null);
                        layoutParams.gravity = 8388611;
                    } else if (i4 == 2) {
                        layoutParams.gravity = 8388613;
                    } else if (i4 == 3) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
                        layoutParams.gravity = 1;
                        this.toolbar.setTitle((CharSequence) null);
                    }
                    screenStackHeaderSubview.setLayoutParams(layoutParams);
                    this.toolbar.addView(screenStackHeaderSubview);
                }
            }
            this.headerHeightUpdateProxy.updateHeaderHeightIfNeeded(this, getScreen());
        }
    }

    private final void maybeUpdate() {
        Screen screen;
        if (getParent() == null || this.isDestroyed || (screen = getScreen()) == null || screen.isBeingRemoved()) {
            return;
        }
        onUpdate();
    }

    public final ScreenStackHeaderSubview getConfigSubview(int i) {
        Object obj = this.configSubviews.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (ScreenStackHeaderSubview) obj;
    }

    public final int getConfigSubviewsCount() {
        return this.configSubviews.size();
    }

    public final void removeConfigSubview(int i) {
        this.configSubviews.remove(i);
        maybeUpdate();
    }

    public final void removeAllConfigSubviews() {
        this.configSubviews.clear();
        maybeUpdate();
    }

    public final void addConfigSubview(ScreenStackHeaderSubview child, int i) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.configSubviews.add(i, child);
        maybeUpdate();
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTitleFontFamily(String str) {
        this.titleFontFamily = str;
    }

    public final void setTitleFontWeight(String str) {
        this.titleFontWeight = ReactTypefaceUtils.parseFontWeight(str);
    }

    public final void setTitleFontSize(float f) {
        this.titleFontSize = f;
    }

    public final void setTitleColor(int i) {
        this.titleColor = i;
    }

    public final void setTintColor(int i) {
        this.tintColor = i;
    }

    public final void setBackgroundColor(Integer num) {
        this.backgroundColor = num;
    }

    public final void setHideShadow(boolean z) {
        this.isShadowHidden = z;
    }

    public final void setHideBackButton(boolean z) {
        this.isBackButtonHidden = z;
    }

    public final void setHidden(boolean z) {
        this.isHeaderHidden = z;
    }

    public final void setTranslucent(boolean z) {
        this.isHeaderTranslucent = z;
    }

    public final void setBackButtonInCustomView(boolean z) {
        this.backButtonInCustomView = z;
    }

    public final void setDirection(String str) {
        this.direction = str;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TextView findTitleTextViewInToolbar(Toolbar toolbar) {
            Intrinsics.checkNotNullParameter(toolbar, "toolbar");
            int childCount = toolbar.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = toolbar.getChildAt(i);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (TextUtils.equals(textView.getText(), toolbar.getTitle())) {
                        return textView;
                    }
                }
            }
            return null;
        }
    }
}
