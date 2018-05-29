package app.domain;

import com.datastax.driver.core.DataType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

/*
id | deveui | dataType | rawData | jsonData
TODO: add dates and findByDates
*/

@Table("measurements")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Measurement implements Serializable {

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    private String devEui;
    private String dataType;
    private String data;
    private String timeStamp;

    public Measurement() {
        this.id = UUID.randomUUID();
    }

    public Measurement(String devEui, String dataType, String data, String timeStamp) {
        this.id = UUID.randomUUID();
        this.devEui = devEui;
        this.dataType = dataType;
        this.data = data;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", devEui='" + devEui + '\'' +
                ", dataType='" + dataType + '\'' +
                ", data='" + data + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDevEui() {
        return devEui;
    }

    public void setDevEui(String devEui) {
        this.devEui = devEui;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
