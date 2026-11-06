package com.swmansion.enriched.markdown.input.editing;

import android.text.Spannable;
import com.swmansion.enriched.markdown.input.autolink.AutoLinkDetector;
import com.swmansion.enriched.markdown.input.formatting.FormattingStore;
import com.swmansion.enriched.markdown.input.model.FormattingRange;
import com.swmansion.enriched.markdown.input.model.StyleType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class LinkCoordinator {
    private final AutoLinkDetector autoLinkDetector;
    private final FormattingStore formattingStore;

    public LinkCoordinator(FormattingStore formattingStore, AutoLinkDetector autoLinkDetector) {
        Intrinsics.checkNotNullParameter(formattingStore, "formattingStore");
        Intrinsics.checkNotNullParameter(autoLinkDetector, "autoLinkDetector");
        this.formattingStore = formattingStore;
        this.autoLinkDetector = autoLinkDetector;
    }

    public final String sanitizeUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return StringsKt.replace$default(StringsKt.replace$default(url, "(", "%28", false, 4, (Object) null), ")", "%29", false, 4, (Object) null);
    }

    public final void setLinkForRange(String url, int i, int i2, Spannable spannable) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (i == i2) {
            return;
        }
        if (spannable != null) {
            this.autoLinkDetector.clearAutoLinkInRange(spannable, i, i2);
        }
        this.formattingStore.addRange(new FormattingRange(StyleType.LINK, i, i2, url));
    }

    public final void addLink(String url, int i, int i2, Spannable spannable) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (i >= i2) {
            return;
        }
        if (spannable != null) {
            this.autoLinkDetector.clearAutoLinkInRange(spannable, i, i2);
        }
        this.formattingStore.addRange(new FormattingRange(StyleType.LINK, i, i2, sanitizeUrl(url)));
    }

    public final void addLinkDirect(String url, int i, int i2) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (i >= i2) {
            return;
        }
        this.formattingStore.addRange(new FormattingRange(StyleType.LINK, i, i2, url));
    }

    public final boolean removeLink(int i) {
        FormattingRange formattingRangeRangeOfType = this.formattingStore.rangeOfType(StyleType.LINK, i);
        if (formattingRangeRangeOfType == null) {
            return false;
        }
        this.formattingStore.removeRange(formattingRangeRangeOfType);
        return true;
    }

    public final FormattingRange linkRangeForDeletion(int i) {
        if (i <= 0) {
            return null;
        }
        return this.formattingStore.rangeOfType(StyleType.LINK, i - 1);
    }
}
