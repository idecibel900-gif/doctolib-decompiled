package com.facebook.react.views.text.internal.span;

import android.text.SpannableStringBuilder;
import com.facebook.common.logging.FLog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SetSpanOperation {
    public static final Companion Companion = new Companion(null);
    private final int end;
    private final int start;
    public final ReactSpan what;

    public SetSpanOperation(int i, int i2, ReactSpan what) {
        Intrinsics.checkNotNullParameter(what, "what");
        this.start = i;
        this.end = i2;
        this.what = what;
    }

    public final void execute(SpannableStringBuilder builder, int i) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (i < 0) {
            throw new IllegalStateException("Check failed.");
        }
        int i2 = this.start == 0 ? 18 : 34;
        int i3 = 255 - i;
        if (i3 < 0) {
            FLog.w("SetSpanOperation", "Text tree size exceeded the limit, styling may become unpredictable");
        }
        builder.setSpan(this.what, this.start, this.end, ((Math.max(i3, 0) << 16) & 16711680) | (i2 & (-16711681)));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
