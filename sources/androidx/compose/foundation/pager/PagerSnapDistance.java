package androidx.compose.foundation.pager;

import com.amazon.a.a.o.c.a.b;

/* JADX INFO: loaded from: classes.dex */
public interface PagerSnapDistance {
    public static final Companion Companion = Companion.$$INSTANCE;

    int calculateTargetPage(int i, int i2, float f, int i3, int i4);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final PagerSnapDistance atMost(int i) {
            if (i < 0) {
                throw new IllegalArgumentException(("pages should be greater than or equal to 0. You have used " + i + b.a).toString());
            }
            return new PagerSnapDistanceMaxPages(i);
        }
    }
}
