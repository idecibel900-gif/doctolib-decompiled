package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes5.dex */
public interface PackageViewDescriptorFactory {
    public static final Companion Companion = Companion.$$INSTANCE;

    PackageViewDescriptor compute(ModuleDescriptorImpl moduleDescriptorImpl, FqName fqName, StorageManager storageManager);

    public static final class Default implements PackageViewDescriptorFactory {
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory
        public PackageViewDescriptor compute(ModuleDescriptorImpl module, FqName fqName, StorageManager storageManager) {
            Intrinsics.checkNotNullParameter(module, "module");
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            return new LazyPackageViewDescriptorImpl(module, fqName, storageManager);
        }
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ModuleCapability CAPABILITY = new ModuleCapability("PackageViewDescriptorFactory");

        private Companion() {
        }

        public final ModuleCapability getCAPABILITY() {
            return CAPABILITY;
        }
    }
}
