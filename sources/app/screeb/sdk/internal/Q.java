package app.screeb.sdk.internal;

import android.util.SparseArray;
import android.view.ViewGroup;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Q {
    public static int e;
    public static int f;
    public static final Method j;
    public static final HashMap k;
    public static final int[] a = new int[2];
    public static final int[] b = new int[2];
    public static final int[] c = new int[4];
    public static final int[] d = new int[2];
    public static final SparseArray g = new SparseArray(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
    public static final HashMap h = new HashMap(128);
    public static final HashSet i = new HashSet();

    static {
        Method method = null;
        try {
            Method declaredMethod = ViewGroup.class.getDeclaredMethod("isChildrenDrawingOrderEnabled", null);
            declaredMethod.setAccessible(true);
            method = declaredMethod;
        } catch (Throwable unused) {
        }
        j = method;
        k = new HashMap();
    }

    /* JADX WARN: Code duplicated, block: B:151:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:157:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:159:0x02cb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:161:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:163:0x02d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:165:0x02da  */
    /* JADX WARN: Code duplicated, block: B:167:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:171:0x0300  */
    /* JADX WARN: Code duplicated, block: B:173:0x0304 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:178:0x0327  */
    /* JADX WARN: Code duplicated, block: B:181:0x0349  */
    /* JADX WARN: Code duplicated, block: B:183:0x0354  */
    /* JADX WARN: Code duplicated, block: B:185:0x0358  */
    /* JADX WARN: Code duplicated, block: B:187:0x035c  */
    /* JADX WARN: Code duplicated, block: B:190:0x0362  */
    /* JADX WARN: Code duplicated, block: B:192:0x0366  */
    /* JADX WARN: Code duplicated, block: B:195:0x0375  */
    /* JADX WARN: Code duplicated, block: B:198:0x0387 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:202:0x039a A[PHI: r13 r15
      0x039a: PHI (r13v21 int) = (r13v20 int), (r13v20 int), (r13v26 int) binds: [B:197:0x0385, B:198:0x0387, B:201:0x038c] A[DONT_GENERATE, DONT_INLINE]
      0x039a: PHI (r15v13 int) = (r15v12 int), (r15v12 int), (r15v20 int) binds: [B:197:0x0385, B:198:0x0387, B:201:0x038c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:206:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:209:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:211:0x03d7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:224:0x042c  */
    /* JADX WARN: Code duplicated, block: B:226:0x0440 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:333:0x05f4  */
    /* JADX WARN: Code duplicated, block: B:335:0x05f9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:376:0x069a  */
    /* JADX WARN: Code duplicated, block: B:378:0x069e  */
    /* JADX WARN: Code duplicated, block: B:399:0x06fa  */
    /* JADX WARN: Code duplicated, block: B:402:0x072e  */
    /* JADX WARN: Code duplicated, block: B:404:0x0737  */
    /* JADX WARN: Code duplicated, block: B:407:0x0748 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:409:0x0761  */
    /* JADX WARN: Code duplicated, block: B:411:0x0765  */
    /* JADX WARN: Code duplicated, block: B:413:0x076c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:418:0x0776  */
    /* JADX WARN: Code duplicated, block: B:421:0x077a  */
    /* JADX WARN: Code duplicated, block: B:423:0x0782  */
    /* JADX WARN: Code duplicated, block: B:426:0x0790 A[Catch: all -> 0x0795, TRY_LEAVE, TryCatch #2 {all -> 0x0795, blocks: (B:424:0x078a, B:426:0x0790), top: B:521:0x078a }] */
    /* JADX WARN: Code duplicated, block: B:428:0x0795  */
    /* JADX WARN: Code duplicated, block: B:430:0x0798  */
    /* JADX WARN: Code duplicated, block: B:431:0x079e  */
    /* JADX WARN: Code duplicated, block: B:434:0x07a2  */
    /* JADX WARN: Code duplicated, block: B:436:0x07ae  */
    /* JADX WARN: Code duplicated, block: B:438:0x07b8  */
    /* JADX WARN: Code duplicated, block: B:441:0x07c6  */
    /* JADX WARN: Code duplicated, block: B:443:0x07c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:446:0x07cf  */
    /* JADX WARN: Code duplicated, block: B:448:0x07d7  */
    /* JADX WARN: Code duplicated, block: B:450:0x07de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:451:0x07e0  */
    /* JADX WARN: Code duplicated, block: B:455:0x07f6  */
    /* JADX WARN: Code duplicated, block: B:482:0x0859  */
    /* JADX WARN: Code duplicated, block: B:484:0x0863  */
    /* JADX WARN: Code duplicated, block: B:485:0x0866  */
    /* JADX WARN: Code duplicated, block: B:488:0x086e  */
    /* JADX WARN: Code duplicated, block: B:491:0x088d  */
    /* JADX WARN: Code duplicated, block: B:493:0x0893  */
    /* JADX WARN: Code duplicated, block: B:495:0x0898  */
    /* JADX WARN: Code duplicated, block: B:496:0x089a  */
    /* JADX WARN: Code duplicated, block: B:499:0x089f  */
    /* JADX WARN: Code duplicated, block: B:500:0x08a1  */
    /* JADX WARN: Code duplicated, block: B:503:0x08b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:505:0x08bd  */
    /* JADX WARN: Code duplicated, block: B:508:0x08c4  */
    /* JADX WARN: Code duplicated, block: B:509:0x08ca  */
    /* JADX WARN: Code duplicated, block: B:521:0x078a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x016b  */
    /* JADX WARN: Code duplicated, block: B:69:0x017e A[LOOP:2: B:68:0x017c->B:69:0x017e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x019a  */
    /* JADX WARN: Code duplicated, block: B:74:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:75:0x01b8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:90:0x01ec  */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x035e, code lost:
    
        if (r6 <= (r48 + r13)) goto L191;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v24, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26, types: [int] */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v47 */
    /* JADX WARN: Type inference failed for: r14v48 */
    /* JADX WARN: Type inference failed for: r14v49 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [app.screeb.sdk.internal.T] */
    /* JADX WARN: Type inference failed for: r2v50, types: [app.screeb.sdk.internal.T] */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r5v104 */
    /* JADX WARN: Type inference failed for: r5v105 */
    /* JADX WARN: Type inference failed for: r5v136 */
    /* JADX WARN: Type inference failed for: r6v51, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v60 */
    /* JADX WARN: Type inference failed for: r6v61, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v62 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v48, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v49 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long a(app.screeb.sdk.internal.N r39, android.view.View r40, android.view.View r41, long r42, int r44, int r45, boolean r46, int r47, int r48, boolean r49, boolean r50, boolean r51, app.screeb.sdk.internal.T r52, int r53, int r54, boolean r55, boolean r56) {
        /*
            Method dump skipped, instruction units count: 2254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: app.screeb.sdk.internal.Q.a(app.screeb.sdk.internal.N, android.view.View, android.view.View, long, int, int, boolean, int, int, boolean, boolean, boolean, app.screeb.sdk.internal.T, int, int, boolean, boolean):long");
    }

    public static void a(String str) {
        if (i.add(str)) {
            Z z = Z.b;
            Y.a();
            Z.b("Mirror", "Duplicate screebId(\"" + str + "\") on multiple visible views — DOM ids must be unique; only the first keeps the id, the rest are disambiguated.");
        }
    }
}
