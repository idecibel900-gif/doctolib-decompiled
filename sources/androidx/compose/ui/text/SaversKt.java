package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class SaversKt {
    private static final Saver AnnotatedStringSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, AnnotatedString annotatedString) {
            return CollectionsKt.arrayListOf(SaversKt.save(annotatedString.getText()), SaversKt.save(annotatedString.getSpanStyles(), SaversKt.AnnotationRangeListSaver, saverScope), SaversKt.save(annotatedString.getParagraphStyles(), SaversKt.AnnotationRangeListSaver, saverScope), SaversKt.save(annotatedString.getAnnotations$ui_text_release(), SaversKt.AnnotationRangeListSaver, saverScope));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString invoke(Object obj) {
            List list;
            List list2;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list3 = (List) obj;
            Object obj2 = list3.get(1);
            Saver saver = SaversKt.AnnotationRangeListSaver;
            Boolean bool = Boolean.FALSE;
            List list4 = null;
            List list5 = ((!Intrinsics.areEqual(obj2, bool) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? (List) saver.restore(obj2) : null;
            Object obj3 = list3.get(2);
            Saver saver2 = SaversKt.AnnotationRangeListSaver;
            List list6 = ((!Intrinsics.areEqual(obj3, bool) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? (List) saver2.restore(obj3) : null;
            Object obj4 = list3.get(0);
            String str = obj4 != null ? (String) obj4 : null;
            Intrinsics.checkNotNull(str);
            if (list5 != null) {
                List list7 = list5;
                if (list7.isEmpty()) {
                    list7 = null;
                }
                list = list7;
            } else {
                list = null;
            }
            if (list6 != null) {
                List list8 = list6;
                if (list8.isEmpty()) {
                    list8 = null;
                }
                list2 = list8;
            } else {
                list2 = null;
            }
            Object obj5 = list3.get(3);
            Saver saver3 = SaversKt.AnnotationRangeListSaver;
            if ((!Intrinsics.areEqual(obj5, bool) || (saver3 instanceof NonNullValueClassSaver)) && obj5 != null) {
                list4 = (List) saver3.restore(obj5);
            }
            return new AnnotatedString(str, list, list2, list4);
        }
    });
    private static final Saver AnnotationRangeListSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, List list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(SaversKt.save((AnnotatedString.Range) list.get(i), SaversKt.AnnotationRangeSaver, saverScope));
            }
            return arrayList;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final List invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                Saver saver = SaversKt.AnnotationRangeSaver;
                AnnotatedString.Range range = null;
                if ((!Intrinsics.areEqual(obj2, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                    range = (AnnotatedString.Range) saver.restore(obj2);
                }
                Intrinsics.checkNotNull(range);
                arrayList.add(range);
            }
            return arrayList;
        }
    });
    private static final Saver AnnotationRangeSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$1

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnnotationType.Link.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AnnotationType.Clickable.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, AnnotatedString.Range range) {
            AnnotationType annotationType;
            Object objSave;
            Object item = range.getItem();
            if (item instanceof ParagraphStyle) {
                annotationType = AnnotationType.Paragraph;
            } else if (item instanceof SpanStyle) {
                annotationType = AnnotationType.Span;
            } else if (item instanceof VerbatimTtsAnnotation) {
                annotationType = AnnotationType.VerbatimTts;
            } else if (item instanceof UrlAnnotation) {
                annotationType = AnnotationType.Url;
            } else if (item instanceof LinkAnnotation.Url) {
                annotationType = AnnotationType.Link;
            } else {
                annotationType = item instanceof LinkAnnotation.Clickable ? AnnotationType.Clickable : AnnotationType.String;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()]) {
                case 1:
                    Object item2 = range.getItem();
                    Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                    objSave = SaversKt.save((ParagraphStyle) item2, SaversKt.getParagraphStyleSaver(), saverScope);
                    break;
                case 2:
                    Object item3 = range.getItem();
                    Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                    objSave = SaversKt.save((SpanStyle) item3, SaversKt.getSpanStyleSaver(), saverScope);
                    break;
                case 3:
                    Object item4 = range.getItem();
                    Intrinsics.checkNotNull(item4, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                    objSave = SaversKt.save((VerbatimTtsAnnotation) item4, SaversKt.VerbatimTtsAnnotationSaver, saverScope);
                    break;
                case 4:
                    Object item5 = range.getItem();
                    Intrinsics.checkNotNull(item5, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                    objSave = SaversKt.save((UrlAnnotation) item5, SaversKt.UrlAnnotationSaver, saverScope);
                    break;
                case 5:
                    Object item6 = range.getItem();
                    Intrinsics.checkNotNull(item6, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
                    objSave = SaversKt.save((LinkAnnotation.Url) item6, SaversKt.LinkSaver, saverScope);
                    break;
                case 6:
                    Object item7 = range.getItem();
                    Intrinsics.checkNotNull(item7, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Clickable");
                    objSave = SaversKt.save((LinkAnnotation.Clickable) item7, SaversKt.ClickableSaver, saverScope);
                    break;
                case 7:
                    objSave = SaversKt.save(range.getItem());
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            return CollectionsKt.arrayListOf(SaversKt.save(annotationType), objSave, SaversKt.save(Integer.valueOf(range.getStart())), SaversKt.save(Integer.valueOf(range.getEnd())), SaversKt.save(range.getTag()));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$2

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnnotationType.Link.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AnnotationType.Clickable.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString.Range invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Object obj3 = null;
            AnnotationType annotationType = obj2 != null ? (AnnotationType) obj2 : null;
            Intrinsics.checkNotNull(annotationType);
            Object obj4 = list.get(2);
            Integer num = obj4 != null ? (Integer) obj4 : null;
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue();
            Object obj5 = list.get(3);
            Integer num2 = obj5 != null ? (Integer) obj5 : null;
            Intrinsics.checkNotNull(num2);
            int iIntValue2 = num2.intValue();
            Object obj6 = list.get(4);
            String str = obj6 != null ? (String) obj6 : null;
            Intrinsics.checkNotNull(str);
            switch (WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()]) {
                case 1:
                    Object obj7 = list.get(1);
                    Saver paragraphStyleSaver = SaversKt.getParagraphStyleSaver();
                    if ((!Intrinsics.areEqual(obj7, Boolean.FALSE) || (paragraphStyleSaver instanceof NonNullValueClassSaver)) && obj7 != null) {
                        obj3 = (ParagraphStyle) paragraphStyleSaver.restore(obj7);
                    }
                    Intrinsics.checkNotNull(obj3);
                    return new AnnotatedString.Range(obj3, iIntValue, iIntValue2, str);
                case 2:
                    Object obj8 = list.get(1);
                    Saver spanStyleSaver = SaversKt.getSpanStyleSaver();
                    if ((!Intrinsics.areEqual(obj8, Boolean.FALSE) || (spanStyleSaver instanceof NonNullValueClassSaver)) && obj8 != null) {
                        obj3 = (SpanStyle) spanStyleSaver.restore(obj8);
                    }
                    Intrinsics.checkNotNull(obj3);
                    return new AnnotatedString.Range(obj3, iIntValue, iIntValue2, str);
                case 3:
                    Object obj9 = list.get(1);
                    Saver saver = SaversKt.VerbatimTtsAnnotationSaver;
                    if ((!Intrinsics.areEqual(obj9, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj9 != null) {
                        obj3 = (VerbatimTtsAnnotation) saver.restore(obj9);
                    }
                    Intrinsics.checkNotNull(obj3);
                    return new AnnotatedString.Range(obj3, iIntValue, iIntValue2, str);
                case 4:
                    Object obj10 = list.get(1);
                    Saver saver2 = SaversKt.UrlAnnotationSaver;
                    if ((!Intrinsics.areEqual(obj10, Boolean.FALSE) || (saver2 instanceof NonNullValueClassSaver)) && obj10 != null) {
                        obj3 = (UrlAnnotation) saver2.restore(obj10);
                    }
                    Intrinsics.checkNotNull(obj3);
                    return new AnnotatedString.Range(obj3, iIntValue, iIntValue2, str);
                case 5:
                    Object obj11 = list.get(1);
                    Saver saver3 = SaversKt.LinkSaver;
                    if ((!Intrinsics.areEqual(obj11, Boolean.FALSE) || (saver3 instanceof NonNullValueClassSaver)) && obj11 != null) {
                        obj3 = (LinkAnnotation.Url) saver3.restore(obj11);
                    }
                    Intrinsics.checkNotNull(obj3);
                    return new AnnotatedString.Range(obj3, iIntValue, iIntValue2, str);
                case 6:
                    Object obj12 = list.get(1);
                    Saver saver4 = SaversKt.ClickableSaver;
                    if ((!Intrinsics.areEqual(obj12, Boolean.FALSE) || (saver4 instanceof NonNullValueClassSaver)) && obj12 != null) {
                        obj3 = (LinkAnnotation.Clickable) saver4.restore(obj12);
                    }
                    Intrinsics.checkNotNull(obj3);
                    return new AnnotatedString.Range(obj3, iIntValue, iIntValue2, str);
                case 7:
                    Object obj13 = list.get(1);
                    obj3 = obj13 != null ? (String) obj13 : null;
                    Intrinsics.checkNotNull(obj3);
                    return new AnnotatedString.Range(obj3, iIntValue, iIntValue2, str);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    });
    private static final Saver VerbatimTtsAnnotationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, VerbatimTtsAnnotation verbatimTtsAnnotation) {
            return SaversKt.save(verbatimTtsAnnotation.getVerbatim());
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final VerbatimTtsAnnotation invoke(Object obj) {
            String str = obj != null ? (String) obj : null;
            Intrinsics.checkNotNull(str);
            return new VerbatimTtsAnnotation(str);
        }
    });
    private static final Saver UrlAnnotationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, UrlAnnotation urlAnnotation) {
            return SaversKt.save(urlAnnotation.getUrl());
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final UrlAnnotation invoke(Object obj) {
            String str = obj != null ? (String) obj : null;
            Intrinsics.checkNotNull(str);
            return new UrlAnnotation(str);
        }
    });
    private static final Saver LinkSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$LinkSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, LinkAnnotation.Url url) {
            return CollectionsKt.arrayListOf(SaversKt.save(url.getUrl()), SaversKt.save(url.getStyles(), SaversKt.getTextLinkStylesSaver(), saverScope));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$LinkSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final LinkAnnotation.Url invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            TextLinkStyles textLinkStyles = null;
            String str = obj2 != null ? (String) obj2 : null;
            Intrinsics.checkNotNull(str);
            Object obj3 = list.get(1);
            Saver textLinkStylesSaver = SaversKt.getTextLinkStylesSaver();
            if ((!Intrinsics.areEqual(obj3, Boolean.FALSE) || (textLinkStylesSaver instanceof NonNullValueClassSaver)) && obj3 != null) {
                textLinkStyles = (TextLinkStyles) textLinkStylesSaver.restore(obj3);
            }
            return new LinkAnnotation.Url(str, textLinkStyles, null, 4, null);
        }
    });
    private static final Saver ClickableSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$ClickableSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, LinkAnnotation.Clickable clickable) {
            return CollectionsKt.arrayListOf(SaversKt.save(clickable.getTag()), SaversKt.save(clickable.getStyles(), SaversKt.getTextLinkStylesSaver(), saverScope));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$ClickableSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final LinkAnnotation.Clickable invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            String str = obj2 != null ? (String) obj2 : null;
            Intrinsics.checkNotNull(str);
            Object obj3 = list.get(1);
            Saver textLinkStylesSaver = SaversKt.getTextLinkStylesSaver();
            return new LinkAnnotation.Clickable(str, ((!Intrinsics.areEqual(obj3, Boolean.FALSE) || (textLinkStylesSaver instanceof NonNullValueClassSaver)) && obj3 != null) ? (TextLinkStyles) textLinkStylesSaver.restore(obj3) : null, null);
        }
    });
    private static final Saver ParagraphStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, ParagraphStyle paragraphStyle) {
            return CollectionsKt.arrayListOf(SaversKt.save(TextAlign.m2474boximpl(paragraphStyle.m2169getTextAligne0LSkKk())), SaversKt.save(TextDirection.m2488boximpl(paragraphStyle.m2170getTextDirections_7Xco())), SaversKt.save(TextUnit.m2616boximpl(paragraphStyle.m2168getLineHeightXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), saverScope), SaversKt.save(paragraphStyle.getTextIndent(), SaversKt.getSaver(TextIndent.Companion), saverScope));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final ParagraphStyle invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            TextIndent textIndent = null;
            TextAlign textAlign = obj2 != null ? (TextAlign) obj2 : null;
            Intrinsics.checkNotNull(textAlign);
            int iM2480unboximpl = textAlign.m2480unboximpl();
            Object obj3 = list.get(1);
            TextDirection textDirection = obj3 != null ? (TextDirection) obj3 : null;
            Intrinsics.checkNotNull(textDirection);
            int iM2494unboximpl = textDirection.m2494unboximpl();
            Object obj4 = list.get(2);
            Saver saver = SaversKt.getSaver(TextUnit.Companion);
            Boolean bool = Boolean.FALSE;
            TextUnit textUnit = ((!Intrinsics.areEqual(obj4, bool) || (saver instanceof NonNullValueClassSaver)) && obj4 != null) ? (TextUnit) saver.restore(obj4) : null;
            Intrinsics.checkNotNull(textUnit);
            long jM2625unboximpl = textUnit.m2625unboximpl();
            Object obj5 = list.get(3);
            Saver saver2 = SaversKt.getSaver(TextIndent.Companion);
            if ((!Intrinsics.areEqual(obj5, bool) || (saver2 instanceof NonNullValueClassSaver)) && obj5 != null) {
                textIndent = (TextIndent) saver2.restore(obj5);
            }
            return new ParagraphStyle(iM2480unboximpl, iM2494unboximpl, jM2625unboximpl, textIndent, null, null, 0, 0, null, 496, null);
        }
    });
    private static final Saver SpanStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, SpanStyle spanStyle) {
            Color colorM1361boximpl = Color.m1361boximpl(spanStyle.m2187getColor0d7_KjU());
            Color.Companion companion = Color.Companion;
            Object objSave = SaversKt.save(colorM1361boximpl, SaversKt.getSaver(companion), saverScope);
            TextUnit textUnitM2616boximpl = TextUnit.m2616boximpl(spanStyle.m2188getFontSizeXSAIIZE());
            TextUnit.Companion companion2 = TextUnit.Companion;
            return CollectionsKt.arrayListOf(objSave, SaversKt.save(textUnitM2616boximpl, SaversKt.getSaver(companion2), saverScope), SaversKt.save(spanStyle.getFontWeight(), SaversKt.getSaver(FontWeight.Companion), saverScope), SaversKt.save(spanStyle.m2189getFontStyle4Lr2A7w()), SaversKt.save(spanStyle.m2190getFontSynthesisZQGJjVo()), SaversKt.save(-1), SaversKt.save(spanStyle.getFontFeatureSettings()), SaversKt.save(TextUnit.m2616boximpl(spanStyle.m2191getLetterSpacingXSAIIZE()), SaversKt.getSaver(companion2), saverScope), SaversKt.save(spanStyle.m2186getBaselineShift5SSeXJ0(), SaversKt.getSaver(BaselineShift.Companion), saverScope), SaversKt.save(spanStyle.getTextGeometricTransform(), SaversKt.getSaver(TextGeometricTransform.Companion), saverScope), SaversKt.save(spanStyle.getLocaleList(), SaversKt.getSaver(LocaleList.Companion), saverScope), SaversKt.save(Color.m1361boximpl(spanStyle.m2185getBackground0d7_KjU()), SaversKt.getSaver(companion), saverScope), SaversKt.save(spanStyle.getTextDecoration(), SaversKt.getSaver(TextDecoration.Companion), saverScope), SaversKt.save(spanStyle.getShadow(), SaversKt.getSaver(Shadow.Companion), saverScope));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$2
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 androidx.compose.ui.text.SpanStyle, still in use, count: 2, list:
              (r1v1 androidx.compose.ui.text.SpanStyle) from 0x00d8: MOVE (r16v2 androidx.compose.ui.text.SpanStyle) = (r1v1 androidx.compose.ui.text.SpanStyle)
              (r1v1 androidx.compose.ui.text.SpanStyle) from 0x00d0: MOVE (r16v7 androidx.compose.ui.text.SpanStyle) = (r1v1 androidx.compose.ui.text.SpanStyle)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
            	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
            	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:59)
            	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
            */
        @Override // kotlin.jvm.functions.Function1
        public final androidx.compose.ui.text.SpanStyle invoke(java.lang.Object r29) {
            /*
                Method dump skipped, instruction units count: 450
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SaversKt$SpanStyleSaver$2.invoke(java.lang.Object):androidx.compose.ui.text.SpanStyle");
        }
    });
    private static final Saver TextLinkStylesSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$TextLinkStylesSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextLinkStyles textLinkStyles) {
            return CollectionsKt.arrayListOf(SaversKt.save(textLinkStyles.getStyle(), SaversKt.getSpanStyleSaver(), saverScope), SaversKt.save(textLinkStyles.getFocusedStyle(), SaversKt.getSpanStyleSaver(), saverScope), SaversKt.save(textLinkStyles.getHoveredStyle(), SaversKt.getSpanStyleSaver(), saverScope), SaversKt.save(textLinkStyles.getPressedStyle(), SaversKt.getSpanStyleSaver(), saverScope));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$TextLinkStylesSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextLinkStyles invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Saver spanStyleSaver = SaversKt.getSpanStyleSaver();
            Boolean bool = Boolean.FALSE;
            SpanStyle spanStyle = null;
            SpanStyle spanStyle2 = ((!Intrinsics.areEqual(obj2, bool) || (spanStyleSaver instanceof NonNullValueClassSaver)) && obj2 != null) ? (SpanStyle) spanStyleSaver.restore(obj2) : null;
            Object obj3 = list.get(1);
            Saver spanStyleSaver2 = SaversKt.getSpanStyleSaver();
            SpanStyle spanStyle3 = ((!Intrinsics.areEqual(obj3, bool) || (spanStyleSaver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? (SpanStyle) spanStyleSaver2.restore(obj3) : null;
            Object obj4 = list.get(2);
            Saver spanStyleSaver3 = SaversKt.getSpanStyleSaver();
            SpanStyle spanStyle4 = ((!Intrinsics.areEqual(obj4, bool) || (spanStyleSaver3 instanceof NonNullValueClassSaver)) && obj4 != null) ? (SpanStyle) spanStyleSaver3.restore(obj4) : null;
            Object obj5 = list.get(3);
            Saver spanStyleSaver4 = SaversKt.getSpanStyleSaver();
            if ((!Intrinsics.areEqual(obj5, bool) || (spanStyleSaver4 instanceof NonNullValueClassSaver)) && obj5 != null) {
                spanStyle = (SpanStyle) spanStyleSaver4.restore(obj5);
            }
            return new TextLinkStyles(spanStyle2, spanStyle3, spanStyle4, spanStyle);
        }
    });
    private static final Saver TextDecorationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextDecoration textDecoration) {
            return Integer.valueOf(textDecoration.getMask());
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextDecoration invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return new TextDecoration(((Integer) obj).intValue());
        }
    });
    private static final Saver TextGeometricTransformSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextGeometricTransform textGeometricTransform) {
            return CollectionsKt.arrayListOf(Float.valueOf(textGeometricTransform.getScaleX()), Float.valueOf(textGeometricTransform.getSkewX()));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextGeometricTransform invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
            List list = (List) obj;
            return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
        }
    });
    private static final Saver TextIndentSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextIndent textIndent) {
            TextUnit textUnitM2616boximpl = TextUnit.m2616boximpl(textIndent.m2503getFirstLineXSAIIZE());
            TextUnit.Companion companion = TextUnit.Companion;
            return CollectionsKt.arrayListOf(SaversKt.save(textUnitM2616boximpl, SaversKt.getSaver(companion), saverScope), SaversKt.save(TextUnit.m2616boximpl(textIndent.m2504getRestLineXSAIIZE()), SaversKt.getSaver(companion), saverScope));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextIndent invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            TextUnit.Companion companion = TextUnit.Companion;
            Saver saver = SaversKt.getSaver(companion);
            Boolean bool = Boolean.FALSE;
            TextUnit textUnit = null;
            TextUnit textUnit2 = ((!Intrinsics.areEqual(obj2, bool) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? (TextUnit) saver.restore(obj2) : null;
            Intrinsics.checkNotNull(textUnit2);
            long jM2625unboximpl = textUnit2.m2625unboximpl();
            Object obj3 = list.get(1);
            Saver saver2 = SaversKt.getSaver(companion);
            if ((!Intrinsics.areEqual(obj3, bool) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) {
                textUnit = (TextUnit) saver2.restore(obj3);
            }
            Intrinsics.checkNotNull(textUnit);
            return new TextIndent(jM2625unboximpl, textUnit.m2625unboximpl(), null);
        }
    });
    private static final Saver FontWeightSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, FontWeight fontWeight) {
            return Integer.valueOf(fontWeight.getWeight());
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final FontWeight invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return new FontWeight(((Integer) obj).intValue());
        }
    });
    private static final Saver BaselineShiftSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m2173invoke8a2Sb4w((SaverScope) obj, ((BaselineShift) obj2).m2414unboximpl());
        }

        /* JADX INFO: renamed from: invoke-8a2Sb4w, reason: not valid java name */
        public final Object m2173invoke8a2Sb4w(SaverScope saverScope, float f) {
            return Float.valueOf(f);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-jTk7eUs, reason: not valid java name and merged with bridge method [inline-methods] */
        public final BaselineShift invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            return BaselineShift.m2408boximpl(BaselineShift.m2409constructorimpl(((Float) obj).floatValue()));
        }
    });
    private static final Saver TextRangeSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m2179invokeFDrldGo((SaverScope) obj, ((TextRange) obj2).m2221unboximpl());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke-FDrldGo, reason: not valid java name */
        public final Object m2179invokeFDrldGo(SaverScope saverScope, long j) {
            return CollectionsKt.arrayListOf(SaversKt.save(Integer.valueOf(TextRange.m2217getStartimpl(j))), SaversKt.save(Integer.valueOf(TextRange.m2212getEndimpl(j))));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-VqIyPBM, reason: not valid java name and merged with bridge method [inline-methods] */
        public final TextRange invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Integer num = obj2 != null ? (Integer) obj2 : null;
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue();
            Object obj3 = list.get(1);
            Integer num2 = obj3 != null ? (Integer) obj3 : null;
            Intrinsics.checkNotNull(num2);
            return TextRange.m2205boximpl(TextRangeKt.TextRange(iIntValue, num2.intValue()));
        }
    });
    private static final Saver ShadowSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, Shadow shadow) {
            return CollectionsKt.arrayListOf(SaversKt.save(Color.m1361boximpl(shadow.m1485getColor0d7_KjU()), SaversKt.getSaver(Color.Companion), saverScope), SaversKt.save(Offset.m1214boximpl(shadow.m1486getOffsetF1C5BW0()), SaversKt.getSaver(Offset.Companion), saverScope), SaversKt.save(Float.valueOf(shadow.getBlurRadius())));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final Shadow invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Saver saver = SaversKt.getSaver(Color.Companion);
            Boolean bool = Boolean.FALSE;
            Color color = ((!Intrinsics.areEqual(obj2, bool) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? (Color) saver.restore(obj2) : null;
            Intrinsics.checkNotNull(color);
            long jM1375unboximpl = color.m1375unboximpl();
            Object obj3 = list.get(1);
            Saver saver2 = SaversKt.getSaver(Offset.Companion);
            Offset offset = ((!Intrinsics.areEqual(obj3, bool) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? (Offset) saver2.restore(obj3) : null;
            Intrinsics.checkNotNull(offset);
            long jM1232unboximpl = offset.m1232unboximpl();
            Object obj4 = list.get(2);
            Float f = obj4 != null ? (Float) obj4 : null;
            Intrinsics.checkNotNull(f);
            return new Shadow(jM1375unboximpl, jM1232unboximpl, f.floatValue(), null);
        }
    });
    private static final NonNullValueClassSaver ColorSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m2175invoke4WTKRHQ((SaverScope) obj, ((Color) obj2).m1375unboximpl());
        }

        /* JADX INFO: renamed from: invoke-4WTKRHQ, reason: not valid java name */
        public final Object m2175invoke4WTKRHQ(SaverScope saverScope, long j) {
            return j == 16 ? Boolean.FALSE : Integer.valueOf(ColorKt.m1393toArgb8_81llA(j));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-ijrfgN4, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Color invoke(Object obj) {
            long jColor;
            if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                jColor = Color.Companion.m1385getUnspecified0d7_KjU();
            } else {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                jColor = ColorKt.Color(((Integer) obj).intValue());
            }
            return Color.m1361boximpl(jColor);
        }
    });
    private static final NonNullValueClassSaver TextUnitSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m2181invokempE4wyQ((SaverScope) obj, ((TextUnit) obj2).m2625unboximpl());
        }

        /* JADX INFO: renamed from: invoke-mpE4wyQ, reason: not valid java name */
        public final Object m2181invokempE4wyQ(SaverScope saverScope, long j) {
            if (TextUnit.m2619equalsimpl0(j, TextUnit.Companion.m2626getUnspecifiedXSAIIZE())) {
                return Boolean.FALSE;
            }
            return CollectionsKt.arrayListOf(SaversKt.save(Float.valueOf(TextUnit.m2622getValueimpl(j))), SaversKt.save(TextUnitType.m2632boximpl(TextUnit.m2621getTypeUIouoOA(j))));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-XNhUCwk, reason: not valid java name and merged with bridge method [inline-methods] */
        public final TextUnit invoke(Object obj) {
            if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                return TextUnit.m2616boximpl(TextUnit.Companion.m2626getUnspecifiedXSAIIZE());
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Float f = obj2 != null ? (Float) obj2 : null;
            Intrinsics.checkNotNull(f);
            float fFloatValue = f.floatValue();
            Object obj3 = list.get(1);
            TextUnitType textUnitType = obj3 != null ? (TextUnitType) obj3 : null;
            Intrinsics.checkNotNull(textUnitType);
            return TextUnit.m2616boximpl(TextUnitKt.m2627TextUnitanM5pPY(fFloatValue, textUnitType.m2638unboximpl()));
        }
    });
    private static final NonNullValueClassSaver OffsetSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m2177invokeUv8p0NA((SaverScope) obj, ((Offset) obj2).m1232unboximpl());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
        public final Object m2177invokeUv8p0NA(SaverScope saverScope, long j) {
            return Offset.m1220equalsimpl0(j, Offset.Companion.m1234getUnspecifiedF1C5BW0()) ? Boolean.FALSE : CollectionsKt.arrayListOf(SaversKt.save(Float.valueOf(Offset.m1223getXimpl(j))), SaversKt.save(Float.valueOf(Offset.m1224getYimpl(j))));
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-x-9fifI, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Offset invoke(Object obj) {
            if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                return Offset.m1214boximpl(Offset.Companion.m1234getUnspecifiedF1C5BW0());
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Float f = obj2 != null ? (Float) obj2 : null;
            Intrinsics.checkNotNull(f);
            float fFloatValue = f.floatValue();
            Object obj3 = list.get(1);
            Float f2 = obj3 != null ? (Float) obj3 : null;
            Intrinsics.checkNotNull(f2);
            return Offset.m1214boximpl(OffsetKt.Offset(fFloatValue, f2.floatValue()));
        }
    });
    private static final Saver LocaleListSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, LocaleList localeList) {
            List localeList2 = localeList.getLocaleList();
            ArrayList arrayList = new ArrayList(localeList2.size());
            int size = localeList2.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(SaversKt.save((Locale) localeList2.get(i), SaversKt.getSaver(Locale.Companion), saverScope));
            }
            return arrayList;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final LocaleList invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                Saver saver = SaversKt.getSaver(Locale.Companion);
                Locale locale = null;
                if ((!Intrinsics.areEqual(obj2, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                    locale = (Locale) saver.restore(obj2);
                }
                Intrinsics.checkNotNull(locale);
                arrayList.add(locale);
            }
            return new LocaleList(arrayList);
        }
    });
    private static final Saver LocaleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, Locale locale) {
            return locale.toLanguageTag();
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final Locale invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            return new Locale((String) obj);
        }
    });

    public static final Object save(Object obj) {
        return obj;
    }

    public static final Object save(Object obj, Saver saver, SaverScope saverScope) {
        Object objSave;
        return (obj == null || (objSave = saver.save(saverScope, obj)) == null) ? Boolean.FALSE : objSave;
    }

    private static final NonNullValueClassSaver NonNullValueClassSaver(final Function2 function2, final Function1 function1) {
        return new NonNullValueClassSaver() { // from class: androidx.compose.ui.text.SaversKt.NonNullValueClassSaver.1
            @Override // androidx.compose.runtime.saveable.Saver
            public Object save(SaverScope saverScope, Object obj) {
                return function2.invoke(saverScope, obj);
            }

            @Override // androidx.compose.runtime.saveable.Saver
            public Object restore(Object obj) {
                return function1.invoke(obj);
            }
        };
    }

    public static final Saver getAnnotatedStringSaver() {
        return AnnotatedStringSaver;
    }

    public static final Saver getParagraphStyleSaver() {
        return ParagraphStyleSaver;
    }

    public static final Saver getSpanStyleSaver() {
        return SpanStyleSaver;
    }

    public static final Saver getTextLinkStylesSaver() {
        return TextLinkStylesSaver;
    }

    public static final Saver getSaver(TextDecoration.Companion companion) {
        return TextDecorationSaver;
    }

    public static final Saver getSaver(TextGeometricTransform.Companion companion) {
        return TextGeometricTransformSaver;
    }

    public static final Saver getSaver(TextIndent.Companion companion) {
        return TextIndentSaver;
    }

    public static final Saver getSaver(FontWeight.Companion companion) {
        return FontWeightSaver;
    }

    public static final Saver getSaver(BaselineShift.Companion companion) {
        return BaselineShiftSaver;
    }

    public static final Saver getSaver(TextRange.Companion companion) {
        return TextRangeSaver;
    }

    public static final Saver getSaver(Shadow.Companion companion) {
        return ShadowSaver;
    }

    public static final Saver getSaver(Color.Companion companion) {
        return ColorSaver;
    }

    public static final Saver getSaver(TextUnit.Companion companion) {
        return TextUnitSaver;
    }

    public static final Saver getSaver(Offset.Companion companion) {
        return OffsetSaver;
    }

    public static final Saver getSaver(LocaleList.Companion companion) {
        return LocaleListSaver;
    }

    public static final Saver getSaver(Locale.Companion companion) {
        return LocaleSaver;
    }
}
