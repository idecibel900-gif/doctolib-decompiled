package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class ColorFilter {
    public static final Companion Companion = new Companion(null);
    private final android.graphics.ColorFilter nativeColorFilter;

    public ColorFilter(android.graphics.ColorFilter colorFilter) {
        this.nativeColorFilter = colorFilter;
    }

    public final android.graphics.ColorFilter getNativeColorFilter$ui_graphics_release() {
        return this.nativeColorFilter;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: tint-xETnrds$default, reason: not valid java name */
        public static /* synthetic */ ColorFilter m1388tintxETnrds$default(Companion companion, long j, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = BlendMode.Companion.m1341getSrcIn0nO6VwU();
            }
            return companion.m1389tintxETnrds(j, i);
        }

        /* JADX INFO: renamed from: tint-xETnrds, reason: not valid java name */
        public final ColorFilter m1389tintxETnrds(long j, int i) {
            return new BlendModeColorFilter(j, i, (DefaultConstructorMarker) null);
        }
    }
}
