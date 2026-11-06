package androidx.media3.datasource.cache;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultContentMetadata implements ContentMetadata {
    public static final DefaultContentMetadata EMPTY = new DefaultContentMetadata(Collections.EMPTY_MAP);
    private int hashCode;
    private final Map metadata;

    public DefaultContentMetadata(Map map) {
        this.metadata = Collections.unmodifiableMap(map);
    }

    public DefaultContentMetadata copyWithMutationsApplied(ContentMetadataMutations contentMetadataMutations) {
        Map mapApplyMutations = applyMutations(this.metadata, contentMetadataMutations);
        return isMetadataEqual(this.metadata, mapApplyMutations) ? this : new DefaultContentMetadata(mapApplyMutations);
    }

    public Set entrySet() {
        return this.metadata.entrySet();
    }

    @Override // androidx.media3.datasource.cache.ContentMetadata
    public final String get(String str, String str2) {
        byte[] bArr = (byte[]) this.metadata.get(str);
        return bArr != null ? new String(bArr, StandardCharsets.UTF_8) : str2;
    }

    @Override // androidx.media3.datasource.cache.ContentMetadata
    public final long get(String str, long j) {
        byte[] bArr = (byte[]) this.metadata.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultContentMetadata.class != obj.getClass()) {
            return false;
        }
        return isMetadataEqual(this.metadata, ((DefaultContentMetadata) obj).metadata);
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            int iHashCode = 0;
            for (Map.Entry entry : this.metadata.entrySet()) {
                iHashCode += Arrays.hashCode((byte[]) entry.getValue()) ^ ((String) entry.getKey()).hashCode();
            }
            this.hashCode = iHashCode;
        }
        return this.hashCode;
    }

    private static boolean isMetadataEqual(Map map, Map map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!Arrays.equals((byte[]) entry.getValue(), (byte[]) map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static Map applyMutations(Map map, ContentMetadataMutations contentMetadataMutations) {
        HashMap map2 = new HashMap(map);
        removeValues(map2, contentMetadataMutations.getRemovedValues());
        addValues(map2, contentMetadataMutations.getEditedValues());
        return map2;
    }

    private static void removeValues(HashMap map, List list) {
        for (int i = 0; i < list.size(); i++) {
            map.remove(list.get(i));
        }
    }

    private static void addValues(HashMap map, Map map2) {
        for (Map.Entry entry : map2.entrySet()) {
            map.put((String) entry.getKey(), getBytes(entry.getValue()));
        }
    }

    private static byte[] getBytes(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(StandardCharsets.UTF_8);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }
}
