package com.swmansion.enriched.markdown.renderer;

import com.swmansion.enriched.markdown.styles.StyleConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class RendererConfig {
    private final StyleConfig style;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RendererConfig) && Intrinsics.areEqual(this.style, ((RendererConfig) obj).style);
    }

    public int hashCode() {
        return this.style.hashCode();
    }

    public String toString() {
        return "RendererConfig(style=" + this.style + ")";
    }

    public RendererConfig(StyleConfig style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.style = style;
    }

    public final StyleConfig getStyle() {
        return this.style;
    }
}
