package com.horcrux.svg;

import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
class GlyphPathBag {
    private final int[][] data;
    private final Paint paint;
    private final ArrayList paths;

    GlyphPathBag(Paint paint) {
        ArrayList arrayList = new ArrayList();
        this.paths = arrayList;
        this.data = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER][];
        this.paint = paint;
        arrayList.add(new Path());
    }

    Path getOrCreateAndCache(char c, String str) {
        Path path;
        int index = getIndex(c);
        if (index != 0) {
            path = (Path) this.paths.get(index);
        } else {
            Path path2 = new Path();
            this.paint.getTextPath(str, 0, 1, 0.0f, 0.0f, path2);
            int[][] iArr = this.data;
            int i = c >> '\b';
            int[] iArr2 = iArr[i];
            if (iArr2 == null) {
                iArr2 = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
                iArr[i] = iArr2;
            }
            iArr2[c & 255] = this.paths.size();
            this.paths.add(path2);
            path = path2;
        }
        Path path3 = new Path();
        path3.addPath(path);
        return path3;
    }

    private int getIndex(char c) {
        int[] iArr = this.data[c >> '\b'];
        if (iArr == null) {
            return 0;
        }
        return iArr[c & 255];
    }
}
