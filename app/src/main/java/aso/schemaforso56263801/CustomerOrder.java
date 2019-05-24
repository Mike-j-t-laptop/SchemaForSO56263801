package aso.schemaforso56263801;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

import static aso.schemaforso56263801.DBConstants.*;

/**
 * The CustomerOrder table
 */
@Entity(tableName = TABLE_CUSTORD)
public class CustomerOrder {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_CUSTORD_ID)
    private long id;

    @ColumnInfo(name = COL_CUSTORD_NAME)
    private String name;

    @ColumnInfo(name = COl_CUSTORD_DATE)
    private String date;

    @ColumnInfo(name = COL_CUSTORD_PAYMENTTYPE_REF)
    @ForeignKey(entity = PaymentType.class,
            parentColumns = COL_PAYTYPE_ID,
            childColumns = COL_CUSTORD_PAYMENTTYPE_REF,
            onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)
    private long payment_type_ref;

    //Default constructor as used by Room
    public CustomerOrder(){}

    //Additional Constructor for use outside of Room
    // therefore IGNORED
    @Ignore
    public CustomerOrder(String name,long payment_type_ref) {
        this.name = name;
        this.payment_type_ref = payment_type_ref;
        this.date = DBConstants.SDF.format(new Date());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getPayment_type_ref() {
        return payment_type_ref;
    }

    public void setPayment_type_ref(long payment_type_ref) {
        this.payment_type_ref = payment_type_ref;
    }
}
