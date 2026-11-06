package com.unistyles;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.annotation.Keep;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.margelo.nitro.unistyles.ColorScheme;
import com.margelo.nitro.unistyles.Dimensions;
import com.margelo.nitro.unistyles.HybridNativePlatformSpec;
import com.margelo.nitro.unistyles.Insets;
import com.margelo.nitro.unistyles.Orientation;
import com.margelo.nitro.unistyles.UnistyleDependency;
import com.margelo.nitro.unistyles.UnistylesNativeMiniRuntime;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0010J\r\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0010J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0010J\u000f\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u0019\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u0010J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010\"J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010,J\u000f\u0010.\u001a\u00020*H\u0016¢\u0006\u0004\b.\u0010,J\u000f\u0010/\u001a\u00020\u0012H\u0016¢\u0006\u0004\b/\u0010\u0014J\u0017\u00101\u001a\u00020\u000e2\u0006\u00100\u001a\u00020 H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u0012H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u0012H\u0016¢\u0006\u0004\b6\u00105J\u0017\u00108\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u0012H\u0016¢\u0006\u0004\b8\u00105J\u000f\u00109\u001a\u00020\u0007H\u0016¢\u0006\u0004\b9\u0010\tJ/\u0010<\u001a\u00020\u000e2\u001e\u0010;\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0:H\u0016¢\u0006\u0004\b<\u0010=J#\u0010?\u001a\u00020\u000e2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0>H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u000eH\u0016¢\u0006\u0004\bA\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020K8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006O"}, d2 = {"Lcom/unistyles/NativePlatformAndroid;", "Lcom/margelo/nitro/unistyles/HybridNativePlatformSpec;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "reactContext", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "buildMiniRuntime", "()Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "", "Lcom/margelo/nitro/unistyles/UnistyleDependency;", "diffMiniRuntime", "()[Lcom/margelo/nitro/unistyles/UnistyleDependency;", "", "onConfigChange", "()V", "checkEdgeToEdge", "", "isEdgeToEdgeAlreadyEnabled", "()Z", "enableEdgeToEdge", "onDestroy", "onHostResume", "onHostPause", "onHostDestroy", "Lcom/margelo/nitro/unistyles/Insets;", "getInsets", "()Lcom/margelo/nitro/unistyles/Insets;", "Lcom/margelo/nitro/unistyles/ColorScheme;", "getColorScheme", "()Lcom/margelo/nitro/unistyles/ColorScheme;", "", "getFontScale", "()D", "getPixelRatio", "Lcom/margelo/nitro/unistyles/Orientation;", "getOrientation", "()Lcom/margelo/nitro/unistyles/Orientation;", "", "getContentSizeCategory", "()Ljava/lang/String;", "Lcom/margelo/nitro/unistyles/Dimensions;", "getScreenDimensions", "()Lcom/margelo/nitro/unistyles/Dimensions;", "getStatusBarDimensions", "getNavigationBarDimensions", "getPrefersRtlDirection", "color", "setRootViewBackgroundColor", "(D)V", "isHidden", "setNavigationBarHidden", "(Z)V", "setStatusBarHidden", "isEnabled", "setImmersiveMode", "getMiniRuntime", "Lkotlin/Function2;", "callback", "registerPlatformListener", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "registerImeListener", "(Lkotlin/jvm/functions/Function1;)V", "unregisterPlatformListeners", "Lcom/facebook/react/bridge/ReactApplicationContext;", "Lcom/unistyles/NativePlatformInsets;", "_insets", "Lcom/unistyles/NativePlatformInsets;", "_miniRuntime", "Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "Lcom/unistyles/NativePlatformListener;", "_listener", "Lcom/unistyles/NativePlatformListener;", "", "getMemorySize", "()J", "memorySize", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativePlatformAndroid extends HybridNativePlatformSpec implements LifecycleEventListener {
    private final NativePlatformInsets _insets;
    private final NativePlatformListener _listener;
    private UnistylesNativeMiniRuntime _miniRuntime;
    private final ReactApplicationContext reactContext;

    private final void checkEdgeToEdge() {
    }

    @Override // com.margelo.nitro.core.HybridObject
    public long getMemorySize() {
        return 0L;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    public NativePlatformAndroid(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this._insets = new NativePlatformInsets(reactContext, new NativePlatformAndroid$_insets$1(this), new Function0() { // from class: com.unistyles.NativePlatformAndroid$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NativePlatformAndroid._insets$lambda$0(this.f$0);
            }
        });
        this._miniRuntime = buildMiniRuntime();
        this._listener = new NativePlatformListener(reactContext, new NativePlatformAndroid$_listener$1(this), new Function0() { // from class: com.unistyles.NativePlatformAndroid$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.diffMiniRuntime();
            }
        });
        checkEdgeToEdge();
        reactContext.addLifecycleEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _insets$lambda$0(NativePlatformAndroid nativePlatformAndroid) {
        nativePlatformAndroid.onConfigChange();
        return Unit.INSTANCE;
    }

    public final void onDestroy() {
        this._listener.onDestroy();
        this._insets.onDestroy();
        this.reactContext.removeLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        this._insets.getInitialInsets(false);
        this._insets.startInsetsListener();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        this._insets.stopInsetsListener();
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public Insets getInsets() {
        return this._insets.getInsets();
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public ColorScheme getColorScheme() {
        int i = this.reactContext.getResources().getConfiguration().uiMode & 48;
        if (i == 16) {
            return ColorScheme.LIGHT;
        }
        if (i == 32) {
            return ColorScheme.DARK;
        }
        return ColorScheme.UNSPECIFIED;
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public double getFontScale() {
        return this.reactContext.getResources().getConfiguration().fontScale;
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public double getPixelRatio() {
        return this.reactContext.getResources().getDisplayMetrics().density;
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public Orientation getOrientation() {
        int i = this.reactContext.getResources().getConfiguration().orientation;
        if (i == 1) {
            return Orientation.PORTRAIT;
        }
        if (i == 2) {
            return Orientation.LANDSCAPE;
        }
        return Orientation.PORTRAIT;
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public String getContentSizeCategory() {
        double fontScale = getFontScale();
        if (fontScale <= 0.8500000238418579d) {
            return "Small";
        }
        if (fontScale <= 1.0d) {
            return "Default";
        }
        if (fontScale <= 1.149999976158142d) {
            return "Large";
        }
        if (fontScale <= 1.2999999523162842d) {
            return "ExtraLarge";
        }
        if (fontScale <= 1.5d) {
            return "Huge";
        }
        if (fontScale <= 1.8d) {
            return "ExtraHuge";
        }
        return "ExtraExtraHuge";
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public Dimensions getScreenDimensions() {
        WindowManager windowManager;
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        if (Build.VERSION.SDK_INT < 30) {
            Object systemService = this.reactContext.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
            float f = displayMetrics.widthPixels;
            float f2 = displayMetrics.density;
            return new Dimensions(f / f2, displayMetrics.heightPixels / f2);
        }
        DisplayMetrics displayMetrics2 = this.reactContext.getResources().getDisplayMetrics();
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity != null && (windowManager = currentActivity.getWindowManager()) != null && (currentWindowMetrics = windowManager.getCurrentWindowMetrics()) != null && (bounds = currentWindowMetrics.getBounds()) != null) {
            return new Dimensions(bounds.width() / displayMetrics2.density, bounds.height() / displayMetrics2.density);
        }
        float f3 = displayMetrics2.widthPixels;
        float f4 = displayMetrics2.density;
        return new Dimensions(f3 / f4, displayMetrics2.heightPixels / f4);
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public Dimensions getStatusBarDimensions() {
        return new Dimensions(getScreenDimensions().getWidth(), this._insets.getInsets().getTop());
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public Dimensions getNavigationBarDimensions() {
        return new Dimensions(getScreenDimensions().getWidth(), this._insets.getInsets().getBottom());
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public boolean getPrefersRtlDirection() {
        return this.reactContext.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).getBoolean("RCTI18nUtil_forceRTL", false) || (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) || (TextUtilsCompat.getLayoutDirectionFromLocale(this.reactContext.getResources().getConfiguration().getLocales().get(0)) == 1);
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public void setRootViewBackgroundColor(final double color) {
        Window window;
        final View decorView;
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.unistyles.NativePlatformAndroid$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                NativePlatformAndroid.setRootViewBackgroundColor$lambda$6$lambda$5$lambda$4(decorView, color);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRootViewBackgroundColor$lambda$6$lambda$5$lambda$4(View view, double d) {
        view.getRootView().setBackgroundColor((int) d);
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public void setNavigationBarHidden(final boolean isHidden) {
        final View decorView;
        final Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity != null) {
            final WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(currentActivity.getWindow(), currentActivity.getWindow().getDecorView());
            Window window = currentActivity.getWindow();
            if (window == null || (decorView = window.getDecorView()) == null) {
                return;
            }
            currentActivity.runOnUiThread(new Runnable() { // from class: com.unistyles.NativePlatformAndroid$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    NativePlatformAndroid.setNavigationBarHidden$lambda$10$lambda$9$lambda$8$lambda$7(isHidden, decorView, windowInsetsControllerCompat, currentActivity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigationBarHidden$lambda$10$lambda$9$lambda$8$lambda$7(boolean z, View view, WindowInsetsControllerCompat windowInsetsControllerCompat, Activity activity) {
        if (z) {
            if (Build.VERSION.SDK_INT <= 29) {
                view.setSystemUiVisibility(4610);
            } else {
                windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.navigationBars());
                windowInsetsControllerCompat.setSystemBarsBehavior(2);
            }
            WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setInsets(WindowInsetsCompat.Type.navigationBars(), androidx.core.graphics.Insets.of(0, 0, 0, 0)).build();
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatBuild, "build(...)");
            ViewCompat.dispatchApplyWindowInsets(activity.findViewById(android.R.id.content), windowInsetsCompatBuild);
            return;
        }
        windowInsetsControllerCompat.show(WindowInsetsCompat.Type.navigationBars());
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public void setStatusBarHidden(final boolean isHidden) {
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity != null) {
            final WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(currentActivity.getWindow(), currentActivity.getWindow().getDecorView());
            final Window window = currentActivity.getWindow();
            if (window != null) {
                currentActivity.runOnUiThread(new Runnable() { // from class: com.unistyles.NativePlatformAndroid$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        NativePlatformAndroid.setStatusBarHidden$lambda$14$lambda$13$lambda$12$lambda$11(isHidden, window, windowInsetsControllerCompat);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStatusBarHidden$lambda$14$lambda$13$lambda$12$lambda$11(boolean z, Window window, WindowInsetsControllerCompat windowInsetsControllerCompat) {
        if (z) {
            if (Build.VERSION.SDK_INT <= 29) {
                window.addFlags(IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET);
                window.clearFlags(2048);
                return;
            } else {
                windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.statusBars());
                return;
            }
        }
        windowInsetsControllerCompat.show(WindowInsetsCompat.Type.statusBars());
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public void setImmersiveMode(boolean isEnabled) {
        setStatusBarHidden(isEnabled);
        setNavigationBarHidden(isEnabled);
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    /* JADX INFO: renamed from: getMiniRuntime, reason: from getter */
    public UnistylesNativeMiniRuntime get_miniRuntime() {
        return this._miniRuntime;
    }

    private final UnistylesNativeMiniRuntime buildMiniRuntime() {
        Orientation orientation = getOrientation();
        return new UnistylesNativeMiniRuntime(getColorScheme(), getScreenDimensions(), getContentSizeCategory(), getInsets(), getPixelRatio(), getFontScale(), getPrefersRtlDirection(), getStatusBarDimensions(), getNavigationBarDimensions(), orientation == Orientation.PORTRAIT, orientation == Orientation.LANDSCAPE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UnistyleDependency[] diffMiniRuntime() {
        UnistylesNativeMiniRuntime unistylesNativeMiniRuntimeBuildMiniRuntime = buildMiniRuntime();
        UnistyleDependency[] unistyleDependencyArrDiffMiniRuntimes = EquatableKt.diffMiniRuntimes(this, this._miniRuntime, unistylesNativeMiniRuntimeBuildMiniRuntime);
        if (!(unistyleDependencyArrDiffMiniRuntimes.length == 0)) {
            this._miniRuntime = unistylesNativeMiniRuntimeBuildMiniRuntime;
        }
        return unistyleDependencyArrDiffMiniRuntimes;
    }

    private final void onConfigChange() {
        this._listener.onConfigChange();
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public void registerPlatformListener(Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this._listener.addPlatformListener(callback);
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public void registerImeListener(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this._insets.addImeListener(callback);
    }

    @Override // com.margelo.nitro.unistyles.HybridNativePlatformSpec
    public void unregisterPlatformListeners() {
        this._listener.removePlatformListeners();
        this._insets.removeImeListeners();
    }

    private final boolean isEdgeToEdgeAlreadyEnabled() {
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return !currentActivity.getWindow().getDecorView().getFitsSystemWindows();
        }
        return (currentActivity.getWindow().getDecorView().getSystemUiVisibility() & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0;
    }

    private final void enableEdgeToEdge() {
        final Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() { // from class: com.unistyles.NativePlatformAndroid$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NativePlatformAndroid.enableEdgeToEdge$lambda$16$lambda$15(currentActivity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enableEdgeToEdge$lambda$16$lambda$15(Activity activity) {
        WindowCompat.setDecorFitsSystemWindows(activity.getWindow(), false);
    }
}
