package fi.csc.avaa.khl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fi.csc.avaa.khl.db.service.http.KuntainfoServiceSoap}.
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.http.KuntainfoServiceSoap
 * @generated
 */
public class KuntainfoSoap implements Serializable {
    private int _kuntaid;
    private String _capitalkuntanimi;
    private int _kpl;
    private String _kuntanimi;
    private int _maakuntaid;
    private int _kuntano;
    private String _kuntanimi_2014;

    public KuntainfoSoap() {
    }

    public static KuntainfoSoap toSoapModel(Kuntainfo model) {
        KuntainfoSoap soapModel = new KuntainfoSoap();

        soapModel.setKuntaid(model.getKuntaid());
        soapModel.setCapitalkuntanimi(model.getCapitalkuntanimi());
        soapModel.setKpl(model.getKpl());
        soapModel.setKuntanimi(model.getKuntanimi());
        soapModel.setMaakuntaid(model.getMaakuntaid());
        soapModel.setKuntano(model.getKuntano());
        soapModel.setKuntanimi_2014(model.getKuntanimi_2014());

        return soapModel;
    }

    public static KuntainfoSoap[] toSoapModels(Kuntainfo[] models) {
        KuntainfoSoap[] soapModels = new KuntainfoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static KuntainfoSoap[][] toSoapModels(Kuntainfo[][] models) {
        KuntainfoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new KuntainfoSoap[models.length][models[0].length];
        } else {
            soapModels = new KuntainfoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static KuntainfoSoap[] toSoapModels(List<Kuntainfo> models) {
        List<KuntainfoSoap> soapModels = new ArrayList<KuntainfoSoap>(models.size());

        for (Kuntainfo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new KuntainfoSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _kuntaid;
    }

    public void setPrimaryKey(int pk) {
        setKuntaid(pk);
    }

    public int getKuntaid() {
        return _kuntaid;
    }

    public void setKuntaid(int kuntaid) {
        _kuntaid = kuntaid;
    }

    public String getCapitalkuntanimi() {
        return _capitalkuntanimi;
    }

    public void setCapitalkuntanimi(String capitalkuntanimi) {
        _capitalkuntanimi = capitalkuntanimi;
    }

    public int getKpl() {
        return _kpl;
    }

    public void setKpl(int kpl) {
        _kpl = kpl;
    }

    public String getKuntanimi() {
        return _kuntanimi;
    }

    public void setKuntanimi(String kuntanimi) {
        _kuntanimi = kuntanimi;
    }

    public int getMaakuntaid() {
        return _maakuntaid;
    }

    public void setMaakuntaid(int maakuntaid) {
        _maakuntaid = maakuntaid;
    }

    public int getKuntano() {
        return _kuntano;
    }

    public void setKuntano(int kuntano) {
        _kuntano = kuntano;
    }

    public String getKuntanimi_2014() {
        return _kuntanimi_2014;
    }

    public void setKuntanimi_2014(String kuntanimi_2014) {
        _kuntanimi_2014 = kuntanimi_2014;
    }
}
