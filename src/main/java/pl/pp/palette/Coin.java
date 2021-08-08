package pl.pp.palette;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Coin {

    private final int CoinX;
    private final int CoinY;
    private final int widthCoin = 15;
    private final int heightCoin = 25;
    private boolean show = true;


    public Coin(int CoinX, int CoinY) {
        this.CoinX = CoinX;
        this.CoinY = CoinY;
    }

    public Shape getShape() {
        return new Ellipse2D.Float(CoinX, CoinY, widthCoin, heightCoin);
    }

    public int getCoinX() {
        return CoinX;
    }

    public int getCoinY() {
        return CoinY;
    }

    public int getWidthCoin() {
        return widthCoin;
    }

    public int getHeightCoin() {
        return heightCoin;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

}
