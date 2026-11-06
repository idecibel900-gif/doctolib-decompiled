package com.swmansion.enriched.markdown.utils.common.serialization;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MarkdownASTSerializer {
    public static final MarkdownASTSerializer INSTANCE = new MarkdownASTSerializer();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MarkdownASTNode.NodeType.values().length];
            try {
                iArr[MarkdownASTNode.NodeType.Text.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.LineBreak.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.SoftBreak.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Strong.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Emphasis.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Strikethrough.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Underline.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Superscript.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Subscript.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Highlight.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Code.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Link.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Image.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MarkdownASTSerializer() {
    }

    public final String serializeChildren(MarkdownASTNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        StringBuilder sb = new StringBuilder();
        Iterator<MarkdownASTNode> it = node.getChildren().iterator();
        while (it.hasNext()) {
            appendNode(it.next(), sb);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final void appendNode(MarkdownASTNode markdownASTNode, StringBuilder sb) {
        String str;
        switch (WhenMappings.$EnumSwitchMapping$0[markdownASTNode.getType().ordinal()]) {
            case 1:
                sb.append(markdownASTNode.getContent());
                break;
            case 2:
                sb.append("\\\n");
                break;
            case 3:
                sb.append("\n");
                break;
            case 4:
                sb.append("**");
                appendChildren(markdownASTNode, sb);
                sb.append("**");
                break;
            case 5:
                sb.append("*");
                appendChildren(markdownASTNode, sb);
                sb.append("*");
                break;
            case 6:
                sb.append("~~");
                appendChildren(markdownASTNode, sb);
                sb.append("~~");
                break;
            case 7:
                sb.append("__");
                appendChildren(markdownASTNode, sb);
                sb.append("__");
                break;
            case 8:
                sb.append("^");
                appendChildren(markdownASTNode, sb);
                sb.append("^");
                break;
            case 9:
                sb.append("~");
                appendChildren(markdownASTNode, sb);
                sb.append("~");
                break;
            case 10:
                sb.append("==");
                appendChildren(markdownASTNode, sb);
                sb.append("==");
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                sb.append("`");
                appendChildren(markdownASTNode, sb);
                sb.append("`");
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                String attribute = markdownASTNode.getAttribute("url");
                str = attribute != null ? attribute : "";
                sb.append("[");
                appendChildren(markdownASTNode, sb);
                sb.append("](");
                sb.append(str);
                sb.append(")");
                break;
            case 13:
                String attribute2 = markdownASTNode.getAttribute("alt");
                if (attribute2 == null) {
                    attribute2 = "";
                }
                String attribute3 = markdownASTNode.getAttribute("url");
                str = attribute3 != null ? attribute3 : "";
                sb.append("![");
                sb.append(attribute2);
                sb.append("](");
                sb.append(str);
                sb.append(")");
                break;
            default:
                appendChildren(markdownASTNode, sb);
                Unit unit = Unit.INSTANCE;
                break;
        }
    }

    private final void appendChildren(MarkdownASTNode markdownASTNode, StringBuilder sb) {
        Iterator<MarkdownASTNode> it = markdownASTNode.getChildren().iterator();
        while (it.hasNext()) {
            appendNode(it.next(), sb);
        }
    }
}
