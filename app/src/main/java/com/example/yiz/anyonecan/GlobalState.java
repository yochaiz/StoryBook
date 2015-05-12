package com.example.yiz.anyonecan;

import android.app.Application;

import java.util.HashMap;

public class GlobalState extends Application {
    private HashMap<Integer, Page> pages;

    public GlobalState() {
        pages = new HashMap<>();
//        Page page = new Page(null, Page1Activity.class);
//        pages.put(R.id.homepage, page);
        Page page = new Page(null, Page2Activity.class);
        pages.put(R.id.page1, page);
        page = new Page(Page1Activity.class, Page3Activity.class);
        pages.put(R.id.page2, page);
        page = new Page(Page2Activity.class, Page4Activity.class);
        pages.put(R.id.page3, page);
        page = new Page(Page3Activity.class, Page5Activity.class);
        pages.put(R.id.page4, page);
        page = new Page(Page4Activity.class, Page6Activity.class);
        pages.put(R.id.page5, page);
        page = new Page(Page5Activity.class, Page7Activity.class);
        pages.put(R.id.page6, page);
        page = new Page(Page6Activity.class, Page8Activity.class);
        pages.put(R.id.page7, page);
        page = new Page(Page7Activity.class, Page9Activity.class);
        pages.put(R.id.page8, page);
        page = new Page(Page8Activity.class, Page10Activity.class);
        pages.put(R.id.page9, page);
        page = new Page(Page9Activity.class, Page11Activity.class);
        pages.put(R.id.page10, page);
        page = new Page(Page10Activity.class, Page12Activity.class);
        pages.put(R.id.page11, page);
        page = new Page(Page11Activity.class, Page13Activity.class);
        pages.put(R.id.page12, page);
        page = new Page(Page12Activity.class
                , Page14Activity.class);
        pages.put(R.id.page13, page);
        page = new Page(Page13Activity.class, null);
        pages.put(R.id.page14, page);
//        page = new Page(Page14Activity.class, null);
//        pages.put(R.layout.activity_listen_game, page);
    }

    public Page getPage(int id) {//returns null if id doesn't exist
        return pages.get(id);
    }
}
