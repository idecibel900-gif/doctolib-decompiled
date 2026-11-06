package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.provider.MediaStore;
import androidx.activity.result.PickVisualMediaRequest;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class ActivityResultContracts$PickMultipleVisualMedia extends ActivityResultContract {
    public static final Companion Companion = new Companion(null);
    private final int maxItems;

    @Override // androidx.activity.result.contract.ActivityResultContract
    public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, PickVisualMediaRequest input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        return null;
    }

    public /* synthetic */ ActivityResultContracts$PickMultipleVisualMedia(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Companion.getMaxItems$activity_release() : i);
    }

    public ActivityResultContracts$PickMultipleVisualMedia(int i) {
        this.maxItems = i;
        if (i <= 1) {
            throw new IllegalArgumentException("Max items must be higher than 1");
        }
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, PickVisualMediaRequest input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        ActivityResultContracts$PickVisualMedia.Companion companion = ActivityResultContracts$PickVisualMedia.Companion;
        if (companion.isSystemPickerAvailable$activity_release()) {
            Intent intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
            int iMin = Math.min(this.maxItems, input.getMaxItems());
            if (iMin <= 1 || iMin > MediaStore.getPickImagesMaxLimit()) {
                throw new IllegalArgumentException("Max items must be greater than 1 and lesser than or equal to MediaStore.getPickImagesMaxLimit()");
            }
            intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", iMin);
            intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", input.getDefaultTab().getValue());
            intent.putExtra("android.provider.extra.PICK_IMAGES_IN_ORDER", input.isOrderedSelection());
            if (input.isCustomAccentColorApplied()) {
                intent.putExtra("android.provider.extra.PICK_IMAGES_ACCENT_COLOR", input.getAccentColor());
            }
            if (Build.VERSION.SDK_INT >= 33) {
                input.getMediaCapabilitiesForTranscoding();
            }
            return intent;
        }
        if (companion.isSystemFallbackPickerAvailable$activity_release(context)) {
            ResolveInfo systemFallbackPicker$activity_release = companion.getSystemFallbackPicker$activity_release(context);
            if (systemFallbackPicker$activity_release == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ActivityInfo activityInfo = systemFallbackPicker$activity_release.activityInfo;
            Intent intent2 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
            intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent2.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
            int iMin2 = Math.min(this.maxItems, input.getMaxItems());
            if (iMin2 <= 1) {
                throw new IllegalArgumentException("Max items must be greater than 1");
            }
            intent2.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_MAX", iMin2);
            intent2.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", input.getDefaultTab().getValue());
            intent2.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_IN_ORDER", input.isOrderedSelection());
            if (input.isCustomAccentColorApplied()) {
                intent2.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_ACCENT_COLOR", input.getAccentColor());
            }
            return intent2;
        }
        Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent3.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
        intent3.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        if (intent3.getType() == null) {
            intent3.setType("*/*");
            intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        }
        return intent3;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public final List parseResult(int i, Intent intent) {
        List clipDataUris$activity_release;
        if (i != -1) {
            intent = null;
        }
        return (intent == null || (clipDataUris$activity_release = ActivityResultContracts$GetMultipleContents.Companion.getClipDataUris$activity_release(intent)) == null) ? CollectionsKt.emptyList() : clipDataUris$activity_release;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getMaxItems$activity_release() {
            if (ActivityResultContracts$PickVisualMedia.Companion.isSystemPickerAvailable$activity_release()) {
                return MediaStore.getPickImagesMaxLimit();
            }
            return Integer.MAX_VALUE;
        }
    }
}
