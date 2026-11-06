package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.activity.result.PickVisualMediaRequest;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class ActivityResultContracts$PickVisualMedia extends ActivityResultContract {
    public static final Companion Companion = new Companion(null);

    public static final class MediaCapabilities {
    }

    public interface VisualMediaType {
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, PickVisualMediaRequest input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        return null;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isSystemPickerAvailable$activity_release() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 33) {
                return true;
            }
            return i >= 30 && SdkExtensions.getExtensionVersion(30) >= 2;
        }

        public final boolean isSystemFallbackPickerAvailable$activity_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getSystemFallbackPicker$activity_release(context) != null;
        }

        public final ResolveInfo getSystemFallbackPicker$activity_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
        }

        public final String getVisualMimeType$activity_release(VisualMediaType input) {
            Intrinsics.checkNotNullParameter(input, "input");
            if (input instanceof ImageOnly) {
                return "image/*";
            }
            if (input instanceof VideoOnly) {
                return "video/*";
            }
            if (input instanceof ImageAndVideo) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class ImageOnly implements VisualMediaType {
        public static final ImageOnly INSTANCE = new ImageOnly();

        private ImageOnly() {
        }
    }

    public static final class VideoOnly implements VisualMediaType {
        public static final VideoOnly INSTANCE = new VideoOnly();

        private VideoOnly() {
        }
    }

    public static final class ImageAndVideo implements VisualMediaType {
        public static final ImageAndVideo INSTANCE = new ImageAndVideo();

        private ImageAndVideo() {
        }
    }

    public static abstract class DefaultTab {
        public /* synthetic */ DefaultTab(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract int getValue();

        private DefaultTab() {
        }

        public static final class PhotosTab extends DefaultTab {
            public static final PhotosTab INSTANCE = new PhotosTab();
            private static final int value = 1;

            private PhotosTab() {
                super(null);
            }

            @Override // androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia.DefaultTab
            public int getValue() {
                return value;
            }
        }

        public static final class AlbumsTab extends DefaultTab {
            public static final AlbumsTab INSTANCE = new AlbumsTab();
            private static final int value = 0;

            private AlbumsTab() {
                super(null);
            }

            @Override // androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia.DefaultTab
            public int getValue() {
                return value;
            }
        }
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, PickVisualMediaRequest input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        Companion companion = Companion;
        if (companion.isSystemPickerAvailable$activity_release()) {
            Intent intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
            intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", input.getDefaultTab().getValue());
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
            intent2.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", input.getDefaultTab().getValue());
            if (input.isCustomAccentColorApplied()) {
                intent2.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_ACCENT_COLOR", input.getAccentColor());
            }
            return intent2;
        }
        Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent3.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
        if (intent3.getType() == null) {
            intent3.setType("*/*");
            intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        }
        return intent3;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public final Uri parseResult(int i, Intent intent) {
        if (i != -1) {
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        Uri data = intent.getData();
        return data == null ? (Uri) CollectionsKt.firstOrNull(ActivityResultContracts$GetMultipleContents.Companion.getClipDataUris$activity_release(intent)) : data;
    }
}
