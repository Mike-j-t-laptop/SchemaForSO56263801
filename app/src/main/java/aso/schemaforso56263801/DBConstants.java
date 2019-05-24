package aso.schemaforso56263801;

import android.provider.BaseColumns;

import java.text.SimpleDateFormat;

/**
 * Constants mostly for names
 */
public class DBConstants {

    public static final String DBNAME = "storeorder";
    public static final int DBVERSION = 1;
    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * DROP TABLE IF EXISTS item;
     * DROP TABLE IF EXISTS category;
     * CREATE TABLE IF NOT EXISTS category (_id INTEGER PRIMARY KEY, category_name TEXT);
     *
     **/
    public static final String TABLE_CATEGORY = "category";
    public static final String COL_CATEGORY_ID = BaseColumns._ID;
    public static final String COL_CATEGORY_NAME = "category_name";

    /**
     *
     * CREATE TABLE IF NOT EXISTS item (
     *     _id INTEGER PRIMARY KEY,
     *     item_name TEXT UNIQUE,
     *     category_ref INTEGER REFERENCES category(_id) ON DELETE CASCADE ON UPDATE CASCADE,
     *     item_price REAL
     * );
     * **/
    public static final String TABLE_ITEM = "item";
    public static final String COL_ITEM_ID = BaseColumns._ID;
    public static final String COl_ITEM_NAME = "item_name";
    public static final String COL_ITEM_PRICE = "item_price";
    public static final String COL_ITEM_CATEGORY_REF = "category_ref";
     /**
     *
     * DROP TABLE IF EXISTS payment_type;
     * CREATE TABLE IF NOT EXISTS payment_type (
     *     _id INTEGER PRIMARY KEY,
     *     payment_type TEXT UNIQUE,
     *     surcharge REAL
     * );
     *
     **/
     public static final String TABLE_PAYTYPE = "payment_type";
     public static final String COL_PAYTYPE_ID = BaseColumns._ID;
     public static final String COl_PAYTYPE_TYPE = "type_of_payment";
     public static final String COL_PAYTYPE_SURCHARGE = "surcharge";

     /**
     *
     * DROP TABLE IF EXISTS order_detail;
     * CREATE TABLE IF NOT EXISTS order_detail (
     *     customer_order_ref INTEGER REFERENCES customer_order(_id) ON DELETE CASCADE ON UPDATE CASCADE,
     *     item_ref REFERENCES item(_id) ON DELETE CASCADE ON UPDATE CASCADE,
     *     quantity
     * );
     **/

    public static final String TABLE_ORDDTL = "order_detail";
    public static final String COL_ORDDTL_CUSTORD_REF = "customer_order_ref";
    public static final String COL_ORDDTL_ITEM_REF = "item_ref";
    public static final String COL_ORDDTL_QUANTITY = "quantity";


    /**
     * -- NOTE cannot call a table order as it is a keyword (not rea true but have to enclose the name e.g.g [order]).
     * DROP TABLE IF EXISTS customer_order;
     * CREATE TABLE IF NOT EXISTS customer_order (
     *     _id INTEGER PRIMARY KEY,
     *     customer_name TEXT,
     *     date TEXT DEFAULT CURRENT_TIMESTAMP,
     *     payment_type_ref INTEGER REFERENCES payment_type(_id) ON DELETE CASCADE ON UPDATE CASCADE
     * );
     **/
    public static final String TABLE_CUSTORD = "customer_order";
    public static final String COL_CUSTORD_ID = BaseColumns._ID;
    public static final String COL_CUSTORD_NAME = "customer_name";
    public static final String COl_CUSTORD_DATE = "date";
    public static final String COL_CUSTORD_PAYMENTTYPE_REF = "payment_type_ref";
}
