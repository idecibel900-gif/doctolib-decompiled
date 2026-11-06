package com.adjust.sdk;

/* JADX INFO: loaded from: classes3.dex */
public class AdjustThirdPartySharingResult {
    private final String thirdPartySharingSettingsJson;

    public AdjustThirdPartySharingResult(String str) {
        this.thirdPartySharingSettingsJson = str;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof AdjustThirdPartySharingResult) {
            return Util.equalString(this.thirdPartySharingSettingsJson, ((AdjustThirdPartySharingResult) obj).thirdPartySharingSettingsJson);
        }
        return false;
    }

    public String getThirdPartySharingSettingsJson() {
        return this.thirdPartySharingSettingsJson;
    }

    public int hashCode() {
        String str = this.thirdPartySharingSettingsJson;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
