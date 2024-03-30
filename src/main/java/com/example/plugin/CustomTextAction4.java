package com.example.plugin;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

class CustomTextAction4 extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        // 获取当前编辑器和选择模型
        Editor editor = e.getRequiredData(com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR);
        SelectionModel selectionModel = editor.getSelectionModel();

        // 获取选中的文本
        String selectedText = selectionModel.getSelectedText();
        if (selectedText != null) {
            // 这里可以添加逻辑以生成你想要的字符串
            String newText = "translateText('plTree.textMap.', " + selectedText+")";

            // 使用WriteCommandAction来替换文本
            WriteCommandAction.runWriteCommandAction(e.getProject(), () ->
                    editor.getDocument().replaceString(
                            selectionModel.getSelectionStart(),
                            selectionModel.getSelectionEnd(),
                            newText
                    )
            );
        }
    }
}
