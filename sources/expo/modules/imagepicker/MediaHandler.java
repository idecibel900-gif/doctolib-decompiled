package expo.modules.imagepicker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import expo.modules.imagepicker.exporters.CompressionImageExporter;
import expo.modules.imagepicker.exporters.ImageExportResult;
import expo.modules.imagepicker.exporters.ImageExporter;
import expo.modules.imagepicker.exporters.RawImageExporter;
import expo.modules.kotlin.providers.AppContextProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: loaded from: classes4.dex */
public final class MediaHandler {
    private final AppContextProvider appContextProvider;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: expo.modules.imagepicker.MediaHandler$handleImage$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return MediaHandler.this.handleImage(null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.imagepicker.MediaHandler$handleVideo$1, reason: invalid class name and case insensitive filesystem */
    static final class C10911 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10911(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return MediaHandler.this.handleVideo(null, this);
        }
    }

    public MediaHandler(AppContextProvider appContextProvider) {
        Intrinsics.checkNotNullParameter(appContextProvider, "appContextProvider");
        this.appContextProvider = appContextProvider;
    }

    private final Context getContext() {
        Context reactContext = this.appContextProvider.getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new IllegalArgumentException("React Application Context is null");
    }

    /* JADX WARN: Code duplicated, block: B:19:0x007d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0092  */
    /* JADX WARN: Code duplicated, block: B:22:0x0094  */
    /* JADX WARN: Code duplicated, block: B:24:0x009e  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:33:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b3 -> B:30:0x00b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00d6 -> B:39:0x00fd). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:24:0x009e
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object readExtras$expo_image_picker_release(java.util.List r26, expo.modules.imagepicker.ImagePickerOptions r27, kotlin.coroutines.Continuation r28) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.MediaHandler.readExtras$expo_image_picker_release(java.util.List, expo.modules.imagepicker.ImagePickerOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final File getCacheDirectory() {
        return this.appContextProvider.getAppContext().getCacheDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x011c  */
    /* JADX WARN: Code duplicated, block: B:40:0x012a  */
    /* JADX WARN: Code duplicated, block: B:45:0x013f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0142  */
    /* JADX WARN: Code duplicated, block: B:50:0x0160  */
    /* JADX WARN: Code duplicated, block: B:53:0x0170  */
    /* JADX WARN: Code duplicated, block: B:56:0x0191  */
    /* JADX WARN: Code duplicated, block: B:60:0x019b  */
    /* JADX WARN: Code duplicated, block: B:62:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object handleImage(Uri uri, ImagePickerOptions imagePickerOptions, Continuation continuation) throws IOException, FailedToCreateFileException {
        AnonymousClass1 anonymousClass1;
        ImageExporter compressionImageExporter;
        ImagePickerOptions imagePickerOptions2;
        String str;
        File file;
        ImageExportResult imageExportResult;
        Uri uri2;
        ImageExportResult imageExportResult2;
        ImagePickerOptions imagePickerOptions3;
        String str2;
        Boolean boolBoxBoolean;
        String str3;
        Object objExif;
        ImageExportResult imageExportResult3;
        String str4;
        Uri uri3;
        ByteArrayOutputStream byteArrayOutputStream;
        AdditionalFileData additionalFileData;
        String name;
        long length;
        Long fileSize;
        Uri uri4 = uri;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objExportAsync = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        Bundle bundle = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExportAsync);
            if (imagePickerOptions.getQuality() == 1.0d) {
                compressionImageExporter = new RawImageExporter();
            } else {
                compressionImageExporter = new CompressionImageExporter(this.appContextProvider, imagePickerOptions.getQuality());
            }
            ContentResolver contentResolver = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            String type = ImagePickerUtilsKt.getType(contentResolver, uri4);
            if (type == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            File fileCreateOutputFile = ImagePickerUtilsKt.createOutputFile(getCacheDirectory(), ImagePickerUtilsKt.toImageFileExtension(type));
            ContentResolver contentResolver2 = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver2, "getContentResolver(...)");
            anonymousClass1.L$0 = uri4;
            imagePickerOptions2 = imagePickerOptions;
            anonymousClass1.L$1 = imagePickerOptions2;
            anonymousClass1.L$2 = type;
            anonymousClass1.L$3 = fileCreateOutputFile;
            anonymousClass1.label = 1;
            objExportAsync = compressionImageExporter.exportAsync(uri4, fileCreateOutputFile, contentResolver2, anonymousClass1);
            if (objExportAsync != coroutine_suspended) {
                str = type;
                file = fileCreateOutputFile;
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            File file2 = (File) anonymousClass1.L$3;
            String str5 = (String) anonymousClass1.L$2;
            ImagePickerOptions imagePickerOptions4 = (ImagePickerOptions) anonymousClass1.L$1;
            Uri uri5 = (Uri) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objExportAsync);
            imagePickerOptions2 = imagePickerOptions4;
            str = str5;
            file = file2;
            uri4 = uri5;
        } else {
            if (i2 == 2) {
                imageExportResult2 = (ImageExportResult) anonymousClass1.L$4;
                file = (File) anonymousClass1.L$3;
                str = (String) anonymousClass1.L$2;
                imagePickerOptions3 = (ImagePickerOptions) anonymousClass1.L$1;
                uri2 = (Uri) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objExportAsync);
                byteArrayOutputStream = (ByteArrayOutputStream) objExportAsync;
                if (byteArrayOutputStream != null) {
                    String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    imageExportResult = imageExportResult2;
                    str2 = strEncodeToString;
                } else {
                    imageExportResult = imageExportResult2;
                    imagePickerOptions2 = imagePickerOptions3;
                    uri4 = uri2;
                    uri2 = uri4;
                    str2 = null;
                    imagePickerOptions3 = imagePickerOptions2;
                }
                boolBoxBoolean = Boxing.boxBoolean(imagePickerOptions3.getExif());
                if (!boolBoxBoolean.booleanValue()) {
                    boolBoxBoolean = null;
                }
                if (boolBoxBoolean != null) {
                    ContentResolver contentResolver3 = getContext().getContentResolver();
                    Intrinsics.checkNotNullExpressionValue(contentResolver3, "getContentResolver(...)");
                    anonymousClass1.L$0 = uri2;
                    anonymousClass1.L$1 = str;
                    anonymousClass1.L$2 = file;
                    anonymousClass1.L$3 = imageExportResult;
                    anonymousClass1.L$4 = str2;
                    anonymousClass1.label = 3;
                    objExif = imageExportResult.exif(contentResolver3, anonymousClass1);
                    if (objExif != coroutine_suspended) {
                        imageExportResult3 = imageExportResult;
                        objExportAsync = objExif;
                        str4 = str;
                        uri3 = uri2;
                    }
                    return coroutine_suspended;
                }
                str3 = str;
                String str6 = str2;
                Bundle bundle2 = bundle;
                additionalFileData = getAdditionalFileData(uri2);
                Uri uri6 = uri2;
                MediaType mediaType = MediaType.IMAGE;
                String string = Uri.fromFile(file).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                int width = imageExportResult.getWidth();
                int height = imageExportResult.getHeight();
                if (additionalFileData != null || (name = additionalFileData.getFileName()) == null) {
                    name = file.getName();
                }
                String str7 = name;
                if (additionalFileData != null || (fileSize = additionalFileData.getFileSize()) == null) {
                    length = file.length();
                } else {
                    length = fileSize.longValue();
                }
                return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri6), mediaType, string, width, height, str7, Boxing.boxLong(length), str3, str6, bundle2, null, null, 3072, null);
            }
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) anonymousClass1.L$4;
            imageExportResult3 = (ImageExportResult) anonymousClass1.L$3;
            file = (File) anonymousClass1.L$2;
            str4 = (String) anonymousClass1.L$1;
            uri3 = (Uri) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objExportAsync);
        }
        bundle = (Bundle) objExportAsync;
        uri2 = uri3;
        imageExportResult = imageExportResult3;
        str3 = str4;
        String str8 = str2;
        Bundle bundle3 = bundle;
        additionalFileData = getAdditionalFileData(uri2);
        Uri uri7 = uri2;
        MediaType mediaType2 = MediaType.IMAGE;
        String string2 = Uri.fromFile(file).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        int width2 = imageExportResult.getWidth();
        int height2 = imageExportResult.getHeight();
        if (additionalFileData != null) {
            name = file.getName();
        } else {
            name = file.getName();
        }
        String str9 = name;
        if (additionalFileData != null) {
            length = file.length();
        } else {
            length = file.length();
        }
        return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri7), mediaType2, string2, width2, height2, str9, Boxing.boxLong(length), str3, str8, bundle3, null, null, 3072, null);
        imageExportResult = (ImageExportResult) objExportAsync;
        Boolean boolBoxBoolean2 = Boxing.boxBoolean(imagePickerOptions2.getBase64());
        if (!boolBoxBoolean2.booleanValue()) {
            boolBoxBoolean2 = null;
        }
        if (boolBoxBoolean2 != null) {
            ContentResolver contentResolver4 = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver4, "getContentResolver(...)");
            anonymousClass1.L$0 = uri4;
            anonymousClass1.L$1 = imagePickerOptions2;
            anonymousClass1.L$2 = str;
            anonymousClass1.L$3 = file;
            anonymousClass1.L$4 = imageExportResult;
            anonymousClass1.label = 2;
            Object objData = imageExportResult.data(contentResolver4, anonymousClass1);
            if (objData != coroutine_suspended) {
                uri2 = uri4;
                imageExportResult2 = imageExportResult;
                objExportAsync = objData;
                imagePickerOptions3 = imagePickerOptions2;
                byteArrayOutputStream = (ByteArrayOutputStream) objExportAsync;
                if (byteArrayOutputStream != null) {
                    String strEncodeToString2 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    imageExportResult = imageExportResult2;
                    str2 = strEncodeToString2;
                } else {
                    imageExportResult = imageExportResult2;
                    imagePickerOptions2 = imagePickerOptions3;
                    uri4 = uri2;
                    uri2 = uri4;
                    str2 = null;
                    imagePickerOptions3 = imagePickerOptions2;
                }
                boolBoxBoolean = Boxing.boxBoolean(imagePickerOptions3.getExif());
                if (!boolBoxBoolean.booleanValue()) {
                    boolBoxBoolean = null;
                }
                if (boolBoxBoolean != null) {
                    ContentResolver contentResolver5 = getContext().getContentResolver();
                    Intrinsics.checkNotNullExpressionValue(contentResolver5, "getContentResolver(...)");
                    anonymousClass1.L$0 = uri2;
                    anonymousClass1.L$1 = str;
                    anonymousClass1.L$2 = file;
                    anonymousClass1.L$3 = imageExportResult;
                    anonymousClass1.L$4 = str2;
                    anonymousClass1.label = 3;
                    objExif = imageExportResult.exif(contentResolver5, anonymousClass1);
                    if (objExif != coroutine_suspended) {
                        imageExportResult3 = imageExportResult;
                        objExportAsync = objExif;
                        str4 = str;
                        uri3 = uri2;
                        bundle = (Bundle) objExportAsync;
                        uri2 = uri3;
                        imageExportResult = imageExportResult3;
                        str3 = str4;
                    }
                } else {
                    str3 = str;
                }
                String str10 = str2;
                Bundle bundle4 = bundle;
                additionalFileData = getAdditionalFileData(uri2);
                Uri uri8 = uri2;
                MediaType mediaType3 = MediaType.IMAGE;
                String string3 = Uri.fromFile(file).toString();
                Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                int width3 = imageExportResult.getWidth();
                int height3 = imageExportResult.getHeight();
                if (additionalFileData != null) {
                    name = file.getName();
                } else {
                    name = file.getName();
                }
                String str11 = name;
                if (additionalFileData != null) {
                    length = file.length();
                } else {
                    length = file.length();
                }
                return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri8), mediaType3, string3, width3, height3, str11, Boxing.boxLong(length), str3, str10, bundle4, null, null, 3072, null);
            }
        } else {
            uri2 = uri4;
            str2 = null;
            imagePickerOptions3 = imagePickerOptions2;
            boolBoxBoolean = Boxing.boxBoolean(imagePickerOptions3.getExif());
            if (!boolBoxBoolean.booleanValue()) {
                boolBoxBoolean = null;
            }
            if (boolBoxBoolean != null) {
                ContentResolver contentResolver6 = getContext().getContentResolver();
                Intrinsics.checkNotNullExpressionValue(contentResolver6, "getContentResolver(...)");
                anonymousClass1.L$0 = uri2;
                anonymousClass1.L$1 = str;
                anonymousClass1.L$2 = file;
                anonymousClass1.L$3 = imageExportResult;
                anonymousClass1.L$4 = str2;
                anonymousClass1.label = 3;
                objExif = imageExportResult.exif(contentResolver6, anonymousClass1);
                if (objExif != coroutine_suspended) {
                    imageExportResult3 = imageExportResult;
                    objExportAsync = objExif;
                    str4 = str;
                    uri3 = uri2;
                    bundle = (Bundle) objExportAsync;
                    uri2 = uri3;
                    imageExportResult = imageExportResult3;
                    str3 = str4;
                }
            } else {
                str3 = str;
            }
            String str12 = str2;
            Bundle bundle5 = bundle;
            additionalFileData = getAdditionalFileData(uri2);
            Uri uri9 = uri2;
            MediaType mediaType4 = MediaType.IMAGE;
            String string4 = Uri.fromFile(file).toString();
            Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
            int width4 = imageExportResult.getWidth();
            int height4 = imageExportResult.getHeight();
            if (additionalFileData != null) {
                name = file.getName();
            } else {
                name = file.getName();
            }
            String str13 = name;
            if (additionalFileData != null) {
                length = file.length();
            } else {
                length = file.length();
            }
            return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri9), mediaType4, string4, width4, height4, str13, Boxing.boxLong(length), str3, str12, bundle5, null, null, 3072, null);
        }
        return coroutine_suspended;
    }

    private final AdditionalFileData getAdditionalFileData(Uri uri) throws IOException {
        Object objM5243constructorimpl;
        Cursor cursorQuery = getContext().getContentResolver().query(uri, (String[]) CollectionsKt.listOf((Object[]) new String[]{"_display_name", "_size"}).toArray(new String[0]), null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (!cursorQuery.moveToFirst()) {
                CloseableKt.closeFinally(cursorQuery, null);
                return null;
            }
            try {
                Result.Companion companion = Result.Companion;
                Integer numValueOf = Integer.valueOf(cursorQuery.getColumnIndex("_display_name"));
                if (numValueOf.intValue() == -1) {
                    numValueOf = null;
                }
                String string = numValueOf != null ? cursorQuery.getString(numValueOf.intValue()) : null;
                Integer numValueOf2 = Integer.valueOf(cursorQuery.getColumnIndex("_size"));
                if (numValueOf2.intValue() == -1) {
                    numValueOf2 = null;
                }
                objM5243constructorimpl = Result.m5243constructorimpl(new AdditionalFileData(string, numValueOf2 != null ? Long.valueOf(cursorQuery.getLong(numValueOf2.intValue())) : null));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m5248isFailureimpl(objM5243constructorimpl)) {
                objM5243constructorimpl = null;
            }
            AdditionalFileData additionalFileData = (AdditionalFileData) objM5243constructorimpl;
            CloseableKt.closeFinally(cursorQuery, null);
            return additionalFileData;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.closeFinally(cursorQuery, th2);
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object handleVideo(Uri uri, Continuation continuation) throws IOException, FailedToCreateFileException, FailedToExtractVideoMetadataException {
        C10911 c10911;
        File fileCreateOutputFile;
        Uri uri2 = uri;
        if (continuation instanceof C10911) {
            c10911 = (C10911) continuation;
            int i = c10911.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c10911.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c10911 = new C10911(continuation);
            }
        } else {
            c10911 = new C10911(continuation);
        }
        Object obj = c10911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10911.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            fileCreateOutputFile = ImagePickerUtilsKt.createOutputFile(getCacheDirectory(), ".mp4");
            ContentResolver contentResolver = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            c10911.L$0 = uri2;
            c10911.L$1 = fileCreateOutputFile;
            c10911.label = 1;
            if (ImagePickerUtilsKt.copyFile(uri2, fileCreateOutputFile, contentResolver, c10911) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            File file = (File) c10911.L$1;
            Uri uri3 = (Uri) c10911.L$0;
            ResultKt.throwOnFailure(obj);
            fileCreateOutputFile = file;
            uri2 = uri3;
        }
        Uri uriFromFile = Uri.fromFile(fileCreateOutputFile);
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(getContext(), uriFromFile);
            AdditionalFileData additionalFileData = getAdditionalFileData(uri2);
            ContentResolver contentResolver2 = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver2, "getContentResolver(...)");
            String type = ImagePickerUtilsKt.getType(contentResolver2, uri2);
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = ImagePickerUtilsKt.extractInt(mediaMetadataRetriever, 18);
            Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            ref$IntRef2.element = ImagePickerUtilsKt.extractInt(mediaMetadataRetriever, 19);
            int iExtractInt = ImagePickerUtilsKt.extractInt(mediaMetadataRetriever, 24);
            if (iExtractInt % SensibleDefaults.X_OFFSET != 0) {
                int i3 = ref$IntRef2.element;
                ref$IntRef2.element = ref$IntRef.element;
                ref$IntRef.element = i3;
            }
            MediaType mediaType = MediaType.VIDEO;
            String string = uriFromFile.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri2), mediaType, string, ref$IntRef.element, ref$IntRef2.element, additionalFileData != null ? additionalFileData.getFileName() : null, additionalFileData != null ? additionalFileData.getFileSize() : null, type, null, null, Boxing.boxInt(ImagePickerUtilsKt.extractInt(mediaMetadataRetriever, 9)), Boxing.boxInt(iExtractInt), 768, null);
        } catch (FailedToExtractVideoMetadataException e) {
            throw new FailedToExtractVideoMetadataException(fileCreateOutputFile, e);
        }
    }
}
