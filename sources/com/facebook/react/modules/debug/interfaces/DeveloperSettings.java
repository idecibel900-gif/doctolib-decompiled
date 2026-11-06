package com.facebook.react.modules.debug.interfaces;

import com.facebook.react.packagerconnection.PackagerConnectionSettings;

/* JADX INFO: loaded from: classes3.dex */
public interface DeveloperSettings {
    PackagerConnectionSettings getPackagerConnectionSettings();

    boolean isDeviceDebugEnabled();

    boolean isElementInspectorEnabled();

    boolean isFpsDebugEnabled();

    boolean isHotModuleReplacementEnabled();

    boolean isJSDevModeEnabled();

    boolean isJSMinifyEnabled();

    void setElementInspectorEnabled(boolean z);

    void setFpsDebugEnabled(boolean z);

    void setHotModuleReplacementEnabled(boolean z);

    void setJSDevModeEnabled(boolean z);
}
