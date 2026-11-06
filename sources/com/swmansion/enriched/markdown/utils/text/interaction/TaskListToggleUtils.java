package com.swmansion.enriched.markdown.utils.text.interaction;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class TaskListToggleUtils {
    public static final TaskListToggleUtils INSTANCE = new TaskListToggleUtils();
    private static final Regex TASK_PATTERN = new Regex("^([ \\t]*[-*+][ \\t]+)\\[[ xX]]", RegexOption.MULTILINE);

    private TaskListToggleUtils() {
    }

    public final String toggleAtIndex(String markdown, int i, boolean z) {
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        List list = SequencesKt.toList(Regex.findAll$default(TASK_PATTERN, markdown, 0, 2, null));
        if (i < 0 || i >= list.size()) {
            return markdown;
        }
        MatchResult matchResult = (MatchResult) list.get(i);
        return StringsKt.replaceRange(markdown, matchResult.getRange(), ((String) matchResult.getGroupValues().get(1)) + "[" + (z ? "x" : " ") + "]").toString();
    }
}
