package com.datadog.android.rum.internal.domain.accessibility;

import android.app.ActivityManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.internal.domain.InfoProvider;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAccessibilityReader implements InfoProvider, ComponentCallbacks {
    public static final Companion Companion = new Companion(null);
    private final AccessibilityManager accessibilityManager;
    private final ActivityManager activityManager;
    private final DefaultAccessibilityReader$animationDurationListener$1 animationDurationListener;
    private final Context applicationContext;
    private final DefaultAccessibilityReader$captioningListener$1 captioningListener;
    private volatile AccessibilityInfo currentState;
    private final DefaultAccessibilityReader$displayInversionListener$1 displayInversionListener;
    private final GlobalWrapper globalWrapper;
    private final Handler handler;
    private final InternalLogger internalLogger;
    private AtomicLong lastPollTime;
    private final Resources resources;
    private final SecureWrapper secureWrapper;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchListener;

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$displayInversionListener$1] */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$captioningListener$1] */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$animationDurationListener$1] */
    public DefaultAccessibilityReader(InternalLogger internalLogger, Context applicationContext, Resources resources, ActivityManager activityManager, AccessibilityManager accessibilityManager, SecureWrapper secureWrapper, GlobalWrapper globalWrapper, final Handler handler) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(secureWrapper, "secureWrapper");
        Intrinsics.checkNotNullParameter(globalWrapper, "globalWrapper");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.internalLogger = internalLogger;
        this.applicationContext = applicationContext;
        this.resources = resources;
        this.activityManager = activityManager;
        this.accessibilityManager = accessibilityManager;
        this.secureWrapper = secureWrapper;
        this.globalWrapper = globalWrapper;
        this.handler = handler;
        this.displayInversionListener = new ContentObserver(handler) { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$displayInversionListener$1
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                final Boolean boolIsDisplayInversionEnabled = this.this$0.isDisplayInversionEnabled();
                this.this$0.updateState(new Function1() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$displayInversionListener$1$onChange$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final AccessibilityInfo invoke(AccessibilityInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return AccessibilityInfo.copy$default(it, null, null, boolIsDisplayInversionEnabled, null, null, null, null, 123, null);
                    }
                });
            }
        };
        this.captioningListener = new ContentObserver(handler) { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$captioningListener$1
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                final Boolean boolIsClosedCaptioningEnabled = this.this$0.isClosedCaptioningEnabled();
                this.this$0.updateState(new Function1() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$captioningListener$1$onChange$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final AccessibilityInfo invoke(AccessibilityInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return AccessibilityInfo.copy$default(it, null, null, null, boolIsClosedCaptioningEnabled, null, null, null, 119, null);
                    }
                });
            }
        };
        this.animationDurationListener = new ContentObserver(handler) { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$animationDurationListener$1
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                final Boolean boolIsReducedAnimationsEnabled = this.this$0.isReducedAnimationsEnabled();
                this.this$0.updateState(new Function1() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$animationDurationListener$1$onChange$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final AccessibilityInfo invoke(AccessibilityInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return AccessibilityInfo.copy$default(it, null, null, null, null, boolIsReducedAnimationsEnabled, null, null, 111, null);
                    }
                });
            }
        };
        this.touchListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$$ExternalSyntheticLambda0
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                DefaultAccessibilityReader.touchListener$lambda$0(this.f$0, z);
            }
        };
        this.currentState = new AccessibilityInfo(null, null, null, null, null, null, null, 127, null);
        this.lastPollTime = new AtomicLong(0L);
        registerListeners();
        buildInitialState();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DefaultAccessibilityReader(InternalLogger internalLogger, Context context, Resources resources, ActivityManager activityManager, AccessibilityManager accessibilityManager, SecureWrapper secureWrapper, GlobalWrapper globalWrapper, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Resources resources2;
        ActivityManager activityManager2;
        AccessibilityManager accessibilityManager2;
        if ((i & 4) != 0) {
            Resources resources3 = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources3, "applicationContext.resources");
            resources2 = resources3;
        } else {
            resources2 = resources;
        }
        if ((i & 8) != 0) {
            Object systemService = context.getSystemService("activity");
            activityManager2 = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        } else {
            activityManager2 = activityManager;
        }
        if ((i & 16) != 0) {
            Object systemService2 = context.getSystemService("accessibility");
            accessibilityManager2 = systemService2 instanceof AccessibilityManager ? (AccessibilityManager) systemService2 : null;
        } else {
            accessibilityManager2 = accessibilityManager;
        }
        this(internalLogger, context, resources2, activityManager2, accessibilityManager2, (i & 32) != 0 ? new SecureWrapper() : secureWrapper, (i & 64) != 0 ? new GlobalWrapper() : globalWrapper, (i & 128) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchListener$lambda$0(DefaultAccessibilityReader this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Boolean boolIsScreenReaderEnabled = this$0.isScreenReaderEnabled(this$0.accessibilityManager);
        this$0.updateState(new Function1() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$touchListener$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AccessibilityInfo invoke(AccessibilityInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return AccessibilityInfo.copy$default(it, null, boolIsScreenReaderEnabled, null, null, null, null, null, 125, null);
            }
        });
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public void cleanup() {
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(this.touchListener);
        }
        this.applicationContext.getContentResolver().unregisterContentObserver(this.animationDurationListener);
        this.applicationContext.getContentResolver().unregisterContentObserver(this.captioningListener);
        this.applicationContext.getContentResolver().unregisterContentObserver(this.displayInversionListener);
        this.applicationContext.unregisterComponentCallbacks(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        final boolean rtlEnabled = getRtlEnabled();
        final String textSize = getTextSize();
        updateState(new Function1() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader.onConfigurationChanged.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AccessibilityInfo invoke(AccessibilityInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return AccessibilityInfo.copy$default(it, textSize, null, null, null, null, null, Boolean.valueOf(rtlEnabled), 62, null);
            }
        });
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public synchronized AccessibilityInfo getState() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastPollTime.get() >= HTTPTimeoutManager.DEFAULT_TIMEOUT_MS) {
                this.lastPollTime.set(jCurrentTimeMillis);
                pollForAttributesWithoutListeners();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void updateState(Function1 function1) {
        this.currentState = (AccessibilityInfo) function1.invoke(this.currentState);
    }

    private final void buildInitialState() {
        String textSize = getTextSize();
        Boolean boolIsScreenReaderEnabled = isScreenReaderEnabled(this.accessibilityManager);
        Boolean boolIsDisplayInversionEnabled = isDisplayInversionEnabled();
        Boolean boolIsLockToScreenEnabled = isLockToScreenEnabled();
        this.currentState = new AccessibilityInfo(textSize, boolIsScreenReaderEnabled, boolIsDisplayInversionEnabled, isClosedCaptioningEnabled(), isReducedAnimationsEnabled(), boolIsLockToScreenEnabled, Boolean.valueOf(getRtlEnabled()));
    }

    private final void registerListeners() {
        this.applicationContext.registerComponentCallbacks(this);
        this.applicationContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("accessibility_display_inversion_enabled"), false, this.displayInversionListener);
        this.applicationContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("accessibility_captioning_enabled"), false, this.captioningListener);
        this.applicationContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("animator_duration_scale"), false, this.animationDurationListener);
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null) {
            accessibilityManager.addTouchExplorationStateChangeListener(this.touchListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Boolean isDisplayInversionEnabled() {
        return isSettingEnabled("accessibility_display_inversion_enabled");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Boolean isClosedCaptioningEnabled() {
        return isSettingEnabled("accessibility_captioning_enabled");
    }

    private final Boolean isLockToScreenEnabled() {
        ActivityManager activityManager = this.activityManager;
        if (activityManager == null) {
            return null;
        }
        return Boolean.valueOf(activityManager.getLockTaskModeState() != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Boolean isReducedAnimationsEnabled() {
        Float float$dd_sdk_android_rum_release = this.globalWrapper.getFloat$dd_sdk_android_rum_release(this.internalLogger, this.applicationContext, "animator_duration_scale");
        if (float$dd_sdk_android_rum_release != null) {
            return Boolean.valueOf(float$dd_sdk_android_rum_release.floatValue() == 0.0f);
        }
        return null;
    }

    private final Boolean isSettingEnabled(String str) {
        Integer int$dd_sdk_android_rum_release = this.secureWrapper.getInt$dd_sdk_android_rum_release(this.internalLogger, this.applicationContext, str);
        if (int$dd_sdk_android_rum_release != null) {
            return Boolean.valueOf(int$dd_sdk_android_rum_release.intValue() == 1);
        }
        return null;
    }

    private final String getTextSize() {
        return String.valueOf(this.resources.getConfiguration().fontScale);
    }

    private final boolean getRtlEnabled() {
        return this.resources.getConfiguration().getLayoutDirection() == 1;
    }

    private final Boolean isScreenReaderEnabled(AccessibilityManager accessibilityManager) {
        if (accessibilityManager != null) {
            return Boolean.valueOf(accessibilityManager.isTouchExplorationEnabled());
        }
        return null;
    }

    private final void pollForAttributesWithoutListeners() {
        final Boolean boolIsLockToScreenEnabled = isLockToScreenEnabled();
        updateState(new Function1() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader.pollForAttributesWithoutListeners.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AccessibilityInfo invoke(AccessibilityInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return AccessibilityInfo.copy$default(it, null, null, null, null, null, boolIsLockToScreenEnabled, null, 95, null);
            }
        });
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
