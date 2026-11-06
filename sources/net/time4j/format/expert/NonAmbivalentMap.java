package net.time4j.format.expert;

import java.util.HashMap;
import java.util.Map;
import net.time4j.engine.ChronoElement;

/* JADX INFO: loaded from: classes5.dex */
class NonAmbivalentMap extends HashMap {
    private static final long serialVersionUID = 1245025551222311435L;

    NonAmbivalentMap(Map map) {
        super(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(ChronoElement chronoElement, Object obj) {
        Object objPut = super.put(chronoElement, obj);
        if (chronoElement == null || objPut == null || objPut.equals(obj)) {
            return objPut;
        }
        throw new AmbivalentValueException(chronoElement);
    }
}
