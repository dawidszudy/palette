package pl.pp.palette;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball {

    private int X = 350;
    private int Y = 250;
    private final int width = 30;
    private final int height = 30;
    private int speedX = 5;
    private int speedY = 10;
    private boolean glue = false;
    private static final Ball ball = new Ball();

    private Ball() {
    }

    public static Ball getBall() {  // metoda zwracająca stan Ball
        return ball;
    }

    public void updatePosition() {

        if ( !glue ) {
            X += speedX;
            Y += speedY;
        }

        if ( glue && X >= Utils.maxWidth - width ) {
            X = Utils.maxWidth - width - 1;
        }

        if ( glue && X <= 0 ) {
            X = 1;
        }

        if ( Y + height > Utils.maxHeight ) {

            X = Palette.paletteX - width / 2 + Palette.widthPalette / 2;
            Y = Palette.paletteY - height;
            Utils.lives--;
            glue = true;
        }

        if ( X + width >= Utils.maxWidth ) {
            speedX = -speedX;
        }

        if ( Y <= 0 ) {
            speedY = -speedY;
        }

        if ( X <= 0 ) {
            speedX = -speedX;
        }

        if ( checkCollision() ) {
            glue = true;
            Y = Palette.paletteY - height;
            X -= speedX;
        }

    }


    public Shape getShape() {
        return new Ellipse2D.Float(X, Y, width, height);
    }


    public boolean checkCollision() {
        return Palette.paletteX < X + width / 2 && Palette.paletteX + Palette.widthPalette > X + width / 2 &&
                Palette.paletteY < Y + height && Palette.paletteY + Palette.heightPalette > Y;
    }

    public boolean checkCollision(Coin coin) {
        return coin.getCoinX() < X + width && coin.getCoinX() + coin.getWidthCoin() > X + width &&
                coin.getCoinY() < Y + height && coin.getCoinY() + coin.getHeightCoin() > Y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public boolean isGlue() {
        return glue;
    }

    public void setGlue(boolean glue) {
        this.glue = glue;
    }

}
