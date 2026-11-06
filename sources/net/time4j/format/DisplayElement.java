package net.time4j.format;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.time4j.engine.BasicElement;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DisplayElement extends BasicElement {
    private static final Map OTHER_DISPLAY_KEYS;

    static {
        HashMap map = new HashMap();
        map.put("YEAR_OF_DISPLAY", "L_year");
        map.put("MONTH_AS_NUMBER", "L_month");
        map.put("HOUR_FROM_0_TO_24", "L_hour");
        map.put("DAY_OF_MONTH", "L_day");
        map.put("DAY_OF_DIVISION", "L_day");
        OTHER_DISPLAY_KEYS = Collections.unmodifiableMap(map);
    }

    protected DisplayElement(String str) {
        super(str);
    }
}
