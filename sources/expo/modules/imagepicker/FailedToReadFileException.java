package expo.modules.imagepicker;

import android.net.Uri;
import expo.modules.kotlin.exception.CodedException;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FailedToReadFileException extends CodedException {
    public /* synthetic */ FailedToReadFileException(File file, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FailedToReadFileException(File file, Throwable th) {
        super("Failed to read a file '" + Uri.fromFile(file), th);
        Intrinsics.checkNotNullParameter(file, "file");
    }
}
