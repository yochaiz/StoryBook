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
        page = new Page(Page7Activity.class, SongPage1Activity.class);
        pages.put(R.id.page8, page);
        page = new Page(Page8Activity.class, SongPage2Activity.class);
        pages.put(R.id.songbook_page1, page);
        page = new Page(SongPage1Activity.class, SongPage3Activity.class);
        pages.put(R.id.songbook_page2, page);
        page = new Page(SongPage2Activity.class, SongPage4Activity.class);
        pages.put(R.id.songbook_page3, page);
        page = new Page(SongPage3Activity.class, WordPage1Activity.class);
        pages.put(R.id.songbook_page4, page);
        page = new Page(SongPage4Activity.class, WordPage2Activity.class);
        pages.put(R.id.wordbook_page1, page);
        page = new Page(WordPage1Activity.class, null);
        pages.put(R.id.wordbook_page2, page);
    }

    public Page getPage(int id) {//returns null if id doesn't exist
        return pages.get(id);
    }
}
