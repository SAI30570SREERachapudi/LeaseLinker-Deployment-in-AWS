package com.example.demo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBDocument
@DynamoDBTable(tableName ="menus")
public class Menus {
    private String mid;
    private String menu;
    private String icon;

    @DynamoDBHashKey(attributeName = "mid")
    public String getMid() { return mid; }
    public void setMid(String mid) { this.mid = mid; }

    @DynamoDBAttribute(attributeName ="menu")
    public String getMenu() { return menu; }
    public void setMenu(String menu) { this.menu = menu; }

    @DynamoDBAttribute(attributeName ="icon")
    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    @Override
    public String toString() {
        return "Menus [mid=" + mid + ", menu=" + menu + ", icon=" + icon + "]";
    }
}
