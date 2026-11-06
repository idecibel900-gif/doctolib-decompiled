package com.adjust.sdk.sig;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 int, still in use, count: 3, list:
      (r0v0 int) from 0x0019: SWITCH (r0v0 int)
     case -1811142716: goto B:118:0x0142
     case -1811142715: goto B:113:0x0135
     case -1811142714: goto B:108:0x0128
     case -1811142713: goto B:103:0x011b
     case -1811142712: goto B:98:0x010e
     case -1811142711: goto B:93:0x0101
     case -1811142710: goto B:88:0x00f4
     case -1811142709: goto B:83:0x00e7
     case -1811142708: goto B:78:0x00da
     case -1811142707: goto B:73:0x00cd
     default: goto B:5:0x001c A[RegionRef:SW:4]
      (r0v0 int) from 0x001c: SWITCH (r0v0 int)
     case -1811142685: goto B:68:0x00c0
     case -1811142684: goto B:63:0x00b3
     case -1811142683: goto B:58:0x00a6
     default: goto B:6:0x001f A[RegionRef:SW:5]
      (r0v0 int) from 0x001f: SWITCH (r0v0 int)
     case 80123371: goto B:53:0x0099
     case 80123372: goto B:48:0x008c
     case 80123373: goto B:43:0x007f
     case 80123374: goto B:38:0x0072
     case 80123375: goto B:33:0x0065
     case 80123376: goto B:28:0x0058
     case 80123377: goto B:23:0x004b
     case 80123378: goto B:18:0x003e
     case 80123379: goto B:13:0x0031
     case 80123380: goto B:8:0x0024
     default: goto B:313:? A[RegionRef:SW:6]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String a(String str) {
        switch (str) {
            case "kotlin.jvm.internal.DoubleCompanionObject":
                return "Companion";
            case "java.lang.Integer":
                return "Int";
            case "java.lang.Cloneable":
                return "Cloneable";
            case "java.lang.annotation.Annotation":
                return "Annotation";
            case "java.lang.Comparable":
                return "Comparable";
            case "java.util.Map":
                return "Map";
            case "java.util.Set":
                return "Set";
            case "double":
                return "Double";
            case "kotlin.jvm.internal.ByteCompanionObject":
                return "Companion";
            case "java.lang.CharSequence":
                return "CharSequence";
            case "java.util.Collection":
                return "Collection";
            case "java.lang.Float":
                return "Float";
            case "java.lang.Short":
                return "Short";
            case "kotlin.jvm.internal.CharCompanionObject":
                return "Companion";
            case "kotlin.jvm.internal.LongCompanionObject":
                return "Companion";
            case "java.util.Map$Entry":
                return "Entry";
            case "int":
                return "Int";
            case "byte":
                return "Byte";
            case "char":
                return "Char";
            case "long":
                return "Long";
            case "boolean":
                return "Boolean";
            case "java.util.List":
                return "List";
            case "kotlin.jvm.internal.ShortCompanionObject":
                return "Companion";
            case "float":
                return "Float";
            case "short":
                return "Short";
            case "java.lang.Character":
                return "Char";
            case "kotlin.jvm.internal.EnumCompanionObject":
                return "Companion";
            case "java.lang.Boolean":
                return "Boolean";
            case "java.lang.Byte":
                return "Byte";
            case "java.lang.Enum":
                return "Enum";
            case "java.lang.Long":
                return "Long";
            case "kotlin.jvm.internal.FloatCompanionObject":
                return "Companion";
            case "java.util.Iterator":
                return "Iterator";
            case "java.util.ListIterator":
                return "ListIterator";
            case "kotlin.jvm.internal.StringCompanionObject":
                return "Companion";
            case "java.lang.Double":
                return "Double";
            case "java.lang.Number":
                return "Number";
            case "java.lang.Object":
                return "Any";
            case "java.lang.String":
                return "String";
            case "java.lang.Iterable":
                return "Iterable";
            case "kotlin.jvm.internal.BooleanCompanionObject":
                return "Companion";
            case "java.lang.Throwable":
                return "Throwable";
            case "kotlin.jvm.internal.IntCompanionObject":
                return "Companion";
            default:
                switch (str) {
                    case -1811142716:
                        if (str.equals("kotlin.jvm.functions.Function10")) {
                            return "Function10";
                        }
                        return null;
                    case -1811142715:
                        if (str.equals("kotlin.jvm.functions.Function11")) {
                            return "Function11";
                        }
                        return null;
                    case -1811142714:
                        if (str.equals("kotlin.jvm.functions.Function12")) {
                            return "Function12";
                        }
                        return null;
                    case -1811142713:
                        if (str.equals("kotlin.jvm.functions.Function13")) {
                            return "Function13";
                        }
                        return null;
                    case -1811142712:
                        if (str.equals("kotlin.jvm.functions.Function14")) {
                            return "Function14";
                        }
                        return null;
                    case -1811142711:
                        if (str.equals("kotlin.jvm.functions.Function15")) {
                            return "Function15";
                        }
                        return null;
                    case -1811142710:
                        if (str.equals("kotlin.jvm.functions.Function16")) {
                            return "Function16";
                        }
                        return null;
                    case -1811142709:
                        if (str.equals("kotlin.jvm.functions.Function17")) {
                            return "Function17";
                        }
                        return null;
                    case -1811142708:
                        if (str.equals("kotlin.jvm.functions.Function18")) {
                            return "Function18";
                        }
                        return null;
                    case -1811142707:
                        if (str.equals("kotlin.jvm.functions.Function19")) {
                            return "Function19";
                        }
                        return null;
                    default:
                        switch (str) {
                            case -1811142685:
                                if (str.equals("kotlin.jvm.functions.Function20")) {
                                    return "Function20";
                                }
                                return null;
                            case -1811142684:
                                if (str.equals("kotlin.jvm.functions.Function21")) {
                                    return "Function21";
                                }
                                return null;
                            case -1811142683:
                                if (str.equals("kotlin.jvm.functions.Function22")) {
                                    return "Function22";
                                }
                                return null;
                            default:
                                switch (str) {
                                    case 80123371:
                                        if (str.equals("kotlin.jvm.functions.Function0")) {
                                            return "Function0";
                                        }
                                        return null;
                                    case 80123372:
                                        if (str.equals("kotlin.jvm.functions.Function1")) {
                                            return "Function1";
                                        }
                                        return null;
                                    case 80123373:
                                        if (str.equals("kotlin.jvm.functions.Function2")) {
                                            return "Function2";
                                        }
                                        return null;
                                    case 80123374:
                                        if (str.equals("kotlin.jvm.functions.Function3")) {
                                            return "Function3";
                                        }
                                        return null;
                                    case 80123375:
                                        if (str.equals("kotlin.jvm.functions.Function4")) {
                                            return "Function4";
                                        }
                                        return null;
                                    case 80123376:
                                        if (str.equals("kotlin.jvm.functions.Function5")) {
                                            return "Function5";
                                        }
                                        return null;
                                    case 80123377:
                                        if (str.equals("kotlin.jvm.functions.Function6")) {
                                            return "Function6";
                                        }
                                        return null;
                                    case 80123378:
                                        if (str.equals("kotlin.jvm.functions.Function7")) {
                                            return "Function7";
                                        }
                                        return null;
                                    case 80123379:
                                        if (str.equals("kotlin.jvm.functions.Function8")) {
                                            return "Function8";
                                        }
                                        return null;
                                    case 80123380:
                                        if (str.equals("kotlin.jvm.functions.Function9")) {
                                            return "Function9";
                                        }
                                        return null;
                                    default:
                                        return null;
                                }
                        }
                }
        }
    }
}
