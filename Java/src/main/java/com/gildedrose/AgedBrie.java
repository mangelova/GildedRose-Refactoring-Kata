package com.gildedrose;

public class AgedBrie extends Item {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        increaseQualityWhenLowerFifty();

        if (this.sellIn < 0) {
            increaseQualityWhenLowerFifty();
        }

        this.sellIn = this.sellIn - 1;
    }

    private void increaseQualityWhenLowerFifty() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
    }
}
