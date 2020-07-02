package com.gildedrose;

public class Backstage extends Item {

    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        increaseQualityWhenLowerFifty();

        if (this.sellIn < 11) {
            increaseQualityWhenLowerFifty();
        }

        if (this.sellIn < 6) {
            increaseQualityWhenLowerFifty();
        }

        this.sellIn = this.sellIn - 1;

        if (this.sellIn < 0) {
            this.quality = 0;
        }
    }

    private void increaseQualityWhenLowerFifty() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
    }
}
