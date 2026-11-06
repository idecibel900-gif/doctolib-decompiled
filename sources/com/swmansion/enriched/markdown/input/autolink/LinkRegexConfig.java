package com.swmansion.enriched.markdown.input.autolink;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class LinkRegexConfig {
    private final boolean caseInsensitive;
    private final boolean dotAll;
    private final boolean isDefault;
    private final boolean isDisabled;
    private final String pattern;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkRegexConfig)) {
            return false;
        }
        LinkRegexConfig linkRegexConfig = (LinkRegexConfig) obj;
        return Intrinsics.areEqual(this.pattern, linkRegexConfig.pattern) && this.caseInsensitive == linkRegexConfig.caseInsensitive && this.dotAll == linkRegexConfig.dotAll && this.isDisabled == linkRegexConfig.isDisabled && this.isDefault == linkRegexConfig.isDefault;
    }

    public int hashCode() {
        return (((((((this.pattern.hashCode() * 31) + Boolean.hashCode(this.caseInsensitive)) * 31) + Boolean.hashCode(this.dotAll)) * 31) + Boolean.hashCode(this.isDisabled)) * 31) + Boolean.hashCode(this.isDefault);
    }

    public String toString() {
        return "LinkRegexConfig(pattern=" + this.pattern + ", caseInsensitive=" + this.caseInsensitive + ", dotAll=" + this.dotAll + ", isDisabled=" + this.isDisabled + ", isDefault=" + this.isDefault + ")";
    }

    public LinkRegexConfig(String pattern, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        this.pattern = pattern;
        this.caseInsensitive = z;
        this.dotAll = z2;
        this.isDisabled = z3;
        this.isDefault = z4;
    }

    public final String getPattern() {
        return this.pattern;
    }

    public final boolean getCaseInsensitive() {
        return this.caseInsensitive;
    }

    public final boolean getDotAll() {
        return this.dotAll;
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }
}
