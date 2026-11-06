package com.facebook.react.devsupport;

import com.revenuecat.purchases.common.Constants;
import java.io.EOFException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class MultipartStreamReader {
    public static final Companion Companion = new Companion(null);
    private final String boundary;
    private long lastProgressEvent;
    private final BufferedSource source;

    public interface ChunkListener {
        void onChunkComplete(Map map, Buffer buffer, boolean z);

        void onChunkProgress(Map map, long j, long j2);
    }

    public MultipartStreamReader(BufferedSource source, String boundary) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        this.source = source;
        this.boundary = boundary;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cb A[SYNTHETIC] */
    public final boolean readAllParts(ChunkListener chunkListener) throws EOFException {
        boolean z;
        Map map;
        ChunkListener listener = chunkListener;
        Intrinsics.checkNotNullParameter(listener, "listener");
        ByteString.Companion companion = ByteString.Companion;
        ByteString byteStringM5652deprecated_encodeUtf8 = companion.m5652deprecated_encodeUtf8("\r\n--" + this.boundary + "\r\n");
        ByteString byteStringM5652deprecated_encodeUtf9 = companion.m5652deprecated_encodeUtf8("\r\n--" + this.boundary + "--\r\n");
        ByteString byteStringM5652deprecated_encodeUtf10 = companion.m5652deprecated_encodeUtf8("\r\n\r\n");
        Buffer buffer = new Buffer();
        Map headers = null;
        long j = 0;
        long jM5650deprecated_size = 0;
        long jM5650deprecated_size2 = 0;
        while (true) {
            long jMax = (long) Math.max(j - ((long) byteStringM5652deprecated_encodeUtf9.m5650deprecated_size()), jM5650deprecated_size);
            long jIndexOf = buffer.indexOf(byteStringM5652deprecated_encodeUtf8, jMax);
            if (jIndexOf == -1) {
                jIndexOf = buffer.indexOf(byteStringM5652deprecated_encodeUtf9, jMax);
                z = true;
            } else {
                z = false;
            }
            if (jIndexOf == -1) {
                long jM5648deprecated_size = buffer.m5648deprecated_size();
                if (headers == null) {
                    long jIndexOf2 = buffer.indexOf(byteStringM5652deprecated_encodeUtf10, jMax);
                    if (jIndexOf2 >= 0) {
                        this.source.read(buffer, jIndexOf2);
                        Buffer buffer2 = new Buffer();
                        buffer.copyTo(buffer2, jMax, jIndexOf2 - jMax);
                        jM5650deprecated_size2 = ((long) byteStringM5652deprecated_encodeUtf10.m5650deprecated_size()) + buffer2.m5648deprecated_size();
                        headers = parseHeaders(buffer2);
                        jM5650deprecated_size = jM5650deprecated_size;
                    } else {
                        map = headers;
                    }
                    if (this.source.read(buffer, 4096) <= 0) {
                        return false;
                    }
                    listener = chunkListener;
                    jM5650deprecated_size = jM5650deprecated_size;
                    j = jM5648deprecated_size;
                } else {
                    map = headers;
                    emitProgress(map, buffer.m5648deprecated_size() - jM5650deprecated_size2, false, listener);
                }
                headers = map;
                if (this.source.read(buffer, 4096) <= 0) {
                    return false;
                }
                listener = chunkListener;
                jM5650deprecated_size = jM5650deprecated_size;
                j = jM5648deprecated_size;
            } else {
                long j2 = jM5650deprecated_size;
                Map map2 = headers;
                long j3 = jIndexOf - j2;
                if (j2 > 0) {
                    Buffer buffer3 = new Buffer();
                    buffer.skip(j2);
                    buffer.read(buffer3, j3);
                    listener = chunkListener;
                    emitProgress(map2, buffer3.m5648deprecated_size() - jM5650deprecated_size2, true, listener);
                    emitChunk(buffer3, z, listener);
                    headers = null;
                    jM5650deprecated_size2 = 0;
                } else {
                    listener = chunkListener;
                    buffer.skip(jIndexOf);
                    headers = map2;
                }
                if (z) {
                    return true;
                }
                jM5650deprecated_size = byteStringM5652deprecated_encodeUtf8.m5650deprecated_size();
                j = jM5650deprecated_size;
            }
        }
    }

    private final Map parseHeaders(Buffer buffer) {
        List listEmptyList;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listSplit = new Regex("\r\n").split(buffer.readUtf8(), 0);
        if (!listSplit.isEmpty()) {
            ListIterator listIterator = listSplit.listIterator(listSplit.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                    break;
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
            break;
        }
        for (String str : (String[]) listEmptyList.toArray(new String[0])) {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, 0, false, 6, (Object) null);
            if (iIndexOf$default != -1) {
                String strSubstring = str.substring(0, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                int length = strSubstring.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) strSubstring.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                String string = strSubstring.subSequence(i, length + 1).toString();
                String strSubstring2 = str.substring(iIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                int length2 = strSubstring2.length() - 1;
                int i2 = 0;
                boolean z3 = false;
                while (i2 <= length2) {
                    boolean z4 = Intrinsics.compare((int) strSubstring2.charAt(!z3 ? i2 : length2), 32) <= 0;
                    if (z3) {
                        if (!z4) {
                            break;
                        }
                        length2--;
                    } else if (z4) {
                        i2++;
                    } else {
                        z3 = true;
                    }
                }
                linkedHashMap.put(string, strSubstring2.subSequence(i2, length2 + 1).toString());
            }
        }
        return linkedHashMap;
    }

    private final void emitChunk(Buffer buffer, boolean z, ChunkListener chunkListener) throws EOFException {
        ByteString byteStringM5652deprecated_encodeUtf8 = ByteString.Companion.m5652deprecated_encodeUtf8("\r\n\r\n");
        long jIndexOf = buffer.indexOf(byteStringM5652deprecated_encodeUtf8);
        if (jIndexOf == -1) {
            chunkListener.onChunkComplete(MapsKt.emptyMap(), buffer, z);
            return;
        }
        Buffer buffer2 = new Buffer();
        Buffer buffer3 = new Buffer();
        buffer.read(buffer2, jIndexOf);
        buffer.skip(byteStringM5652deprecated_encodeUtf8.m5650deprecated_size());
        buffer.readAll(buffer3);
        chunkListener.onChunkComplete(parseHeaders(buffer2), buffer3, z);
    }

    private final void emitProgress(Map map, long j, boolean z, ChunkListener chunkListener) {
        if (chunkListener == null || map == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastProgressEvent > 16 || z) {
            this.lastProgressEvent = jCurrentTimeMillis;
            chunkListener.onChunkProgress(map, j, Long.parseLong((String) map.getOrDefault("Content-Length", "0")));
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
