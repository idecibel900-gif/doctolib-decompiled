package com.facebook.react.devsupport;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DevInternalSettings implements DeveloperSettings, SharedPreferences.OnSharedPreferenceChangeListener {
    public static final Companion Companion = new Companion(null);
    private boolean isDeviceDebugEnabled;
    private final Listener listener;
    private final PackagerConnectionSettings packagerConnectionSettings;
    private final SharedPreferences preferences;

    public interface Listener {
        void onInternalSettingsChanged();
    }

    public DevInternalSettings(Context applicationContext, Listener listener) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.listener = listener;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.preferences = defaultSharedPreferences;
        this.packagerConnectionSettings = new PackagerConnectionSettings(applicationContext);
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.isDeviceDebugEnabled = ReactBuildConfig.DEBUG;
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public PackagerConnectionSettings getPackagerConnectionSettings() {
        return this.packagerConnectionSettings;
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isFpsDebugEnabled() {
        return this.preferences.getBoolean("fps_debug", false);
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setFpsDebugEnabled(boolean z) {
        this.preferences.edit().putBoolean("fps_debug", z).apply();
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isJSDevModeEnabled() {
        return this.preferences.getBoolean("js_dev_mode_debug", true);
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setJSDevModeEnabled(boolean z) {
        this.preferences.edit().putBoolean("js_dev_mode_debug", z).apply();
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isJSMinifyEnabled() {
        return this.preferences.getBoolean("js_minify_debug", false);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        if (this.listener != null) {
            if (Intrinsics.areEqual("fps_debug", str) || Intrinsics.areEqual("js_dev_mode_debug", str) || Intrinsics.areEqual("js_minify_debug", str)) {
                this.listener.onInternalSettingsChanged();
            }
        }
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isElementInspectorEnabled() {
        return this.preferences.getBoolean("inspector_debug", false);
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setElementInspectorEnabled(boolean z) {
        this.preferences.edit().putBoolean("inspector_debug", z).apply();
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isDeviceDebugEnabled() {
        return this.isDeviceDebugEnabled;
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isHotModuleReplacementEnabled() {
        return this.preferences.getBoolean("hot_module_replacement", true);
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setHotModuleReplacementEnabled(boolean z) {
        this.preferences.edit().putBoolean("hot_module_replacement", z).apply();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
