package app.domain;

import com.datastax.driver.core.DataType;
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
public class Measurement implements Serializable {

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    private String devEui;
    private String dataType;
    private String rawData;
    private String jsonData;

    public Measurement() {
        this.id = UUID.randomUUID();
    }

    public Measurement(String devEui, String dataType, String rawData, String jsonData) {
        this.id = UUID.randomUUID();
        this.devEui = devEui;
        this.dataType = dataType;
        this.rawData = rawData;
        this.jsonData = jsonData;
    }

    public UUID getUuid() {
        return id;
    }

    public void setUuid(UUID uuid) {
        this.id = uuid;
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

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
