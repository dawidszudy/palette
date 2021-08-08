package pl.pp.palette;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyListener extends KeyAdapter {

    private MyComponent myComponent;
    private Ball ball = Ball.getBall();

    public MyKeyListener(Ball ball) {
        this.ball = ball;
    }

    public MyKeyListener(MyComponent myComponent) {
        this.myComponent = myComponent;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();
        int speedPalette = 10;

        switch (keyCode) {
            case KeyEvent.VK_LEFT -> {
                Palette.paletteX -= speedPalette;
                if ( Palette.paletteX < 0 ) {
                    Palette.paletteX = 0;
                } else {
                    if ( ball.isGlue() ) {
                        ball.setX(ball.getX() - speedPalette);
                    }
                }
            }
            case KeyEvent.VK_RIGHT -> {
                Palette.paletteX += speedPalette;
                if ( Palette.paletteX > Utils.maxWidth - Palette.widthPalette ) {
                    Palette.paletteX = Utils.maxWidth - Palette.widthPalette;
                } else {
                    if ( ball.isGlue() ) {
                        ball.setX(ball.getX() + speedPalette);
                    }
                }
            }
            case KeyEvent.VK_SPACE -> {
                if ( ball.getSpeedY() > 0 && ball.isGlue() ) {
                    ball.setSpeedY(-ball.getSpeedY());
                }
                ball.setGlue(false);
            }
        }
        myComponent.repaint();
    }

}