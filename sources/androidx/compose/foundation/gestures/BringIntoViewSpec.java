package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;

/* JADX INFO: loaded from: classes.dex */
public interface BringIntoViewSpec {
    public static final Companion Companion = Companion.$$INSTANCE;

    default AnimationSpec getScrollAnimationSpec() {
        return Companion.getDefaultScrollAnimationSpec();
    }

    default float calculateScrollDistance(float f, float f2, float f3) {
        return Companion.defaultCalculateScrollDistance$foundation_release(f, f2, f3);
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final AnimationSpec DefaultScrollAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        private static final BringIntoViewSpec DefaultBringIntoViewSpec = new BringIntoViewSpec() { // from class: androidx.compose.foundation.gestures.BringIntoViewSpec$Companion$DefaultBringIntoViewSpec$1
        };

        private Companion() {
        }

        public final AnimationSpec getDefaultScrollAnimationSpec() {
            return DefaultScrollAnimationSpec;
        }

        public final BringIntoViewSpec getDefaultBringIntoViewSpec$foundation_release() {
            return DefaultBringIntoViewSpec;
        }

        public final float defaultCalculateScrollDistance$foundation_release(float f, float f2, float f3) {
            float f4 = f2 + f;
            if (f >= 0.0f && f4 <= f3) {
                return 0.0f;
            }
            if (f < 0.0f && f4 > f3) {
                return 0.0f;
            }
            float f5 = f4 - f3;
            return Math.abs(f) < Math.abs(f5) ? f : f5;
        }
    }
}
