package expo.modules.filesystem.legacy;

import java.util.regex.Pattern;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FileSystemLegacyModuleKt {
    private static final String TAG = FileSystemLegacyModule.class.getSimpleName();

    public static final String slashifyFilePath(String str) {
        if (str == null) {
            return null;
        }
        return StringsKt.startsWith$default(str, "file:///", false, 2, (Object) null) ? str : Pattern.compile("^file:/*").matcher(str).replaceAll("file:///");
    }
}
