package aso.schemaforso56263801;

import androidx.room.Dao;
import androidx.room.DatabaseView;

@Dao
public interface DatabaseViews {

    String DERIVEDCOLUMN_ITEMLISTCSV = "itemlist";
    String DERIVEDCOLUMN_NETPRICE = "net_price";
    String DERIVEDCOLUMN_CALCULATEDSURCHARGE = "calculated_surcharge";
    String DERIVED_COLUMN_TOTALITEMPRICE = "total_item_price";

    /**
     * SELECT
     *     customer_name,
     *     date,
     *     group_concat(item_name) ||'('||quantity||')' AS items,
     *     sum(item_price) AS total_price,
     *     payment_type,
     *     round(sum(item_price) * surcharge,2) AS surcharge,
     *     round((sum(item_price) * surcharge) + sum(item_price),2) AS total_price
     *     FROM customer_order
     *         JOIN order_detail ON customer_order._id = order_detail.customer_order_ref
     *         JOIN item ON order_detail.item_ref = item._id
     *         JOIN payment_type ON customer_order.payment_type_ref = payment_type._id
     *     GROUP BY customer_order._id -- Treats all data for an order as a single row allowing the use of aggregate functions on the groups e.g. sum, group_concat
     * ;
     */

    @DatabaseView(
            "SELECT " +
                    "customer_name, " +
                    "date, " +
                    "group_concat(item_name,' ~ ') || '('||quantity||')' AS " + DERIVEDCOLUMN_ITEMLISTCSV +  ", " +
                    "sum(item_price) * quantity AS " + DERIVEDCOLUMN_NETPRICE + ", " +
                    "type_of_payment," +
                    "round((sum(item_price) * quantity )* surcharge,2) AS " + DERIVEDCOLUMN_CALCULATEDSURCHARGE + ", " +
                    "round(((sum(item_price) * quantity) * surcharge) + (sum(item_price) * quantity),2) AS " + DERIVED_COLUMN_TOTALITEMPRICE +
                    " FROM customer_order " +
                    " JOIN order_detail ON customer_order._id = order_detail.customer_order_ref " +
                    " JOIN item ON order_detail.item_ref = item._id " +
                    " JOIN payment_type ON customer_order.payment_type_ref = payment_type._id " +
                    " GROUP BY customer_order._id"
    )
    class Example1 {
        private String customer_name;
        private String date;
        private String itemlist;
        private double net_price;
        private String type_of_payment;
        private double calculated_surcharge;
        private double total_item_price;

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getItemlist() {
            return itemlist;
        }

        public void setItemlist(String items) {
            this.itemlist = items;
        }

        public double getNet_price() {
            return net_price;
        }

        public void setNet_price(double net_price) {
            this.net_price = net_price;
        }

        public String getType_of_payment() {
            return type_of_payment;
        }

        public void setType_of_payment(String type_of_payment) {
            this.type_of_payment = type_of_payment;
        }

        public double getCalculated_surcharge() {
            return calculated_surcharge;
        }

        public void setCalculated_surcharge(double calculated_surcharge) {
            this.calculated_surcharge = calculated_surcharge;
        }

        public double getTotal_item_price() {
            return total_item_price;
        }

        public void setTotal_item_price(double total_item_price) {
            this.total_item_price = total_item_price;
        }
    }
}
