package io.didomi.ssl;

import android.graphics.Typeface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u0000 32\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0005\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0015R\u001b\u0010\u001d\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001a\u0010\u0015R\u001b\u0010 \u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\n\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u001b\u0010%\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b\u0013\u0010$R\u001b\u0010)\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b\u0017\u0010(R\u001b\u0010+\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b#\u0010\u001fR\u001d\u0010-\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b'\u0010\fR\u001b\u0010.\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b*\u0010$R\u001b\u00100\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000b\u001a\u0004\b,\u0010(¨\u00064"}, d2 = {"Lio/didomi/sdk/e8;", "", "Lio/didomi/sdk/l$h$a;", "format", "Lio/didomi/sdk/xg;", "a", "Lio/didomi/sdk/ah;", "Lio/didomi/sdk/ah;", "themeProvider", "Landroid/graphics/Typeface;", "b", "Lkotlin/Lazy;", "()Landroid/graphics/Typeface;", "buttonTypeface", "", "c", "n", "()Z", "isStickyButtons", "d", "h", "()Lio/didomi/sdk/xg;", "primaryButtonTheme", "e", "i", "secondaryButtonTheme", "f", "g", "noneButtonTheme", "linkButtonTheme", "Lio/didomi/sdk/l$h$c$a;", "()Lio/didomi/sdk/l$h$c$a;", "descriptionAlignment", "descriptionFontFamily", "", "j", "()I", "descriptionTextColor", "", "k", "()F", "descriptionTextSize", "l", "titleAlignment", "m", "titleFontFamily", "titleTextColor", "o", "titleTextSize", "<init>", "(Lio/didomi/sdk/ah;)V", "p", "android_release"}, k = 1, mv = {1, 8, 0})
public final class e8 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final ah themeProvider;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Lazy buttonTypeface;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Lazy isStickyButtons;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Lazy primaryButtonTheme;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Lazy secondaryButtonTheme;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final Lazy noneButtonTheme;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Lazy linkButtonTheme;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Lazy descriptionAlignment;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Lazy descriptionFontFamily;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Lazy descriptionTextColor;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final Lazy descriptionTextSize;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final Lazy titleAlignment;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final Lazy titleFontFamily;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final Lazy titleTextColor;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final Lazy titleTextSize;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AppConfiguration.Theme.a.values().length];
            try {
                iArr[AppConfiguration.Theme.a.PRIMARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppConfiguration.Theme.a.SECONDARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppConfiguration.Theme.a.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/graphics/Typeface;", "a", "()Landroid/graphics/Typeface;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Typeface invoke() {
            String strD = fc.d(e8.this.themeProvider.s().getNotice().getFontFamily());
            if (strD != null) {
                return e8.this.themeProvider.getResourcesHelper().a(strD);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/l$h$c$a;", "a", "()Lio/didomi/sdk/l$h$c$a;"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function0 {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AppConfiguration.Theme.ContentThemeConfig.a invoke() {
            String strB = e8.this.themeProvider.s().getNotice().getDescriptionAlignment();
            if (strB == null) {
                strB = e8.this.themeProvider.s().getNotice().getAlignment();
            }
            return AppConfiguration.Theme.ContentThemeConfig.a.INSTANCE.a(strB);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/graphics/Typeface;", "a", "()Landroid/graphics/Typeface;"}, k = 3, mv = {1, 8, 0})
    static final class e extends Lambda implements Function0 {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Typeface invoke() {
            String strC = e8.this.themeProvider.s().getNotice().getDescriptionFontFamily();
            if (strC == null) {
                strC = e8.this.themeProvider.s().getNotice().getFontFamily();
            }
            String strD = fc.d(strC);
            if (strD != null) {
                return e8.this.themeProvider.getResourcesHelper().a(strD);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class f extends Lambda implements Function0 {
        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            String strD = e8.this.themeProvider.s().getNotice().getDescriptionTextColor();
            if (strD == null) {
                strD = e8.this.themeProvider.s().getNotice().getTextColor();
            }
            return Integer.valueOf(strD != null ? z.a.b(strD) : e8.this.themeProvider.j());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0})
    static final class g extends Lambda implements Function0 {
        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            Integer numE = e8.this.themeProvider.s().getNotice().getDescriptionTextSize();
            if (numE == null) {
                numE = e8.this.themeProvider.s().getNotice().getTextSize();
            }
            return Float.valueOf(numE != null ? numE.intValue() : 16.0f);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class h extends Lambda implements Function0 {
        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(e8.this.themeProvider.s().getNotice().getStickyButtons());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/xg;", "a", "()Lio/didomi/sdk/xg;"}, k = 3, mv = {1, 8, 0})
    static final class i extends Lambda implements Function0 {
        i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TextTheme invoke() {
            return new TextTheme(null, e8.this.themeProvider.f(), e8.this.a(), 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/xg;", "a", "()Lio/didomi/sdk/xg;"}, k = 3, mv = {1, 8, 0})
    static final class j extends Lambda implements Function0 {
        j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TextTheme invoke() {
            return new TextTheme(null, e8.this.themeProvider.j(), e8.this.a(), 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/xg;", "a", "()Lio/didomi/sdk/xg;"}, k = 3, mv = {1, 8, 0})
    static final class k extends Lambda implements Function0 {
        k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TextTheme invoke() {
            return new TextTheme(e8.this.themeProvider.c(), e8.this.themeProvider.e(), e8.this.a());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/xg;", "a", "()Lio/didomi/sdk/xg;"}, k = 3, mv = {1, 8, 0})
    static final class l extends Lambda implements Function0 {
        l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TextTheme invoke() {
            return new TextTheme(e8.this.themeProvider.k(), e8.this.themeProvider.m(), e8.this.a());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/l$h$c$a;", "a", "()Lio/didomi/sdk/l$h$c$a;"}, k = 3, mv = {1, 8, 0})
    static final class m extends Lambda implements Function0 {
        m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AppConfiguration.Theme.ContentThemeConfig.a invoke() {
            String strJ = e8.this.themeProvider.s().getNotice().getTitleAlignment();
            if (strJ == null) {
                strJ = e8.this.themeProvider.s().getNotice().getAlignment();
            }
            return AppConfiguration.Theme.ContentThemeConfig.a.INSTANCE.a(strJ);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/graphics/Typeface;", "a", "()Landroid/graphics/Typeface;"}, k = 3, mv = {1, 8, 0})
    static final class n extends Lambda implements Function0 {
        n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Typeface invoke() {
            String strK = e8.this.themeProvider.s().getNotice().getTitleFontFamily();
            if (strK == null) {
                strK = e8.this.themeProvider.s().getNotice().getFontFamily();
            }
            String strD = fc.d(strK);
            if (strD != null) {
                return e8.this.themeProvider.getResourcesHelper().a(strD);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class o extends Lambda implements Function0 {
        o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            String strL = e8.this.themeProvider.s().getNotice().getTitleTextColor();
            if (strL == null) {
                strL = e8.this.themeProvider.s().getNotice().getTextColor();
            }
            return Integer.valueOf(strL != null ? z.a.b(strL) : e8.this.themeProvider.j());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0})
    static final class p extends Lambda implements Function0 {
        p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            Integer numM = e8.this.themeProvider.s().getNotice().getTitleTextSize();
            if (numM == null) {
                numM = e8.this.themeProvider.s().getNotice().getTextSize();
            }
            return Float.valueOf(numM != null ? numM.intValue() : 24.0f);
        }
    }

    public e8(ah themeProvider) {
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        this.themeProvider = themeProvider;
        this.buttonTypeface = LazyKt.lazy(new c());
        this.isStickyButtons = LazyKt.lazy(new h());
        this.primaryButtonTheme = LazyKt.lazy(new k());
        this.secondaryButtonTheme = LazyKt.lazy(new l());
        this.noneButtonTheme = LazyKt.lazy(new j());
        this.linkButtonTheme = LazyKt.lazy(new i());
        this.descriptionAlignment = LazyKt.lazy(new d());
        this.descriptionFontFamily = LazyKt.lazy(new e());
        this.descriptionTextColor = LazyKt.lazy(new f());
        this.descriptionTextSize = LazyKt.lazy(new g());
        this.titleAlignment = LazyKt.lazy(new m());
        this.titleFontFamily = LazyKt.lazy(new n());
        this.titleTextColor = LazyKt.lazy(new o());
        this.titleTextSize = LazyKt.lazy(new p());
    }

    public final Typeface c() {
        return (Typeface) this.descriptionFontFamily.getValue();
    }

    public final int d() {
        return ((Number) this.descriptionTextColor.getValue()).intValue();
    }

    public final float e() {
        return ((Number) this.descriptionTextSize.getValue()).floatValue();
    }

    public final TextTheme f() {
        return (TextTheme) this.linkButtonTheme.getValue();
    }

    public final TextTheme g() {
        return (TextTheme) this.noneButtonTheme.getValue();
    }

    public final TextTheme h() {
        return (TextTheme) this.primaryButtonTheme.getValue();
    }

    public final TextTheme i() {
        return (TextTheme) this.secondaryButtonTheme.getValue();
    }

    public final AppConfiguration.Theme.ContentThemeConfig.a j() {
        return (AppConfiguration.Theme.ContentThemeConfig.a) this.titleAlignment.getValue();
    }

    public final Typeface k() {
        return (Typeface) this.titleFontFamily.getValue();
    }

    public final int l() {
        return ((Number) this.titleTextColor.getValue()).intValue();
    }

    public final float m() {
        return ((Number) this.titleTextSize.getValue()).floatValue();
    }

    public final boolean n() {
        return ((Boolean) this.isStickyButtons.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Typeface a() {
        return (Typeface) this.buttonTypeface.getValue();
    }

    public final AppConfiguration.Theme.ContentThemeConfig.a b() {
        return (AppConfiguration.Theme.ContentThemeConfig.a) this.descriptionAlignment.getValue();
    }

    public final TextTheme a(AppConfiguration.Theme.a format) {
        Intrinsics.checkNotNullParameter(format, "format");
        int i2 = b.a[format.ordinal()];
        if (i2 == 1) {
            return h();
        }
        if (i2 == 2) {
            return i();
        }
        if (i2 == 3) {
            return g();
        }
        throw new NoWhenBranchMatchedException();
    }
}
