package com.ualr.recyclerview.data;

import android.content.Context;
import android.content.res.TypedArray;

import com.ualr.recyclerview.R;
import com.ualr.recyclerview.model.People;
import com.ualr.recyclerview.utils.Tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by irconde on 2019-09-25.
 */

// TODO 01. We are using the DataGenerator as data source. It supplies RecyclerView with item content. Specifically it generates a people collection
// Each person is represented by an instance of People class, which encloses the name, the image id, the image drawable and the email of that person

public class DataGenerator {

    /**
     * Generate dummy data people
     *
     * @param ctx android context
     * @return list of object
     */
    public static List<People> getPeopleData(Context ctx) {
        List<People> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.people_images);
        String name_arr[] = ctx.getResources().getStringArray(R.array.people_names);

        for (int i = 0; i < drw_arr.length(); i++) {
            People obj = new People();
            obj.setImage(drw_arr.getResourceId(i, -1));
            obj.setName(name_arr[i]);
            obj.setEmail(Tools.getEmailFromName(obj.getName()));
            obj.setImageDrw(ctx.getResources().getDrawable(obj.getImage()));
            items.add(obj);
        }
        Collections.shuffle(items);
        return items;
    }
}
