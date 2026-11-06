package com.opentok.android;

import android.content.Context;
import com.opentok.otc.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class MediaUtils {
    private static final String VIDEO_CODEC_H264_STRING = "H264";
    private static final String VIDEO_CODEC_VP8_STRING = "VP8";
    private static final String VIDEO_CODEC_VP9_STRING = "VP9";

    public class SupportedCodecs {
        public ArrayList<VideoCodecType> videoEncoderCodecs = new ArrayList<>();
        public ArrayList<VideoCodecType> videoDecoderCodecs = new ArrayList<>();

        public SupportedCodecs() {
        }
    }

    public enum VideoCodecType {
        VIDEO_CODEC_VP8(1),
        VIDEO_CODEC_H264(2),
        VIDEO_CODEC_VP9(3);

        private final int value;

        VideoCodecType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static VideoCodecType getValue(int i) {
            for (VideoCodecType videoCodecType : values()) {
                if (videoCodecType.getValue() == i) {
                    return videoCodecType;
                }
            }
            return null;
        }
    }

    static {
        Loader.load();
    }

    public static SupportedCodecs getSupportedCodecs(Context context) {
        SupportedCodecs supportedCodecs = new MediaUtils().new SupportedCodecs();
        if (new Session.Builder(context, "fakeApiKey", "fakeSessionId").build() != null) {
            for (String str : d.a(new int[1])) {
                str.getClass();
                switch (str) {
                    case "VP8":
                        ArrayList<VideoCodecType> arrayList = supportedCodecs.videoEncoderCodecs;
                        VideoCodecType videoCodecType = VideoCodecType.VIDEO_CODEC_VP8;
                        arrayList.add(videoCodecType);
                        supportedCodecs.videoDecoderCodecs.add(videoCodecType);
                        break;
                    case "VP9":
                        ArrayList<VideoCodecType> arrayList2 = supportedCodecs.videoEncoderCodecs;
                        VideoCodecType videoCodecType2 = VideoCodecType.VIDEO_CODEC_VP9;
                        arrayList2.add(videoCodecType2);
                        supportedCodecs.videoDecoderCodecs.add(videoCodecType2);
                        break;
                    case "H264":
                        ArrayList<VideoCodecType> arrayList3 = supportedCodecs.videoEncoderCodecs;
                        VideoCodecType videoCodecType3 = VideoCodecType.VIDEO_CODEC_H264;
                        arrayList3.add(videoCodecType3);
                        supportedCodecs.videoDecoderCodecs.add(videoCodecType3);
                        break;
                }
            }
        }
        return supportedCodecs;
    }
}
