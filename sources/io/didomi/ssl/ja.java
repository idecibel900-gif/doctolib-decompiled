package io.didomi.ssl;

import androidx.lifecycle.ViewModel;
import com.amazon.a.a.o.b;
import io.didomi.ssl.purpose.common.model.PurposeCategory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0016¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\u0004\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\b\u0010\r\u001a\u0004\u0018\u00010\u0002J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u001a\u0010\u0015\u001a\u00020\u00118\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u00168\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u0004\u0010\u001eR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b\r\u0010#R(\u0010*\u001a\b\u0012\u0004\u0012\u00020%0\u000e8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u001c\u0010&\u001a\u0004\b'\u0010(\"\u0004\b\u0004\u0010)R\u0011\u0010,\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010\"R\u0011\u0010-\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\"¨\u00060"}, d2 = {"Lio/didomi/sdk/ja;", "Landroidx/lifecycle/ViewModel;", "", "infoType", "a", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "category", "", "Lio/didomi/sdk/Purpose;", "purpose", "Lio/didomi/sdk/gi;", "vendorsInfoType", "d", "b", "", "Lio/didomi/sdk/ea;", "h", "Lio/didomi/sdk/zh;", "Lio/didomi/sdk/zh;", "getVendorRepository", "()Lio/didomi/sdk/zh;", "vendorRepository", "Lio/didomi/sdk/n7;", "Lio/didomi/sdk/n7;", "c", "()Lio/didomi/sdk/n7;", "languagesHelper", "Lio/didomi/sdk/gi;", "e", "()Lio/didomi/sdk/gi;", "(Lio/didomi/sdk/gi;)V", "selectedInfoType", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "selectedItemName", "Lio/didomi/sdk/Vendor;", "Ljava/util/List;", "i", "()Ljava/util/List;", "(Ljava/util/List;)V", Didomi.VIEW_VENDORS, "g", b.S, "accessibilityCloseDescription", "<init>", "(Lio/didomi/sdk/zh;Lio/didomi/sdk/n7;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class ja extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final zh vendorRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final n7 languagesHelper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public gi selectedInfoType;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public String selectedItemName;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    protected List<Vendor> vendors;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[gi.values().length];
            try {
                iArr[gi.Purpose.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[gi.Category.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[gi.PurposeConsent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[gi.PurposeLI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public ja(zh vendorRepository, n7 languagesHelper) {
        Intrinsics.checkNotNullParameter(vendorRepository, "vendorRepository");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        this.vendorRepository = vendorRepository;
        this.languagesHelper = languagesHelper;
    }

    public final void a(gi giVar) {
        Intrinsics.checkNotNullParameter(giVar, "<set-?>");
        this.selectedInfoType = giVar;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedItemName = str;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    protected final n7 getLanguagesHelper() {
        return this.languagesHelper;
    }

    public final String d() {
        List<Vendor> listI = i();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listI) {
            if (!((Vendor) obj).isIabVendor()) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        return n7.a(this.languagesHelper, size == 1 ? "single_non_iab_partner_count" : "non_iab_partners_count", null, MapsKt.mapOf(TuplesKt.to("{nb}", String.valueOf(size))), null, 10, null);
    }

    public final gi e() {
        gi giVar = this.selectedInfoType;
        if (giVar != null) {
            return giVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("selectedInfoType");
        return null;
    }

    public final String f() {
        String str = this.selectedItemName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("selectedItemName");
        return null;
    }

    public final String g() {
        int i = a.a[e().ordinal()];
        if (i == 1 || i == 2) {
            return f();
        }
        if (i == 3) {
            return a(n7.a(this.languagesHelper, AuthorizationRequest.Prompt.CONSENT, (gc) null, (Map) null, 6, (Object) null));
        }
        if (i == 4) {
            return a(n7.a(this.languagesHelper, "legitimate_interest", (gc) null, (Map) null, 6, (Object) null));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final List<PurposeVendorDisplay> h() {
        List<Vendor> listI = i();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listI, 10));
        for (Vendor vendor : listI) {
            arrayList.add(new PurposeVendorDisplay(vendor.getId().hashCode(), fc.f(vendor.getName()), vendor.isIabVendor()));
        }
        return arrayList;
    }

    protected final List<Vendor> i() {
        List<Vendor> list = this.vendors;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException(Didomi.VIEW_VENDORS);
        return null;
    }

    protected final void a(List<Vendor> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.vendors = list;
    }

    public final String b() {
        List<Vendor> listI = i();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listI) {
            if (((Vendor) obj).isIabVendor()) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        return n7.a(this.languagesHelper, size == 1 ? "single_iab_partner_count" : "iab_partners_count", null, MapsKt.mapOf(TuplesKt.to("{nb}", String.valueOf(size))), null, 10, null);
    }

    public final String a() {
        return n7.a(this.languagesHelper, "close", null, null, null, 14, null);
    }

    public final void a(PurposeCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        a(gi.Category);
        b(n7.a(this.languagesHelper, category.getName(), null, 2, null));
        a(yh.a(ai.a(this.vendorRepository, category)));
    }

    public final void a(Purpose purpose, gi vendorsInfoType) {
        List<Vendor> listC;
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        Intrinsics.checkNotNullParameter(vendorsInfoType, "vendorsInfoType");
        a(vendorsInfoType);
        b(purpose.getName());
        int i = a.a[vendorsInfoType.ordinal()];
        if (i == 1) {
            listC = ai.c(this.vendorRepository, purpose);
        } else if (i == 3) {
            listC = ai.a(this.vendorRepository, purpose);
        } else if (i != 4) {
            listC = CollectionsKt.emptyList();
        } else {
            listC = ai.b(this.vendorRepository, purpose);
        }
        a(yh.a(listC));
    }

    private final String a(String infoType) {
        return f() + " > " + infoType;
    }
}
