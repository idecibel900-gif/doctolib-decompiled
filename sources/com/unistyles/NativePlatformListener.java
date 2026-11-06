package com.unistyles;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.margelo.nitro.unistyles.UnistyleDependency;
import com.margelo.nitro.unistyles.UnistylesNativeMiniRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001 \b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u000eJ1\u0010\u0017\u001a\u00020\f2\"\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0014j\u0002`\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u000eJ\r\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR \u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001cR6\u0010\u001e\u001a$\u0012 \u0012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0014j\u0002`\u00150\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010(\u001a\n '*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/unistyles/NativePlatformListener;", "", "Lcom/facebook/react/bridge/ReactApplicationContext;", "reactContext", "Lkotlin/Function0;", "Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "getMiniRuntime", "", "Lcom/margelo/nitro/unistyles/UnistyleDependency;", "diffMiniRuntime", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "", "notifyConfigChangedWithDelay", "()V", "dependencies", "miniRuntime", "emitCxxEvent", "([Lcom/margelo/nitro/unistyles/UnistyleDependency;Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;)V", "onDestroy", "Lkotlin/Function2;", "Lcom/unistyles/CxxDependencyListener;", "listener", "addPlatformListener", "(Lkotlin/jvm/functions/Function2;)V", "removePlatformListeners", "onConfigChange", "Lcom/facebook/react/bridge/ReactApplicationContext;", "Lkotlin/jvm/functions/Function0;", "", "_dependencyListeners", "Ljava/util/List;", "com/unistyles/NativePlatformListener$configurationChangeReceiver$1", "configurationChangeReceiver", "Lcom/unistyles/NativePlatformListener$configurationChangeReceiver$1;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "rtlPreferenceListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "i18nUtilSharedPrefs", "Landroid/content/SharedPreferences;", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativePlatformListener {
    private final List<Function2> _dependencyListeners;
    private final NativePlatformListener$configurationChangeReceiver$1 configurationChangeReceiver;
    private final Function0 diffMiniRuntime;
    private final Function0 getMiniRuntime;
    private final SharedPreferences i18nUtilSharedPrefs;
    private final ReactApplicationContext reactContext;
    private final SharedPreferences.OnSharedPreferenceChangeListener rtlPreferenceListener;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.content.BroadcastReceiver, com.unistyles.NativePlatformListener$configurationChangeReceiver$1] */
    public NativePlatformListener(ReactApplicationContext reactContext, Function0 getMiniRuntime, Function0 diffMiniRuntime) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(getMiniRuntime, "getMiniRuntime");
        Intrinsics.checkNotNullParameter(diffMiniRuntime, "diffMiniRuntime");
        this.reactContext = reactContext;
        this.getMiniRuntime = getMiniRuntime;
        this.diffMiniRuntime = diffMiniRuntime;
        this._dependencyListeners = new ArrayList();
        ?? r5 = new BroadcastReceiver() { // from class: com.unistyles.NativePlatformListener$configurationChangeReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                this.this$0.notifyConfigChangedWithDelay();
            }
        };
        this.configurationChangeReceiver = r5;
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.unistyles.NativePlatformListener$$ExternalSyntheticLambda1
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                NativePlatformListener.rtlPreferenceListener$lambda$1(this.f$0, sharedPreferences, str);
            }
        };
        this.rtlPreferenceListener = onSharedPreferenceChangeListener;
        SharedPreferences sharedPreferences = reactContext.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0);
        this.i18nUtilSharedPrefs = sharedPreferences;
        reactContext.registerReceiver(r5, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyConfigChangedWithDelay() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.unistyles.NativePlatformListener$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onConfigChange();
            }
        }, 25L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rtlPreferenceListener$lambda$1(NativePlatformListener nativePlatformListener, SharedPreferences sharedPreferences, String str) {
        if (str != null && str.hashCode() == 1473819547 && str.equals("RCTI18nUtil_forceRTL")) {
            nativePlatformListener.notifyConfigChangedWithDelay();
        }
    }

    public final void onDestroy() {
        removePlatformListeners();
        this.reactContext.unregisterReceiver(this.configurationChangeReceiver);
        this.i18nUtilSharedPrefs.unregisterOnSharedPreferenceChangeListener(this.rtlPreferenceListener);
    }

    public final void addPlatformListener(Function2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this._dependencyListeners.add(listener);
    }

    public final void removePlatformListeners() {
        this._dependencyListeners.clear();
    }

    private final void emitCxxEvent(UnistyleDependency[] dependencies, UnistylesNativeMiniRuntime miniRuntime) {
        Iterator<T> it = this._dependencyListeners.iterator();
        while (it.hasNext()) {
            ((Function2) it.next()).invoke(dependencies, miniRuntime);
        }
    }

    public final void onConfigChange() {
        UnistyleDependency[] unistyleDependencyArr = (UnistyleDependency[]) this.diffMiniRuntime.invoke();
        if (unistyleDependencyArr.length == 0) {
            return;
        }
        emitCxxEvent(unistyleDependencyArr, (UnistylesNativeMiniRuntime) this.getMiniRuntime.invoke());
    }
}
