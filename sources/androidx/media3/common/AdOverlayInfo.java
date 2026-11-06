package androidx.media3.common;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class AdOverlayInfo {
    public final int purpose;
    public final String reasonDetail;
    public final View view;

    public static final class Builder {
        private String detailedReason;
        private final int purpose;
        private final View view;

        public Builder(View view, int i) {
            this.view = view;
            this.purpose = i;
        }

        public Builder setDetailedReason(String str) {
            this.detailedReason = str;
            return this;
        }

        public AdOverlayInfo build() {
            return new AdOverlayInfo(this.view, this.purpose, this.detailedReason);
        }
    }

    public AdOverlayInfo(View view, int i, String str) {
        this.view = view;
        this.purpose = i;
        this.reasonDetail = str;
    }
}
