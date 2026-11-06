package io.didomi.ssl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/didomi/sdk/v;", "Lio/didomi/sdk/d8;", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "contentTextTranslationKey", "d", "titleTranslationKey", "a", "agreeTranslationKey", "e", "learnMoreTranslationKey", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class v implements d8 {
    public static final v a = new v();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final String contentTextTranslationKey = "ccpa_notice_consent";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final String titleTranslationKey = "ccpa_notice_title";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static final String agreeTranslationKey = "ccpa_notice_dismiss";

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private static final String learnMoreTranslationKey = "ccpa_notice_learn_more";

    private v() {
    }

    @Override // io.didomi.ssl.d8
    public String a() {
        return agreeTranslationKey;
    }

    @Override // io.didomi.ssl.d8
    public String b() {
        return learnMoreTranslationKey;
    }

    @Override // io.didomi.ssl.d8
    public String c() {
        return contentTextTranslationKey;
    }

    @Override // io.didomi.ssl.d8
    public String d() {
        return titleTranslationKey;
    }
}
