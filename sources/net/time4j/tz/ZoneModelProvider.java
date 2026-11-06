package net.time4j.tz;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public interface ZoneModelProvider {
    Map getAliases();

    Set getAvailableIDs();

    String getFallback();

    String getLocation();

    String getName();

    ZoneNameProvider getSpecificZoneNameRepository();

    String getVersion();

    TransitionHistory load(String str);
}
