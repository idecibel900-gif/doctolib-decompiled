package io.didomi.ssl;

import android.text.Spanned;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.events.Event;
import io.didomi.ssl.events.PreferencesClickSPICategoryAgreeEvent;
import io.didomi.ssl.events.PreferencesClickSPICategoryDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickSPIPurposeAgreeEvent;
import io.didomi.ssl.events.PreferencesClickSPIPurposeDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickSPIPurposeSaveChoicesEvent;
import io.didomi.ssl.purpose.common.model.PurposeCategory;
import io.didomi.ssl.view.mobile.DidomiToggle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010,\u001a\u00020*\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00103\u001a\u000201\u0012\u0006\u00106\u001a\u000204\u0012\u0006\u0010;\u001a\u000207\u0012\u0006\u0010@\u001a\u00020<\u0012\u0006\u0010E\u001a\u00020A\u0012\u0006\u0010J\u001a\u00020F\u0012\u0006\u0010N\u001a\u00020K¢\u0006\u0004\bu\u0010vJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u000b\u001a\u00020\nJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J\u000e\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\bJ\u0010\u0010\u0004\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u0004\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\rJ\u0016\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0012J\u0016\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0012J\u0006\u0010$\u001a\u00020\rJ\u0006\u0010%\u001a\u00020\rJ\u0006\u0010&\u001a\u00020\rJ\u0006\u0010'\u001a\u00020\rJ\u0006\u0010(\u001a\u00020\rJ\u0006\u0010)\u001a\u00020\rR\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010+R\u001a\u00100\u001a\u00020-8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\t\u0010.\u001a\u0004\b\u0011\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u00105R\u001a\u0010;\u001a\u0002078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0014\u00108\u001a\u0004\b9\u0010:R\u001a\u0010@\u001a\u00020<8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0013\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010E\u001a\u00020A8\u0006¢\u0006\f\n\u0004\b\u000f\u0010B\u001a\u0004\bC\u0010DR\u0017\u0010J\u001a\u00020F8\u0006¢\u0006\f\n\u0004\b\u0011\u0010G\u001a\u0004\bH\u0010IR\u0017\u0010N\u001a\u00020K8\u0006¢\u0006\f\n\u0004\b!\u0010L\u001a\u0004\b!\u0010MR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010OR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010OR\u001f\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0S8\u0006¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00120S8\u0006¢\u0006\f\n\u0004\bV\u0010U\u001a\u0004\bX\u0010WR\u001d\u0010^\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010[\u001a\u0004\b\\\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010`R\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020\b0\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010dR\u0014\u0010g\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010fR\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020\b0\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010dR\u0014\u0010k\u001a\u00020i8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010jR\u0014\u0010m\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010fR\u0014\u0010n\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010fR\u0011\u0010o\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bQ\u0010fR\u0011\u0010q\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bp\u0010fR\u0011\u0010r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010fR\u0011\u0010s\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010fR\u0011\u0010t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bT\u0010f¨\u0006w"}, d2 = {"Lio/didomi/sdk/ac;", "Landroidx/lifecycle/ViewModel;", "", "Lio/didomi/sdk/s8;", "a", "Lio/didomi/sdk/Purpose;", "z", "personalData", "", "b", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "category", "c", "", "B", "g", "purposeCategory", "h", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "f", "e", "", "Lio/didomi/sdk/o8;", "A", "Lio/didomi/sdk/events/Event;", "event", DiagnosticsEntry.ID_KEY, "", "isMainScreen", "item", "j", "d", "selectedCategory", "i", "v", "state", "w", "C", "y", "x", "u", "t", "Lio/didomi/sdk/apiEvents/a;", "Lio/didomi/sdk/apiEvents/a;", "apiEventsRepository", "Lio/didomi/sdk/e0;", "Lio/didomi/sdk/e0;", "()Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/r0;", "Lio/didomi/sdk/r0;", "consentRepository", "Lio/didomi/sdk/b6;", "Lio/didomi/sdk/b6;", "eventsRepository", "Lio/didomi/sdk/n7;", "Lio/didomi/sdk/n7;", "getLanguagesHelper", "()Lio/didomi/sdk/n7;", "languagesHelper", "Lio/didomi/sdk/jh;", "Lio/didomi/sdk/jh;", "getUserChoicesInfoProvider", "()Lio/didomi/sdk/jh;", "userChoicesInfoProvider", "Lio/didomi/sdk/eh;", "Lio/didomi/sdk/eh;", "s", "()Lio/didomi/sdk/eh;", "uiProvider", "Lio/didomi/sdk/zh;", "Lio/didomi/sdk/zh;", "getVendorRepository", "()Lio/didomi/sdk/zh;", "vendorRepository", "Lio/didomi/sdk/u7;", "Lio/didomi/sdk/u7;", "()Lio/didomi/sdk/u7;", "logoProvider", "Ljava/util/List;", "requiredPersonalData", "k", "requiredCategories", "Landroidx/lifecycle/MutableLiveData;", "l", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", "n", "selectedCategoryState", "Lio/didomi/sdk/cc;", "Lkotlin/Lazy;", "o", "()Lio/didomi/sdk/cc;", "spiContent", "Lio/didomi/sdk/b7;", "Lio/didomi/sdk/b7;", "spiInitialPurposesHolder", "p", "categoryInitialPurposesHolder", "()Ljava/util/List;", "accessibilityStateDescription", "()Ljava/lang/String;", "accessibilityActionDescription", "accessibilityStateActionDescription", "Landroid/text/Spanned;", "()Landroid/text/Spanned;", "spiContentDescription", "r", "spiSectionTitle", "noSpiContentLabel", "saveAndCloseButtonTitle", "q", "spiContentTitle", "accessibilityCloseDescription", "accessibilityClosePurposesActionDescription", "saveButtonLabel", "<init>", "(Lio/didomi/sdk/apiEvents/a;Lio/didomi/sdk/e0;Lio/didomi/sdk/r0;Lio/didomi/sdk/b6;Lio/didomi/sdk/n7;Lio/didomi/sdk/jh;Lio/didomi/sdk/eh;Lio/didomi/sdk/zh;Lio/didomi/sdk/u7;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class ac extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final io.didomi.ssl.apiEvents.a apiEventsRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final e0 configurationRepository;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final r0 consentRepository;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final b6 eventsRepository;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final n7 languagesHelper;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final jh userChoicesInfoProvider;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final eh uiProvider;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final zh vendorRepository;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final u7 logoProvider;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private List<Purpose> requiredPersonalData;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private List<PurposeCategory> requiredCategories;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final MutableLiveData selectedCategory;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final MutableLiveData selectedCategoryState;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final Lazy spiContent;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private InitialPurposesHolder spiInitialPurposesHolder;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private InitialPurposesHolder categoryInitialPurposesHolder;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DidomiToggle.b.values().length];
            try {
                iArr[DidomiToggle.b.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DidomiToggle.b.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DidomiToggle.b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(((Purpose) t).getName(), ((Purpose) t2).getName());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/cc;", "a", "()Lio/didomi/sdk/cc;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SensitivePersonalInformation invoke() {
            return ac.this.getConfigurationRepository().b().getPreferences().getSensitivePersonalInformation();
        }
    }

    public ac(io.didomi.ssl.apiEvents.a apiEventsRepository, e0 configurationRepository, r0 consentRepository, b6 eventsRepository, n7 languagesHelper, jh userChoicesInfoProvider, eh uiProvider, zh vendorRepository, u7 logoProvider) {
        Intrinsics.checkNotNullParameter(apiEventsRepository, "apiEventsRepository");
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(consentRepository, "consentRepository");
        Intrinsics.checkNotNullParameter(eventsRepository, "eventsRepository");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        Intrinsics.checkNotNullParameter(userChoicesInfoProvider, "userChoicesInfoProvider");
        Intrinsics.checkNotNullParameter(uiProvider, "uiProvider");
        Intrinsics.checkNotNullParameter(vendorRepository, "vendorRepository");
        Intrinsics.checkNotNullParameter(logoProvider, "logoProvider");
        this.apiEventsRepository = apiEventsRepository;
        this.configurationRepository = configurationRepository;
        this.consentRepository = consentRepository;
        this.eventsRepository = eventsRepository;
        this.languagesHelper = languagesHelper;
        this.userChoicesInfoProvider = userChoicesInfoProvider;
        this.uiProvider = uiProvider;
        this.vendorRepository = vendorRepository;
        this.logoProvider = logoProvider;
        this.requiredPersonalData = ai.b(vendorRepository);
        this.requiredCategories = vendorRepository.u();
        this.selectedCategory = new MutableLiveData();
        this.selectedCategoryState = new MutableLiveData();
        this.spiContent = LazyKt.lazy(new c());
    }

    private final void B() {
        this.apiEventsRepository.h();
        this.consentRepository.a(this.userChoicesInfoProvider.f(), this.userChoicesInfoProvider.b(), this.userChoicesInfoProvider.h(), this.userChoicesInfoProvider.d(), this.userChoicesInfoProvider.g(), this.userChoicesInfoProvider.c(), this.userChoicesInfoProvider.i(), this.userChoicesInfoProvider.e(), true, "click", this.apiEventsRepository, this.eventsRepository);
    }

    private final String c() {
        return n7.a(this.languagesHelper, "know_more_about_this_purpose", null, null, null, 14, null);
    }

    private final List<String> f() {
        return CollectionsKt.listOf((Object[]) new String[]{n7.a(this.languagesHelper, "enable_this_purpose", null, null, null, 14, null), n7.a(this.languagesHelper, "disable_this_purpose", null, null, null, 14, null), n7.a(this.languagesHelper, "enable_this_purpose", null, null, null, 14, null)});
    }

    private final List<String> g() {
        return CollectionsKt.listOf((Object[]) new String[]{n7.a(this.languagesHelper, "disabled", null, null, null, 14, null), n7.a(this.languagesHelper, "enabled", null, null, null, 14, null), n7.a(this.languagesHelper, "unspecified", null, null, null, 14, null)});
    }

    private final String j() {
        return n7.a(this.languagesHelper, "no_sensitive_personal_info", null, null, null, 14, null);
    }

    private final SensitivePersonalInformation o() {
        return (SensitivePersonalInformation) this.spiContent.getValue();
    }

    private final Spanned p() {
        n7 n7Var = this.languagesHelper;
        SensitivePersonalInformation sensitivePersonalInformationO = o();
        return fc.j(n7.a(n7Var, sensitivePersonalInformationO != null ? sensitivePersonalInformationO.b() : null, null, 2, null));
    }

    private final String r() {
        n7 n7Var = this.languagesHelper;
        SensitivePersonalInformation sensitivePersonalInformationO = o();
        return n7.a(n7Var, sensitivePersonalInformationO != null ? sensitivePersonalInformationO.c() : null, null, 2, null);
    }

    private final List<Purpose> z() {
        List<Purpose> mutableList = CollectionsKt.toMutableList((Collection) this.requiredPersonalData);
        if (mutableList.size() > 1) {
            CollectionsKt.sortWith(mutableList, new b());
        }
        if (!this.requiredCategories.isEmpty()) {
            for (Purpose purpose : mutableList) {
                Iterator<T> it = this.requiredCategories.iterator();
                while (it.hasNext()) {
                    a(purpose, (PurposeCategory) it.next());
                }
            }
        }
        return mutableList;
    }

    public List<Purpose> A() {
        Set<Purpose> setK = this.vendorRepository.k();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setK) {
            if (ca.a((Purpose) obj)) {
                arrayList.add(obj);
            }
        }
        this.requiredPersonalData = arrayList;
        return z();
    }

    public final void C() {
        kh.a(this.userChoicesInfoProvider, this.consentRepository.b(), this.vendorRepository);
    }

    public final List<o8> a(PurposeCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PersonalDataDisplayCategoryHeader(b(category)));
        List<PurposeCategory> children = category.getChildren();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            Purpose purposeH = h((PurposeCategory) it.next());
            if (purposeH != null) {
                arrayList2.add(purposeH);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(a((Purpose) it2.next()));
        }
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    public final List<o8> b() {
        ArrayList arrayList = new ArrayList();
        List<PersonalDataDisplayItem> listA = a();
        if (listA.isEmpty()) {
            arrayList.add(new PersonalDataDisplayEmpty(j()));
            return arrayList;
        }
        arrayList.add(new PersonalDataDisplayHeader(p(), r()));
        arrayList.addAll(listA);
        return arrayList;
    }

    public final String d() {
        return n7.a(this.languagesHelper, "close", null, null, null, 14, null);
    }

    public final String e() {
        return n7.a(this.languagesHelper, "close_purpose_view", null, null, null, 14, null);
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    protected final e0 getConfigurationRepository() {
        return this.configurationRepository;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final u7 getLogoProvider() {
        return this.logoProvider;
    }

    public final String k() {
        return n7.a(this.languagesHelper, "save_11a80ec3", null, null, null, 14, null);
    }

    public final String l() {
        return n7.a(this.languagesHelper, this.configurationRepository.b().getPreferences().getContent().g(), "save_11a80ec3", (gc) null, 4, (Object) null);
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final MutableLiveData getSelectedCategory() {
        return this.selectedCategory;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final MutableLiveData getSelectedCategoryState() {
        return this.selectedCategoryState;
    }

    public final String q() {
        n7 n7Var = this.languagesHelper;
        SensitivePersonalInformation sensitivePersonalInformationO = o();
        return n7.a(n7Var, sensitivePersonalInformationO != null ? sensitivePersonalInformationO.d() : null, null, 2, null);
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public final eh getUiProvider() {
        return this.uiProvider;
    }

    public final void t() {
        InitialPurposesHolder initialPurposesHolder = this.categoryInitialPurposesHolder;
        if (initialPurposesHolder != null) {
            c7.a(initialPurposesHolder, this.userChoicesInfoProvider);
        }
        this.selectedCategory.setValue(null);
    }

    public final void u() {
        this.categoryInitialPurposesHolder = InitialPurposesHolder.INSTANCE.a(this.userChoicesInfoProvider);
    }

    public final void v() {
        B();
        a(new PreferencesClickSPIPurposeSaveChoicesEvent());
    }

    public final void w() {
        this.apiEventsRepository.i();
    }

    public final void x() {
        InitialPurposesHolder initialPurposesHolder = this.spiInitialPurposesHolder;
        if (initialPurposesHolder != null) {
            c7.a(initialPurposesHolder, this.userChoicesInfoProvider);
        }
        this.selectedCategory.setValue(null);
    }

    public final void y() {
        this.spiInitialPurposesHolder = InitialPurposesHolder.INSTANCE.a(this.userChoicesInfoProvider);
    }

    private final String c(PurposeCategory category) {
        return n7.a(this.languagesHelper, category.getName(), null, 2, null);
    }

    private final Purpose h(PurposeCategory purposeCategory) {
        if (l9.a(purposeCategory) == PurposeCategory.Type.Purpose) {
            return b(purposeCategory.getPurposeId());
        }
        return null;
    }

    public final DidomiToggle.b d(PurposeCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        List<PurposeCategory> children = category.getChildren();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            Purpose purposeH = h((PurposeCategory) it.next());
            if (purposeH != null) {
                arrayList.add(purposeH);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(c((Purpose) it2.next()));
        }
        List listDistinct = CollectionsKt.distinct(arrayList2);
        return listDistinct.size() == 1 ? (DidomiToggle.b) CollectionsKt.first(listDistinct) : DidomiToggle.b.UNKNOWN;
    }

    public final String e(PurposeCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        return n7.a(this.languagesHelper, category.getName(), null, 2, null);
    }

    public final void i(PurposeCategory selectedCategory) {
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        this.selectedCategoryState.setValue(d(selectedCategory));
    }

    public final void j(PurposeCategory item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.selectedCategory.setValue(item);
    }

    private final DidomiToggle.b c(Purpose personalData) {
        return this.userChoicesInfoProvider.f().contains(personalData) ? DidomiToggle.b.ENABLED : DidomiToggle.b.DISABLED;
    }

    private final PersonalDataDisplayItem f(PurposeCategory category) {
        return new PersonalDataDisplayItem(category.getId().hashCode(), o8.a.Category, true, category.getId(), c(category), c(), d(category), f(), g(), false);
    }

    private final List<String> g(PurposeCategory category) {
        List<PurposeCategory> children = category.getChildren();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            Purpose purposeH = h((PurposeCategory) it.next());
            String id = purposeH != null ? purposeH.getId() : null;
            if (id != null) {
                arrayList.add(id);
            }
        }
        return arrayList;
    }

    public final Purpose b(String id) {
        Object next;
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<T> it = this.requiredPersonalData.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((Purpose) next).getId(), id)) {
                return (Purpose) next;
            }
        }
        next = null;
        return (Purpose) next;
    }

    private final String b(Purpose personalData) {
        return personalData.getName();
    }

    private final String b(PurposeCategory category) {
        return n7.a(this.languagesHelper, category.getDescription(), null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004c  */
    private final List<PersonalDataDisplayItem> a() {
        PersonalDataDisplayItem personalDataDisplayItemF;
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (PurposeCategory purposeCategory : this.requiredCategories) {
            if (l9.a(purposeCategory) == PurposeCategory.Type.Purpose) {
                Purpose purposeB = b(purposeCategory.getPurposeId());
                if (purposeB != null) {
                    personalDataDisplayItemF = a(purposeB);
                    linkedHashSet.add(purposeCategory.getPurposeId());
                } else {
                    personalDataDisplayItemF = null;
                }
            } else {
                List<String> listG = g(purposeCategory);
                if (listG.isEmpty()) {
                    personalDataDisplayItemF = null;
                } else {
                    linkedHashSet.addAll(listG);
                    personalDataDisplayItemF = f(purposeCategory);
                }
            }
            if (personalDataDisplayItemF != null) {
                arrayList.add(personalDataDisplayItemF);
            }
        }
        for (Purpose purpose : z()) {
            if (!linkedHashSet.contains(purpose.getId())) {
                arrayList.add(a(purpose));
            }
        }
        return CollectionsKt.filterNotNull(arrayList);
    }

    public final void a(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.eventsRepository.c(event);
    }

    public final PurposeCategory a(String id) {
        Object next;
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<T> it = this.requiredCategories.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((PurposeCategory) next).getId(), id)) {
                return (PurposeCategory) next;
            }
        }
        next = null;
        return (PurposeCategory) next;
    }

    public final boolean a(boolean isMainScreen) {
        AppConfiguration appConfigurationB = this.configurationRepository.b();
        if (appConfigurationB.getApp().getShouldHideDidomiLogo()) {
            return true;
        }
        return isMainScreen && appConfigurationB.getPreferences().getShowWhenConsentIsMissing();
    }

    public final void a(Purpose personalData, DidomiToggle.b state) {
        Intrinsics.checkNotNullParameter(personalData, "personalData");
        Intrinsics.checkNotNullParameter(state, "state");
        int i = a.a[state.ordinal()];
        if (i == 1) {
            this.userChoicesInfoProvider.a(personalData);
            a(new PreferencesClickSPIPurposeDisagreeEvent(personalData.getId()));
        } else {
            if (i != 2) {
                return;
            }
            this.userChoicesInfoProvider.c(personalData);
            a(new PreferencesClickSPIPurposeAgreeEvent(personalData.getId()));
        }
    }

    public final void a(PurposeCategory category, DidomiToggle.b state) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(state, "state");
        List<PurposeCategory> children = category.getChildren();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            Purpose purposeH = h((PurposeCategory) it.next());
            if (purposeH != null) {
                arrayList.add(purposeH);
            }
        }
        int i = a.a[state.ordinal()];
        if (i == 1) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.userChoicesInfoProvider.a((Purpose) it2.next());
            }
            a(new PreferencesClickSPICategoryDisagreeEvent(category.getId()));
            return;
        }
        if (i != 2) {
            return;
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            this.userChoicesInfoProvider.c((Purpose) it3.next());
        }
        a(new PreferencesClickSPICategoryAgreeEvent(category.getId()));
    }

    private final PersonalDataDisplayItem a(Purpose personalData) {
        return new PersonalDataDisplayItem(personalData.getId().hashCode(), o8.a.PersonalData, false, personalData.getId(), b(personalData), null, c(personalData), f(), g(), false);
    }

    private final void a(Purpose personalData, PurposeCategory category) {
        if (StringsKt.isBlank(personalData.getId()) || !Intrinsics.areEqual(personalData.getId(), category.getPurposeId())) {
            return;
        }
        personalData.setCategory(category);
    }
}
