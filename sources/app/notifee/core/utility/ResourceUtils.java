package app.notifee.core.utility;

import android.R;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.TypedValue;
import app.notifee.core.ContextHolder;
import app.notifee.core.Logger;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ResourceUtils {
    private static volatile Map sResourceIdCache;

    public static Map getResourceIdCache() {
        if (sResourceIdCache == null) {
            synchronized (ResourceUtils.class) {
                try {
                    if (sResourceIdCache == null) {
                        sResourceIdCache = new HashMap();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sResourceIdCache;
    }

    public static Uri getImageSourceUri(String str) {
        try {
            Uri uri = Uri.parse(str);
            return uri.getScheme() == null ? getResourceDrawableUri(str) : uri;
        } catch (Exception unused) {
            return getResourceDrawableUri(str);
        }
    }

    public static Uri getResourceDrawableUri(String str) {
        int resourceIdByName = getResourceIdByName(str, "drawable");
        if (resourceIdByName > 0) {
            return new Uri.Builder().scheme("res").path(String.valueOf(resourceIdByName)).build();
        }
        return Uri.EMPTY;
    }

    public static Bitmap getCircularBitmap(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap;
        Rect rect;
        float f;
        Rect rect2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            bitmapCreateBitmap = Bitmap.createBitmap(height, height, Bitmap.Config.ARGB_8888);
            int i = (width - height) / 2;
            rect = new Rect(i, 0, i + height, height);
            rect2 = new Rect(0, 0, height, height);
            f = height / 2;
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
            int i2 = (height - width) / 2;
            rect = new Rect(0, i2, width, i2 + width);
            f = width / 2;
            rect2 = new Rect(0, 0, width, width);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-65536);
        canvas.drawCircle(f, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return bitmapCreateBitmap;
    }

    public static ListenableFuture getImageBitmapFromUrl(final String str) {
        Uri imageSourceUri;
        final SettableFuture settableFutureCreate = SettableFuture.create();
        if (!str.contains("/")) {
            String imageResourceUrl = getImageResourceUrl(str);
            if (imageResourceUrl == null) {
                settableFutureCreate.set(null);
                return settableFutureCreate;
            }
            imageSourceUri = getImageSourceUri(imageResourceUrl);
        } else {
            imageSourceUri = getImageSourceUri(str);
        }
        ImageRequest imageRequestBuild = ImageRequestBuilder.newBuilderWithSource(imageSourceUri).build();
        if (!Fresco.hasBeenInitialized()) {
            Logger.w("ResourceUtils", "Fresco initializing natively by Notifee");
            Fresco.initialize(ContextHolder.getApplicationContext());
        }
        Fresco.getImagePipeline().fetchDecodedImage(imageRequestBuild, ContextHolder.getApplicationContext()).subscribe(new BaseBitmapDataSubscriber() { // from class: app.notifee.core.utility.ResourceUtils.1
            @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
            protected void onNewResultImpl(Bitmap bitmap) {
                if (bitmap == null) {
                    settableFutureCreate.set(null);
                    return;
                }
                Bitmap.Config config = bitmap.getConfig();
                if (config == null) {
                    config = Bitmap.Config.ARGB_8888;
                }
                settableFutureCreate.set(bitmap.copy(config, false));
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onFailureImpl(DataSource dataSource) {
                Logger.e("ResourceUtils", "Failed to load an image: " + str, dataSource.getFailureCause());
                settableFutureCreate.set(null);
            }
        }, CallerThreadExecutor.getInstance());
        return settableFutureCreate;
    }

    private static String getImageResourceUrl(String str) {
        int resourceIdByName = getResourceIdByName(str, "mipmap");
        if (resourceIdByName == 0) {
            resourceIdByName = getResourceIdByName(str, "drawable");
        }
        if (resourceIdByName == 0) {
            return null;
        }
        if (resourceIdByName > 0) {
            return new Uri.Builder().scheme("res").path(String.valueOf(resourceIdByName)).build().toString();
        }
        return Uri.EMPTY.toString();
    }

    public static int getImageResourceId(String str) {
        int resourceIdByName = getResourceIdByName(str, "mipmap");
        return resourceIdByName == 0 ? getResourceIdByName(str, "drawable") : resourceIdByName;
    }

    public static int getFallbackSmallIconId(Context context) {
        if (context == null) {
            return R.drawable.ic_dialog_info;
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return R.drawable.ic_dialog_info;
            }
            int i = applicationInfo.icon;
            if (i != 0) {
                return i;
            }
            int i2 = applicationInfo.logo;
            return i2 != 0 ? i2 : R.drawable.ic_dialog_info;
        } catch (Exception e) {
            Logger.w("ResourceUtils", "getFallbackSmallIconId -> falling back to system default icon", e);
            return R.drawable.ic_dialog_info;
        }
    }

    private static int getResourceIdByName(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String strReplace = str.toLowerCase(Locale.ROOT).replace("-", "_");
        String str3 = strReplace + "_" + str2;
        synchronized (ResourceUtils.class) {
            try {
                if (getResourceIdCache().containsKey(str3)) {
                    return ((Integer) getResourceIdCache().get(str3)).intValue();
                }
                Context applicationContext = ContextHolder.getApplicationContext();
                int identifier = applicationContext.getResources().getIdentifier(strReplace, str2, applicationContext.getPackageName());
                getResourceIdCache().put(str3, Integer.valueOf(identifier));
                return identifier;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String getSoundName(Uri uri) {
        if (uri != null && uri.toString().contains("android.resource")) {
            String lastPathSegment = uri.getLastPathSegment();
            try {
                int iIntValue = Integer.valueOf(lastPathSegment).intValue();
                Logger.e("ResourceUtils", "Loaded sound by resource id. New app builds will fail to play sound. Create a new channel to resolve. Issue #341");
                if (iIntValue != 0) {
                    TypedValue typedValue = new TypedValue();
                    ContextHolder.getApplicationContext().getResources().getValue(iIntValue, typedValue, true);
                    CharSequence charSequence = typedValue.string;
                    if (charSequence != null || charSequence.length() > 0) {
                        return charSequence.toString().replace("res/raw/", "");
                    }
                }
            } catch (NumberFormatException unused) {
                return lastPathSegment;
            }
        }
        return null;
    }

    public static Uri getSoundUri(String str) {
        Context applicationContext = ContextHolder.getApplicationContext();
        if (str == null) {
            return null;
        }
        if (str.contains("://")) {
            return Uri.parse(str);
        }
        if (str.equalsIgnoreCase("default")) {
            return RingtoneManager.getDefaultUri(2);
        }
        int resourceIdByName = getResourceIdByName(str, "raw");
        if (resourceIdByName == 0 && str.contains(".")) {
            resourceIdByName = getResourceIdByName(str.substring(0, str.lastIndexOf(46)), "raw");
        }
        if (resourceIdByName == 0) {
            return null;
        }
        return Uri.parse("android.resource://" + applicationContext.getPackageName() + "/raw/" + str);
    }
}
