package com.swmansion.enriched.markdown.input.toolbar;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class InputSelectionMenuConfig {
    private final boolean copyAsMarkdown;
    private final String copyAsMarkdownLabel;
    private final boolean format;
    private final String formatLabel;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputSelectionMenuConfig)) {
            return false;
        }
        InputSelectionMenuConfig inputSelectionMenuConfig = (InputSelectionMenuConfig) obj;
        return this.format == inputSelectionMenuConfig.format && Intrinsics.areEqual(this.formatLabel, inputSelectionMenuConfig.formatLabel) && this.copyAsMarkdown == inputSelectionMenuConfig.copyAsMarkdown && Intrinsics.areEqual(this.copyAsMarkdownLabel, inputSelectionMenuConfig.copyAsMarkdownLabel);
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.format) * 31) + this.formatLabel.hashCode()) * 31) + Boolean.hashCode(this.copyAsMarkdown)) * 31) + this.copyAsMarkdownLabel.hashCode();
    }

    public String toString() {
        return "InputSelectionMenuConfig(format=" + this.format + ", formatLabel=" + this.formatLabel + ", copyAsMarkdown=" + this.copyAsMarkdown + ", copyAsMarkdownLabel=" + this.copyAsMarkdownLabel + ")";
    }

    public InputSelectionMenuConfig(boolean z, String formatLabel, boolean z2, String copyAsMarkdownLabel) {
        Intrinsics.checkNotNullParameter(formatLabel, "formatLabel");
        Intrinsics.checkNotNullParameter(copyAsMarkdownLabel, "copyAsMarkdownLabel");
        this.format = z;
        this.formatLabel = formatLabel;
        this.copyAsMarkdown = z2;
        this.copyAsMarkdownLabel = copyAsMarkdownLabel;
    }

    public /* synthetic */ InputSelectionMenuConfig(boolean z, String str, boolean z2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? "" : str2);
    }

    public final boolean getFormat() {
        return this.format;
    }

    public final String getFormatLabel() {
        return this.formatLabel;
    }

    public final boolean getCopyAsMarkdown() {
        return this.copyAsMarkdown;
    }

    public final String getCopyAsMarkdownLabel() {
        return this.copyAsMarkdownLabel;
    }
}
