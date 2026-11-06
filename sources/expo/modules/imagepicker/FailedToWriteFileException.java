package expo.modules.imagepicker;

import android.net.Uri;
import expo.modules.kotlin.exception.CodedException;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public final class FailedToWriteFileException extends CodedException {
    public FailedToWriteFileException(File file, Throwable th) {
        Uri uriFromFile;
        String string;
        super("Failed to write a file '" + ((file == null || (uriFromFile = Uri.fromFile(file)) == null || (string = uriFromFile.toString()) == null) ? "" : string) + "'", th);
    }
}
