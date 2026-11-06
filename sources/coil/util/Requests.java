package coil.util;

import android.graphics.drawable.Drawable;
import coil.request.DefaultRequestOptions;
import coil.request.ImageRequest;
import coil.size.DisplaySizeResolver;
import coil.size.Precision;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: coil.util.-Requests, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Requests {
    private static final DefaultRequestOptions DEFAULT_REQUEST_OPTIONS = new DefaultRequestOptions(null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, 32767, null);

    /* JADX INFO: renamed from: coil.util.-Requests$WhenMappings */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Precision.values().length];
            try {
                iArr[Precision.EXACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Precision.INEXACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Precision.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DefaultRequestOptions getDEFAULT_REQUEST_OPTIONS() {
        return DEFAULT_REQUEST_OPTIONS;
    }

    public static final Drawable getDrawableCompat(ImageRequest imageRequest, Drawable drawable, Integer num, Drawable drawable2) {
        if (drawable != null) {
            return drawable;
        }
        if (num == null) {
            return drawable2;
        }
        if (num.intValue() == 0) {
            return null;
        }
        return Contexts.getDrawableCompat(imageRequest.getContext(), num.intValue());
    }

    public static final boolean getAllowInexactSize(ImageRequest imageRequest) {
        int i = WhenMappings.$EnumSwitchMapping$0[imageRequest.getPrecision().ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (imageRequest.getDefined().getSizeResolver() == null && (imageRequest.getSizeResolver() instanceof DisplaySizeResolver)) {
            return true;
        }
        imageRequest.getTarget();
        return false;
    }
}
