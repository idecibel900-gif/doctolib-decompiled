package expo.modules.screencapture;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import expo.modules.core.interfaces.LifecycleEventListener;
import java.util.Locale;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ScreenshotEventEmitter implements LifecycleEventListener {
    private final ContentObserver contentObserver;
    private final Context context;
    private boolean isListening;
    private String previousPath;

    public ScreenshotEventEmitter(Context context, final Function0 onCapture) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onCapture, "onCapture");
        this.context = context;
        this.isListening = true;
        this.previousPath = "";
        final Handler handler = new Handler(Looper.getMainLooper());
        ContentObserver contentObserver = new ContentObserver(handler) { // from class: expo.modules.screencapture.ScreenshotEventEmitter$contentObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                super.onChange(z, uri);
                if (this.this$0.isListening) {
                    ScreenshotEventEmitter screenshotEventEmitter = this.this$0;
                    if (screenshotEventEmitter.hasPermissions(screenshotEventEmitter.getContext())) {
                        ScreenshotEventEmitter screenshotEventEmitter2 = this.this$0;
                        String filePathFromContentResolver = screenshotEventEmitter2.getFilePathFromContentResolver(screenshotEventEmitter2.getContext(), uri);
                        if (filePathFromContentResolver == null || !this.this$0.isPathOfNewScreenshot(filePathFromContentResolver)) {
                            return;
                        }
                        this.this$0.previousPath = filePathFromContentResolver;
                        onCapture.invoke();
                    }
                }
            }
        };
        this.contentObserver = contentObserver;
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, contentObserver);
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostResume() {
        this.isListening = true;
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostPause() {
        this.isListening = false;
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostDestroy() {
        this.context.getContentResolver().unregisterContentObserver(this.contentObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasPermissions(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            return ContextCompat.checkSelfPermission(context, "android.permission.DETECT_SCREEN_CAPTURE") == 0;
        }
        if (i >= 33) {
            return ContextCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES") == 0;
        }
        return ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFilePathFromContentResolver(Context context, Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                cursorQuery.close();
                return string;
            }
        } catch (Exception e) {
            e.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPathOfNewScreenshot(String str) {
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "screenshot", false, 2, (Object) null)) {
            String lowerCase2 = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) ".pending", false, 2, (Object) null) && (this.previousPath.length() == 0 || str.compareTo(this.previousPath) != 0)) {
                return true;
            }
        }
        return false;
    }
}
