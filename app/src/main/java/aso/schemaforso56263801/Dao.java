package aso.schemaforso56263801;

import android.widget.LinearLayout;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertCategory(Category... categories);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertCategory(Category category);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertPaymentType(PaymentType... paymentTypes);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertPaymentType(PaymentType paymentType);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertItem(Item... items);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertItem(Item item);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertCustomerOrder(CustomerOrder... customerOrders);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertCustomerOrder(CustomerOrder customerOrder);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertOrderDetail(OrderDetail... orderDetails);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertOrderDetail(OrderDetail orderDetail);

    //---------- Only one set of Updates ----------
    @Update(onConflict = OnConflictStrategy.IGNORE)
    int updateCategory(Category... categories);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    int updateCategory(Category category);

    //---------- Only one set of Deletes ----------
    @Delete
    int deleteCategory(Category... categories);

    @Delete
    int deleteCategory(Category category);

    @Query("SELECT * FROM category")
    List<Category> getCategoryList();

    @Query("SELECT * FROM payment_type")
    List<PaymentType> getPaymentTypeList();

    @Query("SELECT * FROM item")
    List<Item> getItemList();

    @Query("SELECT * FROM customer_order")
    List<CustomerOrder> getCustomerOrderList();

    @Query("SELECT * FROM order_detail")
    List<OrderDetail> getOrderDetailList();

    @Query("SELECT * FROM Example1")
    List<DatabaseViews.Example1> getExample1List();
}
