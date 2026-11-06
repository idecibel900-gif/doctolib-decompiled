package io.didomi.ssl;

import androidx.lifecycle.ViewModel;
import com.amazon.a.a.o.b;
import io.didomi.ssl.models.DeviceStorageDisclosure;
import io.didomi.ssl.models.DeviceStorageDisclosures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\b\u0017\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020!¢\u0006\u0004\bG\u0010HJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0015J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0004R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001fR\u0017\u0010%\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010$R(\u0010*\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010)R*\u00100\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010,\u001a\u0004\b-\u0010.\"\u0004\b\u000e\u0010/R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00028\u0006@BX\u0086.¢\u0006\f\n\u0004\b\r\u00101\u001a\u0004\b2\u00103R\"\u0010\u0005\u001a\u00020\u00048\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b#\u00104\u001a\u0004\b\u0017\u00105\"\u0004\b\u0007\u00106R\u0011\u00108\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b7\u00103R\u0011\u00109\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u00103R\u0011\u0010;\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b:\u00103R\u0011\u0010=\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b<\u00103R\u0011\u0010>\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u00103R\u0011\u0010?\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u00103R\u0011\u0010A\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b@\u00103R\u0011\u0010C\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bB\u00103R\u0011\u0010E\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bD\u00103R\u0011\u0010F\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u00103¨\u0006I"}, d2 = {"Lio/didomi/sdk/a2;", "Landroidx/lifecycle/ViewModel;", "", "vendorName", "Lio/didomi/sdk/models/DeviceStorageDisclosures;", "disclosures", "", "a", "", "position", "Lio/didomi/sdk/models/DeviceStorageDisclosure;", "disclosure", "d", "g", "b", "c", "f", "", "Lio/didomi/sdk/w1;", "s", "r", "", "Lio/didomi/sdk/Purpose;", "e", "Lio/didomi/sdk/e0;", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/n7;", "Lio/didomi/sdk/n7;", "languagesHelper", "Lio/didomi/sdk/zh;", "Lio/didomi/sdk/zh;", "vendorRepository", "Lio/didomi/sdk/u7;", "Lio/didomi/sdk/u7;", "h", "()Lio/didomi/sdk/u7;", "logoProvider", "<set-?>", "Lio/didomi/sdk/models/DeviceStorageDisclosure;", "m", "()Lio/didomi/sdk/models/DeviceStorageDisclosure;", "selectedDisclosure", "value", "I", "n", "()I", "(I)V", "selectedIndex", "Ljava/lang/String;", "q", "()Ljava/lang/String;", "Lio/didomi/sdk/models/DeviceStorageDisclosures;", "()Lio/didomi/sdk/models/DeviceStorageDisclosures;", "(Lio/didomi/sdk/models/DeviceStorageDisclosures;)V", "o", b.S, "disclosureDetailsTitle", "i", "nameSectionTitle", "p", "typeSectionTitle", "domainSectionTitle", "expirationSectionTitle", "l", "purposesSectionTitle", "k", "previousButtonLabel", "j", "nextButtonLabel", "accessibilityCloseDescription", "<init>", "(Lio/didomi/sdk/e0;Lio/didomi/sdk/n7;Lio/didomi/sdk/zh;Lio/didomi/sdk/u7;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class a2 extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e0 configurationRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final n7 languagesHelper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final zh vendorRepository;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final u7 logoProvider;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private DeviceStorageDisclosure selectedDisclosure;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private int selectedIndex;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private String vendorName;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    protected DeviceStorageDisclosures disclosures;

    public a2(e0 configurationRepository, n7 languagesHelper, zh vendorRepository, u7 logoProvider) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        Intrinsics.checkNotNullParameter(vendorRepository, "vendorRepository");
        Intrinsics.checkNotNullParameter(logoProvider, "logoProvider");
        this.configurationRepository = configurationRepository;
        this.languagesHelper = languagesHelper;
        this.vendorRepository = vendorRepository;
        this.logoProvider = logoProvider;
    }

    protected final void a(DeviceStorageDisclosures deviceStorageDisclosures) {
        Intrinsics.checkNotNullParameter(deviceStorageDisclosures, "<set-?>");
        this.disclosures = deviceStorageDisclosures;
    }

    public final void b(int i) {
        this.selectedDisclosure = a(i);
        this.selectedIndex = i;
    }

    public final String c(DeviceStorageDisclosure disclosure) {
        Intrinsics.checkNotNullParameter(disclosure, "disclosure");
        Long maxAgeSeconds = disclosure.getMaxAgeSeconds();
        if (maxAgeSeconds != null) {
            if (maxAgeSeconds.longValue() <= 0) {
                maxAgeSeconds = null;
            }
            if (maxAgeSeconds != null) {
                return n7.a(this.languagesHelper, "period_after_data_is_stored", (gc) null, MapsKt.mapOf(TuplesKt.to("{humanizedStorageDuration}", t1.a.b(this.languagesHelper, maxAgeSeconds.longValue()))), 2, (Object) null);
            }
        }
        return null;
    }

    public final String d() {
        return n7.a(this.languagesHelper, "vendors_data_storage", (gc) null, MapsKt.mapOf(TuplesKt.to("{vendorName}", q())), 2, (Object) null);
    }

    protected final DeviceStorageDisclosures e() {
        DeviceStorageDisclosures deviceStorageDisclosures = this.disclosures;
        if (deviceStorageDisclosures != null) {
            return deviceStorageDisclosures;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disclosures");
        return null;
    }

    public final String f() {
        return n7.a(this.languagesHelper, "domain", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String g() {
        return n7.a(this.languagesHelper, "expiration", (gc) null, (Map) null, 6, (Object) null);
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final u7 getLogoProvider() {
        return this.logoProvider;
    }

    public final String i() {
        return n7.a(this.languagesHelper, "name", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String j() {
        return n7.a(this.languagesHelper, "next_storage", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String k() {
        return n7.a(this.languagesHelper, "previous_storage", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String l() {
        return n7.a(this.languagesHelper, "used_for_purposes", (gc) null, (Map) null, 6, (Object) null);
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final DeviceStorageDisclosure getSelectedDisclosure() {
        return this.selectedDisclosure;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final String o() {
        return x8.a.a(this.configurationRepository, this.languagesHelper);
    }

    public final String p() {
        return n7.a(this.languagesHelper, "type", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String q() {
        String str = this.vendorName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vendorName");
        return null;
    }

    public final void r() {
        b(this.selectedIndex + 1);
    }

    public final void s() {
        b(this.selectedIndex - 1);
    }

    public final void a(String vendorName, DeviceStorageDisclosures disclosures) {
        Intrinsics.checkNotNullParameter(vendorName, "vendorName");
        Intrinsics.checkNotNullParameter(disclosures, "disclosures");
        this.vendorName = vendorName;
        a(disclosures);
    }

    public final String d(DeviceStorageDisclosure disclosure) {
        Intrinsics.checkNotNullParameter(disclosure, "disclosure");
        return disclosure.getIdentifier();
    }

    protected final List<Purpose> e(DeviceStorageDisclosure disclosure) {
        Collection collectionEmptyList;
        Iterable iterableEmptyList;
        Intrinsics.checkNotNullParameter(disclosure, "disclosure");
        List<String> purposes = disclosure.getPurposes();
        if (purposes != null) {
            collectionEmptyList = new ArrayList();
            Iterator<T> it = purposes.iterator();
            while (it.hasNext()) {
                Purpose purposeD = this.vendorRepository.d((String) it.next());
                if (purposeD != null) {
                    collectionEmptyList.add(purposeD);
                }
            }
        } else {
            collectionEmptyList = CollectionsKt.emptyList();
        }
        List<String> didomiPurposes = disclosure.getDidomiPurposes();
        if (didomiPurposes == null || (iterableEmptyList = this.vendorRepository.a(CollectionsKt.toSet(didomiPurposes))) == null) {
            iterableEmptyList = CollectionsKt.emptyList();
        }
        return CollectionsKt.plus(collectionEmptyList, iterableEmptyList);
    }

    public String f(DeviceStorageDisclosure disclosure) {
        Intrinsics.checkNotNullParameter(disclosure, "disclosure");
        return i7.a.a(e(disclosure));
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0045  */
    public final String g(DeviceStorageDisclosure disclosure) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(disclosure, "disclosure");
        String type = disclosure.getType();
        if (type == null) {
            str = null;
        } else {
            int iHashCode = type.hashCode();
            if (iHashCode != -1354757532) {
                if (iHashCode != 96801) {
                    if (iHashCode == 117588 && type.equals("web")) {
                        str2 = "web_storage";
                        str = str2;
                    } else {
                        str = null;
                    }
                } else if (type.equals("app")) {
                    str2 = "app_storage";
                    str = str2;
                } else {
                    str = null;
                }
            } else if (type.equals("cookie")) {
                str2 = "cookie_storage";
                str = str2;
            } else {
                str = null;
            }
        }
        if (str == null) {
            return null;
        }
        return n7.a(this.languagesHelper, str, (gc) null, (Map) null, 6, (Object) null);
    }

    public final String b(DeviceStorageDisclosure disclosure) {
        Intrinsics.checkNotNullParameter(disclosure, "disclosure");
        return disclosure.getDomain();
    }

    public final DeviceStorageDisclosure a(int position) {
        List<DeviceStorageDisclosure> disclosuresList = e().getDisclosuresList();
        if (disclosuresList != null) {
            return (DeviceStorageDisclosure) CollectionsKt.getOrNull(disclosuresList, position);
        }
        return null;
    }

    public final String b() {
        return n7.a(this.languagesHelper, "close", null, null, null, 14, null);
    }

    public String a(DeviceStorageDisclosure disclosure) {
        Intrinsics.checkNotNullParameter(disclosure, "disclosure");
        ArrayList arrayList = new ArrayList();
        String domain = disclosure.getDomain();
        if (domain != null && domain.length() > 0) {
            arrayList.add(domain);
        }
        Long maxAgeSeconds = disclosure.getMaxAgeSeconds();
        if (maxAgeSeconds != null) {
            if (maxAgeSeconds.longValue() <= 0) {
                maxAgeSeconds = null;
            }
            if (maxAgeSeconds != null) {
                arrayList.add(t1.a(t1.a, this.languagesHelper, maxAgeSeconds.longValue(), (String) null, false, 12, (Object) null));
            }
        }
        return CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null);
    }

    public final List<DeviceStorageDisclosureItem> c() {
        List<DeviceStorageDisclosure> disclosuresList = e().getDisclosuresList();
        if (disclosuresList != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(disclosuresList, 10));
            for (DeviceStorageDisclosure deviceStorageDisclosure : disclosuresList) {
                long jHashCode = deviceStorageDisclosure.hashCode();
                String identifier = deviceStorageDisclosure.getIdentifier();
                String str = "";
                if (identifier == null) {
                    identifier = "";
                }
                String strA = a(deviceStorageDisclosure);
                if (strA != null) {
                    str = strA;
                }
                arrayList.add(new DeviceStorageDisclosureItem(jHashCode, identifier, str));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    public final boolean a() {
        return this.selectedDisclosure != null;
    }
}
