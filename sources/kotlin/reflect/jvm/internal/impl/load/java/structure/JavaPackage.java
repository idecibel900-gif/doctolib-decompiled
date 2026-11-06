package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public interface JavaPackage extends JavaAnnotationOwner {
    Collection getClasses(Function1 function1);

    FqName getFqName();

    Collection getSubPackages();
}
