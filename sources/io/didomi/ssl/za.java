package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u0019\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u001c"}, d2 = {"Lio/didomi/sdk/za;", "", "Lkotlin/text/Regex;", "b", "Lkotlin/text/Regex;", "c", "()Lkotlin/text/Regex;", "LOCALE_SEPARATOR", "d", "LOCALE_STRING", "g", "TWO_LETTERS", "e", "LI_OPENING_TAG", "f", "a", "LI_CLOSING_TAG", "i", "UL_OPENING_TAG", "h", "UL_CLOSING_TAG", "OL_OPENING_TAG", "j", "OL_CLOSING_TAG", "k", "UUID", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class za {
    public static final za a = new za();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final Regex LOCALE_SEPARATOR = new Regex("[_-]");

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final Regex LOCALE_STRING = new Regex("^[a-z]{2,3}[_-][A-Z]{2}|[a-z]{2,3}$", RegexOption.IGNORE_CASE);

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static final Regex TWO_LETTERS = new Regex("^[A-Za-z]{2}$");

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private static final Regex LI_OPENING_TAG = new Regex("(?i)<\\s*li[^>]*>");

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private static final Regex LI_CLOSING_TAG = new Regex("(?i)<\\s*/\\s*li[^>]*>");

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private static final Regex UL_OPENING_TAG = new Regex("(?i)<\\s*ul[^>]*>");

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private static final Regex UL_CLOSING_TAG = new Regex("(?i)<\\s*/\\s*ul[^>]*>");

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private static final Regex OL_OPENING_TAG = new Regex("(?i)<\\s*ol[^>]*>");

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private static final Regex OL_CLOSING_TAG = new Regex("(?i)<\\s*/\\s*ol[^>]*>");

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private static final Regex UUID = new Regex("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

    private za() {
    }

    public final Regex a() {
        return LI_CLOSING_TAG;
    }

    public final Regex b() {
        return LI_OPENING_TAG;
    }

    public final Regex c() {
        return LOCALE_SEPARATOR;
    }

    public final Regex d() {
        return LOCALE_STRING;
    }

    public final Regex e() {
        return OL_CLOSING_TAG;
    }

    public final Regex f() {
        return OL_OPENING_TAG;
    }

    public final Regex g() {
        return TWO_LETTERS;
    }

    public final Regex h() {
        return UL_CLOSING_TAG;
    }

    public final Regex i() {
        return UL_OPENING_TAG;
    }

    public final Regex j() {
        return UUID;
    }
}
