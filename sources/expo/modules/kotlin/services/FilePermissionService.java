package expo.modules.kotlin.services;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\nH\u0014J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/services/FilePermissionService;", "Lexpo/modules/kotlin/services/Service;", "<init>", "()V", "getPathPermissions", "Ljava/util/EnumSet;", "Lexpo/modules/kotlin/services/FilePermissionService$Permission;", "context", "Landroid/content/Context;", "path", "", "getInternalPathPermissions", "getExternalPathPermissions", "getInternalPaths", "", "Permission", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FilePermissionService implements Service {

    public enum Permission {
        READ,
        WRITE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public EnumSet getPathPermissions(Context context, String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        EnumSet internalPathPermissions = getInternalPathPermissions(path, context);
        return internalPathPermissions == null ? getExternalPathPermissions(path) : internalPathPermissions;
    }

    private final EnumSet getInternalPathPermissions(String path, Context context) {
        Object next;
        String str;
        try {
            String canonicalPath = new File(path).getCanonicalPath();
            Iterator it = getInternalPaths(context).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                str = (String) next;
                Intrinsics.checkNotNull(canonicalPath);
                if (StringsKt.startsWith$default(canonicalPath, str + "/", false, 2, (Object) null)) {
                    break;
                }
            } while (!Intrinsics.areEqual(str, canonicalPath));
            if (((String) next) != null) {
                return EnumSet.of(Permission.READ, Permission.WRITE);
            }
            return null;
        } catch (IOException unused) {
            return EnumSet.noneOf(Permission.class);
        }
    }

    protected EnumSet getExternalPathPermissions(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        EnumSet enumSetNoneOf = EnumSet.noneOf(Permission.class);
        if (file.canRead()) {
            enumSetNoneOf.add(Permission.READ);
        }
        if (file.canWrite()) {
            enumSetNoneOf.add(Permission.WRITE);
        }
        Intrinsics.checkNotNullExpressionValue(enumSetNoneOf, "apply(...)");
        return enumSetNoneOf;
    }

    private final List getInternalPaths(Context context) {
        return CollectionsKt.listOf((Object[]) new String[]{context.getFilesDir().getCanonicalPath(), context.getCacheDir().getCanonicalPath()});
    }
}
