package expo.modules.kotlin;

import expo.modules.ExpoModulesPackageList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ExpoModulesHelper {
    public static final Companion Companion = new Companion(null);
    private static final Lazy modulesProvider$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.ExpoModulesHelper$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ExpoModulesHelper.modulesProvider_delegate$lambda$0();
        }
    });

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ModulesProvider getModulesProvider() {
            return (ModulesProvider) ExpoModulesHelper.modulesProvider$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModulesProvider modulesProvider_delegate$lambda$0() {
        try {
            ExpoModulesPackageList.Companion companion = ExpoModulesPackageList.Companion;
            Object objNewInstance = ExpoModulesPackageList.class.getConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type expo.modules.kotlin.ModulesProvider");
            return (ModulesProvider) objNewInstance;
        } catch (Exception unused) {
            return null;
        }
    }
}
