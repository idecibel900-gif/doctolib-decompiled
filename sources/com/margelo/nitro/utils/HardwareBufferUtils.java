package com.margelo.nitro.utils;

import android.hardware.HardwareBuffer;
import androidx.annotation.Keep;
import com.facebook.proguard.annotations.DoNotStrip;
import com.margelo.nitro.core.ArrayBuffer$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/margelo/nitro/utils/HardwareBufferUtils;", "", "<init>", "()V", "Companion", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HardwareBufferUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native Object copyHardwareBuffer(Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native void copyHardwareBuffer(Object obj, Object obj2);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object copyHardwareBuffer(Object obj) {
            return HardwareBufferUtils.copyHardwareBuffer(obj);
        }

        private Companion() {
        }

        public final HardwareBuffer copyHardwareBuffer(HardwareBuffer hardwareBuffer) {
            Intrinsics.checkNotNullParameter(hardwareBuffer, "hardwareBuffer");
            Object objCopyHardwareBuffer = copyHardwareBuffer((Object) hardwareBuffer);
            Intrinsics.checkNotNull(objCopyHardwareBuffer, "null cannot be cast to non-null type android.hardware.HardwareBuffer");
            return ArrayBuffer$$ExternalSyntheticApiModelOutline0.m(objCopyHardwareBuffer);
        }
    }
}
