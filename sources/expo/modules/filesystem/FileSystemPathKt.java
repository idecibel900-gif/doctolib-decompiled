package expo.modules.filesystem;

import android.net.Uri;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FileSystemPathKt {
    public static final void validateFileSystemChildName(String name) throws UnableToCreateException {
        Intrinsics.checkNotNullParameter(name, "name");
        if (name.length() != 0 && !Intrinsics.areEqual(name, ".") && !Intrinsics.areEqual(name, "..")) {
            for (int i = 0; i < name.length(); i++) {
                char cCharAt = name.charAt(i);
                if (cCharAt != '/' && cCharAt != '\\') {
                }
            }
            return;
        }
        throw new UnableToCreateException("child name must be a single path segment");
    }

    public static final boolean isContentUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(uri.getScheme(), "content");
    }

    public static final boolean isAssetUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(uri.getScheme(), "asset");
    }

    public static final String slashifyFilePath(String str) {
        if (str == null) {
            return null;
        }
        return StringsKt.startsWith$default(str, "file:///", false, 2, (Object) null) ? str : Pattern.compile("^file:/*").matcher(str).replaceAll("file:///");
    }
}
