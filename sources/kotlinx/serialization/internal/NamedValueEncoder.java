package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NamedValueEncoder extends TaggedEncoder {
    protected abstract String composeName(String str, String str2);

    protected abstract String elementName(SerialDescriptor serialDescriptor, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public final String getTag(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return nested(elementName(serialDescriptor, i));
    }

    protected final String nested(String nestedName) {
        Intrinsics.checkNotNullParameter(nestedName, "nestedName");
        String str = (String) getCurrentTagOrNull();
        if (str == null) {
            str = "";
        }
        return composeName(str, nestedName);
    }
}
