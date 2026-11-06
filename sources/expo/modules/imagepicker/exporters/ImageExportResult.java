package expo.modules.imagepicker.exporters;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.imagepicker.FailedToReadFileException;
import expo.modules.imagepicker.ImagePickerConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InterruptibleKt;

/* JADX INFO: loaded from: classes4.dex */
public class ImageExportResult {
    private final int height;
    private final File imageFile;
    private final int width;

    public Object data(ContentResolver contentResolver, Continuation continuation) {
        return data$suspendImpl(this, contentResolver, continuation);
    }

    public Object exif(ContentResolver contentResolver, Continuation continuation) {
        return exif$suspendImpl(this, contentResolver, continuation);
    }

    public ImageExportResult(int i, int i2, File imageFile) {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        this.width = i;
        this.height = i2;
        this.imageFile = imageFile;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    static /* synthetic */ Object data$suspendImpl(final ImageExportResult imageExportResult, final ContentResolver contentResolver, Continuation continuation) {
        return InterruptibleKt.runInterruptible$default(null, new Function0() { // from class: expo.modules.imagepicker.exporters.ImageExportResult$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImageExportResult.data$lambda$2(contentResolver, imageExportResult);
            }
        }, continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteArrayOutputStream data$lambda$2(ContentResolver contentResolver, ImageExportResult imageExportResult) throws FailedToReadFileException, IOException {
        InputStream inputStreamOpenInputStream = contentResolver.openInputStream(Uri.fromFile(imageExportResult.imageFile));
        if (inputStreamOpenInputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ByteStreamsKt.copyTo$default(inputStreamOpenInputStream, byteArrayOutputStream, 0, 2, null);
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                    return byteArrayOutputStream;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(byteArrayOutputStream, th);
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
        throw new FailedToReadFileException(imageExportResult.imageFile, null, 2, null);
    }

    static /* synthetic */ Object exif$suspendImpl(final ImageExportResult imageExportResult, final ContentResolver contentResolver, Continuation continuation) {
        return InterruptibleKt.runInterruptible$default(null, new Function0() { // from class: expo.modules.imagepicker.exporters.ImageExportResult$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImageExportResult.exif$lambda$8(contentResolver, imageExportResult);
            }
        }, continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle exif$lambda$8(ContentResolver contentResolver, ImageExportResult imageExportResult) throws FailedToReadFileException, IOException {
        InputStream inputStreamOpenInputStream = contentResolver.openInputStream(Uri.fromFile(imageExportResult.imageFile));
        if (inputStreamOpenInputStream != null) {
            try {
                Bundle bundle = new Bundle();
                ExifInterface exifInterface = new ExifInterface(inputStreamOpenInputStream);
                Iterable exif_tags = ImagePickerConstants.INSTANCE.getEXIF_TAGS();
                ArrayList<Pair> arrayList = new ArrayList();
                for (Object obj : exif_tags) {
                    if (exifInterface.getAttribute((String) ((Pair) obj).getSecond()) != null) {
                        arrayList.add(obj);
                    }
                }
                for (Pair pair : arrayList) {
                    String str = (String) pair.getFirst();
                    String str2 = (String) pair.getSecond();
                    int iHashCode = str.hashCode();
                    if (iHashCode != -1325958191) {
                        if (iHashCode != -891985903) {
                            if (iHashCode == 104431 && str.equals("int")) {
                                bundle.putInt(str2, exifInterface.getAttributeInt(str2, 0));
                            }
                        } else if (str.equals("string")) {
                            bundle.putString(str2, exifInterface.getAttribute(str2));
                        }
                    } else if (str.equals("double")) {
                        bundle.putDouble(str2, exifInterface.getAttributeDouble(str2, 0.0d));
                    }
                }
                double[] latLong = exifInterface.getLatLong();
                if (latLong != null) {
                    bundle.putDouble("GPSLatitude", latLong[0]);
                    bundle.putDouble("GPSLongitude", latLong[1]);
                    bundle.putDouble("GPSAltitude", exifInterface.getAltitude(0.0d));
                }
                CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                return bundle;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpenInputStream, th);
                    throw th2;
                }
            }
        }
        throw new FailedToReadFileException(imageExportResult.imageFile, null, 2, null);
    }
}
