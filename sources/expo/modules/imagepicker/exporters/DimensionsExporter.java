package expo.modules.imagepicker.exporters;

import android.graphics.BitmapFactory;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DimensionsExporter {
    private final File file;
    private final Lazy isRotatedLandscape$delegate;
    private final Lazy metadata$delegate;

    public DimensionsExporter(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        this.isRotatedLandscape$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.imagepicker.exporters.DimensionsExporter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DimensionsExporter.isRotatedLandscape_delegate$lambda$0(this.f$0));
            }
        });
        this.metadata$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.imagepicker.exporters.DimensionsExporter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DimensionsExporter.metadata_delegate$lambda$2(this.f$0);
            }
        });
    }

    private final boolean isRotatedLandscape() {
        return ((Boolean) this.isRotatedLandscape$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRotatedLandscape_delegate$lambda$0(DimensionsExporter dimensionsExporter) {
        int attributeInt = new ExifInterface(dimensionsExporter.file.getAbsolutePath()).getAttributeInt("Orientation", 0);
        return attributeInt == 6 || attributeInt == 8 || attributeInt == 5 || attributeInt == 7;
    }

    private final BitmapFactory.Options getMetadata() {
        return (BitmapFactory.Options) this.metadata$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BitmapFactory.Options metadata_delegate$lambda$2(DimensionsExporter dimensionsExporter) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(dimensionsExporter.file.getAbsolutePath(), options);
        return options;
    }

    public final int getWidth() {
        return isRotatedLandscape() ? getMetadata().outHeight : getMetadata().outWidth;
    }

    public final int getHeight() {
        return isRotatedLandscape() ? getMetadata().outWidth : getMetadata().outHeight;
    }
}
