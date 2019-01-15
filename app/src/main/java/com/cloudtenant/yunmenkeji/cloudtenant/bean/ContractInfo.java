package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import android.util.Log;

import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.AESOperator;

public class ContractInfo extends BaseBean{


    /**
     * userinfo : ZX+mygKGL5s9ChuiWtZFZeQKWMjOIjC5em390viOT5NH2SpBpGHQ/iJswgNH8pSYhyRAq8hJZ0SAF3bqhmX4q00m6+4XnThC81OJ/InkAUTGQxpwGza2f+ZPyvb7Ls4f1nJbEp4yF/yU4cLgr1d10YmZFBVywyNTq/Tw5aoXvEIlzyQjzITUzZvUGaUyE6O05fc/Wbo8tqj5D7IZZuqo0acmhxZA90mfUTW1GDvShcebagi5bMssbiB3HB/4gBGN3WZ+TndGE6xEa7o+pi1T+igobrBdXZPK2Rp2ZmeETS4aWUhhq8BOCk8VMJApqEnFsltSjifHJMs52jZBvBfA1ZqKt2e35wbH7eIEYHFO1stmdoJa/auc8rkbbEwPm7QiCsA2SXoqg4kqUOCRlvsL7Uce6YFejrlRR7PI1G0aiJWCB/XUfkw5TNZqqOk5Xu+JUlohPX9UgAcJ8pAmhUfj2MI/+TFdf6u7n54wnj+UlTvAbn95Bx43eZ1qBFAdZbCLMiMGwaW+0YZtcM6sxjHpfOOdZ88HqgTgutgwpbIUaJR+4CGwCGcjg7puK0mOOFmUQfOjK+xiQmsQI3t7K7YR91PZcXOMLHy0f8sFQ6oNpgPINFV3nwuUlTpMKtG343BFqyy6+pKlVLG4eL3CCLLKB4RTV2B4qA3LVZu4QiPTituGyE6PZ7ZAOW45X48ZpJhcEDIbGUnKhm9Juwfbyiqp8w8bBa9O+okkfjMXT4bi5yfRkLkAhBapGVDVF0bU/1m1mkIXUamLh/ktp8fusiypP/zdrNhm1t6z7urB1sQL1hU6ugXi/x2Cyta+X45X6xbZ9xixtOTxqSXE70CXaZs7zX3m4+G1Y090wGN/LGMoQCq2vgg/AUqU6tpontUCjl8JjLnzZ2ZColBE9VgLLMUmD+voX4QfJpEh0auvLKnhR4t7cbKP+FH+fAw/mxEMSeK+BLOKuerQR5Yp16VQu6Tcqg==
     */

    private String userinfo;

    public String getUserinfo() throws Exception {
        //return userinfo;

        return AESOperator.getInstance().decrypt(userinfo);
    }

    public void setUserinfo(String userinfoX) {
        this.userinfo = userinfo;
    }


}
