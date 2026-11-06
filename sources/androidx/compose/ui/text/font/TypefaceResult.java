package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public interface TypefaceResult extends State {
    boolean getCacheable();

    public static final class Immutable implements TypefaceResult {
        private final boolean cacheable;
        private final Object value;

        public Immutable(Object obj, boolean z) {
            this.value = obj;
            this.cacheable = z;
        }

        public /* synthetic */ Immutable(Object obj, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? true : z);
        }

        @Override // androidx.compose.runtime.State
        public Object getValue() {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.TypefaceResult
        public boolean getCacheable() {
            return this.cacheable;
        }
    }

    public static final class Async implements TypefaceResult, State {
        private final AsyncFontListLoader current;

        @Override // androidx.compose.runtime.State
        public Object getValue() {
            return this.current.getValue();
        }

        public Async(AsyncFontListLoader asyncFontListLoader) {
            this.current = asyncFontListLoader;
        }

        @Override // androidx.compose.ui.text.font.TypefaceResult
        public boolean getCacheable() {
            return this.current.getCacheable$ui_text_release();
        }
    }
}
