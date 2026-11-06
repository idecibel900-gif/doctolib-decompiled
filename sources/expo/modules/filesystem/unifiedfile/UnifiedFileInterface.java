package expo.modules.filesystem.unifiedfile;

import android.net.Uri;
import expo.modules.kotlin.AppContext;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes4.dex */
public interface UnifiedFileInterface {
    UnifiedFileInterface createDirectory(String str);

    UnifiedFileInterface createFile(String str, String str2);

    boolean delete();

    boolean deleteRecursively();

    boolean exists();

    Uri getContentUri(AppContext appContext);

    Long getCreationTime();

    String getFileName();

    String getType();

    Uri getUri();

    InputStream inputStream();

    boolean isDirectory();

    boolean isFile();

    Long lastModified();

    long length();

    List listFilesAsUnified();

    OutputStream outputStream(boolean z);

    Sequence walkTopDown();
}
