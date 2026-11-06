package com.swmansion.enriched.markdown.input.model;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v0 com.swmansion.enriched.markdown.input.model.BlockType, still in use, count: 1, list:
  (r3v0 com.swmansion.enriched.markdown.input.model.BlockType) from 0x006f: FILLED_NEW_ARRAY 
  (r3v0 com.swmansion.enriched.markdown.input.model.BlockType)
  (r4v0 com.swmansion.enriched.markdown.input.model.BlockType)
  (r5v0 com.swmansion.enriched.markdown.input.model.BlockType)
  (r6v0 com.swmansion.enriched.markdown.input.model.BlockType)
  (r7v0 com.swmansion.enriched.markdown.input.model.BlockType)
  (r8v0 com.swmansion.enriched.markdown.input.model.BlockType)
 A[WRAPPED] (LINE:28) elemType: com.swmansion.enriched.markdown.input.model.BlockType
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
/* JADX INFO: loaded from: classes4.dex */
public final class BlockType {
    PARAGRAPH,
    HEADING_1,
    HEADING_2,
    HEADING_3,
    HEADING_4,
    HEADING_5,
    HEADING_6,
    UNORDERED_LIST_ITEM,
    ORDERED_LIST_ITEM;

    private static final Set ANCHORED;
    private static final List HEADINGS;
    private static final Set LIST_ITEMS;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    private BlockType() {
        super(str, i);
    }

    static {
        List listListOf = CollectionsKt.listOf((Object[]) new BlockType[]{new BlockType(), new BlockType(), new BlockType(), new BlockType(), new BlockType(), new BlockType()});
        HEADINGS = listListOf;
        Set of = SetsKt.setOf((Object[]) new BlockType[]{new BlockType(), new BlockType()});
        LIST_ITEMS = of;
        ANCHORED = SetsKt.plus(CollectionsKt.toSet(listListOf), (Iterable) of);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List getHEADINGS() {
            return BlockType.HEADINGS;
        }

        public final Set getLIST_ITEMS() {
            return BlockType.LIST_ITEMS;
        }

        public final Set getANCHORED() {
            return BlockType.ANCHORED;
        }

        public final BlockType forHeadingLevel(int i) {
            return (BlockType) CollectionsKt.getOrNull(getHEADINGS(), i - 1);
        }
    }

    public static BlockType valueOf(String str) {
        return (BlockType) Enum.valueOf(BlockType.class, str);
    }

    public static BlockType[] values() {
        return (BlockType[]) $VALUES.clone();
    }
}
