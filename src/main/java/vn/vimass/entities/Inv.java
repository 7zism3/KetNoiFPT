package vn.vimass.entities;

import com.google.gson.Gson;

import java.util.Date;
import java.util.List;

public class Inv {
    public String lang;

    public User user;

    // Key hoá đơn
    public String sid;
    // Ngày lập hoá đơn
    public String idt;
    // Loại hoá đơn
    public String type;
    // Mẫu hoá đơn
    public String form;
    public String serial;
    public String seq;
    public String bcode;
    public String bname;
    public String buyer;
    public String btax;
    public String baddr;
    public String btel;
    public String bmail;
    public String paym;
    public String curr;
    public int exrt;
    public String bacc;
    public String bbank;
    public String note;
    public double sumv;
    public double sum;
    public double vatv;
    public double vat;
    public String word;
    public String totalv;
    public String total;
    public double tradeamount;
    public double discount;
    public int aun;
    public int sign;
    public int type_ref;
    public String listnum;
    public Date listdt; // Để qua String -  có định dạng
    public int sendtype;

    public List<Item> items;

    public String stax;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
