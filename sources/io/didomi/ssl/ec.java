package io.didomi.ssl;

import io.didomi.ssl.models.SpecialFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¨\u0006\u0003"}, d2 = {"Lio/didomi/sdk/models/SpecialFeature;", "Lio/didomi/sdk/Purpose;", "a", "android_release"}, k = 2, mv = {1, 8, 0})
public final class ec {
    public static final Purpose a(SpecialFeature specialFeature) {
        Intrinsics.checkNotNullParameter(specialFeature, "<this>");
        return new Purpose(specialFeature.getId(), specialFeature.getIabId(), specialFeature.getName(), specialFeature.getDescription(), specialFeature.getDescriptionLegal(), null, false, false, false, true, null, null, 3552, null);
    }
}
