package io.didomi.ssl;

import io.didomi.ssl.consent.model.ConsentChoices;
import io.didomi.ssl.user.sync.model.ResponseConsents;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\t\u001a\u0012\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000\u001a\u0012\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000\u001a\u0012\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000\u001a\u0012\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000\u001a\u0012\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000\u001a\u0012\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000\u001a\u0012\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000\u001a\u0012\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000¨\u0006\u000b"}, d2 = {"Lio/didomi/sdk/user/sync/model/ResponseConsents;", "", "", "e", "a", "g", "c", "f", "b", "h", "d", "android_release"}, k = 2, mv = {1, 8, 0})
public final class jb {
    public static final Set<String> a(ResponseConsents responseConsents) {
        Collection<String> disabled;
        Intrinsics.checkNotNullParameter(responseConsents, "<this>");
        ConsentChoices consentPurposes = responseConsents.getConsentPurposes();
        if (consentPurposes == null || (disabled = consentPurposes.getDisabled()) == null) {
            return null;
        }
        return CollectionsKt.toSet(disabled);
    }

    public static final Set<String> b(ResponseConsents responseConsents) {
        Collection<String> disabled;
        Intrinsics.checkNotNullParameter(responseConsents, "<this>");
        ConsentChoices consentVendors = responseConsents.getConsentVendors();
        if (consentVendors == null || (disabled = consentVendors.getDisabled()) == null) {
            return null;
        }
        return CollectionsKt.toSet(disabled);
    }

    public static final Set<String> c(ResponseConsents responseConsents) {
        Collection<String> disabled;
        Intrinsics.checkNotNullParameter(responseConsents, "<this>");
        ConsentChoices liPurposes = responseConsents.getLiPurposes();
        if (liPurposes == null || (disabled = liPurposes.getDisabled()) == null) {
            return null;
        }
        return CollectionsKt.toSet(disabled);
    }

    public static final Set<String> d(ResponseConsents responseConsents) {
        Collection<String> disabled;
        Intrinsics.checkNotNullParameter(responseConsents, "<this>");
        ConsentChoices liVendors = responseConsents.getLiVendors();
        if (liVendors == null || (disabled = liVendors.getDisabled()) == null) {
            return null;
        }
        return CollectionsKt.toSet(disabled);
    }

    public static final Set<String> e(ResponseConsents responseConsents) {
        Collection<String> enabled;
        Intrinsics.checkNotNullParameter(responseConsents, "<this>");
        ConsentChoices consentPurposes = responseConsents.getConsentPurposes();
        if (consentPurposes == null || (enabled = consentPurposes.getEnabled()) == null) {
            return null;
        }
        return CollectionsKt.toSet(enabled);
    }

    public static final Set<String> f(ResponseConsents responseConsents) {
        Collection<String> enabled;
        Intrinsics.checkNotNullParameter(responseConsents, "<this>");
        ConsentChoices consentVendors = responseConsents.getConsentVendors();
        if (consentVendors == null || (enabled = consentVendors.getEnabled()) == null) {
            return null;
        }
        return CollectionsKt.toSet(enabled);
    }

    public static final Set<String> g(ResponseConsents responseConsents) {
        Collection<String> enabled;
        Intrinsics.checkNotNullParameter(responseConsents, "<this>");
        ConsentChoices liPurposes = responseConsents.getLiPurposes();
        if (liPurposes == null || (enabled = liPurposes.getEnabled()) == null) {
            return null;
        }
        return CollectionsKt.toSet(enabled);
    }

    public static final Set<String> h(ResponseConsents responseConsents) {
        Collection<String> enabled;
        Intrinsics.checkNotNullParameter(responseConsents, "<this>");
        ConsentChoices liVendors = responseConsents.getLiVendors();
        if (liVendors == null || (enabled = liVendors.getEnabled()) == null) {
            return null;
        }
        return CollectionsKt.toSet(enabled);
    }
}
