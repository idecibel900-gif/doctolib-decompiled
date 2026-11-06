package androidx.media3.exoplayer.mediacodec;

import android.os.Build;
import androidx.media3.common.Format;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class MediaCodecPerformancePointCoverageProvider {
    private static Boolean shouldIgnorePerformancePoints;

    public static int areResolutionAndFrameRateCovered(android.media.MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (Build.VERSION.SDK_INT < 29) {
            return 0;
        }
        Boolean bool = shouldIgnorePerformancePoints;
        if (bool == null || !bool.booleanValue()) {
            return Api29.areResolutionAndFrameRateCovered(videoCapabilities, i, i2, d);
        }
        return 0;
    }

    private static final class Api29 {
        public static int areResolutionAndFrameRateCovered(android.media.MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
            List<android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
            if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
                return 0;
            }
            MediaCodecPerformancePointCoverageProvider$Api29$$ExternalSyntheticApiModelOutline1.m();
            int iEvaluatePerformancePointCoverage = evaluatePerformancePointCoverage(supportedPerformancePoints, MediaCodecPerformancePointCoverageProvider$Api29$$ExternalSyntheticApiModelOutline0.m(i, i2, (int) d));
            if (iEvaluatePerformancePointCoverage == 1 && MediaCodecPerformancePointCoverageProvider.shouldIgnorePerformancePoints == null) {
                Boolean unused = MediaCodecPerformancePointCoverageProvider.shouldIgnorePerformancePoints = Boolean.valueOf(shouldIgnorePerformancePoints());
                if (MediaCodecPerformancePointCoverageProvider.shouldIgnorePerformancePoints.booleanValue()) {
                    return 0;
                }
            }
            return iEvaluatePerformancePointCoverage;
        }

        private static boolean shouldIgnorePerformancePoints() {
            if (Build.VERSION.SDK_INT >= 35) {
                return false;
            }
            int iEvaluateH264RequiredSupport = evaluateH264RequiredSupport(false);
            int iEvaluateH264RequiredSupport2 = evaluateH264RequiredSupport(true);
            if (iEvaluateH264RequiredSupport == 0) {
                return true;
            }
            if (iEvaluateH264RequiredSupport2 == 0) {
                return iEvaluateH264RequiredSupport != 2;
            }
            return (iEvaluateH264RequiredSupport == 2 && iEvaluateH264RequiredSupport2 == 2) ? false : true;
        }

        private static int evaluateH264RequiredSupport(boolean z) {
            android.media.MediaCodecInfo.VideoCapabilities videoCapabilities;
            List<android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints;
            try {
                Format formatBuild = new Format.Builder().setSampleMimeType("video/avc").build();
                if (formatBuild.sampleMimeType != null) {
                    List decoderInfosSoftMatch = MediaCodecUtil.getDecoderInfosSoftMatch(MediaCodecSelector.DEFAULT, formatBuild, z, false);
                    for (int i = 0; i < decoderInfosSoftMatch.size(); i++) {
                        if (((MediaCodecInfo) decoderInfosSoftMatch.get(i)).capabilities != null && (videoCapabilities = ((MediaCodecInfo) decoderInfosSoftMatch.get(i)).capabilities.getVideoCapabilities()) != null && (supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                            MediaCodecPerformancePointCoverageProvider$Api29$$ExternalSyntheticApiModelOutline1.m();
                            return evaluatePerformancePointCoverage(supportedPerformancePoints, MediaCodecPerformancePointCoverageProvider$Api29$$ExternalSyntheticApiModelOutline0.m(1280, 720, 60));
                        }
                    }
                }
            } catch (MediaCodecUtil.DecoderQueryException unused) {
            }
            return 0;
        }

        private static int evaluatePerformancePointCoverage(List list, android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
            for (int i = 0; i < list.size(); i++) {
                if (MediaCodecPerformancePointCoverageProvider$Api29$$ExternalSyntheticApiModelOutline2.m(list.get(i)).covers(performancePoint)) {
                    return 2;
                }
            }
            return 1;
        }
    }
}
