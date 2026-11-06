package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FindClassInModuleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int findNonGenericClassAcrossDependencies$lambda$1(ClassId it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return 0;
    }

    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor classifierDescriptorFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (classifierDescriptorFindClassifierAcrossModuleDependencies instanceof ClassDescriptor) {
            return (ClassDescriptor) classifierDescriptorFindClassifierAcrossModuleDependencies;
        }
        return null;
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor moduleDescriptor, ClassId classId, NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        return classDescriptorFindClassAcrossModuleDependencies != null ? classDescriptorFindClassAcrossModuleDependencies : notFoundClasses.getClass(classId, SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(classId, new PropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ClassId) obj).getOuterClassId();
            }
        }), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return Integer.valueOf(FindClassInModuleKt.findNonGenericClassAcrossDependencies$lambda$1((ClassId) obj));
            }
        })));
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor classifierDescriptorFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (classifierDescriptorFindClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) classifierDescriptorFindClassifierAcrossModuleDependencies;
        }
        return null;
    }

    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ModuleDescriptor resolutionAnchorIfAny = ResolutionAnchorProviderKt.getResolutionAnchorIfAny(moduleDescriptor);
        if (resolutionAnchorIfAny == null) {
            PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(classId.getPackageFqName());
            List listPathSegments = classId.getRelativeClassName().pathSegments();
            ClassifierDescriptor classifierDescriptorMo5389getContributedClassifier = packageViewDescriptor.getMemberScope().mo5389getContributedClassifier((Name) CollectionsKt.first(listPathSegments), NoLookupLocation.FROM_DESERIALIZATION);
            if (classifierDescriptorMo5389getContributedClassifier == null) {
                return null;
            }
            for (Name name : listPathSegments.subList(1, listPathSegments.size())) {
                if (!(classifierDescriptorMo5389getContributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                ClassifierDescriptor classifierDescriptorMo5389getContributedClassifier2 = ((ClassDescriptor) classifierDescriptorMo5389getContributedClassifier).getUnsubstitutedInnerClassesScope().mo5389getContributedClassifier(name, NoLookupLocation.FROM_DESERIALIZATION);
                classifierDescriptorMo5389getContributedClassifier = classifierDescriptorMo5389getContributedClassifier2 instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo5389getContributedClassifier2 : null;
                if (classifierDescriptorMo5389getContributedClassifier == null) {
                    return null;
                }
            }
            return classifierDescriptorMo5389getContributedClassifier;
        }
        PackageViewDescriptor packageViewDescriptor2 = resolutionAnchorIfAny.getPackage(classId.getPackageFqName());
        List listPathSegments2 = classId.getRelativeClassName().pathSegments();
        ClassifierDescriptor classifierDescriptorMo5389getContributedClassifier3 = packageViewDescriptor2.getMemberScope().mo5389getContributedClassifier((Name) CollectionsKt.first(listPathSegments2), NoLookupLocation.FROM_DESERIALIZATION);
        if (classifierDescriptorMo5389getContributedClassifier3 == null) {
            classifierDescriptorMo5389getContributedClassifier3 = null;
            break;
        }
        for (Name name2 : listPathSegments2.subList(1, listPathSegments2.size())) {
            if (classifierDescriptorMo5389getContributedClassifier3 instanceof ClassDescriptor) {
                ClassifierDescriptor classifierDescriptorMo5389getContributedClassifier4 = ((ClassDescriptor) classifierDescriptorMo5389getContributedClassifier3).getUnsubstitutedInnerClassesScope().mo5389getContributedClassifier(name2, NoLookupLocation.FROM_DESERIALIZATION);
                classifierDescriptorMo5389getContributedClassifier3 = classifierDescriptorMo5389getContributedClassifier4 instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo5389getContributedClassifier4 : null;
                if (classifierDescriptorMo5389getContributedClassifier3 != null) {
                }
            }
            classifierDescriptorMo5389getContributedClassifier3 = null;
        }
        if (classifierDescriptorMo5389getContributedClassifier3 != null) {
            return classifierDescriptorMo5389getContributedClassifier3;
        }
        PackageViewDescriptor packageViewDescriptor3 = moduleDescriptor.getPackage(classId.getPackageFqName());
        List listPathSegments3 = classId.getRelativeClassName().pathSegments();
        ClassifierDescriptor classifierDescriptorMo5389getContributedClassifier5 = packageViewDescriptor3.getMemberScope().mo5389getContributedClassifier((Name) CollectionsKt.first(listPathSegments3), NoLookupLocation.FROM_DESERIALIZATION);
        if (classifierDescriptorMo5389getContributedClassifier5 == null) {
            return null;
        }
        for (Name name3 : listPathSegments3.subList(1, listPathSegments3.size())) {
            if (!(classifierDescriptorMo5389getContributedClassifier5 instanceof ClassDescriptor)) {
                return null;
            }
            ClassifierDescriptor classifierDescriptorMo5389getContributedClassifier6 = ((ClassDescriptor) classifierDescriptorMo5389getContributedClassifier5).getUnsubstitutedInnerClassesScope().mo5389getContributedClassifier(name3, NoLookupLocation.FROM_DESERIALIZATION);
            classifierDescriptorMo5389getContributedClassifier5 = classifierDescriptorMo5389getContributedClassifier6 instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo5389getContributedClassifier6 : null;
            if (classifierDescriptorMo5389getContributedClassifier5 == null) {
                return null;
            }
        }
        return classifierDescriptorMo5389getContributedClassifier5;
    }
}
