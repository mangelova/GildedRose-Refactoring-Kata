package com.gildedrose;

public class Altbier extends Item {

    private int standardDecrease = 1;

    public Altbier(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseQualityWhenOverZero(2);

        this.sellIn = this.sellIn - 1;
    }

    private void decreaseQualityWhenOverZero(int factor) {
        this.quality = this.quality - standardDecrease*factor;

        if (this.quality < 0) {
            this.quality = 0;
        }
    }
}
