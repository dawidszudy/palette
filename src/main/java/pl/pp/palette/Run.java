package pl.pp.palette;

import java.awt.*;

public class Run {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MyFrame myFrame = new MyFrame();
            myFrame.setVisible(true);
        });
    }

}
