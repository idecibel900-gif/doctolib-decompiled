package app.notifee.core.utility;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ColorUtils {
    private static final HashMap iColorNameMap;

    public static String getColorString(int i) {
        String str = (String) iColorNameMap.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        return "#" + Integer.toHexString(i).substring(2);
    }

    static {
        HashMap map = new HashMap();
        iColorNameMap = map;
        map.put(-16777216, "black");
        map.put(-12303292, "darkgray");
        map.put(-7829368, "gray");
        map.put(-3355444, "lightgray");
        map.put(-1, "white");
        map.put(-65536, "red");
        map.put(-16711936, "green");
        map.put(-16776961, "blue");
        map.put(-256, "yellow");
        map.put(-16711681, "cyan");
        map.put(-65281, "magenta");
        map.put(-16711681, "aqua");
        map.put(-65281, "fuchsia");
        map.put(-12303292, "darkgrey");
        map.put(-7829368, "grey");
        map.put(-3355444, "lightgrey");
        map.put(-16711936, "lime");
        map.put(-8388608, "maroon");
        map.put(-16777088, "navy");
        map.put(-8355840, "olive");
        map.put(-8388480, "purple");
        map.put(-4144960, "silver");
        map.put(-16744320, "teal");
    }
}
