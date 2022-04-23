package canhnguyen.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String avatar;
    private String name;
    private int price;
    private String author;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Book(String avatar, String name, int price, String author, Category category) {
        this.avatar = avatar;
        this.name = name;
        this.price = price;
        this.author = author;
        this.category = category;
    }

    public Book() {
    }

    public Book(Long id, String avatar, String name, int price, String author, Category category) {
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
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
