package io.didomi.ssl;

import androidx.core.graphics.ColorUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 H2\u00020\u0001:\u0001\u0007B\u0019\b\u0007\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\bF\u0010GJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u001a\u0010\f\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0012\u001a\u00020\r8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u000e\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0018R\u001b\u0010\u0005\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b\u0007\u0010\u0018R\u001b\u0010#\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0018R\u001b\u0010&\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000f\u001a\u0004\b%\u0010\u0018R\u001b\u0010(\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000f\u001a\u0004\b'\u0010\u0018R\u001b\u0010+\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000f\u001a\u0004\b*\u0010\u0018R\u001b\u0010,\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b \u0010\u0018R\u001b\u0010.\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u000f\u001a\u0004\b\u001d\u0010\u0018R\u001b\u00100\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000f\u001a\u0004\b\u0014\u0010/R\u001b\u00102\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u000f\u001a\u0004\b\u001a\u0010\u0018R\u001b\u00103\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b)\u0010/R\u001b\u00104\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b-\u0010\u0018R\u001b\u00108\u001a\u0002058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000f\u001a\u0004\b6\u00107R\u001b\u0010:\u001a\u0002058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b9\u00107R\u001b\u0010<\u001a\u0002058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u000f\u001a\u0004\b;\u00107R\u001b\u0010?\u001a\u00020=8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u000f\u001a\u0004\b!\u0010>R\u001b\u0010B\u001a\u00020@8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u000f\u001a\u0004\b$\u0010AR\u0011\u0010C\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b1\u0010/¨\u0006I"}, d2 = {"Lio/didomi/sdk/ah;", "", "Lio/didomi/sdk/l$h$b$a;", "buttonTheme", "", "backgroundColor", "Landroid/graphics/drawable/GradientDrawable;", "a", "Lio/didomi/sdk/ib;", "Lio/didomi/sdk/ib;", "n", "()Lio/didomi/sdk/ib;", "resourcesHelper", "Lio/didomi/sdk/l$h;", "b", "Lkotlin/Lazy;", "s", "()Lio/didomi/sdk/l$h;", "theme", "Lio/didomi/sdk/l$h$b;", "c", "()Lio/didomi/sdk/l$h$b;", "buttonsThemeConfig", "d", "()I", "highlightBackgroundColor", "e", "l", "regularBackgroundColor", "f", "p", "secondaryBackgroundColor", "g", "h", "q", "secondaryDividerColor", "i", "getThemeColor", "themeColor", "j", "primaryTextColor", "k", "r", "secondaryTextColor", "logoColor", "m", "linkColor", "()Landroid/graphics/drawable/GradientDrawable;", "highlightBackground", "o", "highlightTextColor", "regularBackground", "regularTextColor", "", "t", "()Z", "isDarkTheme", "u", "isFullscreen", "v", "isLinkColorSet", "Lio/didomi/sdk/e8;", "()Lio/didomi/sdk/e8;", "notice", "Lio/didomi/sdk/w8;", "()Lio/didomi/sdk/w8;", "preferences", "secondaryBackground", "Lio/didomi/sdk/e0;", "configurationRepository", "<init>", "(Lio/didomi/sdk/e0;Lio/didomi/sdk/ib;)V", "w", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ah {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final ib resourcesHelper;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Lazy theme;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Lazy buttonsThemeConfig;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Lazy highlightBackgroundColor;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Lazy regularBackgroundColor;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final Lazy secondaryBackgroundColor;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Lazy backgroundColor;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Lazy secondaryDividerColor;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Lazy themeColor;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Lazy primaryTextColor;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final Lazy secondaryTextColor;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final Lazy logoColor;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final Lazy linkColor;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final Lazy highlightBackground;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final Lazy highlightTextColor;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final Lazy regularBackground;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final Lazy regularTextColor;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final Lazy isDarkTheme;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private final Lazy isFullscreen;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final Lazy isLinkColorSet;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private final Lazy notice;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private final Lazy preferences;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            z zVar = z.a;
            String strA = ah.this.s().getBackgroundColor();
            if (StringsKt.isBlank(strA)) {
                strA = "#FFFFFF";
            }
            return Integer.valueOf(zVar.b(strA));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/l$h$b;", "a", "()Lio/didomi/sdk/l$h$b;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AppConfiguration.Theme.ButtonsThemeConfig invoke() {
            return ah.this.s().getButtonsThemeConfig();
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.ah$d, reason: from Kotlin metadata */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/graphics/drawable/GradientDrawable;", "a", "()Landroid/graphics/drawable/GradientDrawable;"}, k = 3, mv = {1, 8, 0})
    static final class GradientDrawable extends Lambda implements Function0 {
        GradientDrawable() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final android.graphics.drawable.GradientDrawable invoke() {
            ah ahVar = ah.this;
            return ahVar.a(ahVar.b().getHighlight(), ah.this.d());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class e extends Lambda implements Function0 {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            z zVar = z.a;
            String strC = ah.this.b().getHighlight().c();
            if (strC == null) {
                strC = ah.this.s().getColor();
            }
            return Integer.valueOf(zVar.b(strC));
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
            AppConfiguration.Theme.ButtonsThemeConfig.ButtonTheme aVarA = ah.this.b().getHighlight();
            String strA = aVarA.getBackgroundColor();
            String strB = aVarA.getTextColor();
            if (strB == null) {
                strB = strA != null ? z.a.a(strA) : io.didomi.ssl.m.a(ah.this.s());
            }
            return Integer.valueOf(z.a.b(strB));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class g extends Lambda implements Function0 {
        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(ah.this.j() == -1);
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
            return Boolean.valueOf(ah.this.s().getFullscreen() || ah.this.h().n());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class i extends Lambda implements Function0 {
        i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(!StringsKt.isBlank(ah.this.s().getLinkColor()));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class j extends Lambda implements Function0 {
        j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(z.a.b(ah.this.s().getLinkColor()));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class k extends Lambda implements Function0 {
        k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            int iB = z.a.b("#265973");
            if (ColorUtils.calculateContrast(iB, ah.this.a()) <= 1.5d) {
                iB = ah.this.j();
            }
            return Integer.valueOf(iB);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/e8;", "a", "()Lio/didomi/sdk/e8;"}, k = 3, mv = {1, 8, 0})
    static final class l extends Lambda implements Function0 {
        l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e8 invoke() {
            return new e8(ah.this);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/w8;", "a", "()Lio/didomi/sdk/w8;"}, k = 3, mv = {1, 8, 0})
    static final class m extends Lambda implements Function0 {
        m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final w8 invoke() {
            return new w8(ah.this);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class n extends Lambda implements Function0 {
        n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            z zVar = z.a;
            String strA = ah.this.s().getBackgroundColor();
            if (StringsKt.isBlank(strA)) {
                strA = "#FFFFFF";
            }
            return Integer.valueOf(zVar.b(zVar.a(strA)));
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.ah$o, reason: from Kotlin metadata and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/graphics/drawable/GradientDrawable;", "a", "()Landroid/graphics/drawable/GradientDrawable;"}, k = 3, mv = {1, 8, 0})
    static final class C1115o extends Lambda implements Function0 {
        C1115o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final android.graphics.drawable.GradientDrawable invoke() {
            ah ahVar = ah.this;
            return ahVar.a(ahVar.b().getRegular(), ah.this.l());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class p extends Lambda implements Function0 {
        p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            z zVar = z.a;
            String strC = ah.this.b().getRegular().c();
            if (strC == null) {
                strC = "#F0F0F0";
            }
            return Integer.valueOf(zVar.b(strC));
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
            AppConfiguration.Theme.ButtonsThemeConfig.ButtonTheme aVarB = ah.this.b().getRegular();
            String strA = aVarB.getBackgroundColor();
            String strB = aVarB.getTextColor();
            if (strB == null) {
                strB = strA != null ? z.a.a(strA) : "#000000";
            }
            return Integer.valueOf(z.a.b(strB));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class r extends Lambda implements Function0 {
        r() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(ColorUtils.setAlphaComponent(ah.this.j(), 10));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class s extends Lambda implements Function0 {
        s() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(ColorUtils.setAlphaComponent(ah.this.j(), 32));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class t extends Lambda implements Function0 {
        t() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(ColorUtils.setAlphaComponent(ah.this.j(), 117));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/l$h;", "a", "()Lio/didomi/sdk/l$h;"}, k = 3, mv = {1, 8, 0})
    static final class u extends Lambda implements Function0 {
        final /* synthetic */ e0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(e0 e0Var) {
            super(0);
            this.a = e0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AppConfiguration.Theme invoke() {
            return this.a.b().getTheme();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class v extends Lambda implements Function0 {
        v() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            z zVar = z.a;
            String strC = ah.this.s().getColor();
            if (StringsKt.isBlank(strC)) {
                strC = "#999999";
            }
            return Integer.valueOf(zVar.b(strC));
        }
    }

    public ah(e0 configurationRepository, ib resourcesHelper) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(resourcesHelper, "resourcesHelper");
        this.resourcesHelper = resourcesHelper;
        this.theme = LazyKt.lazy(new u(configurationRepository));
        this.buttonsThemeConfig = LazyKt.lazy(new c());
        this.highlightBackgroundColor = LazyKt.lazy(new e());
        this.regularBackgroundColor = LazyKt.lazy(new p());
        this.secondaryBackgroundColor = LazyKt.lazy(new r());
        this.backgroundColor = LazyKt.lazy(new b());
        this.secondaryDividerColor = LazyKt.lazy(new s());
        this.themeColor = LazyKt.lazy(new v());
        this.primaryTextColor = LazyKt.lazy(new n());
        this.secondaryTextColor = LazyKt.lazy(new t());
        this.logoColor = LazyKt.lazy(new k());
        this.linkColor = LazyKt.lazy(new j());
        this.highlightBackground = LazyKt.lazy(new GradientDrawable());
        this.highlightTextColor = LazyKt.lazy(new f());
        this.regularBackground = LazyKt.lazy(new C1115o());
        this.regularTextColor = LazyKt.lazy(new q());
        this.isDarkTheme = LazyKt.lazy(new g());
        this.isFullscreen = LazyKt.lazy(new h());
        this.isLinkColorSet = LazyKt.lazy(new i());
        this.notice = LazyKt.lazy(new l());
        this.preferences = LazyKt.lazy(new m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int d() {
        return ((Number) this.highlightBackgroundColor.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int l() {
        return ((Number) this.regularBackgroundColor.getValue()).intValue();
    }

    private final int p() {
        return ((Number) this.secondaryBackgroundColor.getValue()).intValue();
    }

    public final int e() {
        return ((Number) this.highlightTextColor.getValue()).intValue();
    }

    public final int f() {
        return ((Number) this.linkColor.getValue()).intValue();
    }

    public final int g() {
        return ((Number) this.logoColor.getValue()).intValue();
    }

    public final e8 h() {
        return (e8) this.notice.getValue();
    }

    public final w8 i() {
        return (w8) this.preferences.getValue();
    }

    public final int j() {
        return ((Number) this.primaryTextColor.getValue()).intValue();
    }

    public final android.graphics.drawable.GradientDrawable k() {
        return (android.graphics.drawable.GradientDrawable) this.regularBackground.getValue();
    }

    public final int m() {
        return ((Number) this.regularTextColor.getValue()).intValue();
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final ib getResourcesHelper() {
        return this.resourcesHelper;
    }

    public final android.graphics.drawable.GradientDrawable o() {
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setCornerRadius(4 * this.resourcesHelper.a());
        gradientDrawable.setColor(p());
        return gradientDrawable;
    }

    public final int q() {
        return ((Number) this.secondaryDividerColor.getValue()).intValue();
    }

    public final int r() {
        return ((Number) this.secondaryTextColor.getValue()).intValue();
    }

    public final AppConfiguration.Theme s() {
        return (AppConfiguration.Theme) this.theme.getValue();
    }

    public final boolean t() {
        return ((Boolean) this.isDarkTheme.getValue()).booleanValue();
    }

    public final boolean u() {
        return ((Boolean) this.isFullscreen.getValue()).booleanValue();
    }

    public final boolean v() {
        return ((Boolean) this.isLinkColorSet.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppConfiguration.Theme.ButtonsThemeConfig b() {
        return (AppConfiguration.Theme.ButtonsThemeConfig) this.buttonsThemeConfig.getValue();
    }

    public final android.graphics.drawable.GradientDrawable c() {
        return (android.graphics.drawable.GradientDrawable) this.highlightBackground.getValue();
    }

    public final int a() {
        return ((Number) this.backgroundColor.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.graphics.drawable.GradientDrawable a(AppConfiguration.Theme.ButtonsThemeConfig.ButtonTheme buttonTheme, int backgroundColor) {
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        boolean zG = buttonTheme.getSizesInDp();
        String strE = buttonTheme.getBorderRadius();
        if (strE != null) {
            float fA = Float.parseFloat(strE);
            if (zG) {
                fA *= this.resourcesHelper.a();
            }
            gradientDrawable.setCornerRadius(fA);
        } else {
            gradientDrawable.setCornerRadius(0.0f);
        }
        String strD = buttonTheme.getBorderColor();
        String strF = buttonTheme.getBorderWidth();
        if (strF != null && strD != null) {
            int iA = Integer.parseInt(strF);
            if (zG) {
                iA = (int) (iA * this.resourcesHelper.a());
            }
            gradientDrawable.setStroke(iA, z.a.b(strD));
        } else {
            gradientDrawable.setStroke(0, 0);
        }
        gradientDrawable.setColor(backgroundColor);
        return gradientDrawable;
    }
}
