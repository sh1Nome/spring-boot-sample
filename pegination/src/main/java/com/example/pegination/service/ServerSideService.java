package com.example.pegination.service;

import java.util.List;

import com.example.pegination.entity.Hoge;
import com.example.pegination.form.ServerSideForm;

public interface ServerSideService {

    /**
     * テーブルHogeのレコードをすべて取得する
     * @return テーブルHogeのレコードすべてが入ったList
     */
    public List<Hoge> findAllList();

    /**
     * 画面に表示するデータに絞り込む
     * @param form フォームクラス
     * @param allRecordList すべてのレコード
     * @return 絞り込まれたList
     */
    public List<Hoge> narrowDownDisplayList(ServerSideForm form, List<Hoge> allRecordList);

    /**
     * ページめくりをする
     * @param form フォームクラス
     * @param next 次のページか前のページか
     */
    public void pageTurn(ServerSideForm form, boolean next);

}
