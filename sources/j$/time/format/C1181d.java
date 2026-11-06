package j$.time.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: j$.time.format.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1181d implements InterfaceC1182e {
    public final InterfaceC1182e[] a;
    public final boolean b;

    /* JADX WARN: Illegal instructions before constructor call */
    public C1181d(List list, boolean z) {
        ArrayList arrayList = (ArrayList) list;
        this((InterfaceC1182e[]) arrayList.toArray(new InterfaceC1182e[arrayList.size()]), z);
    }

    public C1181d(InterfaceC1182e[] interfaceC1182eArr, boolean z) {
        this.a = interfaceC1182eArr;
        this.b = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if (r2 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r8.c--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if (r2 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        return true;
     */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(HashMap.java:340)
    	at java.base/java.util.HashMap.containsKey(HashMap.java:592)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
     */
    @Override // j$.time.format.InterfaceC1182e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s(j$.time.format.y r8, java.lang.StringBuilder r9) {
        /*
            r7 = this;
            int r0 = r9.length()
            r1 = 1
            boolean r2 = r7.b
            if (r2 == 0) goto Le
            int r3 = r8.c
            int r3 = r3 + r1
            r8.c = r3
        Le:
            j$.time.format.e[] r3 = r7.a     // Catch: java.lang.Throwable -> L27
            int r4 = r3.length     // Catch: java.lang.Throwable -> L27
            r5 = 0
        L12:
            if (r5 >= r4) goto L2c
            r6 = r3[r5]     // Catch: java.lang.Throwable -> L27
            boolean r6 = r6.s(r8, r9)     // Catch: java.lang.Throwable -> L27
            if (r6 != 0) goto L29
            r9.setLength(r0)     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L2f
        L21:
            int r9 = r8.c
            int r9 = r9 - r1
            r8.c = r9
            return r1
        L27:
            r9 = move-exception
            goto L30
        L29:
            int r5 = r5 + 1
            goto L12
        L2c:
            if (r2 == 0) goto L2f
            goto L21
        L2f:
            return r1
        L30:
            if (r2 == 0) goto L37
            int r0 = r8.c
            int r0 = r0 - r1
            r8.c = r0
        L37:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.C1181d.s(j$.time.format.y, java.lang.StringBuilder):boolean");
    }

    @Override // j$.time.format.InterfaceC1182e
    public final int B(v vVar, CharSequence charSequence, int i) {
        boolean z = this.b;
        InterfaceC1182e[] interfaceC1182eArr = this.a;
        int i2 = 0;
        if (z) {
            ArrayList arrayList = vVar.d;
            D dC = vVar.c();
            dC.getClass();
            D d = new D();
            ((HashMap) d.a).putAll(dC.a);
            d.b = dC.b;
            d.c = dC.c;
            d.d = dC.d;
            arrayList.add(d);
            int length = interfaceC1182eArr.length;
            int iB = i;
            while (i2 < length) {
                iB = interfaceC1182eArr[i2].B(vVar, charSequence, iB);
                if (iB < 0) {
                    ArrayList arrayList2 = vVar.d;
                    arrayList2.remove(arrayList2.size() - 1);
                    return i;
                }
                i2++;
            }
            ArrayList arrayList3 = vVar.d;
            arrayList3.remove(arrayList3.size() - 2);
            return iB;
        }
        int length2 = interfaceC1182eArr.length;
        while (i2 < length2) {
            i = interfaceC1182eArr[i2].B(vVar, charSequence, i);
            if (i < 0) {
                return i;
            }
            i2++;
        }
        return i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        InterfaceC1182e[] interfaceC1182eArr = this.a;
        if (interfaceC1182eArr != null) {
            boolean z = this.b;
            sb.append(z ? "[" : "(");
            for (InterfaceC1182e interfaceC1182e : interfaceC1182eArr) {
                sb.append(interfaceC1182e);
            }
            sb.append(z ? "]" : ")");
        }
        return sb.toString();
    }
}
