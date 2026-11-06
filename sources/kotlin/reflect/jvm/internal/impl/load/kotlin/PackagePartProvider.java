package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public interface PackagePartProvider {
    List findPackageParts(String str);

    public static final class Empty implements PackagePartProvider {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider
        public List findPackageParts(String packageFqName) {
            Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
            return CollectionsKt.emptyList();
        }
    }
}
