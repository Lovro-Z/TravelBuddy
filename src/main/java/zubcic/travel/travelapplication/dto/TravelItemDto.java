package zubcic.travel.travelapplication.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TravelItemDto {

    private String title;
    private Integer duration;
    private LocalDate date;
    private BigDecimal price;
    private String description;

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

    @Override
    public String toString() {
        return "TravelItemDto{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", date=" + date +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
