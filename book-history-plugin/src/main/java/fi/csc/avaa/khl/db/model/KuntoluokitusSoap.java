package fi.csc.avaa.khl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fi.csc.avaa.khl.db.service.http.KuntoluokitusServiceSoap}.
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.http.KuntoluokitusServiceSoap
 * @generated
 */
public class KuntoluokitusSoap implements Serializable {
    private int _kuntoid;
    private String _kunto;

    public KuntoluokitusSoap() {
    }

    public static KuntoluokitusSoap toSoapModel(Kuntoluokitus model) {
        KuntoluokitusSoap soapModel = new KuntoluokitusSoap();

        soapModel.setKuntoid(model.getKuntoid());
        soapModel.setKunto(model.getKunto());

        return soapModel;
    }

    public static KuntoluokitusSoap[] toSoapModels(Kuntoluokitus[] models) {
        KuntoluokitusSoap[] soapModels = new KuntoluokitusSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static KuntoluokitusSoap[][] toSoapModels(Kuntoluokitus[][] models) {
        KuntoluokitusSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new KuntoluokitusSoap[models.length][models[0].length];
        } else {
            soapModels = new KuntoluokitusSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static KuntoluokitusSoap[] toSoapModels(List<Kuntoluokitus> models) {
        List<KuntoluokitusSoap> soapModels = new ArrayList<KuntoluokitusSoap>(models.size());

        for (Kuntoluokitus model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new KuntoluokitusSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _kuntoid;
    }

    public void setPrimaryKey(int pk) {
        setKuntoid(pk);
    }

    public int getKuntoid() {
        return _kuntoid;
    }

    public void setKuntoid(int kuntoid) {
        _kuntoid = kuntoid;
    }

    public String getKunto() {
        return _kunto;
    }

    public void setKunto(String kunto) {
        _kunto = kunto;
    }
}
