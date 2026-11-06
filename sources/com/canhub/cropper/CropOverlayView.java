package com.canhub.cropper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0000\u0018\u0000 Â\u00012\u00020\u0001:\u0006Â\u0001Ã\u0001Ä\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0013J/\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ7\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001f\u0010 J/\u0010!\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018H\u0002¢\u0006\u0004\b!\u0010\u001cJ\u001f\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0018H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\nJ\u001f\u0010'\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0018H\u0002¢\u0006\u0004\b'\u0010%J\u0017\u0010)\u001a\u00020(2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020\b¢\u0006\u0004\b/\u0010\nJ'\u00105\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u000202¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\b¢\u0006\u0004\b7\u0010\nJ\u0015\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\u0015\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J\u0015\u0010A\u001a\u00020\b2\u0006\u0010@\u001a\u00020(¢\u0006\u0004\bA\u0010BJ\u0017\u0010E\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bE\u0010FJ\u0015\u0010H\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u0018¢\u0006\u0004\bH\u0010IJ\u0015\u0010K\u001a\u00020\b2\u0006\u0010J\u001a\u000202¢\u0006\u0004\bK\u0010LJ\u0015\u0010O\u001a\u00020\b2\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bO\u0010PJ\u0015\u0010R\u001a\u00020\b2\u0006\u0010Q\u001a\u00020(¢\u0006\u0004\bR\u0010BJ\u0015\u0010T\u001a\u00020\b2\u0006\u0010S\u001a\u00020\u0018¢\u0006\u0004\bT\u0010IJ\u0015\u0010V\u001a\u00020\b2\u0006\u0010U\u001a\u00020\u0018¢\u0006\u0004\bV\u0010IJ\u0015\u0010X\u001a\u00020(2\u0006\u0010W\u001a\u00020(¢\u0006\u0004\bX\u0010YJ\u0015\u0010[\u001a\u00020(2\u0006\u0010Z\u001a\u00020(¢\u0006\u0004\b[\u0010YJ-\u0010`\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\u00182\u0006\u0010]\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00182\u0006\u0010_\u001a\u00020\u0018¢\u0006\u0004\b`\u0010aJ\u0015\u0010d\u001a\u00020\b2\u0006\u0010c\u001a\u00020b¢\u0006\u0004\bd\u0010eJ\u0017\u0010f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\bf\u0010\u0013J\u0017\u0010i\u001a\u00020(2\u0006\u0010h\u001a\u00020gH\u0017¢\u0006\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010m\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010o\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010r\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010t\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010v\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010uR\u0014\u0010x\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010z\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0014\u0010|\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u0019\u0010\u007f\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0081\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0080\u0001R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0080\u0001R\u001b\u0010\u0083\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0080\u0001R\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0080\u0001R\u001a\u0010\u0085\u0001\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010nR\u0018\u0010\u0087\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0017\u0010\u0089\u0001\u001a\u0002008\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0016\u0010\u008b\u0001\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010}R\u0019\u0010\u008c\u0001\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0019\u0010\u008e\u0001\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008d\u0001R\u0018\u0010\u008f\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010lR\u0018\u0010\u0090\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010lR\u0018\u0010\u0091\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010lR\u0018\u0010\u0092\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010lR\u0018\u0010\u0093\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010lR\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R)\u0010\u0098\u0001\u001a\u00020(2\u0007\u0010\u0097\u0001\u001a\u00020(8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\b\u0098\u0001\u0010u\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0019\u0010\u009a\u0001\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u008d\u0001R\u0019\u0010\u009b\u0001\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u008d\u0001R\u0018\u0010\u009c\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010lR,\u0010N\u001a\u0004\u0018\u00010M2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010M8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\bN\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R,\u00109\u001a\u0004\u0018\u0001082\t\u0010\u0097\u0001\u001a\u0004\u0018\u0001088\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\b9\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R.\u0010£\u0001\u001a\u0004\u0018\u00010<2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010<8\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001R\u0018\u0010§\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b§\u0001\u0010uR\u0019\u0010¨\u0001\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0018\u0010ª\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bª\u0001\u0010lR\u0019\u0010«\u0001\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010\u008d\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030¬\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u0018\u0010¯\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¯\u0001\u0010uR\u0016\u0010°\u0001\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b°\u0001\u0010lR\u0017\u0010±\u0001\u001a\u00020(8BX\u0082\u0004¢\u0006\b\u001a\u0006\b±\u0001\u0010\u0099\u0001R(\u0010µ\u0001\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b²\u0001\u0010³\u0001\"\u0005\b´\u0001\u0010\u000eR)\u0010¶\u0001\u001a\u0002022\u0007\u0010¶\u0001\u001a\u0002028F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0005\b¹\u0001\u0010LR)\u0010º\u0001\u001a\u0002022\u0007\u0010º\u0001\u001a\u0002028F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b»\u0001\u0010¸\u0001\"\u0005\b¼\u0001\u0010LR/\u0010Á\u0001\u001a\u0005\u0018\u00010¬\u00012\t\u0010\f\u001a\u0005\u0018\u00010¬\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001¨\u0006Å\u0001"}, d2 = {"Lcom/canhub/cropper/CropOverlayView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "initCropWindow", "()V", "Landroid/graphics/RectF;", "rect", "fixCropWindowRectByRules", "(Landroid/graphics/RectF;)V", "setSystemGestureExclusionRects", "Landroid/graphics/Canvas;", "canvas", "drawCropLabelText", "(Landroid/graphics/Canvas;)V", "drawBackground", "drawGuidelines", "drawBorders", "drawCorners", "", "cornerOffset", "cornerExtension", "drawCornerBasedOnShape", "(Landroid/graphics/Canvas;Landroid/graphics/RectF;FF)V", "drawLineShape", "radius", "drawCornerShape", "(Landroid/graphics/Canvas;Landroid/graphics/RectF;FFF)V", "drawCircleShape", "x", "y", "onActionDown", "(FF)V", "onActionUp", "onActionMove", "", "calculateBounds", "(Landroid/graphics/RectF;)Z", "Lcom/canhub/cropper/CropOverlayView$CropWindowChangeListener;", "listener", "setCropWindowChangeListener", "(Lcom/canhub/cropper/CropOverlayView$CropWindowChangeListener;)V", "fixCurrentCropWindowRect", "", "boundsPoints", "", "viewWidth", "viewHeight", "setBounds", "([FII)V", "resetCropOverlayView", "Lcom/canhub/cropper/CropImageView$CropShape;", "cropShape", "setCropShape", "(Lcom/canhub/cropper/CropImageView$CropShape;)V", "Lcom/canhub/cropper/CropImageView$CropCornerShape;", "cropCornerShape", "setCropCornerShape", "(Lcom/canhub/cropper/CropImageView$CropCornerShape;)V", "isEnabled", "setCropperTextLabelVisibility", "(Z)V", "", "textLabel", "setCropLabelText", "(Ljava/lang/String;)V", "textSize", "setCropLabelTextSize", "(F)V", "textColor", "setCropLabelTextColor", "(I)V", "Lcom/canhub/cropper/CropImageView$Guidelines;", "guidelines", "setGuidelines", "(Lcom/canhub/cropper/CropImageView$Guidelines;)V", "fixAspectRatio", "setFixedAspectRatio", "snapRadius", "setSnapRadius", "cornerRadius", "setCropCornerRadius", "multiTouchEnabled", "setMultiTouchEnabled", "(Z)Z", "centerMoveEnabled", "setCenterMoveEnabled", "maxWidth", "maxHeight", "scaleFactorWidth", "scaleFactorHeight", "setCropWindowLimits", "(FFFF)V", "Lcom/canhub/cropper/CropImageOptions;", "options", "setInitialAttributeValues", "(Lcom/canhub/cropper/CropImageOptions;)V", "onDraw", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "mCropCornerRadius", "F", "mCircleCornerFillColor", "Ljava/lang/Integer;", "mOptions", "Lcom/canhub/cropper/CropImageOptions;", "Landroid/view/ScaleGestureDetector;", "mScaleDetector", "Landroid/view/ScaleGestureDetector;", "mMultiTouchEnabled", "Z", "mCenterMoveEnabled", "Lcom/canhub/cropper/CropWindowHandler;", "mCropWindowHandler", "Lcom/canhub/cropper/CropWindowHandler;", "mCropWindowChangeListener", "Lcom/canhub/cropper/CropOverlayView$CropWindowChangeListener;", "mDrawRect", "Landroid/graphics/RectF;", "Landroid/graphics/Paint;", "mBorderPaint", "Landroid/graphics/Paint;", "mBorderCornerPaint", "mGuidelinePaint", "mBackgroundPaint", "textLabelPaint", "currentPointerId", "Landroid/graphics/Path;", "mPath", "Landroid/graphics/Path;", "mBoundsPoints", "[F", "mCalcBounds", "mViewWidth", "I", "mViewHeight", "mBorderCornerOffset", "mBorderCornerLength", "mInitialCropWindowPaddingRatio", "mTouchRadius", "mSnapRadius", "Lcom/canhub/cropper/CropWindowMoveHandler;", "mMoveHandler", "Lcom/canhub/cropper/CropWindowMoveHandler;", "value", "isFixAspectRatio", "()Z", "mAspectRatioX", "mAspectRatioY", "mTargetAspectRatio", "Lcom/canhub/cropper/CropImageView$Guidelines;", "getGuidelines", "()Lcom/canhub/cropper/CropImageView$Guidelines;", "Lcom/canhub/cropper/CropImageView$CropShape;", "getCropShape", "()Lcom/canhub/cropper/CropImageView$CropShape;", "cornerShape", "Lcom/canhub/cropper/CropImageView$CropCornerShape;", "getCornerShape", "()Lcom/canhub/cropper/CropImageView$CropCornerShape;", "isCropLabelEnabled", "cropLabelText", "Ljava/lang/String;", "cropLabelTextSize", "cropLabelTextColor", "Landroid/graphics/Rect;", "mInitialCropWindowRect", "Landroid/graphics/Rect;", "initializedCropWindow", "maxVerticalGestureExclusion", "isNonStraightAngleRotated", "getCropWindowRect", "()Landroid/graphics/RectF;", "setCropWindowRect", "cropWindowRect", "aspectRatioX", "getAspectRatioX", "()I", "setAspectRatioX", "aspectRatioY", "getAspectRatioY", "setAspectRatioY", "getInitialCropWindowRect", "()Landroid/graphics/Rect;", "setInitialCropWindowRect", "(Landroid/graphics/Rect;)V", "initialCropWindowRect", "Companion", "CropWindowChangeListener", "ScaleListener", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CropOverlayView extends View {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CropImageView.CropCornerShape cornerShape;
    private String cropLabelText;
    private int cropLabelTextColor;
    private float cropLabelTextSize;
    private CropImageView.CropShape cropShape;
    private Integer currentPointerId;
    private CropImageView.Guidelines guidelines;
    private boolean initializedCropWindow;
    private boolean isCropLabelEnabled;
    private boolean isFixAspectRatio;
    private int mAspectRatioX;
    private int mAspectRatioY;
    private Paint mBackgroundPaint;
    private float mBorderCornerLength;
    private float mBorderCornerOffset;
    private Paint mBorderCornerPaint;
    private Paint mBorderPaint;
    private final float[] mBoundsPoints;
    private final RectF mCalcBounds;
    private boolean mCenterMoveEnabled;
    private Integer mCircleCornerFillColor;
    private float mCropCornerRadius;
    private CropWindowChangeListener mCropWindowChangeListener;
    private final CropWindowHandler mCropWindowHandler;
    private final RectF mDrawRect;
    private Paint mGuidelinePaint;
    private float mInitialCropWindowPaddingRatio;
    private final Rect mInitialCropWindowRect;
    private CropWindowMoveHandler mMoveHandler;
    private boolean mMultiTouchEnabled;
    private CropImageOptions mOptions;
    private final Path mPath;
    private ScaleGestureDetector mScaleDetector;
    private float mSnapRadius;
    private float mTargetAspectRatio;
    private float mTouchRadius;
    private int mViewHeight;
    private int mViewWidth;
    private final float maxVerticalGestureExclusion;
    private Paint textLabelPaint;

    public interface CropWindowChangeListener {
        void onCropWindowChanged(boolean z);
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CropImageView.CropShape.values().length];
            try {
                iArr[CropImageView.CropShape.RECTANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CropImageView.CropShape.RECTANGLE_VERTICAL_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CropImageView.CropShape.RECTANGLE_HORIZONTAL_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CropImageView.CropShape.OVAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CropImageView.CropCornerShape.values().length];
            try {
                iArr2[CropImageView.CropCornerShape.OVAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CropImageView.CropCornerShape.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getTextPaint$cropper_release(CropImageOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            Paint paint = new Paint();
            paint.setStrokeWidth(1.0f);
            paint.setTextSize(options.cropperLabelTextSize);
            paint.setStyle(Paint.Style.FILL);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(options.cropperLabelTextColor);
            return paint;
        }

        public final Paint getNewPaint$cropper_release(int i) {
            Paint paint = new Paint();
            paint.setColor(i);
            return paint;
        }

        public final Paint getNewPaintOrNull$cropper_release(float f, int i) {
            if (f <= 0.0f) {
                return null;
            }
            Paint paint = new Paint();
            paint.setColor(i);
            paint.setStrokeWidth(f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            return paint;
        }

        public final Paint getNewPaintWithFill$cropper_release(int i) {
            Paint paint = new Paint();
            paint.setColor(i);
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            return paint;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCenterMoveEnabled = true;
        this.mCropWindowHandler = new CropWindowHandler();
        this.mDrawRect = new RectF();
        this.mPath = new Path();
        this.mBoundsPoints = new float[8];
        this.mCalcBounds = new RectF();
        this.mTargetAspectRatio = this.mAspectRatioX / this.mAspectRatioY;
        this.cropLabelText = "";
        this.cropLabelTextSize = 20.0f;
        this.cropLabelTextColor = -1;
        this.mInitialCropWindowRect = new Rect();
        this.maxVerticalGestureExclusion = TypedValue.applyDimension(1, 200.0f, Resources.getSystem().getDisplayMetrics());
    }

    /* JADX INFO: renamed from: isFixAspectRatio, reason: from getter */
    public final boolean getIsFixAspectRatio() {
        return this.isFixAspectRatio;
    }

    public final CropImageView.Guidelines getGuidelines() {
        return this.guidelines;
    }

    public final CropImageView.CropShape getCropShape() {
        return this.cropShape;
    }

    public final CropImageView.CropCornerShape getCornerShape() {
        return this.cornerShape;
    }

    public final void setCropWindowChangeListener(CropWindowChangeListener listener) {
        this.mCropWindowChangeListener = listener;
    }

    public final RectF getCropWindowRect() {
        return this.mCropWindowHandler.getRect();
    }

    public final void setCropWindowRect(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.mCropWindowHandler.setRect(rect);
    }

    public final void fixCurrentCropWindowRect() {
        RectF cropWindowRect = getCropWindowRect();
        fixCropWindowRectByRules(cropWindowRect);
        this.mCropWindowHandler.setRect(cropWindowRect);
    }

    public final void setBounds(float[] boundsPoints, int viewWidth, int viewHeight) {
        if (boundsPoints == null || !Arrays.equals(this.mBoundsPoints, boundsPoints)) {
            if (boundsPoints == null) {
                Arrays.fill(this.mBoundsPoints, 0.0f);
            } else {
                System.arraycopy(boundsPoints, 0, this.mBoundsPoints, 0, boundsPoints.length);
            }
            this.mViewWidth = viewWidth;
            this.mViewHeight = viewHeight;
            RectF rect = this.mCropWindowHandler.getRect();
            if (rect.width() == 0.0f || rect.height() == 0.0f) {
                initCropWindow();
            }
        }
    }

    public final void resetCropOverlayView() {
        if (this.initializedCropWindow) {
            setCropWindowRect(BitmapUtils.INSTANCE.getEMPTY_RECT_F());
            initCropWindow();
            invalidate();
        }
    }

    public final void setCropShape(CropImageView.CropShape cropShape) {
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        if (this.cropShape != cropShape) {
            this.cropShape = cropShape;
            invalidate();
        }
    }

    public final void setCropCornerShape(CropImageView.CropCornerShape cropCornerShape) {
        Intrinsics.checkNotNullParameter(cropCornerShape, "cropCornerShape");
        if (this.cornerShape != cropCornerShape) {
            this.cornerShape = cropCornerShape;
            invalidate();
        }
    }

    public final void setCropperTextLabelVisibility(boolean isEnabled) {
        this.isCropLabelEnabled = isEnabled;
        invalidate();
    }

    public final void setCropLabelText(String textLabel) {
        if (textLabel != null) {
            this.cropLabelText = textLabel;
        }
    }

    public final void setCropLabelTextSize(float textSize) {
        this.cropLabelTextSize = textSize;
        invalidate();
    }

    public final void setCropLabelTextColor(int textColor) {
        this.cropLabelTextColor = textColor;
        invalidate();
    }

    public final void setGuidelines(CropImageView.Guidelines guidelines) {
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        if (this.guidelines != guidelines) {
            this.guidelines = guidelines;
            if (this.initializedCropWindow) {
                invalidate();
            }
        }
    }

    public final void setFixedAspectRatio(boolean fixAspectRatio) {
        if (this.isFixAspectRatio != fixAspectRatio) {
            this.isFixAspectRatio = fixAspectRatio;
            if (this.initializedCropWindow) {
                initCropWindow();
                invalidate();
            }
        }
    }

    /* JADX INFO: renamed from: getAspectRatioX, reason: from getter */
    public final int getMAspectRatioX() {
        return this.mAspectRatioX;
    }

    public final void setAspectRatioX(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.mAspectRatioX != i) {
            this.mAspectRatioX = i;
            this.mTargetAspectRatio = i / this.mAspectRatioY;
            if (this.initializedCropWindow) {
                initCropWindow();
                invalidate();
            }
        }
    }

    /* JADX INFO: renamed from: getAspectRatioY, reason: from getter */
    public final int getMAspectRatioY() {
        return this.mAspectRatioY;
    }

    public final void setAspectRatioY(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.mAspectRatioY != i) {
            this.mAspectRatioY = i;
            this.mTargetAspectRatio = this.mAspectRatioX / i;
            if (this.initializedCropWindow) {
                initCropWindow();
                invalidate();
            }
        }
    }

    public final void setSnapRadius(float snapRadius) {
        this.mSnapRadius = snapRadius;
    }

    public final void setCropCornerRadius(float cornerRadius) {
        this.mCropCornerRadius = cornerRadius;
    }

    public final boolean setMultiTouchEnabled(boolean multiTouchEnabled) {
        if (this.mMultiTouchEnabled == multiTouchEnabled) {
            return false;
        }
        this.mMultiTouchEnabled = multiTouchEnabled;
        if (!multiTouchEnabled || this.mScaleDetector != null) {
            return true;
        }
        this.mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        return true;
    }

    public final boolean setCenterMoveEnabled(boolean centerMoveEnabled) {
        if (this.mCenterMoveEnabled == centerMoveEnabled) {
            return false;
        }
        this.mCenterMoveEnabled = centerMoveEnabled;
        return true;
    }

    public final void setCropWindowLimits(float maxWidth, float maxHeight, float scaleFactorWidth, float scaleFactorHeight) {
        this.mCropWindowHandler.setCropWindowLimits(maxWidth, maxHeight, scaleFactorWidth, scaleFactorHeight);
    }

    /* JADX INFO: renamed from: getInitialCropWindowRect, reason: from getter */
    public final Rect getMInitialCropWindowRect() {
        return this.mInitialCropWindowRect;
    }

    public final void setInitialCropWindowRect(Rect rect) {
        Rect rect2 = this.mInitialCropWindowRect;
        if (rect == null) {
            rect = BitmapUtils.INSTANCE.getEMPTY_RECT();
        }
        rect2.set(rect);
        if (this.initializedCropWindow) {
            initCropWindow();
            invalidate();
            CropWindowChangeListener cropWindowChangeListener = this.mCropWindowChangeListener;
            if (cropWindowChangeListener != null) {
                cropWindowChangeListener.onCropWindowChanged(false);
            }
        }
    }

    public final void setInitialAttributeValues(CropImageOptions options) {
        CropWindowChangeListener cropWindowChangeListener;
        Intrinsics.checkNotNullParameter(options, "options");
        boolean zAreEqual = Intrinsics.areEqual(this.mOptions, options);
        CropImageOptions cropImageOptions = this.mOptions;
        boolean z = cropImageOptions == null || options.fixAspectRatio != cropImageOptions.fixAspectRatio || cropImageOptions == null || options.aspectRatioX != cropImageOptions.aspectRatioX || cropImageOptions == null || options.aspectRatioY != cropImageOptions.aspectRatioY;
        this.mOptions = options;
        this.mCropWindowHandler.setMinCropResultSize(options.minCropResultWidth, options.minCropResultHeight);
        this.mCropWindowHandler.setMaxCropResultSize(options.maxCropResultWidth, options.maxCropResultHeight);
        if (zAreEqual) {
            return;
        }
        this.mCropWindowHandler.setInitialAttributeValues(options);
        this.cropLabelTextColor = options.cropperLabelTextColor;
        this.cropLabelTextSize = options.cropperLabelTextSize;
        String str = options.cropperLabelText;
        if (str == null) {
            str = "";
        }
        this.cropLabelText = str;
        this.isCropLabelEnabled = options.showCropLabel;
        this.mCropCornerRadius = options.cropCornerRadius;
        this.cornerShape = options.cornerShape;
        this.cropShape = options.cropShape;
        this.mSnapRadius = options.snapRadius;
        setEnabled(options.canChangeCropWindow);
        this.guidelines = options.guidelines;
        this.isFixAspectRatio = options.fixAspectRatio;
        setAspectRatioX(options.aspectRatioX);
        setAspectRatioY(options.aspectRatioY);
        boolean z2 = options.multiTouchEnabled;
        this.mMultiTouchEnabled = z2;
        if (z2 && this.mScaleDetector == null) {
            this.mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        }
        this.mCenterMoveEnabled = options.centerMoveEnabled;
        this.mTouchRadius = options.touchRadius;
        this.mInitialCropWindowPaddingRatio = options.initialCropWindowPaddingRatio;
        Companion companion = INSTANCE;
        this.mBorderPaint = companion.getNewPaintOrNull$cropper_release(options.borderLineThickness, options.borderLineColor);
        this.mBorderCornerOffset = options.borderCornerOffset;
        this.mBorderCornerLength = options.borderCornerLength;
        this.mCircleCornerFillColor = Integer.valueOf(options.circleCornerFillColorHexValue);
        this.mBorderCornerPaint = companion.getNewPaintOrNull$cropper_release(options.borderCornerThickness, options.borderCornerColor);
        this.mGuidelinePaint = companion.getNewPaintOrNull$cropper_release(options.guidelinesThickness, options.guidelinesColor);
        this.mBackgroundPaint = companion.getNewPaint$cropper_release(options.backgroundColor);
        this.textLabelPaint = companion.getTextPaint$cropper_release(options);
        if (z) {
            initCropWindow();
        }
        invalidate();
        if (!z || (cropWindowChangeListener = this.mCropWindowChangeListener) == null) {
            return;
        }
        cropWindowChangeListener.onCropWindowChanged(false);
    }

    private final void initCropWindow() {
        BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
        float fMax = Math.max(bitmapUtils.getRectLeft(this.mBoundsPoints), 0.0f);
        float fMax2 = Math.max(bitmapUtils.getRectTop(this.mBoundsPoints), 0.0f);
        float fMin = Math.min(bitmapUtils.getRectRight(this.mBoundsPoints), getWidth());
        float fMin2 = Math.min(bitmapUtils.getRectBottom(this.mBoundsPoints), getHeight());
        if (fMin <= fMax || fMin2 <= fMax2) {
            return;
        }
        RectF rectF = new RectF();
        this.initializedCropWindow = true;
        float f = this.mInitialCropWindowPaddingRatio;
        float f2 = fMin - fMax;
        float f3 = f * f2;
        float f4 = fMin2 - fMax2;
        float f5 = f * f4;
        if (this.mInitialCropWindowRect.width() > 0 && this.mInitialCropWindowRect.height() > 0) {
            rectF.left = (this.mInitialCropWindowRect.left / this.mCropWindowHandler.getScaleFactorWidth()) + fMax;
            rectF.top = (this.mInitialCropWindowRect.top / this.mCropWindowHandler.getScaleFactorHeight()) + fMax2;
            rectF.right = rectF.left + (this.mInitialCropWindowRect.width() / this.mCropWindowHandler.getScaleFactorWidth());
            rectF.bottom = rectF.top + (this.mInitialCropWindowRect.height() / this.mCropWindowHandler.getScaleFactorHeight());
            rectF.left = Math.max(fMax, rectF.left);
            rectF.top = Math.max(fMax2, rectF.top);
            rectF.right = Math.min(fMin, rectF.right);
            rectF.bottom = Math.min(fMin2, rectF.bottom);
        } else if (!this.isFixAspectRatio || fMin <= fMax || fMin2 <= fMax2) {
            rectF.left = fMax + f3;
            rectF.top = fMax2 + f5;
            rectF.right = fMin - f3;
            rectF.bottom = fMin2 - f5;
        } else if (f2 / f4 > this.mTargetAspectRatio) {
            rectF.top = fMax2 + f5;
            rectF.bottom = fMin2 - f5;
            float width = getWidth() / 2.0f;
            this.mTargetAspectRatio = this.mAspectRatioX / this.mAspectRatioY;
            float fMax3 = Math.max(this.mCropWindowHandler.getMinCropWidth(), rectF.height() * this.mTargetAspectRatio) / 2.0f;
            rectF.left = width - fMax3;
            rectF.right = width + fMax3;
        } else {
            rectF.left = fMax + f3;
            rectF.right = fMin - f3;
            float height = getHeight() / 2.0f;
            float fMax4 = Math.max(this.mCropWindowHandler.getMinCropHeight(), rectF.width() / this.mTargetAspectRatio) / 2.0f;
            rectF.top = height - fMax4;
            rectF.bottom = height + fMax4;
        }
        fixCropWindowRectByRules(rectF);
        this.mCropWindowHandler.setRect(rectF);
    }

    private final void fixCropWindowRectByRules(RectF rect) {
        if (rect.width() < this.mCropWindowHandler.getMinCropWidth()) {
            float minCropWidth = (this.mCropWindowHandler.getMinCropWidth() - rect.width()) / 2;
            rect.left -= minCropWidth;
            rect.right += minCropWidth;
        }
        if (rect.height() < this.mCropWindowHandler.getMinCropHeight()) {
            float minCropHeight = (this.mCropWindowHandler.getMinCropHeight() - rect.height()) / 2;
            rect.top -= minCropHeight;
            rect.bottom += minCropHeight;
        }
        if (rect.width() > this.mCropWindowHandler.getMaxCropWidth()) {
            float fWidth = (rect.width() - this.mCropWindowHandler.getMaxCropWidth()) / 2;
            rect.left += fWidth;
            rect.right -= fWidth;
        }
        if (rect.height() > this.mCropWindowHandler.getMaxCropHeight()) {
            float fHeight = (rect.height() - this.mCropWindowHandler.getMaxCropHeight()) / 2;
            rect.top += fHeight;
            rect.bottom -= fHeight;
        }
        calculateBounds(rect);
        if (this.mCalcBounds.width() > 0.0f && this.mCalcBounds.height() > 0.0f) {
            float fMax = Math.max(this.mCalcBounds.left, 0.0f);
            float fMax2 = Math.max(this.mCalcBounds.top, 0.0f);
            float fMin = Math.min(this.mCalcBounds.right, getWidth());
            float fMin2 = Math.min(this.mCalcBounds.bottom, getHeight());
            if (rect.left < fMax) {
                rect.left = fMax;
            }
            if (rect.top < fMax2) {
                rect.top = fMax2;
            }
            if (rect.right > fMin) {
                rect.right = fMin;
            }
            if (rect.bottom > fMin2) {
                rect.bottom = fMin2;
            }
        }
        if (!this.isFixAspectRatio || Math.abs(rect.width() - (rect.height() * this.mTargetAspectRatio)) <= 0.1d) {
            return;
        }
        if (rect.width() > rect.height() * this.mTargetAspectRatio) {
            float fAbs = Math.abs((rect.height() * this.mTargetAspectRatio) - rect.width()) / 2;
            rect.left += fAbs;
            rect.right -= fAbs;
        } else {
            float fAbs2 = Math.abs((rect.width() / this.mTargetAspectRatio) - rect.height()) / 2;
            rect.top += fAbs2;
            rect.bottom -= fAbs2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawBackground(canvas);
        if (this.mCropWindowHandler.showGuidelines()) {
            CropImageView.Guidelines guidelines = this.guidelines;
            if (guidelines == CropImageView.Guidelines.ON) {
                drawGuidelines(canvas);
            } else if (guidelines == CropImageView.Guidelines.ON_TOUCH && this.mMoveHandler != null) {
                drawGuidelines(canvas);
            }
        }
        Companion companion = INSTANCE;
        CropImageOptions cropImageOptions = this.mOptions;
        this.mBorderCornerPaint = companion.getNewPaintOrNull$cropper_release(cropImageOptions != null ? cropImageOptions.borderCornerThickness : 0.0f, cropImageOptions != null ? cropImageOptions.borderCornerColor : -1);
        drawCropLabelText(canvas);
        drawBorders(canvas);
        drawCorners(canvas);
        if (Build.VERSION.SDK_INT >= 29) {
            setSystemGestureExclusionRects();
        }
    }

    private final void setSystemGestureExclusionRects() {
        RectF rect = this.mCropWindowHandler.getRect();
        List<Rect> systemGestureExclusionRects = getSystemGestureExclusionRects();
        Intrinsics.checkNotNullExpressionValue(systemGestureExclusionRects, "getSystemGestureExclusionRects(...)");
        Rect rect2 = systemGestureExclusionRects.size() > 0 ? systemGestureExclusionRects.get(0) : new Rect();
        List<Rect> systemGestureExclusionRects2 = getSystemGestureExclusionRects();
        Intrinsics.checkNotNullExpressionValue(systemGestureExclusionRects2, "getSystemGestureExclusionRects(...)");
        Rect rect3 = 1 < systemGestureExclusionRects2.size() ? systemGestureExclusionRects2.get(1) : new Rect();
        List<Rect> systemGestureExclusionRects3 = getSystemGestureExclusionRects();
        Intrinsics.checkNotNullExpressionValue(systemGestureExclusionRects3, "getSystemGestureExclusionRects(...)");
        Rect rect4 = 2 < systemGestureExclusionRects3.size() ? systemGestureExclusionRects3.get(2) : new Rect();
        float f = rect.left;
        float f2 = this.mTouchRadius;
        int i = (int) (f - f2);
        rect2.left = i;
        int i2 = (int) (rect.right + f2);
        rect2.right = i2;
        float f3 = rect.top;
        int i3 = (int) (f3 - f2);
        rect2.top = i3;
        float f4 = this.maxVerticalGestureExclusion;
        rect2.bottom = (int) (i3 + (f4 * 0.3f));
        rect3.left = i;
        rect3.right = i2;
        float f5 = rect.bottom;
        int i4 = (int) (((f3 + f5) / 2.0f) - (0.2f * f4));
        rect3.top = i4;
        rect3.bottom = (int) (i4 + (0.4f * f4));
        rect4.left = rect2.left;
        rect4.right = rect2.right;
        int i5 = (int) (f5 + f2);
        rect4.bottom = i5;
        rect4.top = (int) (i5 - (f4 * 0.3f));
        setSystemGestureExclusionRects(CollectionsKt.listOf((Object[]) new Rect[]{rect2, rect3, rect4}));
    }

    private final void drawCropLabelText(Canvas canvas) {
        if (this.isCropLabelEnabled) {
            RectF rect = this.mCropWindowHandler.getRect();
            float f = (rect.left + rect.right) / 2;
            float f2 = rect.top - 50;
            Paint paint = this.textLabelPaint;
            if (paint != null) {
                paint.setTextSize(this.cropLabelTextSize);
                paint.setColor(this.cropLabelTextColor);
            }
            String str = this.cropLabelText;
            Paint paint2 = this.textLabelPaint;
            Intrinsics.checkNotNull(paint2);
            canvas.drawText(str, f, f2, paint2);
            canvas.save();
        }
    }

    private final void drawBackground(Canvas canvas) {
        RectF rect = this.mCropWindowHandler.getRect();
        BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
        float fMax = Math.max(bitmapUtils.getRectLeft(this.mBoundsPoints), 0.0f);
        float fMax2 = Math.max(bitmapUtils.getRectTop(this.mBoundsPoints), 0.0f);
        float fMin = Math.min(bitmapUtils.getRectRight(this.mBoundsPoints), getWidth());
        float fMin2 = Math.min(bitmapUtils.getRectBottom(this.mBoundsPoints), getHeight());
        CropImageView.CropShape cropShape = this.cropShape;
        int i = cropShape == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cropShape.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i == 4) {
                this.mPath.reset();
                this.mDrawRect.set(rect.left, rect.top, rect.right, rect.bottom);
                this.mPath.addOval(this.mDrawRect, Path.Direction.CW);
                canvas.save();
                if (Build.VERSION.SDK_INT >= 26) {
                    canvas.clipOutPath(this.mPath);
                } else {
                    canvas.clipPath(this.mPath, Region.Op.XOR);
                }
                Paint paint = this.mBackgroundPaint;
                Intrinsics.checkNotNull(paint);
                canvas.drawRect(fMax, fMax2, fMin, fMin2, paint);
                canvas.restore();
                return;
            }
            throw new IllegalStateException("Unrecognized crop shape");
        }
        if (!isNonStraightAngleRotated()) {
            float f = rect.top;
            Paint paint2 = this.mBackgroundPaint;
            Intrinsics.checkNotNull(paint2);
            canvas.drawRect(fMax, fMax2, fMin, f, paint2);
            float f2 = rect.bottom;
            Paint paint3 = this.mBackgroundPaint;
            Intrinsics.checkNotNull(paint3);
            canvas.drawRect(fMax, f2, fMin, fMin2, paint3);
            float f3 = rect.top;
            float f4 = rect.left;
            float f5 = rect.bottom;
            Paint paint4 = this.mBackgroundPaint;
            Intrinsics.checkNotNull(paint4);
            canvas.drawRect(fMax, f3, f4, f5, paint4);
            float f6 = rect.right;
            float f7 = rect.top;
            float f8 = rect.bottom;
            Paint paint5 = this.mBackgroundPaint;
            Intrinsics.checkNotNull(paint5);
            canvas.drawRect(f6, f7, fMin, f8, paint5);
            return;
        }
        this.mPath.reset();
        Path path = this.mPath;
        float[] fArr = this.mBoundsPoints;
        path.moveTo(fArr[0], fArr[1]);
        Path path2 = this.mPath;
        float[] fArr2 = this.mBoundsPoints;
        path2.lineTo(fArr2[2], fArr2[3]);
        Path path3 = this.mPath;
        float[] fArr3 = this.mBoundsPoints;
        path3.lineTo(fArr3[4], fArr3[5]);
        Path path4 = this.mPath;
        float[] fArr4 = this.mBoundsPoints;
        path4.lineTo(fArr4[6], fArr4[7]);
        this.mPath.close();
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutPath(this.mPath);
        } else {
            canvas.clipPath(this.mPath, Region.Op.INTERSECT);
        }
        Paint paint6 = this.mBackgroundPaint;
        Intrinsics.checkNotNull(paint6);
        canvas.drawRect(fMax, fMax2, fMin, fMin2, paint6);
        canvas.restore();
    }

    private final void drawGuidelines(Canvas canvas) {
        float strokeWidth;
        if (this.mGuidelinePaint != null) {
            Paint paint = this.mBorderPaint;
            if (paint != null) {
                Intrinsics.checkNotNull(paint);
                strokeWidth = paint.getStrokeWidth();
            } else {
                strokeWidth = 0.0f;
            }
            RectF rect = this.mCropWindowHandler.getRect();
            rect.inset(strokeWidth, strokeWidth);
            float f = 3;
            float fWidth = rect.width() / f;
            float fHeight = rect.height() / f;
            CropImageView.CropShape cropShape = this.cropShape;
            int i = cropShape == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cropShape.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                float f2 = rect.left + fWidth;
                float f3 = rect.right - fWidth;
                float f4 = rect.top;
                float f5 = rect.bottom;
                Paint paint2 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint2);
                canvas.drawLine(f2, f4, f2, f5, paint2);
                float f6 = rect.top;
                float f7 = rect.bottom;
                Paint paint3 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint3);
                canvas.drawLine(f3, f6, f3, f7, paint3);
                float f8 = rect.top + fHeight;
                float f9 = rect.bottom - fHeight;
                float f10 = rect.left;
                float f11 = rect.right;
                Paint paint4 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint4);
                canvas.drawLine(f10, f8, f11, f8, paint4);
                float f12 = rect.left;
                float f13 = rect.right;
                Paint paint5 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint5);
                canvas.drawLine(f12, f9, f13, f9, paint5);
                return;
            }
            if (i == 4) {
                float f14 = 2;
                float fWidth2 = (rect.width() / f14) - strokeWidth;
                float fHeight2 = (rect.height() / f14) - strokeWidth;
                float f15 = rect.left + fWidth;
                float f16 = rect.right - fWidth;
                float fSin = (float) (((double) fHeight2) * Math.sin(Math.acos((fWidth2 - fWidth) / fWidth2)));
                float f17 = (rect.top + fHeight2) - fSin;
                float f18 = (rect.bottom - fHeight2) + fSin;
                Paint paint6 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint6);
                canvas.drawLine(f15, f17, f15, f18, paint6);
                float f19 = (rect.top + fHeight2) - fSin;
                float f20 = (rect.bottom - fHeight2) + fSin;
                Paint paint7 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint7);
                canvas.drawLine(f16, f19, f16, f20, paint7);
                float f21 = rect.top + fHeight;
                float f22 = rect.bottom - fHeight;
                float fCos = (float) (((double) fWidth2) * Math.cos(Math.asin((fHeight2 - fHeight) / fHeight2)));
                float f23 = (rect.left + fWidth2) - fCos;
                float f24 = (rect.right - fWidth2) + fCos;
                Paint paint8 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint8);
                canvas.drawLine(f23, f21, f24, f21, paint8);
                float f25 = (rect.left + fWidth2) - fCos;
                float f26 = (rect.right - fWidth2) + fCos;
                Paint paint9 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint9);
                canvas.drawLine(f25, f22, f26, f22, paint9);
                return;
            }
            throw new IllegalStateException("Unrecognized crop shape");
        }
    }

    private final void drawBorders(Canvas canvas) {
        Paint paint = this.mBorderPaint;
        if (paint != null) {
            Intrinsics.checkNotNull(paint);
            float strokeWidth = paint.getStrokeWidth();
            RectF rect = this.mCropWindowHandler.getRect();
            float f = strokeWidth / 2;
            rect.inset(f, f);
            CropImageView.CropShape cropShape = this.cropShape;
            int i = cropShape == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cropShape.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                Paint paint2 = this.mBorderPaint;
                Intrinsics.checkNotNull(paint2);
                canvas.drawRect(rect, paint2);
            } else {
                if (i == 4) {
                    Paint paint3 = this.mBorderPaint;
                    Intrinsics.checkNotNull(paint3);
                    canvas.drawOval(rect, paint3);
                    return;
                }
                throw new IllegalStateException("Unrecognized crop shape");
            }
        }
    }

    private final void drawCorners(Canvas canvas) {
        float strokeWidth;
        Paint newPaintWithFill$cropper_release;
        if (this.mBorderCornerPaint != null) {
            Paint paint = this.mBorderPaint;
            if (paint != null) {
                Intrinsics.checkNotNull(paint);
                strokeWidth = paint.getStrokeWidth();
            } else {
                strokeWidth = 0.0f;
            }
            Paint paint2 = this.mBorderCornerPaint;
            Intrinsics.checkNotNull(paint2);
            float strokeWidth2 = paint2.getStrokeWidth();
            float f = 2;
            float f2 = (strokeWidth2 - strokeWidth) / f;
            float f3 = strokeWidth2 / f;
            float f4 = f3 + f2;
            CropImageView.CropShape cropShape = this.cropShape;
            int i = cropShape == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cropShape.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                f3 += this.mBorderCornerOffset;
            } else if (i != 4) {
                throw new IllegalStateException("Unrecognized crop shape");
            }
            RectF rect = this.mCropWindowHandler.getRect();
            rect.inset(f3, f3);
            drawCornerBasedOnShape(canvas, rect, f2, f4);
            if (this.cornerShape == CropImageView.CropCornerShape.OVAL) {
                Integer num = this.mCircleCornerFillColor;
                if (num != null) {
                    newPaintWithFill$cropper_release = INSTANCE.getNewPaintWithFill$cropper_release(num.intValue());
                } else {
                    newPaintWithFill$cropper_release = null;
                }
                this.mBorderCornerPaint = newPaintWithFill$cropper_release;
                drawCornerBasedOnShape(canvas, rect, f2, f4);
            }
        }
    }

    private final void drawCornerBasedOnShape(Canvas canvas, RectF rect, float cornerOffset, float cornerExtension) {
        CropImageView.CropShape cropShape = this.cropShape;
        int i = cropShape == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cropShape.ordinal()];
        if (i == 1) {
            drawCornerShape(canvas, rect, cornerOffset, cornerExtension, this.mCropCornerRadius);
            return;
        }
        if (i == 2) {
            float fCenterX = rect.centerX() - this.mBorderCornerLength;
            float f = rect.top - cornerOffset;
            float fCenterX2 = rect.centerX() + this.mBorderCornerLength;
            float f2 = rect.top - cornerOffset;
            Paint paint = this.mBorderCornerPaint;
            Intrinsics.checkNotNull(paint);
            canvas.drawLine(fCenterX, f, fCenterX2, f2, paint);
            float fCenterX3 = rect.centerX() - this.mBorderCornerLength;
            float f3 = rect.bottom + cornerOffset;
            float fCenterX4 = rect.centerX() + this.mBorderCornerLength;
            float f4 = rect.bottom + cornerOffset;
            Paint paint2 = this.mBorderCornerPaint;
            Intrinsics.checkNotNull(paint2);
            canvas.drawLine(fCenterX3, f3, fCenterX4, f4, paint2);
            return;
        }
        if (i != 3) {
            if (i == 4) {
                drawLineShape(canvas, rect, cornerOffset, cornerExtension);
                return;
            }
            throw new IllegalStateException("Unrecognized crop shape");
        }
        float f5 = rect.left - cornerOffset;
        float fCenterY = rect.centerY() - this.mBorderCornerLength;
        float f6 = rect.left - cornerOffset;
        float fCenterY2 = rect.centerY() + this.mBorderCornerLength;
        Paint paint3 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint3);
        canvas.drawLine(f5, fCenterY, f6, fCenterY2, paint3);
        float f7 = rect.right + cornerOffset;
        float fCenterY3 = rect.centerY() - this.mBorderCornerLength;
        float f8 = rect.right + cornerOffset;
        float fCenterY4 = rect.centerY() + this.mBorderCornerLength;
        Paint paint4 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint4);
        canvas.drawLine(f7, fCenterY3, f8, fCenterY4, paint4);
    }

    private final void drawLineShape(Canvas canvas, RectF rect, float cornerOffset, float cornerExtension) {
        float f = rect.left;
        float f2 = rect.top;
        float f3 = f2 + this.mBorderCornerLength;
        Paint paint = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint);
        canvas.drawLine(f - cornerOffset, f2 - cornerExtension, f - cornerOffset, f3, paint);
        float f4 = rect.left;
        float f5 = rect.top;
        Paint paint2 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint2);
        canvas.drawLine(f4 - cornerExtension, f5 - cornerOffset, f4 + this.mBorderCornerLength, f5 - cornerOffset, paint2);
        float f6 = rect.right;
        float f7 = rect.top;
        float f8 = f7 + this.mBorderCornerLength;
        Paint paint3 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint3);
        canvas.drawLine(f6 + cornerOffset, f7 - cornerExtension, f6 + cornerOffset, f8, paint3);
        float f9 = rect.right;
        float f10 = rect.top;
        Paint paint4 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint4);
        canvas.drawLine(f9 + cornerExtension, f10 - cornerOffset, f9 - this.mBorderCornerLength, f10 - cornerOffset, paint4);
        float f11 = rect.left;
        float f12 = rect.bottom;
        float f13 = f12 - this.mBorderCornerLength;
        Paint paint5 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint5);
        canvas.drawLine(f11 - cornerOffset, f12 + cornerExtension, f11 - cornerOffset, f13, paint5);
        float f14 = rect.left;
        float f15 = rect.bottom;
        Paint paint6 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint6);
        canvas.drawLine(f14 - cornerExtension, f15 + cornerOffset, f14 + this.mBorderCornerLength, f15 + cornerOffset, paint6);
        float f16 = rect.right;
        float f17 = rect.bottom;
        float f18 = f17 - this.mBorderCornerLength;
        Paint paint7 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint7);
        canvas.drawLine(f16 + cornerOffset, f17 + cornerExtension, f16 + cornerOffset, f18, paint7);
        float f19 = rect.right;
        float f20 = rect.bottom;
        Paint paint8 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint8);
        canvas.drawLine(f19 + cornerExtension, f20 + cornerOffset, f19 - this.mBorderCornerLength, f20 + cornerOffset, paint8);
    }

    private final void drawCornerShape(Canvas canvas, RectF rect, float cornerOffset, float cornerExtension, float radius) {
        CropImageView.CropCornerShape cropCornerShape = this.cornerShape;
        int i = cropCornerShape == null ? -1 : WhenMappings.$EnumSwitchMapping$1[cropCornerShape.ordinal()];
        if (i != -1) {
            if (i == 1) {
                drawCircleShape(canvas, rect, cornerOffset, radius);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                drawLineShape(canvas, rect, cornerOffset, cornerExtension);
            }
        }
    }

    private final void drawCircleShape(Canvas canvas, RectF rect, float cornerExtension, float radius) {
        float f = rect.left - cornerExtension;
        float f2 = rect.top - cornerExtension;
        Paint paint = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint);
        canvas.drawCircle(f, f2, radius, paint);
        float f3 = rect.right + cornerExtension;
        float f4 = rect.top - cornerExtension;
        Paint paint2 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint2);
        canvas.drawCircle(f3, f4, radius, paint2);
        float f5 = rect.left - cornerExtension;
        float f6 = rect.bottom + cornerExtension;
        Paint paint3 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint3);
        canvas.drawCircle(f5, f6, radius, paint3);
        float f7 = rect.right + cornerExtension;
        float f8 = rect.bottom + cornerExtension;
        Paint paint4 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint4);
        canvas.drawCircle(f7, f8, radius, paint4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        ScaleGestureDetector scaleGestureDetector;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isEnabled()) {
            return false;
        }
        if (this.mMultiTouchEnabled && (scaleGestureDetector = this.mScaleDetector) != null) {
            scaleGestureDetector.onTouchEvent(event);
        }
        int action = event.getAction();
        if (action == 0) {
            this.currentPointerId = Integer.valueOf(event.getPointerId(0));
            onActionDown(event.getX(), event.getY());
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                Integer num = this.currentPointerId;
                int pointerId = event.getPointerId(0);
                if (num == null || num.intValue() != pointerId) {
                    return false;
                }
                onActionMove(event.getX(), event.getY());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            if (action != 3) {
                return false;
            }
        }
        this.currentPointerId = Integer.valueOf(event.getPointerId(0));
        getParent().requestDisallowInterceptTouchEvent(false);
        onActionUp();
        return true;
    }

    private final void onActionDown(float x, float y) {
        CropWindowHandler cropWindowHandler = this.mCropWindowHandler;
        float f = this.mTouchRadius;
        CropImageView.CropShape cropShape = this.cropShape;
        Intrinsics.checkNotNull(cropShape);
        CropWindowMoveHandler moveHandler = cropWindowHandler.getMoveHandler(x, y, f, cropShape, this.mCenterMoveEnabled);
        this.mMoveHandler = moveHandler;
        if (moveHandler != null) {
            invalidate();
        }
    }

    private final void onActionUp() {
        if (this.mMoveHandler != null) {
            this.mMoveHandler = null;
            CropWindowChangeListener cropWindowChangeListener = this.mCropWindowChangeListener;
            if (cropWindowChangeListener != null) {
                cropWindowChangeListener.onCropWindowChanged(false);
            }
            invalidate();
        }
    }

    private final void onActionMove(float x, float y) {
        if (this.mMoveHandler != null) {
            float f = this.mSnapRadius;
            RectF rect = this.mCropWindowHandler.getRect();
            if (calculateBounds(rect)) {
                f = 0.0f;
            }
            CropWindowMoveHandler cropWindowMoveHandler = this.mMoveHandler;
            Intrinsics.checkNotNull(cropWindowMoveHandler);
            cropWindowMoveHandler.move(rect, x, y, this.mCalcBounds, this.mViewWidth, this.mViewHeight, f, this.isFixAspectRatio, this.mTargetAspectRatio);
            this.mCropWindowHandler.setRect(rect);
            CropWindowChangeListener cropWindowChangeListener = this.mCropWindowChangeListener;
            if (cropWindowChangeListener != null) {
                cropWindowChangeListener.onCropWindowChanged(true);
            }
            invalidate();
        }
    }

    private final boolean calculateBounds(RectF rect) {
        float f;
        float f2;
        BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
        float rectLeft = bitmapUtils.getRectLeft(this.mBoundsPoints);
        float rectTop = bitmapUtils.getRectTop(this.mBoundsPoints);
        float rectRight = bitmapUtils.getRectRight(this.mBoundsPoints);
        float rectBottom = bitmapUtils.getRectBottom(this.mBoundsPoints);
        if (!isNonStraightAngleRotated()) {
            this.mCalcBounds.set(rectLeft, rectTop, rectRight, rectBottom);
            return false;
        }
        float[] fArr = this.mBoundsPoints;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        if (f8 < f4) {
            float f9 = fArr[3];
            if (f4 < f9) {
                f5 = fArr[2];
                f3 = f5;
                f4 = f6;
                f2 = f7;
                f6 = f9;
                f = f8;
            } else {
                f3 = fArr[2];
                f2 = f5;
                f5 = f3;
                f6 = f4;
                f4 = f9;
                f = f6;
            }
        } else {
            f = fArr[3];
            if (f4 > f) {
                f2 = fArr[2];
                f5 = f7;
                f6 = f8;
            } else {
                f2 = f3;
                f = f4;
                f3 = f7;
                f4 = f8;
            }
        }
        float f10 = (f4 - f) / (f3 - f2);
        float f11 = (-1.0f) / f10;
        float f12 = f - (f10 * f2);
        float f13 = f - (f2 * f11);
        float f14 = f6 - (f10 * f5);
        float f15 = f6 - (f5 * f11);
        float fCenterY = rect.centerY() - rect.top;
        float fCenterX = rect.centerX();
        float f16 = rect.left;
        float f17 = fCenterY / (fCenterX - f16);
        float f18 = -f17;
        float f19 = rect.top;
        float f20 = f19 - (f16 * f17);
        float f21 = rect.right;
        float f22 = f19 - (f18 * f21);
        float f23 = f10 - f17;
        float f24 = (f20 - f12) / f23;
        float fMax = Math.max(rectLeft, f24 < f21 ? f24 : rectLeft);
        float f25 = (f20 - f13) / (f11 - f17);
        if (f25 >= rect.right) {
            f25 = fMax;
        }
        float fMax2 = Math.max(fMax, f25);
        float f26 = f11 - f18;
        float f27 = (f22 - f15) / f26;
        float fMax3 = Math.max(fMax2, f27 < rect.right ? f27 : fMax2);
        float f28 = (f22 - f13) / f26;
        if (f28 <= rect.left) {
            f28 = rectRight;
        }
        float fMin = Math.min(rectRight, f28);
        float f29 = (f22 - f14) / (f10 - f18);
        if (f29 <= rect.left) {
            f29 = fMin;
        }
        float fMin2 = Math.min(fMin, f29);
        float f30 = (f20 - f14) / f23;
        if (f30 <= rect.left) {
            f30 = fMin2;
        }
        float fMin3 = Math.min(fMin2, f30);
        float fMax4 = Math.max(rectTop, Math.max((f10 * fMax3) + f12, (f11 * fMin3) + f13));
        float fMin4 = Math.min(rectBottom, Math.min((f11 * fMax3) + f15, (f10 * fMin3) + f14));
        RectF rectF = this.mCalcBounds;
        rectF.left = fMax3;
        rectF.top = fMax4;
        rectF.right = fMin3;
        rectF.bottom = fMin4;
        return true;
    }

    private final boolean isNonStraightAngleRotated() {
        float[] fArr = this.mBoundsPoints;
        return (fArr[0] == fArr[6] || fArr[1] == fArr[7]) ? false : true;
    }

    private final class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            RectF rect = CropOverlayView.this.mCropWindowHandler.getRect();
            float focusX = detector.getFocusX();
            float focusY = detector.getFocusY();
            float f = 2;
            float currentSpanY = detector.getCurrentSpanY() / f;
            float currentSpanX = detector.getCurrentSpanX() / f;
            float f2 = focusY - currentSpanY;
            float f3 = focusX - currentSpanX;
            float f4 = focusX + currentSpanX;
            float f5 = focusY + currentSpanY;
            if (f3 >= f4 || f2 > f5 || f3 < 0.0f || f4 > CropOverlayView.this.mCropWindowHandler.getMaxCropWidth() || f2 < 0.0f || f5 > CropOverlayView.this.mCropWindowHandler.getMaxCropHeight()) {
                return true;
            }
            rect.set(f3, f2, f4, f5);
            CropOverlayView.this.mCropWindowHandler.setRect(rect);
            CropOverlayView.this.invalidate();
            return true;
        }
    }
}
