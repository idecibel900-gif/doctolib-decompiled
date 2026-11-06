package expo.modules.kotlin.jni;

import com.opentok.android.PublisherKit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0016\u0012\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0003\"\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\b\u0010\r\u001a\u00020\fH\u0007J\u0015\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0004H\u0007J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/kotlin/jni/ExpectedType;", "", "innerPossibleTypes", "", "Lexpo/modules/kotlin/jni/SingleType;", "<init>", "([Lexpo/modules/kotlin/jni/SingleType;)V", "expectedTypes", "Lexpo/modules/kotlin/jni/CppType;", "([Lexpo/modules/kotlin/jni/CppType;)V", "[Lexpo/modules/kotlin/jni/SingleType;", "innerCombinedTypes", "", "getCombinedTypes", "getPossibleTypes", "()[Lexpo/modules/kotlin/jni/SingleType;", "getFirstType", "hashCode", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpectedType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int innerCombinedTypes;
    private final SingleType[] innerPossibleTypes;

    public ExpectedType(SingleType... innerPossibleTypes) {
        Intrinsics.checkNotNullParameter(innerPossibleTypes, "innerPossibleTypes");
        this.innerPossibleTypes = innerPossibleTypes;
        int cppType = 0;
        for (SingleType singleType : innerPossibleTypes) {
            cppType |= singleType.getCppType();
        }
        this.innerCombinedTypes = cppType;
    }

    /* JADX INFO: renamed from: getCombinedTypes, reason: from getter */
    public final int getInnerCombinedTypes() {
        return this.innerCombinedTypes;
    }

    /* JADX INFO: renamed from: getPossibleTypes, reason: from getter */
    public final SingleType[] getInnerPossibleTypes() {
        return this.innerPossibleTypes;
    }

    public final SingleType getFirstType() {
        return (SingleType) ArraysKt.first(this.innerPossibleTypes);
    }

    public int hashCode() {
        return (this.innerCombinedTypes * 31) + Arrays.hashCode(this.innerPossibleTypes);
    }

    public boolean equals(Object other) {
        if (!(other instanceof ExpectedType)) {
            return false;
        }
        SingleType[] singleTypeArr = this.innerPossibleTypes;
        ExpectedType expectedType = (ExpectedType) other;
        if (singleTypeArr.length != expectedType.innerPossibleTypes.length) {
            return false;
        }
        int length = singleTypeArr.length;
        for (int i = 0; i < length; i++) {
            if (this.innerPossibleTypes[i].getExpectedCppType() != expectedType.innerPossibleTypes[i].getExpectedCppType() || !Intrinsics.areEqual(this.innerPossibleTypes[i], expectedType.innerPossibleTypes[i])) {
                return false;
            }
        }
        return true;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ExpectedType forPrimitiveArray(CppType parameterType) {
            Intrinsics.checkNotNullParameter(parameterType, "parameterType");
            return new ExpectedType(new SingleType(CppType.PRIMITIVE_ARRAY, new ExpectedType[]{new ExpectedType(parameterType)}));
        }

        public final ExpectedType forArray(ExpectedType parameterType) {
            Intrinsics.checkNotNullParameter(parameterType, "parameterType");
            return new ExpectedType(new SingleType(CppType.ARRAY, new ExpectedType[]{parameterType}));
        }

        public final ExpectedType forEnum() {
            return new ExpectedType(CppType.STRING, CppType.INT);
        }

        public final ExpectedType forList(ExpectedType parameterType) {
            Intrinsics.checkNotNullParameter(parameterType, "parameterType");
            return new ExpectedType(new SingleType(CppType.LIST, new ExpectedType[]{parameterType}));
        }

        public final ExpectedType forMap(ExpectedType valueType) {
            Intrinsics.checkNotNullParameter(valueType, "valueType");
            return new ExpectedType(new SingleType(CppType.MAP, new ExpectedType[]{valueType}));
        }

        public final ExpectedType merge(ExpectedType... types) {
            Intrinsics.checkNotNullParameter(types, "types");
            ArrayList arrayList = new ArrayList();
            for (ExpectedType expectedType : types) {
                CollectionsKt.addAll(arrayList, ArraysKt.asIterable(expectedType.innerPossibleTypes));
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : arrayList) {
                CppType expectedCppType$expo_modules_core_release = ((SingleType) obj).getExpectedCppType();
                Object arrayList2 = linkedHashMap.get(expectedCppType$expo_modules_core_release);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap.put(expectedCppType$expo_modules_core_release, arrayList2);
                }
                ((List) arrayList2).add(obj);
            }
            ArrayList arrayList3 = new ArrayList(linkedHashMap.size());
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((List) ((Map.Entry) it.next()).getValue()).iterator();
                if (!it2.hasNext()) {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
                Object next = it2.next();
                while (it2.hasNext()) {
                    next = SingleType.INSTANCE.merge((SingleType) next, (SingleType) it2.next());
                }
                arrayList3.add((SingleType) next);
            }
            SingleType[] singleTypeArr = (SingleType[]) arrayList3.toArray(new SingleType[0]);
            return new ExpectedType((SingleType[]) Arrays.copyOf(singleTypeArr, singleTypeArr.length));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExpectedType(CppType... expectedTypes) {
        Intrinsics.checkNotNullParameter(expectedTypes, "expectedTypes");
        ArrayList arrayList = new ArrayList(expectedTypes.length);
        for (CppType cppType : expectedTypes) {
            arrayList.add(new SingleType(cppType, null, 2, 0 == true ? 1 : 0));
        }
        SingleType[] singleTypeArr = (SingleType[]) arrayList.toArray(new SingleType[0]);
        this((SingleType[]) Arrays.copyOf(singleTypeArr, singleTypeArr.length));
    }
}
