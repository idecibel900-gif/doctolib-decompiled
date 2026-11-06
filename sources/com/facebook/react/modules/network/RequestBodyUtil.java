package com.facebook.react.modules.network;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import com.amazon.a.a.o.b.f;
import com.facebook.common.logging.FLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.GZIPOutputStream;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;
import okio.DeprecatedUpgrade;
import okio.Source;

/* JADX INFO: loaded from: classes3.dex */
public final class RequestBodyUtil {
    public static final RequestBodyUtil INSTANCE = new RequestBodyUtil();

    private RequestBodyUtil() {
    }

    public static final boolean isGzipEncoding(String str) {
        return StringsKt.equals("gzip", str, true);
    }

    public static final InputStream getFileInputStream(Context context, String fileContentUriStr) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileContentUriStr, "fileContentUriStr");
        try {
            Uri uri = Uri.parse(fileContentUriStr);
            String scheme = uri.getScheme();
            if (scheme != null && StringsKt.startsWith$default(scheme, "http", false, 2, (Object) null)) {
                RequestBodyUtil requestBodyUtil = INSTANCE;
                Intrinsics.checkNotNull(uri);
                return requestBodyUtil.getDownloadFileInputStream(context, uri);
            }
            if (StringsKt.startsWith$default(fileContentUriStr, "data:", false, 2, (Object) null)) {
                List listSplit = new Regex(f.a).split(fileContentUriStr, 0);
                if (!listSplit.isEmpty()) {
                    ListIterator listIterator = listSplit.listIterator(listSplit.size());
                    while (listIterator.hasPrevious()) {
                        if (((String) listIterator.previous()).length() != 0) {
                            listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        }
                    }
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                return new ByteArrayInputStream(Base64.decode(((String[]) listEmptyList.toArray(new String[0]))[1], 0));
            }
            return context.getContentResolver().openInputStream(uri);
        } catch (Exception e) {
            FLog.e("ReactNative", "Could not retrieve file for contentUri " + fileContentUriStr, e);
            return null;
        }
    }

    private final InputStream getDownloadFileInputStream(Context context, Uri uri) throws IOException {
        File fileCreateTempFile = File.createTempFile("RequestBodyUtil", "temp", context.getApplicationContext().getCacheDir());
        fileCreateTempFile.deleteOnExit();
        URL url = new URL(uri.toString());
        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
        try {
            InputStream inputStreamOpenStream = url.openStream();
            try {
                ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(inputStreamOpenStream);
                try {
                    fileOutputStream.getChannel().transferFrom(readableByteChannelNewChannel, 0L, Long.MAX_VALUE);
                    FileInputStream fileInputStream = new FileInputStream(fileCreateTempFile);
                    CloseableKt.closeFinally(readableByteChannelNewChannel, null);
                    CloseableKt.closeFinally(inputStreamOpenStream, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    return fileInputStream;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(readableByteChannelNewChannel, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStreamOpenStream, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(fileOutputStream, th5);
                throw th6;
            }
        }
    }

    public static final RequestBody createGzip(MediaType mediaType, String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bytes = body.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            gZIPOutputStream.write(bytes);
            gZIPOutputStream.close();
            RequestBody.Companion companion = RequestBody.INSTANCE;
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            return RequestBody.Companion.create$default(companion, mediaType, byteArray, 0, 0, 12, (Object) null);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeQuietly(Source source) {
        try {
            source.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final RequestBody create(final MediaType mediaType, final InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return new RequestBody() { // from class: com.facebook.react.modules.network.RequestBodyUtil.create.1
            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: contentType */
            public MediaType getContentType() {
                return mediaType;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                try {
                    return inputStream.available();
                } catch (IOException unused) {
                    return 0L;
                }
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink sink) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                Source source = null;
                try {
                    source = DeprecatedUpgrade.getOkio().source(inputStream);
                    sink.writeAll(source);
                } finally {
                    if (source != null) {
                        RequestBodyUtil.INSTANCE.closeQuietly(source);
                    }
                }
            }
        };
    }

    public static final ProgressRequestBody createProgressRequest(RequestBody requestBody, ProgressListener listener) {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return new ProgressRequestBody(requestBody, listener);
    }

    public static final RequestBody getEmptyBody(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        int iHashCode = method.hashCode();
        if (iHashCode == 79599 ? method.equals("PUT") : iHashCode == 2461856 ? method.equals("POST") : iHashCode == 75900968 && method.equals("PATCH")) {
            return RequestBody.INSTANCE.create((MediaType) null, ByteString.EMPTY);
        }
        return null;
    }
}
