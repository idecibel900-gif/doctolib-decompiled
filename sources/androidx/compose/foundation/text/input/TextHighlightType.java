package androidx.compose.foundation.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class TextHighlightType {
    public static final Companion Companion = new Companion(null);
    private static final int HandwritingSelectPreview = m562constructorimpl(0);
    private static final int HandwritingDeletePreview = m562constructorimpl(1);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m562constructorimpl(int i) {
        return i;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getHandwritingSelectPreview-s-xJuwY, reason: not valid java name */
        public final int m564getHandwritingSelectPreviewsxJuwY() {
            return TextHighlightType.HandwritingSelectPreview;
        }

        /* JADX INFO: renamed from: getHandwritingDeletePreview-s-xJuwY, reason: not valid java name */
        public final int m563getHandwritingDeletePreviewsxJuwY() {
            return TextHighlightType.HandwritingDeletePreview;
        }
    }
}
