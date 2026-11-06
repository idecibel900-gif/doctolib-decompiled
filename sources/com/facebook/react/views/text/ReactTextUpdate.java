package com.facebook.react.views.text;

import android.text.Spannable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactTextUpdate {
    public static final Companion Companion = new Companion(null);
    private final boolean containsImages;
    private final int jsEventCounter;
    private final int justificationMode;
    private final float paddingBottom;
    private final float paddingLeft;
    private final float paddingRight;
    private final float paddingTop;
    private final Spannable text;
    private final int textAlign;
    private final int textBreakStrategy;

    public ReactTextUpdate(Spannable text, int i, boolean z, float f, float f2, float f3, float f4, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.jsEventCounter = i;
        this.containsImages = z;
        this.paddingLeft = f;
        this.paddingTop = f2;
        this.paddingRight = f3;
        this.paddingBottom = f4;
        this.textAlign = i2;
        this.textBreakStrategy = i3;
        this.justificationMode = i4;
    }

    public final Spannable getText() {
        return this.text;
    }

    public final int getJsEventCounter() {
        return this.jsEventCounter;
    }

    public final float getPaddingLeft() {
        return this.paddingLeft;
    }

    public final float getPaddingTop() {
        return this.paddingTop;
    }

    public final float getPaddingRight() {
        return this.paddingRight;
    }

    public final float getPaddingBottom() {
        return this.paddingBottom;
    }

    public final int getTextAlign() {
        return this.textAlign;
    }

    public final int getTextBreakStrategy() {
        return this.textBreakStrategy;
    }

    public final int getJustificationMode() {
        return this.justificationMode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReactTextUpdate(Spannable text, int i, boolean z, int i2, int i3, int i4) {
        this(text, i, z, -1.0f, -1.0f, -1.0f, -1.0f, i2, i3, i4);
        Intrinsics.checkNotNullParameter(text, "text");
    }

    public final boolean containsImages() {
        return this.containsImages;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReactTextUpdate buildReactTextUpdateFromState(Spannable text, int i, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new ReactTextUpdate(text, i, false, i2, i3, i4);
        }
    }
}
