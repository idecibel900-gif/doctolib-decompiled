package expo.modules.imagepicker;

import android.net.Uri;
import expo.modules.kotlin.exception.CodedException;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FailedToWriteExifDataToFileException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FailedToWriteExifDataToFileException(File file, Throwable cause) {
        super("Failed to write EXIF data to file '" + Uri.fromFile(file), cause);
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
