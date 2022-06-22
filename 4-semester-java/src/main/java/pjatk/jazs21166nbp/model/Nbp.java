package pjatk.jazs21166nbp.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity(name = "response")
public class Nbp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id of the record", required = true, value = "id", example = "1")
    private Long id;
    @Enumerated(EnumType.STRING)
    @ApiModelProperty(notes = "Name of the metal", required = true, value = "metal", example = "Gold")
    private MetalCategory metal;
    @ApiModelProperty(notes = "Price of the metal", required = true, value = "averagePrice", example = "7034,55")
    private float average_price;
    @ApiModelProperty(notes = "Time frame, date From", required = true, value = "dateFrom", example = "2021-05-25")
    private Date date_from;
    @ApiModelProperty(notes = "Time frame, date to", required = true, value = "dateTo", example = "2021-05-26")
    private Date date_to;
    @ApiModelProperty(notes = "Day and time of the request", required = true, value = "requestTime", example = "17:34:55")
    private Timestamp request_time;

    public Nbp() {
    }

    public Nbp(Long id, MetalCategory metal, float average_price, Date date_from, Date date_to, Timestamp request_time) {
        this.id = id;
        this.metal = metal;
        this.average_price = average_price;
        this.date_from = date_from;
        this.date_to = date_to;
        this.request_time = request_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MetalCategory getMetal() {
        return metal;
    }

    public void setMetal(MetalCategory metal) {
        this.metal = metal;
    }

    public float getAverage_price() {
        return average_price;
    }

    public void setAverage_price(float averagePrice) {
        this.average_price = averagePrice;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date dateFrom) {
        this.date_from = dateFrom;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date dateTo) {
        this.date_to = dateTo;
    }

    public Timestamp getRequest_time() {
        return request_time;
    }

    public void setRequest_time(Timestamp requestTime) {
        this.request_time = requestTime;
    }
}
