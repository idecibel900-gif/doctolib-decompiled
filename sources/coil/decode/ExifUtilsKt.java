package coil.decode;

import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ExifUtilsKt {
    private static final Set RESPECT_PERFORMANCE_MIME_TYPES = SetsKt.setOf((Object[]) new String[]{"image/jpeg", "image/webp", "image/heic", "image/heif"});

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExifOrientationPolicy.values().length];
            try {
                iArr[ExifOrientationPolicy.RESPECT_PERFORMANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExifOrientationPolicy.IGNORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExifOrientationPolicy.RESPECT_ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isSwapped(ExifData exifData) {
        return exifData.getRotationDegrees() == 90 || exifData.getRotationDegrees() == 270;
    }

    public static final boolean isRotated(ExifData exifData) {
        return exifData.getRotationDegrees() > 0;
    }

    public static final boolean supports(ExifOrientationPolicy exifOrientationPolicy, String str) {
        int i = WhenMappings.$EnumSwitchMapping$0[exifOrientationPolicy.ordinal()];
        if (i == 1) {
            return str != null && RESPECT_PERFORMANCE_MIME_TYPES.contains(str);
        }
        if (i == 2) {
            return false;
        }
        if (i == 3) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }
}
