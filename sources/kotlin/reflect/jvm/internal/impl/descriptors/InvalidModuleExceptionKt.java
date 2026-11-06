package kotlin.reflect.jvm.internal.impl.descriptors;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class InvalidModuleExceptionKt {
    private static final ModuleCapability INVALID_MODULE_NOTIFIER_CAPABILITY = new ModuleCapability("InvalidModuleNotifier");

    public static final void moduleInvalidated(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(moduleDescriptor.getCapability(INVALID_MODULE_NOTIFIER_CAPABILITY));
        throw new InvalidModuleException("Accessing invalid module descriptor " + moduleDescriptor);
    }
}
