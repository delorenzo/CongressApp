package com.jdelorenzo.congressapp.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.jdelorenzo.congressapp.data.LegislatorDao;
import com.jdelorenzo.congressapp.data.model.Bill;
import com.jdelorenzo.congressapp.data.model.Committee;
import com.jdelorenzo.congressapp.data.model.District;
import com.jdelorenzo.congressapp.data.model.Legislator;

/** The Room database that contains the Legislator table */
@Database(
    entities = {Legislator.class, Bill.class, Committee.class, District.class},
    version = 1)
public abstract class CongressDatabase extends RoomDatabase {
  private static final String LEGISLATOR_DATABASE_NAME = "Congress.db";
  private static volatile CongressDatabase INSTANCE;

  public static CongressDatabase getInstance(Context context) {
    if (INSTANCE == null) {
      synchronized (CongressDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE =
              Room.databaseBuilder(
                      context.getApplicationContext(),
                      CongressDatabase.class,
                      LEGISLATOR_DATABASE_NAME)
                  .build();
        }
      }
    }
    return INSTANCE;
  }

  public abstract LegislatorDao legislatorDao();
}
