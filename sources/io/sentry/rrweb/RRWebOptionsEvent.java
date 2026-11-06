package io.sentry.rrweb;

import com.google.firebase.messaging.Constants;
import io.sentry.ILogger;
import io.sentry.JsonSerializable;
import io.sentry.ObjectWriter;
import io.sentry.ScreenshotStrategyType;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayOptions;
import io.sentry.protocol.SdkVersion;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class RRWebOptionsEvent extends RRWebEvent implements JsonSerializable {
    private Map dataUnknown;
    private Map optionsPayload;
    private String tag;
    private Map unknown;

    public RRWebOptionsEvent() {
        super(RRWebEventType.Custom);
        this.optionsPayload = new HashMap();
        this.tag = "options";
    }

    public RRWebOptionsEvent(SentryOptions sentryOptions) {
        String str;
        this();
        SdkVersion sdkVersion = sentryOptions.getSdkVersion();
        if (sdkVersion != null) {
            this.optionsPayload.put("nativeSdkName", sdkVersion.getName());
            this.optionsPayload.put("nativeSdkVersion", sdkVersion.getVersion());
        }
        SentryReplayOptions sessionReplay = sentryOptions.getSessionReplay();
        this.optionsPayload.put("errorSampleRate", sessionReplay.getOnErrorSampleRate());
        this.optionsPayload.put("sessionSampleRate", sessionReplay.getSessionSampleRate());
        this.optionsPayload.put("maskAllImages", Boolean.valueOf(sessionReplay.getMaskViewClasses().contains("android.widget.ImageView")));
        this.optionsPayload.put("maskAllText", Boolean.valueOf(sessionReplay.getMaskViewClasses().contains("android.widget.TextView")));
        this.optionsPayload.put("quality", sessionReplay.getQuality().serializedName());
        this.optionsPayload.put("maskedViewClasses", sessionReplay.getMaskViewClasses());
        this.optionsPayload.put("unmaskedViewClasses", sessionReplay.getUnmaskViewClasses());
        if (sessionReplay.getScreenshotStrategy() == ScreenshotStrategyType.PIXEL_COPY) {
            str = "pixelCopy";
        } else {
            str = "canvas";
        }
        this.optionsPayload.put("screenshotStrategy", str);
        this.optionsPayload.put("networkDetailHasUrls", Boolean.valueOf(!sessionReplay.getNetworkDetailAllowUrls().isEmpty()));
        if (sessionReplay.getNetworkDetailAllowUrls().isEmpty()) {
            return;
        }
        this.optionsPayload.put("networkDetailAllowUrls", sessionReplay.getNetworkDetailAllowUrls());
        this.optionsPayload.put("networkRequestHeaders", sessionReplay.getNetworkRequestHeaders());
        this.optionsPayload.put("networkResponseHeaders", sessionReplay.getNetworkResponseHeaders());
        this.optionsPayload.put("networkCaptureBodies", Boolean.valueOf(sessionReplay.isNetworkCaptureBodies()));
        if (sessionReplay.getNetworkDetailDenyUrls().isEmpty()) {
            return;
        }
        this.optionsPayload.put("networkDetailDenyUrls", sessionReplay.getNetworkDetailDenyUrls());
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        new RRWebEvent.Serializer().serialize(this, objectWriter, iLogger);
        objectWriter.name(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        serializeData(objectWriter, iLogger);
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.unknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    private void serializeData(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("tag").value(this.tag);
        objectWriter.name("payload");
        serializePayload(objectWriter, iLogger);
        Map map = this.dataUnknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.dataUnknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    private void serializePayload(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        Map map = this.optionsPayload;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.optionsPayload.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }
}
