package com.jdelorenzo.congressapp.legislators;

import com.jdelorenzo.congressapp.R;

/**
 * Enum describing the legislator pager tabs.
 */

public enum LegislatorFilter {
    ALL(R.string.tab_all, R.layout.legislator_list),
    MY(R.string.tab_local, R.layout.legislator_list);

    private int titleId;
    private int layoutId;
    LegislatorFilter(int titleId, int layoutId) {
        this.titleId = titleId;
        this.layoutId = layoutId;
    }
    public int getTitleId() { return titleId;}
    public int getLayoutId() { return layoutId; }
}
