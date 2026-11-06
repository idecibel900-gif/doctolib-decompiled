package com.swmansion.enriched.markdown.input.toolbar;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FormatMenuConfig {
    private final boolean bold;
    private final String boldLabel;
    private final boolean italic;
    private final String italicLabel;
    private final boolean link;
    private final String linkLabel;
    private final boolean spoiler;
    private final String spoilerLabel;
    private final boolean strikethrough;
    private final String strikethroughLabel;
    private final boolean underline;
    private final String underlineLabel;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormatMenuConfig)) {
            return false;
        }
        FormatMenuConfig formatMenuConfig = (FormatMenuConfig) obj;
        return this.bold == formatMenuConfig.bold && Intrinsics.areEqual(this.boldLabel, formatMenuConfig.boldLabel) && this.italic == formatMenuConfig.italic && Intrinsics.areEqual(this.italicLabel, formatMenuConfig.italicLabel) && this.underline == formatMenuConfig.underline && Intrinsics.areEqual(this.underlineLabel, formatMenuConfig.underlineLabel) && this.strikethrough == formatMenuConfig.strikethrough && Intrinsics.areEqual(this.strikethroughLabel, formatMenuConfig.strikethroughLabel) && this.spoiler == formatMenuConfig.spoiler && Intrinsics.areEqual(this.spoilerLabel, formatMenuConfig.spoilerLabel) && this.link == formatMenuConfig.link && Intrinsics.areEqual(this.linkLabel, formatMenuConfig.linkLabel);
    }

    public int hashCode() {
        return (((((((((((((((((((((Boolean.hashCode(this.bold) * 31) + this.boldLabel.hashCode()) * 31) + Boolean.hashCode(this.italic)) * 31) + this.italicLabel.hashCode()) * 31) + Boolean.hashCode(this.underline)) * 31) + this.underlineLabel.hashCode()) * 31) + Boolean.hashCode(this.strikethrough)) * 31) + this.strikethroughLabel.hashCode()) * 31) + Boolean.hashCode(this.spoiler)) * 31) + this.spoilerLabel.hashCode()) * 31) + Boolean.hashCode(this.link)) * 31) + this.linkLabel.hashCode();
    }

    public String toString() {
        return "FormatMenuConfig(bold=" + this.bold + ", boldLabel=" + this.boldLabel + ", italic=" + this.italic + ", italicLabel=" + this.italicLabel + ", underline=" + this.underline + ", underlineLabel=" + this.underlineLabel + ", strikethrough=" + this.strikethrough + ", strikethroughLabel=" + this.strikethroughLabel + ", spoiler=" + this.spoiler + ", spoilerLabel=" + this.spoilerLabel + ", link=" + this.link + ", linkLabel=" + this.linkLabel + ")";
    }

    public FormatMenuConfig(boolean z, String boldLabel, boolean z2, String italicLabel, boolean z3, String underlineLabel, boolean z4, String strikethroughLabel, boolean z5, String spoilerLabel, boolean z6, String linkLabel) {
        Intrinsics.checkNotNullParameter(boldLabel, "boldLabel");
        Intrinsics.checkNotNullParameter(italicLabel, "italicLabel");
        Intrinsics.checkNotNullParameter(underlineLabel, "underlineLabel");
        Intrinsics.checkNotNullParameter(strikethroughLabel, "strikethroughLabel");
        Intrinsics.checkNotNullParameter(spoilerLabel, "spoilerLabel");
        Intrinsics.checkNotNullParameter(linkLabel, "linkLabel");
        this.bold = z;
        this.boldLabel = boldLabel;
        this.italic = z2;
        this.italicLabel = italicLabel;
        this.underline = z3;
        this.underlineLabel = underlineLabel;
        this.strikethrough = z4;
        this.strikethroughLabel = strikethroughLabel;
        this.spoiler = z5;
        this.spoilerLabel = spoilerLabel;
        this.link = z6;
        this.linkLabel = linkLabel;
    }

    public /* synthetic */ FormatMenuConfig(boolean z, String str, boolean z2, String str2, boolean z3, String str3, boolean z4, String str4, boolean z5, String str5, boolean z6, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? true : z3, (i & 32) != 0 ? "" : str3, (i & 64) != 0 ? true : z4, (i & 128) != 0 ? "" : str4, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? true : z5, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? "" : str5, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) == 0 ? z6 : true, (i & 2048) != 0 ? "" : str6);
    }

    public final boolean getBold() {
        return this.bold;
    }

    public final String getBoldLabel() {
        return this.boldLabel;
    }

    public final boolean getItalic() {
        return this.italic;
    }

    public final String getItalicLabel() {
        return this.italicLabel;
    }

    public final boolean getUnderline() {
        return this.underline;
    }

    public final String getUnderlineLabel() {
        return this.underlineLabel;
    }

    public final boolean getStrikethrough() {
        return this.strikethrough;
    }

    public final String getStrikethroughLabel() {
        return this.strikethroughLabel;
    }

    public final boolean getSpoiler() {
        return this.spoiler;
    }

    public final String getSpoilerLabel() {
        return this.spoilerLabel;
    }

    public final boolean getLink() {
        return this.link;
    }

    public final String getLinkLabel() {
        return this.linkLabel;
    }
}
