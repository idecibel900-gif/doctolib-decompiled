package io.didomi.ssl;

import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0012\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007\u001a\u001e\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\r"}, d2 = {"Landroid/widget/TextView;", "Lio/didomi/sdk/j2;", "type", "Lio/didomi/sdk/ah;", "themeProvider", "", "a", "Lio/didomi/sdk/xg;", "theme", "Lio/didomi/sdk/l$h$c$a;", "alignment", "Landroid/graphics/Typeface;", "fontFamily", "android_release"}, k = 2, mv = {1, 8, 0})
public final class zg {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j2.values().length];
            try {
                iArr[j2.NOTICE_DESCRIPTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[j2.NOTICE_TITLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[j2.PREFERENCES_DESCRIPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[j2.PREFERENCES_TITLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[j2.PRIMARY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[j2.SECONDARY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    public static final void a(TextView textView, j2 type, ah themeProvider) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        switch (a.a[type.ordinal()]) {
            case 1:
                a(textView, themeProvider.h().b(), themeProvider.h().c());
                textView.setTextColor(themeProvider.h().d());
                textView.setTextSize(themeProvider.h().e());
                textView.setTypeface(themeProvider.h().c());
                if (themeProvider.v()) {
                    textView.setLinkTextColor(themeProvider.f());
                }
                break;
            case 2:
                a(textView, themeProvider.h().j(), themeProvider.h().k());
                textView.setTextColor(themeProvider.h().l());
                textView.setTextSize(themeProvider.h().m());
                textView.setTypeface(themeProvider.h().k());
                break;
            case 3:
                a(textView, themeProvider.i().b(), themeProvider.i().g());
                textView.setTextColor(themeProvider.i().e());
                textView.setTextSize(themeProvider.i().f());
                textView.setTypeface(themeProvider.i().g());
                if (themeProvider.v()) {
                    textView.setLinkTextColor(themeProvider.f());
                }
                break;
            case 4:
                a(textView, themeProvider.i().l(), themeProvider.i().m());
                textView.setTextColor(themeProvider.i().p());
                textView.setTextSize(themeProvider.i().q());
                textView.setTypeface(themeProvider.i().m());
                break;
            case 5:
                textView.setTextColor(themeProvider.j());
                break;
            case 6:
                textView.setTextColor(themeProvider.r());
                break;
        }
    }

    public static final void a(final TextView textView, TextTheme theme) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(theme, "theme");
        final GradientDrawable background = theme.getBackground();
        if (background != null) {
            textView.post(new Runnable() { // from class: io.didomi.sdk.zg$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    zg.a(textView, background);
                }
            });
        }
        textView.setTextColor(theme.getTextColor());
        Typeface typeface = theme.getTypeface();
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TextView this_applyTheme, GradientDrawable it) {
        Intrinsics.checkNotNullParameter(this_applyTheme, "$this_applyTheme");
        Intrinsics.checkNotNullParameter(it, "$it");
        this_applyTheme.setBackground(it);
    }

    private static final void a(TextView textView, AppConfiguration.Theme.ContentThemeConfig.a aVar, Typeface typeface) {
        textView.setGravity(aVar.getGravity());
        if (aVar == AppConfiguration.Theme.ContentThemeConfig.a.JUSTIFY) {
            yg.b(textView, typeface != null);
        }
    }
}
