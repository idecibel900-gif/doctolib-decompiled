package io.didomi.ssl;

import io.didomi.ssl.consent.model.ConsentToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001a\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b2\u00103J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u001e\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002J\u0006\u0010\u000e\u001a\u00020\u000bJ*\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015J\u0014\u0010\u0007\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\fJ\u0014\u0010\u0011\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\fJ\u0014\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\fJ\u0014\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\fR\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010!\u001a\u0004\b\u0014\u0010#\"\u0004\b\u0012\u0010%R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R(\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010!\u001a\u0004\b\u0013\u0010#\"\u0004\b+\u0010%R(\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00150\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010!\u001a\u0004\b+\u0010#\"\u0004\b\u000e\u0010%R(\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00150\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010!\u001a\u0004\b\u0011\u0010#\"\u0004\b\"\u0010%R(\u00100\u001a\b\u0012\u0004\u0012\u00020\u00150\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010!\u001a\u0004\b$\u0010#\"\u0004\b/\u0010%R(\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010!\u001a\u0004\b\u0012\u0010#\"\u0004\b(\u0010%¨\u00064"}, d2 = {"Lio/didomi/sdk/jh;", "", "", "Lio/didomi/sdk/Purpose;", Didomi.VIEW_PURPOSES, "requiredPurposes", "", "a", "Lio/didomi/sdk/consent/model/ConsentToken;", "consentToken", "legitimatePurposes", "", "", "personalData", "j", "requiredLegIntPurposes", "purpose", "c", "e", "d", "b", "Lio/didomi/sdk/Vendor;", "vendor", "requiredConsentPurposes", "requiredConsentVendors", "requiredLegIntVendors", "", "Z", "getReady", "()Z", "setReady", "(Z)V", "ready", "Ljava/util/Set;", "f", "()Ljava/util/Set;", "i", "(Ljava/util/Set;)V", "enabledConsentPurposes", "disabledConsentPurposes", "h", "k", "enabledLegIntPurposes", "g", "disabledLegIntPurposes", "enabledConsentVendors", "disabledConsentVendors", "l", "enabledLegIntVendors", "disabledLegIntVendors", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class jh {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final jh k = new jh();

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private boolean ready;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private Set<Purpose> enabledConsentPurposes = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private Set<Purpose> disabledConsentPurposes = new LinkedHashSet();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private Set<Purpose> enabledLegIntPurposes = new LinkedHashSet();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private Set<Purpose> disabledLegIntPurposes = new LinkedHashSet();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private Set<Vendor> enabledConsentVendors = new LinkedHashSet();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private Set<Vendor> disabledConsentVendors = new LinkedHashSet();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private Set<Vendor> enabledLegIntVendors = new LinkedHashSet();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private Set<Vendor> disabledLegIntVendors = new LinkedHashSet();

    /* JADX INFO: renamed from: io.didomi.sdk.jh$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lio/didomi/sdk/jh$a;", "", "Lio/didomi/sdk/jh;", "instance", "Lio/didomi/sdk/jh;", "a", "()Lio/didomi/sdk/jh;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final jh a() {
            return jh.k;
        }

        private Companion() {
        }
    }

    public final Set<Purpose> b() {
        return this.disabledConsentPurposes;
    }

    public final Set<Vendor> c() {
        return this.disabledConsentVendors;
    }

    public final Set<Purpose> d() {
        return this.disabledLegIntPurposes;
    }

    public final void e(Set<Purpose> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.disabledConsentPurposes = set;
    }

    public final Set<Purpose> f() {
        return this.enabledConsentPurposes;
    }

    public final void g(Set<Purpose> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.disabledLegIntPurposes = set;
    }

    public final Set<Purpose> h() {
        return this.enabledLegIntPurposes;
    }

    public final void i(Set<Purpose> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.enabledConsentPurposes = set;
    }

    public final void j(Set<Vendor> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.enabledConsentVendors = set;
    }

    public final void k(Set<Purpose> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.enabledLegIntPurposes = set;
    }

    public final void l(Set<Vendor> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.enabledLegIntVendors = set;
    }

    public final void a(ConsentToken consentToken, Collection<Purpose> requiredPurposes, Collection<Purpose> requiredLegIntPurposes) {
        Intrinsics.checkNotNullParameter(consentToken, "consentToken");
        Intrinsics.checkNotNullParameter(requiredPurposes, "requiredPurposes");
        Intrinsics.checkNotNullParameter(requiredLegIntPurposes, "requiredLegIntPurposes");
        if (this.ready) {
            return;
        }
        this.enabledConsentPurposes = a(consentToken.getEnabledPurposes().values(), requiredPurposes);
        this.disabledConsentPurposes = a(consentToken.getDisabledPurposes().values(), requiredPurposes);
        ArrayList arrayList = new ArrayList();
        for (Object obj : requiredPurposes) {
            if (ca.a((Purpose) obj)) {
                arrayList.add(obj);
            }
        }
        a(consentToken, CollectionsKt.toSet(arrayList));
        this.enabledConsentVendors = CollectionsKt.toMutableSet(consentToken.getEnabledVendors().values());
        this.disabledConsentVendors = CollectionsKt.toMutableSet(consentToken.getDisabledVendors().values());
        a(consentToken, requiredLegIntPurposes);
        this.enabledLegIntVendors = CollectionsKt.toMutableSet(consentToken.getEnabledLegitimateVendors().values());
        this.disabledLegIntVendors = CollectionsKt.toMutableSet(consentToken.getDisabledLegitimateVendors().values());
        this.ready = true;
    }

    public final void b(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        ca.b(this.enabledLegIntPurposes, purpose);
        this.disabledLegIntPurposes.add(purpose);
    }

    public final void c(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        ca.b(this.disabledConsentPurposes, purpose);
        this.enabledConsentPurposes.add(purpose);
    }

    public final void d(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        ca.b(this.disabledLegIntPurposes, purpose);
        this.enabledLegIntPurposes.add(purpose);
    }

    public final Set<Vendor> e() {
        return this.disabledLegIntVendors;
    }

    public final void f(Set<Vendor> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.disabledConsentVendors = set;
    }

    public final Set<Vendor> g() {
        return this.enabledConsentVendors;
    }

    public final void h(Set<Vendor> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.disabledLegIntVendors = set;
    }

    public final Set<Vendor> i() {
        return this.enabledLegIntVendors;
    }

    public final void j() {
        this.ready = false;
        this.enabledConsentPurposes = new LinkedHashSet();
        this.disabledConsentPurposes = new LinkedHashSet();
        this.enabledLegIntPurposes = new LinkedHashSet();
        this.disabledLegIntPurposes = new LinkedHashSet();
        this.enabledConsentVendors = new LinkedHashSet();
        this.disabledConsentVendors = new LinkedHashSet();
        this.enabledLegIntVendors = new LinkedHashSet();
        this.disabledLegIntVendors = new LinkedHashSet();
    }

    public final void e(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        ca.b(this.enabledConsentPurposes, purpose);
        ca.b(this.disabledConsentPurposes, purpose);
    }

    public final void b(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        this.enabledLegIntVendors.remove(vendor);
        this.disabledLegIntVendors.add(vendor);
    }

    public final void c(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        this.disabledConsentVendors.remove(vendor);
        this.enabledConsentVendors.add(vendor);
    }

    public final void d(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        this.disabledLegIntVendors.remove(vendor);
        this.enabledLegIntVendors.add(vendor);
    }

    public final void e(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        this.enabledConsentVendors.remove(vendor);
        this.disabledConsentVendors.remove(vendor);
    }

    public final void b(Set<Vendor> requiredConsentVendors) {
        Intrinsics.checkNotNullParameter(requiredConsentVendors, "requiredConsentVendors");
        for (Vendor vendor : requiredConsentVendors) {
            if (!this.enabledConsentVendors.contains(vendor)) {
                this.disabledConsentVendors.add(vendor);
            }
        }
    }

    public final void c(Set<Purpose> requiredLegIntPurposes) {
        Intrinsics.checkNotNullParameter(requiredLegIntPurposes, "requiredLegIntPurposes");
        for (Purpose purpose : requiredLegIntPurposes) {
            if (!ca.a(this.disabledLegIntPurposes, purpose)) {
                this.enabledLegIntPurposes.add(purpose);
            }
        }
    }

    public final void d(Set<Vendor> requiredLegIntVendors) {
        Intrinsics.checkNotNullParameter(requiredLegIntVendors, "requiredLegIntVendors");
        for (Vendor vendor : requiredLegIntVendors) {
            if (!this.disabledLegIntVendors.contains(vendor)) {
                this.enabledLegIntVendors.add(vendor);
            }
        }
    }

    public final void a(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        ca.b(this.enabledConsentPurposes, purpose);
        this.disabledConsentPurposes.add(purpose);
    }

    public final void a(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        this.enabledConsentVendors.remove(vendor);
        this.disabledConsentVendors.add(vendor);
    }

    private final void a(ConsentToken consentToken, Collection<Purpose> legitimatePurposes) {
        if (u0.m(consentToken)) {
            this.enabledLegIntPurposes = CollectionsKt.toMutableSet(legitimatePurposes);
            this.disabledLegIntPurposes = new LinkedHashSet();
            return;
        }
        Collection<Purpose> collectionValues = consentToken.getDisabledLegitimatePurposes().values();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : legitimatePurposes) {
            if (ca.a(collectionValues, (Purpose) obj)) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.getFirst();
        this.enabledLegIntPurposes = CollectionsKt.toMutableSet((List) pair.getSecond());
        this.disabledLegIntPurposes = CollectionsKt.toMutableSet(list);
    }

    private final void a(ConsentToken consentToken, Set<Purpose> personalData) {
        if (u0.n(consentToken)) {
            Iterator<T> it = personalData.iterator();
            while (it.hasNext()) {
                a((Purpose) it.next());
            }
        }
    }

    public final void a(Set<Purpose> requiredConsentPurposes) {
        Intrinsics.checkNotNullParameter(requiredConsentPurposes, "requiredConsentPurposes");
        for (Purpose purpose : requiredConsentPurposes) {
            if (!ca.a(this.enabledConsentPurposes, purpose)) {
                this.disabledConsentPurposes.add(purpose);
            }
        }
    }

    private final Set<Purpose> a(Collection<Purpose> purposes, Collection<Purpose> requiredPurposes) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : purposes) {
            Purpose purpose = (Purpose) obj;
            if (requiredPurposes != null && ca.a(requiredPurposes, purpose)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toMutableSet(arrayList);
    }
}
