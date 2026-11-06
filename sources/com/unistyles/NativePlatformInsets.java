package com.unistyles;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.Keep;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.margelo.nitro.unistyles.Insets;
import com.margelo.nitro.unistyles.UnistylesNativeMiniRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\fJ\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0007¢\u0006\u0004\b \u0010\fJ%\u0010$\u001a\u00020\u00072\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070!j\u0002`\"¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0007¢\u0006\u0004\b&\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010(R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010(R\u0016\u0010)\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010*R*\u0010-\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070!j\u0002`\"0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/unistyles/NativePlatformInsets;", "", "Lcom/facebook/react/bridge/ReactApplicationContext;", "reactContext", "Lkotlin/Function0;", "Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "getMiniRuntime", "", "onConfigChange", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "onDestroy", "()V", "Lcom/margelo/nitro/unistyles/Insets;", "getInsets", "()Lcom/margelo/nitro/unistyles/Insets;", "", "skipUpdate", "getInitialInsets", "(Z)V", "Landroidx/core/view/WindowInsetsCompat;", "insetsCompat", "Landroid/view/Window;", "window", "", "animatedBottomInsets", "setInsets", "(Landroidx/core/view/WindowInsetsCompat;Landroid/view/Window;Ljava/lang/Double;Z)V", "startInsetsListener", "miniRuntime", "emitImeEvent", "(Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;)V", "stopInsetsListener", "Lkotlin/Function1;", "Lcom/unistyles/CxxImeListener;", "listener", "addImeListener", "(Lkotlin/jvm/functions/Function1;)V", "removeImeListeners", "Lcom/facebook/react/bridge/ReactApplicationContext;", "Lkotlin/jvm/functions/Function0;", "_didGetInsets", "Z", "_shouldListenToImeEvents", "", "_imeListeners", "Ljava/util/List;", "_insets", "Lcom/margelo/nitro/unistyles/Insets;", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativePlatformInsets {
    private boolean _didGetInsets;
    private final List<Function1> _imeListeners;
    private Insets _insets;
    private boolean _shouldListenToImeEvents;
    private final Function0 getMiniRuntime;
    private final Function0 onConfigChange;
    private final ReactApplicationContext reactContext;

    public NativePlatformInsets(ReactApplicationContext reactContext, Function0 getMiniRuntime, Function0 onConfigChange) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(getMiniRuntime, "getMiniRuntime");
        Intrinsics.checkNotNullParameter(onConfigChange, "onConfigChange");
        this.reactContext = reactContext;
        this.getMiniRuntime = getMiniRuntime;
        this.onConfigChange = onConfigChange;
        this._imeListeners = new ArrayList();
        this._insets = new Insets(0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        getInitialInsets(true);
    }

    public final void onDestroy() {
        removeImeListeners();
    }

    public final Insets getInsets() {
        double d = this.reactContext.getResources().getDisplayMetrics().density;
        return new Insets(this._insets.getTop() / d, this._insets.getBottom() / d, this._insets.getLeft() / d, this._insets.getRight() / d, this._insets.getIme() / d);
    }

    public static /* synthetic */ void getInitialInsets$default(NativePlatformInsets nativePlatformInsets, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        nativePlatformInsets.getInitialInsets(z);
    }

    public final void getInitialInsets(boolean skipUpdate) {
        Activity currentActivity;
        View viewFindViewById;
        WindowInsetsCompat rootWindowInsets;
        if (this._didGetInsets || (currentActivity = this.reactContext.getCurrentActivity()) == null || (viewFindViewById = currentActivity.findViewById(android.R.id.content)) == null || (rootWindowInsets = ViewCompat.getRootWindowInsets(viewFindViewById)) == null) {
            return;
        }
        Window window = currentActivity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        setInsets(rootWindowInsets, window, null, skipUpdate);
        this._didGetInsets = true;
    }

    public static /* synthetic */ void setInsets$default(NativePlatformInsets nativePlatformInsets, WindowInsetsCompat windowInsetsCompat, Window window, Double d, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        nativePlatformInsets.setInsets(windowInsetsCompat, window, d, z);
    }

    public final void setInsets(WindowInsetsCompat insetsCompat, Window window, Double animatedBottomInsets, boolean skipUpdate) {
        boolean zIsVisible;
        int i;
        int i2;
        double dMax;
        Intrinsics.checkNotNullParameter(insetsCompat, "insetsCompat");
        Intrinsics.checkNotNullParameter(window, "window");
        Insets insets = this._insets;
        int i3 = Build.VERSION.SDK_INT;
        if (30 <= i3) {
            zIsVisible = insetsCompat.isVisible(WindowInsetsCompat.Type.statusBars());
        } else {
            zIsVisible = (window.getAttributes().flags & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 1024;
        }
        if (zIsVisible) {
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            i = rect.top;
        } else {
            if (zIsVisible) {
                throw new NoWhenBranchMatchedException();
            }
            i = 0;
        }
        androidx.core.graphics.Insets insets2 = insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        int i4 = insetsCompat.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        if (i4 > 0 && insets2.bottom >= i4) {
            i2 = insetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars() | WindowInsetsCompat.Type.displayCutout()).bottom;
        } else {
            i2 = insets2.bottom;
        }
        if (animatedBottomInsets != null && i3 >= 30) {
            dMax = animatedBottomInsets.doubleValue();
        } else {
            dMax = i3 < 30 ? Math.max(i4 - i2, 0) : 0.0d;
        }
        Insets insets3 = new Insets(i, i2, insets2.left, insets2.right, dMax);
        this._insets = insets3;
        boolean zIsEqualTo = EquatableKt.isEqualTo(insets, insets3);
        boolean z = !((insets.getIme() > this._insets.getIme() ? 1 : (insets.getIme() == this._insets.getIme() ? 0 : -1)) == 0) && (i3 < 30 || (animatedBottomInsets != null && i3 >= 30));
        if (skipUpdate) {
            return;
        }
        if (!zIsEqualTo) {
            this.onConfigChange.invoke();
        }
        if (z) {
            emitImeEvent(UnistylesNativeMiniRuntime.copy$default((UnistylesNativeMiniRuntime) this.getMiniRuntime.invoke(), null, null, null, getInsets(), 0.0d, 0.0d, false, null, null, false, false, 2039, null));
        }
    }

    public final void startInsetsListener() {
        View viewFindViewById;
        this._shouldListenToImeEvents = true;
        final Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null || (viewFindViewById = currentActivity.findViewById(android.R.id.content)) == null) {
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, new OnApplyWindowInsetsListener() { // from class: com.unistyles.NativePlatformInsets$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return NativePlatformInsets.startInsetsListener$lambda$5$lambda$4$lambda$3(this.f$0, currentActivity, view, windowInsetsCompat);
            }
        });
        if (Build.VERSION.SDK_INT >= 30) {
            ViewCompat.setWindowInsetsAnimationCallback(viewFindViewById, new WindowInsetsAnimationCompat.Callback() { // from class: com.unistyles.NativePlatformInsets$startInsetsListener$1$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
                public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
                    Object next;
                    Intrinsics.checkNotNullParameter(insets, "insets");
                    Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
                    if (this.this$0._shouldListenToImeEvents) {
                        Iterator<T> it = runningAnimations.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                        } while ((((WindowInsetsAnimationCompat) next).getTypeMask() & WindowInsetsCompat.Type.ime()) == 0);
                        if (((WindowInsetsAnimationCompat) next) != null) {
                            NativePlatformInsets nativePlatformInsets = this.this$0;
                            Activity activity = currentActivity;
                            double bottom = ((double) insets.getInsets(WindowInsetsCompat.Type.ime()).bottom) - nativePlatformInsets._insets.getBottom();
                            if (bottom < 0.0d) {
                                bottom = 0.0d;
                            }
                            Window window = activity.getWindow();
                            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
                            NativePlatformInsets.setInsets$default(nativePlatformInsets, insets, window, Double.valueOf(bottom), false, 8, null);
                            return insets;
                        }
                    }
                    return insets;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat startInsetsListener$lambda$5$lambda$4$lambda$3(NativePlatformInsets nativePlatformInsets, Activity activity, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        setInsets$default(nativePlatformInsets, insets, window, null, false, 8, null);
        return insets;
    }

    public final void emitImeEvent(UnistylesNativeMiniRuntime miniRuntime) {
        Intrinsics.checkNotNullParameter(miniRuntime, "miniRuntime");
        Iterator<T> it = this._imeListeners.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(miniRuntime);
        }
    }

    public final void stopInsetsListener() {
        View viewFindViewById;
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity != null && (viewFindViewById = currentActivity.findViewById(android.R.id.content)) != null) {
            ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, null);
        }
        this._shouldListenToImeEvents = false;
    }

    public final void addImeListener(Function1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this._imeListeners.add(listener);
    }

    public final void removeImeListeners() {
        this._imeListeners.clear();
    }
}
