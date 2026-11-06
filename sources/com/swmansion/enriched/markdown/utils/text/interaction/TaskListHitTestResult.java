package com.swmansion.enriched.markdown.utils.text.interaction;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TaskListHitTestResult {
    private final boolean checked;
    private final String itemText;
    private final int taskIndex;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskListHitTestResult)) {
            return false;
        }
        TaskListHitTestResult taskListHitTestResult = (TaskListHitTestResult) obj;
        return this.taskIndex == taskListHitTestResult.taskIndex && this.checked == taskListHitTestResult.checked && Intrinsics.areEqual(this.itemText, taskListHitTestResult.itemText);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.taskIndex) * 31) + Boolean.hashCode(this.checked)) * 31) + this.itemText.hashCode();
    }

    public String toString() {
        return "TaskListHitTestResult(taskIndex=" + this.taskIndex + ", checked=" + this.checked + ", itemText=" + this.itemText + ")";
    }

    public TaskListHitTestResult(int i, boolean z, String itemText) {
        Intrinsics.checkNotNullParameter(itemText, "itemText");
        this.taskIndex = i;
        this.checked = z;
        this.itemText = itemText;
    }

    public final int getTaskIndex() {
        return this.taskIndex;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final String getItemText() {
        return this.itemText;
    }
}
