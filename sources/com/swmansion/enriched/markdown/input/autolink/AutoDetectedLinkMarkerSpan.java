package com.swmansion.enriched.markdown.input.autolink;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoDetectedLinkMarkerSpan extends CharacterStyle {
    private final String url;

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
    }

    public final String getUrl() {
        return this.url;
    }

    public AutoDetectedLinkMarkerSpan(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }
}
