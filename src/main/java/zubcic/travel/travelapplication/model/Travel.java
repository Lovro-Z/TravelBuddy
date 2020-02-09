package zubcic.travel.travelapplication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "travel")
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private Integer duration;

    @Column
    private LocalDate date;

    @Column
    private BigDecimal price;

    @Column
    private String description;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<User> users;

    public Travel(){}

    public Travel(Long id, String title, Integer duration, LocalDate date, BigDecimal price, String description) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.date = date;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}