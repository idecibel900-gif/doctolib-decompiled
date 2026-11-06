package com.revenuecat.purchases.ui.revenuecatui.components.carousel;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/carousel/ProgrammaticPageTrackingFlag;", "", "()V", "shouldSkipNextPageChange", "", "clear", "", "consumeShouldSkipPageChange", "markProgrammaticScrollStarted", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProgrammaticPageTrackingFlag {
    private boolean shouldSkipNextPageChange;

    public final void markProgrammaticScrollStarted() {
        this.shouldSkipNextPageChange = true;
    }

    public final boolean consumeShouldSkipPageChange() {
        boolean z = this.shouldSkipNextPageChange;
        this.shouldSkipNextPageChange = false;
        return z;
    }

    public final void clear() {
        this.shouldSkipNextPageChange = false;
    }
}
