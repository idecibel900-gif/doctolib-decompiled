package com.swmansion.enriched.markdown.parser;

import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006#"}, d2 = {"Lcom/swmansion/enriched/markdown/parser/Md4cFlags;", "", "underline", "", "latexMath", "superscript", "subscript", "highlight", "permissiveAutolinks", "hardSoftBreaks", "<init>", "(ZZZZZZZ)V", "getUnderline", "()Z", "getLatexMath", "getSuperscript", "getSubscript", "getHighlight", "getPermissiveAutolinks", "getHardSoftBreaks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "Companion", "react-native-enriched-markdown_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Md4cFlags {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Md4cFlags DEFAULT = new Md4cFlags(false, false, false, false, false, false, false, 127, null);
    private final boolean hardSoftBreaks;
    private final boolean highlight;
    private final boolean latexMath;
    private final boolean permissiveAutolinks;
    private final boolean subscript;
    private final boolean superscript;
    private final boolean underline;

    public Md4cFlags() {
        this(false, false, false, false, false, false, false, 127, null);
    }

    public static /* synthetic */ Md4cFlags copy$default(Md4cFlags md4cFlags, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        if ((i & 1) != 0) {
            z = md4cFlags.underline;
        }
        if ((i & 2) != 0) {
            z2 = md4cFlags.latexMath;
        }
        if ((i & 4) != 0) {
            z3 = md4cFlags.superscript;
        }
        if ((i & 8) != 0) {
            z4 = md4cFlags.subscript;
        }
        if ((i & 16) != 0) {
            z5 = md4cFlags.highlight;
        }
        if ((i & 32) != 0) {
            z6 = md4cFlags.permissiveAutolinks;
        }
        if ((i & 64) != 0) {
            z7 = md4cFlags.hardSoftBreaks;
        }
        boolean z8 = z6;
        boolean z9 = z7;
        boolean z10 = z5;
        boolean z11 = z3;
        return md4cFlags.copy(z, z2, z11, z4, z10, z8, z9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getUnderline() {
        return this.underline;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getLatexMath() {
        return this.latexMath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSuperscript() {
        return this.superscript;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getSubscript() {
        return this.subscript;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getHighlight() {
        return this.highlight;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getPermissiveAutolinks() {
        return this.permissiveAutolinks;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getHardSoftBreaks() {
        return this.hardSoftBreaks;
    }

    public final Md4cFlags copy(boolean underline, boolean latexMath, boolean superscript, boolean subscript, boolean highlight, boolean permissiveAutolinks, boolean hardSoftBreaks) {
        return new Md4cFlags(underline, latexMath, superscript, subscript, highlight, permissiveAutolinks, hardSoftBreaks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Md4cFlags)) {
            return false;
        }
        Md4cFlags md4cFlags = (Md4cFlags) other;
        return this.underline == md4cFlags.underline && this.latexMath == md4cFlags.latexMath && this.superscript == md4cFlags.superscript && this.subscript == md4cFlags.subscript && this.highlight == md4cFlags.highlight && this.permissiveAutolinks == md4cFlags.permissiveAutolinks && this.hardSoftBreaks == md4cFlags.hardSoftBreaks;
    }

    public int hashCode() {
        return (((((((((((Boolean.hashCode(this.underline) * 31) + Boolean.hashCode(this.latexMath)) * 31) + Boolean.hashCode(this.superscript)) * 31) + Boolean.hashCode(this.subscript)) * 31) + Boolean.hashCode(this.highlight)) * 31) + Boolean.hashCode(this.permissiveAutolinks)) * 31) + Boolean.hashCode(this.hardSoftBreaks);
    }

    public String toString() {
        return "Md4cFlags(underline=" + this.underline + ", latexMath=" + this.latexMath + ", superscript=" + this.superscript + ", subscript=" + this.subscript + ", highlight=" + this.highlight + ", permissiveAutolinks=" + this.permissiveAutolinks + ", hardSoftBreaks=" + this.hardSoftBreaks + ")";
    }

    public Md4cFlags(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.underline = z;
        this.latexMath = z2;
        this.superscript = z3;
        this.subscript = z4;
        this.highlight = z5;
        this.permissiveAutolinks = z6;
        this.hardSoftBreaks = z7;
    }

    public /* synthetic */ Md4cFlags(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? true : z6, (i & 64) != 0 ? false : z7);
    }

    public final boolean getUnderline() {
        return this.underline;
    }

    public final boolean getLatexMath() {
        return this.latexMath;
    }

    public final boolean getSuperscript() {
        return this.superscript;
    }

    public final boolean getSubscript() {
        return this.subscript;
    }

    public final boolean getHighlight() {
        return this.highlight;
    }

    public final boolean getPermissiveAutolinks() {
        return this.permissiveAutolinks;
    }

    public final boolean getHardSoftBreaks() {
        return this.hardSoftBreaks;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Md4cFlags getDEFAULT() {
            return Md4cFlags.DEFAULT;
        }
    }
}
