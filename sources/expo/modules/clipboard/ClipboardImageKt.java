package expo.modules.clipboard;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Base64;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt;
import kotlinx.coroutines.YieldKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ClipboardImageKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageFormat.values().length];
            try {
                iArr[ImageFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageFormat.JPG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return ClipboardImageKt.bitmapFromContentUriAsync(null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.clipboard.ClipboardImageKt$clipDataFromBase64Image$1, reason: invalid class name and case insensitive filesystem */
    static final class C10851 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C10851(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return ClipboardImageKt.clipDataFromBase64Image(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.clipboard.ClipboardImageKt$imageFromContentUri$1, reason: invalid class name and case insensitive filesystem */
    static final class C10861 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10861(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return ClipboardImageKt.imageFromContentUri(null, null, null, this);
        }
    }

    public static final ImageFormat getImageFormatFromBase64(String base64Image) {
        Intrinsics.checkNotNullParameter(base64Image, "base64Image");
        String strSubstring = base64Image.substring(0, 8);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        if (StringsKt.startsWith$default(strSubstring, "iVBORw0K", false, 2, (Object) null)) {
            return ImageFormat.PNG;
        }
        return StringsKt.startsWith$default(strSubstring, "/9j/", false, 2, (Object) null) ? ImageFormat.JPG : ImageFormat.JPG;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object imageFromContentUri(Context context, Uri uri, GetImageOptions getImageOptions, Continuation continuation) {
        C10861 c10861;
        ImageFormat imageFormat;
        Bitmap bitmap;
        ByteArrayOutputStream byteArrayOutputStream;
        if (continuation instanceof C10861) {
            c10861 = (C10861) continuation;
            int i = c10861.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c10861.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c10861 = new C10861(continuation);
            }
        } else {
            c10861 = new C10861(continuation);
        }
        Object objBitmapFromContentUriAsync = c10861.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10861.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objBitmapFromContentUriAsync);
            c10861.L$0 = getImageOptions;
            c10861.label = 1;
            objBitmapFromContentUriAsync = bitmapFromContentUriAsync(context, uri, c10861);
            if (objBitmapFromContentUriAsync != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            getImageOptions = (GetImageOptions) c10861.L$0;
            ResultKt.throwOnFailure(objBitmapFromContentUriAsync);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteArrayOutputStream = (ByteArrayOutputStream) c10861.L$2;
            imageFormat = (ImageFormat) c10861.L$1;
            bitmap = (Bitmap) c10861.L$0;
            ResultKt.throwOnFailure(objBitmapFromContentUriAsync);
        }
        String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        StringBuilder sb = new StringBuilder("data:" + imageFormat.getMimeType() + ";base64,");
        sb.append(strEncodeToString);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new ImageResult(string, bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmap2 = (Bitmap) objBitmapFromContentUriAsync;
        imageFormat = getImageOptions.getImageFormat();
        int jpegQuality = (int) (getImageOptions.getJpegQuality() * ((double) 100));
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        bitmap2.compress(imageFormat.getCompressFormat(), jpegQuality, byteArrayOutputStream2);
        c10861.L$0 = bitmap2;
        c10861.L$1 = imageFormat;
        c10861.L$2 = byteArrayOutputStream2;
        c10861.label = 2;
        if (YieldKt.yield(c10861) != coroutine_suspended) {
            bitmap = bitmap2;
            byteArrayOutputStream = byteArrayOutputStream2;
            String strEncodeToString2 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            StringBuilder sb2 = new StringBuilder("data:" + imageFormat.getMimeType() + ";base64,");
            sb2.append(strEncodeToString2);
            String string2 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            return new ImageResult(string2, bitmap.getWidth(), bitmap.getHeight());
        }
        return coroutine_suspended;
    }

    public static final void clearClipboardCache(File clipboardCacheDir) {
        File[] fileArrListFiles;
        Intrinsics.checkNotNullParameter(clipboardCacheDir, "clipboardCacheDir");
        if (clipboardCacheDir.exists() && clipboardCacheDir.isDirectory() && (fileArrListFiles = clipboardCacheDir.listFiles()) != null) {
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    Intrinsics.checkNotNull(file);
                    FilesKt.deleteRecursively(file);
                } else {
                    file.delete();
                }
            }
        }
    }

    public static final String hashFileName() throws NoSuchAlgorithmException {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        String str = "copied_image" + ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ClipboardImageKt.hashFileName$lambda$3(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNull(bArrDigest);
        return ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ClipboardImageKt.hashFileName$lambda$4(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence hashFileName$lambda$3(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence hashFileName$lambda$4(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x010d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object clipDataFromBase64Image(Context context, String str, File file, Continuation continuation) throws NoSuchAlgorithmException, IOException, InvalidImageException {
        C10851 c10851;
        ImageFormat imageFormatFromBase64;
        String str2;
        Context context2;
        Bitmap bitmap;
        final File file2;
        final BufferedOutputStream bufferedOutputStream;
        Closeable closeable;
        Function0 function0;
        File file3;
        Context context3;
        if (continuation instanceof C10851) {
            c10851 = (C10851) continuation;
            int i = c10851.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c10851.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c10851 = new C10851(continuation);
            }
        } else {
            c10851 = new C10851(continuation);
        }
        Object objRunInterruptible$default = c10851.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10851.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objRunInterruptible$default);
            Bitmap bitmapBitmapFromBase64String = bitmapFromBase64String(str);
            imageFormatFromBase64 = getImageFormatFromBase64(str);
            clearClipboardCache(file);
            String strHashFileName = hashFileName();
            int i3 = WhenMappings.$EnumSwitchMapping$0[imageFormatFromBase64.ordinal()];
            if (i3 == 1) {
                str2 = strHashFileName + ".png";
            } else {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str2 = strHashFileName + ".jpeg";
            }
            File file4 = new File(file, str2);
            c10851.L$0 = context;
            c10851.L$1 = bitmapBitmapFromBase64String;
            c10851.L$2 = imageFormatFromBase64;
            c10851.L$3 = file4;
            c10851.label = 1;
            if (ensureExists(file4, c10851) != coroutine_suspended) {
                context2 = context;
                bitmap = bitmapBitmapFromBase64String;
                file2 = file4;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) c10851.L$2;
                file3 = (File) c10851.L$1;
                context3 = (Context) c10851.L$0;
                try {
                    ResultKt.throwOnFailure(objRunInterruptible$default);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(closeable, null);
                    ClipData clipDataNewUri = ClipData.newUri(context3.getContentResolver(), "image", ClipboardFileProvider.INSTANCE.getUriForFile(context3, context3.getApplicationInfo().packageName + ".ClipboardFileProvider", file3));
                    Intrinsics.checkNotNullExpressionValue(clipDataNewUri, "newUri(...)");
                    return clipDataNewUri;
                } catch (Throwable th) {
                    th = th;
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(closeable, th);
                        throw th2;
                    }
                }
            }
            file2 = (File) c10851.L$3;
            imageFormatFromBase64 = (ImageFormat) c10851.L$2;
            bitmap = (Bitmap) c10851.L$1;
            context2 = (Context) c10851.L$0;
            ResultKt.throwOnFailure(objRunInterruptible$default);
            bufferedOutputStream = new BufferedOutputStream((FileOutputStream) objRunInterruptible$default);
            try {
                bitmap.compress(imageFormatFromBase64.getCompressFormat(), 100, bufferedOutputStream);
                function0 = new Function0() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ClipboardImageKt.clipDataFromBase64Image$lambda$8$lambda$7(bufferedOutputStream);
                    }
                };
                c10851.L$0 = context2;
                c10851.L$1 = file2;
                c10851.L$2 = bufferedOutputStream;
                c10851.L$3 = null;
                c10851.label = 3;
                if (InterruptibleKt.runInterruptible$default(null, function0, c10851, 1, null) != coroutine_suspended) {
                    file3 = file2;
                    context3 = context2;
                    closeable = bufferedOutputStream;
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(closeable, null);
                    ClipData clipDataNewUri2 = ClipData.newUri(context3.getContentResolver(), "image", ClipboardFileProvider.INSTANCE.getUriForFile(context3, context3.getApplicationInfo().packageName + ".ClipboardFileProvider", file3));
                    Intrinsics.checkNotNullExpressionValue(clipDataNewUri2, "newUri(...)");
                    return clipDataNewUri2;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                th = th3;
                closeable = bufferedOutputStream;
                throw th;
            }
        }
        file2 = (File) c10851.L$3;
        imageFormatFromBase64 = (ImageFormat) c10851.L$2;
        bitmap = (Bitmap) c10851.L$1;
        context2 = (Context) c10851.L$0;
        ResultKt.throwOnFailure(objRunInterruptible$default);
        Function0 function1 = new Function0() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ClipboardImageKt.clipDataFromBase64Image$lambda$6(file2);
            }
        };
        c10851.L$0 = context2;
        c10851.L$1 = bitmap;
        c10851.L$2 = imageFormatFromBase64;
        c10851.L$3 = file2;
        c10851.label = 2;
        objRunInterruptible$default = InterruptibleKt.runInterruptible$default(null, function1, c10851, 1, null);
        if (objRunInterruptible$default != coroutine_suspended) {
            bufferedOutputStream = new BufferedOutputStream((FileOutputStream) objRunInterruptible$default);
            bitmap.compress(imageFormatFromBase64.getCompressFormat(), 100, bufferedOutputStream);
            function0 = new Function0() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ClipboardImageKt.clipDataFromBase64Image$lambda$8$lambda$7(bufferedOutputStream);
                }
            };
            c10851.L$0 = context2;
            c10851.L$1 = file2;
            c10851.L$2 = bufferedOutputStream;
            c10851.L$3 = null;
            c10851.label = 3;
            if (InterruptibleKt.runInterruptible$default(null, function0, c10851, 1, null) != coroutine_suspended) {
                file3 = file2;
                context3 = context2;
                closeable = bufferedOutputStream;
                Unit unit3 = Unit.INSTANCE;
                CloseableKt.closeFinally(closeable, null);
                ClipData clipDataNewUri3 = ClipData.newUri(context3.getContentResolver(), "image", ClipboardFileProvider.INSTANCE.getUriForFile(context3, context3.getApplicationInfo().packageName + ".ClipboardFileProvider", file3));
                Intrinsics.checkNotNullExpressionValue(clipDataNewUri3, "newUri(...)");
                return clipDataNewUri3;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileOutputStream clipDataFromBase64Image$lambda$6(File file) {
        return new FileOutputStream(file, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clipDataFromBase64Image$lambda$8$lambda$7(BufferedOutputStream bufferedOutputStream) throws IOException {
        bufferedOutputStream.flush();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object bitmapFromContentUriAsync(final Context context, final Uri uri, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object objRunInterruptible = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objRunInterruptible);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            Function0 function0 = new Function0() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ClipboardImageKt.bitmapFromContentUriAsync$lambda$9(context, uri);
                }
            };
            anonymousClass1.label = 1;
            objRunInterruptible = InterruptibleKt.runInterruptible(io2, function0, anonymousClass1);
            if (objRunInterruptible == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objRunInterruptible);
        }
        Intrinsics.checkNotNullExpressionValue(objRunInterruptible, "runInterruptible(...)");
        return objRunInterruptible;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap bitmapFromContentUriAsync$lambda$9(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        if (Build.VERSION.SDK_INT < 28) {
            return MediaStore.Images.Media.getBitmap(contentResolver, uri);
        }
        ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(contentResolver, uri);
        Intrinsics.checkNotNullExpressionValue(sourceCreateSource, "createSource(...)");
        return ImageDecoder.decodeBitmap(sourceCreateSource);
    }

    public static final Bitmap bitmapFromBase64String(String base64Image) throws InvalidImageException {
        Intrinsics.checkNotNullParameter(base64Image, "base64Image");
        try {
            byte[] bArrDecode = Base64.decode(base64Image, 0);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            if (bitmapDecodeByteArray != null) {
                return bitmapDecodeByteArray;
            }
            throw new RuntimeException("Failed to convert base64 into Bitmap");
        } catch (RuntimeException e) {
            throw new InvalidImageException(base64Image, e);
        }
    }

    private static final Object ensureExists(final File file, Continuation continuation) {
        return InterruptibleKt.runInterruptible(Dispatchers.getIO(), new Function0() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ClipboardImageKt.ensureExists$lambda$10(file));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ensureExists$lambda$10(File file) {
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        return file.createNewFile();
    }
}
