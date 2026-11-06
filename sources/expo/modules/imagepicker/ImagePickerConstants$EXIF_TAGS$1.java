package expo.modules.imagepicker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class ImagePickerConstants$EXIF_TAGS$1 implements Iterable, KMappedMarker {
    private final Map typeToTags = MapsKt.mapOf(TuplesKt.to("string", CollectionsKt.listOf((Object[]) new String[]{"Artist", "CFAPattern", "ComponentsConfiguration", "Copyright", "DateTime", "DateTimeDigitized", "DateTimeOriginal", "DeviceSettingDescription", "ExifVersion", "FileSource", "FlashpixVersion", "GPSAreaInformation", "GPSDateStamp", "GPSDestBearingRef", "GPSDestDistanceRef", "GPSDestLatitudeRef", "GPSDestLongitudeRef", "GPSHPositioningError", "GPSImgDirectionRef", "GPSLatitudeRef", "GPSLongitudeRef", "GPSMapDatum", "GPSMeasureMode", "GPSProcessingMethod", "GPSSatellites", "GPSSpeedRef", "GPSStatus", "GPSTimeStamp", "GPSTrackRef", "GPSVersionID", "ImageDescription", "ImageUniqueID", "InteroperabilityIndex", "Make", "MakerNote", "Model", "OECF", "RelatedSoundFile", "SceneType", "Software", "SpatialFrequencyResponse", "SpectralSensitivity", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "UserComment"})), TuplesKt.to("double", CollectionsKt.listOf((Object[]) new String[]{"ApertureValue", "BrightnessValue", "CompressedBitsPerPixel", "DigitalZoomRatio", "ExposureBiasValue", "ExposureIndex", "ExposureTime", "FlashEnergy", "FocalLength", "FocalPlaneXResolution", "FocalPlaneYResolution", "FNumber", "GPSAltitude", "GPSDestBearing", "GPSDestDistance", "GPSDestLatitude", "GPSDestLongitude", "GPSDOP", "GPSImgDirection", "GPSLatitude", "GPSLongitude", "GPSSpeed", "GPSTrack", "MaxApertureValue", "PrimaryChromaticities", "ReferenceBlackWhite", "ShutterSpeedValue", "SubjectDistance", "WhitePoint", "XResolution", "YCbCrCoefficients", "YResolution"})), TuplesKt.to("int", CollectionsKt.listOf((Object[]) new String[]{"BitsPerSample", "ColorSpace", "Compression", "Contrast", "CustomRendered", "DefaultCropSize", "DNGVersion", "ExposureMode", "ExposureProgram", "Flash", "FocalLengthIn35mmFilm", "FocalPlaneResolutionUnit", "GainControl", "GPSAltitudeRef", "GPSDifferential", "ImageLength", "ImageWidth", "ISOSpeedRatings", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "LightSource", "MeteringMode", "NewSubfileType", "AspectFrame", "PreviewImageLength", "PreviewImageStart", "Orientation", "PhotometricInterpretation", "PixelXDimension", "PixelYDimension", "PlanarConfiguration", "ResolutionUnit", "RowsPerStrip", "ISO", "SensorBottomBorder", "SensorLeftBorder", "SensorRightBorder", "SensorTopBorder", "SamplesPerPixel", "Saturation", "SceneCaptureType", "SensingMethod", "Sharpness", "StripByteCounts", "StripOffsets", "SubfileType", "SubjectArea", "SubjectDistanceRange", "SubjectLocation", "ThumbnailImageLength", "ThumbnailImageWidth", "TransferFunction", "WhiteBalance", "YCbCrPositioning", "YCbCrSubSampling"})));

    ImagePickerConstants$EXIF_TAGS$1() {
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Map map = this.typeToTags;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(TuplesKt.to(str, (String) it.next()));
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        return arrayList.iterator();
    }
}
