package io.didomi.ssl;

import com.amazon.a.a.o.c.a.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\u0010\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006*\u00020\u0000\u001a\u0010\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\b\u001a\n\u0010\u0002\u001a\u00020\f*\u00020\u000b\u001a\n\u0010\u0004\u001a\u00020\u000e*\u00020\r\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u000b\u001a\n\u0010\u0004\u001a\u00020\u0010*\u00020\u000f\u001a\n\u0010\u0004\u001a\u00020\u0012*\u00020\u0011\u001a\n\u0010\u0002\u001a\u00020\u000e*\u00020\u0011\u001a\n\u0010\u0005\u001a\u00020\u000e*\u00020\u0011\u001a\n\u0010\u0007\u001a\u00020\u0013*\u00020\u0011\u001a\n\u0010\u0004\u001a\u00020\u0012*\u00020\u0014\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0015\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0017*\u00020\u0016\u001a\n\u0010\u0004\u001a\u00020\f*\u00020\u000b\u001a\n\u0010\u0005\u001a\u00020\u0018*\u00020\u000b¨\u0006\u0019"}, d2 = {"Lio/didomi/sdk/l$a;", "", "b", "", "a", "c", "", "d", "Lio/didomi/sdk/l$a$b;", "", "Lio/didomi/sdk/Vendor;", "Lio/didomi/sdk/l;", "", "Lio/didomi/sdk/l$a$b$a;", "", "Lio/didomi/sdk/l$a$b$a$b;", "Lio/didomi/sdk/l$a$b$a$b$b;", "Lio/didomi/sdk/l$e;", "Lio/didomi/sdk/l$h$a;", "Lio/didomi/sdk/l$e$d;", "Lio/didomi/sdk/l$e$c;", "Lio/didomi/sdk/l$h;", "Lio/didomi/sdk/l$i;", "Ljava/util/Date;", "Lio/didomi/sdk/Regulation;", "android_release"}, k = 2, mv = {1, 8, 0})
public final class m {
    public static final long a(AppConfiguration.App app2) {
        long jA;
        Intrinsics.checkNotNullParameter(app2, "<this>");
        Object consentDuration = app2.getConsentDuration();
        if (consentDuration instanceof Number) {
            jA = ((Number) app2.getConsentDuration()).longValue();
        } else {
            jA = consentDuration instanceof String ? fc.a((String) app2.getConsentDuration(), 31622400L) : 31622400L;
        }
        if (jA > 0) {
            return jA;
        }
        return 31622400L;
    }

    public static final String b(AppConfiguration.App app2) {
        Intrinsics.checkNotNullParameter(app2, "<this>");
        if (!wg.a.c(app2.getCountry())) {
            return "AA";
        }
        String country = app2.getCountry();
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String upperCase = country.toUpperCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public static final long c(AppConfiguration.App app2) {
        long jA;
        Intrinsics.checkNotNullParameter(app2, "<this>");
        Object deniedConsentDuration = app2.getDeniedConsentDuration();
        if (deniedConsentDuration instanceof Number) {
            jA = ((Number) app2.getDeniedConsentDuration()).longValue();
        } else {
            jA = deniedConsentDuration instanceof String ? fc.a((String) app2.getDeniedConsentDuration(), -1L) : -1L;
        }
        if (jA > 0) {
            return jA;
        }
        return -1L;
    }

    public static final List<String> d(AppConfiguration.App app2) {
        Intrinsics.checkNotNullParameter(app2, "<this>");
        List<String> listG = app2.g();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listG) {
            String str = (String) obj;
            List<CustomPurpose> listC = app2.c();
            if (!(listC instanceof Collection) || !listC.isEmpty()) {
                Iterator<T> it = listC.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((CustomPurpose) it.next()).getId(), str)) {
                        arrayList.add(obj);
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public static final Set<Vendor> a(AppConfiguration.App.Vendors vendors) {
        Intrinsics.checkNotNullParameter(vendors, "<this>");
        Set<InternalVendor> setA = vendors.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setA, 10));
        for (InternalVendor internalVendor : setA) {
            String id = internalVendor.getId();
            arrayList.add((id != null && StringsKt.startsWith$default(id, "c:", false, 2, (Object) null)) ? h7.a(internalVendor) : h7.a(InternalVendor.a(internalVendor, "c:" + internalVendor.getId(), null, null, null, "custom", null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524270, null)));
        }
        return CollectionsKt.toSet(arrayList);
    }

    public static final boolean c(AppConfiguration.Notice notice) {
        Intrinsics.checkNotNullParameter(notice, "<this>");
        AppConfiguration.Notice.DenyOptions denyOptions = notice.getDenyOptions();
        if (denyOptions != null) {
            return denyOptions.getLink();
        }
        return notice.getDenyAsLink() && Intrinsics.areEqual(notice.getType(), "optin");
    }

    public static final int b(AppConfiguration appConfiguration) {
        Integer gvlSpecificationVersion;
        Intrinsics.checkNotNullParameter(appConfiguration, "<this>");
        Integer majorVersion = appConfiguration.getApp().getVendors().getIab().getMajorVersion();
        if (((majorVersion != null ? majorVersion.intValue() : 0) > 2 || appConfiguration.getApp().getVendors().getIab().getMinorVersion() != null) && (gvlSpecificationVersion = appConfiguration.getApp().getVendors().getIab().getGvlSpecificationVersion()) != null) {
            return gvlSpecificationVersion.intValue();
        }
        return 2;
    }

    public static final Regulation c(AppConfiguration appConfiguration) {
        Intrinsics.checkNotNullParameter(appConfiguration, "<this>");
        String name = appConfiguration.getRegulation().getName();
        Regulation regulation = Regulation.CCPA;
        if (Intrinsics.areEqual(name, regulation.getValue()) && appConfiguration.getRegulation().getCcpa() != null) {
            return regulation;
        }
        String name2 = appConfiguration.getRegulation().getName();
        Regulation regulation2 = Regulation.CPA;
        if (Intrinsics.areEqual(name2, regulation2.getValue())) {
            return regulation2;
        }
        String name3 = appConfiguration.getRegulation().getName();
        Regulation regulation3 = Regulation.CPRA;
        if (Intrinsics.areEqual(name3, regulation3.getValue())) {
            return regulation3;
        }
        String name4 = appConfiguration.getRegulation().getName();
        Regulation regulation4 = Regulation.CTDPA;
        if (Intrinsics.areEqual(name4, regulation4.getValue())) {
            return regulation4;
        }
        String name5 = appConfiguration.getRegulation().getName();
        Regulation regulation5 = Regulation.NONE;
        if (Intrinsics.areEqual(name5, regulation5.getValue())) {
            return regulation5;
        }
        String name6 = appConfiguration.getRegulation().getName();
        Regulation regulation6 = Regulation.UCPA;
        if (Intrinsics.areEqual(name6, regulation6.getValue()) && appConfiguration.getFeatureFlags().getTestUCPA()) {
            return regulation6;
        }
        String name7 = appConfiguration.getRegulation().getName();
        Regulation regulation7 = Regulation.VCDPA;
        return Intrinsics.areEqual(name7, regulation7.getValue()) ? regulation7 : Regulation.GDPR;
    }

    public static final boolean b(AppConfiguration.Notice notice) {
        Intrinsics.checkNotNullParameter(notice, "<this>");
        AppConfiguration.Notice.DenyOptions denyOptions = notice.getDenyOptions();
        if (denyOptions != null) {
            return denyOptions.getCross();
        }
        return false;
    }

    public static final boolean a(AppConfiguration.App.Vendors.IABVendors iABVendors) {
        Intrinsics.checkNotNullParameter(iABVendors, "<this>");
        return iABVendors.getEnabled() && iABVendors.getCanBeEnabled();
    }

    public static final AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b a(AppConfiguration.App.Vendors.IABVendors.PublisherRestriction publisherRestriction) {
        Intrinsics.checkNotNullParameter(publisherRestriction, "<this>");
        AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b.Companion companion = AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b.INSTANCE;
        String restrictionType = publisherRestriction.getRestrictionType();
        if (restrictionType == null) {
            restrictionType = "";
        }
        return companion.a(restrictionType);
    }

    public static final AppConfiguration.Theme.a a(AppConfiguration.Notice notice) {
        Intrinsics.checkNotNullParameter(notice, "<this>");
        if (notice.getDenyOptions() != null) {
            return a(notice.getDenyOptions());
        }
        if (!Intrinsics.areEqual(notice.getType(), "optin") || notice.getDenyAsLink()) {
            return AppConfiguration.Theme.a.NONE;
        }
        return notice.getDenyAsPrimary() ? AppConfiguration.Theme.a.PRIMARY : AppConfiguration.Theme.a.SECONDARY;
    }

    public static final AppConfiguration.Theme.a a(AppConfiguration.Notice.DenyOptions denyOptions) {
        Intrinsics.checkNotNullParameter(denyOptions, "<this>");
        return AppConfiguration.Theme.a.INSTANCE.a(denyOptions.getButtonAsString());
    }

    public static final String a(AppConfiguration.Theme theme) {
        Intrinsics.checkNotNullParameter(theme, "<this>");
        return z.a.a(theme.getColor());
    }

    public static final Date a(AppConfiguration.User user) {
        Intrinsics.checkNotNullParameter(user, "<this>");
        String ignoreConsentBeforeAsString = user.getIgnoreConsentBeforeAsString();
        if (ignoreConsentBeforeAsString == null || StringsKt.isBlank(ignoreConsentBeforeAsString)) {
            return null;
        }
        t1 t1Var = t1.a;
        Date dateA = t1Var.a(user.getIgnoreConsentBeforeAsString());
        if (t1Var.c(dateA)) {
            return dateA;
        }
        return null;
    }

    public static final int a(AppConfiguration appConfiguration) {
        Intrinsics.checkNotNullParameter(appConfiguration, "<this>");
        Integer numL = appConfiguration.getApp().getVendors().getIab().l();
        if (numL != null) {
            return numL.intValue();
        }
        return 7;
    }

    public static final String d(AppConfiguration appConfiguration) {
        Intrinsics.checkNotNullParameter(appConfiguration, "<this>");
        if (!appConfiguration.getApp().getVendors().getIab().getEnabled()) {
            return null;
        }
        if (appConfiguration.getApp().getVendors().getIab().getMajorVersion() == null || appConfiguration.getApp().getVendors().getIab().getMinorVersion() == null) {
            return appConfiguration.getApp().getVendors().getIab().getMajorVersion() != null ? appConfiguration.getApp().getVendors().getIab().getMajorVersion().toString() : "2";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(appConfiguration.getApp().getVendors().getIab().getMajorVersion());
        sb.append(b.a);
        sb.append(appConfiguration.getApp().getVendors().getIab().getMinorVersion());
        return sb.toString();
    }

    public static final AppConfiguration.Notice.d d(AppConfiguration.Notice notice) {
        Intrinsics.checkNotNullParameter(notice, "<this>");
        return AppConfiguration.Notice.d.INSTANCE.a(notice.getPositionAsString());
    }
}
