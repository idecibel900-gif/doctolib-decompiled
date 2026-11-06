package com.revenuecat.purchases.common;

import androidx.core.os.LocaleListCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/common/DefaultLocaleProvider;", "Lcom/revenuecat/purchases/common/LocaleProvider;", "()V", "currentLocalesLanguageTags", "", "getCurrentLocalesLanguageTags", "()Ljava/lang/String;", "preferredLocaleOverride", "setPreferredLocaleOverride", "", "localeString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultLocaleProvider implements LocaleProvider {
    private String preferredLocaleOverride;

    public final void setPreferredLocaleOverride(String localeString) {
        this.preferredLocaleOverride = localeString;
    }

    @Override // com.revenuecat.purchases.common.LocaleProvider
    public String getCurrentLocalesLanguageTags() {
        String str = this.preferredLocaleOverride;
        if (str != null) {
            String languageTags = LocaleListCompat.getDefault().toLanguageTags();
            Intrinsics.checkNotNullExpressionValue(languageTags, "getDefault().toLanguageTags()");
            if (languageTags.length() != 0) {
                str = str + ',' + languageTags;
            }
            if (str != null) {
                return str;
            }
        }
        String languageTags2 = LocaleListCompat.getDefault().toLanguageTags();
        Intrinsics.checkNotNullExpressionValue(languageTags2, "getDefault().toLanguageTags()");
        return languageTags2;
    }
}
