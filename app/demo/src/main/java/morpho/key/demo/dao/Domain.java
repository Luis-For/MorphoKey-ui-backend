package morpho.key.demo.dao;

import java.time.LocalDate;

import jakarta.websocket.Decoder.Text;

public class Domain extends Taxon{

    public Domain(String name, String nameScientific, Text description, LocalDate creationDate) {
        super(name, nameScientific, description, creationDate);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
       
}
