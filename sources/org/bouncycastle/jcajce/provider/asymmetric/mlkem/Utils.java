package org.bouncycastle.jcajce.provider.asymmetric.mlkem;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.jcajce.spec.MLKEMParameterSpec;
import org.bouncycastle.pqc.crypto.mlkem.MLKEMParameters;

/* JADX INFO: loaded from: classes5.dex */
abstract class Utils {
    private static Map parameters;

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(MLKEMParameterSpec.ml_kem_512.getName(), MLKEMParameters.ml_kem_512);
        parameters.put(MLKEMParameterSpec.ml_kem_768.getName(), MLKEMParameters.ml_kem_768);
        parameters.put(MLKEMParameterSpec.ml_kem_1024.getName(), MLKEMParameters.ml_kem_1024);
    }

    static MLKEMParameters getParameters(String str) {
        return (MLKEMParameters) parameters.get(str);
    }
}
