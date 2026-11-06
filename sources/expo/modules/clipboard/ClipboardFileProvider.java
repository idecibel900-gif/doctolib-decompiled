package expo.modules.clipboard;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.amazon.a.a.o.c.a.b;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt;
import net.openid.appauth.AuthorizationRequest;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0003'()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016JM\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J;\u0010\u001f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010!J1\u0010\"\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010#J\u001a\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0006H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lexpo/modules/clipboard/ClipboardFileProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "defaultProjectionColumns", "", "", "[Ljava/lang/String;", "strategy", "Lexpo/modules/clipboard/ClipboardFileProvider$PathStrategy;", "onCreate", "", "attachInfo", "", "context", "Landroid/content/Context;", "info", "Landroid/content/pm/ProviderInfo;", "getType", "uri", "Landroid/net/Uri;", AuthorizationRequest.ResponseMode.QUERY, "Landroid/database/Cursor;", "projection", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "insert", "values", "Landroid/content/ContentValues;", "update", "", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "openFile", "Landroid/os/ParcelFileDescriptor;", "mode", "Companion", "PathStrategy", "SimplePathStrategy", "expo-clipboard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClipboardFileProvider extends ContentProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final File DEVICE_ROOT = new File("/");
    private static final HashMap cache = new HashMap();
    private final String[] defaultProjectionColumns = {"_display_name", "_size"};
    private PathStrategy strategy;

    public interface PathStrategy {
        File getFileForUri(Uri uri);

        Uri getUriForFile(File file);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        super.attachInfo(context, info);
        Companion companion = INSTANCE;
        String authority = info.authority;
        Intrinsics.checkNotNullExpressionValue(authority, "authority");
        this.strategy = companion.getPathStrategy$expo_clipboard_release(context, authority);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        PathStrategy pathStrategy = this.strategy;
        if (pathStrategy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strategy");
            pathStrategy = null;
        }
        File fileForUri = pathStrategy.getFileForUri(uri);
        String name = fileForUri.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) name, b.a, 0, false, 6, (Object) null);
        if (iLastIndexOf$default >= 0) {
            String name2 = fileForUri.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            String strSubstring = name2.substring(iLastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(strSubstring);
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int i;
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (projection == null) {
            projection = this.defaultProjectionColumns;
        }
        PathStrategy pathStrategy = this.strategy;
        if (pathStrategy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strategy");
            pathStrategy = null;
        }
        File fileForUri = pathStrategy.getFileForUri(uri);
        String[] strArr = new String[projection.length];
        Object[] objArr = new Object[projection.length];
        int i2 = 0;
        for (String str : projection) {
            if (Intrinsics.areEqual(str, "_display_name")) {
                strArr[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = fileForUri.getName();
            } else {
                if (Intrinsics.areEqual(str, "_size")) {
                    strArr[i2] = "_size";
                    i = i2 + 1;
                    objArr[i2] = Long.valueOf(fileForUri.length());
                }
            }
            i2 = i;
        }
        Object[] objArrCopyOf = Arrays.copyOf(strArr, i2);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, i2);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(...)");
        MatrixCursor matrixCursor = new MatrixCursor((String[]) objArrCopyOf, 1);
        matrixCursor.addRow(objArrCopyOf2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("This is a read-only provider");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("This is a read-only provider");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("This is a read-only provider");
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String mode) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (!Intrinsics.areEqual("r", mode)) {
            throw new IllegalArgumentException("mode must be \"r\"");
        }
        PathStrategy pathStrategy = this.strategy;
        if (pathStrategy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strategy");
            pathStrategy = null;
        }
        return ParcelFileDescriptor.open(pathStrategy.getFileForUri(uri), 268435456);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Uri getUriForFile(Context context, String authority, File file) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(authority, "authority");
            Intrinsics.checkNotNullParameter(file, "file");
            return getPathStrategy$expo_clipboard_release(context, authority).getUriForFile(file);
        }

        public final PathStrategy getPathStrategy$expo_clipboard_release(Context context, String authority) {
            PathStrategy pathStrategy;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(authority, "authority");
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            synchronized (ClipboardFileProvider.cache) {
                try {
                    pathStrategy = (PathStrategy) ClipboardFileProvider.cache.get(authority);
                    if (pathStrategy == null) {
                        try {
                            ref$ObjectRef.element = ClipboardFileProvider.INSTANCE.parsePathStrategy(context, authority);
                            ClipboardFileProvider.cache.put(authority, ref$ObjectRef.element);
                            pathStrategy = (PathStrategy) ref$ObjectRef.element;
                        } catch (IOException e) {
                            throw new IllegalArgumentException("Failed to parse expo.modules.clipboard.CLIPBOARD_FILE_PROVIDER_PATHS meta-data", e);
                        } catch (XmlPullParserException e2) {
                            throw new IllegalArgumentException("Failed to parse expo.modules.clipboard.CLIPBOARD_FILE_PROVIDER_PATHS meta-data", e2);
                        }
                    }
                    ref$ObjectRef.element = pathStrategy;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return pathStrategy;
        }

        private final PathStrategy parsePathStrategy(Context context, String str) throws XmlPullParserException, IOException {
            SimplePathStrategy simplePathStrategy = new SimplePathStrategy(str);
            PackageManager packageManager = context.getPackageManager();
            ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 128);
            if (providerInfoResolveContentProvider == null) {
                throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
            }
            XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(packageManager, "expo.modules.clipboard.CLIPBOARD_FILE_PROVIDER_PATHS");
            if (xmlResourceParserLoadXmlMetaData == null) {
                throw new IllegalArgumentException("Missing expo.modules.clipboard.CLIPBOARD_FILE_PROVIDER_PATHS meta-data");
            }
            while (true) {
                int next = xmlResourceParserLoadXmlMetaData.next();
                if (next == 1) {
                    return simplePathStrategy;
                }
                if (next == 2) {
                    String name = xmlResourceParserLoadXmlMetaData.getName();
                    Intrinsics.checkNotNull(name);
                    File fileTargetFileFromTag = targetFileFromTag(name, context);
                    if (fileTargetFileFromTag != null) {
                        simplePathStrategy.addRoot(xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name"), ClipboardFileProvider.INSTANCE.buildPath(fileTargetFileFromTag, xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path")));
                    }
                }
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private final File targetFileFromTag(String str, Context context) {
            switch (str.hashCode()) {
                case -1642807877:
                    if (str.equals("files-path")) {
                        return context.getFilesDir();
                    }
                    return null;
                case -1360690478:
                    if (str.equals("external-cache-path")) {
                        File[] externalCacheDirs = context.getExternalCacheDirs();
                        Intrinsics.checkNotNullExpressionValue(externalCacheDirs, "getExternalCacheDirs(...)");
                        if (externalCacheDirs.length == 0) {
                            externalCacheDirs = null;
                        }
                        if (externalCacheDirs != null) {
                            return externalCacheDirs[0];
                        }
                        return null;
                    }
                    return null;
                case -913292752:
                    if (str.equals("root-path")) {
                        return ClipboardFileProvider.DEVICE_ROOT;
                    }
                    return null;
                case -50149145:
                    if (str.equals("external-path")) {
                        return Environment.getExternalStorageDirectory();
                    }
                    return null;
                case -17221744:
                    if (str.equals("cache-path")) {
                        return context.getCacheDir();
                    }
                    return null;
                case 1308690685:
                    if (str.equals("external-files-path")) {
                        File[] externalFilesDirs = context.getExternalFilesDirs(null);
                        Intrinsics.checkNotNullExpressionValue(externalFilesDirs, "getExternalFilesDirs(...)");
                        if (externalFilesDirs.length == 0) {
                            externalFilesDirs = null;
                        }
                        if (externalFilesDirs != null) {
                            return externalFilesDirs[0];
                        }
                        return null;
                    }
                    return null;
                default:
                    return null;
            }
        }

        private final File buildPath(File file, String... strArr) {
            for (String str : strArr) {
                if (str != null) {
                    file = new File(file, str);
                }
            }
            return file;
        }
    }

    public static final class SimplePathStrategy implements PathStrategy {
        private final String authority;
        private final HashMap roots;

        public SimplePathStrategy(String authority) {
            Intrinsics.checkNotNullParameter(authority, "authority");
            this.authority = authority;
            this.roots = new HashMap();
        }

        public final void addRoot(String str, File root) {
            Intrinsics.checkNotNullParameter(root, "root");
            if (str == null || TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.roots.put(str, root.getCanonicalFile());
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + root, e);
            }
        }

        @Override // expo.modules.clipboard.ClipboardFileProvider.PathStrategy
        public Uri getUriForFile(File file) {
            String strSubstring;
            Intrinsics.checkNotNullParameter(file, "file");
            try {
                String canonicalPath = file.getCanonicalPath();
                Intrinsics.checkNotNull(canonicalPath);
                Map.Entry entry = null;
                for (Object obj : this.roots.entrySet()) {
                    Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                    Map.Entry entry2 = (Map.Entry) obj;
                    String path = ((File) entry2.getValue()).getPath();
                    Intrinsics.checkNotNull(path);
                    if (StringsKt.startsWith$default(canonicalPath, path, false, 2, (Object) null) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException(("Failed to find configured root that contains " + ((Object) canonicalPath)).toString());
                }
                String path2 = ((File) entry.getValue()).getPath();
                Intrinsics.checkNotNull(path2);
                if (StringsKt.endsWith$default(path2, "/", false, 2, (Object) null)) {
                    strSubstring = canonicalPath.substring(path2.length());
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                } else {
                    strSubstring = canonicalPath.substring(path2.length() + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                }
                return new Uri.Builder().scheme("content").authority(this.authority).encodedPath(Uri.encode((String) entry.getKey()) + "/" + Uri.encode(strSubstring, "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // expo.modules.clipboard.ClipboardFileProvider.PathStrategy
        public File getFileForUri(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            String encodedPath = uri.getEncodedPath();
            Intrinsics.checkNotNull(encodedPath);
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) encodedPath, '/', 1, false, 4, (Object) null);
            String strSubstring = encodedPath.substring(1, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strDecode = Uri.decode(strSubstring);
            String strSubstring2 = encodedPath.substring(iIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            String strDecode2 = Uri.decode(strSubstring2);
            Intrinsics.checkNotNullExpressionValue(strDecode2, "decode(...)");
            File file = (File) this.roots.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                Intrinsics.checkNotNull(canonicalFile);
                if (FilesKt.startsWith(canonicalFile, file)) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }
    }
}
