package com.swmansion.enriched.markdown.utils.text.view;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SelectionMenuConfig {
    private final boolean copyAsMarkdown;
    private final String copyAsMarkdownLabel;
    private final boolean copyImageUrl;
    private final String copyImageUrlLabel;
    private final List copyImageUrlPluralTemplates;
    private final String copyImageUrlsLabel;
    private final String copyLabel;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectionMenuConfig)) {
            return false;
        }
        SelectionMenuConfig selectionMenuConfig = (SelectionMenuConfig) obj;
        return this.copyAsMarkdown == selectionMenuConfig.copyAsMarkdown && this.copyImageUrl == selectionMenuConfig.copyImageUrl && Intrinsics.areEqual(this.copyLabel, selectionMenuConfig.copyLabel) && Intrinsics.areEqual(this.copyAsMarkdownLabel, selectionMenuConfig.copyAsMarkdownLabel) && Intrinsics.areEqual(this.copyImageUrlLabel, selectionMenuConfig.copyImageUrlLabel) && Intrinsics.areEqual(this.copyImageUrlsLabel, selectionMenuConfig.copyImageUrlsLabel) && Intrinsics.areEqual(this.copyImageUrlPluralTemplates, selectionMenuConfig.copyImageUrlPluralTemplates);
    }

    public int hashCode() {
        return (((((((((((Boolean.hashCode(this.copyAsMarkdown) * 31) + Boolean.hashCode(this.copyImageUrl)) * 31) + this.copyLabel.hashCode()) * 31) + this.copyAsMarkdownLabel.hashCode()) * 31) + this.copyImageUrlLabel.hashCode()) * 31) + this.copyImageUrlsLabel.hashCode()) * 31) + this.copyImageUrlPluralTemplates.hashCode();
    }

    public String toString() {
        return "SelectionMenuConfig(copyAsMarkdown=" + this.copyAsMarkdown + ", copyImageUrl=" + this.copyImageUrl + ", copyLabel=" + this.copyLabel + ", copyAsMarkdownLabel=" + this.copyAsMarkdownLabel + ", copyImageUrlLabel=" + this.copyImageUrlLabel + ", copyImageUrlsLabel=" + this.copyImageUrlsLabel + ", copyImageUrlPluralTemplates=" + this.copyImageUrlPluralTemplates + ")";
    }

    public SelectionMenuConfig(boolean z, boolean z2, String copyLabel, String copyAsMarkdownLabel, String copyImageUrlLabel, String copyImageUrlsLabel, List copyImageUrlPluralTemplates) {
        Intrinsics.checkNotNullParameter(copyLabel, "copyLabel");
        Intrinsics.checkNotNullParameter(copyAsMarkdownLabel, "copyAsMarkdownLabel");
        Intrinsics.checkNotNullParameter(copyImageUrlLabel, "copyImageUrlLabel");
        Intrinsics.checkNotNullParameter(copyImageUrlsLabel, "copyImageUrlsLabel");
        Intrinsics.checkNotNullParameter(copyImageUrlPluralTemplates, "copyImageUrlPluralTemplates");
        this.copyAsMarkdown = z;
        this.copyImageUrl = z2;
        this.copyLabel = copyLabel;
        this.copyAsMarkdownLabel = copyAsMarkdownLabel;
        this.copyImageUrlLabel = copyImageUrlLabel;
        this.copyImageUrlsLabel = copyImageUrlsLabel;
        this.copyImageUrlPluralTemplates = copyImageUrlPluralTemplates;
    }

    public /* synthetic */ SelectionMenuConfig(boolean z, boolean z2, String str, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final boolean getCopyAsMarkdown() {
        return this.copyAsMarkdown;
    }

    public final boolean getCopyImageUrl() {
        return this.copyImageUrl;
    }

    public final String getCopyLabel() {
        return this.copyLabel;
    }

    public final String getCopyAsMarkdownLabel() {
        return this.copyAsMarkdownLabel;
    }

    public final String getCopyImageUrlLabel() {
        return this.copyImageUrlLabel;
    }

    public final String getCopyImageUrlsLabel() {
        return this.copyImageUrlsLabel;
    }

    public final List getCopyImageUrlPluralTemplates() {
        return this.copyImageUrlPluralTemplates;
    }
}
