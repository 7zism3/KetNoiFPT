package vn.vimass.entities;

import com.google.gson.Gson;

public class Item {
    // Số thứ tự dòng
    public int line;
    // Hình thức hàng hoá
    public String type;
    // Loại thuế suất
    public String vrt;
    // Mã hàng hoá
    public String code;
    // Tên mô tả hàng hoá
    public String name;
    // Đơn vị
    public String unit;
    // Đơn giá
    public double price;
    // Số lượng
    public int quantity;
    // Tỉ lệ chiết khấu
    public double perdiscount;
    // Số tiền chiết khấu
    public double amtdiscount;
    // Thành tiền
    public double amount;
    // Số tiền VAT
    public double vat;
    // Tổng tiền bao gồ VAT
    public double total;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
