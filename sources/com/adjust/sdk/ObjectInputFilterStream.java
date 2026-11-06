package com.adjust.sdk;

import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class ObjectInputFilterStream extends ObjectInputStream {
    static final Set<String> ALLOWED_CLASSES = new HashSet(Arrays.asList("java.lang.Boolean", "java.lang.Double", "java.lang.Enum", "java.lang.Float", "java.lang.Integer", "java.lang.Long", "java.lang.Number", "java.lang.String", "java.util.ArrayList", "java.util.HashMap", "java.util.LinkedHashMap", "java.util.LinkedList", "com.adjust.sdk.ActivityKind", "com.adjust.sdk.ActivityPackage", "com.adjust.sdk.ActivityState", "com.adjust.sdk.AdjustAttribution", "com.adjust.sdk.EventMetadata"));

    public ObjectInputFilterStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws InvalidClassException {
        if (ALLOWED_CLASSES.contains(objectStreamClass.getName())) {
            return super.resolveClass(objectStreamClass);
        }
        throw new InvalidClassException("Blocked deserialization", objectStreamClass.getName());
    }
}
