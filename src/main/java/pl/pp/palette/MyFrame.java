package pl.pp.palette;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        setTitle("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);

        MyComponent myComponent = new MyComponent();
        add(myComponent);
        addKeyListener(new MyKeyListener(myComponent));
    }

}
