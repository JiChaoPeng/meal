package com.example.demo.xxxx.meal.bean;

import javax.persistence.*;

@Entity
public class MealBean {
    private String name;
    private String content;
    private int price;
    private String image_url;
    private String address;
    private int room_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public MealBean() {

    }

    public MealBean(String name, String content, int price, String imageUrl, String address, int roomId) {
        this.name = name;
        this.content = content;
        this.price = price;
        this.image_url = imageUrl;
        this.address = address;
        this.room_id = roomId;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
