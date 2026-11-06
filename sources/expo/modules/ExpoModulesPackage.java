package expo.modules;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import expo.modules.adapters.react.ModuleRegistryAdapter;
import expo.modules.core.ModulePriorities;
import expo.modules.core.interfaces.Package;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
public final class ExpoModulesPackage implements ReactPackage {
    public static final Companion Companion = new Companion(null);
    private static final Lazy packageList$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.ExpoModulesPackage$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ExpoModulesPackage.packageList_delegate$lambda$1();
        }
    });
    private final ModuleRegistryAdapter moduleRegistryAdapter = new ModuleRegistryAdapter(Companion.getPackageList());

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List getPackageList() {
            return (List) ExpoModulesPackage.packageList$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List packageList_delegate$lambda$1() {
        try {
            ExpoModulesPackageList.Companion companion = ExpoModulesPackageList.Companion;
            Object objInvoke = ExpoModulesPackageList.class.getMethod("getPackageList", null).invoke(null, null);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<expo.modules.core.interfaces.Package>");
            return CollectionsKt.sortedWith((List) objInvoke, new Comparator() { // from class: expo.modules.ExpoModulesPackage$packageList_delegate$lambda$1$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    ModulePriorities modulePriorities = ModulePriorities.INSTANCE;
                    return ComparisonsKt.compareValues(Integer.valueOf(modulePriorities.get(Reflection.getOrCreateKotlinClass(((Package) obj2).getClass()).getQualifiedName())), Integer.valueOf(modulePriorities.get(Reflection.getOrCreateKotlinClass(((Package) obj).getClass()).getQualifiedName())));
                }
            });
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.facebook.react.ReactPackage
    public List createNativeModules(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        List listCreateNativeModules = this.moduleRegistryAdapter.createNativeModules(reactContext);
        Intrinsics.checkNotNullExpressionValue(listCreateNativeModules, "createNativeModules(...)");
        return listCreateNativeModules;
    }

    @Override // com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        List listCreateViewManagers = this.moduleRegistryAdapter.createViewManagers(reactContext);
        Intrinsics.checkNotNullExpressionValue(listCreateViewManagers, "createViewManagers(...)");
        return listCreateViewManagers;
    }
}
