package aso.schemaforso56263801;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

import static aso.schemaforso56263801.DBConstants.*;

/**
 * The OrderDetail Entity (table)
 */
@Entity(tableName = TABLE_ORDDTL, primaryKeys = {COL_ORDDTL_CUSTORD_REF,COL_ORDDTL_ITEM_REF})
public class OrderDetail {

    @ColumnInfo(name = COL_ORDDTL_CUSTORD_REF)
    @ForeignKey(entity = CustomerOrder.class,
            parentColumns = COL_CUSTORD_ID,
            childColumns = COL_ORDDTL_CUSTORD_REF,
            onUpdate = ForeignKey.CASCADE, onDelete = ForeignKey.CASCADE
    )
    private long customer_order_reference;

    @ColumnInfo(name = COL_ORDDTL_ITEM_REF)
    @ForeignKey(entity = Item.class,
            parentColumns = COL_ITEM_ID,
            childColumns = COL_ORDDTL_ITEM_REF,
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
    )
    private long item_reference;

    @ColumnInfo(name = COL_ORDDTL_QUANTITY)
    private int quantity;

    //Default constructor as used by Room
    public OrderDetail() {}

    //Additional Constructor for use outside of Room
    // therefore IGNORED
    @Ignore
    public OrderDetail(long customer_order_reference ,long item_reference, int quantity ) {
        this.customer_order_reference = customer_order_reference;
        this.item_reference = item_reference;
        this.quantity = quantity;
    }

    public long getCustomer_order_reference() {
        return customer_order_reference;
    }

    public void setCustomer_order_reference(long customer_order_reference) {
        this.customer_order_reference = customer_order_reference;
    }

    public long getItem_reference() {
        return item_reference;
    }

    public void setItem_reference(long item_reference) {
        this.item_reference = item_reference;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
