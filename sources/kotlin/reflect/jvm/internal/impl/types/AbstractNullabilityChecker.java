package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* JADX INFO: loaded from: classes5.dex */
public final class AbstractNullabilityChecker {
    public static final AbstractNullabilityChecker INSTANCE = new AbstractNullabilityChecker();

    private AbstractNullabilityChecker() {
    }

    public final boolean isPossibleSubtype(TypeCheckerState state, RigidTypeMarker subType, RigidTypeMarker superType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return runIsPossibleSubtype(state, subType, superType);
    }

    private final boolean runIsPossibleSubtype(TypeCheckerState typeCheckerState, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS) {
            if (!typeSystemContext.isSingleClassifierType(rigidTypeMarker) && !typeSystemContext.isIntersection(typeSystemContext.typeConstructor(rigidTypeMarker))) {
                typeCheckerState.isAllowedTypeVariable(rigidTypeMarker);
            }
            if (!typeSystemContext.isSingleClassifierType(rigidTypeMarker2)) {
                typeCheckerState.isAllowedTypeVariable(rigidTypeMarker2);
            }
        }
        if (typeSystemContext.isMarkedNullable(rigidTypeMarker2) || typeSystemContext.isDefinitelyNotNullType(rigidTypeMarker) || typeSystemContext.isNotNullTypeParameter(rigidTypeMarker)) {
            return true;
        }
        if ((rigidTypeMarker instanceof CapturedTypeMarker) && typeSystemContext.isProjectionNotNull((CapturedTypeMarker) rigidTypeMarker)) {
            return true;
        }
        AbstractNullabilityChecker abstractNullabilityChecker = INSTANCE;
        if (abstractNullabilityChecker.hasNotNullSupertype(typeCheckerState, rigidTypeMarker, TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE)) {
            return true;
        }
        if (typeSystemContext.isDefinitelyNotNullType(rigidTypeMarker2) || abstractNullabilityChecker.hasNotNullSupertype(typeCheckerState, rigidTypeMarker2, TypeCheckerState.SupertypesPolicy.UpperIfFlexible.INSTANCE) || typeSystemContext.isClassType(rigidTypeMarker)) {
            return false;
        }
        return abstractNullabilityChecker.hasPathByNotMarkedNullableNodes(typeCheckerState, rigidTypeMarker, typeSystemContext.typeConstructor(rigidTypeMarker2));
    }

    public final boolean hasNotNullSupertype(TypeCheckerState typeCheckerState, RigidTypeMarker type, TypeCheckerState.SupertypesPolicy supertypesPolicy) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(supertypesPolicy, "supertypesPolicy");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if ((typeSystemContext.isClassType(type) && !typeSystemContext.isMarkedNullable(type)) || typeSystemContext.isDefinitelyNotNullType(type)) {
            return true;
        }
        typeCheckerState.initialize();
        ArrayDeque supertypesDeque = typeCheckerState.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set supertypesSet = typeCheckerState.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(type);
        while (!supertypesDeque.isEmpty()) {
            RigidTypeMarker rigidTypeMarker = (RigidTypeMarker) supertypesDeque.pop();
            Intrinsics.checkNotNull(rigidTypeMarker);
            if (supertypesSet.add(rigidTypeMarker)) {
                TypeCheckerState.SupertypesPolicy supertypesPolicy2 = typeSystemContext.isMarkedNullable(rigidTypeMarker) ? TypeCheckerState.SupertypesPolicy.None.INSTANCE : supertypesPolicy;
                if (Intrinsics.areEqual(supertypesPolicy2, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    supertypesPolicy2 = null;
                }
                if (supertypesPolicy2 == null) {
                    continue;
                } else {
                    TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                    Iterator it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(rigidTypeMarker)).iterator();
                    while (it.hasNext()) {
                        RigidTypeMarker rigidTypeMarkerMo5391transformType = supertypesPolicy2.mo5391transformType(typeCheckerState, (KotlinTypeMarker) it.next());
                        if ((typeSystemContext.isClassType(rigidTypeMarkerMo5391transformType) && !typeSystemContext.isMarkedNullable(rigidTypeMarkerMo5391transformType)) || typeSystemContext.isDefinitelyNotNullType(rigidTypeMarkerMo5391transformType)) {
                            typeCheckerState.clear();
                            return true;
                        }
                        supertypesDeque.add(rigidTypeMarkerMo5391transformType);
                    }
                }
            }
        }
        typeCheckerState.clear();
        return false;
    }

    public final boolean hasPathByNotMarkedNullableNodes(TypeCheckerState state, RigidTypeMarker start, TypeConstructorMarker end) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        TypeSystemContext typeSystemContext = state.getTypeSystemContext();
        if (INSTANCE.isApplicableAsEndNode(state, start, end)) {
            return true;
        }
        state.initialize();
        ArrayDeque supertypesDeque = state.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set supertypesSet = state.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(start);
        while (!supertypesDeque.isEmpty()) {
            RigidTypeMarker rigidTypeMarker = (RigidTypeMarker) supertypesDeque.pop();
            Intrinsics.checkNotNull(rigidTypeMarker);
            if (supertypesSet.add(rigidTypeMarker)) {
                TypeCheckerState.SupertypesPolicy supertypesPolicy = typeSystemContext.isMarkedNullable(rigidTypeMarker) ? TypeCheckerState.SupertypesPolicy.None.INSTANCE : TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                if (Intrinsics.areEqual(supertypesPolicy, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    supertypesPolicy = null;
                }
                if (supertypesPolicy == null) {
                    continue;
                } else {
                    TypeSystemContext typeSystemContext2 = state.getTypeSystemContext();
                    Iterator it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(rigidTypeMarker)).iterator();
                    while (it.hasNext()) {
                        RigidTypeMarker rigidTypeMarkerMo5391transformType = supertypesPolicy.mo5391transformType(state, (KotlinTypeMarker) it.next());
                        if (INSTANCE.isApplicableAsEndNode(state, rigidTypeMarkerMo5391transformType, end)) {
                            state.clear();
                            return true;
                        }
                        supertypesDeque.add(rigidTypeMarkerMo5391transformType);
                    }
                }
            }
        }
        state.clear();
        return false;
    }

    private final boolean isApplicableAsEndNode(TypeCheckerState typeCheckerState, RigidTypeMarker rigidTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (typeSystemContext.isNothing(rigidTypeMarker)) {
            return true;
        }
        if (typeSystemContext.isMarkedNullable(rigidTypeMarker)) {
            return false;
        }
        if (typeCheckerState.isStubTypeEqualsToAnything() && typeSystemContext.isStubType(rigidTypeMarker)) {
            return true;
        }
        return typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(rigidTypeMarker), typeConstructorMarker);
    }
}
