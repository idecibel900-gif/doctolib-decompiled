package io.didomi.ssl;

import android.text.Spanned;
import android.util.Patterns;
import androidx.core.text.HtmlCompat;
import com.amazon.a.a.o.b.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\u001a\u000e\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0004\u001a\u00020\u0002*\u0004\u0018\u00010\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u0002*\u0004\u0018\u00010\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0000*\u0004\u0018\u00010\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t\u001a\u0016\u0010\u0006\u001a\u00020\u000b*\u0004\u0018\u00010\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a\n\u0010\r\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\u000e*\u00020\u0000\u001a\u0012\u0010\u0003\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000\u001a\f\u0010\u0011\u001a\u00020\u000e*\u00020\u0000H\u0000\u001a\u000e\u0010\u0013\u001a\u00020\u0012*\u0004\u0018\u00010\u0000H\u0000\u001a\f\u0010\u0014\u001a\u00020\u000e*\u00020\u0000H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0000*\u00020\u0000H\u0000\u001a\u000e\u0010\u0016\u001a\u00020\u0000*\u0004\u0018\u00010\u0000H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0000H\u0002¨\u0006\u0017"}, d2 = {"", "d", "", "b", "c", "link", "a", "Lio/didomi/sdk/gc;", "transformation", "Ljava/util/Locale;", "locale", "", "default", "f", "Landroid/text/Spanned;", "h", "url", "i", "", "k", "j", "g", "e", "android_release"}, k = 2, mv = {1, 8, 0})
public final class fc {
    public static final boolean a(String str, String str2) {
        String strReplace$default;
        String strReplace$default2;
        if (str2 == null || (strReplace$default = StringsKt.replace$default(str2, "/", "\\/", false, 4, (Object) null)) == null || (strReplace$default2 = StringsKt.replace$default(strReplace$default, ".", "[.]", false, 4, (Object) null)) == null) {
            return false;
        }
        String str3 = String.format("([\\s\\S]*)< *a [^>]*href *= *\\\"%s\\\".*>([\\s\\S]*)", Arrays.copyOf(new Object[]{strReplace$default2}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(this, *args)");
        Pattern patternCompile = Pattern.compile(str3, 2);
        if (str == null) {
            str = "";
        }
        return patternCompile.matcher(str).matches();
    }

    public static final boolean b(String str) {
        Pattern pattern = Patterns.WEB_URL;
        if (str == null) {
            str = "";
        }
        return pattern.matcher(str).matches();
    }

    public static final boolean c(String str) {
        return b(str) && str != null && StringsKt.endsWith(str, ".json", true);
    }

    public static final String d(String str) {
        String string;
        if (str == null || (string = StringsKt.trim(str).toString()) == null) {
            return null;
        }
        String lowerCase = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (lowerCase != null) {
            return new Regex("\\s+").replace(lowerCase, "_");
        }
        return null;
    }

    private static final String e(String str) {
        String strJoinToString$default;
        List listSplit$default;
        if (str == null || (listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"\n"}, false, 0, 6, (Object) null)) == null) {
            strJoinToString$default = null;
        } else {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
            int i = 0;
            for (Object obj : listSplit$default) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str2 = (String) obj;
                boolean z = i < CollectionsKt.getLastIndex(listSplit$default) && a((String) listSplit$default.get(i2));
                if (a(str2)) {
                    str2 = "<li-tag>" + StringsKt.trim(StringsKt.replace$default(str2, "*", "", false, 4, (Object) null)).toString() + "</li-tag>";
                    if (i == 0 || !a((String) listSplit$default.get(i - 1))) {
                        str2 = "<ul-tag>" + str2;
                    }
                    if (!z) {
                        str2 = str2 + "</ul-tag>";
                    }
                } else if (!z) {
                    str2 = str2 + "<br />";
                }
                arrayList.add(str2);
                i = i2;
            }
            strJoinToString$default = CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
        }
        return strJoinToString$default == null ? "" : strJoinToString$default;
    }

    public static final String f(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.trim(StringsKt.replace$default(str, "&amp;", "&", false, 4, (Object) null)).toString();
    }

    public static final String g(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        za zaVar = za.a;
        return StringsKt.trim(zaVar.e().replace(zaVar.f().replace(zaVar.h().replace(zaVar.i().replace(zaVar.a().replace(zaVar.b().replace(str, "<li-tag>"), "</li-tag>"), "<ul-tag>"), "</ul-tag>"), "<ol-tag>"), "</ol-tag>")).toString();
    }

    public static final Spanned h(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(StringsKt.trim(str).toString(), 0);
        Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(trim(), HtmlCompat.FROM_HTML_MODE_LEGACY)");
        CharSequence charSequenceTrim = StringsKt.trim(spannedFromHtml);
        Intrinsics.checkNotNull(charSequenceTrim, "null cannot be cast to non-null type android.text.Spanned");
        return (Spanned) charSequenceTrim;
    }

    public static final Spanned i(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(g(str), 0, null, new p7());
        Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(\n    replaceLis…   null, LiTagHandler()\n)");
        CharSequence charSequenceTrim = StringsKt.trim(spannedFromHtml);
        Intrinsics.checkNotNull(charSequenceTrim, "null cannot be cast to non-null type android.text.Spanned");
        return (Spanned) charSequenceTrim;
    }

    public static final Spanned j(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (new Regex("<.*?>").containsMatchIn(str)) {
            return i(str);
        }
        CharSequence charSequenceK = k(str);
        Intrinsics.checkNotNull(charSequenceK, "null cannot be cast to non-null type android.text.Spanned");
        return (Spanned) charSequenceK;
    }

    public static final CharSequence k(String str) {
        Spanned spannedFromHtml = HtmlCompat.fromHtml(e(str), 0, null, new p7());
        Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(\n    replaceAst…   null, LiTagHandler()\n)");
        return StringsKt.trim(spannedFromHtml);
    }

    public static final Spanned b(String str, String url) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("<a href=\"%s\">%s</a>", Arrays.copyOf(new Object[]{url, str}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        return h(str2);
    }

    public static final String a(String str, gc transformation, Locale locale) {
        Intrinsics.checkNotNullParameter(transformation, "transformation");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (str == null || StringsKt.isBlank(str)) {
            return "";
        }
        if (transformation == gc.UPPER_CASE) {
            String upperCase = str.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        }
        if (transformation != gc.LOWER_CASE) {
            return str.toString();
        }
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public static final long a(String str, long j) {
        String strSubstringBefore$default;
        if (str != null) {
            try {
                String strSubstringBefore$default2 = StringsKt.substringBefore$default(str, ".", (String) null, 2, (Object) null);
                if (strSubstringBefore$default2 != null && (strSubstringBefore$default = StringsKt.substringBefore$default(strSubstringBefore$default2, f.a, (String) null, 2, (Object) null)) != null) {
                    return Long.parseLong(strSubstringBefore$default);
                }
            } catch (NumberFormatException unused) {
            }
        }
        return j;
    }

    private static final boolean a(String str) {
        return StringsKt.startsWith$default(StringsKt.trim(str).toString(), "*", false, 2, (Object) null);
    }
}
