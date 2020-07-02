package com.gildedrose;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void sell_in_could_be_negative() {
        Item[] items = new Item[] { new Normal("Bread", 0, 55) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    @Tag("Unexpected Behaviour")
    @Test
    void sell_in_could_be_negative_quality_negative() {
        Item[] items = new Item[] { new Normal("Bread", 0, -1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void sell_in_passed_quality_dedcreases_twice() {
        Item[] items = new Item[] { new Normal("Bread", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }
    @Test
    void sell_in_passed_quality_less_than_50() {
        Item[] items = new Item[] { new AgedBrie("Aged Brie", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }
    @Test
    void sell_in_decreases_by_1() {
        Item[] items = new Item[] { new Normal("Bread", 5, 55) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
    }

    @Tag("Unexpected Behaviour")
    @Test
    void sell_in_decreases_by_1_when_quality_over_50() {
        Item[] items = new Item[] { new Normal("Bread", 5, 55) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(54, app.items[0].quality);
    }

    @Test
    void quality_never_more_than_50_when_lower_or_equals_50() {
        Item[] items = new Item[] { new AgedBrie("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Tag("Unexpected Behaviour")
    @Test
    void quality_never_more_than_50() {
        Item[] items = new Item[] { new Normal("Bread", 5, 55) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(54, app.items[0].quality);
    }

    @Test
    void quality_decreases_by_one_for_normal_item() {
        Item[] items = new Item[] { new Normal("Bread", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
    }
    @Test
    void quality_never_negative() {
        Item[] items = new Item[] { new Normal("Bread", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void quality_decreases_by_two_after_sellindate_reached() {
        Item[] items = new Item[] { new Normal("Bread", 0, 27) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(25, app.items[0].quality);
    }
    @Test
    void aged_brie_quality_increases_with_age() {
        Item[] items = new Item[] { new AgedBrie("Aged Brie", 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
    @Test
    void aged_brie_quality_increases_with_age_never_more_than_50() {
        Item[] items = new Item[] { new AgedBrie("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void sulfuras_never_decreases() {
        Item[] items = new Item[] { new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 42) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(42, app.items[0].quality);
    }
    @Test
    void sulfuras_never_to_be_sold() {
        Item[] items = new Item[] { new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 42) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void backstage_passes_sellindate_greater_11_quality_increase_by_1() {
        Item[] items = new Item[] { new Backstage("Backstage passes to a TAFKAL80ETC concert", 15, 27) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
    }

    //    Quality increases by 2 when there are 10 days or less
    @Test
    void backstage_passes_sellindate_lower_10_quality_increase_by_2() {
        Item[] items = new Item[] { new Backstage("Backstage passes to a TAFKAL80ETC concert", 7, 27) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(29, app.items[0].quality);
    }
    //    by 3 when there are 5 days or less but​
    @Test
    void backstage_passes_sellindate_lower_5_quality_increase_by_3() {
        Item[] items = new Item[] { new Backstage("Backstage passes to a TAFKAL80ETC concert", 4, 27) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(30, app.items[0].quality);
    }
    //    Quality drops to 0 after the concert
    @Test
    void backstage_passes_sellindate_0_quality_to_0() {
        Item[] items = new Item[] { new Backstage("Backstage passes to a TAFKAL80ETC concert", 0, 27) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    // TODO: After Sellin degrade twice as fast for Altbier

    @Test
    void altbier_quality_degrades_twice_as_normal() {
        Item[] items = new Item[] { new Altbier("Altbier", 20, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
    }

    // Edge case: Decrease by two -> Make sure quality not under 0
    @Test
    void altbier_quality_not_degrading_under_zero() {
        Item[] items = new Item[] { new Altbier("Altbier", 20, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}