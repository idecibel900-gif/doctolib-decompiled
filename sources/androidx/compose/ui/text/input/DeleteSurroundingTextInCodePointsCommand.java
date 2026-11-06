package androidx.compose.ui.text.input;

/* JADX INFO: loaded from: classes.dex */
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    public DeleteSurroundingTextInCodePointsCommand(int i, int i2) {
        this.lengthBeforeCursor = i;
        this.lengthAfterCursor = i2;
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.").toString());
        }
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer editingBuffer) {
        int i = this.lengthBeforeCursor;
        int selectionStart$ui_text_release = 0;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = selectionStart$ui_text_release + 1;
            if (editingBuffer.getSelectionStart$ui_text_release() > i3) {
                selectionStart$ui_text_release = EditCommandKt.isSurrogatePair(editingBuffer.get$ui_text_release((editingBuffer.getSelectionStart$ui_text_release() - i3) + (-1)), editingBuffer.get$ui_text_release(editingBuffer.getSelectionStart$ui_text_release() - i3)) ? selectionStart$ui_text_release + 2 : i3;
            } else {
                selectionStart$ui_text_release = editingBuffer.getSelectionStart$ui_text_release();
                break;
            }
        }
        int i4 = this.lengthAfterCursor;
        int length$ui_text_release = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = length$ui_text_release + 1;
            if (editingBuffer.getSelectionEnd$ui_text_release() + i6 < editingBuffer.getLength$ui_text_release()) {
                length$ui_text_release = EditCommandKt.isSurrogatePair(editingBuffer.get$ui_text_release((editingBuffer.getSelectionEnd$ui_text_release() + i6) + (-1)), editingBuffer.get$ui_text_release(editingBuffer.getSelectionEnd$ui_text_release() + i6)) ? length$ui_text_release + 2 : i6;
            } else {
                length$ui_text_release = editingBuffer.getLength$ui_text_release() - editingBuffer.getSelectionEnd$ui_text_release();
                break;
            }
        }
        editingBuffer.delete$ui_text_release(editingBuffer.getSelectionEnd$ui_text_release(), editingBuffer.getSelectionEnd$ui_text_release() + length$ui_text_release);
        editingBuffer.delete$ui_text_release(editingBuffer.getSelectionStart$ui_text_release() - selectionStart$ui_text_release, editingBuffer.getSelectionStart$ui_text_release());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return false;
        }
        DeleteSurroundingTextInCodePointsCommand deleteSurroundingTextInCodePointsCommand = (DeleteSurroundingTextInCodePointsCommand) obj;
        return this.lengthBeforeCursor == deleteSurroundingTextInCodePointsCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextInCodePointsCommand.lengthAfterCursor;
    }

    public int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public String toString() {
        return "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.lengthBeforeCursor + ", lengthAfterCursor=" + this.lengthAfterCursor + ')';
    }
}
