package aso.schemaforso56263801;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static aso.schemaforso56263801.DBConstants.*;

/**
 * The PaymentType table
 */
@Entity(tableName = TABLE_PAYTYPE)
public class PaymentType {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_PAYTYPE_ID)
    private long id;

    @ColumnInfo(name = COl_PAYTYPE_TYPE,index = true)
    private String payment_type;

    @ColumnInfo(name = COL_PAYTYPE_SURCHARGE)
    private Double surcharge;

    //Default constructor as used by Room
    public PaymentType() {
    }

    //Additional Constructor for use outside of Room
    // therefore IGNORED
    @Ignore
    public PaymentType(String type_of_payment, double surcharge) {
        this.payment_type = type_of_payment;
        this.surcharge = surcharge;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public Double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(Double surcharge) {
        this.surcharge = surcharge;
    }
}
