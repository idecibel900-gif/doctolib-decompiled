package androidx.compose.foundation.interaction;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public interface PressInteraction extends Interaction {

    public static final class Press implements PressInteraction {
        private final long pressPosition;

        public /* synthetic */ Press(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        private Press(long j) {
            this.pressPosition = j;
        }

        /* JADX INFO: renamed from: getPressPosition-F1C5BW0, reason: not valid java name */
        public final long m268getPressPositionF1C5BW0() {
            return this.pressPosition;
        }
    }

    public static final class Release implements PressInteraction {
        private final Press press;

        public Release(Press press) {
            this.press = press;
        }

        public final Press getPress() {
            return this.press;
        }
    }

    public static final class Cancel implements PressInteraction {
        private final Press press;

        public Cancel(Press press) {
            this.press = press;
        }

        public final Press getPress() {
            return this.press;
        }
    }
}
