本插件适用于JetBrains系列IDE
### 旨在通过快捷键实现文本内容的快速替换，从而简化重复性工作流程。

例如，将文本中的“aaa”通过快捷键Ctrl+0替换为“(test, aaa);”。

### 实现步骤
1. 在com.example.plugin包下添加一个Java类CustomTextAction0。
2. 可以直接参考其它几个类，然后在第19行按照需求修改String newText = "(test, " + selectedText+")";
3. 在plugin.xml的actions节中添加以下配置：
```text
      <action id="CustomTextAction0" class="com.example.plugin.CustomTextAction0" text="Custom Text Action" description="A custom text action.">
            <keyboard-shortcut keymap="$default" first-keystroke="control 0"/>
      </action>
      
      其中first-keystroke就是映射的按键，修改修改id且对应上class
```
4(build)构建插件后，在IDE中通过定义的快捷键即可实现文本替换功能。
5![img.png](img.png)

### 展望：用户可以直接添加模板，不用重复编写，但难度较高，需要研究官方文档
