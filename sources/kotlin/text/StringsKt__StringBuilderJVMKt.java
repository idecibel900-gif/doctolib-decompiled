package kotlin.text;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
public abstract class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    public static StringBuilder clear(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.setLength(0);
        return sb;
    }
}
