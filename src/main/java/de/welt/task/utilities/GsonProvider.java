package de.welt.task.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonProvider {

    static Gson gsonInstance() {
        return new GsonBuilder().setPrettyPrinting().create();
    }
}
