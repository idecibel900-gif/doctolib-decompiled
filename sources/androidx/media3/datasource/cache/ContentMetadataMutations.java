package androidx.media3.datasource.cache;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ContentMetadataMutations {
    private final Map editedValues = new HashMap();
    private final List removedValues = new ArrayList();

    public static ContentMetadataMutations setContentLength(ContentMetadataMutations contentMetadataMutations, long j) {
        return contentMetadataMutations.set("exo_len", j);
    }

    public static ContentMetadataMutations setRedirectedUri(ContentMetadataMutations contentMetadataMutations, Uri uri) {
        if (uri != null) {
            return contentMetadataMutations.set("exo_redir", uri.toString());
        }
        return contentMetadataMutations.remove("exo_redir");
    }

    public ContentMetadataMutations set(String str, String str2) {
        return checkAndSet(str, str2);
    }

    public ContentMetadataMutations set(String str, long j) {
        return checkAndSet(str, Long.valueOf(j));
    }

    public ContentMetadataMutations remove(String str) {
        this.removedValues.add(str);
        this.editedValues.remove(str);
        return this;
    }

    public List getRemovedValues() {
        return Collections.unmodifiableList(new ArrayList(this.removedValues));
    }

    public Map getEditedValues() {
        HashMap map = new HashMap(this.editedValues);
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(map);
    }

    private ContentMetadataMutations checkAndSet(String str, Object obj) {
        this.editedValues.put((String) Assertions.checkNotNull(str), Assertions.checkNotNull(obj));
        this.removedValues.remove(str);
        return this;
    }
}
