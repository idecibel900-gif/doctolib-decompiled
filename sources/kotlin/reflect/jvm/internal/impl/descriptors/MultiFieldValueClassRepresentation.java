package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public final class MultiFieldValueClassRepresentation extends ValueClassRepresentation {
    private final Map map;
    private final List underlyingPropertyNamesToTypes;

    public List getUnderlyingPropertyNamesToTypes() {
        return this.underlyingPropertyNamesToTypes;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiFieldValueClassRepresentation(List underlyingPropertyNamesToTypes) {
        super(null);
        Intrinsics.checkNotNullParameter(underlyingPropertyNamesToTypes, "underlyingPropertyNamesToTypes");
        this.underlyingPropertyNamesToTypes = underlyingPropertyNamesToTypes;
        this.map = MapsKt.toMap(getUnderlyingPropertyNamesToTypes());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation
    public boolean containsPropertyWithName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.map.containsKey(name);
    }

    public String toString() {
        return "MultiFieldValueClassRepresentation(underlyingPropertyNamesToTypes=" + getUnderlyingPropertyNamesToTypes() + ')';
    }
}
