package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u000b\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\r\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\u0003*\u00020\u0000¨\u0006\u0010"}, d2 = {"Lio/didomi/sdk/e0;", "Lio/didomi/sdk/d1;", "countryHelper", "", "b", "a", "g", "i", "j", "k", "h", "f", "d", "l", "e", "c", "android_release"}, k = 2, mv = {1, 8, 0})
public final class f0 {
    private static final boolean a(e0 e0Var, d1 d1Var) {
        return d1Var.c() || e0Var.b().getApp().getGdprAppliesGlobally() || (d1Var.getNet.openid.appauth.ResponseTypeValues.CODE java.lang.String() == null && e0Var.b().getApp().getGdprAppliesWhenUnknown());
    }

    public static final boolean b(e0 e0Var, d1 countryHelper) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        Intrinsics.checkNotNullParameter(countryHelper, "countryHelper");
        if (j(e0Var)) {
            return a(e0Var, countryHelper);
        }
        return e0Var.e() != Regulation.NONE;
    }

    public static final boolean c(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        return e0Var.b().getNotice().getEnableBulkActionOnPurposes();
    }

    public static final boolean d(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        return !k(e0Var);
    }

    public static final boolean e(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        return k(e0Var) && !e0Var.b().getNotice().getContent().d().isEmpty();
    }

    public static final boolean f(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        return k(e0Var);
    }

    public static final boolean g(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        return e0Var.e() == Regulation.CCPA;
    }

    public static final boolean h(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        return e0Var.b().getTheme().getFullscreen() || e0Var.b().getTheme().getNotice().getStickyButtons() || g(e0Var) || m.d(e0Var.b().getNotice()) == AppConfiguration.Notice.d.BOTTOM;
    }

    public static final boolean i(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        return e0Var.e() == Regulation.GDPR;
    }

    public static final boolean j(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        return e0Var.b().getRegulation().getName() == null;
    }

    public static final boolean k(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        return e0Var.e().getMixed();
    }

    public static final boolean l(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        return k(e0Var);
    }

    public static final boolean a(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        return !k(e0Var);
    }

    public static final boolean b(e0 e0Var) {
        Intrinsics.checkNotNullParameter(e0Var, "<this>");
        return i(e0Var);
    }
}
