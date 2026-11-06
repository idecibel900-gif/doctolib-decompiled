package expo.modules.filesystem;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import expo.modules.filesystem.unifiedfile.AssetFile;
import expo.modules.filesystem.unifiedfile.JavaFile;
import expo.modules.filesystem.unifiedfile.SAFDocumentFile;
import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions$ReactContextLost;
import expo.modules.kotlin.services.FilePermissionService;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0000¢\u0006\u0004\b \u0010\u001fJ\u0015\u0010!\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\u0005R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0011\u0010,\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u0010/\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0013\u00103\u001a\u0004\u0018\u0001008F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0013\u00105\u001a\u0004\u0018\u0001008F¢\u0006\u0006\u001a\u0004\b4\u00102¨\u00066"}, d2 = {"Lexpo/modules/filesystem/FileSystemPath;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "Landroid/net/Uri;", "uri", "<init>", "(Landroid/net/Uri;)V", "", "newName", "renamedUri", "(Ljava/lang/String;)Landroid/net/Uri;", "", "delete", "()V", "validateType", "destination", "Ljava/io/File;", "getMoveOrCopyPath", "(Lexpo/modules/filesystem/FileSystemPath;)Ljava/io/File;", "Lexpo/modules/kotlin/services/FilePermissionService$Permission;", "permission", "validatePermission", "(Lexpo/modules/kotlin/services/FilePermissionService$Permission;)V", "", "checkPermission", "(Lexpo/modules/kotlin/services/FilePermissionService$Permission;)Z", "Lexpo/modules/filesystem/CreateOptions;", "options", "validateCanCreate", "(Lexpo/modules/filesystem/CreateOptions;)V", "to", "copy", "(Lexpo/modules/filesystem/FileSystemPath;)V", "move", "rename", "(Ljava/lang/String;)V", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "fileAdapter", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "getFile", "()Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "file", "getJavaFile", "()Ljava/io/File;", "javaFile", "", "getModificationTime", "()Ljava/lang/Long;", "modificationTime", "getCreationTime", "creationTime", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class FileSystemPath extends SharedObject {
    private UnifiedFileInterface fileAdapter;
    private Uri uri;

    public abstract void validateType();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemPath(Uri uri) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final UnifiedFileInterface getFile() {
        UnifiedFileInterface javaFile;
        Context reactContext;
        Context reactContext2;
        UnifiedFileInterface unifiedFileInterface = this.fileAdapter;
        if (Intrinsics.areEqual(unifiedFileInterface != null ? unifiedFileInterface.getUri() : null, this.uri)) {
            return unifiedFileInterface;
        }
        if (FileSystemPathKt.isContentUri(this.uri)) {
            AppContext appContext = getAppContext();
            if (appContext == null || (reactContext2 = appContext.getReactContext()) == null) {
                throw new Exception("No context");
            }
            javaFile = new SAFDocumentFile(reactContext2, this.uri);
        } else if (FileSystemPathKt.isAssetUri(this.uri)) {
            AppContext appContext2 = getAppContext();
            if (appContext2 == null || (reactContext = appContext2.getReactContext()) == null) {
                throw new Exception("No context");
            }
            javaFile = new AssetFile(reactContext, this.uri);
        } else {
            javaFile = new JavaFile(this.uri);
        }
        this.fileAdapter = javaFile;
        return javaFile;
    }

    public final File getJavaFile() throws Exception {
        if (FileSystemPathKt.isContentUri(this.uri)) {
            throw new Exception("This method cannot be used with content URIs: " + this.uri);
        }
        Object file = getFile();
        Intrinsics.checkNotNull(file, "null cannot be cast to non-null type java.io.File");
        return (File) file;
    }

    public final void delete() throws UnableToDeleteException {
        validatePermission(FilePermissionService.Permission.WRITE);
        if (!getFile().exists()) {
            throw new UnableToDeleteException("uri '" + getFile().getUri() + "' does not exist");
        }
        if (getFile().isDirectory()) {
            if (getFile().deleteRecursively()) {
                return;
            }
            throw new UnableToDeleteException("failed to delete '" + getFile().getUri() + "'");
        }
        if (getFile().delete()) {
            return;
        }
        throw new UnableToDeleteException("failed to delete '" + getFile().getUri() + "'");
    }

    public final File getMoveOrCopyPath(FileSystemPath destination) throws CopyOrMoveDirectoryToFileException, DestinationDoesNotExistException {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination instanceof FileSystemDirectory) {
            if (this instanceof FileSystemFile) {
                if (!((FileSystemDirectory) destination).getExists()) {
                    throw new DestinationDoesNotExistException();
                }
                return new File(destination.getJavaFile(), getJavaFile().getName());
            }
            if (((FileSystemDirectory) destination).getExists()) {
                return new File(destination.getJavaFile(), getJavaFile().getName());
            }
            File parentFile = destination.getJavaFile().getParentFile();
            if (parentFile == null || !parentFile.exists()) {
                throw new DestinationDoesNotExistException();
            }
            return destination.getJavaFile();
        }
        if (!(this instanceof FileSystemFile)) {
            throw new CopyOrMoveDirectoryToFileException();
        }
        File parentFile2 = destination.getJavaFile().getParentFile();
        if (parentFile2 == null || !parentFile2.exists()) {
            throw new DestinationDoesNotExistException();
        }
        return destination.getJavaFile();
    }

    public final void validatePermission(FilePermissionService.Permission permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (!checkPermission(permission)) {
            throw new InvalidPermissionException(permission);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    public final boolean checkPermission(FilePermissionService.Permission permission) throws Exceptions$ReactContextLost {
        EnumSet enumSetNoneOf;
        FilePermissionService filePermission;
        Context reactContext;
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (FileSystemPathKt.isContentUri(this.uri) || FileSystemPathKt.isAssetUri(this.uri)) {
            return true;
        }
        AppContext appContext = getAppContext();
        if (appContext != null && (filePermission = appContext.getFilePermission()) != null) {
            AppContext appContext2 = getAppContext();
            if (appContext2 != null && (reactContext = appContext2.getReactContext()) != null) {
                String path = getJavaFile().getPath();
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                enumSetNoneOf = filePermission.getPathPermissions(reactContext, path);
                if (enumSetNoneOf == null) {
                    enumSetNoneOf = EnumSet.noneOf(FilePermissionService.Permission.class);
                }
            } else {
                throw new Exceptions$ReactContextLost();
            }
        } else {
            enumSetNoneOf = EnumSet.noneOf(FilePermissionService.Permission.class);
        }
        return enumSetNoneOf.contains(permission);
    }

    public final void validateCanCreate(CreateOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        if (!options.getOverwrite() && getFile().exists()) {
            throw new UnableToCreateException("it already exists");
        }
    }

    public final void copy(FileSystemPath to) {
        Intrinsics.checkNotNullParameter(to, "to");
        validateType();
        to.validateType();
        validatePermission(FilePermissionService.Permission.READ);
        to.validatePermission(FilePermissionService.Permission.WRITE);
        FilesKt.copyRecursively$default(getJavaFile(), getMoveOrCopyPath(to), false, null, 6, null);
    }

    public final void move(FileSystemPath to) throws CopyOrMoveDirectoryToFileException, DestinationDoesNotExistException {
        Intrinsics.checkNotNullParameter(to, "to");
        validateType();
        to.validateType();
        FilePermissionService.Permission permission = FilePermissionService.Permission.WRITE;
        validatePermission(permission);
        to.validatePermission(permission);
        if (Build.VERSION.SDK_INT >= 26) {
            File moveOrCopyPath = getMoveOrCopyPath(to);
            Path path = getJavaFile().toPath();
            Intrinsics.checkNotNullExpressionValue(path, "toPath(...)");
            Path path2 = moveOrCopyPath.toPath();
            Intrinsics.checkNotNullExpressionValue(path2, "toPath(...)");
            Intrinsics.checkNotNullExpressionValue(Files.move(path, path2, (CopyOption[]) Arrays.copyOf(new CopyOption[0], 0)), "move(...)");
            this.uri = Uri.fromFile(moveOrCopyPath);
            return;
        }
        FilesKt.copyTo$default(getJavaFile(), getMoveOrCopyPath(to), false, 0, 6, null);
        getJavaFile().delete();
        this.uri = Uri.fromFile(getMoveOrCopyPath(to));
    }

    public final void rename(String newName) throws IOException, UnableToCreateException {
        Intrinsics.checkNotNullParameter(newName, "newName");
        validateType();
        validatePermission(FilePermissionService.Permission.WRITE);
        FileSystemPathKt.validateFileSystemChildName(newName);
        File parentFile = getJavaFile().getParentFile();
        if (parentFile == null) {
            throw new UnableToCreateException("parent directory does not exist");
        }
        String canonicalPath = parentFile.getCanonicalPath();
        File file = new File(parentFile, newName);
        File parentFile2 = file.getCanonicalFile().getParentFile();
        if (!Intrinsics.areEqual(parentFile2 != null ? parentFile2.getCanonicalPath() : null, canonicalPath)) {
            throw new UnableToCreateException("child path escapes parent directory");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Path path = getJavaFile().toPath();
            Intrinsics.checkNotNullExpressionValue(path, "toPath(...)");
            Path path2 = file.toPath();
            Intrinsics.checkNotNullExpressionValue(path2, "toPath(...)");
            Intrinsics.checkNotNullExpressionValue(Files.move(path, path2, (CopyOption[]) Arrays.copyOf(new CopyOption[0], 0)), "move(...)");
        } else {
            FilesKt.copyTo$default(getJavaFile(), file, false, 0, 6, null);
            getJavaFile().delete();
        }
        this.uri = renamedUri(newName);
    }

    private final Uri renamedUri(String newName) {
        String string = this.uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strSubstring = string.substring(0, StringsKt.lastIndexOf$default((CharSequence) StringsKt.trimEnd(string, '/'), '/', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String string2 = Uri.withAppendedPath(Uri.parse(strSubstring), newName).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        if (this instanceof FileSystemDirectory) {
            string2 = string2 + "/";
        }
        Uri uri = Uri.parse(string2);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        return uri;
    }

    public final Long getModificationTime() {
        validateType();
        return getFile().lastModified();
    }

    public final Long getCreationTime() {
        return getFile().getCreationTime();
    }
}
