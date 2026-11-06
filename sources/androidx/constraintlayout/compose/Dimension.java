package androidx.constraintlayout.compose;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public interface Dimension {
    public static final Companion Companion = Companion.$$INSTANCE;

    public interface Coercible extends Dimension {
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX INFO: renamed from: value-0680j_4, reason: not valid java name */
        public final Dimension m2689value0680j_4(float f) {
            return new DimensionDescription(f, (DefaultConstructorMarker) null);
        }

        public final Coercible getPreferredWrapContent() {
            return new DimensionDescription("preferWrap");
        }

        public final Dimension getWrapContent() {
            return new DimensionDescription("wrap");
        }

        public final Coercible getFillToConstraints() {
            return new DimensionDescription("spread");
        }
    }
}
