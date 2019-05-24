package aso.schemaforso56263801;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {
        Category.class,
        PaymentType.class,
        Item.class,
        CustomerOrder.class,
        OrderDetail.class
        },
        views = {
                DatabaseViews.Example1.class
        },
        version = DBConstants.DBVERSION
)
public abstract class StoreOrderDatabase extends RoomDatabase {
    public abstract Dao mDao();
}
