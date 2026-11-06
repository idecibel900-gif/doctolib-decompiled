package expo.modules.imagepicker;

import android.net.Uri;
import expo.modules.kotlin.exception.CodedException;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class FailedToExtractVideoMetadataException extends CodedException {
    public /* synthetic */ FailedToExtractVideoMetadataException(File file, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : file, (i & 2) != 0 ? null : th);
    }

    public FailedToExtractVideoMetadataException(File file, Throwable th) {
        Uri uriFromFile;
        String string;
        super("Failed to extract metadata from video file '" + ((file == null || (uriFromFile = Uri.fromFile(file)) == null || (string = uriFromFile.toString()) == null) ? "" : string) + "'", th);
    }
}
