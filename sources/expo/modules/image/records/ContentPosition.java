package expo.modules.image.records;

import android.graphics.Matrix;
import android.graphics.RectF;
import expo.modules.image.ImageUtilsKt;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Je\u0010\u000f\u001a\u0004\u0018\u00010\f*\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2.\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0017\u0010\u0018R(\u0010\u001a\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001c\u0010\u001dR(\u0010\u001f\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u0012\u0004\b!\u0010\u0003\u001a\u0004\b \u0010\u001dR(\u0010\"\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010\u001b\u0012\u0004\b$\u0010\u0003\u001a\u0004\b#\u0010\u001dR(\u0010%\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b%\u0010\u001b\u0012\u0004\b'\u0010\u0003\u001a\u0004\b&\u0010\u001d¨\u0006)"}, d2 = {"Lexpo/modules/image/records/ContentPosition;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "", "Lexpo/modules/image/records/ContentPositionValue;", "", "isReverse", "Landroid/graphics/RectF;", "imageRect", "viewRect", "Lkotlin/Function5;", "", "Lexpo/modules/image/records/CalcAxisOffset;", "calcAxisOffset", "calcOffset", "(Ljava/lang/Object;ZLandroid/graphics/RectF;Landroid/graphics/RectF;Lkotlin/jvm/functions/Function5;)Ljava/lang/Float;", "offsetX", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)F", "offsetY", "Landroid/graphics/Matrix;", "to", "", "apply$expo_image_release", "(Landroid/graphics/Matrix;Landroid/graphics/RectF;Landroid/graphics/RectF;)V", "apply", "top", "Ljava/lang/Object;", "getTop", "()Ljava/lang/Object;", "getTop$annotations", "bottom", "getBottom", "getBottom$annotations", "right", "getRight", "getRight$annotations", "left", "getLeft", "getLeft$annotations", "Companion", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentPosition implements Record {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ContentPosition center = new ContentPosition();
    private final Object bottom;
    private final Object left;
    private final Object right;
    private final Object top;

    @Field
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Field
    public static /* synthetic */ void getLeft$annotations() {
    }

    @Field
    public static /* synthetic */ void getRight$annotations() {
    }

    @Field
    public static /* synthetic */ void getTop$annotations() {
    }

    public final Object getTop() {
        return this.top;
    }

    public final Object getBottom() {
        return this.bottom;
    }

    public final Object getRight() {
        return this.right;
    }

    public final Object getLeft() {
        return this.left;
    }

    private final Float calcOffset(Object obj, boolean z, RectF rectF, RectF rectF2, Function5 function5) {
        float fFloatValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Double) {
            return (Float) function5.invoke(Float.valueOf((float) ((Number) obj).doubleValue()), rectF, rectF2, Boolean.FALSE, Boolean.valueOf(z));
        }
        String str = (String) obj;
        if (Intrinsics.areEqual(str, "center")) {
            fFloatValue = ((Number) function5.invoke(Float.valueOf(50.0f), rectF, rectF2, Boolean.TRUE, Boolean.valueOf(z))).floatValue();
        } else {
            fFloatValue = ((Number) function5.invoke(Float.valueOf(Float.parseFloat(StringsKt.removeSuffix(str, "%"))), rectF, rectF2, Boolean.TRUE, Boolean.valueOf(z))).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: expo.modules.image.records.ContentPosition$offsetX$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function5 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(5, ImageUtilsKt.class, "calcXTranslation", "calcXTranslation(FLandroid/graphics/RectF;Landroid/graphics/RectF;ZZ)F", 1);
        }

        public final Float invoke(float f, RectF p1, RectF p2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            return Float.valueOf(ImageUtilsKt.calcXTranslation(f, p1, p2, z, z2));
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return invoke(((Number) obj).floatValue(), (RectF) obj2, (RectF) obj3, ((Boolean) obj4).booleanValue(), ((Boolean) obj5).booleanValue());
        }
    }

    /* JADX INFO: renamed from: expo.modules.image.records.ContentPosition$offsetX$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function5 {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(5, ImageUtilsKt.class, "calcXTranslation", "calcXTranslation(FLandroid/graphics/RectF;Landroid/graphics/RectF;ZZ)F", 1);
        }

        public final Float invoke(float f, RectF p1, RectF p2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            return Float.valueOf(ImageUtilsKt.calcXTranslation(f, p1, p2, z, z2));
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return invoke(((Number) obj).floatValue(), (RectF) obj2, (RectF) obj3, ((Boolean) obj4).booleanValue(), ((Boolean) obj5).booleanValue());
        }
    }

    private final float offsetX(RectF imageRect, RectF viewRect) {
        Float fCalcOffset = calcOffset(this.left, false, imageRect, viewRect, AnonymousClass1.INSTANCE);
        if (fCalcOffset != null) {
            return fCalcOffset.floatValue();
        }
        Float fCalcOffset2 = calcOffset(this.right, true, imageRect, viewRect, AnonymousClass2.INSTANCE);
        if (fCalcOffset2 != null) {
            return fCalcOffset2.floatValue();
        }
        return ImageUtilsKt.calcXTranslation$default(50.0f, imageRect, viewRect, true, false, 16, null);
    }

    /* JADX INFO: renamed from: expo.modules.image.records.ContentPosition$offsetY$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C10881 extends FunctionReferenceImpl implements Function5 {
        public static final C10881 INSTANCE = new C10881();

        C10881() {
            super(5, ImageUtilsKt.class, "calcYTranslation", "calcYTranslation(FLandroid/graphics/RectF;Landroid/graphics/RectF;ZZ)F", 1);
        }

        public final Float invoke(float f, RectF p1, RectF p2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            return Float.valueOf(ImageUtilsKt.calcYTranslation(f, p1, p2, z, z2));
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return invoke(((Number) obj).floatValue(), (RectF) obj2, (RectF) obj3, ((Boolean) obj4).booleanValue(), ((Boolean) obj5).booleanValue());
        }
    }

    /* JADX INFO: renamed from: expo.modules.image.records.ContentPosition$offsetY$2, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C10892 extends FunctionReferenceImpl implements Function5 {
        public static final C10892 INSTANCE = new C10892();

        C10892() {
            super(5, ImageUtilsKt.class, "calcYTranslation", "calcYTranslation(FLandroid/graphics/RectF;Landroid/graphics/RectF;ZZ)F", 1);
        }

        public final Float invoke(float f, RectF p1, RectF p2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            return Float.valueOf(ImageUtilsKt.calcYTranslation(f, p1, p2, z, z2));
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return invoke(((Number) obj).floatValue(), (RectF) obj2, (RectF) obj3, ((Boolean) obj4).booleanValue(), ((Boolean) obj5).booleanValue());
        }
    }

    private final float offsetY(RectF imageRect, RectF viewRect) {
        Float fCalcOffset = calcOffset(this.top, false, imageRect, viewRect, C10881.INSTANCE);
        if (fCalcOffset != null) {
            return fCalcOffset.floatValue();
        }
        Float fCalcOffset2 = calcOffset(this.bottom, true, imageRect, viewRect, C10892.INSTANCE);
        if (fCalcOffset2 != null) {
            return fCalcOffset2.floatValue();
        }
        return ImageUtilsKt.calcYTranslation$default(50.0f, imageRect, viewRect, true, false, 16, null);
    }

    public final void apply$expo_image_release(Matrix to, RectF imageRect, RectF viewRect) {
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(imageRect, "imageRect");
        Intrinsics.checkNotNullParameter(viewRect, "viewRect");
        to.postTranslate(offsetX(imageRect, viewRect), offsetY(imageRect, viewRect));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ContentPosition getCenter() {
            return ContentPosition.center;
        }
    }
}
