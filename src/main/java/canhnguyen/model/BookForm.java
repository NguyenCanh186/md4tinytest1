package canhnguyen.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

public class BookForm {
    private Long id;
    private MultipartFile avatar;
    private String name;
    private int price;
    private String author;
    private Category category;

    public BookForm() {
    }

    public BookForm(String name, int price, String author, Category category) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.category = category;
    }

    public BookForm(Long id, String name, int price, String author, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.category = category;
    }

    public BookForm(MultipartFile avatar, String name, int price, String author, Category category) {
        this.avatar = avatar;
        this.name = name;
        this.price = price;
        this.author = author;
        this.category = category;
    }

    public BookForm(Long id, MultipartFile avatar, String name, int price, String author, Category category) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.price = price;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
