package kotlin.reflect.jvm.internal.impl.resolve;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ResolutionAnchorProviderKt {
    private static final ModuleCapability RESOLUTION_ANCHOR_PROVIDER_CAPABILITY = new ModuleCapability("ResolutionAnchorProvider");

    public static final ModuleDescriptor getResolutionAnchorIfAny(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(moduleDescriptor.getCapability(RESOLUTION_ANCHOR_PROVIDER_CAPABILITY));
        return null;
    }
}
