package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class FontFamily {
    private final boolean canLoadSynchronously;
    public static final Companion Companion = new Companion(null);
    private static final SystemFontFamily Default = new DefaultFontFamily();
    private static final GenericFontFamily SansSerif = new GenericFontFamily("sans-serif", "FontFamily.SansSerif");
    private static final GenericFontFamily Serif = new GenericFontFamily("serif", "FontFamily.Serif");
    private static final GenericFontFamily Monospace = new GenericFontFamily("monospace", "FontFamily.Monospace");
    private static final GenericFontFamily Cursive = new GenericFontFamily("cursive", "FontFamily.Cursive");

    public /* synthetic */ FontFamily(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    private FontFamily(boolean z) {
        this.canLoadSynchronously = z;
    }

    public interface Resolver {
        /* JADX INFO: renamed from: resolve-DPcqOEQ, reason: not valid java name */
        State mo2270resolveDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int i, int i2);

        /* JADX INFO: renamed from: resolve-DPcqOEQ$default, reason: not valid java name */
        static /* synthetic */ State m2269resolveDPcqOEQ$default(Resolver resolver, FontFamily fontFamily, FontWeight fontWeight, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolve-DPcqOEQ");
            }
            if ((i3 & 1) != 0) {
                fontFamily = null;
            }
            if ((i3 & 2) != 0) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            if ((i3 & 4) != 0) {
                i = FontStyle.Companion.m2289getNormal_LCdwA();
            }
            if ((i3 & 8) != 0) {
                i2 = FontSynthesis.Companion.m2299getAllGVVA2EU();
            }
            return resolver.mo2270resolveDPcqOEQ(fontFamily, fontWeight, i, i2);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SystemFontFamily getDefault() {
            return FontFamily.Default;
        }

        public final GenericFontFamily getSansSerif() {
            return FontFamily.SansSerif;
        }

        public final GenericFontFamily getSerif() {
            return FontFamily.Serif;
        }

        public final GenericFontFamily getMonospace() {
            return FontFamily.Monospace;
        }

        public final GenericFontFamily getCursive() {
            return FontFamily.Cursive;
        }
    }
}
