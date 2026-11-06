package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.parser.CLObject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes.dex */
public final class ConstrainScope {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "width", "getWidth()Landroidx/constraintlayout/compose/Dimension;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "height", "getHeight()Landroidx/constraintlayout/compose/Dimension;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "visibility", "getVisibility()Landroidx/constraintlayout/compose/Visibility;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "scaleX", "getScaleX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "scaleY", "getScaleY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "rotationX", "getRotationX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "rotationY", "getRotationY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "rotationZ", "getRotationZ()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "translationX", "getTranslationX-D9Ej5fM()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "translationY", "getTranslationY-D9Ej5fM()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "translationZ", "getTranslationZ-D9Ej5fM()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "pivotX", "getPivotX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "pivotY", "getPivotY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "horizontalChainWeight", "getHorizontalChainWeight()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "verticalChainWeight", "getVerticalChainWeight()F", 0))};
    private final VerticalAnchorable absoluteLeft;
    private final VerticalAnchorable absoluteRight;
    private float alpha;
    private final BaselineAnchorable baseline;
    private final HorizontalAnchorable bottom;
    private final CLObject containerObject;
    private final VerticalAnchorable end;
    private final DimensionProperty height$delegate;
    private float horizontalBias;
    private final FloatProperty horizontalChainWeight$delegate;
    private final Object id;
    private final ConstrainedLayoutReference parent = new ConstrainedLayoutReference("parent");
    private final FloatProperty pivotX$delegate;
    private final FloatProperty pivotY$delegate;
    private final FloatProperty rotationX$delegate;
    private final FloatProperty rotationY$delegate;
    private final FloatProperty rotationZ$delegate;
    private final FloatProperty scaleX$delegate;
    private final FloatProperty scaleY$delegate;
    private final VerticalAnchorable start;
    private final HorizontalAnchorable top;
    private final DpProperty translationX$delegate;
    private final DpProperty translationY$delegate;
    private final DpProperty translationZ$delegate;
    private float verticalBias;
    private final FloatProperty verticalChainWeight$delegate;
    private final ConstrainScope$visibility$2 visibility$delegate;
    private final DimensionProperty width$delegate;

    /* JADX WARN: Type inference failed for: r15v3, types: [androidx.constraintlayout.compose.ConstrainScope$visibility$2] */
    public ConstrainScope(Object obj, CLObject cLObject) {
        this.id = obj;
        this.containerObject = cLObject;
        this.start = new ConstraintVerticalAnchorable(-2, cLObject);
        this.absoluteLeft = new ConstraintVerticalAnchorable(0, cLObject);
        this.top = new ConstraintHorizontalAnchorable(0, cLObject);
        this.end = new ConstraintVerticalAnchorable(-1, cLObject);
        this.absoluteRight = new ConstraintVerticalAnchorable(1, cLObject);
        this.bottom = new ConstraintHorizontalAnchorable(1, cLObject);
        this.baseline = new ConstraintBaselineAnchorable(cLObject);
        Dimension.Companion companion = Dimension.Companion;
        this.width$delegate = new DimensionProperty(companion.getWrapContent());
        this.height$delegate = new DimensionProperty(companion.getWrapContent());
        final Visibility visible = Visibility.Companion.getVisible();
        this.visibility$delegate = new ObservableProperty(visible) { // from class: androidx.constraintlayout.compose.ConstrainScope$visibility$2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty kProperty, Visibility visibility, Visibility visibility2) {
                this.this$0.getContainerObject$constraintlayout_compose_release().putString(kProperty.getName(), visibility2.getName$constraintlayout_compose_release());
            }
        };
        this.alpha = 1.0f;
        this.scaleX$delegate = new FloatProperty(this, 1.0f, null, 2, null);
        int i = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        String str = null;
        this.scaleY$delegate = new FloatProperty(this, 1.0f, str, i, defaultConstructorMarker);
        float f = 0.0f;
        this.rotationX$delegate = new FloatProperty(this, f, str, i, defaultConstructorMarker);
        this.rotationY$delegate = new FloatProperty(this, f, str, i, defaultConstructorMarker);
        this.rotationZ$delegate = new FloatProperty(this, f, str, i, defaultConstructorMarker);
        float f2 = 0;
        this.translationX$delegate = new DpProperty(this, Dp.m2551constructorimpl(f2), str, i, defaultConstructorMarker);
        this.translationY$delegate = new DpProperty(this, Dp.m2551constructorimpl(f2), str, i, defaultConstructorMarker);
        this.translationZ$delegate = new DpProperty(this, Dp.m2551constructorimpl(f2), str, i, defaultConstructorMarker);
        float f3 = 0.5f;
        this.pivotX$delegate = new FloatProperty(this, f3, str, i, defaultConstructorMarker);
        this.pivotY$delegate = new FloatProperty(this, f3, str, i, defaultConstructorMarker);
        this.horizontalChainWeight$delegate = new FloatProperty(Float.NaN, "hWeight");
        this.verticalChainWeight$delegate = new FloatProperty(Float.NaN, "vWeight");
        this.horizontalBias = 0.5f;
        this.verticalBias = 0.5f;
    }

    public final CLObject getContainerObject$constraintlayout_compose_release() {
        return this.containerObject;
    }

    public final ConstrainedLayoutReference getParent() {
        return this.parent;
    }

    public final VerticalAnchorable getStart() {
        return this.start;
    }

    public final HorizontalAnchorable getTop() {
        return this.top;
    }

    public final VerticalAnchorable getEnd() {
        return this.end;
    }

    public final HorizontalAnchorable getBottom() {
        return this.bottom;
    }

    public final void setWidth(Dimension dimension) {
        this.width$delegate.setValue(this, $$delegatedProperties[0], dimension);
    }

    public final void setHeight(Dimension dimension) {
        this.height$delegate.setValue(this, $$delegatedProperties[1], dimension);
    }

    /* JADX INFO: renamed from: linkTo-8ZKsbrE$default, reason: not valid java name */
    public static /* synthetic */ void m2680linkTo8ZKsbrE$default(ConstrainScope constrainScope, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Dp.m2551constructorimpl(0);
        }
        float f6 = f;
        if ((i & 8) != 0) {
            f2 = Dp.m2551constructorimpl(0);
        }
        float f7 = f2;
        if ((i & 16) != 0) {
            f3 = Dp.m2551constructorimpl(0);
        }
        constrainScope.m2681linkTo8ZKsbrE(horizontalAnchor, horizontalAnchor2, f6, f7, f3, (i & 32) != 0 ? Dp.m2551constructorimpl(0) : f4, (i & 64) != 0 ? 0.5f : f5);
    }

    public final void setHorizontalBias(float f) {
        this.horizontalBias = f;
        if (Float.isNaN(f)) {
            return;
        }
        this.containerObject.putNumber("hBias", f);
    }

    /* JADX INFO: renamed from: linkTo-8ZKsbrE, reason: not valid java name */
    public final void m2681linkTo8ZKsbrE(ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5) {
        this.top.mo2678linkToVpY3zN4(horizontalAnchor, f, f3);
        this.bottom.mo2678linkToVpY3zN4(horizontalAnchor2, f2, f4);
        this.containerObject.putNumber("vBias", f5);
    }

    public static /* synthetic */ void centerVerticallyTo$default(ConstrainScope constrainScope, ConstrainedLayoutReference constrainedLayoutReference, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        constrainScope.centerVerticallyTo(constrainedLayoutReference, f);
    }

    public final void centerVerticallyTo(ConstrainedLayoutReference constrainedLayoutReference, float f) {
        m2680linkTo8ZKsbrE$default(this, constrainedLayoutReference.getTop(), constrainedLayoutReference.getBottom(), 0.0f, 0.0f, 0.0f, 0.0f, f, 60, null);
    }

    private final class DimensionProperty extends ObservableProperty {
        public DimensionProperty(Dimension dimension) {
            super(dimension);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.properties.ObservableProperty
        public void afterChange(KProperty kProperty, Dimension dimension, Dimension dimension2) {
            CLObject containerObject$constraintlayout_compose_release = ConstrainScope.this.getContainerObject$constraintlayout_compose_release();
            String name = kProperty.getName();
            Intrinsics.checkNotNull(dimension2, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
            containerObject$constraintlayout_compose_release.put(name, ((DimensionDescription) dimension2).asCLElement$constraintlayout_compose_release());
        }
    }

    private final class FloatProperty extends ObservableProperty {
        private final String nameOverride;

        public FloatProperty(float f, String str) {
            super(Float.valueOf(f));
            this.nameOverride = str;
        }

        public /* synthetic */ FloatProperty(ConstrainScope constrainScope, float f, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, (i & 2) != 0 ? null : str);
        }

        @Override // kotlin.properties.ObservableProperty
        public /* bridge */ /* synthetic */ void afterChange(KProperty kProperty, Object obj, Object obj2) {
            afterChange(kProperty, ((Number) obj).floatValue(), ((Number) obj2).floatValue());
        }

        protected void afterChange(KProperty kProperty, float f, float f2) {
            if (Float.isNaN(f2)) {
                return;
            }
            CLObject containerObject$constraintlayout_compose_release = ConstrainScope.this.getContainerObject$constraintlayout_compose_release();
            String name = this.nameOverride;
            if (name == null) {
                name = kProperty.getName();
            }
            containerObject$constraintlayout_compose_release.putNumber(name, f2);
        }
    }

    private final class DpProperty extends ObservableProperty {
        private final String nameOverride;

        public /* synthetic */ DpProperty(ConstrainScope constrainScope, float f, String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, str);
        }

        private DpProperty(float f, String str) {
            super(Dp.m2549boximpl(f));
            this.nameOverride = str;
        }

        public /* synthetic */ DpProperty(ConstrainScope constrainScope, float f, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(constrainScope, f, (i & 2) != 0 ? null : str, null);
        }

        @Override // kotlin.properties.ObservableProperty
        public /* bridge */ /* synthetic */ void afterChange(KProperty kProperty, Object obj, Object obj2) {
            m2682afterChangeVpY3zN4(kProperty, ((Dp) obj).m2557unboximpl(), ((Dp) obj2).m2557unboximpl());
        }

        /* JADX INFO: renamed from: afterChange-VpY3zN4, reason: not valid java name */
        protected void m2682afterChangeVpY3zN4(KProperty kProperty, float f, float f2) {
            if (Float.isNaN(f2)) {
                return;
            }
            CLObject containerObject$constraintlayout_compose_release = ConstrainScope.this.getContainerObject$constraintlayout_compose_release();
            String name = this.nameOverride;
            if (name == null) {
                name = kProperty.getName();
            }
            containerObject$constraintlayout_compose_release.putNumber(name, f2);
        }
    }
}
