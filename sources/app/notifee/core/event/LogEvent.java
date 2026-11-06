package app.notifee.core.event;

import app.notifee.core.KeepForSdk;

/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class LogEvent {

    @KeepForSdk
    public static final String LEVEL_DEBUG = "debug";

    @KeepForSdk
    public static final String LEVEL_ERROR = "error";

    @KeepForSdk
    public static final String LEVEL_INFO = "info";

    @KeepForSdk
    public static final String LEVEL_VERBOSE = "verbose";

    @KeepForSdk
    public static final String LEVEL_WARN = "warn";
    private final String level;
    private final String message;
    private final String tag;
    private final Throwable throwable;

    public LogEvent(String str, String str2, String str3) {
        this.tag = str2;
        this.level = str;
        this.message = str3;
        this.throwable = null;
    }

    public LogEvent(String str, String str2, String str3, Throwable th) {
        this.tag = str2;
        this.level = str;
        this.message = str3;
        this.throwable = th;
    }

    @KeepForSdk
    public String getTag() {
        return this.tag;
    }

    @KeepForSdk
    public String getLevel() {
        return this.level;
    }

    @KeepForSdk
    public String getMessage() {
        return this.message;
    }

    @KeepForSdk
    public Throwable getThrowable() {
        return this.throwable;
    }
}
