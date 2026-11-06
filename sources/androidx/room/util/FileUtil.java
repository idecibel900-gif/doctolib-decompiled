package androidx.room.util;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class FileUtil {
    public static final void copy(ReadableByteChannel input, FileChannel output) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        try {
            output.transferFrom(input, 0L, Long.MAX_VALUE);
            output.force(false);
        } finally {
            input.close();
            output.close();
        }
    }
}
