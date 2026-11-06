package net.time4j.engine;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractDuration implements TimeSpan {
    public boolean isEmpty() {
        List totalLength = getTotalLength();
        int size = totalLength.size();
        for (int i = 0; i < size; i++) {
            if (((TimeSpan.Item) totalLength.get(i)).getAmount() > 0) {
                return false;
            }
        }
        return true;
    }
}
