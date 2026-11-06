package expo.modules.imagepicker;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import androidx.core.net.UriKt;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.core.utilities.FileUtilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.InterruptibleKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ImagePickerUtilsKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Bitmap.CompressFormat.JPEG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final File createOutputFile(File cacheDir, String extension) throws IOException, FailedToCreateFileException {
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        Intrinsics.checkNotNullParameter(extension, "extension");
        String strGenerateOutputPath = FileUtilities.generateOutputPath(cacheDir, "ImagePicker", extension);
        try {
            File file = new File(strGenerateOutputPath);
            file.createNewFile();
            return file;
        } catch (IOException e) {
            Intrinsics.checkNotNull(strGenerateOutputPath);
            throw new FailedToCreateFileException(strGenerateOutputPath, e);
        }
    }

    public static final String getType(final ContentResolver contentResolver, final Uri uri) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Function0 function0 = new Function0() { // from class: expo.modules.imagepicker.ImagePickerUtilsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImagePickerUtilsKt.getType$lambda$2(contentResolver, uri);
            }
        };
        String type = contentResolver.getType(uri);
        if (type != null) {
            return type;
        }
        String str = (String) function0.invoke();
        if (str != null) {
            return str;
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return getTypeFromFileUrl(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getType$lambda$2(ContentResolver contentResolver, Uri uri) throws IOException {
        int columnIndex;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) CollectionsKt.listOf("mime_type").toArray(new String[0]), null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            String string = (!cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("mime_type")) == -1 || cursorQuery.isNull(columnIndex)) ? null : cursorQuery.getString(columnIndex);
            CloseableKt.closeFinally(cursorQuery, null);
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursorQuery, th);
                throw th2;
            }
        }
    }

    private static final String getTypeFromFileUrl(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public static final Uri getContentUri(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".ImagePickerFileProvider", file);
        Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(...)");
        return uriForFile;
    }

    public static final Uri toContentUri(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return getContentUri(file, context);
        } catch (Exception unused) {
            Uri uriFromFile = Uri.fromFile(file);
            Intrinsics.checkNotNull(uriFromFile);
            return uriFromFile;
        }
    }

    public static final Bitmap.CompressFormat toBitmapCompressFormat(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return StringsKt.endsWith(FilesKt.getExtension(file), "png", true) ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    public static final String toImageFileExtension(Bitmap.CompressFormat compressFormat) {
        Intrinsics.checkNotNullParameter(compressFormat, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[compressFormat.ordinal()];
        if (i == 1) {
            return ".png";
        }
        if (i == 2) {
            return ".jpeg";
        }
        throw new RuntimeException("Compress format not supported '" + compressFormat.name() + "'");
    }

    public static final String toImageFileExtension(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.endsWith(str, "png", true)) {
            return ".png";
        }
        if (StringsKt.endsWith(str, "gif", true)) {
            return ".gif";
        }
        if (StringsKt.endsWith(str, "bmp", true)) {
            return ".bmp";
        }
        if (StringsKt.endsWith(str, "webp", true)) {
            return ".webp";
        }
        StringsKt.endsWith(str, "jpeg", true);
        return ".jpeg";
    }

    public static final MediaType toMediaType(Uri uri, ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        String type = getType(contentResolver, uri);
        if (type != null && StringsKt.contains$default((CharSequence) type, (CharSequence) "image/", false, 2, (Object) null)) {
            return MediaType.IMAGE;
        }
        if (type == null || !StringsKt.contains$default((CharSequence) type, (CharSequence) "video/", false, 2, (Object) null)) {
            return null;
        }
        return MediaType.VIDEO;
    }

    public static final Bitmap.CompressFormat toBitmapCompressFormat(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.endsWith(str, "png", true) || StringsKt.endsWith(str, "gif", true) || StringsKt.endsWith(str, "bmp", true) || StringsKt.endsWith(str, "webp", true)) {
            return Bitmap.CompressFormat.PNG;
        }
        StringsKt.endsWith(str, "jpeg", true);
        return Bitmap.CompressFormat.JPEG;
    }

    public static final int extractInt(MediaMetadataRetriever mediaMetadataRetriever, int i) throws FailedToExtractVideoMetadataException {
        Intrinsics.checkNotNullParameter(mediaMetadataRetriever, "<this>");
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(i);
        if (strExtractMetadata != null) {
            return Integer.parseInt(strExtractMetadata);
        }
        throw new FailedToExtractVideoMetadataException(null, null, 3, null);
    }

    public static final Iterable getItems(ClipData clipData) {
        Intrinsics.checkNotNullParameter(clipData, "<this>");
        return new ImagePickerUtilsKt$items$1(clipData);
    }

    public static final List getAllDataUris(Intent intent) {
        Iterable items;
        Intrinsics.checkNotNullParameter(intent, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Uri data = intent.getData();
        if (data != null) {
            linkedHashSet.add(data);
        }
        ClipData clipData = intent.getClipData();
        if (clipData != null && (items = getItems(clipData)) != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            Iterator it = items.iterator();
            while (it.hasNext()) {
                arrayList.add(((ClipData.Item) it.next()).getUri());
            }
            linkedHashSet.addAll(arrayList);
        }
        return CollectionsKt.toList(linkedHashSet);
    }

    public static final Object copyFile(final Uri uri, final File file, final ContentResolver contentResolver, Continuation continuation) {
        return InterruptibleKt.runInterruptible$default(null, new Function0() { // from class: expo.modules.imagepicker.ImagePickerUtilsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImagePickerUtilsKt.copyFile$lambda$9(file, uri, contentResolver);
            }
        }, continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyFile$lambda$9(File file, Uri uri, ContentResolver contentResolver) throws FailedToWriteFileException, FailedToReadFileException, IOException {
        if (uri.compareTo(Uri.fromFile(file)) == 0) {
            return Unit.INSTANCE;
        }
        try {
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        ByteStreamsKt.copyTo$default(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, null);
                        CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                        return unit;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(fileOutputStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(inputStreamOpenInputStream, th3);
                        throw th4;
                    }
                }
            }
            throw new FailedToReadFileException(UriKt.toFile(uri), null, 2, null);
        } catch (FileNotFoundException e) {
            throw new FailedToWriteFileException(file, e);
        }
    }

    public static final Object copyExifData(final Uri uri, final File file, final ContentResolver contentResolver, Continuation continuation) {
        return InterruptibleKt.runInterruptible$default(null, new Function0() { // from class: expo.modules.imagepicker.ImagePickerUtilsKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImagePickerUtilsKt.copyExifData$lambda$15(file, uri, contentResolver);
            }
        }, continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyExifData$lambda$15(File file, Uri uri, ContentResolver contentResolver) throws FailedToWriteFileException, FailedToReadFileException, IOException {
        if (uri.compareTo(Uri.fromFile(file)) == 0) {
            return Unit.INSTANCE;
        }
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"ImageLength", "ImageWidth", "PixelXDimension", "PixelYDimension", "Orientation"});
        try {
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                try {
                    ExifInterface exifInterface = new ExifInterface(inputStreamOpenInputStream);
                    ExifInterface exifInterface2 = new ExifInterface(file);
                    Iterable exif_tags = ImagePickerConstants.INSTANCE.getEXIF_TAGS();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : exif_tags) {
                        if (!listListOf.contains((String) ((Pair) obj).getSecond())) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str = (String) ((Pair) it.next()).getSecond();
                        arrayList2.add(TuplesKt.to(str, exifInterface.getAttribute(str)));
                    }
                    ArrayList<Pair> arrayList3 = new ArrayList();
                    for (Object obj2 : arrayList2) {
                        if (((String) ((Pair) obj2).getSecond()) != null) {
                            arrayList3.add(obj2);
                        }
                    }
                    for (Pair pair : arrayList3) {
                        exifInterface2.setAttribute((String) pair.getFirst(), (String) pair.getSecond());
                    }
                    try {
                        exifInterface2.saveAttributes();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                        return Unit.INSTANCE;
                    } catch (IOException e) {
                        throw new FailedToWriteExifDataToFileException(file, e);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStreamOpenInputStream, th);
                        throw th2;
                    }
                }
            }
            throw new FailedToReadFileException(UriKt.toFile(uri), null, 2, null);
        } catch (FileNotFoundException e2) {
            throw new FailedToWriteFileException(file, e2);
        }
    }

    public static final boolean isMediaProviderUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(uri.getAuthority(), "com.android.providers.media.documents");
    }

    public static final boolean isDownloadsProviderUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(uri.getAuthority(), "com.android.providers.downloads.documents");
    }

    public static final boolean isMediaStoreAssetUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        if (isMediaProviderUri(uri)) {
            return true;
        }
        if (isDownloadsProviderUri(uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            Intrinsics.checkNotNullExpressionValue(documentId, "getDocumentId(...)");
            if (StringsKt.startsWith$default(documentId, "msf:", false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public static final String getMediaStoreAssetId(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        if (!isMediaStoreAssetUri(uri)) {
            return null;
        }
        String documentId = DocumentsContract.getDocumentId(uri);
        Intrinsics.checkNotNull(documentId);
        return StringsKt.contains$default((CharSequence) documentId, ':', false, 2, (Object) null) ? (String) StringsKt.split$default((CharSequence) documentId, new char[]{':'}, false, 0, 6, (Object) null).get(1) : documentId;
    }
}
