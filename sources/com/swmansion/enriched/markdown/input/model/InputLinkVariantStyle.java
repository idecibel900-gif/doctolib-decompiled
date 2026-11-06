package com.swmansion.enriched.markdown.input.model;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
public final class InputLinkVariantStyle {
    private final int backgroundColor;
    private final int color;
    private final Regex compiledRegex;
    private final String pattern;
    private final boolean underline;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputLinkVariantStyle)) {
            return false;
        }
        InputLinkVariantStyle inputLinkVariantStyle = (InputLinkVariantStyle) obj;
        return Intrinsics.areEqual(this.pattern, inputLinkVariantStyle.pattern) && this.color == inputLinkVariantStyle.color && this.underline == inputLinkVariantStyle.underline && this.backgroundColor == inputLinkVariantStyle.backgroundColor;
    }

    public int hashCode() {
        return (((((this.pattern.hashCode() * 31) + Integer.hashCode(this.color)) * 31) + Boolean.hashCode(this.underline)) * 31) + Integer.hashCode(this.backgroundColor);
    }

    public String toString() {
        return "InputLinkVariantStyle(pattern=" + this.pattern + ", color=" + this.color + ", underline=" + this.underline + ", backgroundColor=" + this.backgroundColor + ")";
    }

    public InputLinkVariantStyle(String pattern, int i, boolean z, int i2) {
        Regex regex;
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        this.pattern = pattern;
        this.color = i;
        this.underline = z;
        this.backgroundColor = i2;
        try {
            regex = new Regex(pattern);
        } catch (Exception unused) {
            regex = null;
        }
        this.compiledRegex = regex;
    }

    public final int getColor() {
        return this.color;
    }

    public final boolean getUnderline() {
        return this.underline;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Regex getCompiledRegex() {
        return this.compiledRegex;
    }
}
