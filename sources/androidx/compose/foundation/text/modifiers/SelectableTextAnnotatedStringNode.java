package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class SelectableTextAnnotatedStringNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, GlobalPositionAwareModifierNode {
    private final TextAnnotatedStringNode delegate;
    private Function1 onShowTranslation;
    private SelectionController selectionController;

    public /* synthetic */ SelectableTextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function2, SelectionController selectionController, ColorProducer colorProducer, Function1 function3, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function2, selectionController, colorProducer, function3);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
    }

    public /* synthetic */ SelectableTextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function2, SelectionController selectionController, ColorProducer colorProducer, Function1 function3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, (i4 & 8) != 0 ? null : function1, (i4 & 16) != 0 ? TextOverflow.Companion.m2516getClipgIe3tQ8() : i, (i4 & 32) != 0 ? true : z, (i4 & 64) != 0 ? Integer.MAX_VALUE : i2, (i4 & 128) != 0 ? 1 : i3, (i4 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : list, (i4 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : function2, (i4 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : selectionController, (i4 & 2048) != 0 ? null : colorProducer, (i4 & 4096) != 0 ? null : function3, null);
    }

    private SelectableTextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function2, SelectionController selectionController, ColorProducer colorProducer, Function1 function3) {
        this.selectionController = selectionController;
        this.onShowTranslation = function3;
        this.delegate = (TextAnnotatedStringNode) delegate(new TextAnnotatedStringNode(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function2, this.selectionController, colorProducer, this.onShowTranslation, null));
        throw new IllegalArgumentException("Do not use SelectionCapableStaticTextModifier unless selectionController != null");
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        this.delegate.drawNonExtension(contentDrawScope);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo54measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        return this.delegate.m621measureNonExtension3p2s80s(measureScope, measurable, j);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.delegate.minIntrinsicWidthNonExtension(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.delegate.minIntrinsicHeightNonExtension(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.delegate.maxIntrinsicWidthNonExtension(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.delegate.maxIntrinsicHeightNonExtension(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    /* JADX INFO: renamed from: update-L09Iy8E, reason: not valid java name */
    public final void m620updateL09Iy8E(AnnotatedString annotatedString, TextStyle textStyle, List list, int i, int i2, boolean z, FontFamily.Resolver resolver, int i3, Function1 function1, Function1 function2, SelectionController selectionController, ColorProducer colorProducer) {
        TextAnnotatedStringNode textAnnotatedStringNode = this.delegate;
        textAnnotatedStringNode.doInvalidations(textAnnotatedStringNode.updateDraw(colorProducer, textStyle), this.delegate.updateText$foundation_release(annotatedString), this.delegate.m622updateLayoutRelatedArgsMPT68mk(textStyle, list, i, i2, z, resolver, i3), this.delegate.updateCallbacks(function1, function2, selectionController, this.onShowTranslation));
        this.selectionController = selectionController;
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }
}
