package fi.csc.avaa.khl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fi.csc.avaa.khl.db.service.http.JulkaisulajiinfoServiceSoap}.
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.http.JulkaisulajiinfoServiceSoap
 * @generated
 */
public class JulkaisulajiinfoSoap implements Serializable {
    private int _julklajiid;
    private String _julklaji;

    public JulkaisulajiinfoSoap() {
    }

    public static JulkaisulajiinfoSoap toSoapModel(Julkaisulajiinfo model) {
        JulkaisulajiinfoSoap soapModel = new JulkaisulajiinfoSoap();

        soapModel.setJulklajiid(model.getJulklajiid());
        soapModel.setJulklaji(model.getJulklaji());

        return soapModel;
    }

    public static JulkaisulajiinfoSoap[] toSoapModels(Julkaisulajiinfo[] models) {
        JulkaisulajiinfoSoap[] soapModels = new JulkaisulajiinfoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static JulkaisulajiinfoSoap[][] toSoapModels(
        Julkaisulajiinfo[][] models) {
        JulkaisulajiinfoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new JulkaisulajiinfoSoap[models.length][models[0].length];
        } else {
            soapModels = new JulkaisulajiinfoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static JulkaisulajiinfoSoap[] toSoapModels(
        List<Julkaisulajiinfo> models) {
        List<JulkaisulajiinfoSoap> soapModels = new ArrayList<JulkaisulajiinfoSoap>(models.size());

        for (Julkaisulajiinfo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new JulkaisulajiinfoSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _julklajiid;
    }

    public void setPrimaryKey(int pk) {
        setJulklajiid(pk);
    }

    public int getJulklajiid() {
        return _julklajiid;
    }

    public void setJulklajiid(int julklajiid) {
        _julklajiid = julklajiid;
    }

    public String getJulklaji() {
        return _julklaji;
    }

    public void setJulklaji(String julklaji) {
        _julklaji = julklaji;
    }
}
