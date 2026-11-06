package com.swmansion.rnscreens.safearea;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.rnscreens.safearea.paper.SafeAreaViewEdges;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SafeAreaView extends ReactViewGroup implements OnApplyWindowInsetsListener, ViewTreeObserver.OnPreDrawListener {
    public static final Companion Companion = new Companion(null);
    private EdgeInsets currentInterfaceInsets;
    private EdgeInsets currentSystemInsets;
    private SafeAreaViewEdges edges;
    private InsetType insetType;
    private boolean needsInsetsUpdate;
    private WeakReference provider;
    private final ThemedReactContext reactContext;
    private StateWrapper stateWrapper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeAreaView(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.provider = new WeakReference(null);
        EdgeInsets.Companion companion = EdgeInsets.Companion;
        this.currentInterfaceInsets = companion.getZERO();
        this.currentSystemInsets = companion.getZERO();
        this.insetType = InsetType.ALL;
        ViewCompat.setOnApplyWindowInsetsListener(this, this);
    }

    public final StateWrapper getStateWrapper() {
        return this.stateWrapper;
    }

    public final void setStateWrapper(StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        getViewTreeObserver().addOnPreDrawListener(this);
        SafeAreaProvider safeAreaProviderFindAncestorProvider = findAncestorProvider();
        if (safeAreaProviderFindAncestorProvider == null) {
            super.onAttachedToWindow();
            return;
        }
        safeAreaProviderFindAncestorProvider.setOnInterfaceInsetsChangeListener(this);
        this.provider = new WeakReference(safeAreaProviderFindAncestorProvider);
        this.currentInterfaceInsets = safeAreaProviderFindAncestorProvider.getInterfaceInsets();
        updateInsets();
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        SafeAreaProvider safeAreaProvider = (SafeAreaProvider) this.provider.get();
        if (safeAreaProvider != null) {
            safeAreaProvider.removeOnInterfaceInsetsChangeListener(this);
        }
        getViewTreeObserver().removeOnPreDrawListener(this);
        super.onDetachedFromWindow();
    }

    private final SafeAreaProvider findAncestorProvider() {
        ViewParent parent = getParent();
        while (parent != null && !(parent instanceof SafeAreaProvider)) {
            parent = parent.getParent();
        }
        if (parent instanceof SafeAreaProvider) {
            return (SafeAreaProvider) parent;
        }
        return null;
    }

    public final void onInterfaceInsetsChange(EdgeInsets newInterfaceInsets) {
        Intrinsics.checkNotNullParameter(newInterfaceInsets, "newInterfaceInsets");
        if (Intrinsics.areEqual(newInterfaceInsets, this.currentInterfaceInsets)) {
            return;
        }
        this.currentInterfaceInsets = newInterfaceInsets;
        if (this.insetType.containsInterface()) {
            this.needsInsetsUpdate = true;
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat insets) {
        boolean zAreEqual;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        if (!Intrinsics.areEqual(insets2, this.currentSystemInsets)) {
            this.currentSystemInsets = EdgeInsets.Companion.fromInsets(insets2);
            if (this.insetType.containsSystem()) {
                this.needsInsetsUpdate = true;
            }
        }
        WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(insets);
        if (this.insetType.containsSystem()) {
            Insets insets3 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            Intrinsics.checkNotNullExpressionValue(insets3, "getInsets(...)");
            Insets consumedInsetsFromSelectedEdges = getConsumedInsetsFromSelectedEdges(insets3);
            Insets insets4 = insets.getInsets(WindowInsetsCompat.Type.displayCutout());
            Intrinsics.checkNotNullExpressionValue(insets4, "getInsets(...)");
            Insets consumedInsetsFromSelectedEdges2 = getConsumedInsetsFromSelectedEdges(insets4);
            zAreEqual = Intrinsics.areEqual(consumedInsetsFromSelectedEdges2, Insets.NONE);
            builder.setInsets(WindowInsetsCompat.Type.systemBars(), consumedInsetsFromSelectedEdges);
            builder.setInsets(WindowInsetsCompat.Type.displayCutout(), consumedInsetsFromSelectedEdges2);
        } else {
            zAreEqual = false;
        }
        WindowInsetsCompat windowInsetsCompatBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatBuild, "build(...)");
        if (Build.VERSION.SDK_INT >= 30 || !zAreEqual) {
            return windowInsetsCompatBuild;
        }
        WindowInsetsCompat windowInsetsCompatConsumeDisplayCutout = windowInsetsCompatBuild.consumeDisplayCutout();
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatConsumeDisplayCutout, "consumeDisplayCutout(...)");
        return windowInsetsCompatConsumeDisplayCutout;
    }

    private final boolean updateInsetsIfNeeded() {
        if (!this.needsInsetsUpdate) {
            return false;
        }
        this.needsInsetsUpdate = false;
        updateInsets();
        return true;
    }

    private final void updateInsets() {
        EdgeInsets.Companion companion = EdgeInsets.Companion;
        EdgeInsets edgeInsetsMax = companion.max(this.insetType.containsInterface() ? this.currentInterfaceInsets : companion.getZERO(), this.insetType.containsSystem() ? this.currentSystemInsets : companion.getZERO());
        StateWrapper stateWrapper = getStateWrapper();
        if (stateWrapper != null) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble("left", PixelUtil.toDIPFromPixel(edgeInsetsMax.getLeft()));
            writableMapCreateMap.putDouble("top", PixelUtil.toDIPFromPixel(edgeInsetsMax.getTop()));
            writableMapCreateMap.putDouble("right", PixelUtil.toDIPFromPixel(edgeInsetsMax.getRight()));
            writableMapCreateMap.putDouble("bottom", PixelUtil.toDIPFromPixel(edgeInsetsMax.getBottom()));
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            writableMapCreateMap2.putMap("insets", writableMapCreateMap);
            stateWrapper.updateState(writableMapCreateMap2);
        }
    }

    private final Insets getConsumedInsetsFromSelectedEdges(Insets insets) {
        SafeAreaViewEdges safeAreaViewEdges = this.edges;
        int i = safeAreaViewEdges != null ? safeAreaViewEdges.getLeft() : false ? 0 : insets.left;
        SafeAreaViewEdges safeAreaViewEdges2 = this.edges;
        int i2 = safeAreaViewEdges2 != null ? safeAreaViewEdges2.getTop() : false ? 0 : insets.top;
        SafeAreaViewEdges safeAreaViewEdges3 = this.edges;
        int i3 = safeAreaViewEdges3 != null ? safeAreaViewEdges3.getRight() : false ? 0 : insets.right;
        SafeAreaViewEdges safeAreaViewEdges4 = this.edges;
        Insets insetsOf = Insets.of(i, i2, i3, safeAreaViewEdges4 != null ? safeAreaViewEdges4.getBottom() : false ? 0 : insets.bottom);
        Intrinsics.checkNotNullExpressionValue(insetsOf, "of(...)");
        return insetsOf;
    }

    public final void setEdges(SafeAreaViewEdges edges) {
        Intrinsics.checkNotNullParameter(edges, "edges");
        this.edges = edges;
        requestApplyInsets();
        this.needsInsetsUpdate = true;
    }

    public final void setInsetType(InsetType insetType) {
        Intrinsics.checkNotNullParameter(insetType, "insetType");
        this.insetType = insetType;
        requestApplyInsets();
        this.needsInsetsUpdate = true;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean zUpdateInsetsIfNeeded = updateInsetsIfNeeded();
        if (zUpdateInsetsIfNeeded) {
            requestLayout();
        }
        return !zUpdateInsetsIfNeeded;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
