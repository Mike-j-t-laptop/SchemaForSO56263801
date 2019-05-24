package aso.schemaforso56263801;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Dao mDao;
    private StoreOrderDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDB = Room.databaseBuilder(this,StoreOrderDatabase.class,DBConstants.DBNAME).allowMainThreadQueries().build();
        mDao = mDB.mDao();
        buildSomeData();

        /**
         * Examples of retrieving data
         */
        List<PaymentType> paymentTypes = mDao.getPaymentTypeList();
        for (PaymentType p: paymentTypes) {
            Log.d("PAYTYPE",p.getPayment_type());
        }

        List<Category> categories = mDao.getCategoryList();
        for (Category c: categories) {
            Log.d("CATEGORY",c.getCategory());
        }

        List<Item> items = mDao.getItemList();
        for (Item i: items) {
            Log.d("ITEM", i.getItem_name());
        }

        List<CustomerOrder> customer_orders = mDao.getCustomerOrderList();
        for (CustomerOrder co: customer_orders) {
            Log.d("ORDER",co.getName() + " ordered on " + co.getDate());
        }

        List<OrderDetail> order_details = mDao.getOrderDetailList();
        for (OrderDetail od: order_details) {
            Log.d("ORDERDETAIL",
                    "CustOrderRef=" + String.valueOf(od.getCustomer_order_reference()) +
                            "\t  ItemRef=" + String.valueOf(od.getItem_reference()) +
                            "\t  Quantity=" + String.valueOf(od.getQuantity())
            );
        }

        /**
         * The equivalent of the StackOverflow answer
         * which joins tables and generates derived values
         * see DatabaseViews.java as this is separate from the other
         * DAO's
         */
        List<DatabaseViews.Example1> examples = mDao.getExample1List();
        for (DatabaseViews.Example1 e: examples) {
            Log.d("EXAMPLE1",
                    e.getCustomer_name()+
                            "\t" + e.getDate() +
                            "\t" + e.getItemlist() +
                            "\t" + e.getNet_price() +
                            "\t" + e.getType_of_payment() +
                            "\t" + e.getCalculated_surcharge() +
                            "\t" + e.getTotal_item_price()
            );
        }
    }

    /**
     * Add some data (s per example on Stack Overflow)
     * (just once
     *      (
     *          assuming that any rows in PaymentTypes tables signifies that data has been loaded
     *       )
     *  )
     */
    private void buildSomeData() {
        List<PaymentType> ptlist = mDao.getPaymentTypeList();
        if (ptlist.size()> 0) return;
        mDao.insertPaymentType(
                new PaymentType("MasterCard",0.05),
                new PaymentType("Visa",0.05),
                new PaymentType("Cash",0.0),
                new PaymentType("American Express",0.15)
        );

        mDao.insertCategory(
                new Category("Fish"),
                new Category("Beef"),
                new Category("Chicken"),
                new Category("Lamb"),
                new Category("Seafood")
        );
        mDao.insertItem(
                new Item("Fish and Chips",11.30,1),
                new Item("Steak and Kidney Pudding",15.45,2),
                new Item("Lamb Chops, Potato and Gravy",17.40,3)
        );
        mDao.insertCustomerOrder(
                new CustomerOrder("Fred",3),
                new CustomerOrder("Mary",1),
                new CustomerOrder("Tom",2),
                new CustomerOrder("Jane",4)
        );

        mDao.insertOrderDetail(
                new OrderDetail(1,1,2),
                new OrderDetail(1,2,1),

                new OrderDetail(2,3,10),

                new OrderDetail(3,2,1),
                new OrderDetail(3,1,1),
                new OrderDetail(3,3,1),

                new OrderDetail(4,1,1)
        );
    }
}
