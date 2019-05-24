package aso.schemaforso56263801;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static aso.schemaforso56263801.DBConstants.*;

/**
 * The Item table
 */
@Entity(tableName = TABLE_ITEM)
public class Item {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_ITEM_ID)
    private long id;

    @ColumnInfo(name = COl_ITEM_NAME)
    private String item_name;

    @ColumnInfo(name = COL_ITEM_CATEGORY_REF)
    private long category_ref;

    @ColumnInfo(name = COL_ITEM_PRICE)
    private double item_price;

    //Default constructor as used by Room
    public Item(){
    }

    //Additional Constructor for use outside of Room
    // therefore IGNORED
    @Ignore
    public Item(String item, double price, long category_ref) {
        this.item_name = item;
        this.item_price = price;
        this.category_ref = category_ref;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public long getCategory_ref() {
        return category_ref;
    }

    public void setCategory_ref(long category_ref) {
        this.category_ref = category_ref;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }
}
