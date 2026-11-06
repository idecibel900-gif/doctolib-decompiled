package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RenderingUtilsKt {
    public static final String render(Name name) {
        Intrinsics.checkNotNullParameter(name, "<this>");
        if (!shouldBeEscaped(name)) {
            String strAsString = name.asString();
            Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
            return strAsString;
        }
        StringBuilder sb = new StringBuilder();
        String strAsString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(strAsString2, "asString(...)");
        sb.append('`' + strAsString2);
        sb.append('`');
        return sb.toString();
    }

    private static final boolean shouldBeEscaped(Name name) {
        String strAsString = name.asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        if (KeywordStringsGenerated.KEYWORDS.contains(strAsString)) {
            return true;
        }
        for (int i = 0; i < strAsString.length(); i++) {
            char cCharAt = strAsString.charAt(i);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_') {
                return true;
            }
        }
        return strAsString.length() == 0 || !Character.isJavaIdentifierStart(strAsString.codePointAt(0));
    }

    public static final String render(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "<this>");
        return renderFqName(fqNameUnsafe.pathSegments());
    }

    public static final String renderFqName(List pathSegments) {
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        StringBuilder sb = new StringBuilder();
        Iterator it = pathSegments.iterator();
        while (it.hasNext()) {
            Name name = (Name) it.next();
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(render(name));
        }
        return sb.toString();
    }

    public static final String replacePrefixesInTypeRepresentations(String lowerRendered, String lowerPrefix, String upperRendered, String upperPrefix, String foldedPrefix) {
        Intrinsics.checkNotNullParameter(lowerRendered, "lowerRendered");
        Intrinsics.checkNotNullParameter(lowerPrefix, "lowerPrefix");
        Intrinsics.checkNotNullParameter(upperRendered, "upperRendered");
        Intrinsics.checkNotNullParameter(upperPrefix, "upperPrefix");
        Intrinsics.checkNotNullParameter(foldedPrefix, "foldedPrefix");
        if (StringsKt.startsWith$default(lowerRendered, lowerPrefix, false, 2, (Object) null) && StringsKt.startsWith$default(upperRendered, upperPrefix, false, 2, (Object) null)) {
            String strSubstring = lowerRendered.substring(lowerPrefix.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strSubstring2 = upperRendered.substring(upperPrefix.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            String str = foldedPrefix + strSubstring;
            if (Intrinsics.areEqual(strSubstring, strSubstring2)) {
                return str;
            }
            if (typeStringsDifferOnlyInNullability(strSubstring, strSubstring2)) {
                return str + '!';
            }
        }
        return null;
    }

    public static final boolean typeStringsDifferOnlyInNullability(String lower, String upper) {
        Intrinsics.checkNotNullParameter(lower, "lower");
        Intrinsics.checkNotNullParameter(upper, "upper");
        if (Intrinsics.areEqual(lower, StringsKt.replace$default(upper, "?", "", false, 4, (Object) null))) {
            return true;
        }
        if (StringsKt.endsWith$default(upper, "?", false, 2, (Object) null)) {
            if (Intrinsics.areEqual(lower + '?', upper)) {
                return true;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(lower);
        sb.append(")?");
        return Intrinsics.areEqual(sb.toString(), upper);
    }
}
