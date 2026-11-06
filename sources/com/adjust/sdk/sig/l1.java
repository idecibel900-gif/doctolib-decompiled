package com.adjust.sdk.sig;

/* JADX INFO: loaded from: classes3.dex */
public final class l1 {
    public final boolean a;
    public final boolean b;
    public final int c;

    public l1(boolean z, boolean z2, int i) {
        this.a = z;
        this.b = z2;
        this.c = i;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("JsonConfiguration(encodeDefaults=");
        sb.append(this.a);
        sb.append(", ignoreUnknownKeys=false, isLenient=false, allowStructuredMapKeys=false, prettyPrint=false, explicitNulls=");
        sb.append(this.b);
        sb.append(", prettyPrintIndent='    ', coerceInputValues=false, useArrayPolymorphism=false, classDiscriminator='type', allowSpecialFloatingPointValues=false, useAlternativeNames=true, namingStrategy=null, decodeEnumsCaseInsensitive=false, allowTrailingComma=false, allowComments=false, classDiscriminatorMode=");
        int i = this.c;
        if (i == 1) {
            str = "NONE";
        } else if (i != 2) {
            str = i != 3 ? "null" : "POLYMORPHIC";
        } else {
            str = "ALL_JSON_OBJECTS";
        }
        sb.append(str);
        sb.append(", exceptionsWithDebugInfo=true)");
        return sb.toString();
    }
}
