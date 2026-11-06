package com.datadog.android.rum.internal.domain.display;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.internal.domain.InfoProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultDisplayInfoProvider implements InfoProvider {
    private static final Companion Companion = new Companion(null);
    private final Context applicationContext;
    private final DefaultDisplayInfoProvider$brightnessObserver$1 brightnessObserver;
    private final ContentResolver contentResolver;
    private volatile DisplayInfo currentState;
    private final Handler handler;
    private final InternalLogger internalLogger;
    private final SystemSettingsWrapper systemSettingsWrapper;

    /* JADX WARN: Type inference failed for: r2v2, types: [com.datadog.android.rum.internal.domain.display.DefaultDisplayInfoProvider$brightnessObserver$1] */
    public DefaultDisplayInfoProvider(Context applicationContext, InternalLogger internalLogger, SystemSettingsWrapper systemSettingsWrapper, ContentResolver contentResolver, final Handler handler) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(systemSettingsWrapper, "systemSettingsWrapper");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.applicationContext = applicationContext;
        this.internalLogger = internalLogger;
        this.systemSettingsWrapper = systemSettingsWrapper;
        this.contentResolver = contentResolver;
        this.handler = handler;
        this.currentState = new DisplayInfo(null, 1, null);
        this.brightnessObserver = new ContentObserver(handler) { // from class: com.datadog.android.rum.internal.domain.display.DefaultDisplayInfoProvider$brightnessObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                int i = this.this$0.systemSettingsWrapper.getInt("screen_brightness");
                if (i != Integer.MIN_VALUE) {
                    float fNormalizeValue = this.this$0.normalizeValue(i);
                    DefaultDisplayInfoProvider defaultDisplayInfoProvider = this.this$0;
                    defaultDisplayInfoProvider.currentState = defaultDisplayInfoProvider.currentState.copy(Float.valueOf(fNormalizeValue));
                }
            }
        };
        registerListeners();
        buildInitialState();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DefaultDisplayInfoProvider(Context context, InternalLogger internalLogger, SystemSettingsWrapper systemSettingsWrapper, ContentResolver contentResolver, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        SystemSettingsWrapper systemSettingsWrapper2 = (i & 4) != 0 ? new SystemSettingsWrapper(context, internalLogger) : systemSettingsWrapper;
        if ((i & 8) != 0) {
            contentResolver = context.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "applicationContext.contentResolver");
        }
        this(context, internalLogger, systemSettingsWrapper2, contentResolver, (i & 16) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public DisplayInfo getState() {
        return this.currentState;
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public void cleanup() {
        this.contentResolver.unregisterContentObserver(this.brightnessObserver);
    }

    private final void registerListeners() {
        Uri uriFor = Settings.System.getUriFor("screen_brightness");
        if (uriFor != null) {
            this.contentResolver.registerContentObserver(uriFor, false, this.brightnessObserver);
        }
    }

    private final void buildInitialState() {
        int i = this.systemSettingsWrapper.getInt("screen_brightness");
        if (i != Integer.MIN_VALUE) {
            this.currentState = new DisplayInfo(Float.valueOf(normalizeValue(i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float normalizeValue(int i) {
        return roundToOneDecimalPlace(i / 255.0f);
    }

    private final float roundToOneDecimalPlace(float f) {
        return MathKt.roundToInt(f * 10.0f) / 10.0f;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
