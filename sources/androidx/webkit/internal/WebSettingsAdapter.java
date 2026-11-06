package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class WebSettingsAdapter {
    private final WebSettingsBoundaryInterface mBoundaryInterface;

    public WebSettingsAdapter(WebSettingsBoundaryInterface webSettingsBoundaryInterface) {
        this.mBoundaryInterface = webSettingsBoundaryInterface;
    }

    public void setForceDark(int i) {
        this.mBoundaryInterface.setForceDark(i);
    }

    public void setForceDarkStrategy(int i) {
        this.mBoundaryInterface.setForceDarkBehavior(i);
    }

    public void setPaymentRequestEnabled(boolean z) {
        this.mBoundaryInterface.setPaymentRequestEnabled(z);
    }
}
