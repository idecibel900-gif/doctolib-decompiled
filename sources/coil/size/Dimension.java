package coil.size;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Dimension {
    public /* synthetic */ Dimension(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Dimension() {
    }

    public static final class Pixels extends Dimension {
        public final int px;

        public Pixels(int i) {
            super(null);
            this.px = i;
            if (i <= 0) {
                throw new IllegalArgumentException("px must be > 0.");
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Pixels) && this.px == ((Pixels) obj).px;
        }

        public int hashCode() {
            return this.px;
        }

        public String toString() {
            return String.valueOf(this.px);
        }
    }

    public static final class Undefined extends Dimension {
        public static final Undefined INSTANCE = new Undefined();

        private Undefined() {
            super(null);
        }

        public String toString() {
            return "Dimension.Undefined";
        }
    }
}
