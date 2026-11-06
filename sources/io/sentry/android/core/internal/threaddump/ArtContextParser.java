package io.sentry.android.core.internal.threaddump;

import io.sentry.SentryOptions;
import io.sentry.protocol.ArtContext;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes5.dex */
final class ArtContextParser {
    private ArtContext artContext;

    ArtContextParser() {
    }

    ArtContext getArtContext() {
        return this.artContext;
    }

    void parseLine(String str) {
        if (str.startsWith("Free memory until OOME ")) {
            getOrCreateArtContext().setFreeMemoryUntilOome(parsePrettySize(str.substring(23)));
            return;
        }
        if (str.startsWith("Free memory until GC ")) {
            getOrCreateArtContext().setFreeMemoryUntilGc(parsePrettySize(str.substring(21)));
            return;
        }
        if (str.startsWith("Free memory ")) {
            getOrCreateArtContext().setFreeMemory(parsePrettySize(str.substring(12)));
            return;
        }
        if (str.startsWith("Total memory ")) {
            getOrCreateArtContext().setTotalMemory(parsePrettySize(str.substring(13)));
            return;
        }
        if (str.startsWith("Max memory ")) {
            getOrCreateArtContext().setMaxMemory(parsePrettySize(str.substring(11)));
            return;
        }
        if (str.startsWith("Total time waiting for GC to complete: ")) {
            getOrCreateArtContext().setGcWaitingTime(parseTimeMs(str.substring(39)));
            return;
        }
        if (str.startsWith("Total GC time: ")) {
            getOrCreateArtContext().setGcTotalTime(parseTimeMs(str.substring(15)));
            return;
        }
        if (str.startsWith("Total GC count: ")) {
            getOrCreateArtContext().setGcTotalCount(parseLongOrNull(str.substring(16)));
            return;
        }
        if (str.startsWith("Total blocking GC time: ")) {
            getOrCreateArtContext().setGcBlockingTime(parseTimeMs(str.substring(24)));
        } else if (str.startsWith("Total blocking GC count: ")) {
            getOrCreateArtContext().setGcBlockingCount(parseLongOrNull(str.substring(25)));
        } else if (str.startsWith("Total pre-OOME GC count: ")) {
            getOrCreateArtContext().setGcPreOomeCount(parseLongOrNull(str.substring(25)));
        }
    }

    private ArtContext getOrCreateArtContext() {
        if (this.artContext == null) {
            this.artContext = new ArtContext();
        }
        return this.artContext;
    }

    private Long parsePrettySize(String str) {
        String strTrim = str.trim();
        try {
            if (strTrim.endsWith("GB")) {
                return Long.valueOf(Long.parseLong(strTrim.substring(0, strTrim.length() - 2)) * 1073741824);
            }
            if (strTrim.endsWith("MB")) {
                return Long.valueOf(Long.parseLong(strTrim.substring(0, strTrim.length() - 2)) * SentryOptions.MAX_EVENT_SIZE_BYTES);
            }
            if (strTrim.endsWith("KB")) {
                return Long.valueOf(Long.parseLong(strTrim.substring(0, strTrim.length() - 2)) * RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
            }
            if (strTrim.endsWith("B")) {
                return Long.valueOf(Long.parseLong(strTrim.substring(0, strTrim.length() - 1)));
            }
            return null;
        } catch (NumberFormatException unused) {
        }
    }

    private static Double parseTimeMs(String str) {
        String strTrim = str.trim();
        try {
            if (strTrim.equals("0")) {
                return Double.valueOf(0.0d);
            }
            if (strTrim.endsWith("ms")) {
                return Double.valueOf(Double.parseDouble(strTrim.substring(0, strTrim.length() - 2)));
            }
            if (strTrim.endsWith("ns")) {
                return Double.valueOf(Double.parseDouble(strTrim.substring(0, strTrim.length() - 2)) / 1000000.0d);
            }
            if (strTrim.endsWith("us")) {
                return Double.valueOf(Double.parseDouble(strTrim.substring(0, strTrim.length() - 2)) / 1000.0d);
            }
            if (strTrim.endsWith("s")) {
                return Double.valueOf(Double.parseDouble(strTrim.substring(0, strTrim.length() - 1)) * 1000.0d);
            }
            return null;
        } catch (NumberFormatException unused) {
        }
    }

    private static Long parseLongOrNull(String str) {
        try {
            return Long.valueOf(Long.parseLong(str.trim()));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
