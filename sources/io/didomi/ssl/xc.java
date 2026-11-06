package io.didomi.ssl;

import com.amazon.a.a.o.b;
import io.didomi.ssl.models.DeviceStorageDisclosure;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lio/didomi/sdk/xc;", "Lio/didomi/sdk/a2;", "Lio/didomi/sdk/models/DeviceStorageDisclosure;", "disclosure", "", "a", "f", "", "t", b.S, "", "hasCookieSection", "Lio/didomi/sdk/wf;", "Lio/didomi/sdk/n7;", "i", "Lio/didomi/sdk/n7;", "languagesHelper", "u", "()Ljava/lang/String;", "subtitleLabel", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/zh;", "vendorRepository", "Lio/didomi/sdk/u7;", "logoProvider", "<init>", "(Lio/didomi/sdk/e0;Lio/didomi/sdk/n7;Lio/didomi/sdk/zh;Lio/didomi/sdk/u7;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class xc extends a2 {

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final n7 languagesHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xc(e0 configurationRepository, n7 languagesHelper, zh vendorRepository, u7 logoProvider) {
        super(configurationRepository, languagesHelper, vendorRepository, logoProvider);
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        Intrinsics.checkNotNullParameter(vendorRepository, "vendorRepository");
        Intrinsics.checkNotNullParameter(logoProvider, "logoProvider");
        this.languagesHelper = languagesHelper;
    }

    @Override // io.didomi.ssl.a2
    public String a(DeviceStorageDisclosure disclosure) {
        Intrinsics.checkNotNullParameter(disclosure, "disclosure");
        ArrayList arrayList = new ArrayList();
        String identifier = disclosure.getIdentifier();
        if (identifier != null && identifier.length() > 0) {
            arrayList.add(n7.a(this.languagesHelper, "name", (gc) null, (Map) null, 6, (Object) null) + ": " + identifier);
        }
        String strG = g(disclosure);
        if (strG != null && strG.length() > 0) {
            arrayList.add(n7.a(this.languagesHelper, "type", (gc) null, (Map) null, 6, (Object) null) + ": " + strG);
        }
        String domain = disclosure.getDomain();
        if (domain != null && domain.length() > 0) {
            arrayList.add(n7.a(this.languagesHelper, "domain", (gc) null, (Map) null, 6, (Object) null) + ": " + domain);
        }
        String strC = c(disclosure);
        if (strC != null) {
            arrayList.add(n7.a(this.languagesHelper, "expiration", (gc) null, (Map) null, 6, (Object) null) + ": " + strC);
        }
        String strF = f(disclosure);
        if (strF.length() > 0) {
            arrayList.add(n7.a(this.languagesHelper, "used_for_purposes", (gc) null, (Map) null, 6, (Object) null) + ": " + strF);
        }
        return i7.b(i7.a, arrayList, null, 2, null);
    }

    @Override // io.didomi.ssl.a2
    public String f(DeviceStorageDisclosure disclosure) {
        Intrinsics.checkNotNullParameter(disclosure, "disclosure");
        List<Purpose> listE = e(disclosure);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listE, 10));
        Iterator<T> it = listE.iterator();
        while (it.hasNext()) {
            arrayList.add(n7.a(this.languagesHelper, ((Purpose) it.next()).getName(), null, null, null, 14, null));
        }
        return CollectionsKt.joinToString$default(CollectionsKt.sorted(arrayList), ", ", null, null, 0, null, null, 62, null);
    }

    public final List<DeviceStorageDisclosure> t() {
        return e().getDisclosuresList();
    }

    public final String u() {
        StringBuilder sb = new StringBuilder();
        sb.append(n7.a(this.languagesHelper, "device_storage", gc.UPPER_CASE, null, null, 12, null));
        sb.append(": ");
        DeviceStorageDisclosure selectedDisclosure = getSelectedDisclosure();
        sb.append(selectedDisclosure != null ? selectedDisclosure.getIdentifier() : null);
        return sb.toString();
    }

    public final List<wf> a(String title, boolean hasCookieSection) {
        int i;
        List<wf> listEmptyList;
        Intrinsics.checkNotNullParameter(title, "title");
        List<DeviceStorageDisclosure> disclosuresList = e().getDisclosuresList();
        if (disclosuresList != null) {
            if (disclosuresList.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new wf.DeviceStorageDisclosureTitle(!hasCookieSection, title, 0, 4, null));
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = disclosuresList.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    String identifier = ((DeviceStorageDisclosure) next).getIdentifier();
                    if (((identifier == null || StringsKt.isBlank(identifier)) ? 1 : 0) == 0) {
                        arrayList2.add(next);
                    }
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    int i2 = i;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    i = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String identifier2 = ((DeviceStorageDisclosure) next2).getIdentifier();
                    if (identifier2 == null) {
                        identifier2 = "";
                    }
                    arrayList3.add(new wf.DeviceStorageDisclosure(identifier2, i2, 0, 4, null));
                }
                arrayList.addAll(arrayList3);
                listEmptyList = arrayList;
            }
            if (listEmptyList != null) {
                return listEmptyList;
            }
        }
        return CollectionsKt.emptyList();
    }
}
