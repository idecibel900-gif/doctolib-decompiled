package expo.modules.imagepicker;

/* JADX INFO: loaded from: classes4.dex */
public final class ImagePickerConstants {
    public static final ImagePickerConstants INSTANCE = new ImagePickerConstants();
    private static final Iterable EXIF_TAGS = new ImagePickerConstants$EXIF_TAGS$1();

    private ImagePickerConstants() {
    }

    public final Iterable getEXIF_TAGS() {
        return EXIF_TAGS;
    }
}
