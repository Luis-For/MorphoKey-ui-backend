package morpho.key.demo.dao;

import java.time.LocalDate;

import org.hibernate.SessionFactory;
import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.websocket.Decoder.Text;

@Entity
@Table(name = "domain")
public class Taxon {
    protected String name;
    protected String nameScientific;
    protected Text description;
    private final LocalDate creationDate;
    protected LocalDate updateDate;
    private boolean status;
    protected Text photoUrl;

    public Taxon(String name, String nameScientific, Text description, LocalDate creationDate) {
        this.name = name;
        this.nameScientific = nameScientific;
        this.description = description;
        this.creationDate = creationDate;
    }

    

    @Override
    public String toString() {
        return "Taxon [name=" + name + ", nameScientific=" + nameScientific + ", description=" + description
                + ", creationDate=" + creationDate + ", updateDate=" + updateDate + ", status=" + status + ", photoUrl="
                + photoUrl + "]";
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getNameScientific() {
        return nameScientific;
    }


    public void setNameScientific(String nameScientific) {
        this.nameScientific = nameScientific;
    }


    public Text getDescription() {
        return description;
    }


    public void setDescription(Text description) {
        this.description = description;
    }


    public LocalDate getCreationDate() {
        return creationDate;
    }


    public LocalDate getUpdateDate() {
        return updateDate;
    }


    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }


    public boolean isStatus() {
        return status;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }


    public Text getPhotoUrl() {
        return photoUrl;
    }


    public void setPhotoUrl(Text photoUrl) {
        this.photoUrl = photoUrl;
    }

    
}
