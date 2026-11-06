package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class TaskManagerNotFoundException extends CodedException {
    public TaskManagerNotFoundException() {
        super("Could not find the task manager", null, 2, null);
    }
}
