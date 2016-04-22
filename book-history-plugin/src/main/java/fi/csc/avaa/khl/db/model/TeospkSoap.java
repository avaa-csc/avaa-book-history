package fi.csc.avaa.khl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fi.csc.avaa.khl.db.service.http.TeospkServiceSoap}.
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.http.TeospkServiceSoap
 * @generated
 */
public class TeospkSoap implements Serializable {
    private int _teospkid;
    private String _teospknimi;

    public TeospkSoap() {
    }

    public static TeospkSoap toSoapModel(Teospk model) {
        TeospkSoap soapModel = new TeospkSoap();

        soapModel.setTeospkid(model.getTeospkid());
        soapModel.setTeospknimi(model.getTeospknimi());

        return soapModel;
    }

    public static TeospkSoap[] toSoapModels(Teospk[] models) {
        TeospkSoap[] soapModels = new TeospkSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static TeospkSoap[][] toSoapModels(Teospk[][] models) {
        TeospkSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new TeospkSoap[models.length][models[0].length];
        } else {
            soapModels = new TeospkSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static TeospkSoap[] toSoapModels(List<Teospk> models) {
        List<TeospkSoap> soapModels = new ArrayList<TeospkSoap>(models.size());

        for (Teospk model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new TeospkSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _teospkid;
    }

    public void setPrimaryKey(int pk) {
        setTeospkid(pk);
    }

    public int getTeospkid() {
        return _teospkid;
    }

    public void setTeospkid(int teospkid) {
        _teospkid = teospkid;
    }

    public String getTeospknimi() {
        return _teospknimi;
    }

    public void setTeospknimi(String teospknimi) {
        _teospknimi = teospknimi;
    }
}
