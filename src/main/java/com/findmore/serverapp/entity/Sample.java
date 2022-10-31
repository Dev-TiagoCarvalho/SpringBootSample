package com.findmore.serverapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="samples")
public class Sample {

    public enum Type { INT32, INT64, INT128 }

    @JsonProperty("id")
    @Column(name="sample_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id private long id;
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    @JsonProperty("name")
    @Column(name="sample_name", length=50, nullable=false, unique=true)
    private String sampleName;
    public String getName() { return sampleName; }
    public void setName(String sampleName) { this.sampleName = sampleName; }

    @JsonProperty("date")
    @Column(name="sample_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp = new Date(System.currentTimeMillis());
    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }

    @JsonProperty("type")
    @Column(name="sample_enum", length=6)
    @Enumerated(EnumType.STRING)
    private Type enumType;
    public Type getType() { return enumType; }
    public void setType(Type enumType) { this.enumType = enumType; }

    //This field will not be persisted on the database because of the @Transient annotation
    @Transient public final int bits = 64;

    public Sample partialUpdate(Sample sample) {
        if(sample.getName() != null) this.sampleName = sample.getName();
        if(sample.getTimestamp() != null) this.timestamp = sample.getTimestamp();
        if(sample.getType() != null) this.enumType = sample.getType();
        return this;
    }
}
