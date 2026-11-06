package io.didomi.ssl;

import android.graphics.Typeface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u0000 92\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b7\u00108R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\tR\u001d\u0010\r\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\tR\u001b\u0010\u0012\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\u0011R\u001b\u0010\u001b\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\u0011R\u001b\u0010\u001c\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u000b\u0010\u0011R\u001b\u0010\u001d\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u000f\u0010\u0011R\u001b\u0010\u001f\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u001e\u0010\u0011R\u001b\u0010!\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b \u0010\u0011R\u001b\u0010$\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\b\u001a\u0004\b#\u0010\u0011R\u001b\u0010(\u001a\u00020%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b\u0007\u0010'R\u001b\u0010+\u001a\u00020)8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u0013\u0010*R\u001b\u0010.\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\b\u001a\u0004\b\u0016\u0010-R\u001d\u00100\u001a\u0004\u0018\u00010\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\b\u001a\u0004\b\u0019\u0010\tR\u001b\u00102\u001a\u00020%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\b\u001a\u0004\b\"\u0010'R\u001d\u00103\u001a\u0004\u0018\u00010\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b&\u0010\tR\u001b\u00104\u001a\u00020)8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\b\u001a\u0004\b/\u0010*R\u001b\u00106\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\b\u001a\u0004\b1\u0010-¨\u0006:"}, d2 = {"Lio/didomi/sdk/w8;", "", "Lio/didomi/sdk/ah;", "a", "Lio/didomi/sdk/ah;", "themeProvider", "Landroid/graphics/Typeface;", "b", "Lkotlin/Lazy;", "()Landroid/graphics/Typeface;", "buttonTypeface", "c", "r", "titleTypeface", "Lio/didomi/sdk/xg;", "d", "j", "()Lio/didomi/sdk/xg;", "primaryButtonTheme", "e", "k", "secondaryButtonTheme", "f", "i", "noneButtonTheme", "g", "h", "linkButtonTheme", "descriptionPrimaryTextTheme", "descriptionSecondaryTextTheme", "n", "titlePrimaryTextTheme", "o", "titleSecondaryTextTheme", "l", "s", "vendorCountButtonTheme", "Lio/didomi/sdk/l$h$c$a;", "m", "()Lio/didomi/sdk/l$h$c$a;", "descriptionAlignment", "", "()I", "descriptionTextColor", "", "()F", "descriptionTextSize", "p", "descriptionTypeface", "q", "titleAlignment", "titleFontFamily", "titleTextColor", "t", "titleTextSize", "<init>", "(Lio/didomi/sdk/ah;)V", "u", "android_release"}, k = 1, mv = {1, 8, 0})
public final class w8 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final ah themeProvider;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Lazy buttonTypeface;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Lazy titleTypeface;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Lazy primaryButtonTheme;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Lazy secondaryButtonTheme;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final Lazy noneButtonTheme;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Lazy linkButtonTheme;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Lazy descriptionPrimaryTextTheme;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Lazy descriptionSecondaryTextTheme;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Lazy titlePrimaryTextTheme;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final Lazy titleSecondaryTextTheme;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final Lazy vendorCountButtonTheme;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final Lazy descriptionAlignment;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final Lazy descriptionTextColor;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final Lazy descriptionTextSize;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final Lazy descriptionTypeface;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final Lazy titleAlignment;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final Lazy titleFontFamily;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private final Lazy titleTextColor;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final Lazy titleTextSize;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/graphics/Typeface;", "a", "()Landroid/graphics/Typeface;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Typeface invoke() {
            String strD = fc.d(w8.this.themeProvider.s().getPreferences().getFontFamily());
            if (strD != null) {
                return w8.this.themeProvider.getResourcesHelper().a(strD);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/l$h$c$a;", "a", "()Lio/didomi/sdk/l$h$c$a;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AppConfiguration.Theme.ContentThemeConfig.a invoke() {
            String descriptionAlignment = w8.this.themeProvider.s().getPreferences().getDescriptionAlignment();
            if (descriptionAlignment == null) {
                descriptionAlignment = w8.this.themeProvider.s().getPreferences().getAlignment();
            }
            return AppConfiguration.Theme.ContentThemeConfig.a.INSTANCE.a(descriptionAlignment);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/xg;", "a", "()Lio/didomi/sdk/xg;"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function0 {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TextTheme invoke() {
            return new TextTheme(null, w8.this.themeProvider.j(), w8.this.g(), 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/xg;", "a", "()Lio/didomi/sdk/xg;"}, k = 3, mv = {1, 8, 0})
    static final class e extends Lambda implements Function0 {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TextTheme invoke() {
            return new TextTheme(null, w8.this.themeProvider.r(), w8.this.g(), 1, null);
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
            String descriptionTextColor = w8.this.themeProvider.s().getPreferences().getDescriptionTextColor();
            if (descriptionTextColor == null) {
                descriptionTextColor = w8.this.themeProvider.s().getPreferences().getTextColor();
            }
            return Integer.valueOf(descriptionTextColor != null ? z.a.b(descriptionTextColor) : w8.this.themeProvider.j());
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
            Integer descriptionTextSize = w8.this.themeProvider.s().getPreferences().getDescriptionTextSize();
            if (descriptionTextSize == null) {
                descriptionTextSize = w8.this.themeProvider.s().getPreferences().getTextSize();
            }
            return Float.valueOf(descriptionTextSize != null ? descriptionTextSize.intValue() : 16.0f);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/graphics/Typeface;", "a", "()Landroid/graphics/Typeface;"}, k = 3, mv = {1, 8, 0})
    static final class h extends Lambda implements Function0 {
        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Typeface invoke() {
            String descriptionFontFamily = w8.this.themeProvider.s().getPreferences().getDescriptionFontFamily();
            if (descriptionFontFamily == null) {
                descriptionFontFamily = w8.this.themeProvider.s().getPreferences().getFontFamily();
            }
            String strD = fc.d(descriptionFontFamily);
            if (strD != null) {
                return w8.this.themeProvider.getResourcesHelper().a(strD);
            }
            return null;
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
            return new TextTheme(null, w8.this.themeProvider.f(), w8.this.a(), 1, null);
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
            return new TextTheme(null, w8.this.themeProvider.j(), w8.this.a(), 1, null);
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
            return new TextTheme(w8.this.themeProvider.c(), w8.this.themeProvider.e(), w8.this.a());
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
            return new TextTheme(w8.this.themeProvider.k(), w8.this.themeProvider.m(), w8.this.a());
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
            String titleAlignment = w8.this.themeProvider.s().getPreferences().getTitleAlignment();
            if (titleAlignment == null) {
                titleAlignment = w8.this.themeProvider.s().getPreferences().getAlignment();
            }
            return AppConfiguration.Theme.ContentThemeConfig.a.INSTANCE.a(titleAlignment);
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
            String titleFontFamily = w8.this.themeProvider.s().getPreferences().getTitleFontFamily();
            if (titleFontFamily == null) {
                titleFontFamily = w8.this.themeProvider.s().getPreferences().getFontFamily();
            }
            String strD = fc.d(titleFontFamily);
            if (strD != null) {
                return w8.this.themeProvider.getResourcesHelper().a(strD);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/xg;", "a", "()Lio/didomi/sdk/xg;"}, k = 3, mv = {1, 8, 0})
    static final class o extends Lambda implements Function0 {
        o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TextTheme invoke() {
            return new TextTheme(null, w8.this.themeProvider.j(), w8.this.r(), 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/xg;", "a", "()Lio/didomi/sdk/xg;"}, k = 3, mv = {1, 8, 0})
    static final class p extends Lambda implements Function0 {
        p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TextTheme invoke() {
            return new TextTheme(null, w8.this.themeProvider.r(), w8.this.r(), 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class q extends Lambda implements Function0 {
        q() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            String titleTextColor = w8.this.themeProvider.s().getPreferences().getTitleTextColor();
            if (titleTextColor == null) {
                titleTextColor = w8.this.themeProvider.s().getPreferences().getTextColor();
            }
            return Integer.valueOf(titleTextColor != null ? z.a.b(titleTextColor) : w8.this.themeProvider.j());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0})
    static final class r extends Lambda implements Function0 {
        r() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            Integer titleTextSize = w8.this.themeProvider.s().getPreferences().getTitleTextSize();
            if (titleTextSize == null) {
                titleTextSize = w8.this.themeProvider.s().getPreferences().getTextSize();
            }
            return Float.valueOf(titleTextSize != null ? titleTextSize.intValue() : 18.0f);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/graphics/Typeface;", "a", "()Landroid/graphics/Typeface;"}, k = 3, mv = {1, 8, 0})
    static final class s extends Lambda implements Function0 {
        s() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Typeface invoke() {
            String titleFontFamily = w8.this.themeProvider.s().getPreferences().getTitleFontFamily();
            if (titleFontFamily == null) {
                titleFontFamily = w8.this.themeProvider.s().getPreferences().getFontFamily();
            }
            String strD = fc.d(titleFontFamily);
            if (strD != null) {
                return w8.this.themeProvider.getResourcesHelper().a(strD);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/xg;", "a", "()Lio/didomi/sdk/xg;"}, k = 3, mv = {1, 8, 0})
    static final class t extends Lambda implements Function0 {
        t() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TextTheme invoke() {
            return new TextTheme(w8.this.themeProvider.o(), w8.this.themeProvider.j(), w8.this.a());
        }
    }

    public w8(ah themeProvider) {
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        this.themeProvider = themeProvider;
        this.buttonTypeface = LazyKt.lazy(new b());
        this.titleTypeface = LazyKt.lazy(new s());
        this.primaryButtonTheme = LazyKt.lazy(new k());
        this.secondaryButtonTheme = LazyKt.lazy(new l());
        this.noneButtonTheme = LazyKt.lazy(new j());
        this.linkButtonTheme = LazyKt.lazy(new i());
        this.descriptionPrimaryTextTheme = LazyKt.lazy(new d());
        this.descriptionSecondaryTextTheme = LazyKt.lazy(new e());
        this.titlePrimaryTextTheme = LazyKt.lazy(new o());
        this.titleSecondaryTextTheme = LazyKt.lazy(new p());
        this.vendorCountButtonTheme = LazyKt.lazy(new t());
        this.descriptionAlignment = LazyKt.lazy(new c());
        this.descriptionTextColor = LazyKt.lazy(new f());
        this.descriptionTextSize = LazyKt.lazy(new g());
        this.descriptionTypeface = LazyKt.lazy(new h());
        this.titleAlignment = LazyKt.lazy(new m());
        this.titleFontFamily = LazyKt.lazy(new n());
        this.titleTextColor = LazyKt.lazy(new q());
        this.titleTextSize = LazyKt.lazy(new r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Typeface r() {
        return (Typeface) this.titleTypeface.getValue();
    }

    public final TextTheme d() {
        return (TextTheme) this.descriptionSecondaryTextTheme.getValue();
    }

    public final int e() {
        return ((Number) this.descriptionTextColor.getValue()).intValue();
    }

    public final float f() {
        return ((Number) this.descriptionTextSize.getValue()).floatValue();
    }

    public final Typeface g() {
        return (Typeface) this.descriptionTypeface.getValue();
    }

    public final TextTheme h() {
        return (TextTheme) this.linkButtonTheme.getValue();
    }

    public final TextTheme i() {
        return (TextTheme) this.noneButtonTheme.getValue();
    }

    public final TextTheme j() {
        return (TextTheme) this.primaryButtonTheme.getValue();
    }

    public final TextTheme k() {
        return (TextTheme) this.secondaryButtonTheme.getValue();
    }

    public final AppConfiguration.Theme.ContentThemeConfig.a l() {
        return (AppConfiguration.Theme.ContentThemeConfig.a) this.titleAlignment.getValue();
    }

    public final Typeface m() {
        return (Typeface) this.titleFontFamily.getValue();
    }

    public final TextTheme n() {
        return (TextTheme) this.titlePrimaryTextTheme.getValue();
    }

    public final TextTheme o() {
        return (TextTheme) this.titleSecondaryTextTheme.getValue();
    }

    public final int p() {
        return ((Number) this.titleTextColor.getValue()).intValue();
    }

    public final float q() {
        return ((Number) this.titleTextSize.getValue()).floatValue();
    }

    public final TextTheme s() {
        return (TextTheme) this.vendorCountButtonTheme.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Typeface a() {
        return (Typeface) this.buttonTypeface.getValue();
    }

    public final AppConfiguration.Theme.ContentThemeConfig.a b() {
        return (AppConfiguration.Theme.ContentThemeConfig.a) this.descriptionAlignment.getValue();
    }

    public final TextTheme c() {
        return (TextTheme) this.descriptionPrimaryTextTheme.getValue();
    }
}
