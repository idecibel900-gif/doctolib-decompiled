package com.facebook.imagepipeline.common;

import com.facebook.common.util.HashCodeUtil;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class RotationOptions {
    public static final Companion Companion = new Companion(null);
    private static final RotationOptions ROTATION_OPTIONS_AUTO_ROTATE = new RotationOptions(-1, false);
    private static final RotationOptions ROTATION_OPTIONS_DISABLE_ROTATION = new RotationOptions(-2, false);
    private static final RotationOptions ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME = new RotationOptions(-1, true);
    private final boolean deferUntilRendered;
    private final int rotation;

    public static final RotationOptions autoRotate() {
        return Companion.autoRotate();
    }

    public static final RotationOptions disableRotation() {
        return Companion.disableRotation();
    }

    private RotationOptions(int i, boolean z) {
        this.rotation = i;
        this.deferUntilRendered = z;
    }

    public final boolean useImageMetadata() {
        return this.rotation == -1;
    }

    public final boolean rotationEnabled() {
        return this.rotation != -2;
    }

    public final int getForcedAngle() {
        if (useImageMetadata()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.rotation;
    }

    public final boolean canDeferUntilRendered() {
        return this.deferUntilRendered;
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(Integer.valueOf(this.rotation), Boolean.valueOf(this.deferUntilRendered));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RotationOptions)) {
            return false;
        }
        RotationOptions rotationOptions = (RotationOptions) obj;
        return this.rotation == rotationOptions.rotation && this.deferUntilRendered == rotationOptions.deferUntilRendered;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(null, "%d defer:%b", Arrays.copyOf(new Object[]{Integer.valueOf(this.rotation), Boolean.valueOf(this.deferUntilRendered)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RotationOptions autoRotate() {
            return RotationOptions.ROTATION_OPTIONS_AUTO_ROTATE;
        }

        public final RotationOptions disableRotation() {
            return RotationOptions.ROTATION_OPTIONS_DISABLE_ROTATION;
        }
    }
}
