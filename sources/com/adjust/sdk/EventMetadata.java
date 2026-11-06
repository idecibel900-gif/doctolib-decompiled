package com.adjust.sdk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class EventMetadata implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("eventSequence", Map.class)};
    private static final long serialVersionUID = 1;
    private Map<String, Integer> eventSequence = new HashMap();

    private void readObject(ObjectInputStream objectInputStream) {
        this.eventSequence = (Map) Util.readObjectField(objectInputStream.readFields(), "eventSequence", new HashMap());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Util.equalObject(this.eventSequence, ((EventMetadata) obj).eventSequence);
    }

    public int hashCode() {
        return Util.hashObject(this.eventSequence, 17);
    }

    public int incrementSequenceForEvent(String str) {
        Integer num = this.eventSequence.get(str);
        int iIntValue = (num != null ? num.intValue() : 0) + 1;
        this.eventSequence.put(str, Integer.valueOf(iIntValue));
        return iIntValue;
    }
}
