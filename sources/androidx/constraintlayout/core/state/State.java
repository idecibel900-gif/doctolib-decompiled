package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.core.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.FlowReference;
import androidx.constraintlayout.core.state.helpers.GridReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.constraintlayout.core.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.core.state.helpers.VerticalChainReference;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class State {
    public static final Integer PARENT = 0;
    ArrayList mBaselineNeeded;
    ArrayList mBaselineNeededWidgets;
    boolean mDirtyBaselineNeededWidgets;
    private CorePixelDp mDpToPixel;
    private int mNumHelpers;
    public final ConstraintReference mParent;
    private boolean mIsLtr = true;
    protected HashMap mReferences = new HashMap();
    protected HashMap mHelperReferences = new HashMap();
    HashMap mTags = new HashMap();

    public enum Constraint {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        TOP_TO_BASELINE,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BOTTOM_TO_BASELINE,
        BASELINE_TO_BASELINE,
        BASELINE_TO_TOP,
        BASELINE_TO_BOTTOM,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY,
        CIRCULAR_CONSTRAINT
    }

    public enum Direction {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM
    }

    public enum Helper {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        HORIZONTAL_FLOW,
        VERTICAL_FLOW,
        GRID,
        ROW,
        COLUMN,
        FLOW
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 androidx.constraintlayout.core.state.State$Chain, still in use, count: 1, list:
      (r0v0 androidx.constraintlayout.core.state.State$Chain) from 0x0044: INVOKE 
      (wrap java.util.Map:0x0040: SGET  A[WRAPPED] (LINE:116) androidx.constraintlayout.core.state.State.Chain.chainMap java.util.Map)
      ("spread")
      (r0v0 androidx.constraintlayout.core.state.State$Chain)
     INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:116)
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class Chain {
        SPREAD,
        SPREAD_INSIDE,
        PACKED;

        public static Map chainMap = new HashMap();
        public static Map valueMap = new HashMap();

        private Chain() {
            super(str, i);
        }

        public static Chain valueOf(String str) {
            return (Chain) Enum.valueOf(Chain.class, str);
        }

        public static Chain[] values() {
            return (Chain[]) $VALUES.clone();
        }

        static {
            chainMap.put("packed", new Chain());
            chainMap.put("spread_inside", new Chain());
            chainMap.put("spread", new Chain());
            valueMap.put("packed", 2);
            valueMap.put("spread_inside", 1);
            valueMap.put("spread", 0);
        }

        public static int getValueByString(String str) {
            if (valueMap.containsKey(str)) {
                return ((Integer) valueMap.get(str)).intValue();
            }
            return -1;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 androidx.constraintlayout.core.state.State$Wrap, still in use, count: 1, list:
      (r0v0 androidx.constraintlayout.core.state.State$Wrap) from 0x0036: INVOKE 
      (wrap java.util.Map:0x0032: SGET  A[WRAPPED] (LINE:156) androidx.constraintlayout.core.state.State.Wrap.wrapMap java.util.Map)
      ("none")
      (r0v0 androidx.constraintlayout.core.state.State$Wrap)
     INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:156)
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class Wrap {
        NONE,
        CHAIN,
        ALIGNED;

        public static Map wrapMap = new HashMap();
        public static Map valueMap = new HashMap();

        private Wrap() {
            super(str, i);
        }

        public static Wrap valueOf(String str) {
            return (Wrap) Enum.valueOf(Wrap.class, str);
        }

        public static Wrap[] values() {
            return (Wrap[]) $VALUES.clone();
        }

        static {
            wrapMap.put("none", new Wrap());
            wrapMap.put("chain", new Wrap());
            wrapMap.put("aligned", new Wrap());
            valueMap.put("none", 0);
            valueMap.put("chain", 3);
            valueMap.put("aligned", 2);
        }

        public static int getValueByString(String str) {
            if (valueMap.containsKey(str)) {
                return ((Integer) valueMap.get(str)).intValue();
            }
            return -1;
        }
    }

    public State() {
        ConstraintReference constraintReference = new ConstraintReference(this);
        this.mParent = constraintReference;
        this.mNumHelpers = 0;
        this.mBaselineNeeded = new ArrayList();
        this.mBaselineNeededWidgets = new ArrayList();
        this.mDirtyBaselineNeededWidgets = true;
        Integer num = PARENT;
        constraintReference.setKey(num);
        this.mReferences.put(num, constraintReference);
    }

    CorePixelDp getDpToPixel() {
        return this.mDpToPixel;
    }

    public void setDpToPixel(CorePixelDp corePixelDp) {
        this.mDpToPixel = corePixelDp;
    }

    public void setRtl(boolean z) {
        this.mIsLtr = !z;
    }

    public boolean isRtl() {
        return !this.mIsLtr;
    }

    public void reset() {
        Iterator it = this.mReferences.keySet().iterator();
        while (it.hasNext()) {
            ((Reference) this.mReferences.get(it.next())).getConstraintWidget().reset();
        }
        this.mReferences.clear();
        this.mReferences.put(PARENT, this.mParent);
        this.mHelperReferences.clear();
        this.mTags.clear();
        this.mBaselineNeeded.clear();
        this.mDirtyBaselineNeededWidgets = true;
    }

    public int convertDimension(Object obj) {
        if (obj instanceof Float) {
            return Math.round(((Float) obj).floatValue());
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public ConstraintReference createConstraintReference(Object obj) {
        return new ConstraintReference(this);
    }

    public State width(Dimension dimension) {
        return setWidth(dimension);
    }

    public State height(Dimension dimension) {
        return setHeight(dimension);
    }

    public State setWidth(Dimension dimension) {
        this.mParent.setWidth(dimension);
        return this;
    }

    public State setHeight(Dimension dimension) {
        this.mParent.setHeight(dimension);
        return this;
    }

    Reference reference(Object obj) {
        return (Reference) this.mReferences.get(obj);
    }

    public ConstraintReference constraints(Object obj) {
        Reference referenceCreateConstraintReference = (Reference) this.mReferences.get(obj);
        if (referenceCreateConstraintReference == null) {
            referenceCreateConstraintReference = createConstraintReference(obj);
            this.mReferences.put(obj, referenceCreateConstraintReference);
            referenceCreateConstraintReference.setKey(obj);
        }
        if (referenceCreateConstraintReference instanceof ConstraintReference) {
            return (ConstraintReference) referenceCreateConstraintReference;
        }
        return null;
    }

    private String createHelperKey() {
        StringBuilder sb = new StringBuilder();
        sb.append("__HELPER_KEY_");
        int i = this.mNumHelpers;
        this.mNumHelpers = i + 1;
        sb.append(i);
        sb.append("__");
        return sb.toString();
    }

    public HelperReference helper(Object obj, Helper helper) {
        if (obj == null) {
            obj = createHelperKey();
        }
        HelperReference horizontalChainReference = (HelperReference) this.mHelperReferences.get(obj);
        if (horizontalChainReference == null) {
            switch (helper) {
                case HORIZONTAL_CHAIN:
                    horizontalChainReference = new HorizontalChainReference(this);
                    break;
                case VERTICAL_CHAIN:
                    horizontalChainReference = new VerticalChainReference(this);
                    break;
                case ALIGN_HORIZONTALLY:
                    horizontalChainReference = new AlignHorizontallyReference(this);
                    break;
                case ALIGN_VERTICALLY:
                    horizontalChainReference = new AlignVerticallyReference(this);
                    break;
                case BARRIER:
                    horizontalChainReference = new BarrierReference(this);
                    break;
                case LAYER:
                default:
                    horizontalChainReference = new HelperReference(this, helper);
                    break;
                case HORIZONTAL_FLOW:
                case VERTICAL_FLOW:
                    horizontalChainReference = new FlowReference(this, helper);
                    break;
                case GRID:
                case ROW:
                case COLUMN:
                    horizontalChainReference = new GridReference(this, helper);
                    break;
            }
            horizontalChainReference.setKey(obj);
            this.mHelperReferences.put(obj, horizontalChainReference);
        }
        return horizontalChainReference;
    }

    public GuidelineReference horizontalGuideline(Object obj) {
        return guideline(obj, 0);
    }

    public GuidelineReference verticalGuideline(Object obj) {
        return guideline(obj, 1);
    }

    public GuidelineReference guideline(Object obj, int i) {
        ConstraintReference constraintReferenceConstraints = constraints(obj);
        if (constraintReferenceConstraints.getFacade() == null || !(constraintReferenceConstraints.getFacade() instanceof GuidelineReference)) {
            GuidelineReference guidelineReference = new GuidelineReference(this);
            guidelineReference.setOrientation(i);
            guidelineReference.setKey(obj);
            constraintReferenceConstraints.setFacade(guidelineReference);
        }
        return (GuidelineReference) constraintReferenceConstraints.getFacade();
    }

    public BarrierReference barrier(Object obj, Direction direction) {
        ConstraintReference constraintReferenceConstraints = constraints(obj);
        if (constraintReferenceConstraints.getFacade() == null || !(constraintReferenceConstraints.getFacade() instanceof BarrierReference)) {
            BarrierReference barrierReference = new BarrierReference(this);
            barrierReference.setBarrierDirection(direction);
            constraintReferenceConstraints.setFacade(barrierReference);
        }
        return (BarrierReference) constraintReferenceConstraints.getFacade();
    }

    public GridReference getGrid(Object obj, String str) {
        ConstraintReference constraintReferenceConstraints = constraints(obj);
        if (constraintReferenceConstraints.getFacade() == null || !(constraintReferenceConstraints.getFacade() instanceof GridReference)) {
            Helper helper = Helper.GRID;
            if (str.charAt(0) == 'r') {
                helper = Helper.ROW;
            } else if (str.charAt(0) == 'c') {
                helper = Helper.COLUMN;
            }
            constraintReferenceConstraints.setFacade(new GridReference(this, helper));
        }
        return (GridReference) constraintReferenceConstraints.getFacade();
    }

    public FlowReference getFlow(Object obj, boolean z) {
        FlowReference flowReference;
        ConstraintReference constraintReferenceConstraints = constraints(obj);
        if (constraintReferenceConstraints.getFacade() == null || !(constraintReferenceConstraints.getFacade() instanceof FlowReference)) {
            if (z) {
                flowReference = new FlowReference(this, Helper.VERTICAL_FLOW);
            } else {
                flowReference = new FlowReference(this, Helper.HORIZONTAL_FLOW);
            }
            constraintReferenceConstraints.setFacade(flowReference);
        }
        return (FlowReference) constraintReferenceConstraints.getFacade();
    }

    public VerticalChainReference verticalChain() {
        return (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
    }

    public HorizontalChainReference horizontalChain() {
        return (HorizontalChainReference) helper(null, Helper.HORIZONTAL_CHAIN);
    }

    public void map(Object obj, Object obj2) {
        ConstraintReference constraintReferenceConstraints = constraints(obj);
        if (constraintReferenceConstraints != null) {
            constraintReferenceConstraints.setView(obj2);
        }
    }

    public void setTag(String str, String str2) {
        ArrayList arrayList;
        ConstraintReference constraintReferenceConstraints = constraints(str);
        if (constraintReferenceConstraints != null) {
            constraintReferenceConstraints.setTag(str2);
            if (!this.mTags.containsKey(str2)) {
                arrayList = new ArrayList();
                this.mTags.put(str2, arrayList);
            } else {
                arrayList = (ArrayList) this.mTags.get(str2);
            }
            arrayList.add(str);
        }
    }

    public ArrayList getIdsForTag(String str) {
        if (this.mTags.containsKey(str)) {
            return (ArrayList) this.mTags.get(str);
        }
        return null;
    }

    public void apply(ConstraintWidgetContainer constraintWidgetContainer) {
        HelperReference helperReference;
        HelperWidget helperWidget;
        HelperWidget helperWidget2;
        constraintWidgetContainer.removeAllChildren();
        this.mParent.getWidth().apply(this, constraintWidgetContainer, 0);
        this.mParent.getHeight().apply(this, constraintWidgetContainer, 1);
        for (Object obj : this.mHelperReferences.keySet()) {
            HelperWidget helperWidget3 = ((HelperReference) this.mHelperReferences.get(obj)).getHelperWidget();
            if (helperWidget3 != null) {
                Reference referenceConstraints = (Reference) this.mReferences.get(obj);
                if (referenceConstraints == null) {
                    referenceConstraints = constraints(obj);
                }
                referenceConstraints.setConstraintWidget(helperWidget3);
            }
        }
        for (Object obj2 : this.mReferences.keySet()) {
            Reference reference = (Reference) this.mReferences.get(obj2);
            if (reference != this.mParent && (reference.getFacade() instanceof HelperReference) && (helperWidget2 = ((HelperReference) reference.getFacade()).getHelperWidget()) != null) {
                Reference referenceConstraints2 = (Reference) this.mReferences.get(obj2);
                if (referenceConstraints2 == null) {
                    referenceConstraints2 = constraints(obj2);
                }
                referenceConstraints2.setConstraintWidget(helperWidget2);
            }
        }
        Iterator it = this.mReferences.keySet().iterator();
        while (it.hasNext()) {
            Reference reference2 = (Reference) this.mReferences.get(it.next());
            if (reference2 != this.mParent) {
                ConstraintWidget constraintWidget = reference2.getConstraintWidget();
                constraintWidget.setDebugName(reference2.getKey().toString());
                constraintWidget.setParent(null);
                if (reference2.getFacade() instanceof GuidelineReference) {
                    reference2.apply();
                }
                constraintWidgetContainer.add(constraintWidget);
            } else {
                reference2.setConstraintWidget(constraintWidgetContainer);
            }
        }
        Iterator it2 = this.mHelperReferences.keySet().iterator();
        while (it2.hasNext()) {
            HelperReference helperReference2 = (HelperReference) this.mHelperReferences.get(it2.next());
            if (helperReference2.getHelperWidget() != null) {
                Iterator it3 = helperReference2.mReferences.iterator();
                while (it3.hasNext()) {
                    helperReference2.getHelperWidget().add(((Reference) this.mReferences.get(it3.next())).getConstraintWidget());
                }
                helperReference2.apply();
            } else {
                helperReference2.apply();
            }
        }
        Iterator it4 = this.mReferences.keySet().iterator();
        while (it4.hasNext()) {
            Reference reference3 = (Reference) this.mReferences.get(it4.next());
            if (reference3 != this.mParent && (reference3.getFacade() instanceof HelperReference) && (helperWidget = (helperReference = (HelperReference) reference3.getFacade()).getHelperWidget()) != null) {
                for (Object obj3 : helperReference.mReferences) {
                    Reference reference4 = (Reference) this.mReferences.get(obj3);
                    if (reference4 != null) {
                        helperWidget.add(reference4.getConstraintWidget());
                    } else if (obj3 instanceof Reference) {
                        helperWidget.add(((Reference) obj3).getConstraintWidget());
                    } else {
                        System.out.println("couldn't find reference for " + obj3);
                    }
                }
                reference3.apply();
            }
        }
        for (Object obj4 : this.mReferences.keySet()) {
            Reference reference5 = (Reference) this.mReferences.get(obj4);
            reference5.apply();
            ConstraintWidget constraintWidget2 = reference5.getConstraintWidget();
            if (constraintWidget2 != null && obj4 != null) {
                constraintWidget2.stringId = obj4.toString();
            }
        }
    }

    public void baselineNeededFor(Object obj) {
        this.mBaselineNeeded.add(obj);
        this.mDirtyBaselineNeededWidgets = true;
    }

    public boolean isBaselineNeeded(ConstraintWidget constraintWidget) {
        if (this.mDirtyBaselineNeededWidgets) {
            this.mBaselineNeededWidgets.clear();
            Iterator it = this.mBaselineNeeded.iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget2 = ((Reference) this.mReferences.get(it.next())).getConstraintWidget();
                if (constraintWidget2 != null) {
                    this.mBaselineNeededWidgets.add(constraintWidget2);
                }
            }
            this.mDirtyBaselineNeededWidgets = false;
        }
        return this.mBaselineNeededWidgets.contains(constraintWidget);
    }
}
