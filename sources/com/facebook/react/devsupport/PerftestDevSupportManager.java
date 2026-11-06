package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class PerftestDevSupportManager extends ReleaseDevSupportManager {
    private final DevServerHelper devServerHelper;
    private final DeveloperSettings devSettings;

    public PerftestDevSupportManager(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.devSettings = new DevInternalSettings(applicationContext, new DevInternalSettings.Listener() { // from class: com.facebook.react.devsupport.PerftestDevSupportManager$devSettings$1
            @Override // com.facebook.react.devsupport.DevInternalSettings.Listener
            public void onInternalSettingsChanged() {
            }
        });
        this.devServerHelper = new DevServerHelper(getDevSettings(), applicationContext, getDevSettings().getPackagerConnectionSettings());
    }

    @Override // com.facebook.react.devsupport.ReleaseDevSupportManager, com.facebook.react.devsupport.interfaces.DevSupportManager
    public DeveloperSettings getDevSettings() {
        return this.devSettings;
    }

    @Override // com.facebook.react.devsupport.ReleaseDevSupportManager, com.facebook.react.devsupport.interfaces.DevSupportManager
    public void startInspector() {
        this.devServerHelper.openInspectorConnection();
    }

    @Override // com.facebook.react.devsupport.ReleaseDevSupportManager, com.facebook.react.devsupport.interfaces.DevSupportManager
    public void stopInspector() {
        this.devServerHelper.closeInspectorConnection();
    }
}
