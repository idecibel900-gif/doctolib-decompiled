package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¨\u0006\u000b"}, d2 = {"Lio/didomi/sdk/wg;", "", "", "html", "a", "string", "", "c", "b", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class wg {
    public static final wg a = new wg();

    private wg() {
    }

    public final String a(String html) {
        Intrinsics.checkNotNullParameter(html, "html");
        return new Regex("</?a[^>]*>").replace(html, "");
    }

    public final boolean b(String string) {
        Regex regexD = za.a.d();
        if (string == null) {
            string = "";
        }
        return regexD.matches(string);
    }

    public final boolean c(String string) {
        Regex regexG = za.a.g();
        if (string == null) {
            string = "";
        }
        return regexG.matches(string);
    }
}
