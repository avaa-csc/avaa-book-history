package fi.csc.avaa.khl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fi.csc.avaa.khl.db.service.http.MaakuntainfoServiceSoap}.
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.http.MaakuntainfoServiceSoap
 * @generated
 */
public class MaakuntainfoSoap implements Serializable {
    private int _maakuntaid;
    private String _maakunta;
    private int _kpl;

    public MaakuntainfoSoap() {
    }

    public static MaakuntainfoSoap toSoapModel(Maakuntainfo model) {
        MaakuntainfoSoap soapModel = new MaakuntainfoSoap();

        soapModel.setMaakuntaid(model.getMaakuntaid());
        soapModel.setMaakunta(model.getMaakunta());
        soapModel.setKpl(model.getKpl());

        return soapModel;
    }

    public static MaakuntainfoSoap[] toSoapModels(Maakuntainfo[] models) {
        MaakuntainfoSoap[] soapModels = new MaakuntainfoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MaakuntainfoSoap[][] toSoapModels(Maakuntainfo[][] models) {
        MaakuntainfoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MaakuntainfoSoap[models.length][models[0].length];
        } else {
            soapModels = new MaakuntainfoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MaakuntainfoSoap[] toSoapModels(List<Maakuntainfo> models) {
        List<MaakuntainfoSoap> soapModels = new ArrayList<MaakuntainfoSoap>(models.size());

        for (Maakuntainfo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MaakuntainfoSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _maakuntaid;
    }

    public void setPrimaryKey(int pk) {
        setMaakuntaid(pk);
    }

    public int getMaakuntaid() {
        return _maakuntaid;
    }

    public void setMaakuntaid(int maakuntaid) {
        _maakuntaid = maakuntaid;
    }

    public String getMaakunta() {
        return _maakunta;
    }

    public void setMaakunta(String maakunta) {
        _maakunta = maakunta;
    }

    public int getKpl() {
        return _kpl;
    }

    public void setKpl(int kpl) {
        _kpl = kpl;
    }
}
