package io.didomi.ssl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a$\u0010\u0004\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00000\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\t"}, d2 = {"Lio/didomi/sdk/m1;", "Lio/didomi/sdk/e7;", "translation", "", "a", "", "", "", "translations", "android_release"}, k = 2, mv = {1, 8, 0})
public final class q1 {
    public static final void a(m1 m1Var, InternalPurpose translation) {
        Intrinsics.checkNotNullParameter(m1Var, "<this>");
        Intrinsics.checkNotNullParameter(translation, "translation");
        String name = translation.getName();
        if (name != null) {
            m1Var.setName(name);
        }
        String description = translation.getDescription();
        if (description != null) {
            m1Var.setDescription(description);
        }
        String descriptionLegal = translation.getDescriptionLegal();
        if (descriptionLegal != null) {
            m1Var.setDescriptionLegal(descriptionLegal);
        }
        List<String> listE = translation.e();
        if (listE != null) {
            m1Var.setIllustrations(listE);
        }
    }

    public static final void a(Set<? extends m1> set, Map<String, InternalPurpose> translations) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(translations, "translations");
        for (m1 m1Var : set) {
            InternalPurpose internalPurpose = translations.get(m1Var.getId());
            if (internalPurpose != null) {
                a(m1Var, internalPurpose);
            }
        }
    }
}
