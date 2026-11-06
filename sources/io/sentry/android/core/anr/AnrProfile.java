package io.sentry.android.core.anr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class AnrProfile {
    public final long endTimeMs;
    public final List stacks;
    public final long startTimeMs;

    public AnrProfile(List list) {
        this.stacks = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AnrStackTrace anrStackTrace = (AnrStackTrace) it.next();
            if (anrStackTrace != null) {
                this.stacks.add(anrStackTrace);
            }
        }
        Collections.sort(this.stacks);
        if (!this.stacks.isEmpty()) {
            this.startTimeMs = ((AnrStackTrace) this.stacks.get(0)).timestampMs;
            List list2 = this.stacks;
            this.endTimeMs = ((AnrStackTrace) list2.get(list2.size() - 1)).timestampMs + 10000;
        } else {
            this.startTimeMs = 0L;
            this.endTimeMs = 0L;
        }
    }
}
