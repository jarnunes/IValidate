package com.ivalidate.model;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class CopyClipboard {
    public static void copy(String value) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(value);
        clipboard.setContents(selection, null);
    }

}
