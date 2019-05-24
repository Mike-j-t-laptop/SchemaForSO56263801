package aso.schemaforso56263801;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static aso.schemaforso56263801.DBConstants.*;

/**
 * The Category table
 */
@Entity(tableName = TABLE_CATEGORY)
public class Category {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_CATEGORY_ID)
    private long id;

    @ColumnInfo(name = COL_CATEGORY_NAME,index = true)
    private String category;

    //Default constructor as used by Room
    public Category(){
    }

    //Additional Constructor for use outside of Room
    // therefore IGNORED
    @Ignore
    public Category(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
