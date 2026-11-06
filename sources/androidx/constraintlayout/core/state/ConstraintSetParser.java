package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.ChainReference;
import androidx.constraintlayout.core.state.helpers.FlowReference;
import androidx.constraintlayout.core.state.helpers.GridReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import com.amazon.a.a.o.b.f;
import com.google.firebase.messaging.Constants;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintSetParser {

    interface GeneratedValue {
        float value();
    }

    public static class LayoutVariables {
        HashMap mMargins = new HashMap();
        HashMap mGenerators = new HashMap();
        HashMap mArrayIds = new HashMap();

        void put(String str, int i) {
            this.mMargins.put(str, Integer.valueOf(i));
        }

        void put(String str, float f, float f2) {
            if (this.mGenerators.containsKey(str)) {
                this.mGenerators.get(str);
            }
            this.mGenerators.put(str, new Generator(f, f2));
        }

        void put(String str, float f, float f2, float f3, String str2, String str3) {
            if (this.mGenerators.containsKey(str)) {
                this.mGenerators.get(str);
            }
            FiniteGenerator finiteGenerator = new FiniteGenerator(f, f2, f3, str2, str3);
            this.mGenerators.put(str, finiteGenerator);
            this.mArrayIds.put(str, finiteGenerator.array());
        }

        float get(Object obj) {
            if (obj instanceof CLString) {
                String strContent = ((CLString) obj).content();
                if (this.mGenerators.containsKey(strContent)) {
                    return ((GeneratedValue) this.mGenerators.get(strContent)).value();
                }
                if (this.mMargins.containsKey(strContent)) {
                    return ((Integer) this.mMargins.get(strContent)).floatValue();
                }
                return 0.0f;
            }
            if (obj instanceof CLNumber) {
                return ((CLNumber) obj).getFloat();
            }
            return 0.0f;
        }

        ArrayList getList(String str) {
            if (this.mArrayIds.containsKey(str)) {
                return (ArrayList) this.mArrayIds.get(str);
            }
            return null;
        }

        void put(String str, ArrayList arrayList) {
            this.mArrayIds.put(str, arrayList);
        }
    }

    static class Generator implements GeneratedValue {
        float mCurrent;
        float mIncrementBy;
        float mStart;
        boolean mStop = false;

        Generator(float f, float f2) {
            this.mStart = f;
            this.mIncrementBy = f2;
            this.mCurrent = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            if (!this.mStop) {
                this.mCurrent += this.mIncrementBy;
            }
            return this.mCurrent;
        }
    }

    static class FiniteGenerator implements GeneratedValue {
        float mFrom;
        float mInitial;
        float mMax;
        String mPostfix;
        String mPrefix;
        float mStep;
        float mTo;
        boolean mStop = false;
        float mCurrent = 0.0f;

        FiniteGenerator(float f, float f2, float f3, String str, String str2) {
            this.mFrom = f;
            this.mTo = f2;
            this.mStep = f3;
            this.mPrefix = str == null ? "" : str;
            this.mPostfix = str2 == null ? "" : str2;
            this.mMax = f2;
            this.mInitial = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            float f = this.mCurrent;
            if (f >= this.mMax) {
                this.mStop = true;
            }
            if (!this.mStop) {
                this.mCurrent = f + this.mStep;
            }
            return this.mCurrent;
        }

        public ArrayList array() {
            ArrayList arrayList = new ArrayList();
            int i = (int) this.mInitial;
            int i2 = (int) this.mMax;
            int i3 = i;
            while (i <= i2) {
                arrayList.add(this.mPrefix + i3 + this.mPostfix);
                i3 += (int) this.mStep;
                i++;
            }
            return arrayList;
        }
    }

    public static void populateState(CLObject cLObject, State state, LayoutVariables layoutVariables) {
        ArrayList<String> arrayListNames = cLObject.names();
        if (arrayListNames == null) {
            return;
        }
        for (String str : arrayListNames) {
            CLElement cLElement = cLObject.get(str);
            str.getClass();
            switch (str) {
                case "Helpers":
                    if (!(cLElement instanceof CLArray)) {
                        break;
                    } else {
                        parseHelpers(state, layoutVariables, (CLArray) cLElement);
                        break;
                    }
                    break;
                case "Generate":
                    if (!(cLElement instanceof CLObject)) {
                        break;
                    } else {
                        parseGenerate(state, layoutVariables, (CLObject) cLElement);
                        break;
                    }
                    break;
                case "Variables":
                    if (!(cLElement instanceof CLObject)) {
                        break;
                    } else {
                        parseVariables(state, layoutVariables, (CLObject) cLElement);
                        break;
                    }
                    break;
                default:
                    if (cLElement instanceof CLObject) {
                        CLObject cLObject2 = (CLObject) cLElement;
                        String strLookForType = lookForType(cLObject2);
                        if (strLookForType != null) {
                            switch (strLookForType) {
                                case "vGuideline":
                                    parseGuidelineParams(1, state, str, cLObject2);
                                    break;
                                case "column":
                                case "row":
                                case "grid":
                                    parseGridType(strLookForType, state, str, layoutVariables, cLObject2);
                                    break;
                                case "hChain":
                                case "vChain":
                                    parseChainType(strLookForType, state, str, layoutVariables, cLObject2);
                                    break;
                                case "barrier":
                                    parseBarrier(state, str, cLObject2);
                                    break;
                                case "hFlow":
                                case "vFlow":
                                    parseFlowType(strLookForType, state, str, layoutVariables, cLObject2);
                                    break;
                                case "hGuideline":
                                    parseGuidelineParams(0, state, str, cLObject2);
                                    break;
                            }
                        } else {
                            parseWidget(state, layoutVariables, str, cLObject2);
                            break;
                        }
                    } else {
                        if (cLElement instanceof CLNumber) {
                            layoutVariables.put(str, cLElement.getInt());
                        }
                        break;
                    }
                    break;
            }
        }
    }

    private static void parseVariables(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> arrayListNames = cLObject.names();
        if (arrayListNames == null) {
            return;
        }
        for (String str : arrayListNames) {
            CLElement cLElement = cLObject.get(str);
            if (cLElement instanceof CLNumber) {
                layoutVariables.put(str, cLElement.getInt());
            } else if (cLElement instanceof CLObject) {
                CLObject cLObject2 = (CLObject) cLElement;
                if (cLObject2.has(Constants.MessagePayloadKeys.FROM) && cLObject2.has("to")) {
                    layoutVariables.put(str, layoutVariables.get(cLObject2.get(Constants.MessagePayloadKeys.FROM)), layoutVariables.get(cLObject2.get("to")), 1.0f, cLObject2.getStringOrNull("prefix"), cLObject2.getStringOrNull("postfix"));
                } else if (cLObject2.has(Constants.MessagePayloadKeys.FROM) && cLObject2.has("step")) {
                    layoutVariables.put(str, layoutVariables.get(cLObject2.get(Constants.MessagePayloadKeys.FROM)), layoutVariables.get(cLObject2.get("step")));
                } else if (cLObject2.has("ids")) {
                    CLArray array = cLObject2.getArray("ids");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < array.size(); i++) {
                        arrayList.add(array.getString(i));
                    }
                    layoutVariables.put(str, arrayList);
                } else if (cLObject2.has("tag")) {
                    layoutVariables.put(str, state.getIdsForTag(cLObject2.getString("tag")));
                }
            }
        }
    }

    static void parseHelpers(State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        for (int i = 0; i < cLArray.size(); i++) {
            CLElement cLElement = cLArray.get(i);
            if (cLElement instanceof CLArray) {
                CLArray cLArray2 = (CLArray) cLElement;
                if (cLArray2.size() > 1) {
                    String string = cLArray2.getString(0);
                    string.getClass();
                    switch (string) {
                        case "vGuideline":
                            parseGuideline(1, state, cLArray2);
                            break;
                        case "hChain":
                            parseChain(0, state, layoutVariables, cLArray2);
                            break;
                        case "vChain":
                            parseChain(1, state, layoutVariables, cLArray2);
                            break;
                        case "hGuideline":
                            parseGuideline(0, state, cLArray2);
                            break;
                    }
                }
            }
        }
    }

    static void parseGenerate(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> arrayListNames = cLObject.names();
        if (arrayListNames == null) {
            return;
        }
        for (String str : arrayListNames) {
            CLElement cLElement = cLObject.get(str);
            ArrayList list = layoutVariables.getList(str);
            if (list != null && (cLElement instanceof CLObject)) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    parseWidget(state, layoutVariables, (String) it.next(), (CLObject) cLElement);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0086  */
    static void parseChain(int i, State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        String strContent;
        ChainReference chainReferenceHorizontalChain = i == 0 ? state.horizontalChain() : state.verticalChain();
        CLElement cLElement = cLArray.get(1);
        if (cLElement instanceof CLArray) {
            CLArray cLArray2 = (CLArray) cLElement;
            if (cLArray2.size() < 1) {
                return;
            }
            for (int i2 = 0; i2 < cLArray2.size(); i2++) {
                chainReferenceHorizontalChain.add(cLArray2.getString(i2));
            }
            if (cLArray.size() > 2) {
                CLElement cLElement2 = cLArray.get(2);
                if (cLElement2 instanceof CLObject) {
                    CLObject cLObject = (CLObject) cLElement2;
                    for (String str : cLObject.names()) {
                        str.getClass();
                        if (str.equals("style")) {
                            CLElement cLElement3 = cLObject.get(str);
                            if (cLElement3 instanceof CLArray) {
                                CLArray cLArray3 = (CLArray) cLElement3;
                                if (cLArray3.size() > 1) {
                                    strContent = cLArray3.getString(0);
                                    chainReferenceHorizontalChain.bias(cLArray3.getFloat(1));
                                } else {
                                    strContent = cLElement3.content();
                                }
                            } else {
                                strContent = cLElement3.content();
                            }
                            strContent.getClass();
                            if (strContent.equals("packed")) {
                                chainReferenceHorizontalChain.style(State.Chain.PACKED);
                            } else if (strContent.equals("spread_inside")) {
                                chainReferenceHorizontalChain.style(State.Chain.SPREAD_INSIDE);
                            } else {
                                chainReferenceHorizontalChain.style(State.Chain.SPREAD);
                            }
                        } else {
                            parseConstraint(state, layoutVariables, cLObject, chainReferenceHorizontalChain, str);
                        }
                    }
                }
            }
        }
    }

    private static float toPix(State state, float f) {
        return state.getDpToPixel().toPixels(f);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:47:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00df  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x0105  */
    /* JADX WARN: Code duplicated, block: B:70:0x010d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0115  */
    /* JADX WARN: Code duplicated, block: B:74:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x0127 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x0129 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x012b  */
    /* JADX WARN: Code duplicated, block: B:79:0x013a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0170  */
    /* JADX WARN: Code duplicated, block: B:81:0x0196  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:84:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:85:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:89:0x020a  */
    /* JADX WARN: Code duplicated, block: B:93:0x01e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x01e7 A[SYNTHETIC] */
    private static void parseChainType(String str, State state, String str2, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        CLArray cLArray;
        int i;
        float f;
        float pix;
        float pix2;
        float f2;
        float f3;
        String strContent;
        int i2 = 0;
        ChainReference chainReferenceHorizontalChain = str.charAt(0) == 'h' ? state.horizontalChain() : state.verticalChain();
        chainReferenceHorizontalChain.setKey(str2);
        for (String str3 : cLObject.names()) {
            str3.getClass();
            int i3 = 6;
            int i4 = 3;
            int i5 = 2;
            int i6 = 1;
            int i7 = -1;
            switch (str3) {
                case "bottom":
                    i7 = i2;
                case "contains":
                    i7 = 1;
                case "end":
                    i7 = 2;
                case "top":
                    i7 = 3;
                case "left":
                    i7 = 4;
                case "right":
                    i7 = 5;
                case "start":
                    i7 = 6;
                case "style":
                    i7 = 7;
                default:
                    switch (i7) {
                        case 0:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            parseConstraint(state, layoutVariables, cLObject, chainReferenceHorizontalChain, str3);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            i2 = 0;
                            break;
                        case 1:
                            CLElement cLElement = cLObject.get(str3);
                            if (cLElement instanceof CLArray) {
                                CLArray cLArray2 = (CLArray) cLElement;
                                if (cLArray2.size() >= 1) {
                                    int i8 = i2;
                                    while (i8 < cLArray2.size()) {
                                        CLElement cLElement2 = cLArray2.get(i8);
                                        if (cLElement2 instanceof CLArray) {
                                            CLArray cLArray3 = (CLArray) cLElement2;
                                            if (cLArray3.size() > 0) {
                                                String strContent2 = cLArray3.get(i2).content();
                                                int size = cLArray3.size();
                                                if (size == i5) {
                                                    float f4 = cLArray3.getFloat(i6);
                                                    CLArray cLArray4 = cLArray2;
                                                    f = f4;
                                                    cLArray = cLArray4;
                                                    pix = Float.NaN;
                                                } else {
                                                    if (size == i4) {
                                                        CLArray cLArray5 = cLArray2;
                                                        f = cLArray3.getFloat(i6);
                                                        cLArray = cLArray5;
                                                        i8 = i8;
                                                        i6 = i6;
                                                        pix = toPix(state, cLArray3.getFloat(i5));
                                                        strContent2 = strContent2;
                                                        pix2 = Float.NaN;
                                                        i = i5;
                                                        f3 = pix;
                                                        f2 = Float.NaN;
                                                    } else if (size == 4) {
                                                        float f5 = cLArray3.getFloat(i6);
                                                        float pix3 = toPix(state, cLArray3.getFloat(i5));
                                                        i4 = 3;
                                                        CLArray cLArray6 = cLArray2;
                                                        f = f5;
                                                        cLArray = cLArray6;
                                                        i6 = i6;
                                                        pix = toPix(state, cLArray3.getFloat(3));
                                                        f2 = Float.NaN;
                                                        i = i5;
                                                        f3 = pix3;
                                                        i8 = i8;
                                                        strContent2 = strContent2;
                                                        pix2 = Float.NaN;
                                                    } else if (size != i3) {
                                                        cLArray = cLArray2;
                                                        f = Float.NaN;
                                                        pix = Float.NaN;
                                                    } else {
                                                        float f6 = cLArray3.getFloat(i6);
                                                        float pix4 = toPix(state, cLArray3.getFloat(i5));
                                                        float pix5 = toPix(state, cLArray3.getFloat(i4));
                                                        float pix6 = toPix(state, cLArray3.getFloat(4));
                                                        int i9 = i5;
                                                        f3 = pix4;
                                                        cLArray = cLArray2;
                                                        f = f6;
                                                        i = i9;
                                                        i6 = i6;
                                                        pix = pix5;
                                                        i8 = i8;
                                                        strContent2 = strContent2;
                                                        pix2 = toPix(state, cLArray3.getFloat(5));
                                                        f2 = pix6;
                                                        i4 = 3;
                                                    }
                                                    chainReferenceHorizontalChain.addChainElement(strContent2, f, f3, pix, f2, pix2);
                                                }
                                                f2 = pix;
                                                pix2 = f2;
                                                i = i5;
                                                f3 = pix2;
                                                chainReferenceHorizontalChain.addChainElement(strContent2, f, f3, pix, f2, pix2);
                                            } else {
                                                i8 = i8;
                                                cLArray = cLArray2;
                                                i = i5;
                                                i6 = i6;
                                            }
                                        } else {
                                            i8 = i8;
                                            cLArray = cLArray2;
                                            i = i5;
                                            i6 = i6;
                                            chainReferenceHorizontalChain.add(cLElement2.content());
                                        }
                                        i8++;
                                        cLArray2 = cLArray;
                                        i5 = i;
                                        i6 = i6;
                                        i2 = 0;
                                        i3 = 6;
                                    }
                                    break;
                                }
                            }
                            System.err.println(str2 + " contains should be an array \"" + cLElement.content() + "\"");
                            return;
                        case 7:
                            CLElement cLElement3 = cLObject.get(str3);
                            if (cLElement3 instanceof CLArray) {
                                CLArray cLArray7 = (CLArray) cLElement3;
                                if (cLArray7.size() > 1) {
                                    strContent = cLArray7.getString(i2);
                                    chainReferenceHorizontalChain.bias(cLArray7.getFloat(1));
                                } else {
                                    strContent = cLElement3.content();
                                }
                            } else {
                                strContent = cLElement3.content();
                            }
                            strContent.getClass();
                            if (strContent.equals("packed")) {
                                chainReferenceHorizontalChain.style(State.Chain.PACKED);
                            } else if (strContent.equals("spread_inside")) {
                                chainReferenceHorizontalChain.style(State.Chain.SPREAD_INSIDE);
                            } else {
                                chainReferenceHorizontalChain.style(State.Chain.SPREAD);
                            }
                            break;
                    }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:117:0x01ef  */
    private static void parseGridType(String str, State state, String str2, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        float f;
        float f2;
        float f3;
        float f4;
        GridReference grid = state.getGrid(str2, str);
        for (String str3 : cLObject.names()) {
            str3.getClass();
            int i = 0;
            switch (str3) {
                case "orientation":
                    grid.setOrientation(cLObject.get(str3).getInt());
                    break;
                case "padding":
                    CLElement cLElement = cLObject.get(str3);
                    if (cLElement instanceof CLArray) {
                        CLArray cLArray = (CLArray) cLElement;
                        if (cLArray.size() > 1) {
                            f = cLArray.getInt(0);
                            f4 = cLArray.getInt(1);
                            if (cLArray.size() > 2) {
                                f3 = cLArray.getInt(2);
                                try {
                                    f2 = ((CLArray) cLElement).getInt(3);
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                    f2 = 0.0f;
                                }
                            } else {
                                f2 = f4;
                                f3 = f;
                            }
                        } else {
                            f = cLElement.getInt();
                            f2 = f;
                            f3 = f2;
                            f4 = f3;
                        }
                    } else {
                        f = cLElement.getInt();
                        f2 = f;
                        f3 = f2;
                        f4 = f3;
                    }
                    grid.setPaddingStart(Math.round(toPix(state, f)));
                    grid.setPaddingTop(Math.round(toPix(state, f4)));
                    grid.setPaddingEnd(Math.round(toPix(state, f3)));
                    grid.setPaddingBottom(Math.round(toPix(state, f2)));
                    break;
                case "contains":
                    CLArray arrayOrNull = cLObject.getArrayOrNull(str3);
                    if (arrayOrNull != null) {
                        while (i < arrayOrNull.size()) {
                            grid.add(state.constraints(arrayOrNull.get(i).content()));
                            i++;
                        }
                        break;
                    } else {
                        break;
                    }
                    break;
                case "hGap":
                    grid.setHorizontalGaps(toPix(state, cLObject.get(str3).getFloat()));
                    break;
                case "rows":
                    int i2 = cLObject.get(str3).getInt();
                    if (i2 > 0) {
                        grid.setRowsSet(i2);
                        break;
                    } else {
                        break;
                    }
                    break;
                case "vGap":
                    grid.setVerticalGaps(toPix(state, cLObject.get(str3).getFloat()));
                    break;
                case "flags":
                    String strContent = "";
                    try {
                        CLElement cLElement2 = cLObject.get(str3);
                        if (cLElement2 instanceof CLNumber) {
                            i = cLElement2.getInt();
                        } else {
                            strContent = cLElement2.content();
                        }
                    } catch (Exception e) {
                        System.err.println("Error parsing grid flags " + e);
                    }
                    if (strContent != null && !strContent.isEmpty()) {
                        grid.setFlags(strContent);
                        break;
                    } else {
                        grid.setFlags(i);
                        break;
                    }
                    break;
                case "skips":
                    String strContent2 = cLObject.get(str3).content();
                    if (strContent2 == null || !strContent2.contains(com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
                        break;
                    } else {
                        grid.setSkips(strContent2);
                        break;
                    }
                    break;
                case "spans":
                    String strContent3 = cLObject.get(str3).content();
                    if (strContent3 == null || !strContent3.contains(com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
                        break;
                    } else {
                        grid.setSpans(strContent3);
                        break;
                    }
                    break;
                case "rowWeights":
                    String strContent4 = cLObject.get(str3).content();
                    if (strContent4 == null || !strContent4.contains(f.a)) {
                        break;
                    } else {
                        grid.setRowWeights(strContent4);
                        break;
                    }
                    break;
                case "columns":
                    int i3 = cLObject.get(str3).getInt();
                    if (i3 > 0) {
                        grid.setColumnsSet(i3);
                        break;
                    } else {
                        break;
                    }
                    break;
                case "columnWeights":
                    String strContent5 = cLObject.get(str3).content();
                    if (strContent5 == null || !strContent5.contains(f.a)) {
                        break;
                    } else {
                        grid.setColumnWeights(strContent5);
                        break;
                    }
                    break;
                default:
                    applyAttribute(state, layoutVariables, state.constraints(str2), cLObject, str3);
                    break;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:0x022e  */
    /* JADX WARN: Code duplicated, block: B:130:0x0298  */
    /* JADX WARN: Code duplicated, block: B:140:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:178:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:194:0x0403  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void parseFlowType(String str, State state, String str2, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        int i;
        float f;
        int i2;
        String strContent;
        String string;
        String string2;
        Float fValueOf;
        Float fValueOf2;
        Float fValueOf3;
        String strContent2;
        String string3;
        String string4;
        float f2;
        float f3;
        float f4;
        float f5;
        Float fValueOf4;
        Float fValueOf5;
        Float fValueOf6;
        float f6;
        float pix;
        float f7;
        float f8;
        float f9 = 0.5f;
        Float fValueOf7 = Float.valueOf(0.5f);
        int i3 = 0;
        FlowReference flow = state.getFlow(str2, str.charAt(0) == 'v');
        for (String str3 : cLObject.names()) {
            str3.getClass();
            int i4 = 4;
            switch (str3.hashCode()) {
                case -1254185091:
                    i = str3.equals("hAlign") ? i3 : -1;
                    break;
                case -1237307863:
                    i = str3.equals("hStyle") ? 1 : -1;
                    break;
                case -1198076529:
                    i = str3.equals("hFlowBias") ? 2 : -1;
                    break;
                case -853376977:
                    i = str3.equals("vAlign") ? 3 : -1;
                    break;
                case -836499749:
                    i = str3.equals("vStyle") ? 4 : -1;
                    break;
                case -806339567:
                    i = str3.equals("padding") ? 5 : -1;
                    break;
                case -732635235:
                    i = str3.equals("vFlowBias") ? 6 : -1;
                    break;
                case -567445985:
                    i = str3.equals("contains") ? 7 : -1;
                    break;
                case -488900360:
                    i = str3.equals("maxElement") ? 8 : -1;
                    break;
                case 3169614:
                    i = str3.equals("hGap") ? 9 : -1;
                    break;
                case 3575610:
                    i = str3.equals("type") ? 10 : -1;
                    break;
                case 3586688:
                    i = str3.equals("vGap") ? 11 : -1;
                    break;
                case 3657802:
                    i = str3.equals("wrap") ? 12 : -1;
                    break;
                default:
                    i = -1;
                    break;
            }
            switch (i) {
                case 0:
                    f = f9;
                    String strContent3 = cLObject.get(str3).content();
                    strContent3.getClass();
                    if (strContent3.equals("end")) {
                        i2 = 0;
                        flow.setHorizontalAlign(1);
                    } else if (strContent3.equals("start")) {
                        i2 = 0;
                        flow.setHorizontalAlign(0);
                    } else {
                        flow.setHorizontalAlign(2);
                        i2 = 0;
                    }
                    i3 = i2;
                    f9 = f;
                    break;
                case 1:
                    f = f9;
                    CLElement cLElement = cLObject.get(str3);
                    if (cLElement instanceof CLArray) {
                        CLArray cLArray = (CLArray) cLElement;
                        if (cLArray.size() > 1) {
                            string = cLArray.getString(0);
                            strContent = cLArray.getString(1);
                            if (cLArray.size() > 2) {
                                string2 = cLArray.getString(2);
                            } else {
                                string2 = "";
                            }
                        } else {
                            strContent = cLElement.content();
                            string = "";
                            string2 = string;
                        }
                    } else {
                        strContent = cLElement.content();
                        string = "";
                        string2 = string;
                    }
                    if (!strContent.equals("")) {
                        flow.setHorizontalStyle(State.Chain.getValueByString(strContent));
                    }
                    if (!string.equals("")) {
                        flow.setFirstHorizontalStyle(State.Chain.getValueByString(string));
                    }
                    if (!string2.equals("")) {
                        flow.setLastHorizontalStyle(State.Chain.getValueByString(string2));
                    }
                    i2 = 0;
                    i3 = i2;
                    f9 = f;
                    break;
                case 2:
                    f = f9;
                    CLElement cLElement2 = cLObject.get(str3);
                    if (cLElement2 instanceof CLArray) {
                        CLArray cLArray2 = (CLArray) cLElement2;
                        if (cLArray2.size() > 1) {
                            fValueOf2 = Float.valueOf(cLArray2.getFloat(0));
                            fValueOf = Float.valueOf(cLArray2.getFloat(1));
                            fValueOf3 = cLArray2.size() > 2 ? Float.valueOf(cLArray2.getFloat(2)) : fValueOf7;
                        } else {
                            fValueOf = Float.valueOf(cLElement2.getFloat());
                            fValueOf2 = fValueOf7;
                            fValueOf3 = fValueOf2;
                        }
                    } else {
                        fValueOf = Float.valueOf(cLElement2.getFloat());
                        fValueOf2 = fValueOf7;
                        fValueOf3 = fValueOf2;
                    }
                    flow.horizontalBias(fValueOf.floatValue());
                    if (fValueOf2.floatValue() != f) {
                        flow.setFirstHorizontalBias(fValueOf2.floatValue());
                    }
                    if (fValueOf3.floatValue() != f) {
                        flow.setLastHorizontalBias(fValueOf3.floatValue());
                    }
                    i2 = 0;
                    i3 = i2;
                    f9 = f;
                    break;
                case 3:
                    f = f9;
                    String strContent4 = cLObject.get(str3).content();
                    strContent4.getClass();
                    switch (strContent4) {
                        case "baseline":
                            flow.setVerticalAlign(3);
                            break;
                        case "bottom":
                            flow.setVerticalAlign(1);
                            break;
                        case "top":
                            flow.setVerticalAlign(0);
                            break;
                        default:
                            flow.setVerticalAlign(2);
                            break;
                    }
                    i2 = 0;
                    i3 = i2;
                    f9 = f;
                    break;
                case 4:
                    f = f9;
                    CLElement cLElement3 = cLObject.get(str3);
                    if (cLElement3 instanceof CLArray) {
                        CLArray cLArray3 = (CLArray) cLElement3;
                        if (cLArray3.size() > 1) {
                            string3 = cLArray3.getString(0);
                            strContent2 = cLArray3.getString(1);
                            if (cLArray3.size() > 2) {
                                string4 = cLArray3.getString(2);
                            } else {
                                string4 = "";
                            }
                        } else {
                            strContent2 = cLElement3.content();
                            string3 = "";
                            string4 = string3;
                        }
                    } else {
                        strContent2 = cLElement3.content();
                        string3 = "";
                        string4 = string3;
                    }
                    if (!strContent2.equals("")) {
                        flow.setVerticalStyle(State.Chain.getValueByString(strContent2));
                    }
                    if (!string3.equals("")) {
                        flow.setFirstVerticalStyle(State.Chain.getValueByString(string3));
                    }
                    if (!string4.equals("")) {
                        flow.setLastVerticalStyle(State.Chain.getValueByString(string4));
                    }
                    i2 = 0;
                    i3 = i2;
                    f9 = f;
                    break;
                case 5:
                    f = f9;
                    CLElement cLElement4 = cLObject.get(str3);
                    if (cLElement4 instanceof CLArray) {
                        CLArray cLArray4 = (CLArray) cLElement4;
                        if (cLArray4.size() > 1) {
                            f2 = cLArray4.getInt(0);
                            f5 = cLArray4.getInt(1);
                            if (cLArray4.size() > 2) {
                                f4 = cLArray4.getInt(2);
                                try {
                                    f3 = ((CLArray) cLElement4).getInt(3);
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                    f3 = 0.0f;
                                }
                            } else {
                                f4 = f2;
                                f3 = f5;
                            }
                        } else {
                            f2 = cLElement4.getInt();
                            f3 = f2;
                            f4 = f3;
                            f5 = f4;
                        }
                    } else {
                        f2 = cLElement4.getInt();
                        f3 = f2;
                        f4 = f3;
                        f5 = f4;
                    }
                    flow.setPaddingLeft(Math.round(toPix(state, f2)));
                    flow.setPaddingTop(Math.round(toPix(state, f5)));
                    flow.setPaddingRight(Math.round(toPix(state, f4)));
                    flow.setPaddingBottom(Math.round(toPix(state, f3)));
                    i2 = 0;
                    i3 = i2;
                    f9 = f;
                    break;
                case 6:
                    f = f9;
                    CLElement cLElement5 = cLObject.get(str3);
                    if (cLElement5 instanceof CLArray) {
                        CLArray cLArray5 = (CLArray) cLElement5;
                        if (cLArray5.size() > 1) {
                            fValueOf5 = Float.valueOf(cLArray5.getFloat(0));
                            fValueOf4 = Float.valueOf(cLArray5.getFloat(1));
                            fValueOf6 = cLArray5.size() > 2 ? Float.valueOf(cLArray5.getFloat(2)) : fValueOf7;
                        } else {
                            fValueOf4 = Float.valueOf(cLElement5.getFloat());
                            fValueOf5 = fValueOf7;
                            fValueOf6 = fValueOf5;
                        }
                    } else {
                        fValueOf4 = Float.valueOf(cLElement5.getFloat());
                        fValueOf5 = fValueOf7;
                        fValueOf6 = fValueOf5;
                    }
                    try {
                        flow.verticalBias(fValueOf4.floatValue());
                        if (fValueOf5.floatValue() != f) {
                            flow.setFirstVerticalBias(fValueOf5.floatValue());
                        }
                        if (fValueOf6.floatValue() != f) {
                            flow.setLastVerticalBias(fValueOf6.floatValue());
                        }
                    } catch (NumberFormatException unused2) {
                    }
                    i2 = 0;
                    i3 = i2;
                    f9 = f;
                    break;
                case 7:
                    CLElement cLElement6 = cLObject.get(str3);
                    if (cLElement6 instanceof CLArray) {
                        CLArray cLArray6 = (CLArray) cLElement6;
                        if (cLArray6.size() >= 1) {
                            int i5 = i3;
                            while (i5 < cLArray6.size()) {
                                CLElement cLElement7 = cLArray6.get(i5);
                                float f10 = f9;
                                if (cLElement7 instanceof CLArray) {
                                    CLArray cLArray7 = (CLArray) cLElement7;
                                    if (cLArray7.size() > 0) {
                                        String strContent5 = cLArray7.get(i3).content();
                                        int size = cLArray7.size();
                                        if (size == 2) {
                                            f6 = cLArray7.getFloat(1);
                                            pix = Float.NaN;
                                        } else {
                                            if (size == 3) {
                                                f8 = cLArray7.getFloat(1);
                                                pix = toPix(state, cLArray7.getFloat(2));
                                                f7 = pix;
                                            } else if (size != i4) {
                                                f6 = Float.NaN;
                                                pix = Float.NaN;
                                            } else {
                                                f8 = cLArray7.getFloat(1);
                                                float pix2 = toPix(state, cLArray7.getFloat(2));
                                                pix = toPix(state, cLArray7.getFloat(3));
                                                f7 = pix2;
                                            }
                                            f6 = f8;
                                            flow.addFlowElement(strContent5, f6, f7, pix);
                                        }
                                        f7 = pix;
                                        flow.addFlowElement(strContent5, f6, f7, pix);
                                    }
                                } else {
                                    flow.add(cLElement7.content());
                                }
                                i5++;
                                f9 = f10;
                                i3 = 0;
                                i4 = 4;
                            }
                            f = f9;
                            i2 = i3;
                            i3 = i2;
                            f9 = f;
                            break;
                        }
                    }
                    System.err.println(str2 + " contains should be an array \"" + cLElement6.content() + "\"");
                    break;
                case 8:
                    flow.setMaxElementsWrap(cLObject.get(str3).getInt());
                    f = f9;
                    i2 = i3;
                    i3 = i2;
                    f9 = f;
                    break;
                case 9:
                    flow.setHorizontalGap(cLObject.get(str3).getInt());
                    f = f9;
                    i2 = i3;
                    i3 = i2;
                    f9 = f;
                    break;
                case 10:
                    if (cLObject.get(str3).content().equals("hFlow")) {
                        flow.setOrientation(i3);
                    } else {
                        flow.setOrientation(1);
                    }
                    f = f9;
                    i2 = i3;
                    i3 = i2;
                    f9 = f;
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    flow.setVerticalGap(cLObject.get(str3).getInt());
                    f = f9;
                    i2 = i3;
                    i3 = i2;
                    f9 = f;
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    flow.setWrapMode(State.Wrap.getValueByString(cLObject.get(str3).content()));
                    f = f9;
                    i2 = i3;
                    i3 = i2;
                    f9 = f;
                    break;
                default:
                    applyAttribute(state, layoutVariables, state.constraints(str2), cLObject, str3);
                    f = f9;
                    i2 = i3;
                    i3 = i2;
                    f9 = f;
                    break;
            }
            return;
        }
    }

    static void parseGuideline(int i, State state, CLArray cLArray) throws CLParsingException {
        CLObject cLObject;
        String stringOrNull;
        CLElement cLElement = cLArray.get(1);
        if ((cLElement instanceof CLObject) && (stringOrNull = (cLObject = (CLObject) cLElement).getStringOrNull(DiagnosticsEntry.ID_KEY)) != null) {
            parseGuidelineParams(i, state, stringOrNull, cLObject);
        }
    }

    /* JADX WARN: switch over string: strings are not added: [[left]] */
    static void parseGuidelineParams(int i, State state, String str, CLObject cLObject) throws CLParsingException {
        String str2;
        ArrayList arrayListNames = cLObject.names();
        if (arrayListNames == null) {
            return;
        }
        ConstraintReference constraintReferenceConstraints = state.constraints(str);
        if (i == 0) {
            state.horizontalGuideline(str);
        } else {
            state.verticalGuideline(str);
        }
        boolean z = !state.isRtl() || i == 0;
        GuidelineReference guidelineReference = (GuidelineReference) constraintReferenceConstraints.getFacade();
        Iterator it = arrayListNames.iterator();
        float pix = 0.0f;
        boolean z2 = false;
        while (true) {
            boolean z3 = true;
            while (true) {
                if (!it.hasNext()) {
                    if (z2) {
                        if (z3) {
                            guidelineReference.percent(pix);
                            return;
                        } else {
                            guidelineReference.percent(1.0f - pix);
                            return;
                        }
                    }
                    if (z3) {
                        guidelineReference.start(Float.valueOf(pix));
                        return;
                    } else {
                        guidelineReference.end(Float.valueOf(pix));
                        return;
                    }
                }
                str2 = (String) it.next();
                str2.getClass();
                switch (str2) {
                    case "percent":
                        CLArray arrayOrNull = cLObject.getArrayOrNull(str2);
                        if (arrayOrNull == null) {
                            pix = cLObject.getFloat(str2);
                            z2 = true;
                            z3 = true;
                            break;
                        } else {
                            if (arrayOrNull.size() > 1) {
                                String string = arrayOrNull.getString(0);
                                float f = arrayOrNull.getFloat(1);
                                string.getClass();
                                switch (string) {
                                    case "end":
                                        z3 = !z;
                                        pix = f;
                                        break;
                                    case "left":
                                        z3 = true;
                                        pix = f;
                                        z2 = true;
                                        break;
                                    case "right":
                                        z3 = false;
                                        pix = f;
                                        break;
                                    case "start":
                                        z3 = z;
                                        pix = f;
                                        break;
                                    default:
                                        pix = f;
                                        break;
                                }
                            }
                            z2 = true;
                            break;
                        }
                        break;
                    case "end":
                        pix = toPix(state, cLObject.getFloat(str2));
                        z3 = !z;
                        break;
                    case "right":
                        pix = toPix(state, cLObject.getFloat(str2));
                        z3 = false;
                        break;
                    case "start":
                        pix = toPix(state, cLObject.getFloat(str2));
                        z3 = z;
                        break;
                }
            }
            pix = toPix(state, cLObject.getFloat(str2));
        }
    }

    static void parseBarrier(State state, String str, CLObject cLObject) throws CLParsingException {
        boolean zIsRtl = state.isRtl();
        BarrierReference barrierReferenceBarrier = state.barrier(str, State.Direction.END);
        ArrayList<String> arrayListNames = cLObject.names();
        if (arrayListNames == null) {
            return;
        }
        for (String str2 : arrayListNames) {
            str2.getClass();
            byte b = 2;
            switch (str2) {
                case "margin":
                    float floatOrNaN = cLObject.getFloatOrNaN(str2);
                    if (!Float.isNaN(floatOrNaN)) {
                        barrierReferenceBarrier.margin(Float.valueOf(toPix(state, floatOrNaN)));
                        break;
                    } else {
                        break;
                    }
                    break;
                case "direction":
                    String string = cLObject.getString(str2);
                    string.getClass();
                    switch (string.hashCode()) {
                        case -1383228885:
                            b = string.equals("bottom") ? (byte) 0 : (byte) -1;
                            break;
                        case 100571:
                            b = string.equals("end") ? (byte) 1 : (byte) -1;
                            break;
                        case 115029:
                            if (!string.equals("top")) {
                                b = -1;
                            }
                            break;
                        case 3317767:
                            b = string.equals("left") ? (byte) 3 : (byte) -1;
                            break;
                        case 108511772:
                            b = string.equals("right") ? (byte) 4 : (byte) -1;
                            break;
                        case 109757538:
                            b = string.equals("start") ? (byte) 5 : (byte) -1;
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    switch (b) {
                        case 0:
                            barrierReferenceBarrier.setBarrierDirection(State.Direction.BOTTOM);
                            break;
                        case 1:
                            if (!zIsRtl) {
                                barrierReferenceBarrier.setBarrierDirection(State.Direction.RIGHT);
                            } else {
                                barrierReferenceBarrier.setBarrierDirection(State.Direction.LEFT);
                            }
                            break;
                        case 2:
                            barrierReferenceBarrier.setBarrierDirection(State.Direction.TOP);
                            break;
                        case 3:
                            barrierReferenceBarrier.setBarrierDirection(State.Direction.LEFT);
                            break;
                        case 4:
                            barrierReferenceBarrier.setBarrierDirection(State.Direction.RIGHT);
                            break;
                        case 5:
                            if (!zIsRtl) {
                                barrierReferenceBarrier.setBarrierDirection(State.Direction.LEFT);
                            } else {
                                barrierReferenceBarrier.setBarrierDirection(State.Direction.RIGHT);
                            }
                            break;
                    }
                    break;
                case "contains":
                    CLArray arrayOrNull = cLObject.getArrayOrNull(str2);
                    if (arrayOrNull == null) {
                        break;
                    } else {
                        for (int i = 0; i < arrayOrNull.size(); i++) {
                            barrierReferenceBarrier.add(state.constraints(arrayOrNull.get(i).content()));
                        }
                        break;
                    }
                    break;
            }
        }
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, String str, CLObject cLObject) throws CLParsingException {
        parseWidget(state, layoutVariables, state.constraints(str), cLObject);
    }

    static void applyAttribute(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject, String str) throws CLParsingException {
        ConstraintReference constraintReferenceConstraints;
        str.getClass();
        switch (str) {
            case "centerVertically":
                String string = cLObject.getString(str);
                boolean zEquals = string.equals("parent");
                Object obj = string;
                if (zEquals) {
                    obj = State.PARENT;
                }
                ConstraintReference constraintReferenceConstraints2 = state.constraints(obj);
                constraintReference.topToTop(constraintReferenceConstraints2);
                constraintReference.bottomToBottom(constraintReferenceConstraints2);
                break;
            case "center":
                String string2 = cLObject.getString(str);
                if (string2.equals("parent")) {
                    constraintReferenceConstraints = state.constraints(State.PARENT);
                } else {
                    constraintReferenceConstraints = state.constraints(string2);
                }
                constraintReference.startToStart(constraintReferenceConstraints);
                constraintReference.endToEnd(constraintReferenceConstraints);
                constraintReference.topToTop(constraintReferenceConstraints);
                constraintReference.bottomToBottom(constraintReferenceConstraints);
                break;
            case "custom":
                parseCustomProperties(cLObject, constraintReference, str);
                break;
            case "rotationX":
                constraintReference.rotationX(layoutVariables.get(cLObject.get(str)));
                break;
            case "rotationY":
                constraintReference.rotationY(layoutVariables.get(cLObject.get(str)));
                break;
            case "rotationZ":
                constraintReference.rotationZ(layoutVariables.get(cLObject.get(str)));
                break;
            case "translationX":
                constraintReference.translationX(toPix(state, layoutVariables.get(cLObject.get(str))));
                break;
            case "translationY":
                constraintReference.translationY(toPix(state, layoutVariables.get(cLObject.get(str))));
                break;
            case "translationZ":
                constraintReference.translationZ(toPix(state, layoutVariables.get(cLObject.get(str))));
                break;
            case "height":
                constraintReference.setHeight(parseDimension(cLObject, str, state, state.getDpToPixel()));
                break;
            case "motion":
                parseMotionProperties(cLObject.get(str), constraintReference);
                break;
            case "pivotX":
                constraintReference.pivotX(layoutVariables.get(cLObject.get(str)));
                break;
            case "pivotY":
                constraintReference.pivotY(layoutVariables.get(cLObject.get(str)));
                break;
            case "scaleX":
                constraintReference.scaleX(layoutVariables.get(cLObject.get(str)));
                break;
            case "scaleY":
                constraintReference.scaleY(layoutVariables.get(cLObject.get(str)));
                break;
            case "hRtlBias":
                float f = layoutVariables.get(cLObject.get(str));
                if (state.isRtl()) {
                    f = 1.0f - f;
                }
                constraintReference.horizontalBias(f);
                break;
            case "vWeight":
                constraintReference.setVerticalChainWeight(layoutVariables.get(cLObject.get(str)));
                break;
            case "alpha":
                constraintReference.alpha(layoutVariables.get(cLObject.get(str)));
                break;
            case "hBias":
                constraintReference.horizontalBias(layoutVariables.get(cLObject.get(str)));
                break;
            case "vBias":
                constraintReference.verticalBias(layoutVariables.get(cLObject.get(str)));
                break;
            case "width":
                constraintReference.setWidth(parseDimension(cLObject, str, state, state.getDpToPixel()));
                break;
            case "hWeight":
                constraintReference.setHorizontalChainWeight(layoutVariables.get(cLObject.get(str)));
                break;
            case "centerHorizontally":
                String string3 = cLObject.getString(str);
                boolean zEquals2 = string3.equals("parent");
                Object obj2 = string3;
                if (zEquals2) {
                    obj2 = State.PARENT;
                }
                ConstraintReference constraintReferenceConstraints3 = state.constraints(obj2);
                constraintReference.startToStart(constraintReferenceConstraints3);
                constraintReference.endToEnd(constraintReferenceConstraints3);
                break;
            case "visibility":
                String string4 = cLObject.getString(str);
                string4.getClass();
                switch (string4) {
                    case "invisible":
                        constraintReference.visibility(4);
                        constraintReference.alpha(0.0f);
                        break;
                    case "gone":
                        constraintReference.visibility(8);
                        break;
                    case "visible":
                        constraintReference.visibility(0);
                        break;
                }
                break;
            default:
                parseConstraint(state, layoutVariables, cLObject, constraintReference, str);
                break;
        }
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject) throws CLParsingException {
        if (constraintReference.getWidth() == null) {
            constraintReference.setWidth(Dimension.createWrap());
        }
        if (constraintReference.getHeight() == null) {
            constraintReference.setHeight(Dimension.createWrap());
        }
        ArrayList arrayListNames = cLObject.names();
        if (arrayListNames == null) {
            return;
        }
        Iterator it = arrayListNames.iterator();
        while (it.hasNext()) {
            applyAttribute(state, layoutVariables, constraintReference, cLObject, (String) it.next());
        }
    }

    static void parseCustomProperties(CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ArrayList<String> arrayListNames;
        CLObject objectOrNull = cLObject.getObjectOrNull(str);
        if (objectOrNull == null || (arrayListNames = objectOrNull.names()) == null) {
            return;
        }
        for (String str2 : arrayListNames) {
            CLElement cLElement = objectOrNull.get(str2);
            if (cLElement instanceof CLNumber) {
                constraintReference.addCustomFloat(str2, cLElement.getFloat());
            } else if (cLElement instanceof CLString) {
                long colorString = parseColorString(cLElement.content());
                if (colorString != -1) {
                    constraintReference.addCustomColor(str2, (int) colorString);
                }
            }
        }
    }

    private static int indexOf(String str, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private static void parseMotionProperties(CLElement cLElement, ConstraintReference constraintReference) throws CLParsingException {
        if (cLElement instanceof CLObject) {
            CLObject cLObject = (CLObject) cLElement;
            TypedBundle typedBundle = new TypedBundle();
            ArrayList<String> arrayListNames = cLObject.names();
            if (arrayListNames == null) {
                return;
            }
            for (String str : arrayListNames) {
                str.getClass();
                switch (str) {
                    case "stagger":
                        typedBundle.add(600, cLObject.getFloat(str));
                        break;
                    case "easing":
                        typedBundle.add(603, cLObject.getString(str));
                        break;
                    case "quantize":
                        CLElement cLElement2 = cLObject.get(str);
                        if (cLElement2 instanceof CLArray) {
                            CLArray cLArray = (CLArray) cLElement2;
                            int size = cLArray.size();
                            if (size > 0) {
                                typedBundle.add(610, cLArray.getInt(0));
                                if (size > 1) {
                                    typedBundle.add(611, cLArray.getString(1));
                                    if (size > 2) {
                                        typedBundle.add(602, cLArray.getFloat(2));
                                    }
                                }
                            }
                            break;
                        } else {
                            typedBundle.add(610, cLObject.getInt(str));
                            break;
                        }
                        break;
                    case "pathArc":
                        String string = cLObject.getString(str);
                        int iIndexOf = indexOf(string, "none", "startVertical", "startHorizontal", "flip", "below", "above");
                        if (iIndexOf == -1) {
                            System.err.println(cLObject.getLine() + " pathArc = '" + string + "'");
                            break;
                        } else {
                            typedBundle.add(607, iIndexOf);
                            break;
                        }
                        break;
                    case "relativeTo":
                        typedBundle.add(605, cLObject.getString(str));
                        break;
                }
            }
            constraintReference.mMotionProperties = typedBundle;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:106:0x0190  */
    /* JADX WARN: Code duplicated, block: B:128:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:167:0x0266  */
    /* JADX WARN: Code duplicated, block: B:20:0x0085  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:82:0x012d  */
    /* JADX WARN: Failed to find 'out' block for switch in B:53:0x00d0. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    static void parseConstraint(State state, LayoutVariables layoutVariables, CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ConstraintReference constraintReferenceConstraints;
        ConstraintReference constraintReferenceConstraints2;
        boolean z;
        char c;
        boolean z2;
        boolean z3;
        ?? r16;
        boolean z4;
        boolean zIsRtl = state.isRtl();
        boolean z5 = !zIsRtl;
        CLArray arrayOrNull = cLObject.getArrayOrNull(str);
        if (arrayOrNull != null && arrayOrNull.size() > 1) {
            String string = arrayOrNull.getString(0);
            String stringOrNull = arrayOrNull.getStringOrNull(1);
            float pix = arrayOrNull.size() > 2 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(2))) : 0.0f;
            float pix2 = arrayOrNull.size() > 3 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(3))) : 0.0f;
            if (string.equals("parent")) {
                constraintReferenceConstraints2 = state.constraints(State.PARENT);
            } else {
                constraintReferenceConstraints2 = state.constraints(string);
            }
            str.getClass();
            float f = pix;
            switch (str) {
                case "baseline":
                    z = true;
                    c = 2;
                    stringOrNull.getClass();
                    switch (stringOrNull) {
                        case "baseline":
                            state.baselineNeededFor(constraintReference.getKey());
                            state.baselineNeededFor(constraintReferenceConstraints2.getKey());
                            constraintReference.baselineToBaseline(constraintReferenceConstraints2);
                            break;
                        case "bottom":
                            state.baselineNeededFor(constraintReference.getKey());
                            constraintReference.baselineToBottom(constraintReferenceConstraints2);
                            break;
                        case "top":
                            state.baselineNeededFor(constraintReference.getKey());
                            constraintReference.baselineToTop(constraintReferenceConstraints2);
                            break;
                    }
                    z2 = z;
                    z3 = false;
                    break;
                case "circular":
                    z = true;
                    c = 2;
                    constraintReference.circularConstraint(constraintReferenceConstraints2, layoutVariables.get(arrayOrNull.get(1)), arrayOrNull.size() > 2 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(2))) : 0.0f);
                    z2 = z;
                    z3 = false;
                    break;
                case "bottom":
                    stringOrNull.getClass();
                    switch (stringOrNull) {
                        case "baseline":
                            state.baselineNeededFor(constraintReferenceConstraints2.getKey());
                            constraintReference.bottomToBaseline(constraintReferenceConstraints2);
                            break;
                        case "bottom":
                            constraintReference.bottomToBottom(constraintReferenceConstraints2);
                            break;
                        case "top":
                            constraintReference.bottomToTop(constraintReferenceConstraints2);
                            break;
                    }
                    z = true;
                    c = 2;
                    z2 = z;
                    z3 = false;
                    break;
                case "end":
                    z2 = zIsRtl;
                    z = true;
                    c = 2;
                    z3 = true;
                    break;
                case "top":
                    stringOrNull.getClass();
                    switch (stringOrNull) {
                        case "baseline":
                            state.baselineNeededFor(constraintReferenceConstraints2.getKey());
                            constraintReference.topToBaseline(constraintReferenceConstraints2);
                            break;
                        case "bottom":
                            constraintReference.topToBottom(constraintReferenceConstraints2);
                            break;
                        case "top":
                            constraintReference.topToTop(constraintReferenceConstraints2);
                            break;
                    }
                    z = true;
                    c = 2;
                    z2 = z;
                    z3 = false;
                    break;
                case "left":
                    z2 = true;
                    z = true;
                    c = 2;
                    z3 = true;
                    break;
                case "right":
                    z2 = false;
                    z = true;
                    c = 2;
                    z3 = true;
                    break;
                case "start":
                    z2 = z5;
                    z = true;
                    c = 2;
                    z3 = true;
                    break;
                default:
                    z = true;
                    c = 2;
                    z2 = z;
                    z3 = false;
                    break;
            }
            if (z3) {
                stringOrNull.getClass();
                switch (stringOrNull.hashCode()) {
                    case 100571:
                        if (!stringOrNull.equals("end")) {
                            r16 = -1;
                        } else {
                            r16 = 0;
                        }
                        break;
                    case 3317767:
                        if (!stringOrNull.equals("left")) {
                            r16 = -1;
                        } else {
                            r16 = z;
                        }
                        break;
                    case 108511772:
                        if (!stringOrNull.equals("right")) {
                            r16 = -1;
                        } else {
                            r16 = c;
                        }
                        break;
                    case 109757538:
                        if (!stringOrNull.equals("start")) {
                            r16 = -1;
                        } else {
                            r16 = 3;
                        }
                        break;
                    default:
                        r16 = -1;
                        break;
                }
                switch (r16) {
                    case 0:
                        z4 = zIsRtl;
                        break;
                    case 1:
                    default:
                        z4 = z;
                        break;
                    case 2:
                        z4 = false;
                        break;
                    case 3:
                        z4 = z5;
                        break;
                }
                if (z2) {
                    if (z4) {
                        constraintReference.leftToLeft(constraintReferenceConstraints2);
                    } else {
                        constraintReference.leftToRight(constraintReferenceConstraints2);
                    }
                } else if (z4) {
                    constraintReference.rightToLeft(constraintReferenceConstraints2);
                } else {
                    constraintReference.rightToRight(constraintReferenceConstraints2);
                }
            }
            constraintReference.margin(Float.valueOf(f)).marginGone(Float.valueOf(pix2));
        }
        String stringOrNull2 = cLObject.getStringOrNull(str);
        if (stringOrNull2 != null) {
            if (stringOrNull2.equals("parent")) {
                constraintReferenceConstraints = state.constraints(State.PARENT);
            } else {
                constraintReferenceConstraints = state.constraints(stringOrNull2);
            }
            str.getClass();
            switch (str) {
                case "baseline":
                    state.baselineNeededFor(constraintReference.getKey());
                    state.baselineNeededFor(constraintReferenceConstraints.getKey());
                    constraintReference.baselineToBaseline(constraintReferenceConstraints);
                    break;
                case "bottom":
                    constraintReference.bottomToBottom(constraintReferenceConstraints);
                    break;
                case "end":
                    if (!zIsRtl) {
                        constraintReference.rightToRight(constraintReferenceConstraints);
                        break;
                    } else {
                        constraintReference.leftToLeft(constraintReferenceConstraints);
                        break;
                    }
                    break;
                case "top":
                    constraintReference.topToTop(constraintReferenceConstraints);
                    break;
                case "start":
                    if (!zIsRtl) {
                        constraintReference.leftToLeft(constraintReferenceConstraints);
                        break;
                    } else {
                        constraintReference.rightToRight(constraintReferenceConstraints);
                        break;
                    }
                    break;
            }
        }
    }

    static Dimension parseDimensionMode(String str) {
        Dimension dimensionCreateFixed = Dimension.createFixed(0);
        str.getClass();
        switch (str) {
            case "preferWrap":
                return Dimension.createSuggested(Dimension.WRAP_DIMENSION);
            case "parent":
                return Dimension.createParent();
            case "spread":
                return Dimension.createSuggested(Dimension.SPREAD_DIMENSION);
            case "wrap":
                return Dimension.createWrap();
            default:
                if (str.endsWith("%")) {
                    return Dimension.createPercent(0, Float.parseFloat(str.substring(0, str.indexOf(37))) / 100.0f).suggested(0);
                }
                return str.contains(com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR) ? Dimension.createRatio(str).suggested(Dimension.SPREAD_DIMENSION) : dimensionCreateFixed;
        }
    }

    static Dimension parseDimension(CLObject cLObject, String str, State state, CorePixelDp corePixelDp) throws CLParsingException {
        CLElement cLElement = cLObject.get(str);
        Dimension dimensionCreateFixed = Dimension.createFixed(0);
        if (cLElement instanceof CLString) {
            return parseDimensionMode(cLElement.content());
        }
        if (cLElement instanceof CLNumber) {
            return Dimension.createFixed(state.convertDimension(Float.valueOf(corePixelDp.toPixels(cLObject.getFloat(str)))));
        }
        if (cLElement instanceof CLObject) {
            CLObject cLObject2 = (CLObject) cLElement;
            String stringOrNull = cLObject2.getStringOrNull("value");
            if (stringOrNull != null) {
                dimensionCreateFixed = parseDimensionMode(stringOrNull);
            }
            CLElement orNull = cLObject2.getOrNull("min");
            if (orNull != null) {
                if (orNull instanceof CLNumber) {
                    dimensionCreateFixed.min(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull).getFloat()))));
                } else if (orNull instanceof CLString) {
                    dimensionCreateFixed.min(Dimension.WRAP_DIMENSION);
                }
            }
            CLElement orNull2 = cLObject2.getOrNull("max");
            if (orNull2 != null) {
                if (orNull2 instanceof CLNumber) {
                    dimensionCreateFixed.max(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull2).getFloat()))));
                    return dimensionCreateFixed;
                }
                if (orNull2 instanceof CLString) {
                    dimensionCreateFixed.max(Dimension.WRAP_DIMENSION);
                }
            }
        }
        return dimensionCreateFixed;
    }

    static long parseColorString(String str) {
        if (!str.startsWith("#")) {
            return -1L;
        }
        String strSubstring = str.substring(1);
        if (strSubstring.length() == 6) {
            strSubstring = "FF" + strSubstring;
        }
        return Long.parseLong(strSubstring, 16);
    }

    static String lookForType(CLObject cLObject) {
        Iterator it = cLObject.names().iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals("type")) {
                return cLObject.getString("type");
            }
        }
        return null;
    }
}
