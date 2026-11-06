package expo.modules.imagepicker.exporters;

import android.content.ContentResolver;
import android.net.Uri;
import java.io.File;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public interface ImageExporter {
    Object exportAsync(Uri uri, File file, ContentResolver contentResolver, Continuation continuation);
}
