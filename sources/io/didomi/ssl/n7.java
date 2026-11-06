package io.didomi.ssl;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\u0006\u0010#\u001a\u00020!\u0012\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@J \u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0012J \u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0012J\b\u0010\b\u001a\u00020\u0007H\u0012J \u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0002H\u0012J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0012J*\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0012J4\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0012J\b\u0010\u000f\u001a\u00020\u0007H\u0012J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0012J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J(\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0017J0\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0017J&\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J2\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0017J>\u0010\u0005\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u0017J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J \u0010\u0005\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016R\u0014\u0010 \u001a\u00020\u001e8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\t\u0010\"R.\u0010%\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u00028\u0012@\u0012X\u0092.¢\u0006\u0006\n\u0004\b\u0006\u0010$R.\u0010'\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u00028\u0012@\u0012X\u0092.¢\u0006\u0006\n\u0004\b&\u0010$R.\u0010(\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u00028\u0012@\u0012X\u0092.¢\u0006\u0006\n\u0004\b\u0018\u0010$R\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0012@\u0012X\u0092.¢\u0006\u0006\n\u0004\b)\u0010$R\u001b\u0010-\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b\u0006\u0010,R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\b\u0010$R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010$R!\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118RX\u0092\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010+\u001a\u0004\b&\u00100R\"\u00104\u001a\u00020\u00038\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u0016\u00102\u001a\u0004\b)\u0010,\"\u0004\b&\u00103R*\u0010;\u001a\u0002052\u0006\u00106\u001a\u0002058\u0016@TX\u0096\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b*\u00109\"\u0004\b\u0005\u0010:R\u0014\u0010<\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010,¨\u0006A"}, d2 = {"Lio/didomi/sdk/n7;", "", "", "", "customContent", "a", "c", "", "h", "b", "additionalMacros", "contentBeforeMacros", "macros", "Lio/didomi/sdk/gc;", "transform", "j", "languageCode", "", "languages", "language", SubscriberAttributeKt.JSON_NAME_KEY, "", "k", "Lio/didomi/sdk/m7;", "e", "i", "", "allVendors", "iabVendors", "nonIABVendors", "Lio/didomi/sdk/e0;", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/ib;", "Lio/didomi/sdk/ib;", "resourcesHelper", "Ljava/util/Map;", "consolidatedTexts", "d", "distributedTexts", "textsConfiguration", "f", "g", "Lkotlin/Lazy;", "()Ljava/lang/String;", "defaultLanguage", "defaultCountriesBySdk", "fallbackCodesBySdk", "()Ljava/util/Set;", "enabledAndAvailableLanguages", "Ljava/lang/String;", "(Ljava/lang/String;)V", "selectedLanguageCode", "Ljava/util/Locale;", "<set-?>", "l", "Ljava/util/Locale;", "()Ljava/util/Locale;", "(Ljava/util/Locale;)V", "selectedLocale", "selectedLanguage", "Lio/didomi/sdk/DidomiInitializeParameters;", "initializeParameters", "<init>", "(Lio/didomi/sdk/e0;Lio/didomi/sdk/ib;Lio/didomi/sdk/DidomiInitializeParameters;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class n7 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e0 configurationRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final ib resourcesHelper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private Map<String, ? extends Map<String, String>> consolidatedTexts;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private Map<String, ? extends Map<String, String>> distributedTexts;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private Map<String, ? extends Map<String, String>> textsConfiguration;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private Map<String, String> macros;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Lazy defaultLanguage;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Map<String, String> defaultCountriesBySdk;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Map<String, String> fallbackCodesBySdk;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Lazy enabledAndAvailableLanguages;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public String selectedLanguageCode;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private Locale selectedLocale;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0 {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return n7.this.configurationRepository.b().getLanguages().getDefaultLanguage();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "a", "()Ljava/util/Set;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<String> invoke() {
            n7 n7Var = n7.this;
            Set<String> setA = n7Var.a(n7Var.configurationRepository.b().getLanguages().b());
            Set<String> setA2 = n7.this.configurationRepository.f().g().a();
            ArrayList arrayList = new ArrayList();
            for (Object obj : setA) {
                if (s7.a.a(setA2, (String) obj)) {
                    arrayList.add(obj);
                }
            }
            return CollectionsKt.toSet(arrayList);
        }
    }

    public n7(e0 configurationRepository, ib resourcesHelper, DidomiInitializeParameters initializeParameters) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(resourcesHelper, "resourcesHelper");
        Intrinsics.checkNotNullParameter(initializeParameters, "initializeParameters");
        this.configurationRepository = configurationRepository;
        this.resourcesHelper = resourcesHelper;
        this.defaultLanguage = LazyKt.lazy(new a());
        this.defaultCountriesBySdk = configurationRepository.f().g().b();
        this.fallbackCodesBySdk = configurationRepository.f().g().d();
        this.enabledAndAvailableLanguages = LazyKt.lazy(new b());
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        this.selectedLocale = locale;
        j();
        h();
        String str = initializeParameters.languageCode;
        if (str != null) {
            e(str);
        }
    }

    private Set<String> d() {
        return (Set) this.enabledAndAvailableLanguages.getValue();
    }

    private void h() {
        this.distributedTexts = a();
        this.textsConfiguration = this.configurationRepository.b().h();
        Map<String, ? extends Map<String, String>> map = this.distributedTexts;
        Map<String, ? extends Map<String, String>> map2 = null;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distributedTexts");
            map = null;
        }
        Map<String, ? extends Map<String, String>> mutableMap = MapsKt.toMutableMap(map);
        Map<String, ? extends Map<String, String>> map3 = this.textsConfiguration;
        if (map3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textsConfiguration");
        } else {
            map2 = map3;
        }
        mutableMap.putAll(map2);
        this.consolidatedTexts = mutableMap;
        this.macros = b();
    }

    private void j() {
        s7 s7Var = s7.a;
        boolean zA = s7Var.a(d(), c());
        String strA = s7Var.a(d(), this.defaultCountriesBySdk, this.fallbackCodesBySdk, Locale.getDefault());
        if (strA == null) {
            strA = "";
        }
        if (wg.a.b(strA)) {
            c(strA);
            return;
        }
        if (zA) {
            c(c());
        } else if (d().isEmpty()) {
            c(this.configurationRepository.f().g().getDefaultLanguage());
        } else {
            c((String) CollectionsKt.first(d()));
        }
    }

    public Map<String, String> b(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, ? extends Map<String, String>> map = this.consolidatedTexts;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consolidatedTexts");
            map = null;
        }
        return map.get(key);
    }

    public String c() {
        return (String) this.defaultLanguage.getValue();
    }

    public String e() {
        return t7.a(getSelectedLocale());
    }

    public String f() {
        String str = this.selectedLanguageCode;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("selectedLanguageCode");
        return null;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public Locale getSelectedLocale() {
        return this.selectedLocale;
    }

    public void i() {
        j();
        h();
    }

    public boolean k() {
        String strB = s7.a.b(e());
        String str = this.defaultCountriesBySdk.get(strB);
        return Intrinsics.areEqual(e(), strB + '-' + str);
    }

    private Map<String, String> b() {
        AppConfiguration.App aVarA = this.configurationRepository.b().getApp();
        return MapsKt.mapOf(TuplesKt.to("{privacyPolicyURL}", aVarA.getPrivacyPolicyURL()), TuplesKt.to("{websiteName}", aVarA.getName()), TuplesKt.to("\"{website_name}\"", aVarA.getName()));
    }

    private String c(Map<String, String> customContent) {
        if (k()) {
            String strB = s7.a.b(e());
            if (customContent != null) {
                return customContent.get(strB);
            }
        }
        return null;
    }

    protected void a(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<set-?>");
        this.selectedLocale = locale;
    }

    public void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedLanguageCode = str;
    }

    public m7 e(String languageCode) {
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        wg wgVar = wg.a;
        if (!wgVar.b(languageCode)) {
            Log.e$default("Error, language '" + languageCode + "' doesn't fit the requested format", null, 2, null);
            return m7.InvalidCode;
        }
        s7 s7Var = s7.a;
        String strA = s7Var.a(d(), this.configurationRepository.f().g().b(), this.configurationRepository.f().g().d(), s7Var.a(languageCode));
        if (strA == null) {
            strA = "";
        }
        if (!wgVar.b(strA)) {
            Log.e$default("Error, language '" + languageCode + "' is not supported or not enabled.", null, 2, null);
            return m7.NotEnabled;
        }
        try {
            c(strA);
            h();
            return m7.Success;
        } catch (Exception unused) {
            Log.e$default("Error, language '" + strA + "' is not supported.", null, 2, null);
            i();
            return m7.NotEnabled;
        }
    }

    public String a(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        String str = this.defaultCountriesBySdk.get(language);
        if (str == null || str.length() == 0) {
            return language;
        }
        return language + '-' + str;
    }

    private void c(String languageCode) {
        a(s7.a.a(languageCode));
        d(languageCode);
    }

    public static /* synthetic */ String a(n7 n7Var, Map map, gc gcVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCustomTranslation");
        }
        if ((i & 2) != 0) {
            gcVar = gc.NONE;
        }
        return n7Var.a((Map<String, String>) map, gcVar);
    }

    public String a(Map<String, String> customContent, gc transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        String strA = a(customContent);
        String strA2 = strA != null ? fc.a(strA, transform, getSelectedLocale()) : null;
        return strA2 == null ? "" : strA2;
    }

    public static /* synthetic */ String a(n7 n7Var, Map map, String str, gc gcVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCustomTranslationWithDefault");
        }
        if ((i & 4) != 0) {
            gcVar = gc.NONE;
        }
        return n7Var.a((Map<String, String>) map, str, gcVar);
    }

    private Map<String, String> b(Map<String, String> additionalMacros) {
        Map<String, String> map = this.macros;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macros");
            map = null;
        }
        Map<String, String> mutableMap = MapsKt.toMutableMap(map);
        if (additionalMacros != null && !additionalMacros.isEmpty()) {
            mutableMap.putAll(additionalMacros);
        }
        return mutableMap;
    }

    public String a(Map<String, String> customContent, String key, gc transform) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(transform, "transform");
        String strA = a(customContent);
        Map<String, String> map = this.macros;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macros");
            map = null;
        }
        String strA2 = a(strA, map, transform);
        return strA2 == null ? a(this, key, transform, null, null, 12, null) : strA2;
    }

    private String a(Map<String, String> customContent) {
        String str;
        return (customContent == null || (str = customContent.get(f())) == null) ? c(customContent) : str;
    }

    public String a(Map<String, String> customContent, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String strA = a(customContent);
        return strA == null ? a(this, key, null, null, null, 14, null) : strA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String a(n7 n7Var, String str, gc gcVar, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTranslatedText");
        }
        if ((i & 2) != 0) {
            gcVar = gc.NONE;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        return n7Var.a(str, gcVar, (Map<String, String>) map);
    }

    public String a(String key, gc transform, Map<String, String> additionalMacros) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Map<String, String> mapB = b(key);
        String strA = a(mapB != null ? mapB.get(e()) : null, b(additionalMacros), transform);
        if (strA != null && !StringsKt.isBlank(strA)) {
            return strA;
        }
        if (k()) {
            String strB = s7.a.b(e());
            Map<String, String> mapB2 = b(key);
            String strA2 = a(mapB2 != null ? mapB2.get(strB) : null, b(additionalMacros), transform);
            if (strA2 != null && !StringsKt.isBlank(strA2)) {
                return strA2;
            }
        }
        Map<String, String> mapB3 = b(key);
        String strA3 = a(mapB3 != null ? mapB3.get(c()) : null, b(additionalMacros), transform);
        if (strA3 != null && !StringsKt.isBlank(strA3)) {
            return strA3;
        }
        String strA4 = a(key, transform, additionalMacros, e());
        if (!StringsKt.isBlank(strA4)) {
            return strA4;
        }
        String strA5 = a(key, transform, additionalMacros, c());
        return !StringsKt.isBlank(strA5) ? strA5 : key;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String a(n7 n7Var, String str, gc gcVar, Map map, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTranslation");
        }
        if ((i & 2) != 0) {
            gcVar = gc.NONE;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            str2 = n7Var.e();
        }
        return n7Var.a(str, gcVar, map, str2);
    }

    public String a(String key, gc transform, Map<String, String> additionalMacros, String language) {
        String strA;
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(language, "language");
        if (key == null || StringsKt.isBlank(key)) {
            return "";
        }
        String strA2 = this.resourcesHelper.a(key, language);
        return (strA2 == null || (strA = a(strA2, b(additionalMacros), transform)) == null) ? key : strA;
    }

    private Map<String, Map<String, String>> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AppConfiguration.Preferences.Content aVarB = this.configurationRepository.b().getPreferences().getContent();
        Map<String, String> mapA = aVarB.a();
        if (mapA == null) {
            mapA = MapsKt.emptyMap();
        }
        Pair pair = TuplesKt.to("preferences.content.agreeToAll", mapA);
        Map<String, String> mapD = aVarB.d();
        if (mapD == null) {
            mapD = MapsKt.emptyMap();
        }
        Pair pair2 = TuplesKt.to("preferences.content.disagreeToAll", mapD);
        Map<String, String> mapG = aVarB.g();
        if (mapG == null) {
            mapG = MapsKt.emptyMap();
        }
        Pair pair3 = TuplesKt.to("preferences.content.save", mapG);
        Map<String, String> mapJ = aVarB.j();
        if (mapJ == null) {
            mapJ = MapsKt.emptyMap();
        }
        Pair pair4 = TuplesKt.to("preferences.content.text", mapJ);
        Map<String, String> mapL = aVarB.l();
        if (mapL == null) {
            mapL = MapsKt.emptyMap();
        }
        Pair pair5 = TuplesKt.to("preferences.content.title", mapL);
        Map<String, String> mapK = aVarB.k();
        if (mapK == null) {
            mapK = MapsKt.emptyMap();
        }
        Pair pair6 = TuplesKt.to("preferences.content.textVendors", mapK);
        Map<String, String> mapI = aVarB.i();
        if (mapI == null) {
            mapI = MapsKt.emptyMap();
        }
        linkedHashMap.putAll(MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, TuplesKt.to("preferences.content.subTextVendors", mapI)));
        AppConfiguration.Notice.Content bVarA = this.configurationRepository.b().getNotice().getContent();
        linkedHashMap.putAll(MapsKt.mapOf(TuplesKt.to("notice.content.notice", bVarA.e()), TuplesKt.to("notice.content.dismiss", bVarA.a()), TuplesKt.to("notice.content.learnMore", bVarA.c())));
        return linkedHashMap;
    }

    private String a(String contentBeforeMacros, Map<String, String> macros, gc transform) {
        if (contentBeforeMacros == null) {
            return null;
        }
        if (StringsKt.isBlank(contentBeforeMacros)) {
            return "";
        }
        String strReplace$default = contentBeforeMacros;
        for (Map.Entry<String, String> entry : macros.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null && !StringsKt.isBlank(value)) {
                strReplace$default = StringsKt.replace$default(StringsKt.replace$default(strReplace$default, '%' + key, value, false, 4, (Object) null), key, value, false, 4, (Object) null);
            }
        }
        return fc.a(strReplace$default, transform, getSelectedLocale());
    }

    public void a(int allVendors, int iabVendors, int nonIABVendors) {
        Map<String, String> map = this.macros;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macros");
            map = null;
        }
        Map<String, String> mutableMap = MapsKt.toMutableMap(map);
        mutableMap.put("{numberOfPartners}", String.valueOf(allVendors));
        mutableMap.put("{numberOfIABPartners}", String.valueOf(iabVendors));
        mutableMap.put("{numberOfNonIABPartners}", String.valueOf(nonIABVendors));
        this.macros = mutableMap;
    }

    public Set<String> a(Set<String> languages) {
        Intrinsics.checkNotNullParameter(languages, "languages");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(languages, 10));
        Iterator<T> it = languages.iterator();
        while (it.hasNext()) {
            arrayList.add(a((String) it.next()));
        }
        return CollectionsKt.toSet(arrayList);
    }
}
