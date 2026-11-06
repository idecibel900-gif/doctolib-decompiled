package com.swmansion.enriched.markdown.input.styles;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StyleMergingConfig {
    private final Set blockingStyles;
    private final Set conflictingStyles;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StyleMergingConfig)) {
            return false;
        }
        StyleMergingConfig styleMergingConfig = (StyleMergingConfig) obj;
        return Intrinsics.areEqual(this.conflictingStyles, styleMergingConfig.conflictingStyles) && Intrinsics.areEqual(this.blockingStyles, styleMergingConfig.blockingStyles);
    }

    public int hashCode() {
        return (this.conflictingStyles.hashCode() * 31) + this.blockingStyles.hashCode();
    }

    public String toString() {
        return "StyleMergingConfig(conflictingStyles=" + this.conflictingStyles + ", blockingStyles=" + this.blockingStyles + ")";
    }

    public StyleMergingConfig(Set conflictingStyles, Set blockingStyles) {
        Intrinsics.checkNotNullParameter(conflictingStyles, "conflictingStyles");
        Intrinsics.checkNotNullParameter(blockingStyles, "blockingStyles");
        this.conflictingStyles = conflictingStyles;
        this.blockingStyles = blockingStyles;
    }

    public /* synthetic */ StyleMergingConfig(Set set, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? SetsKt.emptySet() : set2);
    }

    public final Set getConflictingStyles() {
        return this.conflictingStyles;
    }

    public final Set getBlockingStyles() {
        return this.blockingStyles;
    }
}
