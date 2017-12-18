package com.radyalabs.mobileagent.data.cache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.radyalabs.mobileagent.model.local.Cache;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by RadyaLabs PC on 15/12/2017.
 */
@Dao
public interface CacheDao {

    @Query("select * from Cache where id = :id")
    Cache loadCacheById(int id);

    @Insert(onConflict = IGNORE)
    void insertCache(Cache cache);

    @Update(onConflict = REPLACE)
    void updateCache(Cache cache);

}
