package io.didomi.ssl;

import androidx.lifecycle.ViewModel;
import com.amazon.a.a.o.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u0003\u0010\u001dR\u0011\u0010\"\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010#\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010!R\u0011\u0010$\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010!R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001f0%8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010&R\u0014\u0010(\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010!R\u0011\u0010*\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b)\u0010!R\u0011\u0010+\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b\u0003\u0010!¨\u0006."}, d2 = {"Lio/didomi/sdk/n1;", "Landroidx/lifecycle/ViewModel;", "Lio/didomi/sdk/e0;", "a", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/b6;", "b", "Lio/didomi/sdk/b6;", "eventsRepository", "Lio/didomi/sdk/u7;", "c", "Lio/didomi/sdk/u7;", "g", "()Lio/didomi/sdk/u7;", "logoProvider", "Lio/didomi/sdk/n7;", "d", "Lio/didomi/sdk/n7;", "f", "()Lio/didomi/sdk/n7;", "setLanguagesHelper", "(Lio/didomi/sdk/n7;)V", "languagesHelper", "Lio/didomi/sdk/m1;", "e", "Lio/didomi/sdk/m1;", "i", "()Lio/didomi/sdk/m1;", "(Lio/didomi/sdk/m1;)V", "selectedItem", "", "j", "()Ljava/lang/String;", b.S, b.c, "descriptionLegal", "", "()Ljava/util/List;", "illustrations", "illustrationsHeaderLabel", "h", "name", "accessibilityCloseDescription", "<init>", "(Lio/didomi/sdk/e0;Lio/didomi/sdk/b6;Lio/didomi/sdk/u7;Lio/didomi/sdk/n7;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class n1 extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e0 configurationRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final b6 eventsRepository;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final u7 logoProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private n7 languagesHelper;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public m1 selectedItem;

    public n1(e0 configurationRepository, b6 eventsRepository, u7 logoProvider, n7 languagesHelper) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(eventsRepository, "eventsRepository");
        Intrinsics.checkNotNullParameter(logoProvider, "logoProvider");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        this.configurationRepository = configurationRepository;
        this.eventsRepository = eventsRepository;
        this.logoProvider = logoProvider;
        this.languagesHelper = languagesHelper;
    }

    public final void a(m1 m1Var) {
        Intrinsics.checkNotNullParameter(m1Var, "<set-?>");
        this.selectedItem = m1Var;
    }

    public final String b() {
        return i().getDescription();
    }

    public final String c() {
        return fc.k(i().getDescriptionLegal()).toString();
    }

    public final List<String> d() {
        ArrayList arrayList;
        List<String> illustrations = i().getIllustrations();
        if (illustrations != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(illustrations, 10));
            Iterator<T> it = illustrations.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.trim((String) it.next()).toString());
            }
        } else {
            arrayList = null;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    public String e() {
        return n7.a(this.languagesHelper, "purpose_illustration_explanation", null, null, null, 14, null);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    protected final n7 getLanguagesHelper() {
        return this.languagesHelper;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final u7 getLogoProvider() {
        return this.logoProvider;
    }

    public final String h() {
        return StringsKt.trim(i().getName()).toString();
    }

    public final m1 i() {
        m1 m1Var = this.selectedItem;
        if (m1Var != null) {
            return m1Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("selectedItem");
        return null;
    }

    public final String j() {
        return x8.a.a(this.configurationRepository, this.languagesHelper);
    }

    public final String a() {
        return n7.a(this.languagesHelper, "close", null, null, null, 14, null);
    }
}
